package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴年額基準年度8月のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoNengakuKijunNendo8GatsuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuchoNengakuKijunNendo8Gatsu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuchoNengakuKijunNendo8Gatsu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_当年度を返す() {
        assertThat(TokuchoNengakuKijunNendo8Gatsu.toValue(new RString("1")), is(TokuchoNengakuKijunNendo8Gatsu.当年度));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_翌年度を返す() {
        assertThat(TokuchoNengakuKijunNendo8Gatsu.toValue(new RString("2")), is(TokuchoNengakuKijunNendo8Gatsu.翌年度));
    }

    @Test
    public void 当年度を指定した場合_getコードは_1を返す() {
        assertThat(TokuchoNengakuKijunNendo8Gatsu.当年度.getコード(), is(new RString("1")));
    }

    @Test
    public void 翌年度を指定した場合_getコードは_2を返す() {
        assertThat(TokuchoNengakuKijunNendo8Gatsu.翌年度.getコード(), is(new RString("2")));
    }

    @Test
    public void 当年度を指定した場合_get名称は_当年度を返す() {
        assertThat(TokuchoNengakuKijunNendo8Gatsu.当年度.get名称(), is(new RString("当年度")));
    }

    @Test
    public void 翌年度を指定した場合_get名称は_翌年度を返す() {
        assertThat(TokuchoNengakuKijunNendo8Gatsu.翌年度.get名称(), is(new RString("翌年度")));
    }

}
