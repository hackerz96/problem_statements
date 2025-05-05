// Single file implementation with custom exception and validation

class NonEligibleException extends Exception {
    public NonEligibleException(String message) {
        super(message);
    }
}

class Citizen {
    private String name;
    private int id;
    private int age;
    private String country;
    private String sex;
    private String maritalStatus;
    private double annualIncome;
    private String economyStatus;

    public Citizen(String name, int id, int age, String country, String sex, String maritalStatus,
                   double annualIncome, String economyStatus) throws NonEligibleException {
        this.name = name;
        this.id = id;
        this.age = age;
        this.country = country;
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.annualIncome = annualIncome;
        this.economyStatus = economyStatus;

        if (age < 18 && !country.equalsIgnoreCase("India")) {
            throw new NonEligibleException("Citizen not eligible: Age below 18 and not from India.");
        }
    }

    @Override
    public String toString() {
        return "Citizen Details:\n" +
                "Name: " + name + "\n" +
                "ID: " + id + "\n" +
                "Age: " + age + "\n" +
                "Country: " + country + "\n" +
                "Sex: " + sex + "\n" +
                "Marital Status: " + maritalStatus + "\n" +
                "Annual Income: " + annualIncome + "\n" +
                "Economic Status: " + economyStatus + "\n";
    }
}

public class CitizenApplication {
    public static void main(String[] args) {
        try {
            Citizen c1 = new Citizen("Rahul", 101, 25, "India", "Male", "Single", 500000, "Middle Class");
            System.out.println(c1);

            Citizen c2 = new Citizen("John", 102, 16, "USA", "Male", "Single", 300000, "Lower Class");
            System.out.println(c2); // Won’t print if exception is thrown
        } catch (NonEligibleException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
