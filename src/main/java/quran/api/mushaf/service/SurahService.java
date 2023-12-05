package quran.api.mushaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quran.api.mushaf.dto.SurahDto;
import quran.api.mushaf.entity.Surah;
import quran.api.mushaf.repository.SurahRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurahService {

    @Autowired
    SurahRepository repository;

    public List<SurahDto> getAll() {
        return repository.findAll().stream()
                .map(surah -> new SurahDto(surah.getId().intValue(), surah.getName(), surah.getPlace(), surah.getAyahs().size()))
                .collect(Collectors.toList());
    }

    public Surah getByName(String name) {
        return repository.findByName(name);
    }
}
