package testdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);

		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;



		boolean Quit = false;
		
		int input;
		
		int selectedAssietOption;
		
		double Rayon;
		double Cote;
		double longueurC;
		
		int dateDeFabricationAR;
		int dateDeFabricationAC;
		int dateDeFabricationC;
		
		double prixAR;
		double prixAC;
		double prixC;
		
		int selectedAssietR;
		int selectedAssietC;
		int selectedCuiliere;

		con = DbInfo.connDB();
		
		Assiette assiette = new Assiette();

		AssietteRonde assietteRonde = new AssietteRonde();
		AssietteCarree assietteCarree = new AssietteCarree();
		Cuillere cuillere = new Cuillere();
		
		while(Quit == false) {
			System.out.println("1- Assiet");
			System.out.println("2- Cuillere");
			System.out.println("3- Quit");
			
			input = scanner.nextInt();
			switch(input) {
				case 1:
					System.out.println("1- AssietteRonde");
					System.out.println("2- AssietteCarre");
					System.out.println("3- Affichier tous les assiettes");
					System.out.println("4- anuuler");
					
					selectedAssietOption = scanner.nextInt();
					switch(selectedAssietOption) {
						case 1:
							System.out.println("1- affichier tous les AssietteRondes");
							System.out.println("2- enregistrer un nouveaux AssietteRondes");
							System.out.println("3- annuler");
							
							selectedAssietR = scanner.nextInt();
							switch(selectedAssietR) {
								case 1:
									assietteRonde.affichierTousLesAR();
								break;

								case 2:
									System.out.println("entre la date de fabrication");
									dateDeFabricationAR = scanner.nextInt();
									assietteRonde.setYear(dateDeFabricationAR);
									
									System.out.println("entre la valeur de rayon");
									Rayon = scanner.nextDouble();
									assietteRonde.setRayon(Rayon);
									
									System.out.println("entre le prix");
									prixAR = scanner.nextDouble();
									assietteRonde.setPrix(prixAR);
									

									try {
										String sql = "INSERT INTO `assietteronde`(`dateDeFabriquation`, `prix`, `rayon`, `surface`) VALUES (?, ?, ?, ?)";
										PreparedStatement ps = con.prepareStatement(sql);

										ps.setInt(1, assietteRonde.getYear());
										ps.setDouble(2, assietteRonde.CalculerPrix());
										ps.setDouble(3, Rayon);
										ps.setDouble(4, assietteRonde.CalculerSurface());
										ps.executeUpdate();
										assietteRonde.afficherSurfaceAssiettes();
										System.out.println("Assiette Ronde inserted !!!");

									} catch (SQLException e) {
										System.err.println(e);
									}
								break;
								
								case 3:
									
								break;
							}
							
						break;
						
						case 2:
							System.out.println("1- affichier tous les AssietteCarres");
							System.out.println("2- enregistrer un nouveaux AssietteCarre");
							System.out.println("3- annuler");
							
							selectedAssietC = scanner.nextInt();
							switch(selectedAssietC) {
								case 1:
									assietteCarree.affichierTousLesAC();
								break;
								
								case 2:
									System.out.println("entre la date de fabrication AssietteCarre");
									dateDeFabricationAC = scanner.nextInt();
									assietteCarree.setYear(dateDeFabricationAC);
									
									System.out.println("entre la valeur de cote");
									Cote = scanner.nextDouble();
									assietteCarree.setCote(Cote);
									
									System.out.println("entre le prix de AssietteCarre");
									prixAC = scanner.nextDouble();
									assietteCarree.setPrix(prixAC);
									
									
									try {
										String sql = "INSERT INTO `assiettecarree`(`dateDeFabriquation`, `prix`, `cote`, `surface`) VALUES (?, ?, ?, ?)";
										PreparedStatement ps = con.prepareStatement(sql);

										ps.setInt(1, assietteCarree.getYear());
										ps.setDouble(2, assietteCarree.CalculerPrix());
										ps.setDouble(3, Cote);
										ps.setDouble(4, assietteCarree.CalculerSurface());
										ps.executeUpdate();
										
										System.out.println("Assiette Carrés inserted !!!");

									} catch (SQLException e) {
										System.err.println(e);
									}
								break;
								
								case 3:
									
								break;
						}
							
						break;
						
						case 3:
							assiette.afficherSurfaceAssiettes();
						break;
						
						case 4:
							
						break;
					}
				break;
				
				case 2:
					System.out.println("1- affichier tous les cuilieres");
					System.out.println("2- enregistrer un nouveaux cuiliere");
					System.out.println("3- annuler");
					
					selectedCuiliere = scanner.nextInt();
					switch(selectedCuiliere) {
						case 1:
							cuillere.afficherCuilleres();
						break;
						
						case 2:
							System.out.println("entre la date de fabrication cuiliere");
							dateDeFabricationC = scanner.nextInt();
							cuillere.setYear(dateDeFabricationC);
							
							System.out.println("entre la valeur de longueur");
							longueurC = scanner.nextDouble();
							
							System.out.println("entre le prix de cuiliere");
							prixC = scanner.nextDouble();
							
							try {
								String sql = "INSERT INTO `cuillere`(`dateDeFabriquation`, `prix`, `longueur`) VALUES (?, ?, ?)";
								PreparedStatement ps = con.prepareStatement(sql);

								ps.setInt(1, cuillere.getYear());
								ps.setDouble(2, prixC);
								ps.setDouble(3, longueurC);
								ps.executeUpdate();
								System.out.println("Assiette Carrés inserted !!!");

							} catch (SQLException e) {
								System.err.println(e);
							}
						break;
						
						case 3:
							
						break;
				}
					
				break;
				
				case 3:
					System.out.println(";)");
					Quit = true;
				break;
			}
		}

	}
}



