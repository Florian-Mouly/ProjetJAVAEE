package DAO_Test;

import DAO.ClientDAO;
import DAO.DataSourceFactory;
import Entities.Client;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class ClientDAOTest {
	private ClientDAO myDAO; // L'objet à tester
	private DataSource myDataSource; // La source de données à utiliser
	

	@Before
	public void setUp() throws SQLException {
		myDataSource = DataSourceFactory.getDataSource();
		myDAO = new ClientDAO(myDataSource);
	}
	
	/**
	 * Test of allClient method, of class ClientDAO.
	 * @throws simplejdbc.SQLException
	 */
	@Test
	public void testNumberOfCustomers() throws SQLException{
		List<Client> result = myDAO.allClient();
		assertEquals(91, result.size());
	}
        

	/***
	 * Test of getClient method, of class ClientDAO.
	 * @throws simplejdbc.SQLException
	 */
	/*** @Test
	public void testgetclient() throws SQLException {
                //exist
		String clientContact = "Maria Anders";
		Client result = myDAO.getClient(clientContact);
		assertEquals(clientContact, result.getContact());
                //don't exist
                clientContact = "test";
                try{
                    result = myDAO.getClient(clientContact);
                    fail("//don't exist");
                }catch(Exception e){
                    
                }
	}

        /**
	 * Test of editClient method, of class ClientDAO.
	 * @throws simplejdbc.SQLException
	 */
	@Test
	public void testeditclient() throws SQLException{
                String clientContact = "Maria Anders";
                String newClientContact = "Maria";
		Client client = myDAO.getClient(clientContact);
                myDAO.editClient(client, null, newClientContact, null, null, null, null, null, null, null, null, null);
                Client newClient=myDAO.getClient(newClientContact);
                clientContact = "Maria";
                newClientContact = "Maria Anders";
		client = myDAO.getClient(clientContact);
                myDAO.editClient(client, null, newClientContact, null, null, null, null, null, null, null, null, null);
                newClientContact = "Maria";
		assertEquals(newClientContact, newClient.getContact());
	}
        
        
//
//	/**
//	 * Test of customersInState method, of class DAO.
//	 * @throws simplejdbc.DAOException
//	 */
//	@Test
//	public void testCustomersInState() throws DAOException {
//		String state = "CA";
//		List<CustomerEntity> result = myDAO.customersInState(state);
//		assertEquals(4, result.size());
//	}
//
//	/**
//	 * Test of deleteCustomer method, of class DAO.
//	 * @throws simplejdbc.DAOException
//	 */
//	@Test
//	public void testDeleteUnknownCustomer () throws DAOException {
//		int id = 999;
//		assertEquals(0, myDAO.deleteCustomer(id));
//	}
//
//	/**
//	 * Test of deleteCustomer method, of class DAO.
//	 * @throws simplejdbc.DAOException
//	 */
//	@Test @Ignore
//	public void testDeleteCustomerWithoutOrder () throws DAOException {
//		int id = 25; // Le client 25 n'a pas de bon de commande
//		assertEquals(1, myDAO.deleteCustomer(id));
//	}
//
//	/**
//	 * Test of deleteCustomer method, of class DAO.
//	 */
//	@Test
//	public void testDeleteCustomerWithOrder () {
//		int id = 1; // Le client 1 a des bons de commande
//		try {
//			myDAO.deleteCustomer(id); // Cette ligne doit lever une exception
//			fail(); // On ne doit pas passer par ici
//		} catch (DAOException e) {
//			// On doit passer par ici, violation d'intégrité référentielle
//		}
//	}
	
}
