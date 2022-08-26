package dat.persistence;

import dat.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper
{
    Connection connection;

    public UserMapper() throws SQLException, ClassNotFoundException
    {
        this.connection = DBConnector.getConnection();
    }

    public List<User> getUsers() throws SQLException
    {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM usertable";

        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String pw = rs.getString("pw");
                userList.add(new User(1, fname, lname, pw));
            }
        }
        catch (SQLException ex)
        {
            throw new SQLException("Fejl i DB query: " + ex.getMessage());
        }
        return userList;
    }

}
