package fr.polytech.repository;

import fr.polytech.business.Post;
import fr.polytech.repository.interfaces.PostRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JDBCPostRepository implements PostRepository {
    private DataSource database;

    public JDBCPostRepository(DataSource database) {
        this.database = database;
    }

    public void save(Post toPost) {
        try {
            Connection connection = this.database.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO posts(content) VALUES(?)");
            statement.setString(1, toPost.getContent());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Post> findAll() {
        List<Post> result = new ArrayList<Post>();

        try {
            Connection connection = this.database.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM posts");
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                result.add(new Post(set.getString("content")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
