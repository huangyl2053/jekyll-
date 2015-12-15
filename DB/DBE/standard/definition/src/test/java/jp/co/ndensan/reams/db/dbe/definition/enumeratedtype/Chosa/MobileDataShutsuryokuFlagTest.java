package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * モバイルデータ出力フラグのテストクラスです。
 * 
 * @author LDNS 
 */
public class MobileDataShutsuryokuFlagTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        MobileDataShutsuryokuFlag.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        MobileDataShutsuryokuFlag.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_未出力を返す() {
        assertThat(MobileDataShutsuryokuFlag.toValue(new RString("0")), is(MobileDataShutsuryokuFlag.未出力));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_出力済を返す() {
        assertThat(MobileDataShutsuryokuFlag.toValue(new RString("1")), is(MobileDataShutsuryokuFlag.出力済));
    }

    @Test
    public void 未出力を指定した場合_getコードは_0を返す() {
        assertThat(MobileDataShutsuryokuFlag.未出力.getコード(), is(new RString("0")));
    }

    @Test
    public void 出力済を指定した場合_getコードは_1を返す() {
        assertThat(MobileDataShutsuryokuFlag.出力済.getコード(), is(new RString("1")));
    }

    @Test
    public void 未出力を指定した場合_get名称は_未出力を返す() {
        assertThat(MobileDataShutsuryokuFlag.未出力.get名称(), is(new RString("未出力")));
    }

    @Test
    public void 出力済を指定した場合_get名称は_出力済を返す() {
        assertThat(MobileDataShutsuryokuFlag.出力済.get名称(), is(new RString("出力済")));
    }

}
