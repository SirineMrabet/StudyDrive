package Helpers;

import Base.BaseUtile;
import Configuration.Config;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.xml.dom.ITagSetter;

import java.io.File;

public class ScreenShots extends BaseUtile {

    private BaseUtile base;

    public ScreenShots(BaseUtile base) {
        this.base = base;
        this.driver = base.driver;
    }

    /**
     * This function will take screenshot
     *
     * @param fileWithPath
     * @throws Exception
     */
    public static void takeSnapShot(String fileWithPath) {
        try{
            //Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            //Call getScreenshotAs method to create image file
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            //Move image file to new destination
            File DestFile = new File(fileWithPath);
            //Copy file at destination
            FileUtils.copyFile(SrcFile, DestFile);
        }
        catch(Exception e){
            System.out.println("Exception while trying to capture a screenshot  "+e.getMessage());
        }

    }

    public static boolean checkIMGContainTxt(String FilePath, String text) {
        try {
            File imgFile = new File(FilePath);
            ITesseract  instance = new Tesseract();
            instance.setDatapath(System.getProperty("user.dir")+ Config.TessDataPath);
            instance.setLanguage("eng");
            instance.setPageSegMode(1);
            instance.setOcrEngineMode(1);
            String textExtract = instance.doOCR(imgFile);
            return textExtract.contains(text);

        }
        catch (Error | TesseractException e){

            System.out.println("******************************This is the error*********************************************");

            System.out.println("Error while decoding the image  "+e.getMessage());
            System.out.println("********************************************************************************************");
            e.printStackTrace();
            System.out.println("********************************************************************************************");
            System.out.println("********************************************************************************************");
            System.out.println("********************************************************************************************");
        }
        return false;
    }
}
