package quran.api.mushaf.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Surah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Type place;

    @OneToMany(mappedBy = "surah")
    @OrderBy("number ASC")
    List<Ayah> ayahs;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getPlace() {
        return place;
    }

    public void setPlace(Type place) {
        this.place = place;
    }

    public List<Ayah> getAyahs() {
        return ayahs;
    }

    public void setAyahs(List<Ayah> ayahs) {
        this.ayahs = ayahs;
    }


    public enum Type{
        MEKKA("مكية"), MADINA("مدنية");
        private String label;

        private Type(String label){
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }
}
