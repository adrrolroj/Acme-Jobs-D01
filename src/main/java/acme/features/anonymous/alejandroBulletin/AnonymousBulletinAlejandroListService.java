
package acme.features.anonymous.alejandroBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.alejandroBulletin.AlejandroBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousBulletinAlejandroListService implements AbstractListService<Anonymous, AlejandroBulletin> {

	//Internal state

	@Autowired
	private AnonymousBulletinAlejandroRepository repository;


	//AbstractListService<Anonymous,AlejandroBulletin> interface

	@Override
	public boolean authorise(final Request<AlejandroBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<AlejandroBulletin> request, final AlejandroBulletin entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "text", "moment");
	}

	@Override
	public Collection<AlejandroBulletin> findMany(final Request<AlejandroBulletin> request) {

		assert request != null;

		Collection<AlejandroBulletin> result;

		result = this.repository.findMany();
		return result;
	}

}
