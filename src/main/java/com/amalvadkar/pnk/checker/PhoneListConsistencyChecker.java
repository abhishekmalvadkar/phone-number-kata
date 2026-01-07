package com.amalvadkar.pnk.checker;

import com.amalvadkar.pnk.record.PhoneNumber;

import java.util.List;
import java.util.function.Predicate;

public class PhoneListConsistencyChecker {
    private final List<String> phoneNumbers;

    public PhoneListConsistencyChecker(String phoneList) {
        phoneNumbers = PhoneNumber.extractPhoneNumbers(phoneList);
    }

    public boolean isConsistent() {
        if (phoneNumbers.isEmpty()) return true;
        if (phoneNumbers.size() == 1) return true;
        return phoneNumbers.stream()
                .noneMatch(this::withAnyOtherPhoneNumberStartWith);
    }

    private boolean withAnyOtherPhoneNumberStartWith(String givenPhoneNumber) {
        return phoneNumbers.stream()
                .filter(ignore(givenPhoneNumber))
                .noneMatch(whereStartWith(givenPhoneNumber));
    }

    private static Predicate<String> whereStartWith(String currentPhoneNumber) {
        return phoneNumber -> phoneNumber.startsWith(currentPhoneNumber);
    }

    private static Predicate<String> ignore(String currentPhoneNumber) {
        return phoneNumber -> !phoneNumber.equals(currentPhoneNumber);
    }

}
