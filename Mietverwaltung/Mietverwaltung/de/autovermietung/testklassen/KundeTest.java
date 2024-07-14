package Testklassen;

import fachklassen.Kunde;

public class KundeTest {
    
    @VertragTest
    public void testKundeCreation() {
        Kunde kunde = new Kunde("Max", "Mustermann", "01.01.1990", 31, 123456, 12345678, "B", "max.mustermann@example.com", "EC-Karte", "Keine besonderen Vorkommnisse", "Musterstraße", 1, 12345, "Musterstadt", true, 10, "max123", "passwortMax");
        
        assertNotNull(kunde);
    }

    private void assertNotNull(Kunde kunde) {
        // wird fehler ausgeben wenn Kunde 0 ist 
        throw new UnsupportedOperationException("Unimplemented method 'assertNotNull'");
    }

    @VertragTest
    public void testGettersAndSetters() {
        Kunde kunde = new Kunde("Max", "Mustermann", "01.01.1990", 31, 123456, 12345678, "B", "max.mustermann@example.com", "EC-Karte", "Keine besonderen Vorkommnisse", "Musterstraße", 1, 12345, "Musterstadt", true, 10, "max123", "passwortMax");

        assertEqualsI(123456, kunde.getKundennummer());
        kunde.setKundennummer(999999);
        assertEqualsI(999999, kunde.getKundennummer());

        assertEquals("max.mustermann@example.com", kunde.getEmail());
        kunde.setEmail("neue.email@example.com");
        assertEquals("neue.email@example.com", kunde.getEmail());

        assertEquals("max123", kunde.getAnmeldename());
        kunde.setAnmeldename("newLogin");
        assertEquals("newLogin", kunde.getAnmeldename());
    }

    private void assertEqualsI(int i, int kundennummer) {
        // wird fehler ausgeben wenn Kunde bei dem jeweiligen wert null ist
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    private void assertEquals(String string, String string2) {
        // wird fehler ausgeben wenn Kunde bei dem jeweiligen wert null ist
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    @VertragTest
    public void testLogin() {
        Kunde kunde = new Kunde("Max", "Mustermann", "01.01.1990", 31, 123456, 12345678, "B", "max.mustermann@example.com", "EC-Karte", "Keine besonderen Vorkommnisse", "Musterstraße", 1, 12345, "Musterstadt", true, 10,  "max123", "passwortMax");
        Kunde loggedKunde = Kunde.login("max123", "passwortMax");
        assertNotNull(loggedKunde);
        assertEquals(kunde.getAnmeldename(), loggedKunde.getAnmeldename());
        assertEquals(kunde.getPasswort(), loggedKunde.getPasswort());
    }
}
