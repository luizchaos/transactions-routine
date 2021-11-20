package org.lhtc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.lhtc.entity.Account;
import org.lhtc.repository.AccountRepository;

import java.util.Map;

@Controller
@RequestMapping("/")
public class AccountController {
    private AccountRepository accountRepository;

    @Autowired
    public AccountController( AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/accounts/{account_id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAccount(@PathVariable("account_id") String account_id) {

        Long id = Long.parseLong(account_id);
        Account account = accountRepository.findByAccountId(id);

        if (account == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(account);
        }
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    public String addAccount(@RequestBody Map<String, Object> account) {
        Account acc = new Account();
        acc.setDocumentNumber(Integer.parseInt((String) account.get("document_number")));
        accountRepository.save(acc);

        return "redirect:/accounts/" + acc.getAccountId();
    }
}
