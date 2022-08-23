package com.example.dubbosimulate.framework.protocol.http;

import com.example.dubbosimulate.framework.Invocation;
import com.example.dubbosimulate.framework.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {

        try {
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();

            String interfaceName = invocation.getInterfaceName();
            String methodName = invocation.getMethodName();

            Class aClass = LocalRegister.get(interfaceName);
            Method method = aClass.getMethod(methodName, invocation.getParamTypes());
            Object result = method.invoke(aClass.getDeclaredConstructor().newInstance(), invocation.getParams());

            if (result instanceof String) {
                IOUtils.write((String) result, resp.getOutputStream());
            } else {
                throw new RuntimeException("不支持得类型");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
