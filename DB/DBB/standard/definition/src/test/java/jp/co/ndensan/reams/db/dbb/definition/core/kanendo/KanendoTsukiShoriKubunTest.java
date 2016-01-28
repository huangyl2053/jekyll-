package jp.co.ndensan.reams.db.dbb.definition.core.kanendo;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 過年度月処理区分のテストクラスです。
 *
 * @author LDNS
 */
public class KanendoTsukiShoriKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KanendoTsukiShoriKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KanendoTsukiShoriKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_随時を返す() {
        assertThat(KanendoTsukiShoriKubun.toValue(new RString("6")), is(KanendoTsukiShoriKubun.随時));
    }

    @Test
    public void 随時を指定した場合_getコードは_6を返す() {
        assertThat(KanendoTsukiShoriKubun.随時.getコード(), is(new RString("6")));
    }

    @Test
    public void 随時を指定した場合_get名称は_随時を返す() {
        assertThat(KanendoTsukiShoriKubun.随時.get名称(), is(new RString("随時")));
    }

}
