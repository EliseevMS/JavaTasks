package com.company;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter implements BlackListFilter{
    public void filterComments(List<String> comments, Set<String> blackList) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+"); //паттерн для выделения слов
        for (int i = 0; i < comments.size(); i++) {
            String comment = comments.get(i);
            Matcher matcher = pattern.matcher(comment);
            while (matcher.find()) {  // идем по всем найденным словам
                String word = matcher.group().toLowerCase(Locale.ROOT);
                if (blackList.contains(word)) { // если слово в черном списке удаляем комментарий
                    comments.remove(i);
                    i--;
                    break;
                }
            }
        }
    }
}