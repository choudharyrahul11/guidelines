package com.core.Bank;

public class AccountHolder implements Runnable{
	private Account account;

	public AccountHolder(Account account) {
		this.account = account;
	}
	
	public void run(){
		for(int i= 1;i<=4;i++){
			try {
				makeWithDraw(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if(account.getBalance()<0){
					System.out.println("Account is overdrawn!");
				}
			}
		
	}

	private  void makeWithDraw(int withDrawnAmt) throws InterruptedException {
		if(account.getBalance() >= withDrawnAmt){
			System.out.println(Thread.currentThread().getName()+" is going to withdraw the amount"+ withDrawnAmt);
			Thread.sleep(2000);
			account.withdraw(withDrawnAmt);
			System.out.println(Thread.currentThread().getName()+" has withdrawn the amount"+ withDrawnAmt+ "and current account balance is"+account.getBalance());
		}
		else{
			System.out.println("Account doesn't has the sufficient balance");
		}
		
		
	}

}
