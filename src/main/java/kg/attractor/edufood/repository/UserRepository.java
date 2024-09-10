package kg.attractor.edufood.repository;

import kg.attractor.edufood.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
    Optional<User> findByEmail(String email);

//    @Query("SELECT u FROM User u JOIN RespondedApplicant ra ON u.id = ra.resumeId WHERE ra.vacancyId = :vacancyId")
//    List<User> findUsersRespondedToVacancy(@Param("vacancyId") Integer vacancyId);
}
