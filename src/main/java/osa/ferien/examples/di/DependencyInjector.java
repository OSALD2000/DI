package osa.ferien.examples.di;

import osa.ferien.examples.code.ProxyPluginHandler;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class DependencyInjector
{
    private Map<Class<?>, Object> pluginInstances = new HashMap<>();


    public void addedMethode(String string)
    {
        System.out.println("Hello from added Method : " + string);
    }

    public void registerPlugin(Class<?> pluginClass) throws Exception
    {
        Object instance = pluginClass.getDeclaredConstructor().newInstance();

        Object proxyInstance = Proxy.newProxyInstance(
                pluginClass.getClassLoader(),
                new Class[]{Plugin.class},
                new ProxyPluginHandler(instance)
        );

        pluginInstances.put(pluginClass, proxyInstance);
    }

    public void registerPlugin(Object instance) throws Exception
    {

        Object proxyInstance = Proxy.newProxyInstance(
                instance.getClass().getClassLoader(),
                new Class[]{Plugin.class},
                new ProxyPluginHandler(instance)
        );

        pluginInstances.put(instance.getClass(), proxyInstance);
    }


    public void resolveDependencies() throws Exception
    {
        for (Object pluginInstance : pluginInstances.values())
        {
            for (Field field : ((ProxyPluginHandler) Proxy.getInvocationHandler(pluginInstance)).geTargetClass().getDeclaredFields())
            {
                if (field.isAnnotationPresent(InjectDependency.class))
                {
                    Class<?> dependencyType = field.getType();
                    Object proxyDependencyInstance = pluginInstances.get(dependencyType);
                    if (proxyDependencyInstance != null) {
                        field.setAccessible(true);
                        Object oldInstance = ((ProxyPluginHandler) Proxy.getInvocationHandler(pluginInstance)).getTarget();
                        Object dependencyInstance = ((ProxyPluginHandler) Proxy.getInvocationHandler(proxyDependencyInstance)).getTarget();
                        field.set(oldInstance, dependencyInstance);
                        field.setAccessible(false);
                    }

                }
            }
        }
    }

    public void executePlugins() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (Object pluginInstance : pluginInstances.values()) {
            if (((ProxyPluginHandler) Proxy.getInvocationHandler(pluginInstance)).getTarget() instanceof Plugin)
            {
                Method addedMethod = pluginInstance.getClass().getMethod("printInfo", String.class);
                addedMethod.invoke(pluginInstance, pluginInstance.toString());
                ((Plugin) pluginInstance).execute();
            }
        }
    }
}
