package in.techmafif.bankjago.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.techmafif.bankjago.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByAccountNumber(String accountNumber);
}
	
