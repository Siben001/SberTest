package servlets;

import model.BankModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountBalance extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/accountBalance.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("account_name");
        try {
            BankModel bank = BankModel.getInstance();
            Double balance = bank.getBalance(name);

            req.setAttribute("Account", name);
            req.setAttribute("Balance", balance);
            doGet(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
