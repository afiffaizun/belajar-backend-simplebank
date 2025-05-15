package in.techmafif.bankjago.repository;

import in.techmafif.bankjago.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
}
