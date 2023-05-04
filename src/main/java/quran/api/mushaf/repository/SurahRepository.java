package quran.api.mushaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quran.api.mushaf.entity.Surah;

@Repository
public interface SurahRepository extends JpaRepository<Surah, Long> {
    Surah findByName(String name);
}
