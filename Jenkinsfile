job("Dependency Injection Job")
{
    description("This is a test Jenkins Job")
   
    scm {
        git('https://github.com/OSALD2000/DI.git', 'master')
    }

    steps
    {
        maven
        {
            mavenInstallation('maven')
            goals("clean install")
        }
    }
}