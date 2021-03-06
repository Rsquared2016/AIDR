package qa.qcri.aidr.dbmanager.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;

import qa.qcri.aidr.common.exception.PropertyNotSetException;
import qa.qcri.aidr.dbmanager.entities.misc.Collection;
import qa.qcri.aidr.dbmanager.entities.misc.CrisisType;
import qa.qcri.aidr.dbmanager.entities.misc.Users;
import qa.qcri.aidr.dbmanager.entities.model.ModelFamily;
import qa.qcri.aidr.dbmanager.entities.task.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown=true)
public class CollectionDTO implements Serializable  {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7825767671101319130L;

	static final Logger logger = Logger.getLogger("db-manager-log");

	@XmlElement
	private Long crisisID;

	@XmlElement
	private  String name;

	@XmlElement
	private CrisisTypeDTO crisisTypeDTO = null;

	@XmlElement
	private  String code;

	@XmlElement
	private UsersDTO usersDTO = null;

	@XmlElement
	private boolean isTrashed;
	
	@XmlElement
	private boolean isMicromapperEnabled;

	@XmlElement
	private List<NominalAttributeDTO> nominalAttributesDTO = null;

	@XmlElement
	private List<DocumentDTO> documentsDTO = null;

	@XmlElement
	private List<ModelFamilyDTO> modelFamiliesDTO = null;

	@XmlElement
	private UsersDTO ownerDTO = null;

	public CollectionDTO(){}

	public CollectionDTO(String name, String code, boolean isTrashed, boolean isMicromapperEnabled,
			CrisisTypeDTO crisisTypeDTO, UsersDTO usersDTO, UsersDTO owner) {

		this.setName(name);
		this.setCode(code);
		this.setIsTrashed(isTrashed);
		this.setIsMicromapperEnabled(isMicromapperEnabled);
		this.setCrisisTypeDTO(crisisTypeDTO);
		this.setUsersDTO(usersDTO);
		this.setOwnerDTO(owner);
	}
	

	public CollectionDTO(Long crisisID, String name, String code, boolean isTrashed, boolean isMicromapperEnabled,
			CrisisTypeDTO crisisTypeDTO, UsersDTO usersDTO, UsersDTO owner) {

		this.setCrisisID(crisisID);
		this.setName(name);
		this.setCode(code);
		this.setIsTrashed(isTrashed);
		this.setIsMicromapperEnabled(isMicromapperEnabled);
		this.setCrisisTypeDTO(crisisTypeDTO);
		this.setUsersDTO(usersDTO);
		this.setOwnerDTO(owner);
	}

	public CollectionDTO(Collection collection) throws PropertyNotSetException {
		if (collection != null) {
			
			this.setCrisisID(collection.getCrisisId());
			this.setName(collection.getName());
			this.setCode(collection.getCode());
			this.setIsTrashed(collection.isIsTrashed());
			this.setIsMicromapperEnabled(collection.isIsMicromapperEnabled());
			if (collection.hasCrisisType() && collection.getCrisisType() != null) {
				CrisisType cType = new CrisisType(collection.getCrisisType().getName());
				cType.setCrisisTypeId(collection.getCrisisType().getCrisisTypeId());
				this.setCrisisTypeDTO(new CrisisTypeDTO(cType));
			}
			if (collection.hasUsers() & collection.getUsers() != null) {
				Users user = new Users();
				user.setUserName(collection.getUsers().getUserName());
				user.setId(collection.getUsers().getId());
				this.setUsersDTO(new UsersDTO(user));
			}
			
			if(collection.getOwner() != null) {
				Users user = new Users();
				user.setUserName(collection.getOwner().getUserName());
				user.setId(collection.getOwner().getId());
				this.setOwnerDTO(new UsersDTO(user));
			}
			
			if (collection.hasModelFamilies()) {
				this.setModelFamiliesDTO(toModelFamilyDTOList(collection.getModelFamilies()));
			}
			if (collection.hasDocuments()) {
				this.setDocumentsDTO(toDocumentDTOList(collection.getDocuments()));
			}
		} else {
			logger.error("Entity = null in constructor");
		}

	}
	
	public UsersDTO getOwnerDTO() {
		return ownerDTO;
	}

	public void setOwnerDTO(UsersDTO ownerDTO) {
		this.ownerDTO = ownerDTO;
	}
	
	public Long getCrisisID() {
			return this.crisisID;
	}

