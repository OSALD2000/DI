package osa.ferien.examples.code;

import osa.ferien.examples.di.InjectDependency;
import osa.ferien.examples.di.Plugin;

public class LoggingPlugin implements Plugin
{
    @InjectDependency
    private TestClass testClass;

    @Override
    public void execute() {
        System.out.println("Logging Plugin: Nachricht protokolliert");
    }

    @Override
    public void printInfo(String message) {

    }

    public void log(String message)
    {
        testClass.PrintAllTests();
        System.out.println("Logging: " +message);
    }
}
