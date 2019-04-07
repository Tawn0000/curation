package io.github.tawn0000.curation.dao;

import java.util.List;

public interface E_tagDao {
    List<E_tag> queryE_tag();

    E_tag queryE_tagByid(int e_tagId);

    int insertE_tag(E_tag e_tag);

    int updateE_tag(E_tag e_tag);

    int deleteE_tag(int e_tagId);
}
