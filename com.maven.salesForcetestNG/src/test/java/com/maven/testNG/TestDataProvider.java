package com.maven.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
	@Test(dataProvider = "myDataProvider")
    public void myTestMethod(String param1, int param2) {
        System.out.println("Parameter 1: " + param1);
        System.out.println("Parameter 2: " + param2);
    }

    @DataProvider(name = "myDataProvider")
    public Object[][] provideData() {
        return new Object[][] {
            { "Value1", 123 },
            { "Value2", 456 }
        };
    }
}
