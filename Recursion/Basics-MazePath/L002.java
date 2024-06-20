import java.util.Scanner;
import java.util.ArrayList;

public class L002 {
    static class Customer {
        String firstName;
        String lastName;
        String customerID;
        int age;
        String mobileNo;
        String accountNo;
        int accountBalance;
        String accountType;
    }

    static class Manager {
        String firstName;
        String lastName;
        String managerId;
        int age;
        String mobileNo;
    }

    static class Branch {
        String branchName;
        Manager branchManager;
        int branchFund;
        ArrayList<Customer> customerList = new ArrayList<>();
    }

    static class Bank {
        ArrayList<Branch> branches = new ArrayList<>();
        String bankName;
        int totalCustomers;
        int totalFund;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // ======number of banks =================//
        int totalBanks = sc.nextInt();
        sc.nextLine();

        ArrayList<Bank> allBanks = new ArrayList<>();

        // ===============create banks==================//
        for (int i = 0; i < totalBanks; i++) {
            Bank bank = new Bank();
            bank.bankName = sc.nextLine();

            // =========== number of branches =============//
            int totalBranches = sc.nextInt();
            sc.nextLine();

            // ===============Create branches =============//
            for (int j = 0; j < totalBranches; j++) {
                Branch branch = new Branch();
                branch.branchName = sc.nextLine();

                // ===manager ====//
                Manager branchManager = new Manager();
                branchManager.firstName = sc.nextLine();
                branchManager.lastName = sc.nextLine();
                branchManager.managerId = sc.nextLine();
                branchManager.age = sc.nextInt();
                sc.nextLine();
                branchManager.mobileNo = sc.nextLine();
                branch.branchManager = branchManager;

                int branchFund = 0;

                // ===number of customers===///
                int totalCustomers = sc.nextInt();
                sc.nextLine();

                // ===============Create customers =============//
                for (int p = 0; p < totalCustomers; p++) {
                    Customer customer = new Customer();
                    customer.firstName = sc.nextLine();
                    customer.lastName = sc.nextLine();
                    customer.customerID = sc.nextLine();
                    customer.age = sc.nextInt();
                    sc.nextLine();
                    customer.mobileNo = sc.nextLine();
                    customer.accountNo = sc.nextLine();
                    customer.accountBalance = sc.nextInt();
                    sc.nextLine();
                    customer.accountType = sc.nextLine();

                    // Add customer balance to branch fund
                    branchFund += customer.accountBalance;

                    // Add customer to the branch's customer list
                    branch.customerList.add(customer);
                }

                // Add branch fund to the bank's total fund
                bank.totalFund += branchFund;
                branch.branchFund = branchFund;

                // Add total customers in the branch to the bank's total customers
                bank.totalCustomers += branch.customerList.size();

                // Add branch to the bank's branch list
                bank.branches.add(branch);
            }

            // Add bank to the list of all banks
            allBanks.add(bank);
        }

        for (Bank b : allBanks) {
            System.out.println("Bank Name: " + b.bankName);
            System.out.println("Total Customers: " + b.totalCustomers);
            System.out.println("Total Fund: " + b.totalFund);
            for (Branch br : b.branches) {
                System.out.println("  Branch Name: " + br.branchName);
                System.out.println("  Manager Name: " + br.branchManager.firstName + " " + br.branchManager.lastName);
                System.out.println("  Manager ID: " + br.branchManager.managerId);
                System.out.println("  Manager Age: " + br.branchManager.age);
                System.out.println("  Manager Mobile No: " + br.branchManager.mobileNo);
                System.out.println("  Total Branch Fund: " + br.branchFund);
                System.out.println("  Total Customers in Branch: " + br.customerList.size());
                for (Customer c : br.customerList) {
                    System.out.println("    Customer First Name: " + c.firstName);
                    System.out.println("    Customer Last Name: " + c.lastName);
                    System.out.println("    Customer ID: " + c.customerID);
                    System.out.println("    Customer Age: " + c.age);
                    System.out.println("    Customer Mobile No: " + c.mobileNo);
                    System.out.println("    Account No: " + c.accountNo);
                    System.out.println("    Account Balance: " + c.accountBalance);
                    System.out.println("    Account Type: " + c.accountType);
                    System.out.println("    ======================================");
                }
            }
        }
        sc.close();
        System.out.println("hello world");
        // ArrayList<Bank> bankList = findBanks(allBanks);
        /*
         * for (Bank bank : bankList) {
         * System.out.println(bank.bankName);
         * }
         */
        // ArrayList<Bank> bankList = findBanks(allBanks);
        /*
         * * for (Bank bank : bankList) {
         * for (Branch b : bank.branches) {
         * System.out.println(b.branchName);
         * 
         * }
         * 
         * }
         */
        /*
         * ArrayList<Customer> result = ListOfCust(allBanks);
         * for (Customer c : result) {
         * System.out.println(c.firstName);
         * }
         */
        /*
         * int averageAge = AverageAgeOfCust(allBanks);
         * 
         * System.out.println("Average age of customers: " + averageAge);
         */
       /*  ArrayList<Manager> manager = BranchManagerDetails(allBanks, "HDFCB01");
        System.out.println("Branch Manager Details:");
        for (Manager managers : manager) {
            System.out.println("Manager Name: " + managers.firstName);
            System.out.println("Manager Name: " + managers.lastName);
            System.out.println("Manager ID: " + managers.managerId);
            System.out.println("Manager Age: " + managers.age);
            System.out.println("Manager Mobile No: " + managers.mobileNo);
        }*/

