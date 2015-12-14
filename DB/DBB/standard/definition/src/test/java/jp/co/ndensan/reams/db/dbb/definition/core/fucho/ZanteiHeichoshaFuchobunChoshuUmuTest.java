package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 仮算定併徴者普徴分徴収有無のテストクラスです。
 *
 * @author LDNS
 */
public class ZanteiHeichoshaFuchobunChoshuUmuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ZanteiHeichoshaFuchobunChoshuUmu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ZanteiHeichoshaFuchobunChoshuUmu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_徴収しないを返す() {
        assertThat(ZanteiHeichoshaFuchobunChoshuUmu.toValue(new RString("0")), is(ZanteiHeichoshaFuchobunChoshuUmu.徴収しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_徴収するを返す() {
        assertThat(ZanteiHeichoshaFuchobunChoshuUmu.toValue(new RString("1")), is(ZanteiHeichoshaFuchobunChoshuUmu.徴収する));
    }

    @Test
    public void 徴収しないを指定した場合_getコードは_0を返す() {
        assertThat(ZanteiHeichoshaFuchobunChoshuUmu.徴収しない.getコード(), is(new RString("0")));
    }

    @Test
    public void 徴収するを指定した場合_getコードは_1を返す() {
        assertThat(ZanteiHeichoshaFuchobunChoshuUmu.徴収する.getコード(), is(new RString("1")));
    }

    @Test
    public void 徴収しないを指定した場合_get名称は_徴収しないを返す() {
        assertThat(ZanteiHeichoshaFuchobunChoshuUmu.徴収しない.get名称(), is(new RString("徴収しない")));
    }

    @Test
    public void 徴収するを指定した場合_get名称は_徴収するを返す() {
        assertThat(ZanteiHeichoshaFuchobunChoshuUmu.徴収する.get名称(), is(new RString("徴収する")));
    }

}
