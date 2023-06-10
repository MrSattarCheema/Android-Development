import java.time.temporal.TemporalAmount

fun main(){
    println("Welcome to your banking system. \n" +
            "\n" +
            "What type of account would you like to create?\n" +
            "\n" +
            "1. Debit account\n" +
            "2. Credit account\n" +
            "3. Checking account")
    var accountType:String=""
    var userChoice:Int=0;
    while (accountType==""){
        println("Choose an option between 1 to 3")
        userChoice=((1..5).random());
        println("The selected option is $userChoice")
        when(userChoice){
            1 -> accountType="debit"
            2 -> accountType="credit"
            3 -> accountType="checking"
            else -> {println("Invalid Choice");
                continue}
        }
    }

    println("You have created a $accountType account")
    var accountBalance=((1..1000).random());
    println("Account Balance is $accountBalance")
    val money=(1..1000).random()
    println("Money want to deposit/withdraw $money")
    var output:Int=0
    fun withdraw(amount:Int):Int{
        accountBalance-=amount;
        println("Amount of money withdraw is $amount and current balance is $accountBalance")
        return amount;
    }
//    withdraw(money)
    fun debitWithdraw(amount:Int):Int{
        if(accountBalance<=0){
            println("Can't withdraw, no money on this account!")
            return accountBalance;
        }
        else if(accountBalance<amount){
            println("Not enough money on this account! The checking balance is $accountBalance dollars.")
            return 0;
        }
        else{
            return withdraw(money);
        }
    }
//    output=debitWithdraw(money);
//    println("The debit with draw is $output")
    fun deposit(amount:Int):Int{
        accountBalance+=amount;
        println("Amount of money deposited is $amount and current balance is $accountBalance")
        return amount;
    }
//    output=deposit(money)
//    println("The output is $output")
    fun creditDeposit(amount: Int):Int{
        if(accountBalance<=0){
            println("You don’t need to deposit anything in order to pay off the account since it has already been paid off. ")
            return accountBalance
        }
        else if(accountBalance+amount>0){
            println("Deposit failed, you tried to pay off an amount greater than the credit balance. " +
                    "The checking balance is ${accountBalance} dollars")
            return 0;
        }
        else if(amount == -accountBalance){
            println("You deposited just enough money in order to completely pay off the account in this case.")
            return amount
        }
        else{
            return deposit(amount);
        }
    }
//    output=creditDeposit(money)
//    println("The credit deposit is $output")
    fun transfer(mode:String){
        val transferAmount:Int
        when(mode){
            "withdraw" ->{
                if (accountType=="debit"){
                    transferAmount=debitWithdraw(money)
                }
                else{
                    transferAmount=withdraw(money)
                }
                println("The amount you withdrew is $transferAmount dollars")
            }
            "deposit" -> {
                if(accountType=="credit"){
                    transferAmount=creditDeposit(money)
                }
                else{
                    transferAmount=deposit(money);
                }
                println("The amount you deposited is ${transferAmount} dollars.")
            }
            else ->{
                return
            }
        }
    }
    var isSystemOpen:Boolean=true;
    var option:Int=0;
    while(isSystemOpen){
        println("What would you like to do?\n" +
                "\n" +
                "1. Check bank account balance\n" +
                "2. Withdraw money\n" +
                "3. Deposit money\n" +
                "4. Close the app\n" +
                "\n" +
                "Which option do you choose? (1, 2, 3 or 4)")
        option=(1..5).random()
        println("The selected option is $option")
        when(option){
            1 -> println("The account balance is $accountBalance")
            2 -> transfer("withdraw")
            3 -> transfer("deposit")
            4 -> {
                isSystemOpen=false
                println("System is closed")
            }
            else ->
                continue

        }
    }
}
