package cn.wolfcode.lww.controller;

import cn.wolfcode.lww.domain.Comment;
import cn.wolfcode.lww.domain.Hotsell;
import cn.wolfcode.lww.domain.Strategy;
import cn.wolfcode.lww.domain.Travelnotes;
import cn.wolfcode.lww.service.CommentService;
import cn.wolfcode.lww.service.HotSellService;
import cn.wolfcode.lww.service.TravelnotesService;
import cn.wolfcode.lww.util.QueryObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TravelnotesController {
    @Autowired
    HotSellService hotSellService;
    @Autowired
    TravelnotesService travelnotesService;
    @Autowired
    CommentService commentService;
    @RequestMapping("/selectTravelNotesAll")
    public String selectTravelNotesAll(Model model,QueryObject queryObject){

        PageInfo<Travelnotes> travelnotesPageInfo = travelnotesService.selectAll(queryObject);
        model.addAttribute("list",travelnotesPageInfo);
        return "travel/travel_journal";
    }

    @RequestMapping("/selectTravelByPrimaryKey")
    public String selectTravelByPrimaryKey(String id, Model model, QueryObject queryObject){
        Travelnotes travelnotes = travelnotesService.selectByPrimaryKey(id);
        model.addAttribute("travelnote",travelnotes);

        //
        //攻略评论信息
        List<Comment> comments = commentService.queryComment(id,1);
        model.addAttribute("commentList",comments);

        travelnotesService.updateWatchById(id);
        return "travel/travel_journal_content";
    }
    @RequestMapping("/pushTravelNotes")
    public  String pushTravelNotes(String id,Model model) {
        if (id == null) {
            //添加页

            model.addAttribute("type", "insert");
            return "travel/push";
        } else {
            //编辑页
            model.addAttribute("type", "update");
            //根据id查询攻略信息并把设置在页面中（service——mapper）
            Travelnotes travelnotes = travelnotesService.selectByPrimaryKey(id);
            //设置在页面中
            model.addAttribute("travelnotes", travelnotes);
            return "travel/push";
        }
    }
    //实现插入自己的游记
    @RequestMapping("/insertTravelNotes")
    public String insertTravelNotes(Travelnotes travelnotes){//实体类接收信息
        //调用service
        travelnotesService.insert(travelnotes);
        return "redirect:/selectTravelNotesAll";
    }

    //删除自己的游记
    @RequestMapping("/updateTravelNotes")
    public String updateTravelNotes(Travelnotes travelnotes){
        travelnotesService.updateByPrimaryKey(travelnotes);
        return "redirect:/selectTravelNotesAll";
    }



    @RequestMapping("/deleteTravelNote")
    public String deleteTravelNote(String id){
        travelnotesService.deleteByPrimaryKey(id);
        //删除评论
        commentService.deleteByArtId(id);
        return "redirect:/selectTravelNotesAll";
    }
}
