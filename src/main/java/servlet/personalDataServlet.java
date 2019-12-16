/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.ClientDAO;
import Entities.Client;
import DAO.DataSourceFactory;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Flo pc
 */
@WebServlet(name = "personalDataServlet", urlPatterns = {"/personalDataServlet"})
public class personalDataServlet extends HttpServlet {

    private static DataSource dataSource = DataSourceFactory.getDataSource();
    public Client clientCourant;
    ClientDAO daoclient = new ClientDAO(dataSource);
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        String client = (String) session.getAttribute("contact");
        clientCourant = daoclient.getClient(client);
        String action = request.getParameter("action");
        boolean ok = false;
        boolean ok2= false;
        

        if (action != null ) {
            switch(action){
            case "Envoyer":
                System.out.println("TEST ENVOYER");
                String Contact = request.getParameter("Contact");
                String Societe = request.getParameter("Societe");
                String Fonction = request.getParameter("Fonction");
                String Adresse = request.getParameter("Adresse");
                String Ville = request.getParameter("Ville");
                String Region = request.getParameter("Region");
                String Code_Postal = request.getParameter("Code_Postal");
                String Pays = request.getParameter("Pays");
                String Telephone = request.getParameter("Telephone");
                String Fax = request.getParameter("Fax");
                daoclient.editClient(clientCourant, null, Contact, Societe, Fonction, Adresse, Ville, Region, Code_Postal, Pays, Telephone, Fax);
                session.setAttribute("contact", Contact);
                clientCourant = daoclient.getClient(Contact);
                break;
            case "Voir":
                ok = true;
                response.sendRedirect("commandeClientServlet");
                break;
            case "Deco":
                ok2= true;
                session.setAttribute("contact",null);
                response.sendRedirect("AccueilServlet");
                break;
            }
        }
        if(ok == false && ok2 == false){
            request.setAttribute("clientCourant", clientCourant);
            this.getServletContext().getRequestDispatcher("/personalData.jsp").forward(request, response);
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
            Logger.getLogger(personalDataServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(personalDataServlet.class.getName()).log(Level.SEVERE, null, ex);
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
