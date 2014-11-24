// default package
// Generated Nov 24, 2014 4:55:08 PM by Hibernate Tools 4.0.0
package qa.qcri.aidr.predictdb.entities.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ModelNominalLabelId generated by hbm2java
 */
@Embeddable
public class ModelNominalLabelId implements java.io.Serializable {

	private int modelId;
	private int nominalLabelId;

	public ModelNominalLabelId() {
	}

	public ModelNominalLabelId(int modelId, int nominalLabelId) {
		this.modelId = modelId;
		this.nominalLabelId = nominalLabelId;
	}

	@Column(name = "modelID", nullable = false)
	public int getModelId() {
		return this.modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	@Column(name = "nominalLabelID", nullable = false)
	public int getNominalLabelId() {
		return this.nominalLabelId;
	}

	public void setNominalLabelId(int nominalLabelId) {
		this.nominalLabelId = nominalLabelId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ModelNominalLabelId))
			return false;
		ModelNominalLabelId castOther = (ModelNominalLabelId) other;

		return (this.getModelId() == castOther.getModelId())
				&& (this.getNominalLabelId() == castOther.getNominalLabelId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getModelId();
		result = 37 * result + this.getNominalLabelId();
		return result;
	}

}
