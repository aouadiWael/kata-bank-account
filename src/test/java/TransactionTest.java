import entity.Transaction;
import entity.TransactionType;
import exception.InvalidOperationException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Test class for Transaction entity
 *
 * @Author Wael AOUADI
 */
public class TransactionTest {

	/**
	 * DATE_FORMATTER
	 */
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");

	/**
	 * Test build transaction when amount is null
	 *
	 * @throws InvalidOperationException
	 */
	@Test(expected = InvalidOperationException.class)
	public void GivenNullAmount_WhenBuildTransaction_ThenThrowException() throws InvalidOperationException {
		Transaction transaction = Transaction.build(TransactionType.DEPOSIT, BigDecimal.ZERO);
		Assert.assertEquals(BigDecimal.ZERO, transaction.getAmount());
	}

	/**
	 * Test build transaction when type is null
	 *
	 * @throws InvalidOperationException
	 */
	@Test(expected = NullPointerException.class)
	public void GivenNullTransactionType_WhenBuildTransaction_ThenThrowException() throws InvalidOperationException {
		Transaction transaction = Transaction.build(null, BigDecimal.valueOf(500));
		Assert.assertEquals(BigDecimal.ZERO, transaction.getAmount());
	}

	/**
	 * Test transaction print
	 *
	 * @throws InvalidOperationException
	 */
	@Test
	public void GivenTransaction_WhenTransactionBuilt_ThenPrintTransactionDetails() throws InvalidOperationException {
		Transaction transaction = Transaction.build(TransactionType.DEPOSIT, BigDecimal.valueOf(500));
		Assert.assertEquals(String.format("%-10s\t%-10s\t%-10s", TransactionType.DEPOSIT, "500,00",
				DATE_FORMATTER.format(LocalDateTime.now())), transaction.print());

	}
}
