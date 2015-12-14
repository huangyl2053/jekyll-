package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 端数調整単位のテストクラスです。
 *
 * @author LDNS
 */
public class HasuChoseiTaniTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HasuChoseiTani.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HasuChoseiTani.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_1を返す() {
        assertThat(HasuChoseiTani.toValue(new RString("1")), is(HasuChoseiTani._1));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_10を返す() {
        assertThat(HasuChoseiTani.toValue(new RString("10")), is(HasuChoseiTani._10));
    }

    @Test
    public void 引数に100を指定した場合_toValueは_100を返す() {
        assertThat(HasuChoseiTani.toValue(new RString("100")), is(HasuChoseiTani._100));
    }

    @Test
    public void 引数に1000を指定した場合_toValueは_1000を返す() {
        assertThat(HasuChoseiTani.toValue(new RString("1000")), is(HasuChoseiTani._1000));
    }

    @Test
    public void _1を指定した場合_getコードは_1を返す() {
        assertThat(HasuChoseiTani._1.getコード(), is(new RString("1")));
    }

    @Test
    public void _10を指定した場合_getコードは_10を返す() {
        assertThat(HasuChoseiTani._10.getコード(), is(new RString("10")));
    }

    @Test
    public void _100を指定した場合_getコードは_100を返す() {
        assertThat(HasuChoseiTani._100.getコード(), is(new RString("100")));
    }

    @Test
    public void _1000を指定した場合_getコードは_1000を返す() {
        assertThat(HasuChoseiTani._1000.getコード(), is(new RString("1000")));
    }

    @Test
    public void _1を指定した場合_get名称は__1を返す() {
        assertThat(HasuChoseiTani._1.get名称(), is(new RString("_1")));
    }

    @Test
    public void _10を指定した場合_get名称は__10を返す() {
        assertThat(HasuChoseiTani._10.get名称(), is(new RString("_10")));
    }

    @Test
    public void _100を指定した場合_get名称は__100を返す() {
        assertThat(HasuChoseiTani._100.get名称(), is(new RString("_100")));
    }

    @Test
    public void _1000を指定した場合_get名称は__1000を返す() {
        assertThat(HasuChoseiTani._1000.get名称(), is(new RString("_1000")));
    }

    @Test
    public void _1を指定した場合_get略称は_1を返す() {
        assertThat(HasuChoseiTani._1.get略称(), is(new RString("1")));
    }

    @Test
    public void _10を指定した場合_get略称は_10を返す() {
        assertThat(HasuChoseiTani._10.get略称(), is(new RString("10")));
    }

    @Test
    public void _100を指定した場合_get略称は_100を返す() {
        assertThat(HasuChoseiTani._100.get略称(), is(new RString("100")));
    }

    @Test
    public void _1000を指定した場合_get略称は_1000を返す() {
        assertThat(HasuChoseiTani._1000.get略称(), is(new RString("1,000")));
    }

}
