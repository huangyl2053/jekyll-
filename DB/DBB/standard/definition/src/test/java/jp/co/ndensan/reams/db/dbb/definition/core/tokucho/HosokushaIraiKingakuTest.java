package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴捕捉者依頼金額計算のテストクラスです。
 *
 * @author LDNS
 */
public class HosokushaIraiKingakuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HosokushaIraiKingaku.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HosokushaIraiKingaku.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_通常の異動賦課に含めて計算するを返す() {
        assertThat(HosokushaIraiKingaku.toValue(new RString("0")), is(HosokushaIraiKingaku.通常の異動賦課に含めて計算する));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_特徴捕捉対象者のみを計算するを返す() {
        assertThat(HosokushaIraiKingaku.toValue(new RString("1")), is(HosokushaIraiKingaku.特徴捕捉対象者のみを計算する));
    }

    @Test
    public void 通常の異動賦課に含めて計算するを指定した場合_getコードは_0を返す() {
        assertThat(HosokushaIraiKingaku.通常の異動賦課に含めて計算する.getコード(), is(new RString("0")));
    }

    @Test
    public void 特徴捕捉対象者のみを計算するを指定した場合_getコードは_1を返す() {
        assertThat(HosokushaIraiKingaku.特徴捕捉対象者のみを計算する.getコード(), is(new RString("1")));
    }

    @Test
    public void 通常の異動賦課に含めて計算するを指定した場合_get名称は_通常の異動賦課に含めて計算するを返す() {
        assertThat(HosokushaIraiKingaku.通常の異動賦課に含めて計算する.get名称(), is(new RString("通常の異動賦課に含めて計算する")));
    }

    @Test
    public void 特徴捕捉対象者のみを計算するを指定した場合_get名称は_特徴捕捉対象者のみを計算するを返す() {
        assertThat(HosokushaIraiKingaku.特徴捕捉対象者のみを計算する.get名称(), is(new RString("特徴捕捉対象者のみを計算する")));
    }

}
