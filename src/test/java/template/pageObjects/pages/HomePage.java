package template.pageObjects.pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import cucumber.api.java.en.Then;

public class HomePage extends AbstractPageObject
{

    /*
     * (non-Javadoc)
     * 
     * @see com.xceptance.scripting.selenide.page.AbstractPage()
     */
    @Override
    public void isExpectedPage()
    {
        $("#service-areas").should(exist);
    }

    /*
     * (non-Javadoc)
     * 
     * @see template.pageObjects.pages.AbstractPageObject()
     */
    @Then("^The home page should have heading, carousel, services and the company button$")
    public void validateStructure()
    {
        // Verifies the company Logo and name are visible.
        $("#navigation .navbar-brand a[title=Home]").shouldBe(visible);

        // Verifies the Navigation bar is visible
        $("#navigation .navbar-header ul.nav").shouldBe(visible);
        // Asserts there's categories in the nav bar.
        $$("#navigation .navbar-header ul.nav > li > a").shouldHave(sizeGreaterThan(0));

        // Asserts the first headline is there.
        $("#service-areas .landing-intro > h1").shouldBe(matchText("[A-Z].{3,}"));

        // Asserts the animated carousel is there.
        $("#myCarousel").shouldBe(visible);

        // Verifies the "services" section is there.
        // Asserts there's at least 1 item in the list.
        $$("#service-areas .container .thumbnail").shouldHave(sizeGreaterThan(0));

        // Verifies the company button is there.
        $$("#xlt-background .container p.lead > a.btn-primary").shouldHave(sizeGreaterThan(0));
    }
}
