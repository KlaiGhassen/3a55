package Services;

import Models.User;
import Utils.MyDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService implements ICrud<User> {
    private Connection con;

    public UserService() {
        this.con = MyDb.getInstance().getConnection();
    }

    @Override
    public void insert(User obj) throws SQLException {
        String sql = "INSERT INTO user(firstName,lastName,age) VALUES('" + obj.getFirstName() + "','" + obj.getLastName() + "','" + obj.getAge() + "')";
        Statement stmt = this.con.createStatement();
        stmt.executeUpdate(sql);
    }

    @Override
    public void update(User obj) throws SQLException {
        String sql = "UPDATE SET user VALUES('" + obj.getFirstName() + "','" + obj.getLastName() + "','" + obj.getAge() + "' where id = '" + obj.getId() + "'";
        Statement stmt = this.con.createStatement();
        stmt.executeUpdate(sql);
    }

    @Override
    public void delete(User obj) throws SQLException {
        String sql = "DELETE FROM user WHERE id = '" + obj.getId() + "'";
        Statement stmt = this.con.createStatement();
        stmt.executeUpdate(sql);
    }

    @Override
    public List<User> findAll() throws SQLException {
        String sql = "SELECT * FROM user";
        Statement stmt = this.con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<User> list = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString("lastName"));
            user.setAge(rs.getInt("age"));
            list.add(user);
        }

        return list;
    }
}
