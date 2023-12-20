import java.sql.*;
public class Main {
    public static void getAlldetails(Connection c) throws SQLException {
        PreparedStatement p=c.prepareStatement("select * from Student");
        ResultSet rs= p.executeQuery();
        while(rs.next()){
            System.out.println("id: "+rs.getInt(1)+"name: "+rs.getString(2));
        }
        c.close();
    }

    public static void main(String[] args) throws SQLException {
        String url="jdbc:postgresql://localhost:5432/demo";
        String username="postgres";
        String password="Dhanush@20";
        Connection c=DriverManager.getConnection(url,username,password);
        System.out.println(c);
        PreparedStatement p= c.prepareStatement("insert into student values (?,?)");
        p.setInt(1,3);
        p.setString(2,"ramki");
        p.executeUpdate();
//        c.close();
        getAlldetails(c);
    }
}