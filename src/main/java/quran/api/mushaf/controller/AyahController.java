package quran.api.mushaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quran.api.mushaf.repository.AyahRepository;

@RestController
@RequestMapping("/ayah")
public class AyahController {

    @Autowired
    AyahRepository ayahRepository;

    @GetMapping("/{surahName}")
    public ResponseEntity<?> getAyah(@PathVariable("surahName") String name, @RequestParam("number") Integer number){
        return ResponseEntity.ok(ayahRepository.findBySurahAndNumber(name,number));
    }
}
