package r.r.services;

import java.util.List;

import org.springframework.stereotype.Service;

import r.r.dtos.SubcatDto;
import r.r.models.Subcat;

@Service
public interface SubcatService {
   Subcat save(SubcatDto subcatDto);

   Subcat get(int id);

   List<Subcat> all();

   Subcat update(int id, SubcatDto subcatDto);

   Subcat nameChange(int id, SubcatDto subcatDto);

   Subcat imageChange(int id, SubcatDto subcatDto);

   String drop(int id);
}
