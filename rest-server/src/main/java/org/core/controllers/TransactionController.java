package org.core.controllers;

import org.core.DTO.TransactionDTO;
import org.core.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/hello")
    public ResponseEntity<String> helloController(){
        String helloString = "Hello";
        return new ResponseEntity<>(helloString, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TransactionDTO> saveTransaction(@RequestBody TransactionDTO transactionDTO){
        if(!transactionService.isValid(transactionDTO)){
            logger.error("Transaction Not Valid");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        TransactionDTO savedTransaction = transactionService.saveTransaction(transactionDTO);

        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransactionDTO>> getAllTransactions(){

        List<TransactionDTO> transactions = transactionService.getTransactions();

        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable Long id){
        try{
            TransactionDTO transactionDTO = transactionService.getTransaction(id);
            logger.info("Transaction found #{}", transactionDTO.getId());
            return new ResponseEntity<>(transactionDTO, HttpStatus.OK);
        } catch(NoSuchElementException error){
            logger.error("Erreur NoSuchElementException:", error);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTransaction(@PathVariable Long id){
        try{
            transactionService.deleteTransaction(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch(EmptyResultDataAccessException error){
            logger.error("Erreur EmptyResultDataAccessException:", error);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
