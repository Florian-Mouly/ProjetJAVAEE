/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.DataSourceFactory;
import DAO.ProduitDAO;
import Entities.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "EditionProduitServlet", urlPatterns = {"/EditionProduitServlet"})
public class EditionProduitServlet extends HttpServlet {

    private static DataSource dataSource = DataSourceFactory.getDataSource();
    //public Produit produitCourant;
    ProduitDAO daoproduit = new ProduitDAO(dataSource);
    public List<Produit> listProduit;
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
        
//        int client = (String) session.getAttribute("contact");
//        produitCourant = daoproduit.getProduit(client);
        String action = request.getParameter("action");
        boolean ok = false;
        boolean ok2= false;
        
        if (action != null ) {
            switch(action){
            case "Save":
                System.out.println("TEST ENVOYER");
                String nom = request.getParameter("Nom");
                int fournisseur = Integer.parseInt(request.getParameter("Fournisseur"));
                int categorie = Integer.parseInt(request.getParameter("Categorie"));
                String quantite_par_unite = request.getParameter("Quantite_par_unite");
                Double prix_unitaire = Double.parseDouble(request.getParameter("Prix_unitaire"));
                int unite_en_stock = Integer.parseInt(request.getParameter("Unite_en_stock"));
                int unites_commandees = Integer.parseInt(request.getParameter("Unites_commandees"));
                int niveau_de_reapprovi = Integer.parseInt(request.getParameter("Niveau_de_reapprovi"));
                int indisponible = Integer.parseInt(request.getParameter("Indisponible"));
                int ref=666;
                daoproduit.ajoutProduit(nom, ref, fournisseur, categorie, quantite_par_unite, prix_unitaire, unite_en_stock, unites_commandees, niveau_de_reapprovi, indisponible);
                session.setAttribute("contact", "admin");
                response.sendRedirect("AdminProduitServlet");
                ok2= true;
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
            this.getServletContext().getRequestDispatcher("/editionProduit.jsp").forward(request, response);
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
            Logger.getLogger(EditionProduitServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditionProduitServlet.class.getName()).log(Level.SEVERE, null, ex);
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
