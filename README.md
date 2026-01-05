# Phone Number Kata

## Problem Statement

Given a list of phone numbers, determine whether the list is **consistent**.

A phone list is considered **consistent** if **no phone number is a prefix of another phone number** in the list.  
If any phone number starts with the complete sequence of digits of another number, the list is **inconsistent**.

## Example

Consider the following phone numbers:

- Bob: `91125426`
- Alice: `97625992`
- Emergency: `911`

This phone list is **inconsistent** because the number `911` is a prefix of `91125426`.  
As a result, dialing Bob’s number would be incorrectly routed to the emergency line after entering the first three digits.

## Expected Behavior

- Return **true** if the phone list is consistent.
- Return **false** if at least one phone number is a prefix of another.

## Acceptance Criteria

- An empty list is considered consistent.
- A list containing a single phone number is consistent.
- If any phone number is a prefix of another, the list is inconsistent.
- The order of phone numbers does not affect the result.
- Phone numbers contain digits only.
