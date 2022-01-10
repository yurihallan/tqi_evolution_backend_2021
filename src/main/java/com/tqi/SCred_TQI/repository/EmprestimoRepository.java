package com.tqi.SCred_TQI.repository;

import com.tqi.SCred_TQI.entity.Cliente;
import com.tqi.SCred_TQI.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmprestimoRepository extends JpaRepository<Emprestimo,Long> {

    @Query(value = "SELECT e.id, e.valor_emprestimo, e.qtd_parcelas FROM emprestimo e ", nativeQuery = true)
    List<Object> FindAllEmprestimo();
}
