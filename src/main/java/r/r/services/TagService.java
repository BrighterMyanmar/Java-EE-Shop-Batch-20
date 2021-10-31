package r.r.services;

import java.util.List;

import org.springframework.stereotype.Service;

import r.r.dtos.TagDto;
import r.r.models.Tag;

@Service
public interface TagService {
   String save(TagDto tagDto);

   Tag get(int id);

   List<Tag> all();

   Tag update(int id, TagDto tagDto);

   String drop(int id);

}
