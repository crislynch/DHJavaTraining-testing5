//Crea un oggetto data da questa stringa 2023-03-01T13:00:00Z
//aggiungi un anno
//sottrai un mese
//aggiungi 7 giorni
//Stampa il risultato localizzata per l'Italia
import java.time.*;

public class Main {
    public static void main(String[] args) {
        String dataString = "2023-03-01T13:00:00Z";
        OffsetDateTime data = getParse(dataString);

        //aggiungi un anno
        OffsetDateTime dopoUnAnno = getDopoUnAnno(data);

        //sottrai un mese
        OffsetDateTime dopoUnMese = getDopoUnMese(dopoUnAnno);

        //aggiungi 7 giorni
        OffsetDateTime dopoSetteGiorni = getDopoSetteGiorni(dopoUnMese);


        ZonedDateTime oraLocaleIt = getOraLocaleIt(dopoSetteGiorni);
        //Stampa il risultato localizzata per l'Italia
        System.out.println("Data localizzata per l'Italia: " + oraLocaleIt);
    }

    public static ZonedDateTime getOraLocaleIt(OffsetDateTime dopoSetteGiorni) {
        ZonedDateTime oraLocaleIt = dopoSetteGiorni.atZoneSameInstant(ZoneId.of("Europe/Rome"));
        return oraLocaleIt;
    }

    public static OffsetDateTime getDopoSetteGiorni(OffsetDateTime dopoUnMese) {
        OffsetDateTime dopoSetteGiorni = dopoUnMese.plusDays(7);
        return dopoSetteGiorni;
    }

    public static OffsetDateTime getDopoUnMese(OffsetDateTime dopoUnAnno) {
        OffsetDateTime dopoUnMese = dopoUnAnno.minusMonths(1);
        return dopoUnMese;
    }

    public static OffsetDateTime getDopoUnAnno(OffsetDateTime data) {
        OffsetDateTime dopoUnAnno = data.plusYears(1);
        return dopoUnAnno;
    }

    public static OffsetDateTime getParse(String dataString) {
        OffsetDateTime data = OffsetDateTime.parse(dataString);
        return data;
    }
}