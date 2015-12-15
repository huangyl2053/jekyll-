package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 要介護状態像例コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class YokaigoJotaizoReiCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        YokaigoJotaizoReiCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        YokaigoJotaizoReiCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_認知機能の低下等を返す() {
        assertThat(YokaigoJotaizoReiCode.toValue(new RString("01")), is(YokaigoJotaizoReiCode.認知機能の低下等));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_不安定な状態を返す() {
        assertThat(YokaigoJotaizoReiCode.toValue(new RString("02")), is(YokaigoJotaizoReiCode.不安定な状態));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_その他を返す() {
        assertThat(YokaigoJotaizoReiCode.toValue(new RString("99")), is(YokaigoJotaizoReiCode.その他));
    }

    @Test
    public void 認知機能の低下等を指定した場合_getコードは_01を返す() {
        assertThat(YokaigoJotaizoReiCode.認知機能の低下等.getコード(), is(new RString("01")));
    }

    @Test
    public void 不安定な状態を指定した場合_getコードは_02を返す() {
        assertThat(YokaigoJotaizoReiCode.不安定な状態.getコード(), is(new RString("02")));
    }

    @Test
    public void その他を指定した場合_getコードは_99を返す() {
        assertThat(YokaigoJotaizoReiCode.その他.getコード(), is(new RString("99")));
    }

    @Test
    public void 認知機能の低下等を指定した場合_get名称は_認知機能の低下等を返す() {
        assertThat(YokaigoJotaizoReiCode.認知機能の低下等.get名称(), is(new RString("認知機能の低下等")));
    }

    @Test
    public void 不安定な状態を指定した場合_get名称は_不安定な状態を返す() {
        assertThat(YokaigoJotaizoReiCode.不安定な状態.get名称(), is(new RString("不安定な状態")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(YokaigoJotaizoReiCode.その他.get名称(), is(new RString("その他")));
    }

}
