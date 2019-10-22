
package acme.features.anonymous.fernandoBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.fernandoBulletin.FernandoBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousBulletinFernandoListService implements AbstractListService<Anonymous, FernandoBulletin> {

	//Internal state--------------------------------------------
	@Autowired
	private AnonymousBulletinFernandoRepository repository;


	//AbstractListService<Anonymous, FernandoBulletin> interface ----------
	@Override
	public boolean authorise(final Request<FernandoBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<FernandoBulletin> request, final FernandoBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "title", "text", "moment");

	}

	@Override
	public Collection<FernandoBulletin> findMany(final Request<FernandoBulletin> request) {
		assert request != null;

		Collection<FernandoBulletin> result;

		result = this.repository.findMany();
		return result;
	}

}
