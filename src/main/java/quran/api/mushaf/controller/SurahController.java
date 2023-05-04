package quran.api.mushaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quran.api.mushaf.entity.Surah;
import quran.api.mushaf.repository.AyahRepository;
import quran.api.mushaf.repository.SurahRepository;

@RestController
@RequestMapping("/surah")
public class SurahController {

    @Autowired
    SurahRepository surahRepository;

    @GetMapping("/{name}")
    public ResponseEntity<?> getSurah(@PathVariable("name") String name){
        return ResponseEntity.ok(surahRepository.findByName(name));
    }
}
