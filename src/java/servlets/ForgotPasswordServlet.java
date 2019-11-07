package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

public class ForgotPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        
        AccountService as = new AccountService();
        
        Boolean scary = false;
        try {
            scary = as.forgotPassword(email, getServletContext().getRealPath("/WEB-INF"));
        } catch (Exception ex) {
            Logger.getLogger(ForgotPasswordServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(scary == false){
            request.setAttribute("update", "Could not find email in database. Try again.");
        } else {
            request.setAttribute("update", "Email sent successfully.");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/forgot.jsp").forward(request, response);
    }
}
