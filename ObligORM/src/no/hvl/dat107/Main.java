package no.hvl.dat107;

import java.util.List;

public class Main {

	static final String JDBC_DRIVER = "org.postgresql.Driver";

	static final String DB_URL = "jdbc:postgresql://129.151.221.119:5432/675218";
	static final String USER = "675218";
	static final String PASS = "Ha1FinDagIDag!";

	public static void main(String[] args) {

		// Søk i databasen etter ansatte med kun ID
		AnsattDAO ansattDAO1 = new AnsattDAO();
		int ansattId = 1; // Eksempel på Frikk
		Ansatt ansatt = ansattDAO1.finnAnsattMedId(ansattId);
		if (ansatt != null) {
			System.out.println(ansatt.toString());
		} else {
			System.out.println("Fant ikke ansatt med ID: " + ansattId);
		}

		AnsattDAO ansattDAO2 = new AnsattDAO();
		ansattId = 2; // eksempel på Mats
		Ansatt ansatt2 = ansattDAO2.finnAnsattMedId(ansattId);
		if (ansatt != null) {
			System.out.println(ansatt2.toString());
		} else {
			System.out.println("Fant ikke ansatt med ID: " + ansattId);
		}

		AnsattDAO ansattDAO3 = new AnsattDAO();
		ansattId = 3; // eksempel på Mats
		Ansatt ansatt3 = ansattDAO3.finnAnsattMedId(ansattId);
		if (ansatt != null) {
			System.out.println(ansatt3.toString());
		} else {
			System.out.println("Fant ikke ansatt med ID: " + ansattId);
		}
		System.out.println("");

		// Søk i databasen etter ansatte ved kun brukernavn
		AnsattDAO ansattDAO4 = new AnsattDAO();
		String brukernavn = "slaasletten"; // Eksempel på brukernavnet til frikk
		Ansatt ansatt4 = ansattDAO4.finnAnsattMedBrukernavn(brukernavn);
		if (ansatt != null) {
			System.out.println(ansatt4.toString());
		} else {
			System.out.println("Fant ikke ansatt med brukernavn: " + brukernavn);
		}
		System.out.println("");

		// Søk i databasen etter alle ansatte
		AnsattDAO ansattDAO5 = new AnsattDAO();
		List<Ansatt> ansatte = ansattDAO5.listAlleAnsatte();
		for (Ansatt ans : ansatte) {
			System.out.println(ans.toString());
		}
		System.out.println("");

		// Oppdatere stilling og lønn
		AnsattDAO ansattDAO6 = new AnsattDAO();
		ansattId = 1; // Eksempel på ansatt Frikk
		String nyStilling = "C/O";
		java.math.BigDecimal nyLonn = new java.math.BigDecimal("290000.00");
		ansattDAO6.oppdaterAnsattStillingOgLonn(ansattId, nyStilling, nyLonn);

		System.out.println("");

		// legge til en ny ansatt i databasen
		AnsattDAO ansattDAO7 = new AnsattDAO();
		Ansatt nyAnsatt = new Ansatt(4, "Jenny", "Seeberg", "JSeeberg", new java.util.Date(), "Utvikler",new java.math.BigDecimal("50000.00"), 1);
		ansattDAO7.leggTilNyAnsatt(nyAnsatt);

	}
}
