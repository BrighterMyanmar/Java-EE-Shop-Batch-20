package r.r.services;

import java.util.List;

import org.springframework.stereotype.Service;

import r.r.dtos.ChildcatDto;
import r.r.models.Childcat;

@Service
public interface ChildcatService {
   Childcat save(ChildcatDto childcatDto);

   List<Childcat> all();

   Childcat get(int id);

   Childcat update(int id, ChildcatDto childcatDto);

   Childcat nameChange(int id, ChildcatDto childcatDto);

   Childcat imageChange(int id, ChildcatDto childcatDto);

   Childcat subcatChange(int id, ChildcatDto childcatDto);

   String drop(int id);
}
