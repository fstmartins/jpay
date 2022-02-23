package com.jumia.jpay.repository;

import com.jumia.jpay.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

    List<PhoneNumber> listAll();
}
