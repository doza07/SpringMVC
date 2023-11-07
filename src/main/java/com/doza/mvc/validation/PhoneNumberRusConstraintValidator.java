package com.doza.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberRusConstraintValidator implements ConstraintValidator<PhoneNumberRus, String> {

    private String phonePrefix;

    @Override
    public void initialize(PhoneNumberRus thePhoneNumberRus) {
        phonePrefix = thePhoneNumberRus.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {


        boolean result;
        if(theCode != null) {
            result = theCode.startsWith(phonePrefix);
        }else {
            result = true;
        }

        return result;
    }
}
