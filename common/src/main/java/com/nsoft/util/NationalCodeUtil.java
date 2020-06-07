package com.nsoft.util;

public class NationalCodeUtil {
    public static boolean checkNationalCodeFormat(String nationalCode){
        if (Empty.isNotEmpty(nationalCode) && nationalCode.length() == 10) {
            if (nationalCode.equals("1111111111") ||
                    nationalCode.equals("0000000000") ||
                    nationalCode.equals("2222222222") ||
                    nationalCode.equals("3333333333") ||
                    nationalCode.equals("4444444444") ||
                    nationalCode.equals("5555555555") ||
                    nationalCode.equals("6666666666") ||
                    nationalCode.equals("7777777777") ||
                    nationalCode.equals("8888888888") ||
                    nationalCode.equals("9999999999")) {
                return false;
            }


            int controlKey = nationalCode.charAt(9) - '0';
            int checkSum = (nationalCode.charAt(0) - '0') * 10 +
                    (nationalCode.charAt(1) - '0') * 9 +
                    (nationalCode.charAt(2) - '0') * 8 +
                    (nationalCode.charAt(3) - '0') * 7 +
                    (nationalCode.charAt(4) - '0') * 6 +
                    (nationalCode.charAt(5) - '0') * 5 +
                    (nationalCode.charAt(6) - '0') * 4 +
                    (nationalCode.charAt(7) - '0') * 3 +
                    (nationalCode.charAt(8) - '0') * 2;
            int checkerKey = checkSum - (checkSum / 11) * 11;
            return (checkerKey == 0 && checkerKey == controlKey) || (checkerKey == 1 && controlKey == 1) || (checkerKey > 1 && controlKey == 11 - checkerKey);
        } else {
            return false;
        }
    }

    public static String generateVirtualNationalCode(){
        long randNum;
        long min = 1000000000L;
        long max = 9999999999L;

        do {
            randNum = min + (long) (Math.random() * (max - min));
        }while (NationalCodeUtil.checkNationalCodeFormat(String.valueOf(randNum)));
        return String.valueOf(randNum);
    }
}
