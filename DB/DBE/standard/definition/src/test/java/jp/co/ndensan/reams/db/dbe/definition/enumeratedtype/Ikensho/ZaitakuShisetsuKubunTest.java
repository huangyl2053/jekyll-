package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 在宅/施設区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ZaitakuShisetsuKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ZaitakuShisetsuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ZaitakuShisetsuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_在宅を返す() {
        assertThat(ZaitakuShisetsuKubun.toValue(new RString("1")), is(ZaitakuShisetsuKubun.在宅));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_施設を返す() {
        assertThat(ZaitakuShisetsuKubun.toValue(new RString("2")), is(ZaitakuShisetsuKubun.施設));
    }

    @Test
    public void 在宅を指定した場合_getコードは_1を返す() {
        assertThat(ZaitakuShisetsuKubun.在宅.getコード(), is(new RString("1")));
    }

    @Test
    public void 施設を指定した場合_getコードは_2を返す() {
        assertThat(ZaitakuShisetsuKubun.施設.getコード(), is(new RString("2")));
    }

    @Test
    public void 在宅を指定した場合_get名称は_在宅を返す() {
        assertThat(ZaitakuShisetsuKubun.在宅.get名称(), is(new RString("在宅")));
    }

    @Test
    public void 施設を指定した場合_get名称は_施設を返す() {
        assertThat(ZaitakuShisetsuKubun.施設.get名称(), is(new RString("施設")));
    }

}
