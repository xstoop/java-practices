package april4.polymorphic;

public class Main {
    public static void main(String[] args) {

        // 多态：方法调用总是作用于运行时对象的实际类型
        Income[] incomes = {
                new Income(3000),
                new Salary(5000),
                new StateCouncilSpecialAllowance(12000),
        };

        Main main = new Main();

        System.out.println(main.totalTax(incomes));
    }

    public double totalTax(Income[] incomes) {
        double tax = 0;
        for (Income income : incomes) {
            // getTax方法的调用取决于运行时income实际的类型，在这里不需要知道其他子类的存在
            tax = tax + income.getTax();
        }
        return tax;
    }
}
