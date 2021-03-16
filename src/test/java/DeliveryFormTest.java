
import com.codeborne.selenide.Selectors;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryFormTest {


    @Test
    public void shouldSubmitRequest() {
        open("http://localhost:9999");
        $("[placeholder='Город']").sendKeys(TestData.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(TestData.setDate(5));
        $("[name='name']").sendKeys(TestData.enterName());
        $("[name='phone']").sendKeys(TestData.enterPhone());
        $("[class='checkbox__box']").click();
        $(byText("Запланировать")).click();
        $(Selectors.withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(16));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(TestData.setDate(7));
        $(byText("Запланировать")).click();
        $(byText("Перепланировать")).click();
        $(Selectors.withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(16));
        $("[data-test-id=success-notification] .notification__content").shouldHave(text(TestData.setDate(7)));

    }


}
