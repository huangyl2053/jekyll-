package jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 資格住特適用事由のテストクラスです。
 *
 */
public class ShikakuJutokuTekiyoJiyuTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShikakuJutokuTekiyoJiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShikakuJutokuTekiyoJiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_自特例適用を返す() {
        assertThat(ShikakuJutokuTekiyoJiyu.toValue(new RString("05")), is(ShikakuJutokuTekiyoJiyu.自特例適用));
    }

    @Test
    public void 自特例適用を指定した場合_getコードは_05を返す() {
        assertThat(ShikakuJutokuTekiyoJiyu.自特例適用.getコード(), is(new RString("05")));
    }

    @Test
    public void 自特例適用を指定した場合_get名称は_自特例適用を返す() {
        assertThat(ShikakuJutokuTekiyoJiyu.自特例適用.get名称(), is(new RString("自特例適用")));
    }

}
