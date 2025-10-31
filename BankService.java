// BankService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {
    @Autowired
    private AccountRepository repo;

    @Transactional
    public void transfer(int fromAccountId, int toAccountId, double amount) {
        Account from = repo.findById(fromAccountId)
            .orElseThrow(() -> new RuntimeException("Source account not found"));
        Account to = repo.findById(toAccountId)
            .orElseThrow(() -> new RuntimeException("Destination account not found"));
        if (from.getBalance() < amount) throw new RuntimeException("Insufficient funds");
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        repo.save(from);
        repo.save(to);
        // If any exception occurs, transaction will roll back
    }
}
