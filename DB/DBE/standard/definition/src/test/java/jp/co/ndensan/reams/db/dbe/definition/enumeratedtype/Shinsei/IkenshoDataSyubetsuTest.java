package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 意見書データ種別のテストクラスです。
 * 
 * @author LDNS 
 */
public class IkenshoDataSyubetsuTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        IkenshoDataSyubetsu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        IkenshoDataSyubetsu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_意見書定型を返す() {
        assertThat(IkenshoDataSyubetsu.toValue(new RString("0")), is(IkenshoDataSyubetsu.意見書定型));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_意見書定型外を返す() {
        assertThat(IkenshoDataSyubetsu.toValue(new RString("1")), is(IkenshoDataSyubetsu.意見書定型外));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_外部ｿﾌﾄを返す() {
        assertThat(IkenshoDataSyubetsu.toValue(new RString("2")), is(IkenshoDataSyubetsu.外部ｿﾌﾄ));
    }

    @Test
    public void 意見書定型を指定した場合_getコードは_0を返す() {
        assertThat(IkenshoDataSyubetsu.意見書定型.getコード(), is(new RString("0")));
    }

    @Test
    public void 意見書定型外を指定した場合_getコードは_1を返す() {
        assertThat(IkenshoDataSyubetsu.意見書定型外.getコード(), is(new RString("1")));
    }

    @Test
    public void 外部ｿﾌﾄを指定した場合_getコードは_2を返す() {
        assertThat(IkenshoDataSyubetsu.外部ｿﾌﾄ.getコード(), is(new RString("2")));
    }

    @Test
    public void 意見書定型を指定した場合_get名称は_意見書定型を返す() {
        assertThat(IkenshoDataSyubetsu.意見書定型.get名称(), is(new RString("意見書定型")));
    }

    @Test
    public void 意見書定型外を指定した場合_get名称は_意見書定型外を返す() {
        assertThat(IkenshoDataSyubetsu.意見書定型外.get名称(), is(new RString("意見書定型外")));
    }

    @Test
    public void 外部ｿﾌﾄを指定した場合_get名称は_外部ｿﾌﾄを返す() {
        assertThat(IkenshoDataSyubetsu.外部ｿﾌﾄ.get名称(), is(new RString("外部ｿﾌﾄ")));
    }

}
