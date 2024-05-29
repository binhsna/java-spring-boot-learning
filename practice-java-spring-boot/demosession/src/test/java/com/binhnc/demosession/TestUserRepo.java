package com.binhnc.demosession;

import com.binhnc.demosession.Repository.UserRepo;
import com.binhnc.demosession.model.State;
import com.binhnc.demosession.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

///////@SpringBootTest
class TestUserRepo {
    @Test
    public void addUser() {
        UserRepo userRepo = new UserRepo();
        User user = userRepo.addUser("Nguyễn Công Bình", "binhsna@gmail.com", "124sxck", State.PENDING);
        assertThat(user).isNotNull();
        System.out.println(user.getId());
        assertThat(user.getId()).isNotBlank();
    }

    @Test
    public void addUserWithPendingState() {
        UserRepo userRepo = new UserRepo();
        User user = userRepo.addUser("Nguyễn Công Bình", "binhsna@gmail.com", "124sxck");
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotBlank();
        assertThat(user.getState()).isEqualTo(State.PENDING);
    }

    @Test
    public void isEmailExit() {
        UserRepo userRepo = new UserRepo();
        userRepo.addUser("Nguyễn Công Bình", "binhsna@gmail.com", "124sxck", State.PENDING);
        userRepo.addUser("Nguyễn Công Nam", "namnc@gmail.com", "124sxck", State.PENDING);
        userRepo.addUser("Nguyễn Trung Tâm", "tamnt@gmail.com", "124sxck", State.PENDING);

        assertThat(userRepo.isEmailExist("binhsna@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("namnc@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("tamnt@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("Tamnt@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("Tamnt02@gmail.com")).isFalse();
    }

    @Test
    public void findByEmail() {
        UserRepo userRepo = new UserRepo();
        userRepo.addUser("Nguyễn Công Bình", "binhsna@gmail.com", "124sxck", State.PENDING);
        userRepo.addUser("Nguyễn Công Nam", "namnc@gmail.com", "124sxck", State.PENDING);
        userRepo.addUser("Nguyễn Trung Tâm", "tamnt@gmail.com", "124sxck", State.PENDING);

        assertThat(userRepo.findByEmail("binhsna@gmail.com")).isPresent();
        assertThat(userRepo.findByEmail("afd@gmail.com")).isNotPresent();
    }
}
