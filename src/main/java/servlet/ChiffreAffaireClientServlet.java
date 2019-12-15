/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.CommandeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Quentin
 */
@WebServlet(name = "ChiffreAffaireClientServlet", urlPatterns = {"/ChiffreAffaireClientServlet"})
public class ChiffreAffaireClientServlet extends HttpServlet {
               CommandeDAO commandedao;

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
                Map<String,Integer> map = commandedao.getNBAllCommandeParClient();
                request.setAttribute("map", map);
                Gson gson= new Gson();
                String jsonString = gson.toJson(map);
                response.setContentType(jsonString);
                response.getWriter().write(jsonString);
                System.out.println("map="+map);
        
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
