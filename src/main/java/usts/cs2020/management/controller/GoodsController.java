package usts.cs2020.management.controller;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import usts.cs2020.management.model.Question;
import usts.cs2020.management.model.Res;
import usts.cs2020.management.model.goods;
import usts.cs2020.management.service.GoodsService;

import java.util.List;
import java.util.Map;

@Repository
@RequestMapping(value = "/goods",method = {RequestMethod.GET,RequestMethod.POST})
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    //新增收支情况
    @PostMapping("/insert")
    public ResponseEntity insertNewGoods(@RequestParam("content") String content,
                                         @RequestParam("data") String data,
                                         @RequestParam("amount") String amount,
                                         @RequestParam("goodspicture") String goodspicture,
                                         @RequestParam("receipt") String receipt,
                                         @RequestParam("acceptor") String acceptor){
        int result = goodsService.insertNewGoods(content,data, amount, goodspicture, receipt, acceptor);
        if(result != 1){
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
    }
    //查询所有数据
    @PostMapping("/findall")
    public ResponseEntity findAllgoods(){
        List<Map<String,goods>> findAllgoods = goodsService.findAllgoods();
        return new ResponseEntity(findAllgoods,HttpStatus.OK);
    }

    //插入质疑
    @PostMapping("/insertquestion")
    public ResponseEntity insertquestion(@RequestParam("content") String content,
                                         @RequestParam("question") String question,
                                         @RequestParam("initiator") String initiator){
        int result = goodsService.insertquestion(content, question,initiator);
        if(result != 1){
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
    }

    //查询所有质疑
    @PostMapping("/findallquestion")
    public ResponseEntity findAllQuestion(){
        List<Map<String, Question>> findAllquestion = goodsService.findAllQuestion();
        return new ResponseEntity(findAllquestion,HttpStatus.OK);
    }

    //回复后插入数据库
    @PostMapping("/insertresponse")
    public ResponseEntity insertresponse(@RequestParam("content") String content,
                                         @RequestParam("question") String question,
                                         @RequestParam("initiator") String initiator,
                                         @RequestParam("response") String response){
        int result2 = goodsService.deletequestion(content);
        int result = goodsService.insertresponse(content, question, initiator, response);
        if(result != 1 || result2 != 1){
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
    }

    //查询所有的问题和已经解答的质疑
    @PostMapping("/findquestionandresponse")
    public ResponseEntity findquestionandresponse(){
        List<Map<String, Res>> findquestionandresponse = goodsService.findquestionandresponse();
        return new ResponseEntity(findquestionandresponse,HttpStatus.OK);
    }

    //取出当前确认的人数
    @PostMapping("/selectnumber")
    public ResponseEntity selectNumber(@RequestParam("content") String content){
        List<Integer> num = goodsService.selectNumber(content);
        return new ResponseEntity(num,HttpStatus.OK);
    }
}
