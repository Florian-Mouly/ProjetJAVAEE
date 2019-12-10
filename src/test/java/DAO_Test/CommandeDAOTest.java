
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_Test;

import DAO.CommandeDAO;
import DAO.DataSourceFactory;
import Entities.Commande;
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
public class CommandeDAOTest {
        private CommandeDAO myDAO; // L'objet à tester
	private DataSource myDataSource; // La source de données à utiliser
        
        @Before
	public void setUp() throws SQLException {
		myDataSource = DataSourceFactory.getDataSource();
		myDAO = new CommandeDAO(myDataSource);
	}
        
        
	/**
	 * Test of allCommande method, of class CommandeDAO.
	 * @throws simplejdbc.SQLException
	 */
	@Test
	public void testNumberOfCommand() throws SQLException{
		List<Commande> result = myDAO.allCommande();
		assertEquals(830, result.size());
	}
        
        /**
	 * Test of getCommande method, of class CommandeDAO.
	 * @throws simplejdbc.SQLException
	 */
	@Test
	public void testgetcommande() throws SQLException {
                //exist
		String commandeClient = "VINET";
		Commande result = myDAO.getCommande(commandeClient);
		assertEquals(commandeClient, result.getClient());
                //don't exist
                commandeClient = "test";
                result = myDAO.getCommande(commandeClient);
                assertEquals(null, result);
	}
}
