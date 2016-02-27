package jp.co.ndensan.reams.db.dbc.definition.core.kyusochisha;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 旧措置入所者特例コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class KyuSochiNyushoshaTokureiCodeTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KyuSochiNyushoshaTokureiCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KyuSochiNyushoshaTokureiCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_無しを返す() {
        assertThat(KyuSochiNyushoshaTokureiCode.toValue(new RString("1")), is(KyuSochiNyushoshaTokureiCode.無し));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_有りを返す() {
        assertThat(KyuSochiNyushoshaTokureiCode.toValue(new RString("2")), is(KyuSochiNyushoshaTokureiCode.有り));
    }

    @Test
    public void 無しを指定した場合_getコードは_1を返す() {
        assertThat(KyuSochiNyushoshaTokureiCode.無し.getコード(), is(new RString("1")));
    }

    @Test
    public void 有りを指定した場合_getコードは_2を返す() {
        assertThat(KyuSochiNyushoshaTokureiCode.有り.getコード(), is(new RString("2")));
    }

    @Test
    public void 無しを指定した場合_get名称は_無しを返す() {
        assertThat(KyuSochiNyushoshaTokureiCode.無し.get名称(), is(new RString("無し")));
    }

    @Test
    public void 有りを指定した場合_get名称は_有りを返す() {
        assertThat(KyuSochiNyushoshaTokureiCode.有り.get名称(), is(new RString("有り")));
    }

}
