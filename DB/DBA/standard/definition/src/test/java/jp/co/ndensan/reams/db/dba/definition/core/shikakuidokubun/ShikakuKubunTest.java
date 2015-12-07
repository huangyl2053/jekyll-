package jp.co.ndensan.reams.db.dba.definition.core.shikakuidokubun;

import jp.co.ndensan.reams.db.dba.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 資格区分のテストクラスです。
 */
public class ShikakuKubunTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShikakuKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShikakuKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_１号を返す() {
        assertThat(ShikakuKubun.toValue(new RString("1")), is(ShikakuKubun._１号
        ));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_２号を返す() {
        assertThat(ShikakuKubun.toValue(new RString("2")), is(ShikakuKubun._２号
        ));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_１号外を返す() {
        assertThat(ShikakuKubun.toValue(new RString("3")), is(ShikakuKubun._１号外
        ));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_２号外を返す() {
        assertThat(ShikakuKubun.toValue(new RString("4")), is(ShikakuKubun._２号外
        ));
    }

    @Test
    public void _１号を指定した場合_getコードは_1を返す() {
        assertThat(ShikakuKubun._１号.getコード(), is(new RString("1"))
        );
    }

    @Test
    public void _２号を指定した場合_getコードは_2を返す() {
        assertThat(ShikakuKubun._２号.getコード(), is(new RString("2"))
        );
    }

    @Test
    public void _１号外を指定した場合_getコードは_3を返す() {
        assertThat(ShikakuKubun._１号外.getコード(), is(new RString("3"))
        );
    }

    @Test
    public void _２号外を指定した場合_getコードは_4を返す() {
        assertThat(ShikakuKubun._２号外.getコード(), is(new RString("4"))
        );
    }

    @Test
    public void _１号を指定した場合_get名称は__1号被保険者を返す() {
        assertThat(ShikakuKubun._１号.get名称(), is(new RString("_1号被保険者"))
        );
    }

    @Test
    public void _２号を指定した場合_get名称は__2号被保険者を返す() {
        assertThat(ShikakuKubun._２号.get名称(), is(new RString("_2号被保険者"))
        );
    }

    @Test
    public void _１号外を指定した場合_get名称は_１号被保険者_外国人を返す() {
        assertThat(ShikakuKubun._１号外.get名称(), is(new RString("１号被保険者（外国人）"))
        );
    }

    @Test
    public void _２号外を指定した場合_get名称は_２号被保険者_外国人を返す() {
        assertThat(ShikakuKubun._２号外.get名称(), is(new RString("２号被保険者（外国人）"))
        );
    }

    @Test
    public void _１号を指定した場合_get略称は_１号を返す() {
        assertThat(ShikakuKubun._１号.get略称(), is(new RString("１号"))
        );
    }

    @Test
    public void _２号を指定した場合_get略称は_２号を返す() {
        assertThat(ShikakuKubun._２号.get略称(), is(new RString("２号"))
        );
    }

    @Test
    public void _１号外を指定した場合_get略称は_１号外を返す() {
        assertThat(ShikakuKubun._１号外.get略称(), is(new RString("１号外"))
        );
    }

    @Test
    public void _２号外を指定した場合_get略称は_２号外を返す() {
        assertThat(ShikakuKubun._２号外.get略称(), is(new RString("２号外"))
        );
    }

}
