/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 *
 * @author chenaoqi
 */
public class FukushiyoguKonyuhiShikyuGendogakuValidateTest {

    private FukushiyoguKonyuhiShikyuGendogakuValidate sut;
    HihokenshaNo 被保険者番号;
    FlexibleYearMonth サービス提供年月;
    RString 整理番号;
    JigyoshaNo 事業者番号;
    RString 様式番号;
    RString 明細番号;
    Decimal 今回の保険対象費用額;

    @Before
    public void setUp() {
        sut = mock(FukushiyoguKonyuhiShikyuGendogakuValidate.class);
        被保険者番号 = new HihokenshaNo("");
        サービス提供年月 = new FlexibleYearMonth("");
        整理番号 = new RString("");
        事業者番号 = new JigyoshaNo("");
        様式番号 = new RString("");
        明細番号 = new RString("");
        今回の保険対象費用額 = new Decimal("33");
    }

    @Test
    public void chkKonyuhiShikyuGendogaku_被保険者番号がnullの場合_falseを返す() {
        boolean flag = sut.chkKonyuhiShikyuGendogaku(null, サービス提供年月, 整理番号,
                事業者番号, 様式番号, 明細番号, 今回の保険対象費用額);
        assertThat(flag, is(false));
    }

    @Test
    public void chkKonyuhiShikyuGendogaku_サービス提供年月がnullの場合_falseを返す() {
        boolean flag = sut.chkKonyuhiShikyuGendogaku(被保険者番号, null, 整理番号,
                事業者番号, 様式番号, 明細番号, 今回の保険対象費用額);
        assertThat(flag, is(false));
    }

    @Test
    public void chkKonyuhiShikyuGendogaku_事業者番号がnullの場合_falseを返す() {
        boolean flag = sut.chkKonyuhiShikyuGendogaku(被保険者番号, サービス提供年月, 整理番号,
                null, 様式番号, 明細番号, 今回の保険対象費用額);
        assertThat(flag, is(false));
    }

    @Test
    public void chkKonyuhiShikyuGendogaku_様式番号がnullの場合_falseを返す() {
        boolean flag = sut.chkKonyuhiShikyuGendogaku(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, null, 明細番号, 今回の保険対象費用額);
        assertThat(flag, is(false));
    }

    @Test
    public void chkKonyuhiShikyuGendogaku_明細番号がnullの場合_falseを返す() {
        boolean flag = sut.chkKonyuhiShikyuGendogaku(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号, null, 今回の保険対象費用額);
        assertThat(flag, is(false));
    }

    @Test
    public void chkKonyuhiShikyuGendogaku_今回の保険対象費用額がnullの場合_falseを返す() {
        boolean flag = sut.chkKonyuhiShikyuGendogaku(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号, 明細番号, null);
        assertThat(flag, is(false));
    }

    @Test
    public void chkKonyuhiShikyuGendogaku_整理番号がnullの場合_falseを返す() {
        boolean flag = sut.chkKonyuhiShikyuGendogaku(被保険者番号, サービス提供年月, null,
                事業者番号, 様式番号, 明細番号, 今回の保険対象費用額);
        assertThat(flag, is(false));
    }

    @Test
    public void chkKonyuhiShikyuGendogaku_整理番号がnullないの場合_falseを返す() {
        boolean flag = sut.chkKonyuhiShikyuGendogaku(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号, 明細番号, 今回の保険対象費用額);
        assertThat(flag, is(false));
    }

}
