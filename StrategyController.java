package cn.wolfcode.lww.controller;

import cn.wolfcode.lww.domain.Comment;
import cn.wolfcode.lww.domain.Hotsell;
import cn.wolfcode.lww.domain.Strategy;
import cn.wolfcode.lww.domain.Travelnotes;
import cn.wolfcode.lww.service.CommentService;
import cn.wolfcode.lww.service.HotSellService;
import cn.wolfcode.lww.service.StrategyService;
import cn.wolfcode.lww.util.QueryObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/*
* 1看请求路径和携带参数
* 2mapper sql 语句怎么写？接口怎么写？返回值（不需要）
* 3service 事务 业务，aop 调用mapper
* 4controller 1调用service 2映射请求路径 3接收参数 4往前端设置参数 5响应
*
*
* */
@Controller
public class StrategyController {
    @Autowired
    HotSellService hotSellService;
    @Autowired
    StrategyService strategyService;
    @Autowired
    CommentService commentService;

    @RequestMapping("/getStrategyAll")
    public String getStrategyAll(Model model,QueryObject queryObject,String classify){

        //查询热卖信息
        List<Hotsell> hotsells = hotSellService.selectAll();
        //System.out.println(hotsells);

        //攻略
        PageInfo<Strategy> strategyPageInfo = strategyService.selectAll(queryObject,classify);
        //
        model.addAttribute("list",strategyPageInfo);  // list：看HTML each 后面那个 名字不是乱写的
        //E:\environment\javaEE_shixun_20220606start\lww\src\main\webapp\WEB-INF\views\strategy\strategy.html
        model.addAttribute("hotSellList",hotsells);  //http://localhost:8080/cover/hotsell/bz3.jpeg

        //分页看WEB-INF\views\strategy\strategy.html 的分页器&pom.xml的分页器
        //和application里面的 <!-- 传入PageHelper的插件 -->
        //        <property name="plugins">
        return "strategy/strategy";
    }

    @RequestMapping("/selectByPrimaryKey")
    public String selectByPrimaryKey(String id, Model model){
        Strategy strategy = strategyService.selectByPrimaryKey(id);
        model.addAttribute("strategy",strategy);

        //热售
        List<Hotsell> hotsells = hotSellService.selectAll();
        model.addAttribute("hotsells",hotsells);
        //攻略评论信息
        List<Comment> comments = commentService.queryComment(id, 0);
        model.addAttribute("commentList",comments);
        //攻略看到的次数
        strategyService.updateWatchById(id);
        return "strategy/strategy_content";
    }
    /*
    * 发布与编辑的数据回写
    *
    * */
    //发布页
    @RequestMapping("/pushStartEgy")
    public String pushStartEgy(String id,Model model){
        if(id==null){  //返回添加页
            model.addAttribute("type","insert");
            return "strategy/push";
        }else{//编辑页 根据id查询攻略信息并把之前历史数据信息设置在页面中 (service-mapper)
            model.addAttribute("type","update");
            Strategy strategy = strategyService.selectByPrimaryKey(id);
            //设置在页面中
            model.addAttribute("startEgy",strategy);
            return "strategy/push";
        }
    }

    @RequestMapping("/updateStartEgy")
    public String updateStartEgy(Strategy strategy){
        strategyService.updateByPrimaryKey(strategy);
        return "redirect:/getStrategyAll";
    }

    //实现插入自己的攻略
    @RequestMapping("/insertStartEgy")
    public String insertStartEgy(Strategy strategy){//实体类接收信息
        //调用service
        strategyService.insert(strategy);
        return "redirect:/getStrategyAll";
    }



    @RequestMapping("/deleteStartEgy")
    public String deleteStartEgy(String id){//实体类接收信息/参数
        //调用service
        strategyService.deleteByPrimaryKey(id);
        //删除评论  删掉文章还留着评论干嘛
        commentService.deleteByArtId(id);
        return "redirect:/getStrategyAll";
    }

}
