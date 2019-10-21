
package acme.features.anonymous.fernandoBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.fernandoBulletin.FernandoBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousbulletinFernandoRepository extends AbstractRepository {

	@Query("select a from FernandoBulletin a")
	Collection<FernandoBulletin> findMany();
}
