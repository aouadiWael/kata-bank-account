package entity;

import exception.InvalidOperationException;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The Account entity
 *
 * @Author Wael AOUADI
 */
@Setter
@Getter
public class Account {

	/**
	 * Account number
	 */
	private int accountNumber;
	/**
	 * Balance
	 */
	private BigDecimal balance;
	/**
	 * History List
	 */
	private List<AccountStatement> accountHistory = new ArrayList();

	/**
	 * History details header
	 */
	private static final String LABELS = String.format("%-10s\t%-10s\t%12s\t%15s\n", "Operation", "Amount", "Date",
			"Balance");

	/**
	 * Constructor
	 *
	 * @param accountNumber
	 * @param balance
	 */
	public Account(int accountNumber, BigDecimal balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	/**
	 * Execute the transaction
	 *
	 * @param transactionType
	 * @param amount
	 * @throws InvalidOperationException
	 */
	public void executeTransaction(TransactionType transactionType, BigDecimal amount) throws InvalidOperationException {
		Transaction transaction = Transaction.build(transactionType, amount);
		TransactionProcessor transactionProcessor = new TransactionProcessor(this, transaction);
		transactionProcessor.process();
	}

	/**
	 * Show the account transactions history
	 */
	public String showHistory() {
		StringBuilder sb = new StringBuilder(LABELS);
		accountHistory.forEach(accountHisto -> sb.append(accountHisto.print()));
		return sb.toString();
	}
}
