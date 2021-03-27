import java.sql.*;

public class JDBC {
	//String propFileName = "BD.properties";
	//DatabaseAccessProperties db = new DatabaseAccessProperties(propFileName);

	static Connection con;
	static Statement statement;

	static final String databaseUrl = "jdbc:mysql://localhost:3306/projet";	//db.getDatabaseUrl();
	static final String databaseUsername = "root";								//db.getUsername();
	static final String databasePassword = "Nisso369";						//db.getPassword();

	Client loggedClient;
	
    public static void main(String[] args) throws SQLException {
		String query = "SELECT * FROM client";
		
		GUILogin guiClient = new GUILogin();
		guiClient.GUI();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
			statement = con.createStatement();

			// ResultSet result = statement.executeQuery(query);

			// while (result.next()) {
			//  	for(int i = 1; i <= 6; i++) {
			//  		System.out.println(result.getString(i));
			//  	}
			// }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

	public Client registerNewClient(String name, String lastName, String mail, String password, String postalAdr) {
		try {
			String sql = 	"INSERT INTO client (prenom, nom, adr_mail, mdp, adr_postale) "
						 +	"VALUES (?, ?, ?, ?, ?) ";
			
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, name);
			ps.setString(2, lastName);
			ps.setString(3, mail);
			ps.setString(4, password);
			ps.setString(5, postalAdr);
	
			ps.executeUpdate();

			loggedClient = loginClient(mail, password);
			return loggedClient;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Client loginClient(String mail, String password) {
		try {
			String sql = 	"SELECT * FROM client " +
							"WHERE adr_mail = ? AND mdp = ?";
	
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, mail);
			ps.setString(2, password);
			
			ResultSet result = ps.executeQuery();

			this.loggedClient = null;

			if (result.next()) {
				loggedClient = new Client(result.getInt("ID"), 
										  result.getString("prenom"), 
										  result.getString("nom"), 
										  result.getString("adr_mail"), 
										  result.getString("mdp"), 
										  result.getString("adr_postale"));
			}
			System.out.println("Client ID : " + loggedClient.ID());
			return loggedClient;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Client getLoggedClient() {
		return loggedClient;
	}
}
