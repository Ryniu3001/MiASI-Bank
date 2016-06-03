import operations.Transfer;

public aspect MyAspect {

	pointcut function() : 
		call ( void operations.Operation.execute()) && target(operations.Transfer);
	
	after(): function(){
		System.out.println("ASPEKT");
	}
	
	before(): function(){
		System.out.println("ASPEKT");
		System.out.println(((Transfer)thisJoinPoint.getTarget()).getAmount());
	}
}
