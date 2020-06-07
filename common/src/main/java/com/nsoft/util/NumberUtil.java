package com.nsoft.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NumberUtil {

    private static final DecimalFormat format = new DecimalFormat("###,###");
    private static final DecimalFormat fixLengthFormat = new DecimalFormat("000000000000");

    public static final Pattern ALL_DIGIT_PATTERN = Pattern.compile("\\d+");
    public static final Pattern FULL_NUMERIC_PATTERN = Pattern.compile("[\\+|-]?\\d+(.\\d+)?");

    private static final ResourceBundle bundle = ResourceBundle.getBundle("bundle/numbers", new Locale("fa"));
    private static final String[] primeKeys = {"", "number.one", "number.two", "number.three", "number.four", "number.five", "number.six", "number.seven", "number.eight", "number.nine", "number.ten"};
    private static final String[] teenKeys = {"number.ten", "number.eleven", "number.twelve", "number.thirteen", "number.fourteen", "number.fifteen", "number.sixteen", "number.seventeen", "number.eighteen", "number.nineteen"};
    private static final String[] decimalKeys = {"number.twenty", "number.thirty", "number.forty", "number.fifty", "number.sixty", "number.seventy", "number.eighty", "number.ninety"};
    private static final String[] hundredKeys = {"", "number.1.hundred", "number.2.hundred", "number.3.hundred", "number.4.hundred", "number.5.hundred", "number.6.hundred", "number.7.hundred", "number.8.hundred", "number.9.hundred"};
    private static final String[] levelPostfixes = {"", "number.thousand", "number.million", "number.milliard", "number.trillion"};
    public static String convertToText(String number){
        return convertToText(Long.parseLong(number));
    }
    public static String convertToText(long number){
        StringBuilder result = new StringBuilder("");
        if(number == 0){
            result.append(getKeyValue("number.zero"));
        }else{
            int level = 0;
            while (number > 0){
                long part = number % 1000;
                number = number / 1000;
                StringBuilder partText = convertPartToText((int)part, level);
                if(Empty.isNotEmpty(partText) && Empty.isNotEmpty(result)){
                    partText.append(" ").append(getKeyValue("and")).append(" ");
                }
                partText.append(result);
                result = partText;
                level++;
            }
        }
        return result.toString();
    }

    private static StringBuilder convertPartToText(int part, int level) {
        StringBuilder result = new StringBuilder("");
        if(part > 0){
            int hundred = part / 100;
            int decimal = (part - (hundred * 100)) / 10;
            int prime = part % 10;

            result.append(getKeyValue(hundredKeys[hundred]));
            if(hundred > 0 && (decimal > 0 || prime > 0)){
                result.append(" ").append(getKeyValue("and")).append(" ");
            }
            if(decimal > 1){
                result.append(getKeyValue(decimalKeys[decimal - 2]));
                if(decimal > 0 && prime > 0){
                    result.append(" ").append(getKeyValue("and")).append(" ");
                }
                result.append(getKeyValue(primeKeys[prime]));
            }else if(decimal == 1){
                result.append(getKeyValue(teenKeys[prime]));
            }else{
                result.append(getKeyValue(primeKeys[prime]));
            }
            if(level > 0){
                result.append(" ");
            }
            result.append(getKeyValue(levelPostfixes[level]));
        }
        return result;
    }

    private static String getKeyValue(String key) {
        if (bundle.containsKey(key)) {
            return bundle.getString(key);
        }
        return "";
    }

    public static String formatNumberToFixLength(Number number){
        if(number != null){
            return fixLengthFormat.format(number);
        }
        return "";
    }
    public static String formatNumber(Number number){
        if(number != null){
            return format.format(number);
        }
        return "";
    }
    public static Number parseNumber(String number) throws ParseException {
        if(Empty.isNotEmpty(number)){
            return format.parse(number);
        }
        return null;
    }

    public static boolean isNumeric(String str) {
        Matcher matcher = FULL_NUMERIC_PATTERN.matcher(str);
        return matcher.matches();
    }

    public static boolean isAllDigits(String str) {
        Matcher matcher = ALL_DIGIT_PATTERN.matcher(str);
        return matcher.matches();
    }
}