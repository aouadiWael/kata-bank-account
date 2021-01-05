package entity;

import java.math.BigDecimal;

/**
 * Account Statement entity
 *
 * @Author Wael AOUADI
 */
public class AccountStatement {

	/**
	 * The statement transaction
	 */
	private Transaction transaction;

	/**
	 * Current Balance
	 */
	private BigDecimal balance;

	/**
	 * Constructor
	 *
	 * @param transaction
	 * @param balance
	 */
	public AccountStatement(Transaction transaction, BigDecimal balance) {
		this.transaction = transaction;
		this.balance = balance;
	}

	/**
	 * Print Statement details
	 *
	 * @return String
	 */
	public String print() {
		return (String.format("%10s\t%10s\n", transaction.print(), Transaction.DECIMAL_FORMATTER.format(balance)));
	}
}
