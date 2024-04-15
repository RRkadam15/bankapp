package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] temperatureValues;
    private static int nHours;

    @BeforeClass
    public static void setUp() {
        // Initializing common objects and data
        wController = WeatherController.getInstance();
        nHours = wController.getTotalHours();
        temperatureValues = new double[nHours];
        for (int i = 0; i < nHours; i++) {
            temperatureValues[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void tearDown() {
        // Shutting down controller after all tests
        wController.close();
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "220473748";
        Assert.assertNotNull("Student ID is 220473748", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Rohit Rajendra Kadam";
        Assert.assertNotNull("Student name is Rohit Rajendra Kadam", studentName);
    }

    @Test
    public void testTemperatureMin() {
        double minTemperature = MinTemperature();
        Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
    }

    @Test
    public void testTemperatureMax() {
        double maxTemperature = MaxTemperature();
        Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
    }

    @Test
    public void testTemperatureAverage() {
        double averageTemperature = AverageTemperature();
        Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemperature);
    }

    private double MinTemperature() {
        System.out.println("+++ testTemperatureMin +++");
        double minTemperature = 1000; 

        for (double temperatureVal : temperatureValues) {
            if (temperatureVal < minTemperature) {
                minTemperature = temperatureVal;
            }
        }
        System.out.println("Minimum Temperature is: " + minTemperature);
        return minTemperature;
    }
    
    private double AverageTemperature() {
        System.out.println("+++ testTemperatureAverage +++");
        double sumTemp = 0;

        for (double temperatureVal : temperatureValues) {
            sumTemp += temperatureVal;
        }

        double averageTemp = sumTemp / nHours;
        System.out.println("Average Temperature is: " + averageTemp);
        return averageTemp;
    }

    private double MaxTemperature() {
        System.out.println("+++ testTemperatureMax +++");
        double maxTemperature = -1; 

        for (double temperatureVal : temperatureValues) {
            if (temperatureVal > maxTemperature) {
                maxTemperature = temperatureVal;
            }
        }
        System.out.println("Maximum Temperature is: " + maxTemperature);
        return maxTemperature;
    }


    @Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
