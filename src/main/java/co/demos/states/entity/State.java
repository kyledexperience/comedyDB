package co.demos.states.entity;

public class State {

	private Integer stateId;
	private String state;

	public State(Integer stateId, String state) {
		super();
		this.stateId = stateId;
		this.state = state;
	}

	public State() {

	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", state=" + state + "]";
	}

	public Integer getStateId() {
		return stateId;
	}

	public String getState() {
		return state;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public void setState(String state) {
		this.state = state;
	}

}
