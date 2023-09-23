package com.example.kpz_kp.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class Organization {
    private final String name = "SharinganCopyCompany";
    private final String address = "вул. Перемоги 4";

    public void printCheck(String service_name, int size, double price, int id){
        try{
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("D:/temp/kpz/kpz_check.pdf"));
            String FONT = "./assets/fonts/times.ttf";
            document.open();
            document.newPage();
            BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf, 20, Font.BOLD);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date = formatter.format(new Date());
            String text1 = "Замовлення №" + id +"\n";
            String text2 = service_name + " - " + size +" шт."+"\n";
            String text3 = price + " грн."+"\n";
            String text4 = this.name + ", " + this.address + ". " + date;
            Paragraph paragraph = new Paragraph(text1.concat(text2).concat(text3).concat(text4), font);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            document.close();
        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
