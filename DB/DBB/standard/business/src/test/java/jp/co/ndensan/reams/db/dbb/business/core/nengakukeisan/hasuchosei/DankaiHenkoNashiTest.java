/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei;

import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankai;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankaiTest;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyoTest;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 段階が4月_翌3月まで変更無いかテストクラスです。
 *
 * @author n3336
 */
public class DankaiHenkoNashiTest {

    public DankaiHenkoNashiTest() {
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

        IHasuChoseiHantei hantei = new DankaiHenkoNashi();
        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();

        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set段階に変更無い場合は端数調整不要なのでfalseを返す(hokenryoDankaiList));
        assertThat(hantei.judgeHasuu(nengakuHokenryoKeisanParameter), is(false));
    }

    @Test
    public void 段階に変更ある場合は端数調整必要なのでtrueを返す() {

        List<HokenryoDankai> hokenryoDankaiList = HokenryoDankaiTest.set段階が4月_翌3月までに変更無いか();

        IHasuChoseiHantei hantei = new DankaiHenkoNashi();
        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();

        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set段階に変更無い場合は端数調整不要なのでfalseを返す(hokenryoDankaiList));
        assertThat(hantei.judgeHasuu(nengakuHokenryoKeisanParameter), is(true));
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
