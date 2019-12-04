package servlet;

import DAO.CategorieDAO;
import DAO.ClientDAO;
import Entities.Client;
import DAO.DataSourceFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Quentin
 */
public class AccueilServlet extends HttpServlet {
    
    private static DataSource dataSource;
    private List<Client> all;

    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        dataSource = DataSourceFactory.getDataSource();  
        ClientDAO dao = new ClientDAO(dataSource);
             
        
        this.getServletContext().getRequestDispatcher("/PageAccueil.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        request.setAttribute("email", email);
        
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        
        if(email.equals("admin") && name.equals("admin")){
            request.setAttribute("message", "vous etes admin");
        } else{
            request.setAttribute("message", "vous etes pas admin");
        }
        
        this.getServletContext().getRequestDispatcher("/PageAccueil.jsp").forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
