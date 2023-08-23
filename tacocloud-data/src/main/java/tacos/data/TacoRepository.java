package tacos.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.Optional;

import tacos.Taco;

//@CrossOrigin(origins="*") // 추가됨
public interface TacoRepository 
         extends PagingAndSortingRepository<Taco, Long> {
	
	Optional<Taco> findById(Long id);
	Taco save(Taco taco);


}
