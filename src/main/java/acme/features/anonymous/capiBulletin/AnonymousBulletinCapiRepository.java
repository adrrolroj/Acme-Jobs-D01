
package acme.features.anonymous.capiBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.capiBulletin.CapiBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousBulletinCapiRepository extends AbstractRepository {

	@Query("select a from CapiBulletin a")
	Collection<CapiBulletin> findMany();
}