	public void setCrisisID(Long crisisID) {
		if(crisisID.longValue() <= 0) {
			logger.error( "Attempt to set a crisisID to zero or a negative number" );
			throw new IllegalArgumentException("crisisID cannot be zero or a negative number");
		} else {
			this.crisisID = crisisID;
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CrisisTypeDTO getCrisisTypeDTO() {
			return this.crisisTypeDTO;
	}

	public void setCrisisTypeDTO(CrisisTypeDTO crisisTypeDTO) {
		this.crisisTypeDTO = crisisTypeDTO;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isIsTrashed() {
		return this.isTrashed;
	}

	public void setIsTrashed(boolean isTrashed) {
		this.isTrashed = isTrashed;
	}

	public boolean isIsMicromapperEnabled() {
		return isMicromapperEnabled;
	}

	public void setIsMicromapperEnabled(boolean isMicromapperEnabled) {
		this.isMicromapperEnabled = isMicromapperEnabled;
	}
	
	public UsersDTO getUsersDTO() {
		return this.usersDTO;
	}

	public void setUsersDTO(UsersDTO usersDTO) {
			this.usersDTO = usersDTO;
	}

	public List<NominalAttributeDTO> getNominalAttributesDTO() {
		return this.nominalAttributesDTO;
	}

	public void setNominalAttributesDTO(List<NominalAttributeDTO> nominalAttributesDTO) {
		this.nominalAttributesDTO = nominalAttributesDTO;
	}

	public List<DocumentDTO> getDocumentsDTO() {
		return this.documentsDTO;
	}

	public void setDocumentsDTO(List<DocumentDTO> documentsDTO) {
		this.documentsDTO = documentsDTO;
	}

	public List<ModelFamilyDTO> getModelFamiliesDTO() {
		return this.modelFamiliesDTO;
	}

	public void setModelFamiliesDTO(List<ModelFamilyDTO> modelFamiliesDTO) {
		this.modelFamiliesDTO = modelFamiliesDTO;
	}

	private List<DocumentDTO> toDocumentDTOList(List<Document> list) {
		if (list != null) {
			try {
				List<DocumentDTO> dtoList = new ArrayList<DocumentDTO>();
				for (Document d: list) {
					Document doc = new Document(d.getCrisis(), d.isIsEvaluationSet(),
											d.isHasHumanLabels(), d.getValueAsTrainingSample(),
											d.getReceivedAt(), d.getLanguage(), d.getDoctype(), d.getData(),
											d.getWordFeatures(), d.getGeoFeatures(), d.getTaskAssignments(),
											d.getDocumentNominalLabels());					
					doc.setDocumentId(d.getDocumentId());
					dtoList.add(new DocumentDTO(doc));
				}
				return dtoList;
			} catch (Exception e) {
				logger.warn("Unable to wrap Document to DocumentDTO.");
			}
		}
		return null;
	}

	private List<Document> toDocumentList(List<DocumentDTO> list) throws PropertyNotSetException {
		if (list != null) {
			List<Document> eList = new ArrayList<Document>();
			for (DocumentDTO dto: list) {
				eList.add(dto.toEntity());
			}
			return eList;
		}
		return null;
	}

	private List<ModelFamilyDTO> toModelFamilyDTOList(List<ModelFamily> list) throws PropertyNotSetException {
		if (list != null) {
			List<ModelFamilyDTO> dtoList = new ArrayList<ModelFamilyDTO>();
			for (ModelFamily d: list) {
				dtoList.add(new ModelFamilyDTO(d));
			}
			return dtoList;
		}
		return null;
	}


	private List<ModelFamily> toModelFamilyList(List<ModelFamilyDTO> list) throws PropertyNotSetException {
		if (list != null) {
			List<ModelFamily> eList = new ArrayList<ModelFamily>();
			for (ModelFamilyDTO dto: list) {
				eList.add(dto.toEntity());
			}
			return eList;
		}
		return null;
	}

	/* Mapping to entity */
	public Collection toEntity() throws PropertyNotSetException {
		Collection crisis = new Collection();
		if (this.getCrisisID() != null) {
			crisis.setCrisisId(this.getCrisisID());
		}
		crisis.setName(getName());
		crisis.setCode(this.getCode());
		crisis.setIsTrashed(this.isTrashed);
		crisis.setIsMicromapperEnabled(this.isMicromapperEnabled);
		if(this.getOwnerDTO() != null) {
			crisis.setOwner(this.getOwnerDTO().toEntity());
		}
		if (this.getUsersDTO() != null) {
			crisis.setUsers(this.getUsersDTO().toEntity());
		}
		if (this.getCrisisTypeDTO() != null) {
			crisis.setCrisisType(this.getCrisisTypeDTO().toEntity());
		} 

		// Optional fields conversion
		if (this.getDocumentsDTO() != null) {
			crisis.setDocuments(this.toDocumentList(this.getDocumentsDTO()));
		} 
		if (this.getModelFamiliesDTO() != null) {
			crisis.setModelFamilies(this.toModelFamilyList(this.getModelFamiliesDTO()));
		} 
		return crisis;
	}


}

