/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Qi
 */
public class ShokanbaraiJutakuShikyuGendogakuHanteiCheckTest extends DbcTestDacBase {

    private ShokanbaraiJutakuShikyuGendogakuHanteiCheck sut;

    @Before
    public void setUp() {

    }

    @Test
    public void chkShokanbaraiJutakuShikyuGendogakuTaishoTaniのテスト() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(new RString("2173"), new Decimal("0"), new RString("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void chkShokanbaraiJutakuShikyuGendogakuTaniGokeiのテスト() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaniGokei(new RString("2133"), new Decimal("1"), new Decimal("8"), new Decimal("4"), new RString("33"));
        assertThat(flag, is(true));
    }
}
