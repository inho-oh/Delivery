package usedbookstore;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface DeliveryRepository extends PagingAndSortingRepository<Delivery, Long>{


}