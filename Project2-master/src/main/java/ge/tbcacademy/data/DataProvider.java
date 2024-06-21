package ge.tbcacademy.data;

public class DataProvider {
    @org.testng.annotations.DataProvider
    public static Object[][] pricesDataProvider() {
        int numberOfRows = 5;
        Object[][] prices = new Object[numberOfRows][2];

        for (int i = 1; i <= numberOfRows; i++) {
           int minPriceForRange = 30 * i;
           int maxPriceForRange = 50 * i;

            prices[i-1][0] = String.valueOf(minPriceForRange);
            prices[i-1][1] = String.valueOf(maxPriceForRange);

        }

        return prices;
    }
    }
