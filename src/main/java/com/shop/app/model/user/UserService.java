package com.shop.app.model.user;

import com.shop.app.model.user.dto.RequestUser;
import com.shop.app.model.user.dto.ResponseUser;
import com.shop.app.model.user.predicate.UserPredicate;
import com.shop.app.model.user.repository.UserRepository;
import com.shop.app.model.user.repository.UserRepositorySupport;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserRepositorySupport userRepositorySupport;

    public ResponseUser signUp(RequestUser request){
        User user = User.builder()
                .loginId(request.getLoginId())
                .name(request.getName())
                .password(request.getPassword())
                .build();
        return modelMapper.map(userRepository.save(user),ResponseUser.class);
    }
    public List<ResponseUser> findAll() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user,ResponseUser.class)).collect(Collectors.toList());
    }
    public ResponseUser findLoginId(String id) {
        return modelMapper.map(userRepository.findByLoginId(id), ResponseUser.class);
    }
    public List<ResponseUser> findName(String name) {
        return userRepositorySupport.findByName(name).stream().map(user -> modelMapper.map(user,ResponseUser.class)).collect(Collectors.toList());
    }
}
