package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 代納人表示有無のテストクラスです。
 * 
 * @author LDNS 
 */
public class DianoninHyojiUmuTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        DianoninHyojiUmu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        DianoninHyojiUmu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_表示しないを返す() {
        assertThat(DianoninHyojiUmu.toValue(new RString("0")), is(DianoninHyojiUmu.表示しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_表示するを返す() {
        assertThat(DianoninHyojiUmu.toValue(new RString("1")), is(DianoninHyojiUmu.表示する));
    }

    @Test
    public void 表示しないを指定した場合_getコードは_0を返す() {
        assertThat(DianoninHyojiUmu.表示しない.getコード(), is(new RString("0")));
    }

    @Test
    public void 表示するを指定した場合_getコードは_1を返す() {
        assertThat(DianoninHyojiUmu.表示する.getコード(), is(new RString("1")));
    }

    @Test
    public void 表示しないを指定した場合_get名称は_表示しないを返す() {
        assertThat(DianoninHyojiUmu.表示しない.get名称(), is(new RString("表示しない")));
    }

    @Test
    public void 表示するを指定した場合_get名称は_表示するを返す() {
        assertThat(DianoninHyojiUmu.表示する.get名称(), is(new RString("表示する")));
    }

}
