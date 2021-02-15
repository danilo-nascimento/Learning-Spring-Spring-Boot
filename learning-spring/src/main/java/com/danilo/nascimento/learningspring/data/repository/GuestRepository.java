package com.danilo.nascimento.learningspring.data.repository;

import com.danilo.nascimento.learningspring.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {

}
