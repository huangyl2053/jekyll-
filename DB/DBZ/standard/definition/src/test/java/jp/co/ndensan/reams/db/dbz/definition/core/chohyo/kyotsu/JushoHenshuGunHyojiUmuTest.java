package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 住所編集郡名表示有無のテストクラスです。
 * 
 * @author LDNS 
 */
public class JushoHenshuGunHyojiUmuTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JushoHenshuGunHyojiUmu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JushoHenshuGunHyojiUmu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_しないを返す() {
        assertThat(JushoHenshuGunHyojiUmu.toValue(new RString("0")), is(JushoHenshuGunHyojiUmu.しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_するを返す() {
        assertThat(JushoHenshuGunHyojiUmu.toValue(new RString("1")), is(JushoHenshuGunHyojiUmu.する));
    }

    @Test
    public void しないを指定した場合_getコードは_0を返す() {
        assertThat(JushoHenshuGunHyojiUmu.しない.getコード(), is(new RString("0")));
    }

    @Test
    public void するを指定した場合_getコードは_1を返す() {
        assertThat(JushoHenshuGunHyojiUmu.する.getコード(), is(new RString("1")));
    }

    @Test
    public void しないを指定した場合_get名称は_しないを返す() {
        assertThat(JushoHenshuGunHyojiUmu.しない.get名称(), is(new RString("しない")));
    }

    @Test
    public void するを指定した場合_get名称は_するを返す() {
        assertThat(JushoHenshuGunHyojiUmu.する.get名称(), is(new RString("する")));
    }

}
