package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 引渡し区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class HikiwatashiKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HikiwatashiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HikiwatashiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_引渡し未を返す() {
        assertThat(HikiwatashiKubun.toValue(new RString("0")), is(HikiwatashiKubun.引渡し未));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_引渡し済を返す() {
        assertThat(HikiwatashiKubun.toValue(new RString("1")), is(HikiwatashiKubun.引渡し済));
    }

    @Test
    public void 引渡し未を指定した場合_getコードは_0を返す() {
        assertThat(HikiwatashiKubun.引渡し未.getコード(), is(new RString("0")));
    }

    @Test
    public void 引渡し済を指定した場合_getコードは_1を返す() {
        assertThat(HikiwatashiKubun.引渡し済.getコード(), is(new RString("1")));
    }

    @Test
    public void 引渡し未を指定した場合_get名称は_引渡し未を返す() {
        assertThat(HikiwatashiKubun.引渡し未.get名称(), is(new RString("引渡し未")));
    }

    @Test
    public void 引渡し済を指定した場合_get名称は_引渡し済を返す() {
        assertThat(HikiwatashiKubun.引渡し済.get名称(), is(new RString("引渡し済")));
    }

}
