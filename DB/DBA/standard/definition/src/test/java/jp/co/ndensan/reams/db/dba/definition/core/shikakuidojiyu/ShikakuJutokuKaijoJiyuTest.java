package jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 資格住特解除事由のテストクラスです。
 *
 */
public class ShikakuJutokuKaijoJiyuTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShikakuJutokuKaijoJiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShikakuJutokuKaijoJiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に71を指定した場合_toValueは_自特例転入を返す() {
        assertThat(ShikakuJutokuKaijoJiyu.toValue(new RString("71")), is(ShikakuJutokuKaijoJiyu.自特例転入));
    }

    @Test
    public void 引数に72を指定した場合_toValueは_自特例解除を返す() {
        assertThat(ShikakuJutokuKaijoJiyu.toValue(new RString("72")), is(ShikakuJutokuKaijoJiyu.自特例解除));
    }

    @Test
    public void 自特例転入を指定した場合_getコードは_71を返す() {
        assertThat(ShikakuJutokuKaijoJiyu.自特例転入.getコード(), is(new RString("71")));
    }

    @Test
    public void 自特例解除を指定した場合_getコードは_72を返す() {
        assertThat(ShikakuJutokuKaijoJiyu.自特例解除.getコード(), is(new RString("72")));
    }

    @Test
    public void 自特例転入を指定した場合_get名称は_自特例転入を返す() {
        assertThat(ShikakuJutokuKaijoJiyu.自特例転入.get名称(), is(new RString("自特例転入")));
    }

    @Test
    public void 自特例解除を指定した場合_get名称は_自特例解除を返す() {
        assertThat(ShikakuJutokuKaijoJiyu.自特例解除.get名称(), is(new RString("自特例解除")));
    }

}
