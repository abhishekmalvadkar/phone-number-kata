package com.amalvadkar.pnk.checker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneListConsistencyCheckerTest {
    @Test
    void should_return_true_if_given_phone_list_is_empty() {
        PhoneListConsistencyChecker phoneListConsistencyChecker = new PhoneListConsistencyChecker("""
                Name,Phone Number""");

        boolean isConsistent = phoneListConsistencyChecker.isConsistent();

        assertThat(isConsistent).isTrue();
    }

    @Test
    void should_return_true_if_given_single_phone_entry_phone_list() {
        PhoneListConsistencyChecker phoneListConsistencyChecker = new PhoneListConsistencyChecker("""
                Name,Phone Number
                XYZ,123""");

        boolean isConsistent = phoneListConsistencyChecker.isConsistent();

        assertThat(isConsistent).isTrue();
    }

    @Test
    void should_return_false_if_given_in_consistent_phone_list() {
        PhoneListConsistencyChecker phoneListConsistencyChecker = new PhoneListConsistencyChecker("""
                Name,Phone Number
                ABC,12345,
                XYZ,123""");

        boolean isConsistent = phoneListConsistencyChecker.isConsistent();

        assertThat(isConsistent).isFalse();
    }

    @Test
    void should_return_false_if_given_in_consistent_example_phone_list() {
        PhoneListConsistencyChecker phoneListConsistencyChecker = new PhoneListConsistencyChecker("""
                Name,Phone Number
                Bob,91125426,
                Alice,97625992
                Emergency,911""");

        boolean isConsistent = phoneListConsistencyChecker.isConsistent();

        assertThat(isConsistent).isFalse();
    }

    @Test
    void should_return_true_if_given_consistent_phone_list() {
        PhoneListConsistencyChecker phoneListConsistencyChecker = new PhoneListConsistencyChecker("""
                Name,Phone Number
                Bob,91125426,
                Alice,97625992
                Emergency,456""");

        boolean isConsistent = phoneListConsistencyChecker.isConsistent();

        assertThat(isConsistent).isTrue();
    }
}
