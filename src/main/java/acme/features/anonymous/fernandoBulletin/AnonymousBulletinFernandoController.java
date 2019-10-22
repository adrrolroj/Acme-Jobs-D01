
package acme.features.anonymous.fernandoBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.fernandoBulletin.FernandoBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/fernando-bulletin/")
public class AnonymousBulletinFernandoController extends AbstractController<Anonymous, FernandoBulletin> {

	//Internal state--------------------------
	@Autowired
	private AnonymousBulletinFernandoListService	listService;
	@Autowired
	private AnonymousBulletinFernandoCreateService	createService;


	//Constructor-----------------------------
	@PostConstruct
	private void initialise() {
		this.addBasicCommand(BasicCommand.LIST, this.listService);
		this.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
