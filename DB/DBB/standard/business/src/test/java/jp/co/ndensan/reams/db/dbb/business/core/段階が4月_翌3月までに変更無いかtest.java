package jp.co.ndensan.reams.db.dbb.business.core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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

    HokenryoDankai dankai4 = new HokenryoDankai();
    HokenryoDankai dankai5 = new HokenryoDankai();
    HokenryoDankai dankai6 = new HokenryoDankai();
    HokenryoDankai dankai7 = new HokenryoDankai();
    HokenryoDankai dankai8 = new HokenryoDankai();
    HokenryoDankai dankai9 = new HokenryoDankai();
    HokenryoDankai dankai10 = new HokenryoDankai();
    HokenryoDankai dankai11 = new HokenryoDankai();
    HokenryoDankai dankai12 = new HokenryoDankai();
    HokenryoDankai dankai1 = new HokenryoDankai();
    HokenryoDankai dankai2 = new HokenryoDankai();
    HokenryoDankai dankai3 = new HokenryoDankai();

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

        dankai4.setSystemDankai(new RString("4"));
        dankai5.setSystemDankai(new RString("4"));
        dankai6.setSystemDankai(new RString("4"));
        dankai7.setSystemDankai(new RString("4"));
        dankai8.setSystemDankai(new RString("4"));
        dankai9.setSystemDankai(new RString("4"));
        dankai10.setSystemDankai(new RString("4"));
        dankai11.setSystemDankai(new RString("4"));
        dankai12.setSystemDankai(new RString("4"));
        dankai1.setSystemDankai(new RString("4"));
        dankai2.setSystemDankai(new RString("4"));
        dankai3.setSystemDankai(new RString("4"));

        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set保険料段階_4月(dankai4);
        fukakonkyo.set保険料段階_5月(dankai5);
        fukakonkyo.set保険料段階_6月(dankai6);
        fukakonkyo.set保険料段階_7月(dankai7);
        fukakonkyo.set保険料段階_8月(dankai8);
        fukakonkyo.set保険料段階_9月(dankai9);
        fukakonkyo.set保険料段階_10月(dankai10);
        fukakonkyo.set保険料段階_11月(dankai11);
        fukakonkyo.set保険料段階_12月(dankai12);
        fukakonkyo.set保険料段階_1月(dankai1);
        fukakonkyo.set保険料段階_2月(dankai2);
        fukakonkyo.set保険料段階_3月(dankai3);

        端数調整判定 hantei = new 段階が4月_翌3月まで変更無いか();
        保険料段階判定input input = new 保険料段階判定input();

        input.set年額賦課根拠(fukakonkyo);
        assertThat(hantei.judgeHasuu(input), is(false));
    }

    @Test
    public void 段階に変更ある場合は端数調整必要なのでtrueを返す() {

        dankai4.setSystemDankai(new RString("4"));
        dankai5.setSystemDankai(new RString("4"));
        dankai6.setSystemDankai(new RString("4"));
        dankai7.setSystemDankai(new RString("4"));
        dankai8.setSystemDankai(new RString("4"));
        dankai9.setSystemDankai(new RString("4"));
        dankai10.setSystemDankai(new RString("4"));
        dankai11.setSystemDankai(new RString("4"));
        dankai12.setSystemDankai(new RString("4"));
        dankai1.setSystemDankai(new RString("4"));
        dankai2.setSystemDankai(new RString("4"));
        dankai3.setSystemDankai(new RString("5"));

        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set保険料段階_4月(dankai4);
        fukakonkyo.set保険料段階_5月(dankai5);
        fukakonkyo.set保険料段階_6月(dankai6);
        fukakonkyo.set保険料段階_7月(dankai7);
        fukakonkyo.set保険料段階_8月(dankai8);
        fukakonkyo.set保険料段階_9月(dankai9);
        fukakonkyo.set保険料段階_10月(dankai10);
        fukakonkyo.set保険料段階_11月(dankai11);
        fukakonkyo.set保険料段階_12月(dankai12);
        fukakonkyo.set保険料段階_1月(dankai1);
        fukakonkyo.set保険料段階_2月(dankai2);
        fukakonkyo.set保険料段階_3月(dankai3);

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
