package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 端数調整方法のテストクラスです。
 *
 * @author LDNS
 */
public class HasuChoseiHohoTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HasuChoseiHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HasuChoseiHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_切上げを返す() {
        assertThat(HasuChoseiHoho.toValue(new RString("1")), is(HasuChoseiHoho.切上げ));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_切捨てを返す() {
        assertThat(HasuChoseiHoho.toValue(new RString("2")), is(HasuChoseiHoho.切捨て));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_四捨五入を返す() {
        assertThat(HasuChoseiHoho.toValue(new RString("3")), is(HasuChoseiHoho.四捨五入));
    }

    @Test
    public void 切上げを指定した場合_getコードは_1を返す() {
        assertThat(HasuChoseiHoho.切上げ.getコード(), is(new RString("1")));
    }

    @Test
    public void 切捨てを指定した場合_getコードは_2を返す() {
        assertThat(HasuChoseiHoho.切捨て.getコード(), is(new RString("2")));
    }

    @Test
    public void 四捨五入を指定した場合_getコードは_3を返す() {
        assertThat(HasuChoseiHoho.四捨五入.getコード(), is(new RString("3")));
    }

    @Test
    public void 切上げを指定した場合_get名称は_切上げを返す() {
        assertThat(HasuChoseiHoho.切上げ.get名称(), is(new RString("切上げ")));
    }

    @Test
    public void 切捨てを指定した場合_get名称は_切捨てを返す() {
        assertThat(HasuChoseiHoho.切捨て.get名称(), is(new RString("切捨て")));
    }

    @Test
    public void 四捨五入を指定した場合_get名称は_四捨五入を返す() {
        assertThat(HasuChoseiHoho.四捨五入.get名称(), is(new RString("四捨五入")));
    }

}
