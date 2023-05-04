package quran.api.mushaf.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Ayah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer number;

    @Column(columnDefinition = "varchar(3000)")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Surah surah;


    public Ayah() {
    }

    public Ayah(Integer number, String content, Surah surah) {
        this.number = number;
        this.content = content;
        this.surah = surah;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Surah getSurah() {
        return surah;
    }

    public void setSurah(Surah surah) {
        this.surah = surah;
    }
}
