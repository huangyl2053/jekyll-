package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 自地区フラグのテストクラスです。
 *
 * @author LDNS
 */
public class JiChikuFlagTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_自地区を返す() {
        assertThat(JiChikuFlag.toValue(true), is(JiChikuFlag.自地区));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_他地区を返す() {
        assertThat(JiChikuFlag.toValue(false), is(JiChikuFlag.他地区));
    }

    @Test
    public void 自地区を指定した場合_getコードは_Trueを返す() {
        assertThat(JiChikuFlag.自地区.getコード(), is(true));
    }

    @Test
    public void 他地区を指定した場合_getコードは_Falseを返す() {
        assertThat(JiChikuFlag.他地区.getコード(), is(false));
    }

    @Test
    public void 自地区を指定した場合_get名称は_自地区を返す() {
        assertThat(JiChikuFlag.自地区.get名称(), is(new RString("自地区")));
    }

    @Test
    public void 他地区を指定した場合_get名称は_他地区を返す() {
        assertThat(JiChikuFlag.他地区.get名称(), is(new RString("他地区")));
    }

}
