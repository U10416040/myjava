//U10416040 ªL¦ö¼á

import java.util.*;
import java.awt.*;

public class MainAccount {
	public static void main(String[] args){
		Account acc1;
		int i,total;
		Transaction t1;//Transaction reference
		acc1=new Account(1122, 1000, "George");//create Account object		
		
		//transactions
		//acc1.withdraw(30);
		acc1.withdraw(10);
		acc1.withdraw(40);
		acc1.withdraw(50);
		acc1.deposit(5);
		acc1.deposit(4);
		acc1.deposit(2);
		
		//print properties of each transactions 
		total=acc1.transactions.size();
		for(i=0;i<total;i++){
			t1=(Transaction)acc1.transactions.get(i);
			System.out.printf("%s %c %f %f %s\n", t1.date.toString(), t1.type, t1.amount, t1.balance, t1.description);
		}		
	}
}


class Transaction{
	Date date;
	char type;//'W' for withdraw,'D' for deposit
	double amount;
	double balance;
	String description;//describes how much money be withdrawn or deposited
	
	public Transaction(char type, double amount, double balance, String description){
		this.type=type;
		this.amount=amount;
		this.balance=balance;
		this.description=description;
		date=new Date();
	}
}


class Account{
	//data fields
	private int id=0;        
	private double balance=0;
	private double annualInterestRate=0;
	private Date dateCreated;
	private String name;
	public ArrayList<Transaction> transactions;
	private double amount;

	//no-arg constructor
	Account(){

	}

	//constructor
	Account(int id1, double balance1){
		id=id1;
		balance=balance1;
	}
	
	//constructor with ID, BALANCE, NAME
	Account(int id1, double balance1, String name1){
		id=id1;
		balance=balance1;
		name=name1;
		transactions=new ArrayList<Transaction>();//create ArraryList object with Transaction type
		amount=0;
		annualInterestRate=1.65/100;//interest rate
	}

	//mutator methods
	void set_id(int rekt){
		id=rekt;
	}

	void set_balance(double kappa){
		balance=kappa;
	}

	void set_annualInterestRate(double thumb){
		annualInterestRate=thumb;
	}

	//accessor methods
	int get_id(){
		return id;
	}

	double get_balance(){
		return balance;
	}

	double get_annualInterestRate(){
		return annualInterestRate;
	}

	Date get_dateCreated(){
		return dateCreated;
	}

	double get_MonthlyInterestRate(){
		return (annualInterestRate/12);
	}

	double get_MonthlyInterest(){
		return (annualInterestRate/12)*(balance);
	}

	double withdraw(double cash){
		balance=balance-cash;
		amount++;//increase amount of trade
		Transaction tran=new Transaction('W', amount, balance, "withdraw " + cash);//create withdraw object
		transactions.add(tran);//add transaction object to ArrayList
		System.out.printf("ID=%d NAME=%s RATE=%f BALANCE=%f\n", id, name, annualInterestRate, balance);
		return balance;
	}

	double deposit(double cash){
		balance=balance+cash;
		amount++;//increase amount of trade
		Transaction tran=new Transaction('D', amount, balance, "deposit " + cash);//create deposit object
		transactions.add(tran);//add transaction object to ArrayList
		System.out.printf("ID=%d NAME=%s RATE=%f BALANCE=%f\n", id, name, annualInterestRate, balance);
		return balance;
	}  
}

