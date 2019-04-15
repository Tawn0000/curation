package io.github.tawn0000.curation.service;

import io.github.tawn0000.curation.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> queryAdmin();

    Admin queryAdminByid(int adminId);

    Boolean insertAdmin(Admin admin);

    Boolean updateAdmin(Admin admin);

    Boolean deleteAdmin(int adminId);
}
