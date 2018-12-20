package org.lanqiao.service;

import org.aspectj.lang.annotation.Pointcut;
import org.lanqiao.service.impl.IUserService;
import org.springframework.stereotype.Service;

@Service("userservice")
public class UserService implements IUserService {
    @Override
    @Pointcut("execution(* *..UserService.doSome(..))")
    public void doSome() {
//        int[] arr = new int[2];
//        try{
//            System.out.println(arr[2]);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        System.out.println("主业务逻辑方法");
    }

    @Override
    public Object doSome(String username) {
    //    System.out.println(1/0);
        System.out.println("主业务逻辑方法   doSome"+username);
        return username;
    }
@Override
    public String doOther(){
        System.out.println("doOther.........");
        return "hello";
    }
}
