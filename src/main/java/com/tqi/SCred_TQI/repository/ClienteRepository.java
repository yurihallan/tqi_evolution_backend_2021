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


    @Query(value = "SELECT  e2.id , e2.qtd_parcelas, e2.data_primeira_parcela, e2.valor_emprestimo, " +
            " c.email , c.renda " +
            " FROM cliente c , cliente_emprestimos ce , emprestimo e2, cliente_emprestimos ce3 " +
            " WHERE c.id  = ce.cliente_id " +
            " and ce.emprestimos_id = e2.id " +
            "  c.id = :id ", nativeQuery = true)
    Optional<Cliente> LoanDetail(Long id);
}
