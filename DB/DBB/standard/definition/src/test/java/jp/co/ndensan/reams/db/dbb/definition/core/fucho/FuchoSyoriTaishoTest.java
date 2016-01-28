package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 普徴処理対象のテストクラスです。
 *
 * @author LDNS
 */
public class FuchoSyoriTaishoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        FuchoSyoriTaisho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        FuchoSyoriTaisho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_なしを返す() {
        assertThat(FuchoSyoriTaisho.toValue(new RString("1")), is(FuchoSyoriTaisho.なし));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_全件対象を返す() {
        assertThat(FuchoSyoriTaisho.toValue(new RString("2")), is(FuchoSyoriTaisho.全件対象));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_異動分のみ対象を返す() {
        assertThat(FuchoSyoriTaisho.toValue(new RString("3")), is(FuchoSyoriTaisho.異動分のみ対象));
    }

    @Test
    public void なしを指定した場合_getコードは_1を返す() {
        assertThat(FuchoSyoriTaisho.なし.getコード(), is(new RString("1")));
    }

    @Test
    public void 全件対象を指定した場合_getコードは_2を返す() {
        assertThat(FuchoSyoriTaisho.全件対象.getコード(), is(new RString("2")));
    }

    @Test
    public void 異動分のみ対象を指定した場合_getコードは_3を返す() {
        assertThat(FuchoSyoriTaisho.異動分のみ対象.getコード(), is(new RString("3")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(FuchoSyoriTaisho.なし.get名称(), is(new RString("なし")));
    }

    @Test
    public void 全件対象を指定した場合_get名称は_全件対象を返す() {
        assertThat(FuchoSyoriTaisho.全件対象.get名称(), is(new RString("全件対象")));
    }

    @Test
    public void 異動分のみ対象を指定した場合_get名称は_異動分のみ対象を返す() {
        assertThat(FuchoSyoriTaisho.異動分のみ対象.get名称(), is(new RString("異動分のみ対象")));
    }

}
