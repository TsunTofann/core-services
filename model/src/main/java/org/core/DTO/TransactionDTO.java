package org.core.DTO;

import lombok.Data;

@Data
public class TransactionDTO {

    private Long id;
    private String name;
    private Float amount;
}
