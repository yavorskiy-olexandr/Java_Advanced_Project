package ua.lviv.lgs.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="bucket")
public class Bucket {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="user_id", referencedColumnName="id")
	private User user;
	@ManyToOne
	@JoinColumn(name="scores_id", referencedColumnName="id")
	private Scores scoresId;
	@Column
	private Date purchaseDate;
	
	public Bucket() {
	}

	public Bucket(User user, Scores scoresId, Date purchaseDate) {
		super();
		this.user = user;
		this.scoresId = scoresId;
		this.purchaseDate = purchaseDate;
	}

	public Bucket(Integer id, User user, Scores scoresId, Date purchaseDate) {
		super();
		this.id = id;
		this.user = user;
		this.scoresId = scoresId;
		this.purchaseDate = purchaseDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Scores getScoresId() {
		return scoresId;
	}

	public void setScoresId(Scores scoresId) {
		this.scoresId = scoresId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((scoresId == null) ? 0 : scoresId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Bucket other = (Bucket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (scoresId == null) {
			if (other.scoresId != null)
				return false;
		} else if (!scoresId.equals(other.scoresId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user=" + user + ", scoresId=" + scoresId + ", purchaseDate=" + purchaseDate
				+ "]";
	}
}
