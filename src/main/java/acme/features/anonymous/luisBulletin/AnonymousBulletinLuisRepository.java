
package acme.features.anonymous.luisBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.luisBulletin.LuisBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousBulletinLuisRepository extends AbstractRepository {

	@Query("select a from LuisBulletin a")
	Collection<LuisBulletin> findMany();
}
