package co.sample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String item;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	private float amount;

	protected Expense() {
	}

	protected Expense(String item, float amount) {
		this.item = item;
		this.amount = amount;
	}

	// getters and setters are hidden for brevity

	@Override
	public String toString() {
		return id + ". " + item + " - " + amount + " USD";
	}
}
