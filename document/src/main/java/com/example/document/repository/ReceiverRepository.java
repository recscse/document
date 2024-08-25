package com.example.document.repository;

import com.example.document.model.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReceiverRepository extends JpaRepository<Receiver,String> {
   Optional<Receiver> findByUserName(String userName);
}
