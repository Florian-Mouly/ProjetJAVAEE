/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.ClientDAO;
import DAO.CommandeDAO;
import DAO.DataSourceFactory;
import Entities.Client;
import Entities.Commande;
import Entities.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author damie
 */
@WebServlet(name = "commandeClientServlet", urlPatterns = {"/commandeClientServlet"})
public class commandeClientServlet extends HttpServlet {

    private static DataSource datasource = DataSourceFactory.getDataSource();
    public List<Commande> list_commande;
    ClientDAO clientDAO = new ClientDAO(datasource);
    CommandeDAO commandeDAO = new CommandeDAO(datasource);

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String client = (String)session.getAttribute("contact");
        
        String clientCode = clientDAO.getClient(client).getCode();
        list_commande=commandeDAO.getCommande(clientCode);
        String action = request.getParameter("action");
        
        
        boolean ok = false;
        boolean ok2 = false;
        
        System.out.println("---------------------------------------");
        if (action != null ) {
            switch(action){
            case "Accueil":
                ok = true;
                session.setAttribute("contact",null);
                response.sendRedirect("AccueilServlet");
                break;
            case "Retour":
                ok2 = true;
                response.sendRedirect("personalDataServlet");
            }
        }
        if(ok == false && ok2 == false){
            request.setAttribute("list_commande", list_commande);
            this.getServletContext().getRequestDispatcher("/listeCommandes.jsp").forward(request, response);
        }
        
        
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(commandeClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(commandeClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
