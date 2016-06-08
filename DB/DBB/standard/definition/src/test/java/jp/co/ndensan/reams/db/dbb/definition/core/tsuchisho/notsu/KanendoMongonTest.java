package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 過年度文言のテストクラスです。
 *
 * @author LDNS
 */
public class KanendoMongonTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KanendoMongon.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KanendoMongon.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_随時を返す() {
        assertThat(KanendoMongon.toValue(new RString("1")), is(KanendoMongon.随時));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_スペースを返す() {
        assertThat(KanendoMongon.toValue(new RString("2")), is(KanendoMongon.スペース));
    }

    @Test
    public void 随時を指定した場合_getコードは_1を返す() {
        assertThat(KanendoMongon.随時.getコード(), is(new RString("1")));
    }

    @Test
    public void スペースを指定した場合_getコードは_2を返す() {
        assertThat(KanendoMongon.スペース.getコード(), is(new RString("2")));
    }

    @Test
    public void 随時を指定した場合_get名称は_随時を返す() {
        assertThat(KanendoMongon.随時.get名称(), is(new RString("随時")));
    }

    @Test
    public void スペースを指定した場合_get名称は_スペースを返す() {
        assertThat(KanendoMongon.スペース.get名称(), is(new RString("スペース")));
    }

}
