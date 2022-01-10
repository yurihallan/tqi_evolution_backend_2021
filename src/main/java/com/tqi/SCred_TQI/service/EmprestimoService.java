package com.tqi.SCred_TQI.service;

import com.tqi.SCred_TQI.entity.Emprestimo;
import com.tqi.SCred_TQI.exception.LoanNotFoundException;
import com.tqi.SCred_TQI.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository;

    public List<Emprestimo> listAllLoan(){
        return emprestimoRepository.findAll();
    }

    public Emprestimo findLoanById(@PathVariable Long id) throws LoanNotFoundException {
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(id);

        return emprestimoOptional.orElseThrow(() -> new LoanNotFoundException("Loan Not Found"));
    }

    public ResponseEntity CreateLoan( @RequestBody Emprestimo NewEmprestimo){
        LocalDate data_primeira_parcela = NewEmprestimo.getData_primeira_parcela();
        LocalDate data_tres_meses = LocalDate.now().plusMonths(3);

        if((NewEmprestimo.getQtd_parcelas() <= 60) && (data_primeira_parcela.compareTo(data_tres_meses) <= 0)) {
            return new ResponseEntity(emprestimoRepository.save(NewEmprestimo), HttpStatus.OK);
        } else {
            return new ResponseEntity(new LoanNotFoundException("Emprestimo excedeu o limite permitido!"), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity deleteLoan(@PathVariable Long id) {
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(id);
        if(emprestimoOptional.isPresent()){
            emprestimoRepository.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return  new ResponseEntity(new LoanNotFoundException("Emprestimo não foi encontrado!"),HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity ChangeLoan(@PathVariable Long id, @RequestBody Emprestimo NewEmprestimo) {
        Optional<Emprestimo> emprestimoOld = emprestimoRepository.findById(id);

        if(emprestimoOld.isPresent()){
            Emprestimo emprestimo = emprestimoOld.get();
            emprestimo.setValor_emprestimo(NewEmprestimo.getValor_emprestimo());
            emprestimo.setQtd_parcelas(NewEmprestimo.getQtd_parcelas());
            emprestimo.setData_primeira_parcela(NewEmprestimo.getData_primeira_parcela());
            return new ResponseEntity<>(emprestimo, HttpStatus.OK);
        }else {
            return new ResponseEntity(new LoanNotFoundException("O id do Emprestimo não foi encontrado!"),HttpStatus.NOT_FOUND);
        }
    }

}
