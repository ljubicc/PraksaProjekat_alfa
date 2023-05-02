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
		// objekte smestamo u listu osoba karakteri
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
		D.stampajPoruke();
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
		
		// osoba sa najpozitivnijom i najnegativnijom dispozicijom ----- 5. zadatak
		int maxRaspon = 0;
		int minRaspon = 0;
		Osoba najSrecnija = new Osoba();
		Osoba najTuznija = new Osoba();
		for (Osoba o : karakteri) {
			if (o.rasponDispozicije() > maxRaspon) {
				maxRaspon = o.rasponDispozicije();
				najSrecnija.setCharacter(o.getCharacter());
			} else if (o.rasponDispozicije() < minRaspon) {
				minRaspon = o.rasponDispozicije();
				najTuznija.setCharacter(o.getCharacter());
			}
		}
		System.out.println("Najpozitivniju dispoziciju ima : " + najSrecnija.getCharacter()
				+ "\nNajnegativniju dispoziciju ima: " + najTuznija.getCharacter());

		System.out.println();
		
		// Jon vise voli Daenerys ili Daenerys vise voli Jona ---------- 6. zadatak		
		if (J.prebrojLove() > D.prebrojLove())
			System.out.println("Jon vise voli Daenerys.");
		else if (J.prebrojLove() < D.prebrojLove())
			System.out.println("Daenerys vise voli Jona.");
		else
			System.out.println("Podjednako se vole");

	}
}
