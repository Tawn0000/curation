package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Admin;

import java.util.List;

public interface AdminDao {
    List<Admin> queryAdmin();

    Admin queryAdminByid(int adminId);

    void insertAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(int adminId);
}
