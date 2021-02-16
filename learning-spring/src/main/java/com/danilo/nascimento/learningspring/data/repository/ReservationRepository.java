package com.danilo.nascimento.learningspring.data.repository;

import com.danilo.nascimento.learningspring.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
