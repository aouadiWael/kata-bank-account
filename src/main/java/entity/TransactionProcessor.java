package entity;

import exception.InvalidOperationException;

import java.math.BigDecimal;

/**
 * Transaction Processor
 *
 * @Author Wael AOUADI
 */
public class TransactionProcessor {
	/**
	 * The account
	 */
	private Account account;
	/**
	 * The transaction
	 */
	private Transaction transaction;

	/**
	 * Constructor
	 *
	 * @param account
	 * @param transaction
	 */
	public TransactionProcessor(Account account, Transaction transaction) {
		this.account = account;
		this.transaction = transaction;
	}

	/**
	 * The transaction processing (Deposit and Withdrawal operations)
	 *
	 * @throws InvalidOperationException
	 */
	public void process() throws InvalidOperationException {
		final BigDecimal amount = TransactionType.DEPOSIT.equals(transaction.getTransactionType()) ? transaction.getAmount() : transaction.getAmount().negate();
		final BigDecimal expectedFunds = amount.add(account.getBalance());

		if (expectedFunds.signum() < 0) {
			throw new InvalidOperationException("Insufficient Funds: Maximum authorized amount: " + account.getBalance());
		}

		account.setBalance(expectedFunds);
		account.getAccountHistory().add(new AccountStatement(transaction, account.getBalance()));
	}
}
