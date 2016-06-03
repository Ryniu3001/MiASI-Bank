import operations.Transfer;
import product.Account;

public aspect MyAspect {

	pointcut function() : 	
		call ( void operations.Operation.execute()) && target(operations.Transfer);
	
	after(): function(){
		Transfer transfer = (Transfer)thisJoinPoint.getTarget();
		Account sourceAccount = (Account)transfer.getFrom();
		sourceAccount.setBalance(sourceAccount.getBalance()-10);
	}
	
}
