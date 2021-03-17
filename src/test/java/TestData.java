
import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


@Data
@Value
public class TestData {


    private TestData() {
    }


    public static String enterName(){
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().firstName();
        return name;
    }

    public static String enterPhone()  {
        Faker faker = new Faker(new Locale("ru"));
        String phone = faker.numerify("+7##########");
        return phone;
    }

    public static String getCity(){
        String[] city = { "Майкоп", "Уфа", "Нальчик", "Якутск", "Казань", "Кызыл", "Магас"};
        int rnd = new Random().nextInt(city.length);
        return city[rnd];
    }


    public static String setDate(long plusDay) {
        String date = LocalDate
                .now()
                .plusDays(plusDay)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }


}