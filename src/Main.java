import com.BigDate1421_Dduo.JavaBean.Food;
import com.BigDate1421_Dduo.JavaBean.User;
import com.BigDate1421_Dduo.Start.StartChoose;
import com.BigDate1421_Dduo.Takeout.Choose5_Order;
import com.BigDate1421_Dduo.Takeout.TakeoutChoose;
import com.BigDate1421_Dduo.Tools.Music;

public class Main {

    public static void main(String[] args) {

        //添加用户样例
        User.addExample();

        //添加食品样例
        Food.addExampleFood();

        //添加点餐样例
        Choose5_Order.addExampleOrder();

        //播放音乐
        Music.music();

        //开始运行
        //初始账户名为User 密码为123 验证码为Duo
        StartChoose.choose();

        //进入外卖界面(测试时使用)
        //TakeoutChoose.choose();

    }

}