/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slr;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Touraj
 */
public class ACMProcessor implements IProcessor{
    
    public StringBuffer sb;
    enum aggregationEnum{main, and, or};

    public ACMProcessor() {
        sb = new StringBuffer();
    }

    public NodeList getNodesByXpath(String xpathQuery) {
        // "/acm/abstract"
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xPath = xpf.newXPath();
        //XPathExpression xpe = null;
        String expression = xpathQuery;
        NodeList nodes = null;
        try {
            // /catalog/journal[2]/article
            // "/catalog/journal/article[@date='January-2004']/title"

            XMLLoader xl = new XMLLoader();
            xl.setXmlFileName(new File("src/resources/ACM.xml"));
            InputSource inputSource = xl.loadXMlDocument();

            nodes = (NodeList) xPath.evaluate(expression, inputSource, XPathConstants.NODESET);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nodes;
    }

    public void buildQueryByXpath(NodeList nodes, String entity) {
        
        if (sb.toString().isEmpty())
        {
            sb.append("(");
        }else sb.append(" and (");
        
        for (int i = 0; i < nodes.getLength(); ++i) {
            // nodes.item(i).getFirstChild().getNodeValue()
            String aggregationType = nodes.item(i).getAttributes().getNamedItem("aggregation").getNodeValue();
            if (aggregationType.equalsIgnoreCase(aggregationEnum.main.toString())) {
                sb.append(entity+":");
                sb.append(nodes.item(i).getFirstChild().getNodeValue());

            } else if (aggregationType.equalsIgnoreCase(aggregationEnum.and.toString())) {
                sb.append(" and "+entity+":");
                sb.append(nodes.item(i).getFirstChild().getNodeValue());
            }
            else if (aggregationType.equalsIgnoreCase(aggregationEnum.or.toString())) {
                sb.append(" or "+entity+":");
                sb.append(nodes.item(i).getFirstChild().getNodeValue());
            }
            
           // System.out.println(aggregationType);
        }
        sb.append(")");

        // return null;
    }

    public String buildFinalQueryString() {
        NodeList nodesAbstract = this.getNodesByXpath("/acm/abstract");
       this.buildQueryByXpath(nodesAbstract, "Abstract");
       
       NodeList nodesTitle = this.getNodesByXpath("/acm/title");
       this.buildQueryByXpath(nodesTitle, "Title");
       return sb.toString();
    }
}
