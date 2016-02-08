package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 介護認定審査会優先振分区分コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class ShinsakaiYusenWaritsukeKubunCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShinsakaiYusenWaritsukeKubunCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShinsakaiYusenWaritsukeKubunCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_通常を返す() {
        assertThat(ShinsakaiYusenWaritsukeKubunCode.toValue(new RString("0")), is(ShinsakaiYusenWaritsukeKubunCode.通常));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_優先を返す() {
        assertThat(ShinsakaiYusenWaritsukeKubunCode.toValue(new RString("1")), is(ShinsakaiYusenWaritsukeKubunCode.優先));
    }

    @Test
    public void 通常を指定した場合_getコードは_0を返す() {
        assertThat(ShinsakaiYusenWaritsukeKubunCode.通常.getコード(), is(new RString("0")));
    }

    @Test
    public void 優先を指定した場合_getコードは_1を返す() {
        assertThat(ShinsakaiYusenWaritsukeKubunCode.優先.getコード(), is(new RString("1")));
    }

    @Test
    public void 通常を指定した場合_get名称は_通常を返す() {
        assertThat(ShinsakaiYusenWaritsukeKubunCode.通常.get名称(), is(new RString("通常")));
    }

    @Test
    public void 優先を指定した場合_get名称は_優先を返す() {
        assertThat(ShinsakaiYusenWaritsukeKubunCode.優先.get名称(), is(new RString("優先")));
    }

}
