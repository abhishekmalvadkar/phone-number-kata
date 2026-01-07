package com.amalvadkar.pnk.checker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneListConsistencyCheckerTest {
    @Test
    void should_return_true_if_given_phone_list_is_empty() {
        PhoneListConsistencyChecker phoneListConsistencyChecker = new PhoneListConsistencyChecker();

        boolean isConsistent = phoneListConsistencyChecker.isConsistent("""
                Name,Phone Number""");

        assertThat(isConsistent).isTrue();
    }

    @Test
    void should_return_true_if_given_single_phone_entry_phone_list() {
        PhoneListConsistencyChecker phoneListConsistencyChecker = new PhoneListConsistencyChecker();

        boolean isConsistent = phoneListConsistencyChecker.isConsistent("""
                Name,Phone Number
                XYZ,123""");

        assertThat(isConsistent).isTrue();
    }
}
