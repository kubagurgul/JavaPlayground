package com.jgurgul.j13.designPatterns.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyApp {
    public static void main(String[] args) {
        ProxyApp pa = new ProxyApp();
        pa.execute();


    }

    void execute() {
        PlayerService playerService = new PlayerService();
        Object proxy = Proxy.newProxyInstance(getClass().getClassLoader(), playerService.getClass().getInterfaces(), new MyInvocationHandler(playerService));

        Method m = null;
        try {
            m = proxy.getClass().getDeclaredMethod("play", String.class);
            m.invoke(proxy, "asdf");
            System.out.println("xxx");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
