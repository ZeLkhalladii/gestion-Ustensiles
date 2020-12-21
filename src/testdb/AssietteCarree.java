package testdb;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;

public class AssietteCarree extends Assiette {
	private double cote;
	private double prix;

	public double getCote() {
		return cote;
	}

	public void setCote(double cote) {
		this.cote = cote;
	}
	
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double CalculerPrix() {
		int year = (Year.now().getValue()) - getYear();
		
		double valueAdedd;
		
		if(year > 50) {
			valueAdedd = year - 50;
			return getPrix() + valueAdedd * 5;
		}
		return getPrix();
	}
	
	public double CalculerSurface() {
		return getCote() * getCote();
	}
	
	public void affichierTousLesAC() throws SQLException {
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		
		con = DbInfo.connDB();
		
		System.out.println("\n*************** les assiette carrés ***************\n");
		
		try {
			
			stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM `assiettecarree`";
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				StringBuilder sb = new StringBuilder();
				sb.append("id: " + rs.getInt("id") + "->");
				sb.append("date de fabriquation: " + rs.getInt("dateDeFabriquation") + "->");
				sb.append("prix: " + rs.getDouble("prix") + " MAD" + "->");
				sb.append("cote: " + rs.getDouble("cote") + " CM" + "\n");

				System.out.println(sb.toString());
			}

			rs.last();
			System.out.println(rs.getRow());
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
}

