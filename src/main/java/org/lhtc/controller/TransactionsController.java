package org.lhtc.controller;

import org.lhtc.entity.Account;
import org.lhtc.entity.OperationsTypes;
import org.lhtc.entity.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.lhtc.repository.TransactionsRepository;

import java.util.Map;

@Controller
@RequestMapping("/")
public class TransactionsController {

    private TransactionsRepository transactionsRepository;

    @Autowired
    public TransactionsController( TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @RequestMapping(value = "/transactions/{transaction_id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getTransaction(@PathVariable("transaction_id") String transaction_id) {

        Long id = Long.parseLong(transaction_id);
        Transactions transactions = transactionsRepository.findByTransactionId(id);

        if (transactions == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(transactions);
        }
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    public String addTransaction(@RequestBody Map<String, Object> obj) throws Exception {
        Transactions tra = new Transactions();

        Account a = new Account();
        a.setAccountId(Long.parseLong((String) obj.get("account_id")));

        OperationsTypes o = new OperationsTypes();
        o.setOperationTypeId(Long.parseLong((String) obj.get("operation_type_id")));

        tra.setAccountId(a);
        tra.setOperationTypeId(o);
        tra.setAmount(Double.parseDouble((String) obj.get("amount")));
        tra.setEventDate(java.time.LocalDateTime.now());
        tra.validateTransaction();
        transactionsRepository.save(tra);



        return "redirect:/transactions/" + tra.getTransactionId();
    }
}
