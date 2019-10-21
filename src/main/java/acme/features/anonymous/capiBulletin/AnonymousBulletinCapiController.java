
package acme.features.anonymous.capiBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.capiBulletin.CapiBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/capi-bulletin/")
public class AnonymousBulletinCapiController extends AbstractController<Anonymous, CapiBulletin> {

	//Internal state

	@Autowired
	private AnonymousBulletinCapiListService	listService;
	@Autowired
	private AnonymousBulletinCapiCreateService	createService;


	//Constructor

	@PostConstruct
	private void initialise() {
		this.addBasicCommand(BasicCommand.LIST, this.listService);
		this.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
