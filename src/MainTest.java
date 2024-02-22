import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.assertEquals;
public class MainTest {

    @Test
    public void getOraLocaleIt() {
        String dateString = "2023-03-01T13:00:00Z";
        OffsetDateTime dateTime = Main.getParse(dateString);
        OffsetDateTime dopoUnAnno = Main.getDopoUnAnno(dateTime);
        OffsetDateTime dopoUnMese = Main.getDopoUnMese(dopoUnAnno);
        OffsetDateTime dopoSetteGiorni = Main.getDopoSetteGiorni(dopoUnMese);
        ZonedDateTime oraLocaleIt = Main.getOraLocaleIt(dopoSetteGiorni);
        ZonedDateTime expectedOraLocaleIt = dopoSetteGiorni.atZoneSameInstant(ZoneId.of("Europe/Rome"));

        assertEquals(expectedOraLocaleIt, oraLocaleIt);
    }

    @Test
    public void getDopoSetteGiorni() {
        String dateString = "2023-03-01T13:00:00Z";
        OffsetDateTime dateTime = Main.getParse(dateString);
        OffsetDateTime dopoUnAnno = Main.getDopoUnAnno(dateTime);
        OffsetDateTime dopoUnMese = Main.getDopoUnMese(dopoUnAnno);
        OffsetDateTime dopoSetteGiorni = Main.getDopoSetteGiorni(dopoUnMese);
        OffsetDateTime expectedDopoSetteGiorni = dopoUnMese.plusDays(7);

        assertEquals(expectedDopoSetteGiorni, dopoSetteGiorni);
    }

    @Test
    public void getDopoUnMese() {
        String dateString = "2023-03-01T13:00:00Z";
        OffsetDateTime dateTime = Main.getParse(dateString);
        OffsetDateTime dopoUnAnno = Main.getDopoUnAnno(dateTime);
        OffsetDateTime dopoUnMese = Main.getDopoUnMese(dopoUnAnno);
        OffsetDateTime expectedDopoUnMese = dopoUnAnno.minusMonths(1);

        assertEquals(expectedDopoUnMese, dopoUnMese);
    }

    @Test
    public void testGetDopoUnAnno() {
        String dateString = "2023-03-01T13:00:00Z";
        OffsetDateTime dateTime = Main.getParse(dateString);
        OffsetDateTime dopoUnAnno = Main.getDopoUnAnno(dateTime);
        OffsetDateTime expectedDopoUnAnno = dateTime.plusYears(1);

        assertEquals(expectedDopoUnAnno, dopoUnAnno);
    }

    @Test
    public void testGetParse() {
        String dateString = "2023-03-01T13:00:00Z";
        OffsetDateTime dateTime = Main.getParse(dateString);
        OffsetDateTime expectedDate = OffsetDateTime.parse(dateString);

        assertEquals(expectedDate, dateTime);
    }
}