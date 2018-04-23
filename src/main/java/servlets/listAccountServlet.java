package servlets;

import entities.Account;
import model.BankModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class listAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BankModel bank = null;
        try {
            bank = BankModel.getInstance();
            List<Account> acc = bank.getAccountList();
            req.setAttribute("Accounts", acc);
        } catch (Exception e) {
            e.printStackTrace();
        }


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/listAccount.jsp");
        requestDispatcher.forward(req, resp);
    }
}
