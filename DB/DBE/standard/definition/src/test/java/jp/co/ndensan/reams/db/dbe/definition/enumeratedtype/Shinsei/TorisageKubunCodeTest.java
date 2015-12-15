package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 取下区分コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class TorisageKubunCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TorisageKubunCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TorisageKubunCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_認定申請有効を返す() {
        assertThat(TorisageKubunCode.toValue(new RString("1")), is(TorisageKubunCode.認定申請有効));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_却下を返す() {
        assertThat(TorisageKubunCode.toValue(new RString("2")), is(TorisageKubunCode.却下));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_取り下げを返す() {
        assertThat(TorisageKubunCode.toValue(new RString("3")), is(TorisageKubunCode.取り下げ));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_区分変更却下を返す() {
        assertThat(TorisageKubunCode.toValue(new RString("4")), is(TorisageKubunCode.区分変更却下));
    }

    @Test
    public void 認定申請有効を指定した場合_getコードは_1を返す() {
        assertThat(TorisageKubunCode.認定申請有効.getコード(), is(new RString("1")));
    }

    @Test
    public void 却下を指定した場合_getコードは_2を返す() {
        assertThat(TorisageKubunCode.却下.getコード(), is(new RString("2")));
    }

    @Test
    public void 取り下げを指定した場合_getコードは_3を返す() {
        assertThat(TorisageKubunCode.取り下げ.getコード(), is(new RString("3")));
    }

    @Test
    public void 区分変更却下を指定した場合_getコードは_4を返す() {
        assertThat(TorisageKubunCode.区分変更却下.getコード(), is(new RString("4")));
    }

    @Test
    public void 認定申請有効を指定した場合_get名称は_認定申請有効を返す() {
        assertThat(TorisageKubunCode.認定申請有効.get名称(), is(new RString("認定申請有効")));
    }

    @Test
    public void 却下を指定した場合_get名称は_却下を返す() {
        assertThat(TorisageKubunCode.却下.get名称(), is(new RString("却下")));
    }

    @Test
    public void 取り下げを指定した場合_get名称は_取り下げを返す() {
        assertThat(TorisageKubunCode.取り下げ.get名称(), is(new RString("取り下げ")));
    }

    @Test
    public void 区分変更却下を指定した場合_get名称は_区分変更却下を返す() {
        assertThat(TorisageKubunCode.区分変更却下.get名称(), is(new RString("区分変更却下")));
    }

}
