package com.example.jpa.domain.base;


import com.example.jpa.constant.BaseEnumCode;

import javax.persistence.AttributeConverter;
import java.util.Arrays;

public abstract class AbstractBaseEnumConverter<X extends Enum<X> & BaseEnumCode<Y>, Y> implements AttributeConverter<X, Y> {

    protected abstract X[] getValueList();

    @Override
    public Y convertToDatabaseColumn(X attribute) {
        return attribute.getValue();
    }

    @Override
    public X convertToEntityAttribute(Y dbData) {
        return Arrays.stream(getValueList()).filter(e -> e.getValue().equals(dbData)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported type for %s.", dbData)));
    }

}
