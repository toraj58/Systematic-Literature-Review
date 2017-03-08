/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slr;

import java.util.List;

/**
 *
 * @author Touraj
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       //StringBuffer acmQuery = new StringBuffer();
       //List<IProcessor> listOfProcessors = new ArrayList();
       
       ACMProcessor acmProcessor = new ACMProcessor() ;
       SceinceDirectProcessor sceinceDirectProcessor = new SceinceDirectProcessor();
       
       ProcessorManager pm = new ProcessorManager();
       
       pm.addProcessor(acmProcessor);
       pm.addProcessor(sceinceDirectProcessor);
       
       List<String> queryStrings = pm.getAllStringQueries();
       
       for (String query : queryStrings)
       {
           System.out.println(query);
       }
       

       

//       String result = acmProcessor.buildFinalQueryString();
//              System.out.println(result);
//              
//               String result2 = sceinceDirectProcessor.buildFinalQueryString();
//              System.out.println(result2);

          // System.out.println(title);
  

    }
}
