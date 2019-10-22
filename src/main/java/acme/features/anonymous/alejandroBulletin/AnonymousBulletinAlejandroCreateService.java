
package acme.features.anonymous.alejandroBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.alejandroBulletin.AlejandroBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousBulletinAlejandroCreateService implements AbstractCreateService<Anonymous, AlejandroBulletin> {

	//Internal state--------------------------------------------
	@Autowired
	private AnonymousBulletinAlejandroRepository repository;


	//AbstractCreateService<Anonymous, AlejandroBulletin> interface ----------
	@Override
	public boolean authorise(final Request<AlejandroBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<AlejandroBulletin> request, final AlejandroBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<AlejandroBulletin> request, final AlejandroBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "text", "moment");

	}

	@Override
	public AlejandroBulletin instantiate(final Request<AlejandroBulletin> request) {
		assert request != null;

		AlejandroBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result = new AlejandroBulletin();
		result.setAuthor("Alejandro");
		result.setTitle("CreandoBulletin");
		result.setMoment(moment);
		result.setText("Texto de ejemplo");
		return result;
	}

	@Override
	public void validate(final Request<AlejandroBulletin> request, final AlejandroBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<AlejandroBulletin> request, final AlejandroBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
