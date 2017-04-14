package fr.polytech.business.services;

/**
 * Polytech Marseille
 * Case 925 - 163, avenue de Luminy
 * 13288 Marseille CEDEX 9
 * <p>
 * Ce fichier est l'oeuvre d'eleves de Polytech Marseille. Il ne peut etre
 * reproduit, utilise ou modifie sans l'avis express de ses auteurs.
 */

/**
 * @author Sudreau
 */

import fr.polytech.business.Post;
import fr.polytech.business.services.interfaces.PublicationService;
import fr.polytech.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {
    private PostRepository repository;

    @Autowired
    public PublicationServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    public void post(Post toPost) {
        this.repository.save(toPost);
    }

    @Override
    public Post getById(long id) {
        return this.repository.findOne(id);
    }

    public List<Post> fetchAll() {
        return this.repository.findAll();
    }
}
