package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Record;

import java.util.List;

public interface RecordDao {
    List<Record> queryRecord();

    //根据userId和exhibitionId获得所有的Record
    List<Record> queryRecordById(Long userId, Long exhibitionId);

    //根据userId,exhibitionId和exhibitId获得特定展品的Record
    Record queryRecordByAllId(Long userId, Long exhibitionId, Long exhibitId);

    //根据userId,exhibitionId和exhibitId插入记录
    int insertRecord(Record record);

    //根据userId,exhibitionId和exhibitIdg更新记录
    int updateRecord(Record record);

    int deleteRecord(Long recordId);
}
