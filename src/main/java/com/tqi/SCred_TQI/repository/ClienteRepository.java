package com.tqi.SCred_TQI.repository;

import com.tqi.SCred_TQI.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Query(value = "select c.* from cliente c WHERE c.email = :email AND c.senha = :senha ",nativeQuery = true)
    Optional<Cliente> GetLogin(String email, String senha);
}
