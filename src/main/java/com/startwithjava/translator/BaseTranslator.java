package com.startwithjava.translator;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BaseTranslator<S,D>{
    private ModelMapper mapper;

    public D translate(S source,Class<D> targetType){
       return mapper.map(source,targetType);
    }
}
