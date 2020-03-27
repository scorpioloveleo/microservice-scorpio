package com.scorpio.config;

import com.scorpio.handler.GlobalExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

public class StartCommand {

    private Logger logger  = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public  StartCommand(String[] args){
        Boolean isServerPort = false;
        String serverPort = "";
        if(args!= null){
            for (String arg : args){
              if(StringUtils.hasText(arg) &&
              arg.startsWith("--server.port")){
                  isServerPort = true;
                  serverPort = arg;
                  break;
              }
            }
        }

        //没有指定端口号，则随机生成一个可用的端口
        if(!isServerPort){
            int port =getAvailablePort();
            logger.info("current server.port = " + port);
            System.setProperty("server.port", String.valueOf(port));
        }else{
            logger.info("current server.port = " +serverPort.split("=")[1]);
            System.setProperty("server.port", serverPort.split("=")[1]);
        }
    }


    public static int getAvailablePort(){
        int max =65535;
        int min =2000;
        Random random = new Random();
        int port = random.nextInt(max)%(max-min+1) + min;
        boolean using = StartCommand.isLoclePortUsing(port);
        if(using){
            return getAvailablePort();
        }else {
            return port;
        }
    }

    public static boolean isLoclePortUsing(int port){
        boolean flag = false;
        try {
            InetAddress Address = InetAddress.getByName("127.0.0.1");
            Socket socket = new Socket(Address,port);  //建立一个Socket连接
            flag = true;
        } catch (IOException e) {

        }
        return flag;
    }

}
