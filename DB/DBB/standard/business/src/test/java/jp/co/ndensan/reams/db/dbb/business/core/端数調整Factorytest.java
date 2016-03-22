/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankaiTest;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
public class 端数調整Factorytest {

    public 端数調整Factorytest() {
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
    public void 端数調整不要の場合は金額に変更なし() {

        端数調整Factory factory = new 端数調整Factory();

        保険料段階判定input input = new 保険料段階判定input();

        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20140401"));
        fukakonkyo.set資格喪失日(new RDate("20150401"));
        fukakonkyo.setランク_4月(new RString("4"));
        fukakonkyo.setランク_5月(new RString("4"));
        fukakonkyo.setランク_6月(new RString("4"));
        fukakonkyo.setランク_7月(new RString("4"));
        fukakonkyo.setランク_8月(new RString("4"));
        fukakonkyo.setランク_9月(new RString("4"));
        fukakonkyo.setランク_10月(new RString("4"));
        fukakonkyo.setランク_11月(new RString("4"));
        fukakonkyo.setランク_12月(new RString("4"));
        fukakonkyo.setランク_1月(new RString("4"));
        fukakonkyo.setランク_2月(new RString("4"));
        fukakonkyo.setランク_3月(new RString("4"));

        List<HokenryoDankai> hokenryoDankaiList = HokenryoDankaiTest.set段階が4月_翌3月までに変更無いか();

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

        NengakuSeigyoJoho seigyo = new NengakuSeigyoJoho();
        seigyo.set端数単位(new Decimal("10"));
        seigyo.set端数調整方法(new RString("切り上げ"));
        seigyo.set端数単位_ランク用(new Decimal("100"));
        seigyo.set端数調整方法_ランク用(new RString("切捨て"));

        input.set年額賦課根拠(fukakonkyo);
        input.set年額制御情報(seigyo);
        input.set賦課年度(new RString("2014"));

        assertThat(factory.getIncetance(input).calc端数(new Decimal("9999")), is(new Decimal("9999")));

    }

    @Test
    public void 段階に変更あった場合は端数調整必要() {

        端数調整Factory factory = new 端数調整Factory();

        保険料段階判定input input = new 保険料段階判定input();

        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20140401"));
        fukakonkyo.set資格喪失日(new RDate("20150401"));
        fukakonkyo.setランク_4月(new RString("4"));
        fukakonkyo.setランク_5月(new RString("4"));
        fukakonkyo.setランク_6月(new RString("4"));
        fukakonkyo.setランク_7月(new RString("4"));
        fukakonkyo.setランク_8月(new RString("4"));
        fukakonkyo.setランク_9月(new RString("4"));
        fukakonkyo.setランク_10月(new RString("4"));
        fukakonkyo.setランク_11月(new RString("4"));
        fukakonkyo.setランク_12月(new RString("4"));
        fukakonkyo.setランク_1月(new RString("4"));
        fukakonkyo.setランク_2月(new RString("4"));
        fukakonkyo.setランク_3月(new RString("4"));

        List<HokenryoDankai> hokenryoDankaiList = HokenryoDankaiTest.set段階が4月_翌3月までに変更無いか();

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
        NengakuSeigyoJoho seigyo = new NengakuSeigyoJoho();
        seigyo.set端数単位(new Decimal("10"));
        seigyo.set端数調整方法(new RString("切り上げ"));
        seigyo.set端数単位_ランク用(new Decimal("100"));
        seigyo.set端数調整方法_ランク用(new RString("切捨て"));

        input.set年額賦課根拠(fukakonkyo);
        input.set年額制御情報(seigyo);
        input.set賦課年度(new RString("2014"));

        assertThat(factory.getIncetance(input).calc端数(new Decimal("9999")), is(new Decimal("10000")));

    }

    @Test
    public void ランクに変更あった場合は端数調整必要() {

        端数調整Factory factory = new 端数調整Factory();

        保険料段階判定input input = new 保険料段階判定input();

        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20140401"));
        fukakonkyo.set資格喪失日(new RDate("20150401"));
        fukakonkyo.setランク_4月(new RString("5"));
        fukakonkyo.setランク_5月(new RString("4"));
        fukakonkyo.setランク_6月(new RString("4"));
        fukakonkyo.setランク_7月(new RString("4"));
        fukakonkyo.setランク_8月(new RString("4"));
        fukakonkyo.setランク_9月(new RString("4"));
        fukakonkyo.setランク_10月(new RString("4"));
        fukakonkyo.setランク_11月(new RString("4"));
        fukakonkyo.setランク_12月(new RString("4"));
        fukakonkyo.setランク_1月(new RString("4"));
        fukakonkyo.setランク_2月(new RString("4"));
        fukakonkyo.setランク_3月(new RString("4"));

        List<HokenryoDankai> hokenryoDankaiList = HokenryoDankaiTest.set段階が4月_翌3月までに変更無いか();

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

        NengakuSeigyoJoho seigyo = new NengakuSeigyoJoho();
        seigyo.set端数単位(new Decimal("10"));
        seigyo.set端数調整方法(new RString("切り上げ"));
        seigyo.set端数単位_ランク用(new Decimal("100"));
        seigyo.set端数調整方法_ランク用(new RString("切捨て"));

        input.set年額賦課根拠(fukakonkyo);
        input.set年額制御情報(seigyo);
        input.set賦課年度(new RString("2014"));

        assertThat(factory.getIncetance(input).calc端数(new Decimal("9999")), is(new Decimal("9900")));

    }

    @Test
    public void 資格取得日が年度途中の場合は端数調整必要() {

        端数調整Factory factory = new 端数調整Factory();

        保険料段階判定input input = new 保険料段階判定input();

        NengakuFukaKonkyo fukakonkyo = new NengakuFukaKonkyo();
        fukakonkyo.set資格取得日(new RDate("20140402"));
        fukakonkyo.set資格喪失日(null);
        fukakonkyo.setランク_4月(new RString("4"));
        fukakonkyo.setランク_5月(new RString("4"));
        fukakonkyo.setランク_6月(new RString("4"));
        fukakonkyo.setランク_7月(new RString("4"));
        fukakonkyo.setランク_8月(new RString("4"));
        fukakonkyo.setランク_9月(new RString("4"));
        fukakonkyo.setランク_10月(new RString("4"));
        fukakonkyo.setランク_11月(new RString("4"));
        fukakonkyo.setランク_12月(new RString("4"));
        fukakonkyo.setランク_1月(new RString("4"));
        fukakonkyo.setランク_2月(new RString("4"));
        fukakonkyo.setランク_3月(new RString("4"));

        List<HokenryoDankai> hokenryoDankaiList = HokenryoDankaiTest.set段階が4月_翌3月までに変更無いか();

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

        NengakuSeigyoJoho seigyo = new NengakuSeigyoJoho();
        seigyo.set端数単位(new Decimal("10"));
        seigyo.set端数調整方法(new RString("切り上げ"));
        seigyo.set端数単位_ランク用(new Decimal("100"));
        seigyo.set端数調整方法_ランク用(new RString("切捨て"));

        input.set年額賦課根拠(fukakonkyo);
        input.set年額制御情報(seigyo);
        input.set賦課年度(new RString("2014"));

        assertThat(factory.getIncetance(input).calc端数(new Decimal("9999")), is(new Decimal("10000")));

    }

}
