/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei;

import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuHokenryoKeisanParameter;
import jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param.NengakuFukaKonkyoTest;
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
public class RankHenkoNashiTest {

    public RankHenkoNashiTest() {
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
    public void ランクに変更がある場合はtrue() {

        IHasuChoseiHantei hantei = new RankHenkoNashi();
        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();
        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.setランクに変更がある場合はtrue());
        assertThat(hantei.judgeHasuu(nengakuHokenryoKeisanParameter), is(true));
    }

    @Test
    public void ランクに変更がない場合はfalse() {

        IHasuChoseiHantei hantei = new RankHenkoNashi();
        NengakuHokenryoKeisanParameter nengakuHokenryoKeisanParameter = new NengakuHokenryoKeisanParameter();
        nengakuHokenryoKeisanParameter.set年額賦課根拠(NengakuFukaKonkyoTest.setランクに変更がない場合はfalse());
        assertThat(hantei.judgeHasuu(nengakuHokenryoKeisanParameter), is(false));
    }

}
