package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHantei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 一次判定結果送付区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class IchijiHanteiSofuKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        IchijiHanteiSofuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        IchijiHanteiSofuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_未送付を返す() {
        assertThat(IchijiHanteiSofuKubun.toValue(new RString("0")), is(IchijiHanteiSofuKubun.未送付));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_送付済を返す() {
        assertThat(IchijiHanteiSofuKubun.toValue(new RString("1")), is(IchijiHanteiSofuKubun.送付済));
    }

    @Test
    public void 未送付を指定した場合_getコードは_0を返す() {
        assertThat(IchijiHanteiSofuKubun.未送付.getコード(), is(new RString("0")));
    }

    @Test
    public void 送付済を指定した場合_getコードは_1を返す() {
        assertThat(IchijiHanteiSofuKubun.送付済.getコード(), is(new RString("1")));
    }

    @Test
    public void 未送付を指定した場合_get名称は_未送付を返す() {
        assertThat(IchijiHanteiSofuKubun.未送付.get名称(), is(new RString("未送付")));
    }

    @Test
    public void 送付済を指定した場合_get名称は_送付済を返す() {
        assertThat(IchijiHanteiSofuKubun.送付済.get名称(), is(new RString("送付済")));
    }

}
