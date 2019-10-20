
package acme.features.anonymous.capiBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.capiBulletin.CapiBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousBulletinCapiCreateService implements AbstractCreateService<Anonymous, CapiBulletin> {

	//Internal state--------------------------------------------
	@Autowired
	private AnonymousBulletinCapiRepository repository;


	//AbstractCreateService<Anonymous, CapiBulletin> interface ----------
	@Override
	public boolean authorise(final Request<CapiBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<CapiBulletin> request, final CapiBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<CapiBulletin> request, final CapiBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "text", "moment");

	}

	@Override
	public CapiBulletin instantiate(final Request<CapiBulletin> request) {
		assert request != null;

		CapiBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result = new CapiBulletin();
		result.setAuthor("Capi");
		result.setTitle("CreandoBulletin");
		result.setMoment(moment);
		result.setText("Texto de ejemplo");
		return result;
	}

	@Override
	public void validate(final Request<CapiBulletin> request, final CapiBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<CapiBulletin> request, final CapiBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
