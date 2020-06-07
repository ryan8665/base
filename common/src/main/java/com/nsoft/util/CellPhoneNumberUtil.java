package com.nsoft.util;


import com.nsoft.ApplicationConfig;
import com.nsoft.enums.CellPhoneOperator;

public class CellPhoneNumberUtil {

    public static CellPhoneOperator findPhoneOperator(String phoneNumber, ApplicationConfig applicationConfig) {
//        if (phoneNumber.startsWith(applicationConfig.getIrancellFirstStartNumber()) || phoneNumber.startsWith(applicationConfig.getIrancellSecondStartNumber())) {
//            return CellPhoneOperator.IRANCELL;
//        } else if (phoneNumber.startsWith(applicationConfig.getMCIStartNumber())) {
//            return CellPhoneOperator.MCI;
//        } else if (phoneNumber.startsWith(applicationConfig.getRightelStartNumber())) {
//            return CellPhoneOperator.RIGHTEL;
//        }
        return null;
    }


    public static boolean isValidPhoneNumber(String cellphoneNumber, ApplicationConfig applicationConfig) {
//        return cellphoneNumber.startsWith(applicationConfig.getIrancellFirstStartNumber())
//                || cellphoneNumber.startsWith(applicationConfig.getRightelStartNumber())
//                || cellphoneNumber.startsWith(applicationConfig.getMCIStartNumber())
//                || cellphoneNumber.startsWith(applicationConfig.getIrancellSecondStartNumber());
        return false;
    }
}