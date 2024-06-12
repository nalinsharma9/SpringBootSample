package com.telusko.demo.bootjpa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.bootjpa.dao.AlienRepo;
import com.telusko.demo.bootjpa.model.Alien;

import java.util.List;
import java.util.Optional;


@Controller
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }


    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){
        repo.save(alien);
        return "home.jsp";
    }

//    @RequestMapping("/getAlien")
//    public ModelAndView getAlien(@RequestParam int aid){
//        ModelAndView mv = new ModelAndView("showAlien.jsp");
//        Alien alien = repo.findById(aid).orElse(new Alien());
//        mv.addObject(alien);
//
//        System.out.println(repo.findByTech("Java"));
//        System.out.println(repo.findByAidGreaterThan(101));
//        System.out.println(repo.findByTechSorted("Java"));
//        return mv;
//    }

    //produces will restrict the data to be returned only in the format mentioned
    //@RequestMapping(value = "aliens",produces = {"application/xml"})
    @RequestMapping(value = "aliens")
    @ResponseBody //this annotation will return the data as it is without looking for any view name
    public List<Alien> getAliens(){
        //jackson-core automatically converts java object into Json when we return data from controller
        return repo.findAll();
    }

    @RequestMapping("alien/{aid}")
    @ResponseBody //this annotation will return the data as it is without looking for any view name
    public Optional<Alien> getAliens(@PathVariable("aid") int aid){
        return repo.findById(aid);
    }


}
