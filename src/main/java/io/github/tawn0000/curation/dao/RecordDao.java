package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Record;

import java.util.List;

public interface RecordDao {
    List<Record> queryRecord();

    Record queryRecordByid(int recordId);

    int insertRecord(Record record);

    int updateRecord(Record record);

    int deleteRecord(int recordId);
}
