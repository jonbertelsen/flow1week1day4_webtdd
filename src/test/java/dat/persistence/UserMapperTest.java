package dat.persistence;

import dat.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest
{
    Connection con;
    UserMapper userMapper;

    UserMapperTest() throws SQLException, ClassNotFoundException
    {
        con = DBConnector.getConnection();
        userMapper = new UserMapper();
    }

    @BeforeEach
    void setUp() {
        System.out.println("TESTINNNNGGGG");
        try {
            String createTable = "CREATE TABLE IF NOT EXISTS `startcode_test`.`usertable` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `fname` VARCHAR(45) NULL,\n" +
                    "  `lname` VARCHAR(45) NULL,\n" +
                    "  `pw` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            con.prepareStatement(createTable).executeUpdate();
            con.prepareStatement("DELETE FROM `startcode_test`.`usertable`").executeUpdate();
            String SQL = "INSERT INTO startcode_test.usertable (fname, lname, pw, phone, address) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Hans");
            ps.setString(2, "Hansen");
            ps.setString(3, "Hemmelig123");
            ps.setString(4, "40404040");
            ps.setString(5,"Rolighedsvej 3");
            ps.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    void getUsers() throws SQLException
    {
        int expected = 1;
        List<User> userList = userMapper.getUsers();
        int actual = userList.size();
        assertEquals(expected, actual);
        String expectedName = "Hans";
        String actualName = userList.get(0).getFname();
        assertEquals(expectedName, actualName);
    }
}