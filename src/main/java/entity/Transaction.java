package entity;

import exception.InvalidOperationException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Transaction Entity
 *
 * @Author Wael AOUADI
 */
@Getter
@Setter
@EqualsAndHashCode
public class Transaction {
	/**
	 * Date Formatter
	 */
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss");
	/**
	 * Amount Formatter
	 */
	public static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("#.00");
	/**
	 * Transaction Date
	 */
	private LocalDateTime transactionDate;
	/**
	 * Transaction Type
	 */
	private TransactionType transactionType;
	/**
	 * Transaction Amount
	 */
	private BigDecimal amount;


	/**
	 * Private Constructor
	 *
	 * @param transactionType
	 * @param amount
	 */
	private Transaction(TransactionType transactionType, BigDecimal amount) {
		this.transactionType = Objects.requireNonNull(transactionType, "Invalid Transaction type !");
		this.amount = amount;
		this.transactionDate = LocalDateTime.now();
	}

	/**
	 * Transaction Builder
	 *
	 * @param transactionType
	 * @param amount
	 * @return
	 * @throws InvalidOperationException
	 */
	public static Transaction build(TransactionType transactionType, BigDecimal amount) throws InvalidOperationException {
		if (BigDecimal.ZERO.compareTo(amount) >= 0) {
			throw new InvalidOperationException("Amount must be greater than 0 !");
		}
		return new Transaction(transactionType, amount);
	}

	/**
	 * Print transaction details
	 *
	 * @return String
	 */
	public String print() {
		return (String.format("%-10s\t%-10s\t%-10s", transactionType, DECIMAL_FORMATTER.format(amount), DATE_FORMATTER.format(transactionDate)));
	}
}
