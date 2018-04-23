package servlets;

import entities.Account;
import model.BankModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/deleteAccount.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("account_name");
        try {
            BankModel bank = BankModel.getInstance();

            Account acc = bank.getAccountByName(name);
            if (acc != null){
                bank.deleteAccount(name);
            }
            else {
                req.setAttribute("Error", 1);
            }
            req.setAttribute("Account", name);
            doGet(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
