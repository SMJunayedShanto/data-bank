/************************************************************
 * File: PersonController.java Course materials (22W) CST8277
 *
 * @author Teddy Yap
 * @author Shariar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.annotation.SessionMap;
import javax.inject.Inject;

import databank.dao.PersonDao;
import databank.model.PersonPojo;

/**
 * Description: Responsible for collection of Person Pojo's in XHTML (list) <h:dataTable> </br>
 * Delegates all C-R-U-D behavior to DAO
 */

//TODO don't forget this object is a managed bean with a session scope
public class PersonController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	@SessionMap
	private Map< String, Object> sessionMap;

	@Inject
	private PersonDao personDao;

	private List< PersonPojo> people;

	//necessary methods to make controller work

	public void loadPeople() {
		setPeople( personDao.readAllPeople());
	}

	public List< PersonPojo> getPeople() {
		return people;
	}

	public void setPeople( List< PersonPojo> people) {
		this.people = people;
	}

	public String navigateToAddForm() {
		//Pay attention to the name here, it will be used as the object name in add-person.xhtml
		//ex. <h:inputText value="#{newPerson.firstName}" id="firstName" />
		sessionMap.put( "newPerson", new PersonPojo());
		return "add-person?faces-redirect=true";
	}

	public String submitPerson( PersonPojo person) {
		//TODO use DAO, also update the Person object with current date. you can use Instant::now
		return null;
	}

	public String navigateToUpdateForm( int personId) {
		//TODO use session map to keep track of of the object being edited
		//use DAO to find the object
		return null;
	}

	public String submitUpdatedPerson( PersonPojo person) {
		//TODO use DAO
		return null;
	}

	public String deletePerson( int personId) {
		//TODO use DAO
		return null;
	}

}