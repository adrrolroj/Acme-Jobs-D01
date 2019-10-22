
package acme.features.anonymous.alejandroBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.alejandroBulletin.AlejandroBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/alejandro-bulletin/")
public class AnonymousBulletinAlejandroController extends AbstractController<Anonymous, AlejandroBulletin> {

	//Internal state

	@Autowired
	private AnonymousBulletinAlejandroListService	listService;
	@Autowired
	private AnonymousBulletinAlejandroCreateService	createService;


	//Constructor

	@PostConstruct
	private void initialise() {
		this.addBasicCommand(BasicCommand.LIST, this.listService);
		this.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
