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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
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
 * @author Quentin
 */
@WebServlet(name = "ChiffreAffaireClientServlet", urlPatterns = {"/ChiffreAffaireClientServlet"})
public class ChiffreAffaireClientServlet extends HttpServlet {

    private static DataSource dataSource = DataSourceFactory.getDataSource();
    public List<Client> list_client;
    public List<Commande> list_commande;
    CommandeDAO daoCom = new CommandeDAO(dataSource);
    ClientDAO dacCli = new ClientDAO(dataSource);

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
                
                HttpSession session = request.getSession();
                
                Properties result = new Properties();
                String action = request.getParameter("action");
                Map<String, Integer> listOfCommande = daoCom.getNBAllCommandeParClient();
                Gson gson = new Gson();
                String json = gson.toJson(listOfCommande);
                request.setAttribute("listOfCommande", listOfCommande);
                
                System.out.println("--TEST--");
                System.out.println(action);
                boolean ok = false;
                
                if (action != null ) {
                    switch(action){
                        case "Accueil":
                            ok = true;
                            session.setAttribute("contact",null);
                            response.sendRedirect("AccueilServlet");
                            break;
                    }
                }
                if (ok == false){
                    this.getServletContext().getRequestDispatcher("/viewStats.jsp").forward(request, response);
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
                       Logger.getLogger(ChiffreAffaireClientServlet.class.getName()).log(Level.SEVERE, null, ex);
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
                       Logger.getLogger(ChiffreAffaireClientServlet.class.getName()).log(Level.SEVERE, null, ex);
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
