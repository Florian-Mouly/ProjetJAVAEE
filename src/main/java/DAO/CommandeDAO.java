package DAO;

import Entities.Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;



public class CommandeDAO {

	private final DataSource myDataSource;

	/**
	 * Construit le AO avec sa source de données
	 * @param dataSource la source de données à utiliser
	 */
	public CommandeDAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}

	/**
	 * Contenu de la table Commande
	 * @return Liste des commandes
	 * @throws SQLException renvoyées par JDBC
	 */
	public List<Commande> allCommande() throws SQLException {

		List<Commande> result = new LinkedList<>();

		String sql = "SELECT * FROM Commande ORDER BY Numero";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int Numero = rs.getInt("Numero");
				String Client = rs.getString("Client");
				Commande c = new Commande(Numero, Client, null, null, null, null, null, null, null, null, null, null);
				result.add(c);
			}
		}
		return result;
	}
        
        /**
	 * Affiche la commande faite pas un client
         * @param client
	 * @return Commande du client
	 * @throws SQLException renvoyées par JDBC
	 */
	public Commande getCommande(String client) throws SQLException {

		Commande result=null;

		String sql = "SELECT * FROM Commande WHERE Client=?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, client);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int Numero = rs.getInt("Numero");
				String Client = rs.getString("Client");
				Commande c = new Commande(Numero, Client, null, null, null, null, null, null, null, null, null, null);
				result=c;
			}
		}
		return result;
	}
        
        
        /**
	 * compte le nombre de commande par categorie sur une page donnee
         * @param dateDeb debut de la plage a rechercher
         * @param dateFin fin de la plage a rechercher
	 * @return tableau de in
	 * @throws SQLException renvoyées par JDBC
	 */
	public Map<String, Integer> getNBCommandeParCateg(String dateDeb, String dateFin) throws SQLException {

		Map<String, Integer> result=new HashMap<String, Integer>();

		String sql = "SELECT count(distinct Numero) as NB, Ca.LIBELLE as nom FROM Produit P , Categorie Ca, Commande Co, Ligne L WHERE Co.numero=L.commande and L.produit=P.reference and P.categorie=Ca.code and Saisie_le between ? and ? group by Ca.LIBELLE";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, dateDeb);
                        stmt.setString(2, dateFin);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int nb = rs.getInt("NB");
				String cate = rs.getString("nom");
				result.put(cate, nb);
			}
		}
		return result;
	}
        
//	/**     
//	 * Ajout d'un enregistrement dans la table DISCOUNT_CODE
//	 * @param code le code (non null)
//	 * @param rate le taux (positive or 0)
//	 * @return 1 si succès, 0 sinon
//	 * @throws SQLException renvoyées par JDBC
//	 */
//	public int addDiscountCode(String code, float rate) throws SQLException {
//		int result = 0;
//		String sql = "INSERT INTO DISCOUNT_CODE VALUES (?, ?)";
//		try (Connection connection = myDataSource.getConnection(); 
//		     PreparedStatement stmt = connection.prepareStatement(sql)) {
//			stmt.setString(1, code);
//			stmt.setFloat(2, rate);
//			result = stmt.executeUpdate();
//		}
//		return result;
//	}
//
//		
//	/**
//	 * Supprime un enregistrement dans la table DISCOUNT_CODE
//	 * @param code la clé de l'enregistrement à supprimer
//	 * @return le nombre d'enregistrements supprimés (1 ou 0)
//	 * @throws java.sql.SQLException renvoyées par JDBC
//	 **/
//	public int deleteDiscountCode(String code) throws SQLException {
//		int result = 0;
//		String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
//		try (Connection connection = myDataSource.getConnection(); 
//		     PreparedStatement stmt = connection.prepareStatement(sql)) {
//			stmt.setString(1, code);
//			result = stmt.executeUpdate();
//		}
//		return result;
//	}
        
}
