package fr.polytech.business.interfaces;

import fr.polytech.business.Post;

import java.util.List;

public interface PublicationService {
    void post(Post toPost);

    List<Post> fetchAll();
}
