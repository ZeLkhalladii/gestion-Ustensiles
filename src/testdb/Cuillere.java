package testdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cuillere extends Ustensile {
	private double longueur;
	
	public double calculerNombre() {
		return 0;
	}
	
	public String afficherCuilleres() {
		return "";
	}

	public double getLongueur() {
		return longueur;
	}
	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}
	
	public void affichierTousLesC() throws SQLException {
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		
		con = DbInfo.connDB();
		
		System.out.println("\n*************** les cuillier ***************\n");

		try {
			stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM `cuillere`";
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				StringBuilder sb = new StringBuilder();
				sb.append("id: " + rs.getInt("id") + "->");
				sb.append("date de fabriquation: " + rs.getInt("dateDeFabriquation") + "->");
				sb.append("prix: " + rs.getDouble("prix") + " MAD" + "->");
				sb.append("longueur: " + rs.getDouble("longueur") + " CM" + "\n");

				System.out.println(sb.toString());
			}

			rs.last();
			System.out.println(rs.getRow());
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(stat != null) {
				stat.close();
			}
			if(con != null) {
				con.close();
			}
		}
	}
}

