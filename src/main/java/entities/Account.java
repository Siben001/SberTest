package entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Collator;
import java.util.Locale;

public class Account {
    private String name;
    private Double balance;

    public Account(ResultSet rs) throws SQLException {
        setName(rs.getString(1));
        setBalance(rs.getDouble(2));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    public String toString() {
        return "Account:" + name + ", balance=" + balance;
    }

    public int compareTo(Object obj) {
        Collator c = Collator.getInstance(new Locale("ru"));
        c.setStrength(Collator.PRIMARY);
        return c.compare(this.toString(), obj.toString());
    }
}
