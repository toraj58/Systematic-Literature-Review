/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.xml.sax.InputSource;

/**
 *
 * @author Touraj
 */
public class XMLLoader {

    private  File xmlFileName;

    public void setXmlFileName(File xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    public File getXmlFileName() {
        return xmlFileName;
    }

    public XMLLoader() {
    }

     public  InputSource loadXMlDocument() {
        InputSource is = null;
        try {
            FileInputStream fis = new FileInputStream(xmlFileName);
            is = new InputSource(fis);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return is;
    }
}
