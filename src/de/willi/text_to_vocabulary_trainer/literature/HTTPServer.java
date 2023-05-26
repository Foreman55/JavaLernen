package de.willi.text_to_vocabulary_trainer.literature;

import com.sun.net.httpserver.HttpServer;
import de.willi.text_to_vocabulary_trainer.literature.controller.LiteratureController;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class HTTPServer {

    public void start() throws IOException {
        System.out.println("Start Webserver");
        HttpServer httpServer = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        httpServer.createContext("/ls", new LiteratureController());// Controller Klasse übergeben
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        httpServer.setExecutor(threadPoolExecutor);
        httpServer.start();
        System.out.println("Ende Webserver");
    }
}
