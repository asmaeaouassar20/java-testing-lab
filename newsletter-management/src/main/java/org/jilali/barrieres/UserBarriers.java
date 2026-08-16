package org.jilali.barrieres;

public class UserBarriers {
    private  UserRepository userRepository;
    private  EmailService emailService;
    public UserBarriers(UserRepository userRepository, EmailService emailService){
        this.userRepository=userRepository;
        this.emailService=emailService;
    }
    public void userPermit(int userId1){
        userRepository.registerUserOnApp(userId1);
        emailService.notifyUser(userId1);
    }
}
