package praksa;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Osoba {
	
	private String character;
	private String allegiance;
	private List<String> messages_file;
	
	public Osoba() {
		
	}
	public Osoba(String character, String allegiance, String messages_file) {
		this.character = character;
		this.allegiance = allegiance;
		this.messages_file = FileHelper.loadMessages(messages_file);
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getAllegiance() {
		return allegiance;
	}

	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}

	public List<String> getMessages_file() {
		return messages_file;
	} 

	public void setMessages_file(List<String> messages_file) {
		this.messages_file = messages_file;
	}
	
	// broj poslatih poruka kataktera ------- 3. zadatak
	public int brojPoslatihPoruka() {		
		return messages_file.size() - 1;
	}
	
	//stampanje svih poruka osobe ---------  2. zadatak
	public void stampajPoruke() {

		Iterator<String> iter = messages_file.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	// metoda prebrojava i vraca broj srecnih smajlija
	public int prebrojHappy() {
		int broj = 0;
		Pattern pattern = Pattern.compile("[🙂😄😍]");
		for(String s : messages_file) {
			Matcher matcher = pattern.matcher(s);
			while(matcher.find()) {
				broj++;
			}
		}
		return broj;
	}
	
	// metoda prebrojava i vraca broj tuznih smajlija
	public int prebrojSad() {
		int broj = 0;
		Pattern pattern = Pattern.compile("[😭😢😞👿]");
		for(String s : messages_file) {
			Matcher matcher = pattern.matcher(s);
			while(matcher.find()) {
				broj++;
			}
		}
		return broj;
	}
	
	// metoda uporedjuje broj pozitivnih i broj negativnih smajlija i  
	// na osnovu toga vraca String podatak ------------ 4. zadatak
	public String dispozicija() {
		if(prebrojHappy() > prebrojSad())
			return "pozitivna dispozicija";
		else
			return "negativna dispozicija";
	}
	
	// razlika izmedju srecnih i tuznih smajlija osobe ( potrebno za odredjivanje naj + ili naj - dispozicije )
	public int rasponDispozicije() {
		return prebrojHappy() - prebrojSad();
	}
	
	// metoda prebrojava i vraca broj ljubavnih smajlija
	public int prebrojLove() {
		int broj = 0;
		Pattern pattern = Pattern.compile("[😍😘]");
		for(String s : messages_file) {
			Matcher matcher = pattern.matcher(s);
			while(matcher.find()) {
				broj++;
			}
		}
		return broj;
	}
	
	public void ispisi() {
		System.out.println("Ime: " + character + "\nPripadnost: " + allegiance + "\nPoruke: ");
		stampajPoruke();
	}

}




