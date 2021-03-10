
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

    Faker faker = new Faker(new Locale("ru"));


    public String enterName(Faker faker){
        String name = faker.name().fullName();
        return name;
    }

    public String enterPhone(Faker faker)  {
        String phone = faker.numerify("+7##########");
        return phone;
    }

    public String getCity(){
        String[] city = { "Майкоп", "Уфа", "Нальчик", "Якутск", "Казань", "Кызыл", "Магас"};
        int rnd = new Random().nextInt(city.length);
        return city[rnd];
    }


    public static String getDatePlusThree(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(3).format(formatter);
        return date;
    }

    public static String getDatePlusFive(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(5).format(formatter);
        return date;
    }




}