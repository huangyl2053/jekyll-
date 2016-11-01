package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴依頼金額計算方法4月のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoIraikingakuKeisanHoho4GatsuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuchoIraikingakuKeisanHoho4Gatsu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuchoIraikingakuKeisanHoho4Gatsu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_年額除12乗仮徴収月数除年金支給回数を返す() {
        assertThat(TokuchoIraikingakuKeisanHoho4Gatsu.toValue(new RString("1")), is(TokuchoIraikingakuKeisanHoho4Gatsu.法定計算方法_6で割る
        ));
    }

    @Test
    public void 年額除12乗仮徴収月数除年金支給回数を指定した場合_getコードは_1を返す() {
        assertThat(TokuchoIraikingakuKeisanHoho4Gatsu.法定計算方法_6で割る.getコード(), is(new RString("1"))
        );
    }

    @Test
    public void 年額除12乗仮徴収月数除年金支給回数を指定した場合_get名称は_法定計算方法_6で割るを返す() {
        assertThat(TokuchoIraikingakuKeisanHoho4Gatsu.法定計算方法_6で割る.get名称(), is(new RString("年額÷12Ｘ仮徴収月数÷年金支給回数"))
        );
    }
}
