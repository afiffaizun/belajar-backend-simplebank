package in.techmafif.bankjago.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.techmafif.bankjago.model.Account;
import in.techmafif.bankjago.model.Transaction;
import in.techmafif.bankjago.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	private final AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService= accountService;
	}
	
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		return ResponseEntity.ok(accountService.createAccount(account));
	}
	
	@GetMapping
	public ResponseEntity<List<Account>> getAllAccounts() {
		return ResponseEntity.ok(accountService.getAllAccounts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
		return ResponseEntity.ok(accountService.getAccountById(id));
	}
	
	@PostMapping("/{accountNumber}/deposit")
    public ResponseEntity<Transaction> deposit(@PathVariable String accountNumber, 
                                            @RequestParam BigDecimal amount) {
        return ResponseEntity.ok(accountService.deposit(accountNumber, amount));
    }

    @PostMapping("/{accountNumber}/withdraw")
    public ResponseEntity<Transaction> withdraw(@PathVariable String accountNumber, 
                                             @RequestParam BigDecimal amount) {
        return ResponseEntity.ok(accountService.withdraw(accountNumber, amount));
    }
	
}
