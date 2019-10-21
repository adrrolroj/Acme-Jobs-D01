
package acme.features.anonymous.luisBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.luisBulletin.LuisBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/luis-bulletin/")
public class AnonymousBulletinLuisController extends AbstractController<Anonymous, LuisBulletin> {

	//Internal state--------------------------

	@Autowired
	private AnonymousBulletinLuisListService	listService;
	@Autowired
	private AnonymousBulletinLuisCreateService	createService;


	//Constructor-----------------------------

	@PostConstruct
	private void initialise() {
		this.addBasicCommand(BasicCommand.LIST, this.listService);
		this.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
