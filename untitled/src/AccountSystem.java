public class AccountSystem {
    private double initialAmount;
    private double interestRate;
    private int numYears;
    private double[] accountBalance;

    public AccountSystem(double initialAmount, double interestRate, int numYears) {
        this.initialAmount = initialAmount;
        this.interestRate = interestRate;
        this.numYears = numYears;
        this.accountBalance = new double[numYears];
        this.accountBalance[0] = initialAmount;
    }

    public void calculateStatistics() {
        double totalDeposited = 0;
        double totalWithdrawn = 0;
        double maxBalance = 0;

        for (int i = 0; i < numYears; i++) {
            totalDeposited += accountBalance[i];
            if (accountBalance[i] > maxBalance) {
                maxBalance = accountBalance[i];
            }
        }

        totalWithdrawn = totalDeposited - accountBalance[numYears - 1];

        System.out.println("Сумма пополнения: $" + totalDeposited);
        System.out.println("Сумма снятия: $" + totalWithdrawn);
        System.out.println("Максимальный баланс: $" + maxBalance);
    }

    public void trackTerm(int currentYear) {
        if (currentYear <= numYears) {
            int remainingYears = numYears - currentYear;
            System.out.println("Осталось " + remainingYears + " до блокировки учетной записи");
        } else {
            System.out.println("Учетная записить была заблокирована");
        }
    }

    public void calculateInterestRate() {
        if (initialAmount > 10000) {
            this.interestRate = 0.08;
        } else {
            this.interestRate = 0.05;
        }
        System.out.println("Перерасчет процентной ставки: " + (this.interestRate * 100) + "%");
    }

    public void createNewAccount(double initialAmount) {
        this.initialAmount = initialAmount;
        this.accountBalance = new double[numYears];
        this.accountBalance[0] = initialAmount;
    }

    public void closeAccount() {
        initialAmount = 0;
        accountBalance = new double[numYears];
        System.out.println("Учетная запись была закрыта");
    }

    public static void main(String[] args) {
        AccountSystem account = new AccountSystem(5000, 0.06, 10);
        account.calculateStatistics();

        account.trackTerm(5);

        account.calculateInterestRate();

        account.createNewAccount(8000);
        account.calculateStatistics();

        account.closeAccount();
    }
}