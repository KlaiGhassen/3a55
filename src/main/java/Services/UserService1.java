package Services;

import Models.User;
import Utils.MyDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService1 implements ICrud<User> {
    private Connection con;

    public UserService1() {
        this.con = MyDb.getInstance().getConnection();
    }


    @Override
    public void insert(User obj) throws SQLException {
        String sql = "INSERT INTO user(firstName,lastName,age) VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(3, obj.getAge());
        ps.setString(1, obj.getFirstName());
        ps.setString(2, obj.getLastName());
        ps.executeUpdate();
    }

    @Override
    public void update(User obj) throws SQLException {
        String sql = "UPDATE user SET firstName=?,lastName=?,age=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, obj.getFirstName());
        ps.setString(2, obj.getLastName());
        ps.setInt(3, obj.getAge());
        ps.setInt(4, obj.getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(User obj) throws SQLException {

        String sql = "DELETE FROM user WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, obj.getId());
        ps.executeUpdate();

    }

    @Override
    public List<User> findAll() throws SQLException {
        String sql = "SELECT * FROM user";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<User> list = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setAge(rs.getInt("age"));
            list.add(user);
        }
        return list;
    }
}
