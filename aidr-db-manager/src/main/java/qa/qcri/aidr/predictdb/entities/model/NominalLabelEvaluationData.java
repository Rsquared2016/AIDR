// default package
// Generated Nov 24, 2014 4:55:08 PM by Hibernate Tools 4.0.0
package qa.qcri.aidr.predictdb.entities.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * NominalLabelEvaluationData generated by hbm2java
 */
@Entity
@Table(name = "nominal_label_evaluation_data", catalog = "aidr_predict")
public class NominalLabelEvaluationData implements java.io.Serializable {

	private NominalLabelEvaluationDataId id;

	public NominalLabelEvaluationData() {
	}

	public NominalLabelEvaluationData(NominalLabelEvaluationDataId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "documentId", column = @Column(name = "documentID", nullable = false)),
			@AttributeOverride(name = "crisisId", column = @Column(name = "crisisID", nullable = false)),
			@AttributeOverride(name = "nominalLabelId", column = @Column(name = "nominalLabelID", nullable = false)),
			@AttributeOverride(name = "nominalAttributeId", column = @Column(name = "nominalAttributeID", nullable = false)),
			@AttributeOverride(name = "wordFeatures", column = @Column(name = "wordFeatures", length = 65535)) })
	public NominalLabelEvaluationDataId getId() {
		return this.id;
	}

	public void setId(NominalLabelEvaluationDataId id) {
		this.id = id;
	}

}
