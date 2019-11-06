package cn.yupcd.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yupcd.web.entities.User;
import cn.yupcd.web.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Optional<User> findById(long id){
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    
    public User update(User user){
        Optional<User> optionalUserEntity = userRepository.findById(user.getId());
        if(optionalUserEntity.isPresent()) {
            return userRepository.save(user);
        }
        return null;
    }
    
    public User save(User user){
        return userRepository.save(user);
    }
	
	public void delete(long id){
		userRepository.deleteById(id);
    }
}
