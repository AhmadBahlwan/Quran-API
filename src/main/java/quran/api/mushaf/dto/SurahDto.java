package quran.api.mushaf.dto;

import quran.api.mushaf.entity.Surah;

public class SurahDto {

    private int surahNumber;
    private String name;
    private Surah.Type place;
    private int length;

    public SurahDto(int surahNumber, String name, Surah.Type place, int length) {
        this.surahNumber = surahNumber;
        this.name = name;
        this.place = place;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Surah.Type getPlace() {
        return place;
    }

    public void setPlace(Surah.Type place) {
        this.place = place;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSurahNumber() {
        return surahNumber;
    }

    public void setSurahNumber(int surahNumber) {
        this.surahNumber = surahNumber;
    }
}
