import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyTests {

    @Test
    public void SimpleTest()
    {
        System.out.println("My first test.");
    }
    @DataProvider(name = "dataProvider")
    public Object[][] numbs()
    {
        Object[][] objects = {
                {10, 5},
                {12, 2},
        };


        return objects;
    };
    @Test(groups = "A+B", dataProvider = "dataProvider")
    public void AB1(int a, int b)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(a + b==15);
        softAssert.assertTrue(a != b);
        softAssert.assertTrue( a > b);
        System.out.println(a + b);
        System.out.println();
        softAssert.assertAll();
    }
    @Test(groups = "A-B", dataProvider = "dataProvider")
    public void AB2(int a, int b)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(a - b==5);
        softAssert.assertTrue(a != b);
        softAssert.assertTrue( a > b);
        System.out.println(a - b);
        System.out.println();
        softAssert.assertAll();
    }
    @Test(groups = "A*B", dataProvider = "dataProvider")
    public void AB3(int a, int b)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(a * b==50);
        softAssert.assertTrue(a != b);
        softAssert.assertTrue( a < b);
        softAssert.assertTrue( a > b);
        System.out.println(a * b);
        System.out.println();
        softAssert.assertAll();
    }
    @Test(groups = "A/B", dataProvider = "dataProvider", dependsOnGroups = "A*B")
    public void AB4(int a, int b)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(a / b==2);
        softAssert.assertTrue(a != b);
        softAssert.assertTrue( a < b);
        softAssert.assertTrue( a > b);
        System.out.println(a / b);
        System.out.println();
        softAssert.assertAll();
    }
    @Test(groups = "A%B", dataProvider = "dataProvider", dependsOnGroups = "A*B")
    public void AB5(int a, int b)
    {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(a % b==0);
        softAssert.assertTrue(a != b);
        System.out.println(a % b);
        System.out.println();
        softAssert.assertAll();

    }
}
