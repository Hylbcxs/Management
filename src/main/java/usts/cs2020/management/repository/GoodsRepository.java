package usts.cs2020.management.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import usts.cs2020.management.model.Question;
import usts.cs2020.management.model.Res;
import usts.cs2020.management.model.Student;
import usts.cs2020.management.model.goods;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsRepository extends CrudRepository<Student,Integer> {
    //插入数据
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO expenses(content,data,amount,goodspicture,receipt,acceptor) VALUES(:content,:data,:amount,:goodspicture,:receipt,:acceptor)",nativeQuery = true)
    int insertNewGoods(@Param("content") String content,
                       @Param("data") String date,
                       @Param("amount") String amount,
                       @Param("goodspicture") String goodspicture,
                       @Param("receipt") String receipt,
                       @Param("acceptor") String acceptor
                       );

    //查询所有数据
    @Query(value = "SELECT * FROM expenses",nativeQuery = true)
    List<Map<String,goods>> findAllgoods();

    //质疑插入
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO question(content,question,initiator) VALUES(:content,:question,:initiator)",nativeQuery = true)
    int insertquestion(@Param("content") String content,
                       @Param("question") String question,
                       @Param("initiator") String initiator);

    //列出所有质疑
    @Query(value = "SELECT * FROM question",nativeQuery = true)
    List<Map<String, Question>> findAllQuestion();

    //回复后加入response数据库
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO response(content,question,initiator,response) VALUES(:content,:question,:initiator,:response)",nativeQuery = true)
    int insertresponse(@Param("content") String content,
                       @Param("question") String question,
                       @Param("initiator") String initiator,
                       @Param("response") String response);

    //回复后删除question数据库中的一条
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM question WHERE content = :content",nativeQuery = true)
    int deletequestion(@Param("content") String content);

    //查询出response表中数据
    @Query(value = "SELECT * FROM response",nativeQuery = true)
    List<Map<String, Res>> findquestionandresponse();

    //取出当前确认的人数
    @Query(value = "SELECT number FROM confirm WHERE content = :content",nativeQuery = true)
    List<Integer> selectNumber(@Param("content") String content);
}
