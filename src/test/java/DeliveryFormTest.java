
import com.codeborne.selenide.Selectors;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryFormTest {

    TestData testData = new TestData();
    Faker faker = new Faker(new Locale("ru"));


    @Test
    public void shouldSubmitRequest() {
        open("http://localhost:9999");
        $("[placeholder='Город']").sendKeys(testData.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(TestData.getDatePlusThree());
        $("[name='name']").sendKeys(testData.enterName(faker));
        $("[name='phone']").sendKeys(testData.enterPhone(faker));
        $("[class='checkbox__box']").click();
        $(byText("Запланировать")).click();
        $(Selectors.withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(16));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(TestData.getDatePlusFive());
        $(byText("Запланировать")).click();
        $(byText("Перепланировать")).click();
        $(Selectors.withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(16));

    }


}
