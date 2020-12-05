package com.example.netty.learning;

import com.example.netty.learning.discard.DiscardServer;
import com.example.netty.learning.time.TimeServer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception{
    	int port = 9090;
    	if (args.length > 0) {
    		port = Integer.parseInt(args[0]);
    	}
    	
//    	new DiscardServer(port).run();
    	new TimeServer(port).run();
    }
}
