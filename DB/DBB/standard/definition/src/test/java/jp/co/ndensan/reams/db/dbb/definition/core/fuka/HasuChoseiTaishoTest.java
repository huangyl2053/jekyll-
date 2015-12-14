package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 端数調整対象のテストクラスです。
 *
 * @author LDNS
 */
public class HasuChoseiTaishoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HasuChoseiTaisho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HasuChoseiTaisho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_標準を返す() {
        assertThat(HasuChoseiTaisho.toValue(new RString("1")), is(HasuChoseiTaisho.標準));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_全件を返す() {
        assertThat(HasuChoseiTaisho.toValue(new RString("2")), is(HasuChoseiTaisho.全件));
    }

    @Test
    public void 標準を指定した場合_getコードは_1を返す() {
        assertThat(HasuChoseiTaisho.標準.getコード(), is(new RString("1")));
    }

    @Test
    public void 全件を指定した場合_getコードは_2を返す() {
        assertThat(HasuChoseiTaisho.全件.getコード(), is(new RString("2")));
    }

    @Test
    public void 標準を指定した場合_get名称は_標準を返す() {
        assertThat(HasuChoseiTaisho.標準.get名称(), is(new RString("標準")));
    }

    @Test
    public void 全件を指定した場合_get名称は_全件を返す() {
        assertThat(HasuChoseiTaisho.全件.get名称(), is(new RString("全件")));
    }

}
