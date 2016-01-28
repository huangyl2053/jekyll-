package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 住所編集都道府県名表示有無のテストクラスです。
 * 
 * @author LDNS 
 */
public class JushoHenshuTodofukenHyojiUmuTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JushoHenshuTodofukenHyojiUmu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JushoHenshuTodofukenHyojiUmu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_しないを返す() {
        assertThat(JushoHenshuTodofukenHyojiUmu.toValue(new RString("0")), is(JushoHenshuTodofukenHyojiUmu.しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_するを返す() {
        assertThat(JushoHenshuTodofukenHyojiUmu.toValue(new RString("1")), is(JushoHenshuTodofukenHyojiUmu.する));
    }

    @Test
    public void しないを指定した場合_getコードは_0を返す() {
        assertThat(JushoHenshuTodofukenHyojiUmu.しない.getコード(), is(new RString("0")));
    }

    @Test
    public void するを指定した場合_getコードは_1を返す() {
        assertThat(JushoHenshuTodofukenHyojiUmu.する.getコード(), is(new RString("1")));
    }

    @Test
    public void しないを指定した場合_get名称は_しないを返す() {
        assertThat(JushoHenshuTodofukenHyojiUmu.しない.get名称(), is(new RString("しない")));
    }

    @Test
    public void するを指定した場合_get名称は_するを返す() {
        assertThat(JushoHenshuTodofukenHyojiUmu.する.get名称(), is(new RString("する")));
    }

}
