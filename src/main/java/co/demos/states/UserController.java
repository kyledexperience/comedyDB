package co.demos.states;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.demos.states.dao.UsersDao;
import co.demos.states.dao.UsersDaoOld;
import co.demos.states.entity.State;
import co.demos.states.entity.User;

@Controller
public class UserController {

	@Autowired
	private UsersDaoOld daoOld;

	@Autowired
	private UsersDao dao;

	@RequestMapping("/")
	public ModelAndView home() {

		ModelAndView mav = new ModelAndView("index");
		List<User> users = daoOld.findAll();
		List<State> states = dao.findAllStates();

		mav.addObject("list", users);
		mav.addObject("state", states);

		return mav;

	}

	@PostMapping("/")
	public ModelAndView add(@RequestParam("first") String first, @RequestParam("last") String last,
			@RequestParam("state") Integer state) {

		User user = new User();

		user.setFirstName(first);
		user.setLastName(last);

		if (state < 1) {
			user.setStateId(1);
		} else {
			user.setStateId(state);
		}

		dao.create(user);

		return new ModelAndView("redirect:/");

	}

	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable(value = "id", required = false) Long id) {

		ModelAndView mav = new ModelAndView("redirect:/");

		dao.detete(id);

		return mav;

	}

	@RequestMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable(value = "id", required = false) Long id) {

		ModelAndView mav = new ModelAndView("edit");
		List<State> states = dao.findStates();
		User user = dao.findById(id);

		mav.addObject("state", states);
		mav.addObject("user", user);

		return mav;

	}

	@PostMapping("/edit/{id}")
	public ModelAndView edited(@RequestParam("id") Long id, @RequestParam("stateId") Integer stateId) {

		ModelAndView mav = new ModelAndView("redirect:/");

		dao.update(id, stateId);

		return mav;

	}

}
