package usts.cs2020.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cs2020.management.model.Question;
import usts.cs2020.management.model.Res;
import usts.cs2020.management.model.goods;
import usts.cs2020.management.repository.GoodsRepository;

import java.util.List;
import java.util.Map;

@Service
public class GoodsService {
    @Autowired
    GoodsRepository goodsRepository;

    public int insertNewGoods(String content,String data,String amount,String goodspicture,String receipt,String acceptor){
        return goodsRepository.insertNewGoods(content,data, amount, goodspicture, receipt, acceptor);
    }

    public List<Map<String,goods>> findAllgoods(){
        return goodsRepository.findAllgoods();
    }

    public int insertquestion(String content,String question,String initiator){
        return goodsRepository.insertquestion(content, question,initiator);
    }

    public List<Map<String, Question>> findAllQuestion(){
        return goodsRepository.findAllQuestion();
    }
    public int insertresponse(String content,String question,String initiator,String response){
        return goodsRepository.insertresponse(content, question, initiator, response);
    }
    public int deletequestion(String content){
        return goodsRepository.deletequestion(content);
    }
    public List<Map<String, Res>> findquestionandresponse(){
        return goodsRepository.findquestionandresponse();
    }
    public List<Integer> selectNumber(String content){
        return goodsRepository.selectNumber(content);
    }
}
