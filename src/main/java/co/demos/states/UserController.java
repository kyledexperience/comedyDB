package co.demos.states;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.demos.states.dao.UsersDao;
import co.demos.states.dao.UsersDaoOld;
import co.demos.states.entity.User;

@Controller
public class UserController {

	@Autowired
	private UsersDaoOld daoOld;

	@Autowired
	private UsersDao dao;

	@RequestMapping("/")
	public ModelAndView home() {

		List<User> users = daoOld.findAll();

		return new ModelAndView("index", "list", users);

	}

	@PostMapping("/")
	public ModelAndView add(@RequestParam("first") String first, @RequestParam("last") String last,
			@RequestParam("state") Integer state) {

		User user = new User();
		int size = dao.findAll().size();
		user.setId((long) size + 1);

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

}
