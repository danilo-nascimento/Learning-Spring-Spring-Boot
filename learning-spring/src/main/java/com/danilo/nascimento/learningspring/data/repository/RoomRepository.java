package com.danilo.nascimento.learningspring.data.repository;

import com.danilo.nascimento.learningspring.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
