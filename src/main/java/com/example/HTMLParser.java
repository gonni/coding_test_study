package com.example;

import java.util.regex.*;

public class HTMLParser {
    public static void main(String[] args) {
        String html = "<a href=\"http://abc.com\">abc</a>";
        parseHTML(html);
    }

    public static void parseHTML(String html) {
        // 정규표현식
        String tagRegex = "<(\\w+)([^>]*)>(.*?)</\\1>";
        Pattern pattern = Pattern.compile(tagRegex);
        Matcher matcher = pattern.matcher(html);

        if (matcher.find()) {
            // 태그 이름
            String tagName = matcher.group(1);

            // 속성 추출
            String attributes = matcher.group(2).trim();
            String tagValue = matcher.group(3).trim();

            System.out.println("Tag Name: " + tagName);

            // 속성 분석
            if (!attributes.isEmpty()) {
                String attrRegex = "(\\w+)=\"(.*?)\"";
                Pattern attrPattern = Pattern.compile(attrRegex);
                Matcher attrMatcher = attrPattern.matcher(attributes);

                while (attrMatcher.find()) {
                    System.out.println("Attribute: " + attrMatcher.group(1));
                    System.out.println("Attribute Value: " + attrMatcher.group(2));
                }
            }

            // 태그 값
            System.out.println("Tag Value: " + tagValue);
        } else {
            System.out.println("No valid HTML tag found.");
        }
    }
}