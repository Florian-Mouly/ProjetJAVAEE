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
 * @author Flo pc
 */
@WebServlet(name = "AdminProduitServlet", urlPatterns = {"/AdminProduitServlet"})
public class AdminProduitServlet extends HttpServlet {

    private static DataSource dataSource = DataSourceFactory.getDataSource();
    public List<Produit> listProduit;
    ProduitDAO  daoproduit = new ProduitDAO(dataSource);
    
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
        String action = request.getParameter("action");
        listProduit = daoproduit.allProduit();
        
        boolean ok = false;
        boolean ok2 = false;
        boolean ok3 = false;
        boolean ok4 = false;
        
        if (action != null ) {
            switch(action){
                case "Accueil":
                    ok = true;
                    session.setAttribute("contact",null);
                    response.sendRedirect("AccueilServlet");
                    break;
                case "Retour":
                    ok2 = true;
                    response.sendRedirect("ChiffreAffaireClientServlet");
                    break;
                case "Edit":
                    ok3 = true;
                    response.sendRedirect("EditionProduitServlet");
                    break;
               
            }
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // val[O] -> type du bouton
            // val[1] -> reference du produit selectione

                String[] val=action.split(";");
                if( !ok && !ok2 && !ok3 && val[0].equals("modifier")){
                    Produit produitCourant=daoproduit.getProduit(Integer.parseInt(val[1]));
                    request.setAttribute("produitCourant", produitCourant);
                    response.sendRedirect("ModifProduitServlet");
                }
            
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            if( !ok && !ok2 && !ok3 && (Integer.parseInt(action)>0) && (Integer.parseInt(action)<999)){
                System.out.println("delete "+action);
                daoproduit.supprProduit(Integer.parseInt(action));
                listProduit=daoproduit.allProduit();
            }   
        }
        
        
        
        if (ok == false && ok2 == false && ok3==false){
            
            request.setAttribute("listProduit", listProduit);
            this.getServletContext().getRequestDispatcher("/listeProduitsAdmin.jsp").forward(request, response);
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
            Logger.getLogger(AdminProduitServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminProduitServlet.class.getName()).log(Level.SEVERE, null, ex);
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
