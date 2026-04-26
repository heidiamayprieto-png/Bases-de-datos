package series ;
import java . sql .*;

public class ConnectionManager{
	private String user;
	private String password;
	private String url;
	
	public ConnectionManager (String user , String password) { 
		this.user = user;
		this.password = password;
		this.url = "jdbc:mysql://localhost:3306/series";
	}

	public String url(){ 
		return this.url;
	}

	public String runTask ( DataBaseTask [] tasks , String [] dataArray ) { 
		Connection conn;
		try {
			conn = DriverManager.getConnection(url,user,password); 
			for (int i = 0; i < tasks.length; i++) 
                tasks[i].run(conn, dataArray[i]);
            conn.close();
            return "OK";
        } catch (SQLException e) {
            return "SQL:" + e.getMessage();
        } catch (SeriesException e) {
        	return "Task:" + e.when() + "\t" + e.getMessage();
        }catch (Exception e) {
            return "Otro:" + e.getMessage();
        } 
      
	}
     
}