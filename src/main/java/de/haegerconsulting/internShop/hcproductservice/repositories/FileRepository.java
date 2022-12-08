package de.haegerconsulting.internShop.hcproductservice.repositories;

import de.haegerconsulting.internShop.hcproductservice.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FileRepository extends JpaRepository<File, String> {

    List<File> findAllByProductName(String productName);
}
