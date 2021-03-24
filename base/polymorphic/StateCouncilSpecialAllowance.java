package polymorphic;

public class StateCouncilSpecialAllowance extends Income {

    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        // 国务院特殊津贴不需要交税
        return 0;
    }
}
