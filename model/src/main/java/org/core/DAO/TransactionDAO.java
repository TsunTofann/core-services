package org.core.DAO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity()
@Table(name="transaction")
public class TransactionDAO {

    @Id
    private Long id;

    private String name;

    private Float amount;
}
