package servlets;

import entities.Account;
import model.BankModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class moneyTransfer extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/moneyTransfer.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name_from = req.getParameter("account_name_from");
        String name_to = req.getParameter("account_name_to");
        Integer err_numb = null;
        try {

            Double sum = Double.parseDouble(req.getParameter("sum"));
            try {
                BankModel bank = BankModel.getInstance();
                Account acc_from = bank.getAccountByName(name_from);
                Account acc_to = bank.getAccountByName(name_to);
                if (acc_from == null){
                    err_numb = 1;
                    req.setAttribute("Account", name_from);
                }
                else if (acc_to == null){
                    err_numb = 1;
                    req.setAttribute("Account", name_to);
                }
                else {
                    List<Account> acc = bank.moneyTransfer(acc_from, acc_to, sum);
                    req.setAttribute("Account_from", acc.get(0));
                    req.setAttribute("Account_to", acc.get(1));
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
