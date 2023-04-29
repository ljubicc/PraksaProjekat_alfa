package praksa;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {

		// od fajla "got_meta_data.txt" pravimo listu stringova listMetaData
		List<String> listMetaData = FileHelper.loadListString();

		// inicijalizujemo listu osoba karakteri
		List<Osoba> karakteri = new ArrayList<>();

		// prolazimo kroz listu stringova listMetaData,
		// splitujemo , pravimo objekte na osnovu tekstualnog fajla i
		// objekte smestamo u listu karakteri
		for (int i = 1; i < listMetaData.size(); i++) {
			String[] s = listMetaData.get(i).split(", ");
			Osoba o = new Osoba(s[0], s[1], s[2]);
			karakteri.add(o);
		}

		Osoba D = karakteri.get(0);
		Osoba J = karakteri.get(1);
		Osoba T = karakteri.get(2);
		Osoba C = karakteri.get(3);

		// stampaj sve poruke osobe Daeneryes ------- 2. zadatak
		for (Osoba o : karakteri) {
			if (o.equals(D))
				o.ispisi();
		}
		System.out.println();
		
		// broj poruka koje je svaki karakter poslao ----------- 3. zadatak
		for (Osoba o : karakteri) {
			System.out.println("Karakter: " + o.getCharacter() + " Broj poslatih poruka: " + o.brojPoslatihPoruka());
		}
		System.out.println();
		
		// metoda odredjuje dispiziciju osobe -------------- 4. zadatak
		for (Osoba o : karakteri) {
			System.out.println(o.getCharacter() + " - " + o.dispozicija());
		}
		System.out.println();
		
		// osoba sa najpozitivnijom i najnegativnijom dispozicijom (mozda staviti ovaj deo u metodu) ----- 5. zadatak
		int maxRaspon = 0;
		int minRaspon = 0;
		Osoba najS = new Osoba();
		Osoba najT = new Osoba();
		for (Osoba o : karakteri) {
			if (o.rasponDispozicije() > maxRaspon) {
				maxRaspon = o.rasponDispozicije();
				najS.setCharacter(o.getCharacter());
			} else if (o.rasponDispozicije() < minRaspon) {
				minRaspon = o.rasponDispozicije();
				najT.setCharacter(o.getCharacter());
			}
		}
		System.out.println("Najpozitivniju dispoziciju ima : " + najS.getCharacter()
				+ "\nNajnegativniju dispoziciju ima: " + najT.getCharacter());

		System.out.println();
		
		// Jon vise voli Daenerys ili Daenerys vise voli Jona (i ovo je za posebnu metodu) ---------- 6. zadatak
		int johnLove = 0;
		int danyLove = 0;
		for (Osoba o : karakteri) {
			if (o.getCharacter().equals(J.getCharacter())) {
				johnLove = o.prebrojLove();
			}
			if (o.getCharacter().equals(D.getCharacter())) {
				danyLove = o.prebrojLove();
			}
		}
		if (johnLove > danyLove)
			System.out.println("Jon vise voli Daenerys.");
		else if (johnLove < danyLove)
			System.out.println("Daenerys vise voli Jona.");
		else
			System.out.println("Podjednako se vole");

	}
}
