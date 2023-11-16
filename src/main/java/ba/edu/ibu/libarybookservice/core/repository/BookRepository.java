package ba.edu.ibu.libarybookservice.core.repository;

import ba.edu.ibu.libarybookservice.core.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    Optional<Book> findByTitle(String title);
}
