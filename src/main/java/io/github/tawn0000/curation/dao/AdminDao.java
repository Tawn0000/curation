package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Admin;

import java.util.List;

public interface AdminDao {
    List<Admin> queryAdmin();

    Admin queryAdminById(int adminId);

    int insertAdmin(Admin admin);

    int updateAdmin(Admin admin);

    int deleteAdmin(int adminId);
}
