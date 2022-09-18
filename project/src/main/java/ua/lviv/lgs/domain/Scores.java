package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name="scores")
public class Scores {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	@Column
	private Double math;
	@Column
	private Double phisics;
	@Column
	private Double english;
	@Lob
	private String encodedImage;
	public Scores(Integer id, Double math, Double phisics, Double english) {
		this.id = id;
		this.math = math;
		this.phisics = phisics;
		this.english = english;
	}
	public Scores(Double math, Double phisics, Double english) {
		this.math = math;
		this.phisics = phisics;
		this.english = english;
	}
	public Scores() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getMath() {
		return math;
	}
	public void setMath(Double math) {
		this.math = math;
	}
	public Double getPhisics() {
		return phisics;
	}
	public void setPhisics(Double phisics) {
		this.phisics = phisics;
	}
	public Double getEnglish() {
		return english;
	}
	public void setEnglish(Double english) {
		this.english = english;
	}
	public String getEncodedImage() {
		return encodedImage;
	}
	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((english == null) ? 0 : english.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((math == null) ? 0 : math.hashCode());
		result = prime * result + ((phisics == null) ? 0 : phisics.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scores other = (Scores) obj;
		if (english == null) {
			if (other.english != null)
				return false;
		} else if (!english.equals(other.english))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (math == null) {
			if (other.math != null)
				return false;
		} else if (!math.equals(other.math))
			return false;
		if (phisics == null) {
			if (other.phisics != null)
				return false;
		} else if (!phisics.equals(other.phisics))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Scores [id=" + id + ", math=" + math + ", phisics=" + phisics + ", english=" + english + "]";
	}
	
}
