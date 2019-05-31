package com.justcoffeeshop.errors;

public class ObjectNotFoundException extends ValidatorException {
    public ObjectNotFoundException(String fieldName) {
        super("objectNotFound", fieldName);
    }
}
