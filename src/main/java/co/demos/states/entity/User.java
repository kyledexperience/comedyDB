package co.demos.states.entity;

public class User {

	private Long id;
	private String firstName;
	private String lastName;
	private Integer stateId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User() {

	}

	public User(Long id, String firstName, String lastName, Integer stateId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.stateId = stateId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

}
