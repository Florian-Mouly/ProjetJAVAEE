/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_Test;

import DAO.ProduitDAO;
import DAO.DataSourceFactory;
import Entities.Produit;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Flo
 */
public class ProduitDAOTest {
        private ProduitDAO myDAO;
        private DataSource myDataSource;
        
        
        @Before
        public void setUp() throws SQLException {
            myDataSource = DataSourceFactory.getDataSource();
            myDAO = new ProduitDAO(myDataSource);
        }
        /**
         * Test of allProduit methid, of class ProduitDAO
         * On verifie si on a bien la totalité des produits
         * @throws SQLException 
         */
        @Test
        public void testNumberOfProduct() throws SQLException{
            List<Produit> result = myDAO.allProduit();
            assertEquals(77, result.size());
        }
        
//        @Test
//        public void testgetproduit() throws SQLException {
//            //exist
//            String nomProduit = "Chai";
//            Produit result = myDAO.getNom(nomProduit);
//            
//        }
}
