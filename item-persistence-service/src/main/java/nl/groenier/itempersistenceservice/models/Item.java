package nl.groenier.itempersistenceservice.models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String descriptionOfContent;
	private int weightInGram;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescriptionOfContent() {
		return descriptionOfContent;
	}

	public void setDescriptionOfContent(String descriptionOfContent) {
		this.descriptionOfContent = descriptionOfContent;
	}

	public int getWeightInGram() {
		return weightInGram;
	}

	public void setWeightInGram(int weightInGram) {
		this.weightInGram = weightInGram;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id='" + id + '\'' +
				", descriptionOfContent='" + descriptionOfContent + '\'' +
				", weightInGram=" + weightInGram +
				'}';
	}

}
