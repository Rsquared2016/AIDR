package qa.qcri.aidr.task.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: jilucas
 * Date: 9/15/13
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement
@Entity 	//@IdClass(DocumentNominalLabelKey.class)
@Table(catalog = "aidr_predict",name = "document_nominal_label")
public class DocumentNominalLabel implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;

    public  DocumentNominalLabel() {}
    public  DocumentNominalLabel(Long documentID, Long nominalLabelID){
        this.documentID = documentID;
        this.nominalLabelID = nominalLabelID;
        this.timestamp = new Date();
    }
    
    public  DocumentNominalLabel(Long documentID, Long nominalLabelID, Long userID){
        this.documentID = documentID;
        this.nominalLabelID = nominalLabelID;
        this.userID = userID;
        this.timestamp = new Date();
    }
    
    public Long getDocumentID() {
        return documentID;
    }

    public void setDocumentID(Long documentID) {
        this.documentID = documentID;
    }

    public Long getNominalLabelID() {
        return nominalLabelID;
    }

    public void setNominalLabelID(Long nominalLabelID) {
        this.nominalLabelID = nominalLabelID;
    }
    
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    @XmlElement
    @Id
    @Column(name = "documentID")
    private Long documentID;

    
    //@Id
    @XmlElement
    @Column (name = "nominalLabelID", nullable = false)
    private Long nominalLabelID;
    
    //@Id
    @XmlElement
    @Column (name = "userID", nullable = false)
    private Long userID;
    
    @XmlElement
    @Column (name = "timestamp", nullable = false)
    private Date timestamp;


}
