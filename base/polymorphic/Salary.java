package polymorphic;

public class Salary extends Income {

    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        // 工资交税去掉5000基数
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}
