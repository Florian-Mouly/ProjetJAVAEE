package DAO;

import Entities.Client;
import Entities.Product;
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
        
        public List<Product> allProducts(){
            
            List<Product> products = new ArrayList<Product>();
            
            Product p = new Product("Produit1");
            Product p2 = new Product("Produit2");
            products.add(p);
            products.add(p);
            return products;
            //Tout les produit à recuperer 
            //A completer
        }

	       /**
         * 
         */
        public List<Product> allProduit() throws SQLException{
            List<Product> result = new LinkedList<>();
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
                            int Unite_en_Stock = rs.getInt("Unite_en_Stock");
                            int Unite_commandees = rs.getInt("Unites_commandees");
                            int Niveau_de_rea = rs.getInt("Niveau_de_rea");
                            int Indisponible = rs.getInt("Indisponible");
                            Product p = new Product(Reference, Nom, Fournisseur, Categorie, Quantite_Par_Unite, Prix_unitaire, Unite_en_Stock, Unite_commandees, Niveau_de_rea, Indisponible);
                            result.add(p);
			}
		}
		return result;
	}
        
        
        
        
        
        /**
	 * Produit en fonction de sa reference
	 * @return Product
	 * @throws SQLException renvoyées par JDBC
	 */
	public Product getProduit(int reference) throws SQLException {

		Product result=null;

		String sql = "SELECT * FROM Product WHERE reference=?";
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
                            int Unite_en_Stock = rs.getInt("Unite_en_Stock");
                            int Unite_commandees = rs.getInt("Unites_commandees");
                            int Niveau_de_rea = rs.getInt("Niveau_de_rea");
                            int Indisponible = rs.getInt("Indisponible");
                            Product p = new Product(reference, Nom, Fournisseur, Categorie, Quantite_Par_Unite, Prix_unitaire, Unite_en_Stock, Unite_commandees, Niveau_de_rea, Indisponible);
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
