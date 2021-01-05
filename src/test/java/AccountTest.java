import entity.Account;
import entity.TransactionType;
import exception.InvalidOperationException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Test class for Account entity
 *
 * @Author Wael AOUADI
 */
public class AccountTest {

	/**
	 * Test DEPOSIT Transacation
	 *
	 * @throws InvalidOperationException
	 */
	@Test
	public void GivenAccount_WhenDepositTransactionExecuted_ThenUpdateAccountBalance() throws InvalidOperationException {
		Account account = new Account(1, BigDecimal.valueOf(500));
		account.executeTransaction(TransactionType.DEPOSIT, BigDecimal.valueOf(200));
		Assert.assertEquals(BigDecimal.valueOf(700), account.getBalance());
	}

	/**
	 * Test WITHDRAWAL Transaction
	 *
	 * @throws InvalidOperationException
	 */
	@Test
	public void GivenAccount_WhenWithdrawalTransactionExecuted_ThenUpdateAccountBalance() throws InvalidOperationException {
		Account account = new Account(1, BigDecimal.valueOf(500));
		account.executeTransaction(TransactionType.WITHDRAWAL, BigDecimal.valueOf(200));
		Assert.assertEquals(BigDecimal.valueOf(300), account.getBalance());
	}

	/**
	 * Test DEPOSIT with null amount
	 *
	 * @throws InvalidOperationException
	 */
	@Test(expected = InvalidOperationException.class)
	public void GivenNullAmount_WhenExecuteTransaction_ThenThrowException() throws InvalidOperationException {
		Account account = new Account(1, BigDecimal.valueOf(500));
		account.executeTransaction(TransactionType.DEPOSIT, BigDecimal.valueOf(0));
	}

	/**
	 * Test Account history after transactions execution
	 *
	 * @throws Exception
	 */
	@Test
	public void GivenAccount_WhenExecuteMultipleTransactions_ThenUpdateAccountHistory() throws Exception {
		Account account = new Account(1, BigDecimal.valueOf(500));
		account.executeTransaction(TransactionType.DEPOSIT, new BigDecimal(500));
		account.executeTransaction(TransactionType.WITHDRAWAL, new BigDecimal(100));

		Assert.assertEquals(2, account.getAccountHistory().size());
		Assert.assertEquals(BigDecimal.valueOf(900), account.getBalance());

	}

	/**
	 * Test WITHDRAWAL Transaction when insufficient funds
	 *
	 * @throws Exception
	 */
	@Test(expected = InvalidOperationException.class)
	public void GivenAccountWithInsufficientFunds_WhenExecuteTransaction_ThenThrowException() throws Exception {
		Account account = new Account(1, BigDecimal.valueOf(500));
		account.executeTransaction(TransactionType.WITHDRAWAL, new BigDecimal(800));
	}

}
