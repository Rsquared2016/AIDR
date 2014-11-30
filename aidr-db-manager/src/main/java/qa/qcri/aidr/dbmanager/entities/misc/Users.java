// default package
// Generated Nov 24, 2014 4:55:08 PM by Hibernate Tools 4.0.0

package qa.qcri.aidr.dbmanager.entities.misc;

import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.collection.internal.PersistentList;

import qa.qcri.aidr.dbmanager.entities.model.NominalAttribute;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "aidr_predict", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Users implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1155167281183767570L;
	private Long userId;
	private String name;
	private String role;
	private List<NominalAttribute> nominalAttributes = null;
	private List<Crisis> crisises = null;

	public Users() {
	}

	public Users(String name, String role) {
		this.name = name;
		this.role = role;
	}

	public Users(String name, String role, List<NominalAttribute> nominalAttributes, List<Crisis> crisises) {
		this.name = name;
		this.role = role;
		this.nominalAttributes = nominalAttributes;
		this.crisises = crisises;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userID", unique = true, nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "name", unique = true, nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "role", nullable = false, length = 45)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public List<NominalAttribute> getNominalAttributes() {
		return this.nominalAttributes;
	}

	public void setNominalAttributes(List<NominalAttribute> nominalAttributes) {
		this.nominalAttributes = nominalAttributes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public List<Crisis> getCrisises() {
		return this.crisises;
	}

	public void setCrisises(List<Crisis> crisises) {
		this.crisises = crisises;
	}

	public boolean hasCrisises() {
		return ((PersistentList) this.crisises).wasInitialized();
	}
	
	public boolean hasNominalAttributes() {
		return ((PersistentList) this.nominalAttributes).wasInitialized();
	}
}
