
package acme.features.anonymous.fernandoBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.fernandoBulletin.FernandoBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousBulletinFernandoCreateService implements AbstractCreateService<Anonymous, FernandoBulletin> {

	//Internal state--------------------------------------------
	@Autowired
	private AnonymousbulletinFernandoRepository repository;


	//AbstractCreateService<Anonymous, AdrianBulletin> interface ----------
	@Override
	public boolean authorise(final Request<FernandoBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<FernandoBulletin> request, final FernandoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<FernandoBulletin> request, final FernandoBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "text", "moment");

	}

	@Override
	public FernandoBulletin instantiate(final Request<FernandoBulletin> request) {
		assert request != null;

		FernandoBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result = new FernandoBulletin();
		result.setAuthor("Juan");
		result.setTitle("Bulletin");
		result.setMoment(moment);
		result.setText("Hola");
		return result;
	}

	@Override
	public void validate(final Request<FernandoBulletin> request, final FernandoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<FernandoBulletin> request, final FernandoBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
