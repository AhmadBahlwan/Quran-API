package quran.api.mushaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import quran.api.mushaf.entity.Ayah;


@Repository
public interface AyahRepository extends JpaRepository<Ayah,Long> {

    @Query("SELECT ayah FROM Ayah ayah WHERE ayah.surah.name = :name AND ayah.number = :number ")
    Ayah findBySurahAndNumber(@Param("name") String name, @Param("number") Integer number);
}
