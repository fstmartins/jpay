package com.jumia.jpay.mapper;

import com.jumia.jpay.model.Customer;
import com.jumia.jpay.model.CustomerResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerToCustomerResponseMapper {

    CustomerToCustomerResponseMapper INSTANCE = Mappers.getMapper(CustomerToCustomerResponseMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "phone", target = "phone")
    CustomerResponseBody customerToCustomerResponse(Customer customer);
}
