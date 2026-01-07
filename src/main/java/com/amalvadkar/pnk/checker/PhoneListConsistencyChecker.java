package com.amalvadkar.pnk.checker;

import com.amalvadkar.pnk.record.PhoneNumber;

import java.util.List;

public class PhoneListConsistencyChecker {
    private final List<String> phoneNumbers;

    public PhoneListConsistencyChecker(String phoneList) {
        phoneNumbers = PhoneNumber.extractPhoneNumbers(phoneList);
    }

    public boolean isConsistent() {
        if (phoneNumbers.isEmpty()) return true;
        if (phoneNumbers.size() == 1) return true;
        return phoneNumbers.stream()
                .noneMatch(this::isAnyOtherPhoneNumberStartWith);
    }

    private boolean isAnyOtherPhoneNumberStartWith(String currentPhoneNumber) {
        return phoneNumbers.stream()
                .filter(phoneNumber -> !phoneNumber.equals(currentPhoneNumber))
                .noneMatch(phoneNumber -> phoneNumber.startsWith(currentPhoneNumber));
    }

}
