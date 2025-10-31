// Account.java
import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    private String holder;
    private double balance;

    // Constructors, Getters, Setters
}
