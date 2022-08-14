package org.core.mappers;

import org.core.DAO.TransactionDAO;
import org.core.DTO.TransactionDTO;
import org.springframework.stereotype.Service;

@Service
public class TransactionMapper {

    public TransactionDTO convertDAOtoDTO(TransactionDAO transactionDAO){
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setId(transactionDAO.getId());
        transactionDTO.setName(transactionDAO.getName());
        transactionDTO.setAmount(transactionDAO.getAmount());
        return transactionDTO;
    }

    public TransactionDAO convertDTOtoDAO(TransactionDTO transactionDTO){
        TransactionDAO transactionDAO = new TransactionDAO();
        transactionDAO.setId(transactionDTO.getId());
        transactionDAO.setName(transactionDTO.getName());
        transactionDAO.setAmount(transactionDTO.getAmount());
        return transactionDAO;
    }
}
