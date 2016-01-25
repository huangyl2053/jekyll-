/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author chenaoqi
 */
public class ShokanbaraiJutakuShikyuGendogakuHanteiCheckTest extends DbcTestDacBase {

    private ShokanbaraiJutakuShikyuGendogakuHanteiCheck sut;

    @Before
    public void setUp() {

    }

    @Test
    public void 対象単位の必須入力チェック_様式番号がnullの場合_falseを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(null, Decimal.ZERO, new ServiceShuruiCode("33"));
        assertThat(flag, is(false));
    }

    @Test
    public void 対象単位の必須入力チェック_様式番号が213の場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(new RString("2131"), null, new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 対象単位の必須入力チェック_様式番号が2141の場合_falseを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(new RString("2141"), Decimal.ZERO, new ServiceShuruiCode("33"));
        assertThat(flag, is(false));
    }

    @Test
    public void 対象単位の必須入力チェック_様式番号が214Xの場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(new RString("2142"), null, new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 対象単位の必須入力チェック_様式番号が2151の場合_falseを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(new RString("2151"), Decimal.ZERO, new ServiceShuruiCode("33"));
        assertThat(flag, is(false));
    }

    @Test
    public void 対象単位の必須入力チェック_様式番号が215Xの場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(new RString("2152"), null, new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 対象単位の必須入力チェック_様式番号が2161の場合_falseを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(new RString("2161"), Decimal.ZERO, new ServiceShuruiCode("33"));
        assertThat(flag, is(false));
    }

    @Test
    public void 対象単位の必須入力チェック_様式番号が216Xの場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(new RString("2162"), null, new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 対象単位の必須入力チェック_様式番号が2173の場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(new RString("2173"), null, new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 対象単位の必須入力チェック_様式番号が2174の場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(new RString("2174"), null, new ServiceShuruiCode("35"));
        assertThat(flag, is(true));
    }

    @Test
    public void 対象単位の必須入力チェック_様式番号が2175の場合_falseを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(new RString("2175"), Decimal.ZERO, new ServiceShuruiCode("35"));
        assertThat(flag, is(false));
    }

    @Test
    public void 保険分単位合計チェック_様式番号がnullの場合_falseを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaishoTani(null, Decimal.ZERO, new ServiceShuruiCode("33"));
        assertThat(flag, is(false));
    }

    @Test
    public void 保険分単位合計チェック_様式番号が2131の場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaniGokei(new RString("2131"), new Decimal("1"), new Decimal("8"), new Decimal("4"), new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 保険分単位合計チェック_様式番号が213Xの場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaniGokei(new RString("2132"), new Decimal("1"), new Decimal("8"), new Decimal("4"), new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 保険分単位合計チェック_様式番号が2141の場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaniGokei(new RString("2141"), new Decimal("1"), new Decimal("8"), new Decimal("4"), new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 保険分単位合計チェック_様式番号が214Xの場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaniGokei(new RString("2142"), new Decimal("1"), new Decimal("8"), new Decimal("4"), new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 保険分単位合計チェック_様式番号が2151の場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaniGokei(new RString("2151"), new Decimal("1"), new Decimal("8"), new Decimal("4"), new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 保険分単位合計チェック_様式番号が215Xの場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaniGokei(new RString("2152"), new Decimal("1"), new Decimal("8"), new Decimal("4"), new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 保険分単位合計チェック_様式番号が2161の場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaniGokei(new RString("2161"), new Decimal("1"), new Decimal("8"), new Decimal("4"), new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 保険分単位合計チェック_様式番号が216Xの場合_trueを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaniGokei(new RString("2162"), new Decimal("1"), new Decimal("8"), new Decimal("4"), new ServiceShuruiCode("33"));
        assertThat(flag, is(true));
    }

    @Test
    public void 保険分単位合計チェック_様式番号が216Xの場合_falseを返す() {
        sut = new ShokanbaraiJutakuShikyuGendogakuHanteiCheck();
        boolean flag = sut.chkShokanbaraiJutakuShikyuGendogakuTaniGokei(new RString("2162"), new Decimal("2.1"), new Decimal("2.5"), new Decimal("4.6"), new ServiceShuruiCode("33"));
        assertThat(flag, is(false));
    }
}
