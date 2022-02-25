package com.intive.patronage22eganortap.web.mapper;


import org.mapstruct.*;

@MapperConfig(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        implementationName = "<CLASS_NAME>MapstructImpl"

)
public interface GlobalMapperConfig {
}
