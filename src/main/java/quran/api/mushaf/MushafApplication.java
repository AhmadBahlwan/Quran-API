package quran.api.mushaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import quran.api.mushaf.entity.Ayah;
import quran.api.mushaf.entity.Surah;
import quran.api.mushaf.repository.AyahRepository;
import quran.api.mushaf.repository.SurahRepository;

import javax.annotation.PostConstruct;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@SpringBootApplication
public class MushafApplication {

	public static void main(String[] args) {
		SpringApplication.run(MushafApplication.class, args);
	}

	@Autowired
	SurahRepository surahRepository;
	@Autowired
	AyahRepository ayahRepository;
	//@PostConstruct
	private void initSurah() throws IOException {
		List<String> arabicNumbers = Arrays.asList("٠","١","٢","٣ "," ٤"," ٥"," ٦","٧"," ٨","٩");
		String path = "C:\\Users\\HP\\Desktop\\quran.txt";
		String []arr = getFileContent(path).split("\n");
		AtomicLong surahIndex = new AtomicLong(1);
		for (int i=1;i<arr.length;i+=5){
			AtomicInteger ayahIndex = new AtomicInteger(1);
			Arrays.stream(arr[i].split("\\([0-9]+[0-9]*[0-9]*\\)"))
					.filter(item->!item.isBlank())
					.map(String::trim)
					.forEach(item->{
						Ayah ayah = new Ayah(ayahIndex.getAndIncrement(),item,surahRepository.findById(surahIndex.get()).get());
						ayahRepository.save(ayah);
					});
			surahIndex.incrementAndGet();
		}

//		Arrays.asList(splitByWord(path,"سورة"))
//				.stream()
//				.filter(word->!arabicNumbers.contains(word.trim()))
//				.forEach(word-> {
//					Surah surah = new Surah();
//					word = word.trim().substring(0,word.length()-4);
//					if (word.contains("١"))
//						word = word.substring(0,word.length()-1);
//					surah.setName(word.trim());
//					repository.save(surah);
//				});


	}
	@PostConstruct
	public void initializeSurahPlaces(){
		String textInfo = "البقرة-آل عمران-النساء-المائدة-الأنفال-التوبة-النور-الأحزاب-محمد-الفتح-الحجرات-الحديد-المجادلة-الحشر-الممتحنة-الصف-الجمعة-المنافقون-التغابن-الطلاق-التحريم-النصر";
		String text2Info = "الرعد-الحج-الرحمن-الإنسان-البينة-الزلزلة";
		List<String> names = Arrays.asList(text2Info.split("-"));
		surahRepository.findAll().stream().filter(surah->surah.getPlace() == null)
				.forEach(surah->{
					surah.setPlace(Surah.Type.MEKKA);
					surahRepository.save(surah);
				});
	}


	public static String getFileContent(String path) throws IOException {
		DataInputStream reader = new DataInputStream(new FileInputStream(path));
		int nBytesToRead = reader.available();
		if (nBytesToRead > 0) {
			byte[] bytes = new byte[nBytesToRead];
			reader.read(bytes);
			return new String(bytes);
		}
		return "";
	}

	public static String[] splitByWord(String path, String word) throws IOException {
		String content = getFileContent(path);
		return content.split(word);
	}


}
