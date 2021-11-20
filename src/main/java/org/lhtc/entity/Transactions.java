package org.lhtc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.time.LocalDateTime;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "accountId", nullable = false)
    private Account accountId;

    @ManyToOne
    @JoinColumn(name = "operationTypeId", nullable = false)
    private OperationsTypes operationTypeId;

    @Column(name="amount", nullable=false, unique=false)
    private Double amount;

    @Column(name="eventDate", nullable=false, unique=false)
    private LocalDateTime eventDate;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public OperationsTypes getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(OperationsTypes operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public void validateTransaction() throws Exception {
        if (operationTypeId.getOperationTypeId() == 4){
            if (amount < 0){
                throw new Exception("Invalid Transaction");
            }
        }else{
            if (amount > 0){
                throw new Exception("Invalid Transaction");
            }
        }
    }
}
