//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//
//import static jm.task.core.jdbc.util.Util.getConnection;
//
//public class UserDaoJDBCImpl implements UserDao {
//
//    public UserDaoJDBCImpl() {
//
//    }
//    public void createUsersTable() {
//        try (Connection connection = getConnection();
//             Statement statement = connection.createStatement()) {
//            String query = "CREATE TABLE if not exists users (" +
//                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
//                    "name VARCHAR(45), " +
//                    "lastname VARCHAR(45), " +
//                    "age TINYINT)";
//            statement.execute(query);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public void dropUsersTable() {
//        String sql = " truncate users";//
//
//        try (Connection connection = getConnection();
//             Statement stmt = connection.createStatement()) {
//             stmt.executeUpdate(sql);
//        } catch (Exception  e) {
//            e.printStackTrace();
//        }
//    }
//
//    public  void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)";
//        try (Connection connection = getConnection();
//             PreparedStatement pstmt = connection.prepareStatement(sql)) {
//
//            pstmt.setString(1, name);
//            pstmt.setString(2, lastName);
//            pstmt.setByte(3, age);
//            pstmt.execute();
//            System.out.println("User  с именем " + name + " добавлен в базу данных");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {
//        String sql = "DELETE FROM users WHERE id = ?";
//
//        try (Connection connection = getConnection();
//             PreparedStatement pstmt = connection.prepareStatement(sql)) {
//            pstmt.setLong(1, id);
//            pstmt.executeUpdate();
//            System.out.println("User  с id == " +id+" удален из таблицы");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        User user = new User();
//        String sql = "SELECT * FROM users";
//        try (Connection connection = getConnection();
//             Statement stmt = connection.createStatement();){
//             ResultSet rs = stmt.executeQuery(sql) ;
//            while (rs.next()) {
//                user.setId(rs.getLong("id"));
//                user.setName(rs.getString("name"));
//                user.setLastName(rs.getString("lastname"));
//                user.setAge(rs.getByte("age"));
//                users.add(user);
//                System.out.println(users.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    public void cleanUsersTable() {
//        String sql = "DELETE FROM users";
//        try (Connection connection = getConnection();
//             Statement stmt = connection.createStatement()) {
//            stmt.executeUpdate(sql);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
