package servlets;

import entities.Account;
import model.BankModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class takeMoney extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/takeMoney.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("account_name");
        Integer err_numb = null;
        try {
            req.setAttribute("Account", name);
            Double sum = Double.parseDouble(req.getParameter("sum"));
            try {
                BankModel bank = BankModel.getInstance();
                Account acc = bank.takeMoney(name, sum);
                if (acc == null){
                    err_numb = 1;
                }
                else {
                    req.setAttribute("Balance", acc.getBalance());
                }
                req.setAttribute("Error", err_numb);
                doGet(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e)
        {
            req.setAttribute("Error", 2);
            doGet(req, resp);
        }
    }
}
