package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴開始通知書本算定出力条件のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoKaishiTsuhishoHoniOutputJokenTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuchoKaishiTsuhishoHoniOutputJoken.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuchoKaishiTsuhishoHoniOutputJoken.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_本算定分を返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken.toValue(new RString("1")), is(TokuchoKaishiTsuhishoHoniOutputJoken.本算定分));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_12月特徴開始者のみを返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken.toValue(new RString("2")), is(TokuchoKaishiTsuhishoHoniOutputJoken._12月特徴開始者のみ));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_2月特徴開始者のみを返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken.toValue(new RString("3")), is(TokuchoKaishiTsuhishoHoniOutputJoken._2月特徴開始者のみ));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_4月特徴開始者のみを返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken.toValue(new RString("4")), is(TokuchoKaishiTsuhishoHoniOutputJoken._4月特徴開始者のみ));
    }

    @Test
    public void 本算定分を指定した場合_getコードは_1を返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken.本算定分.getコード(), is(new RString("1")));
    }

    @Test
    public void _12月特徴開始者のみを指定した場合_getコードは_2を返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken._12月特徴開始者のみ.getコード(), is(new RString("2")));
    }

    @Test
    public void _2月特徴開始者のみを指定した場合_getコードは_3を返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken._2月特徴開始者のみ.getコード(), is(new RString("3")));
    }

    @Test
    public void _4月特徴開始者のみを指定した場合_getコードは_4を返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken._4月特徴開始者のみ.getコード(), is(new RString("4")));
    }

    @Test
    public void 本算定分を指定した場合_get名称は_本算定分を返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken.本算定分.get名称(), is(new RString("本算定分")));
    }

    @Test
    public void _12月特徴開始者のみを指定した場合_get名称は__12月特徴開始者のみを返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken._12月特徴開始者のみ.get名称(), is(new RString("_12月特徴開始者のみ")));
    }

    @Test
    public void _2月特徴開始者のみを指定した場合_get名称は__2月特徴開始者のみを返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken._2月特徴開始者のみ.get名称(), is(new RString("_2月特徴開始者のみ")));
    }

    @Test
    public void _4月特徴開始者のみを指定した場合_get名称は__4月特徴開始者のみを返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken._4月特徴開始者のみ.get名称(), is(new RString("_4月特徴開始者のみ")));
    }

    @Test
    public void 本算定分を指定した場合_get略称は_本算定分を返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken.本算定分.get略称(), is(new RString("本算定分")));
    }

    @Test
    public void _12月特徴開始者のみを指定した場合_get略称は_12月特徴開始者のみを返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken._12月特徴開始者のみ.get略称(), is(new RString("12月特徴開始者のみ")));
    }

    @Test
    public void _2月特徴開始者のみを指定した場合_get略称は_2月特徴開始者のみを返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken._2月特徴開始者のみ.get略称(), is(new RString("2月特徴開始者のみ")));
    }

    @Test
    public void _4月特徴開始者のみを指定した場合_get略称は_4月特徴開始者のみを返す() {
        assertThat(TokuchoKaishiTsuhishoHoniOutputJoken._4月特徴開始者のみ.get略称(), is(new RString("4月特徴開始者のみ")));
    }

}
