package com.company.demo.service;

import com.company.demo.entity.User;
import com.company.demo.exception.NotFoundException;
import com.company.demo.model.dto.UserDto;
import com.company.demo.model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static final ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1, "Nguyễn Công Bình", "binhsna@gmail.com", "0971912776", "avatar.img", "123"));
        users.add(new User(2, "Nguyễn Công Nam", "namnc@gmail.com", "0971912777", "avatar.img", "123"));
        users.add(new User(3, "Nguyễn Thị Mơ", "monguyenthi@gmail.com", "0971912754", "avatar.img", "123"));
        users.add(new User(4, "Lê Văn Mạnh", "manhlv@gmail.com", "0971912734", "avatar.img", "123"));
        users.add(new User(5, "Phan Đinh Tùng", "tungdinh@gmail.com", "0971912767", "avatar.img", "123"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("User không tồn tại trong hệ thống");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains(keyword)) {
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }
}
