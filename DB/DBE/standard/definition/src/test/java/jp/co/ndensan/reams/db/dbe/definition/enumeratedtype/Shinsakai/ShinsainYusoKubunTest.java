package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 審査員郵送区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShinsainYusoKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShinsainYusoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShinsainYusoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_自宅を返す() {
        assertThat(ShinsainYusoKubun.toValue(new RString("1")), is(ShinsainYusoKubun.自宅));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_所属機関を返す() {
        assertThat(ShinsainYusoKubun.toValue(new RString("2")), is(ShinsainYusoKubun.所属機関));
    }

    @Test
    public void 自宅を指定した場合_getコードは_1を返す() {
        assertThat(ShinsainYusoKubun.自宅.getコード(), is(new RString("1")));
    }

    @Test
    public void 所属機関を指定した場合_getコードは_2を返す() {
        assertThat(ShinsainYusoKubun.所属機関.getコード(), is(new RString("2")));
    }

    @Test
    public void 自宅を指定した場合_get名称は_自宅を返す() {
        assertThat(ShinsainYusoKubun.自宅.get名称(), is(new RString("自宅")));
    }

    @Test
    public void 所属機関を指定した場合_get名称は_所属機関を返す() {
        assertThat(ShinsainYusoKubun.所属機関.get名称(), is(new RString("所属機関")));
    }

}
