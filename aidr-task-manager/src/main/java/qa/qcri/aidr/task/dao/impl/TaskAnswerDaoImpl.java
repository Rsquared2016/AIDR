package qa.qcri.aidr.task.dao.impl;

//import org.springframework.stereotype.Repository;

import qa.qcri.aidr.task.dao.TaskAnswerDao;
import qa.qcri.aidr.task.entities.TaskAnswer;


/**
 * Created with IntelliJ IDEA.
 * User: jilucas
 * Date: 9/15/13
 * Time: 7:38 AM
 * To change this template use File | Settings | File Templates.
 */
//@Repository
public class TaskAnswerDaoImpl extends AbstractDaoImpl<TaskAnswer, String> implements TaskAnswerDao {

    protected TaskAnswerDaoImpl(){
        super(TaskAnswer.class);
    }

    @Override
    public void insertTaskAnswer(TaskAnswer taskAnswer) {
        save(taskAnswer);
    }

}