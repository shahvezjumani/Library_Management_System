
package JFrams;
import java.sql.*;

public class DBConnection {
    static Connection con = null;
    
    public static Connection getConnection(){
        try{
            	Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3306/LibraryManagement?characterEncoding=utf8";
                String username = "root";
                String password = "root";
                con = DriverManager.getConnection(url, username, password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
