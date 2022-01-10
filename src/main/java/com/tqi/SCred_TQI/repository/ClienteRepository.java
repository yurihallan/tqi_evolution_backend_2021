package com.tqi.SCred_TQI.repository;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.tqi.SCred_TQI.entity.Cliente;
import com.tqi.SCred_TQI.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Query(value = "select c.* from cliente c WHERE c.email = :email AND c.senha = :senha ",nativeQuery = true)
    Optional<Cliente> GetLogin(String email, String senha);


    @Query(value = "Selecte2.id , e2.qtd_parcelas, e2.data_primeira_parcela, e2.valor_emprestimo, " +
            " c.email , c.renda " +
            " join cliente_emprestimos ce " +
            "  on c.id = ce,cliente_id " +
            " join emprestimo e " +
            " on e.id = ce.emprestimos_id " +
            " where c.id = :id",nativeQuery = true )
    Optional<Cliente> LoanDetail(@Param("id") Long id);
}
