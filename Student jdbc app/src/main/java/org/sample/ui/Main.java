package org.sample.ui;

import java.sql.*;
import java.util.*;
public class Main {
    public static void addstudent(Scanner sc) throws SQLException {
        System.out.println("enter id: ");
        int id=sc.nextInt();
        System.out.println("enter name: ");
        String name=sc.next();
        System.out.println("enter marks: ");
        int marks=sc.nextInt();
        Student s=new Student(id,name,marks);
        Connection conn= DBUtils.connectToDatabase();
        PreparedStatement ps=conn.prepareStatement("insert into student values (?,?,?)");
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setInt(3,marks);
        ps.executeUpdate();
        DBUtils.closeConnection(conn);
        System.out.println("Student was added successfully");
    }

    public static void updatestudent(Scanner sc) throws SQLException, NoSuchMethodException {
        Connection conn= DBUtils.connectToDatabase();
        System.out.println("enter id: ");
        int id=sc.nextInt();
        PreparedStatement ps1=conn.prepareStatement("select * from student where id=?");
        ps1.setInt(1,id);
        ResultSet rs= ps1.executeQuery();
        if(DBUtils.isResultSetEmpty(rs)){
            throw new NoSuchMethodException("enter valid id");
        }
        else{
            System.out.println("enter marks: ");
            int marks=sc.nextInt();
//            Student s=new Student(id,name,marks);
            PreparedStatement ps=conn.prepareStatement("update student set marks=? where id=?");
            ps.setInt(1,marks);
            ps.setInt(2,id);
            ps.executeUpdate();
            DBUtils.closeConnection(conn);
            System.out.println("Student was updated successfully");
        }

    }

    public static void getbystudentid(Scanner sc) throws SQLException, NoSuchMethodException {
        Connection conn= DBUtils.connectToDatabase();
        System.out.println("enter id: ");
        int id=sc.nextInt();
        PreparedStatement ps1=conn.prepareStatement("select * from student where id=?");
        ps1.setInt(1,id);
        ResultSet rs= ps1.executeQuery();
        if(DBUtils.isResultSetEmpty(rs)){
            throw new NoSuchMethodException("enter valid id");
        }
        else{
            while (rs.next()){
                System.out.println("id: "+rs.getInt(1)+" name: "+rs.getString(2)+" marks: "+rs.getInt(3));
            }
        }

    }

    public static void deletestudent(Scanner sc) throws SQLException, NoSuchMethodException {
        Connection conn= DBUtils.connectToDatabase();
        System.out.println("enter id: ");
        int id=sc.nextInt();
        PreparedStatement ps1=conn.prepareStatement("select * from student where id=?");
        ps1.setInt(1,id);
        ResultSet rs= ps1.executeQuery();
        if(DBUtils.isResultSetEmpty(rs)){
            throw new NoSuchMethodException("enter valid id");
        }
        else{
//            Student s=new Student(id,name,marks);
            PreparedStatement ps=conn.prepareStatement("delete from student where id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
            DBUtils.closeConnection(conn);
            System.out.println("Student was deleted successfully");
        }

    }

    public static void getallstudent(Scanner sc) throws SQLException, NoSuchMethodException {
        Connection conn= DBUtils.connectToDatabase();
        PreparedStatement ps1=conn.prepareStatement("select * from student");
        ResultSet rs= ps1.executeQuery();
        if(DBUtils.isResultSetEmpty(rs)){
            throw new NoSuchMethodException("there is no student");
        }
        else{
            while (rs.next()){
                System.out.println("id: "+rs.getInt(1)+" name: "+rs.getString(2)+" marks: "+rs.getInt(3));
            }
        }

    }

    public static void main(String[] args) throws SQLException, NoSuchMethodException {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println(
                    "+----------------------+"+"\n"
                    +"| 1. Add student       |"+"\n"
                    +"| 2. GetByID student    |"+"\n"
                    +"| 3. GetAll student    |"+"\n"
                    +"| 4. Update student    |"+"\n"
                    +"| 5. Delete student    |"+"\n"
                    +"| 0. Exit              |"+"\n"
                    +"+----------------------+");

            choice = sc.nextInt();
            switch(choice) {
                case 0:
                    System.out.println("Thank you, Visit again");
                    break;
                case 1:
                    addstudent(sc);
                    break;
                case 2:
                    getbystudentid(sc);
                    break;
                case 3:
                    getallstudent(sc);
                    break;
                case 4:
                    updatestudent(sc);
                    break;
                case 5:
                    deletestudent(sc);
                    break;
                default:
                    System.out.println("Invalid Selection, try again");
            }
        }while(choice != 0);
        sc.close();
    }
}