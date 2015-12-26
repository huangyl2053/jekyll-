package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 外部帳票文字切れ制御のテストクラスです。
 * 
 * @author LDNS 
 */
public class GaibuChohyoMojigireSeigyoTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        GaibuChohyoMojigireSeigyo.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        GaibuChohyoMojigireSeigyo.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_印字しないを返す() {
        assertThat(GaibuChohyoMojigireSeigyo.toValue(new RString("0")), is(GaibuChohyoMojigireSeigyo.印字しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_印字可能範囲まで印字するを返す() {
        assertThat(GaibuChohyoMojigireSeigyo.toValue(new RString("1")), is(GaibuChohyoMojigireSeigyo.印字可能範囲まで印字する));
    }

    @Test
    public void 印字しないを指定した場合_getコードは_0を返す() {
        assertThat(GaibuChohyoMojigireSeigyo.印字しない.getコード(), is(new RString("0")));
    }

    @Test
    public void 印字可能範囲まで印字するを指定した場合_getコードは_1を返す() {
        assertThat(GaibuChohyoMojigireSeigyo.印字可能範囲まで印字する.getコード(), is(new RString("1")));
    }

    @Test
    public void 印字しないを指定した場合_get名称は_印字しないを返す() {
        assertThat(GaibuChohyoMojigireSeigyo.印字しない.get名称(), is(new RString("印字しない")));
    }

    @Test
    public void 印字可能範囲まで印字するを指定した場合_get名称は_印字可能範囲まで印字するを返す() {
        assertThat(GaibuChohyoMojigireSeigyo.印字可能範囲まで印字する.get名称(), is(new RString("印字可能範囲まで印字する")));
    }

}
