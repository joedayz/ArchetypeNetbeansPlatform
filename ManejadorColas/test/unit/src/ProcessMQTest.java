/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author Edwin Farfan
 */
public class ProcessMQTest {
    
    @Test
    public void testProperties(){
        
        
        String rabbitPp = System.getProperties().toString(); //System.getProperty("rabbitmqctl.bin");
        
        Assert.assertNotNull(rabbitPp );
    }
    
}
