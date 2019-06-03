package com.example.demo;
import com.example.demo.Admin.Admin;
import com.example.demo.Book.Book;
import com.example.demo.Book.BookType_Num;
import com.example.demo.Book.BookType_Numrespository;
import com.example.demo.Book.Bookrespository;
import com.example.demo.LoginAdmin.LoginAdmin;
import com.example.demo.LoginAdmin.LoginAdminrespository;
import com.example.demo.Num.Num;
import com.example.demo.Num.Numrespository;
import com.example.demo.Admin.Adminrespository;
import com.example.demo.User.User;
import com.example.demo.User.Userrespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/rest")
public class LoginController  {
  @Autowired
  Adminrespository adminrespository;
  @Autowired
  Numrespository numrespository;
  @Autowired
  LoginAdminrespository loginAdminrespository;
  @Autowired
    Bookrespository bookrespository;
  @Autowired
  Userrespository userrespository;
  @Autowired
  BookType_Numrespository bookType_numrespository;
    //判断登录的正确性
    @RequestMapping(value = "/admin/login")
    @ResponseBody
    public  String login(@RequestParam String username,@RequestParam String password){
        boolean exist= loginAdminrespository.existsAdminByUsername(username);
        if (exist){
            LoginAdmin loginAdmin = loginAdminrespository.findByUsername(username);
            if (loginAdmin.getPassword().equals(password)){
                return "success";
            }
            else{
                return "failed";
            }

        }else return "failed";



    }
    //取得用户的信息
    @RequestMapping(value = "/logindata")

    public  List<Admin> logindata(){

        List<Admin>list=new ArrayList<>();
        list= adminrespository.findAll();
        return list;

    }
    //取得书本的信息
    @RequestMapping(value = "/bookdata")
    public  List<Book> bookdata(){
        List<Book>list=new ArrayList<>();
        list=bookrespository.findAll();
        return list;
    }
    @RequestMapping(value = "/userdata")
    public List<User>userdata(){
        List<User>list=new ArrayList<>();
        list= userrespository.findAll();
        return list;
    }
    @RequestMapping(value = "/numdata")
    @ResponseBody
    public List<Num>numdata(){
        List<Num>list=new ArrayList<>();
        list=numrespository.findAll();
        return list;
    }
    @RequestMapping(value="/booktype_num_data")
    @ResponseBody
    public List<BookType_Num>booktype_num_data(){
        List<BookType_Num>list=bookType_numrespository.findAll();

        return list;
    }
//    @RequestMapping(value="")
//    @ResponseBody
//    public Map<String ,String>

    //返回管理员的数量
    @RequestMapping(value = "/adminnum")
    public int adminnum(){
        List<Num>list=new ArrayList<>();
        list=numrespository.findAll();
        int num=Integer.valueOf(list.get(0).getAdminnum());
        return num;
    }
    @RequestMapping(value="/booknum")
    public int booknum(){
        List<Num>list=new ArrayList<>();
        list=numrespository.findAll();
        int num=Integer.valueOf(list.get(0).getBooknum());
        return num;
    }
    @RequestMapping(value="/usernum")
    public int usernum(){
        List<Num>list=new ArrayList<>();
        list=numrespository.findAll();
        int num=Integer.valueOf(list.get(0).getUsernum());
        return num;
    }
    //加管理员
    @PostMapping(value="/admin/add")
    public void add(@RequestParam String name, @RequestParam String  date ,
                    @RequestParam String sex, @RequestParam String iphone ,@RequestParam String email ){

        adminrespository.save(new Admin(sex,  name,  date,  iphone, email));
        numrespository.updateAdminNum();
        System.out.println("成功");

    }
    //加登录名
    @PostMapping(value="/admin/add2")
    public void add2(@RequestParam String name, @RequestParam String password ){

       loginAdminrespository.save(new LoginAdmin(name,password));

        System.out.println("成功");

    }
    @PostMapping(value = "/book/add")
    public void bookadd(@RequestParam int bid,@RequestParam String bname ,@RequestParam String author,
                        @RequestParam String press,@RequestParam String remark,@RequestParam String type,@RequestParam float price ,@RequestParam int num){
        System.out.println("bid"+bid);
        bookrespository.save(new Book(bid,bname,author,press,remark,price,type,num));
        numrespository.updateBookNum();
        BookType_Num bookType_num=null;
        bookType_num=bookType_numrespository.findByName(type);
        if (bookType_num==null){
            bookType_numrespository.update2(type);
        }
        else{
            bookType_numrespository.update(type);
        }



        System.out.println("成功");
    }
    @PostMapping(value = "/user/add")
    public void bookadd(@RequestParam int uid,@RequestParam String uname,@RequestParam String usex,@RequestParam String uaddress,
                        @RequestParam String udate,@RequestParam  String uiphone ,@RequestParam String uemail){
       userrespository.save(new User(uid,uname,usex,uaddress,udate,uiphone,uemail));
       numrespository.updateUserNum();
        System.out.println("成功");
    }

