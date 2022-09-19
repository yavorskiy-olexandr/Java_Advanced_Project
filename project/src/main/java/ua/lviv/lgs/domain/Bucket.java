package ua.lviv.lgs.domain;

import java.util.Date;

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
	private Scores scores;
	@Column
	private Date purchaseDate;
	
	public Bucket() {
	}

	public Bucket(Integer id) {
		this.id = id;
	}

	public Bucket(User user, Scores scores, Date purchaseDate) {
		this.user = user;
		this.scores = scores;
		this.purchaseDate = purchaseDate;
	}

	public Bucket(Integer id, User user, Scores scores, Date purchaseDate) {
		this.id = id;
		this.user = user;
		this.scores = scores;
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

	public Scores getScores() {
		return scores;
	}

	public void setScores(Scores scores) {
		this.scores = scores;
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
		result = prime * result + ((scores == null) ? 0 : scores.hashCode());
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
		if (scores == null) {
			if (other.scores != null)
				return false;
		} else if (!scores.equals(other.scores))
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
		return "Bucket [id=" + id + ", user=" + user + ", scoresId=" + scores + ", purchaseDate=" + purchaseDate
				+ "]";
	}
}
