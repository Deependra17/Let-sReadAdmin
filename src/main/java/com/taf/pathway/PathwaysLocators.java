package com.taf.pathway;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PathwaysLocators {
    public String getClickOnPathway() {
        return ClickOnPathway;
    }

    public String getCreatePathway() {
        return CreatePathway;
    }

    public String getEnterPathwaysName() {
        return EnterPathwaysName;
    }

    public String getEnterPathwayIntro() {
        return EnterPathwayIntro;
    }

    public String getUploadImage() {
        return UploadImage;
    }

    public String getSelectPathwaysCover() {
        return SelectPathwaysCover;
    }

    public String getReadingBuddy() {
        return ReadingBuddy;
    }

    public String getClickOnSave() {
        return ClickOnSave;
    }

    public String getCreateLevel1() {
        return CreateLevel1;
    }

    public String getAddBook() {
        return AddBook;
    }

    public String getEnterBookName() {
        return EnterBookName;
    }

    public String getSelectBook() {
        return SelectBook;
    }

    public String getClickOnAddBook() {
        return ClickOnAddBook;
    }

    private String ClickOnPathway;
    private String CreatePathway;
    private String EnterPathwaysName;
    private String EnterPathwayIntro;
    private String UploadImage;
    private String SelectPathwaysCover;
    private String ReadingBuddy;
    private String ClickOnSave;
    private String CreateLevel1;
    private String AddBook;
    private String EnterBookName;
    private String SelectBook;
    private String ClickOnAddBook;

    PathwaysLocators(){
        try (
                InputStream input = new FileInputStream("src/main/resources/config.properties")) {

            Properties locate = new Properties();
            locate.load(input);
            this.ClickOnPathway=locate.getProperty("ClickOnPathway");
            this.CreatePathway=locate.getProperty("CreatePathway");
            this.EnterPathwaysName=locate.getProperty("EnterPathwaysName");
            this.EnterPathwayIntro=locate.getProperty("EnterPathwayIntro");
            this.UploadImage=locate.getProperty("UploadImage");
            this.SelectPathwaysCover=locate.getProperty("SelectPathwaysCover");
            this.ReadingBuddy=locate.getProperty("ReadingBuddy");
            this.ClickOnSave=locate.getProperty("ClickOnSave");
            this.CreateLevel1=locate.getProperty("CreateLevel1");
            this.AddBook=locate.getProperty("AddBook");
            this.EnterBookName=locate.getProperty("EnterBookName");
            this.SelectBook=locate.getProperty("SelectBook");
            this.ClickOnAddBook=locate.getProperty("ClickOnAddBook");

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
    }
}
