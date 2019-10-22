
package acme.features.anonymous.luisBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.luisBulletin.LuisBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousBulletinLuisCreateService implements AbstractCreateService<Anonymous, LuisBulletin> {

	//Internal state--------------------------------------------
	@Autowired
	private AnonymousBulletinLuisRepository repository;


	//AbstractCreateService<Anonymous, LuisBulletin> interface ----------
	@Override
	public boolean authorise(final Request<LuisBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<LuisBulletin> request, final LuisBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<LuisBulletin> request, final LuisBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "text", "moment");

	}

	@Override
	public LuisBulletin instantiate(final Request<LuisBulletin> request) {
		assert request != null;

		LuisBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result = new LuisBulletin();
		result.setAuthor("Pepe");
		result.setTitle("Bulletin");
		result.setMoment(moment);
		result.setText("Saludos");
		return result;
	}

	@Override
	public void validate(final Request<LuisBulletin> request, final LuisBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<LuisBulletin> request, final LuisBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
