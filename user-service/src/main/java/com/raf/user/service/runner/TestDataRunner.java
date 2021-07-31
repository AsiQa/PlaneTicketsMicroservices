package com.raf.user.service.runner;

import com.raf.user.service.domain.Role;
import com.raf.user.service.domain.User;
import com.raf.user.service.domain.UserStatus;
import com.raf.user.service.repository.RoleRepository;
import com.raf.user.service.repository.UserRepository;
import com.raf.user.service.repository.UserStatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile({"default"})
@Component
public class TestDataRunner implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private UserStatusRepository userStatusRepository;

    public TestDataRunner(RoleRepository roleRepository, UserRepository userRepository, UserStatusRepository userStatusRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userStatusRepository = userStatusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Insert roles
        Role roleUser = new Role("ROLE_USER", "User role");
        Role roleAdmin = new Role("ROLE_ADMIN", "Admin role");
        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);
        //Insert admin
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin");
        admin.setRole(roleAdmin);
        admin.setMilje(30000);
        userRepository.save(admin);

        //User statuses
        userStatusRepository.save(new UserStatus(0,999, 0));
        userStatusRepository.save(new UserStatus(1000, 9999, 10));
        userStatusRepository.save(new UserStatus(10000, 999999, 20));
    }
}

