package osa.ferien.examples.code;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyPluginHandler implements InvocationHandler
{
    private final Object target;

    public ProxyPluginHandler(Object plugin)
    {
        this.target = plugin;
    }

    public Class<?> geTargetClass()
    {
        return target.getClass();
    }

    public Object getTarget()
    {
        return target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception
    {
        if ("printInfo".equals(method.getName()))
        {
            System.out.println("Hello from added method printInfo : " + args[0]);
        }
        return method.invoke(target, args);
    }
}