    //管理员编辑
    @PostMapping(value="/admin/edit")
    public void adminedit(@RequestParam String number,@RequestParam String name, @RequestParam String  date ,
                     @RequestParam String sex, @RequestParam String iphone ,@RequestParam String email){
       Admin admin = adminrespository.findByNumber(Integer.valueOf(number));
       admin.setDate(date);
       admin.setEmail(email);
       admin.setIphone(iphone);
       admin.setName(name);
       admin.setSex(sex);
        adminrespository.save(admin);
        System.out.println("修改成功");
    }
    @PostMapping(value = "/book/edit")
    public void bookedit(@RequestParam int bid,@RequestParam String bname ,@RequestParam String author,
                         @RequestParam String press,@RequestParam String remark,@RequestParam String type,@RequestParam float price ,@RequestParam int num){
                Book book=bookrespository.findByBid(Integer.valueOf(bid));
                book.setAuthor(author);
                book.setBname(bname);
                book.setNum(num);
                book.setPress(press);
                book.setRemark(remark);
                book.setType(type);
                book.setPrice(price);
                bookrespository.save(book);

                System.out.println("修改成功");
    }
    @PostMapping(value = "/user/edit")
    public void useredit(@RequestParam int uid,@RequestParam String uname,@RequestParam String usex,@RequestParam String uaddress,
                         @RequestParam String udate,@RequestParam  String uiphone ,@RequestParam String uemail){
        User user=userrespository.findByUid(uid);
        user.setUname(uname);
        user.setUsex(usex);
        user.setUaddress(uaddress);
        user.setUdate(udate);
        user.setUiphone(uiphone);
        user.setUemail(uemail);
        userrespository.save(user);
        System.out.println("修改成功");
    }

    @PostMapping(value = "/admin/dele")
    public void admindele(@RequestParam String number){
        Admin admin = adminrespository.findByNumber(Integer.valueOf(number));
        LoginAdmin loginAdmin = loginAdminrespository.findByNumber(Integer.valueOf(number));

        adminrespository.delete(admin);
        loginAdminrespository.delete(loginAdmin);
        numrespository.increaseAdminNum();
        System.out.println("删除成功");
    }
    @PostMapping(value = "/book/dele")
    public void bookdele(@RequestParam int bid,@RequestParam String type)
    {   BookType_Num bookType_num=bookType_numrespository.findByName(type);
        Book book=bookrespository.findByBid(bid);
        if (bookType_num.getValue()==1){
            bookType_numrespository.increase2(type);
        }else{
            bookType_numrespository.increase(type);
        }


        bookrespository.delete(book);
        numrespository.increaseBookNum();


        System.out.println("删除成功");

    }
    @PostMapping(value="/user/dele")
    public void userdele(@RequestParam int uid){
        User user=userrespository.findByUid(uid);
        userrespository.delete(user);
        numrespository.increaseUserNum();
        System.out.println("删除成功");
    }

//    @PostMapping(value = "/del")
//    public String del(@RequestParam int  id){
//        userrespository.delete(new Admin(id));
//        return "已经删除";
//    }
//    @PostMapping(value = "/add")
//    public String add(@RequestParam String  name, @RequestParam String password, @RequestParam String iphone){
//        System.out.println(name);
//
//        userrespository.save(new Admin(name,password,iphone));
//
//        return "已经添加";
//    }
//    @GetMapping(value = "/select")
//    public Object get(@RequestParam Integer id){
//
//        return  userrespository.findById(id);
//    }
//    @PostMapping(value = "/update")
//    public String update (@RequestParam int id, @RequestParam String  name, @RequestParam String password, @RequestParam String iphone){
//        Admin user=new Admin(id,name,password,iphone);
//        userrespository.save(user);
//        return "成功修改";
//    }



}
