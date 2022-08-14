package org.core.services;

import org.core.DAO.TransactionDAO;
import org.core.DTO.TransactionDTO;
import org.core.mappers.TransactionMapper;
import org.core.repositories.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    public boolean isValid(TransactionDTO transactionDTO) {
        return true;
    }

    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {

        TransactionDAO transactionDAO = transactionMapper.convertDTOtoDAO(transactionDTO);

        TransactionDAO savedTransactionDAO = transactionRepository.save(transactionDAO);

        return transactionMapper.convertDAOtoDTO(savedTransactionDAO);
    }

    public List<TransactionDTO> getTransactions() {

        List<TransactionDTO> transactionDTOList = new ArrayList<>();

        List<TransactionDAO> transactionDAOList = transactionRepository.findAll();

        for (TransactionDAO transactionDAO : transactionDAOList) {
            transactionDTOList.add(transactionMapper.convertDAOtoDTO(transactionDAO));
        }
        return transactionDTOList;
    }

    public TransactionDTO getTransaction(Long id) throws NoSuchElementException {
        TransactionDAO transactionDAO = transactionRepository.findById(id).orElseThrow();
        return transactionMapper.convertDAOtoDTO(transactionDAO);
    }

    public void deleteTransaction(Long id) throws EmptyResultDataAccessException {
        transactionRepository.deleteById(id);
    }
}
