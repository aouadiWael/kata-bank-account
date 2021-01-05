import entity.Account;
import entity.TransactionType;

import java.math.BigDecimal;

/**
 * @Author Wael AOUADI
 */
public class Main {
	public static void main(String[] args) {
		Account account = new Account(1, BigDecimal.ZERO);
		try {
			account.executeTransaction(TransactionType.DEPOSIT, new BigDecimal(500));
			account.executeTransaction(TransactionType.DEPOSIT, new BigDecimal(100));
			account.executeTransaction(TransactionType.WITHDRAWAL, new BigDecimal(300));
			account.executeTransaction(TransactionType.DEPOSIT, new BigDecimal(500));
			account.executeTransaction(TransactionType.WITHDRAWAL, new BigDecimal(100));
			System.out.println(account.showHistory());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
