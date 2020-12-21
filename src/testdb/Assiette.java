package testdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Assiette extends Ustensile {
	public double calculerSomme;
	public double calculerSommeAR;
	public double calculerSommeAC;

	public double getCalculerSommeAR() {
		return calculerSommeAR;
	}

	public void setCalculerSommeAR(double calculerSommeAR) {
		this.calculerSommeAR = calculerSommeAR;
	}

	public double getCalculerSommeAC() {
		return calculerSommeAC;
	}

	public void setCalculerSommeAC(double calculerSommeAC) {
		this.calculerSommeAC = calculerSommeAC;
	}
	
	public double getCalculerSomme() {
		return getCalculerSommeAR() + getCalculerSommeAC();
	}

	public void afficherSurfaceAssiettes() throws SQLException {
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;

		Statement stat2 = null;
		ResultSet rs2 = null;
		
		Statement stat3 = null;
		ResultSet rs3 = null;
		
		Statement stat4 = null;
		ResultSet rs4 = null;
		
		con = DbInfo.connDB();
		
		try {
			stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//String sql2 = "SELECT sum(surface) FROM `assietteronde`";

			String sql = "SELECT * FROM `assietteronde`";
			rs = stat.executeQuery(sql);
			
			System.out.println("\n*************** les assiette roundes ***************\n");
			
			while(rs.next()) {
				StringBuilder sb = new StringBuilder();
				sb.append("id: " + rs.getInt("id") + "->");
				sb.append("date de fabriquation: " + rs.getInt("dateDeFabriquation") + "->");
				sb.append("prix: " + rs.getDouble("prix") + " MAD" + "->");
				sb.append("rayon: " + rs.getDouble("rayon") + " CM" + "\n");
				sb.append("surface: " + rs.getDouble("surface") + " CM" + "\n");

				System.out.println(sb.toString());
			}

			rs.last();
			System.out.println("nombres des assiettes roundes: " + rs.getRow());
		} catch (SQLException e) {
			System.err.println(e);
		}
		
		/* -------------------------------------------------------------------------------------------------------- */
		
		try {
			stat2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql2 = "SELECT * FROM `assiettecarree`";
			rs2 = stat2.executeQuery(sql2);
			
			System.out.println("\n*************** les assiette carreés ***************\n");
			
			while(rs2.next()) {
				StringBuilder sb2 = new StringBuilder();
				
				sb2.append("id: " + rs2.getInt("id") + "->");
				sb2.append("date de fabriquation: " + rs2.getInt("dateDeFabriquation") + "->");
				sb2.append("prix: " + rs2.getDouble("prix") + " MAD" + "->");
				sb2.append("cote: " + rs2.getDouble("cote") + " CM" + "\n");
				sb2.append("surface: " + rs2.getDouble("surface") + " CM" + "\n");

				System.out.println(sb2.toString());
			}

			rs2.last();
			System.out.println("nombres des assiettes carrés: " + rs2.getRow());
		} catch (SQLException e) {
			System.err.println(e);
		}
		
		/* -------------------------------------------------------------------------------------------------------- */
		
		try {
			stat3 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql3 = "SELECT sum(surface) FROM `assietteronde`";
			rs3 = stat3.executeQuery(sql3);
			
			System.out.println("\n*************** totale prix des assiette roundes ***************");
			while(rs3.next()) {
				int num1 = rs3.getInt(1);
				
				this.calculerSommeAR += this.calculerSommeAR +num1;
			}
			
			System.out.println(this.calculerSommeAR + " MAD");
			setCalculerSommeAR(this.calculerSommeAR);

		} catch (SQLException e) {
			System.err.println(e);
		}
		
		/* -------------------------------------------------------------------------------------------------------- */
		
		try {
			stat4 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql4 = "SELECT sum(surface) FROM `assiettecarree`";
			rs4 = stat4.executeQuery(sql4);
			
			System.out.println("\n*************** totale prix des assiette carres ***************");
			while(rs4.next()) {
				int num2 = rs4.getInt(1);
				
				this.calculerSommeAC += this.calculerSommeAC +num2;
			}
			
			System.out.println(this.calculerSommeAC + " MAD");
			setCalculerSommeAC(this.calculerSommeAC);

		} catch (SQLException e) {
			System.err.println(e);
		}
		
		/* -------------------------------------------------------------------------------------------------------- */
		System.out.println("\n*************** totale prix des assiettes ***************");
		System.out.println(getCalculerSomme() + " MAD");
	}
}