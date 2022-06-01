package Assignments;
import java.sql.*;
import java.util.Scanner;

public class Lab6 {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

        try
        {    int choice=0;
            student s = new student();
            do
            {
                System.out.println("Select an operation \n 1- Registration \n 2- Password Update \n 3- Delete a Record \n 4- Search for a Student \n 5- Exit \n Enter your choice :");
                Scanner choicein = new Scanner(System.in);
                choice=choicein.nextInt();
                switch(choice)
                {
                    case 1:
                        s.getStudentDetails();
                        s.insertStudent();
                        break;
                    case 2:
                        s.updateStudentPassword();
                        break;
                    case 3:
                        s.deleteStudentRecord();
                        break;
                    case 4:
                        s.searchStudent();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Select the correct choice");
                }
            }while(choice!=5);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
class student
{
    private String name;
    private String password;
    private String country;
    private int mark;

    public void getStudentDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Name :");
        name = input.nextLine();
        System.out.println("Enter your password : ");
        password = input.nextLine();
        System.out.println("Enter your Country : ");
        country = input.nextLine();
        System.out.println("Enter the marks :");
        mark = input.nextInt();
    }

    public void insertStudent() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

        dbmsconnection dbmsconnect = new dbmsconnection("jdbc:mysql://localhost:3306/student","root","rootpassword");
        Connection con = dbmsconnect.getConnection();
        String sql = "insert into student values (?,?,?,?);";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, password);
        stmt.setString(3, country);
        stmt.setInt(4, mark);
        int i = stmt.executeUpdate();
        System.out.println("Record  inserted successfully");
        dbmsconnect.closeConnection(con, stmt);
    }

    public void updateStudentPassword() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        dbmsconnection dbmsconnect = new dbmsconnection("jdbc:mysql://localhost:3306/student","root","rootpassword");
        Connection con = dbmsconnect.getConnection();
        System.out.println("Enter Your Name");
        Scanner input = new Scanner(System.in);
        String inputname=input.nextLine();
        System.out.println("Enter the new Password");
        String inputpass=input.nextLine();
        String sql = "update student set password = ? where name = ?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, inputpass);
        stmt.setString(2, inputname);
        int i = stmt.executeUpdate();
        if(i>0)
        {
            System.out.println("Record updated sucessfully");
        }else
        {
            System.out.println("No Such record in the Database");
        }
        dbmsconnect.closeConnection(con, stmt);
    }


    public void deleteStudentRecord() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        dbmsconnection dbmsconnect = new dbmsconnection("jdbc:mysql://localhost:3306/student","root","rootpassword");
        Connection con = dbmsconnect.getConnection();
        System.out.println("Enter the Name of the Student");
        Scanner input = new Scanner(System.in);
        String inputname=input.nextLine();
        String sql = "delete from student where name = ?;";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, inputname);
        int i = stmt.executeUpdate();
        if(i>0)
        {
            System.out.println("Record Deleted Successfully");
        }
        else
        {
            System.out.println("No Such Record in the Database");
        }
        dbmsconnect.closeConnection(con, stmt);
    }

    public void searchStudent() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        dbmsconnection dbmsconnect = new dbmsconnection("jdbc:mysql://localhost:3306/student","root","rootpassword");
        Connection con = dbmsconnect.getConnection();
        System.out.println("Enter Your Name : ");
        Scanner input = new Scanner(System.in);
        String inputname=input.nextLine();
        String sql = "select * from student where name=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, inputname);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()==false)
        {
            System.out.println("No such record found in the database");
        }
        else
        {
            System.out.println("\n Name : " + rs.getString(1)+"\t Password : "+rs.getString(2)+"\t Country : "+rs.getString(3)+"\t Marks : " + rs.getInt(4));

        }
        dbmsconnect.closeConnection(con, stmt);
    }
}

class dbmsconnection
{
    String url;
    String username;
    String password;

    public dbmsconnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @SuppressWarnings("deprecation")
    public Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Connection con=null;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        con = DriverManager.getConnection(url,username,password);
        System.out.println("Connection Established Successfully");
        return con;
    }

    public void closeConnection(Connection con,Statement stmt) throws SQLException
    {
        stmt.close();
        con.close();
        System.out.println("The connection is closed");
    }
}

