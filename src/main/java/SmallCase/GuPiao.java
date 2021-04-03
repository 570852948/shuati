package SmallCase;

public class GuPiao {

    public static void main(String[] args) {
        float[] f = {10,9.5f,9,9.1f,9.5f,10};
        float everyTimeBuy = 2000;
        float r = revenue(f,everyTimeBuy);
        float spendAll = f.length*everyTimeBuy;
        System.out.println("赚了：" + r);

        System.out.println("收益率：" + r / spendAll * 100 + "%");
    }

    public static float revenue(float[] prices,float everyTimeSpend) {
        float revenue = 0;
        float quantity = 0;
        float lastPrice = prices[prices.length - 1];
        float current_total_price = 0;
        float spend_total_price = 0;

        for (float e : prices) {
            float g = 0;
            g = everyTimeSpend/e;
            quantity += g;
        }

        //目前值多少钱
        current_total_price = quantity * lastPrice;
        System.out.println("目前持有：" + quantity + "股");
        System.out.println("目前市值：" + current_total_price);
        //花费了多少钱
        spend_total_price = prices.length * everyTimeSpend;
        System.out.println("如果一开始直接梭哈有这么多股：" + spend_total_price/prices[0] + "股");
        System.out.println("花费金额：" + spend_total_price);
        revenue = current_total_price - spend_total_price;

        return revenue;
    }
}
