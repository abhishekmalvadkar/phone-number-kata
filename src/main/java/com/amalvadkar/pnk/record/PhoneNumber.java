package com.amalvadkar.pnk.record;

import java.util.List;

public record PhoneNumber(String customerName, String phoneNumber) {

    public static PhoneNumber of(String phoneRecord) {
        String customerName = splitWithComma(phoneRecord)[0];
        String phoneNumber = splitWithComma(phoneRecord)[1];
        return new PhoneNumber(customerName, phoneNumber);
    }

    private static String[] splitWithComma(String phoneRecord) {
        return phoneRecord.split(",");
    }

    public static List<String> extractPhoneNumbers(String phoneList) {
        return phoneList.lines()
                .skip(1)
                .map(PhoneNumber::of)
                .map(PhoneNumber::phoneNumber)
                .toList();
    }
}
