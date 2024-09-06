package osa.ferien.examples;

import osa.ferien.examples.code.LoggingPlugin;
import osa.ferien.examples.code.ProcessingPlugin;
import osa.ferien.examples.code.TestClass;
import osa.ferien.examples.di.DependencyInjector;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        TestClass testClass = new TestClass("first Test sentence", "second Test sentence", "third Test sentence", "fourth Test sentence", "fifth Test sentence");
        DependencyInjector injector = new DependencyInjector();

        injector.registerPlugin(testClass);
        injector.registerPlugin(LoggingPlugin.class);
        injector.registerPlugin(ProcessingPlugin.class);

        injector.resolveDependencies();

        injector.executePlugins();
    }
}