/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package slr;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Touraj
 */
public class ProcessorManager {
    
    private List<IProcessor> listOfProcs;
    


    public ProcessorManager() {
        listOfProcs = new ArrayList();
    }
    
    public void addProcessor(IProcessor iproc)
    {
        listOfProcs.add(iproc);
    
    }
    
    public List<String> getAllStringQueries()
    {
        List<String> queries = new ArrayList<String>();
       for(IProcessor proc: listOfProcs)
       {
          String resultQueryperDatabase = proc.buildFinalQueryString();
          queries.add(resultQueryperDatabase);
          
       }
        
    return queries;
    }

}
