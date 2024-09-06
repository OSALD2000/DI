package osa.ferien.examples.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class TestClass
{
    @Setter
    private String test0;
    @Setter
    private String test1;
    @Setter
    private String test2;
    @Setter
    private String test3;
    @Setter
    private String test4;

    private List<String> array;

    public TestClass(String test0, String test1, String test2, String test3, String test4) {
        this.test0 = test0;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
        this.test4 = test4;
        this.array = Arrays.asList( test0, test1, test2, test3, test4);
    }




    public void PrintAllTests()
    {
        for (String test : array)
        {
            System.out.println(test);
        }
    }
}
