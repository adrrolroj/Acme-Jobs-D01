
package acme.features.anonymous.adrianBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.adrianBulletin.AdrianBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousBulletinAdrianCreateService implements AbstractCreateService<Anonymous, AdrianBulletin> {

	//Internal state--------------------------------------------
	@Autowired
	private AnonymousBulletinAdrianRepository repository;


	//AbstractCreateService<Anonymous, AdrianBulletin> interface ----------
	@Override
	public boolean authorise(final Request<AdrianBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<AdrianBulletin> request, final AdrianBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<AdrianBulletin> request, final AdrianBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "text", "moment");

	}

	@Override
	public AdrianBulletin instantiate(final Request<AdrianBulletin> request) {
		assert request != null;

		AdrianBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		result = new AdrianBulletin();
		result.setAuthor("Juan");
		result.setTitle("Bulletin");
		result.setMoment(moment);
		result.setText("Hola");
		return result;
	}

	@Override
	public void validate(final Request<AdrianBulletin> request, final AdrianBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<AdrianBulletin> request, final AdrianBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