        ArrayList<Customer> customers= CustomerDetails(allBanks, "HDFCC15","HDFCB01" , "HDFC");
        for(Customer c :customers)
        {
            System.out.println(c.firstName);
            System.out.println(c.lastName);
            System.out.println(c.customerID);
            System.out.println(c.age);
            System.out.println(c.mobileNo);
            System.out.println(c.accountNo);
            System.out.println(c.accountBalance);
            System.out.println(c.accountType);
            







        }


    }

    // Find the bank in which customer age is between 20 to 30 having account
    // balance more than 1 lakh ruppee
    public static ArrayList<Bank> findBanks(ArrayList<Bank> list) {
        ArrayList<Bank> ans = new ArrayList<>();

        for (Bank bank : list) {

            for (Branch branch : bank.branches) {
                for (Customer customer : branch.customerList) {
                    if (customer.age >= 20 && customer.age <= 30 && customer.accountBalance > 100000) {
                        ans.add(bank);

                        break;
                    }
                }

            }

        }
        return ans;

    }

    // Find the branches where the fund is more than 20 lakh ruppes in all banks
    public static ArrayList<Bank> FindBranches(ArrayList<Bank> mArrayList) {
        ArrayList<Bank> result = new ArrayList<Bank>();
        for (Bank b : mArrayList) {
            for (Branch bch : b.branches) {
                if (bch.branchFund > 20000000) {
                    result.add(b);
                }
            }

        }
        return result;

    }

    // find the list of customers in all banks where the balance is less than 1 lakh
    public static ArrayList<Customer> ListOfCust(ArrayList<Bank> list) {
        ArrayList<Customer> ans = new ArrayList<Customer>();
        for (Bank bank : list) {
            for (Branch branch : bank.branches) {
                for (Customer c : branch.customerList) {
                    if (c.accountBalance < 1000000) {
                        ans.add(c);
                    }
                }
            }
        }
        return ans;
    }

    // find the average age of customer in all branches of the given bank
    public static int AverageAgeOfCust(ArrayList<Bank> list) {
        int ans = 0;
        int customerCount = 0;
        for (Bank bank : list) {
            for (Branch branch : bank.branches) {
                for (Customer cust : branch.customerList) {
                    ans = ans + cust.age;
                    customerCount++;

                }

            }

        }
        return ans / customerCount;

    }

    // find the branch where the fund to customer ratio is very high
    // fund/cusomercount
    // print the branch manager details of given bank based on branch no;

    public static ArrayList<Manager> BranchManagerDetails(ArrayList<Bank> list, String name) {
        ArrayList<Manager> managers = new ArrayList<>();
        for (Bank b : list) {
            for (Branch bch : b.branches) {
                if (bch.branchName.equals(name)) {
                    managers.add(bch.branchManager);
                }
            }
        }
        return managers;
    }

    // print the customer details based on customerId branchNo and bankName;
    public static ArrayList<Customer> CustomerDetails(ArrayList<Bank> list, String ID, String BRname, String Bname) {
        ArrayList<Customer> cust = new ArrayList<>();
        for (Bank b : list) {
            if (b.bankName.equals(Bname)) {
                for (Branch branch : b.branches) {
                    if (branch.branchName.equals(BRname))

                    {
                        for (Customer c : branch.customerList) {
                            if (c.customerID.equals(ID)) {
                                cust.add(c);
                            }

                        }

                    }
                }

            }

        }
        return cust;


    }
   // total number of saving account and checking account in all branches //
/// List<Account> Account{type,noofaccounts}
public static int totalNumber(ArrayList<Bank> list,String type)
{
    int SavingAccountType=0;
    
    for(Bank bank : list)
    {
        for(Branch branch : bank.branches)
        {
            for(Customer cust : branch.customerList)
            {
                if(cust.accountType.equals(type))
                {
                    SavingAccountType++;



                }

            }
        }
    }



    return SavingAccountType;


}




}

// total no. of checking account in given bank based on bank name
    

