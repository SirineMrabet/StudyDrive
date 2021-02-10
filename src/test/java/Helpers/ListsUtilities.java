package Helpers;

import Base.BaseUtile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListsUtilities extends BaseUtile {

    private BaseUtile base;

    public ListsUtilities(BaseUtile base) {
        this.base = base;
        this.driver = base.driver;
    }

    public static void SelectItem(String Item, String FromXpath) {
        String innerhtml = null;
        List<WebElement> element_list = driver.findElements(By.xpath(FromXpath));
        System.out.println("Number of Elements : " + element_list.size());
        for (int i = 0; i < element_list.size(); i++) {
            WebElement my_element = element_list.get(i);
            innerhtml = my_element.getText();
            System.out.println(my_element.getTagName()+"         "+my_element.getText());
            if (innerhtml.contains(Item)) {
                my_element.click();
                break;
            }
        }
    }


}
