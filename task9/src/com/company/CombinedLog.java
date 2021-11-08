package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CombinedLog implements AutoCloseable {
    private int numberOfFiles;
    private BufferedReader[] readers;
    private LogEntry[] currentLogsEntries;

    public CombinedLog(String[] fileNames) {
        numberOfFiles = fileNames.length;
        readers = createReaders(fileNames);
        initLogEntries(readers);
    }

    public void close() {
        for (BufferedReader reader : readers) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private BufferedReader[] createReaders(String[] fileNames) {
        BufferedReader[] readers = new BufferedReader[numberOfFiles];

        for (int i = 0; i < numberOfFiles; i++) {
            String fileName = fileNames[i];
            try {
                readers[i] = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                throw new IllegalArgumentException("Log file \"" + fileName + "\" not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return readers;
    }

    private void initLogEntries(BufferedReader[] readers) {
        currentLogsEntries = new LogEntry[numberOfFiles];
        for (int i = 0; i < numberOfFiles; i++) {
            String line = null;
            try {
                line = readers[i].readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentLogsEntries[i] = (line != null ? new LogEntry(line) : null);
        }
    }

    public String readLine() {
        String result = null;
        int indexMinEntry = getIndexMinEntry();
        if (indexMinEntry != -1) {
            result = currentLogsEntries[indexMinEntry].toString();
            updateLogEntry(indexMinEntry);
        }
        return result;
    }

    private void updateLogEntry(int index) {
        String line = null;
        try {
            line = readers[index].readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        currentLogsEntries[index] = (line != null ? new LogEntry(line) : null);
    }

    private int getIndexMinEntry() {
        int minIndex = -1;
        long minTime = Long.MAX_VALUE;

        for (int i = 0; i < numberOfFiles; i++) {
            if (currentLogsEntries[i] != null) {
                long currentLogEntryTime = currentLogsEntries[i].time;
                if (currentLogEntryTime < minTime) {
                    minTime = currentLogEntryTime;
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }

    private class LogEntry {
        private final long time;
        private final String message;

        private LogEntry(String line) {
            if (line == null) {
                throw new IllegalArgumentException("Empty line");
            }
            String[] lineComponents = line.trim().split(" ", 2);
            time = Long.parseLong(lineComponents[0]);
            message = lineComponents[1];
        }

        @Override
        public String toString() {
            return time + " " + message;
        }
    }
}