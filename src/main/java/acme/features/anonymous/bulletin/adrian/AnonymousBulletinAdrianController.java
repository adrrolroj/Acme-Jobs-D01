
package acme.features.anonymous.bulletin.adrian;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.bulletin.adrian.AdrianBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/bulletin/adrian/")
public class AnonymousBulletinAdrianController extends AbstractController<Anonymous, AdrianBulletin> {

	//Internal state--------------------------
	@Autowired
	private AnonymousBulletinAdrianListService		listService;
	@Autowired
	private AnonymousBulletinAdrianCreateService	createService;


	//Constructor-----------------------------
	@PostConstruct
	private void initialise() {
		this.addBasicCommand(BasicCommand.LIST, this.listService);
		this.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
