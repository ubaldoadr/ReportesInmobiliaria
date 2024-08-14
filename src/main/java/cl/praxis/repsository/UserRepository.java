package cl.praxis.repsository;



import cl.praxis.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByUsername(String username);
  // List<User> findByFirstNameAndLastName(String firstName, String lastName);
}
