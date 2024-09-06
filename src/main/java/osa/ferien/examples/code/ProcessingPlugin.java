package osa.ferien.examples.code;

import osa.ferien.examples.di.InjectDependency;
import osa.ferien.examples.di.Plugin;

public class ProcessingPlugin implements Plugin
{
    @InjectDependency
    private LoggingPlugin loggingPlugin;

    @InjectDependency
    private TestClass testClass;

    @Override
    public void execute()
    {
        System.out.println("Processing Plugin: Verarbeitung gestartet.");
        loggingPlugin.log("Verarbeitung abgeschlossen.");
        testClass.PrintAllTests();
    }

    @Override
    public void printInfo(String message)
    {
    }
}
