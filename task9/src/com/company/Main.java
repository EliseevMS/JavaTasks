package com.company;

import com.company.CombinedLog;

public class Main {
    public static void main(String[] args) {
        try(CombinedLog log = new CombinedLog(args)) {
            String line = null;
            while ((line = log.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}