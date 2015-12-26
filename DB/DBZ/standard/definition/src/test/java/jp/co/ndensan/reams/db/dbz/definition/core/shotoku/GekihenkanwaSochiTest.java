package jp.co.ndensan.reams.db.dbz.definition.core.shotoku;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 激変緩和措置区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class GekihenkanwaSochiTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        GekihenkanwaSochi.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        GekihenkanwaSochi.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_対象外を返す() {
        assertThat(GekihenkanwaSochi.toValue(new RString("0")), is(GekihenkanwaSochi.対象外));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_対象を返す() {
        assertThat(GekihenkanwaSochi.toValue(new RString("1")), is(GekihenkanwaSochi.対象));
    }

    @Test
    public void 対象外を指定した場合_getコードは_0を返す() {
        assertThat(GekihenkanwaSochi.対象外.getコード(), is(new RString("0")));
    }

    @Test
    public void 対象を指定した場合_getコードは_1を返す() {
        assertThat(GekihenkanwaSochi.対象.getコード(), is(new RString("1")));
    }

    @Test
    public void 対象外を指定した場合_get名称は_対象外を返す() {
        assertThat(GekihenkanwaSochi.対象外.get名称(), is(new RString("対象外")));
    }

    @Test
    public void 対象を指定した場合_get名称は_対象を返す() {
        assertThat(GekihenkanwaSochi.対象.get名称(), is(new RString("対象")));
    }

}
