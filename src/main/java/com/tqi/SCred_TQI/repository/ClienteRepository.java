package com.tqi.SCred_TQI.repository;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.tqi.SCred_TQI.entity.Cliente;
import com.tqi.SCred_TQI.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Query(value = "select c.* from cliente c WHERE c.email = :email AND c.senha = :senha ",nativeQuery = true)
    Optional<Cliente> GetLogin(String email, String senha);


    @Query(value = "SELECT c.email, c.renda, e.id, e.valor_emprestimo, e.data_primeira_parcela, e.qtd_parcelas " +
            " FROM cliente c inner join emprestimo e " +
            " on c.id = e.cliente_id " +
            " where c.id = ?1 ", nativeQuery = true)
    Optional<Object> LoanDetail(Long id);
}
