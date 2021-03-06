/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qa.qcri.aidr.predictui.facade.imp;

import java.util.ArrayList;

import qa.qcri.aidr.common.exception.PropertyNotSetException;
import qa.qcri.aidr.dbmanager.dto.ModelDTO;
import qa.qcri.aidr.predictui.facade.*;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import qa.qcri.aidr.dbmanager.dto.taggerapi.ModelWrapper;
import qa.qcri.aidr.dbmanager.dto.taggerapi.ModelHistoryWrapper;


/**
 *
 * @author Imran
 *
 * Koushik: added try/catch
 */
@Stateless
public class ModelFacadeImp implements ModelFacade {

	private static Logger logger = Logger.getLogger(ModelFacadeImp.class);
    @EJB
    private qa.qcri.aidr.dbmanager.ejb.remote.facade.ModelResourceFacade remoteModelEJB;

    @EJB
    private ModelNominalLabelFacade modelLabelFacade;
    
    @Override
    public List<ModelDTO> getAllModels() {
        try {
            return remoteModelEJB.getAllModels();
        } catch (PropertyNotSetException e) {
            logger.error("Error in getAllModels.", e);
        }
        return null;

    }

    @Override
    public ModelDTO getModelByID(Long id) {
        try {
            return remoteModelEJB.getModelByID(id);
        } catch (PropertyNotSetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getModelCountByModelFamilyID(Long modelFamilyID) {
        try {
            return remoteModelEJB.getModelCountByModelFamilyID(modelFamilyID);
        } catch (PropertyNotSetException pe) {
            pe.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ModelHistoryWrapper> getModelByModelFamilyID(Long modelFamilyID, Integer start, 
    		Integer limit, String sortColumn, String sortDirection) {
        List<ModelHistoryWrapper> modelsList = new ArrayList<ModelHistoryWrapper>();
        try {
            modelsList = remoteModelEJB.getModelByModelFamilyID(modelFamilyID, start, limit, sortColumn, sortDirection);
        } catch (PropertyNotSetException pe) {
            pe.printStackTrace();
        }
        return modelsList;
    }

    @Override
    public List<ModelWrapper> getModelByCrisisID(Long crisisID) {
        try {
            return remoteModelEJB.getModelByCrisisID(crisisID);
        } catch (PropertyNotSetException pe) {
            pe.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void deleteModelDataByModelFamily(Long modelFamilyID) {
    	try {
			List<ModelHistoryWrapper> historyWrappers = remoteModelEJB.getModelByModelFamilyID(modelFamilyID, 0, 10);
			for (ModelHistoryWrapper modelHistoryWrapper : historyWrappers) {
				modelLabelFacade.deleteByModel(modelHistoryWrapper.getModelID());
				remoteModelEJB.deleteModel(modelHistoryWrapper.getModelID());
			}
			
		} catch (PropertyNotSetException e) {
			logger.error("Error in deleting Model Data with modelFamilyID : " + modelFamilyID);
		}
    }

}
