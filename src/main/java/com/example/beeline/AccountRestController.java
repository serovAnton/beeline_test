package com.example.beeline;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController

public class AccountRestController {

    private final AccountService accountService;

    @Autowired
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/transferMoney")
    public void transferMoney(int amount, int accountFrom, int accountTo) {
        if (accountService.validate(amount, accountFrom, accountTo))
             accountService.transferMoney(amount, accountFrom, accountTo);
        else throw new ResponseStatusException(HttpStatus.MULTI_STATUS, "Incorrect data");;
    }

}
