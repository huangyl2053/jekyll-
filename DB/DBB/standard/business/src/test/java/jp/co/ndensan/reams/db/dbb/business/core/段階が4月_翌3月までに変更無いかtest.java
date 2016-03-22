package jp.co.ndensan.reams.db.dbb.business.core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankai;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankaiTest;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author n3336
 */
public class 段階が4月_翌3月までに変更無いかtest {

    public 段階が4月_翌3月までに変更無いかtest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void 段階に変更無い場合は端数調整不要なのでfalseを返す() {

        List<HokenryoDankai> hokenryoDankaiList = HokenryoDankaiTest.set段階が4月_翌3月までに変更無いか();

        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set保険料段階_4月(hokenryoDankaiList.get(0));
        fukakonkyo.set保険料段階_5月(hokenryoDankaiList.get(1));
        fukakonkyo.set保険料段階_6月(hokenryoDankaiList.get(2));
        fukakonkyo.set保険料段階_7月(hokenryoDankaiList.get(3));
        fukakonkyo.set保険料段階_8月(hokenryoDankaiList.get(4));
        fukakonkyo.set保険料段階_9月(hokenryoDankaiList.get(5));
        fukakonkyo.set保険料段階_10月(hokenryoDankaiList.get(6));
        fukakonkyo.set保険料段階_11月(hokenryoDankaiList.get(7));
        fukakonkyo.set保険料段階_12月(hokenryoDankaiList.get(8));
        fukakonkyo.set保険料段階_1月(hokenryoDankaiList.get(9));
        fukakonkyo.set保険料段階_2月(hokenryoDankaiList.get(10));
        fukakonkyo.set保険料段階_3月(hokenryoDankaiList.get(11));

        端数調整判定 hantei = new 段階が4月_翌3月まで変更無いか();
        保険料段階判定input input = new 保険料段階判定input();

        input.set年額賦課根拠(fukakonkyo);
        assertThat(hantei.judgeHasuu(input), is(false));
    }

    @Test
    public void 段階に変更ある場合は端数調整必要なのでtrueを返す() {

        List<HokenryoDankai> hokenryoDankaiList = HokenryoDankaiTest.set段階が4月_翌3月までに変更無いか();

        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set保険料段階_4月(hokenryoDankaiList.get(0));
        fukakonkyo.set保険料段階_5月(hokenryoDankaiList.get(1));
        fukakonkyo.set保険料段階_6月(hokenryoDankaiList.get(2));
        fukakonkyo.set保険料段階_7月(hokenryoDankaiList.get(3));
        fukakonkyo.set保険料段階_8月(hokenryoDankaiList.get(4));
        fukakonkyo.set保険料段階_9月(hokenryoDankaiList.get(5));
        fukakonkyo.set保険料段階_10月(hokenryoDankaiList.get(6));
        fukakonkyo.set保険料段階_11月(hokenryoDankaiList.get(7));
        fukakonkyo.set保険料段階_12月(hokenryoDankaiList.get(8));
        fukakonkyo.set保険料段階_1月(hokenryoDankaiList.get(9));
        fukakonkyo.set保険料段階_2月(hokenryoDankaiList.get(10));
        fukakonkyo.set保険料段階_3月(hokenryoDankaiList.get(11));

        端数調整判定 hantei = new 段階が4月_翌3月まで変更無いか();
        保険料段階判定input input = new 保険料段階判定input();

        input.set年額賦課根拠(fukakonkyo);
        assertThat(hantei.judgeHasuu(input), is(true));
    }

    protected static Date toDate(String str) {
        Date date = null;
        try {
            date = DateFormat.getDateInstance().parse(str);
        } catch (ParseException pe) {

        }
        return date;
    }

}
