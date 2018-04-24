package model;

import entities.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankModel {
    private List<Account> bank;

    private static Connection con;
    private static BankModel instance;

    private BankModel() throws Exception{
        bank = new ArrayList<Account>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/web_test";
            String username = "root";
            String password = "123qwe";
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new Exception(e);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public static synchronized BankModel getInstance() throws Exception {
        if (instance == null) {
            instance = new BankModel();
        }
        return instance;
    }

    public void addAccount(String name) throws SQLException {
        PreparedStatement stmt = null;
        Double base_balance = 0.0;
        try {
            stmt = con.prepareStatement("INSERT INTO bank VALUES (?, ?)");
            stmt.setString(1, name);
            stmt.setDouble(2, base_balance);
            stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public List getAccountList() throws SQLException{
        List<Account> l = new ArrayList();

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM bank");
            while (rs.next()) {
                Account acc = new Account(rs);
                l.add(acc);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return l;
    }

    public void deleteAccount(String name) throws SQLException{
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM bank WHERE account=?");
            stmt.setString(1, name);
            stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public Double getBalance(String name) throws SQLException{
        Double blnc = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * from bank WHERE account=?");
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Account acc = new Account(rs);
                blnc = acc.getBalance();
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return blnc;
    }

    public Account takeMoney(String name, Double sum) throws SQLException{
        Account acc = null;
        acc = getAccountByName(name);
        if (acc != null) {
            Double current_balance = acc.getBalance();
            Double new_balance = current_balance - sum;
            if (new_balance < 0.0) {
                acc.setBalance(-1.0);
            } else {
                updateAccount(name, new_balance);
                acc = getAccountByName(name);
            }
        }
        return acc;
    }

    public Account addMoney(String name, Double sum) throws SQLException{
        Account acc = null;
        acc = getAccountByName(name);
        if (acc != null) {
            Double new_balance = acc.getBalance() + sum;
            updateAccount(name, new_balance);
            acc = getAccountByName(name);
        }
        return acc;
    }

    public List<Account> moneyTransfer(Account acc_from, Account acc_to, Double sum) throws SQLException{
        List<Account> acc = new ArrayList<>();
        if (acc_from.getName().equals(acc_to.getName()))
        {
            acc.add(acc_from);
            acc.add(acc_to);
        }
        else {
            acc_from = takeMoney(acc_from.getName(), sum);
            acc.add(acc_from);
            if (acc_from.getBalance() >= 0.0){
                acc_to = addMoney(acc_to.getName(), sum);
            }
            acc.add(acc_to);}
        return acc;
    }


    public void updateAccount(String name, Double new_balance) throws SQLException{
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE bank SET balance=? WHERE account=?");
            stmt.setDouble(1, new_balance);
            stmt.setString(2, name);
            stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public Account getAccountByName(String name) throws SQLException{
        Account acc = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * from bank WHERE account=?");
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            while (rs.next()) {
                acc = new Account(rs);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }


        return acc;
    }
}
