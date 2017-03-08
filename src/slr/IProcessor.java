/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package slr;

import org.w3c.dom.NodeList;

/**
 *
 * @author Touraj
 */
public interface IProcessor {
    
    public NodeList getNodesByXpath(String xpathQuery);
    public void buildQueryByXpath(NodeList nodes, String entity);
    public String buildFinalQueryString();

}
