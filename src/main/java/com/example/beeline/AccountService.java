package com.example.beeline;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    public boolean validate(int amount, int accountFrom, int accountTo) {
        return accountRepository.findById(accountFrom).isPresent() &&
                accountRepository.findById(accountTo).isPresent() &&
                (accountRepository.findById(accountFrom).get().getAmount() >= amount) &&
                accountFrom != accountTo;
    }

    public void transferMoney(int amount, int accountFrom, int accountTo) {
        accountRepository.findById(accountTo).get().setAmount(
                amount + accountRepository.findById(accountTo).get().getAmount()
        );
        accountRepository.findById(accountFrom).get().setAmount(accountRepository.findById(accountFrom).get().getAmount() - amount);

    }

}
