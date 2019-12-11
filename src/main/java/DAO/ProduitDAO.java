package DAO;

import Entities.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;



public class ProduitDAO {

	private final DataSource myDataSource;

	/**
	 * Construit le AO avec sa source de données
	 * @param dataSource la source de données à utiliser
	 */
	public ProduitDAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
        public List<Produit> allProducts(){
            
            List<Produit> products = new ArrayList<Produit>();
            
            Produit p = new Produit("Produit1");
            Produit p2 = new Produit("Produit2");
            products.add(p);
            products.add(p);
            return products;
            //Tout les produit à recuperer 
            //A completer
        }

	       /**
         * 
         */
        public List<Produit> allProduit() throws SQLException{
            List<Produit> result = new LinkedList<>();

            String sql = "SELECT * FROM Produit";
            try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            int Reference = rs.getInt("Reference");
                            String Nom = rs.getString("Nom");
                            int Fournisseur = rs.getInt("Fournisseur");
                            int Categorie = rs.getInt("Categorie");
                            String Quantite_Par_Unite = rs.getString("Quantite_Par_Unite");
                            float Prix_unitaire = rs.getFloat("Prix_Unitaire");
                            int Unites_en_Stock = rs.getInt("Unites_en_Stock");
                            int Unites_commandees = rs.getInt("Unites_commandees");
                            int Niveau_de_reappro = rs.getInt("Niveau_de_reappro");
                            int Indisponible = rs.getInt("Indisponible");
                            Produit p = new Produit(Reference, Nom, Fournisseur, Categorie, Quantite_Par_Unite, Prix_unitaire, Unites_en_Stock, Unites_commandees, Niveau_de_reappro, Indisponible);
                            result.add(p);
			}
		}catch(SQLException e){
                    throw  e;
                }
            
		return result;
	}
        
        
        
        
        
        /**
	 * Produit en fonction de sa reference
	 * @return Produit
	 * @throws SQLException renvoyées par JDBC
	 */
	public Produit getProduit(int reference) throws SQLException {

		Produit result=null;

		String sql = "SELECT * FROM Produit WHERE reference=?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setInt(1, reference);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            String Nom = rs.getString("Nom");
                            int Fournisseur = rs.getInt("Fournisseur");
                            int Categorie = rs.getInt("Categorie");
                            String Quantite_Par_Unite = rs.getString("Quantite_Par_Unite");
                            float Prix_unitaire = rs.getFloat("Prix_Unitaire");
                            int Unites_en_Stock = rs.getInt("Unites_en_Stock");
                            int Unites_commandees = rs.getInt("Unites_commandees");
                            int Niveau_de_reappro = rs.getInt("Niveau_de_reappro");
                            int Indisponible = rs.getInt("Indisponible");
                            Produit p = new Produit(reference, Nom, Fournisseur, Categorie, Quantite_Par_Unite, Prix_unitaire, Unites_en_Stock, Unites_commandees, Niveau_de_reappro, Indisponible);
                            result = p;
			}
		} catch(Exception e){
                    throw e;
                }
		return result;
	}
        
        /**
	 * Produit en fonction de sa reference
	 * @return Produit
	 * @throws SQLException renvoyées par JDBC
	 */
	public Produit getProduitByName(String name) throws SQLException {

		Produit result=null;

		String sql = "SELECT * FROM Produit WHERE Nom=?";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                            int Reference = rs.getInt("Reference");
                            int Fournisseur = rs.getInt("Fournisseur");
                            int Categorie = rs.getInt("Categorie");
                            String Quantite_Par_Unite = rs.getString("Quantite_Par_Unite");
                            float Prix_unitaire = rs.getFloat("Prix_Unitaire");
                            int Unites_en_Stock = rs.getInt("Unites_en_Stock");
                            int Unites_commandees = rs.getInt("Unites_commandees");
                            int Niveau_de_reappro = rs.getInt("Niveau_de_reappro");
                            int Indisponible = rs.getInt("Indisponible");
                            Produit p = new Produit(Reference, name, Fournisseur, Categorie, Quantite_Par_Unite, Prix_unitaire, Unites_en_Stock, Unites_commandees, Niveau_de_reappro, Indisponible);
                            result = p;
			}
		} catch(Exception e){
                    throw e;
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
