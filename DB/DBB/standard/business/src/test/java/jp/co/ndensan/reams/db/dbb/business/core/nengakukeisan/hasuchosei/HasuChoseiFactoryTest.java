/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei;

import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.HokenryoDankaiTest;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyoTest;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuSeigyoJohoTest;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * HasuChoseiFactoryテストクラスです。
 *
 * @author n3336
 */
public class HasuChoseiFactoryTest {

    public HasuChoseiFactoryTest() {
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

        HasuChoseiFactory factory = new HasuChoseiFactory();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();

        List<HokenryoDankai> hokenryoDankaiList = HokenryoDankaiTest.set段階が4月_翌3月までに変更無いか();

        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set端数調整不要の場合は金額に変更なし(hokenryoDankaiList));
        nengakuHokenryoKeisanParameter.set年額制御情報(NengakuSeigyoJohoTest.set端数調整不要の場合は金額に変更なし(hokenryoDankaiList));
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));

        assertThat(factory.getIncetance(nengakuHokenryoKeisanParameter).calc端数(new Decimal("9999")), is(new Decimal("9999")));

    }

    @Test
    public void 段階に変更あった場合は端数調整必要() {

        HasuChoseiFactory factory = new HasuChoseiFactory();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();

        List<HokenryoDankai> hokenryoDankaiList = HokenryoDankaiTest.set段階が4月_翌3月までに変更無いか();

        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set端数調整不要の場合は金額に変更なし(hokenryoDankaiList));
        nengakuHokenryoKeisanParameter.set年額制御情報(NengakuSeigyoJohoTest.set端数調整不要の場合は金額に変更なし(hokenryoDankaiList));
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));

        assertThat(factory.getIncetance(nengakuHokenryoKeisanParameter).calc端数(new Decimal("9999")), is(new Decimal("10000")));

    }

    @Test
    public void ランクに変更あった場合は端数調整必要() {

        HasuChoseiFactory factory = new HasuChoseiFactory();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();

        List<HokenryoDankai> hokenryoDankaiList = HokenryoDankaiTest.set段階が4月_翌3月までに変更無いか();

        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.setランクに変更あった場合は端数調整必要(hokenryoDankaiList));
        nengakuHokenryoKeisanParameter.set年額制御情報(NengakuSeigyoJohoTest.set端数調整不要の場合は金額に変更なし(hokenryoDankaiList));
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));

        assertThat(factory.getIncetance(nengakuHokenryoKeisanParameter).calc端数(new Decimal("9999")), is(new Decimal("9900")));

    }

    @Test
    public void 資格取得日が年度途中の場合は端数調整必要() {

        HasuChoseiFactory factory = new HasuChoseiFactory();

        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();

        List<HokenryoDankai> hokenryoDankaiList = HokenryoDankaiTest.set段階が4月_翌3月までに変更無いか();

        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.set資格取得日が年度途中の場合は端数調整必要(hokenryoDankaiList));
        nengakuHokenryoKeisanParameter.set年額制御情報(NengakuSeigyoJohoTest.set端数調整不要の場合は金額に変更なし(hokenryoDankaiList));
        nengakuHokenryoKeisanParameter.set賦課年度(new FlexibleDate("2014"));

        assertThat(factory.getIncetance(nengakuHokenryoKeisanParameter).calc端数(new Decimal("9999")), is(new Decimal("10000")));

    }

}
