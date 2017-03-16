package fr.polytech.repository.interfaces;

import fr.polytech.business.Post;

import java.util.List;

public interface PostRepository {

    void save(Post toPost);

    List<Post> findAll();
}
