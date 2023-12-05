package quran.api.mushaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import quran.api.mushaf.dto.SurahDto;
import quran.api.mushaf.entity.Surah;

import java.util.List;

@Repository
public interface SurahRepository extends JpaRepository<Surah, Long> {
    Surah findByName(String name);

    List<Surah> findAll();
}
