package Classes;
import java.sql.*;
public class RoomClass {
    static Connection c;
    static Statement ss;
    static String query;
    static Connect t = new Connect();
    
    public static void Change_Data(int Room_ID ,String tybeOFInfo ,String NewInfo)
    {      
        try {
            c=t.setconnect();
            ss=c.createStatement();
            query="update room set "+tybeOFInfo+ " = "+NewInfo+" where Room_ID= "+Room_ID+" ";
            ss.execute(query);
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
                finally {
            try {
                c.close();
                ss.close();
            }              
            catch(SQLException ee) {
                System.out.println(ee.getMessage());
            }
        }
    }    
    public static void Add_Room(int Room_ID,String Tybe_Of_Room  ,int floor )
    {
        try {
            c=t.setconnect();
            ss=c.createStatement();
            query="insert into room values ('"+Room_ID+"','"+ floor+"','"+Tybe_Of_Room+"')";
            ss.execute(query);
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
                finally {
            try {
                c.close();
                ss.close();
            }              
            catch(SQLException ee) {
                System.out.println(ee.getMessage());
            }
        }
    }

    public static void Delete_Room(int SSN)
    {
        try {
            c=t.setconnect();
            ss=c.createStatement();
            query="delete from room where Room_ID ="+SSN+"";
            ss.execute(query);
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
                finally {
            try {
                c.close();
                ss.close();
            }              
            catch(SQLException ee) {
                System.out.println(ee.getMessage());
            }
        }
    }        
}
