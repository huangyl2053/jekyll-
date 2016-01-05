package jp.co.ndensan.reams.db.dbc.definition.core.kyufukeiyaku;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 確約書有りのテストクラスです。
 * 
 * @author LDNS 
 */
public class ToriatsukaiKakuyakushoKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ToriatsukaiKakuyakushoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ToriatsukaiKakuyakushoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数にtrueを指定した場合_toValueは_確約書有りを返す() {
        assertThat(ToriatsukaiKakuyakushoKubun.toValue(new RString("true")), is(ToriatsukaiKakuyakushoKubun.確約書有り));
    }

    @Test
    public void 引数にfalseを指定した場合_toValueは_確約書無しを返す() {
        assertThat(ToriatsukaiKakuyakushoKubun.toValue(new RString("false")), is(ToriatsukaiKakuyakushoKubun.確約書無し));
    }

    @Test
    public void 確約書有りを指定した場合_getコードは_trueを返す() {
        assertThat(ToriatsukaiKakuyakushoKubun.確約書有り.getコード(), is(new RString("true")));
    }

    @Test
    public void 確約書無しを指定した場合_getコードは_falseを返す() {
        assertThat(ToriatsukaiKakuyakushoKubun.確約書無し.getコード(), is(new RString("false")));
    }

    @Test
    public void 確約書有りを指定した場合_get名称は_確約書有りを返す() {
        assertThat(ToriatsukaiKakuyakushoKubun.確約書有り.get名称(), is(new RString("確約書有り")));
    }

    @Test
    public void 確約書無しを指定した場合_get名称は_確約書無しを返す() {
        assertThat(ToriatsukaiKakuyakushoKubun.確約書無し.get名称(), is(new RString("確約書無し")));
    }

}
