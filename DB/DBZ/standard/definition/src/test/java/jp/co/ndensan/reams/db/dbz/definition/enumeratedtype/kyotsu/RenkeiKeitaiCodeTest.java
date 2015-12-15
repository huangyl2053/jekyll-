package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 連携形態コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class RenkeiKeitaiCodeTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        RenkeiKeitaiCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        RenkeiKeitaiCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_FDを返す() {
        assertThat(RenkeiKeitaiCode.toValue(new RString("01")), is(RenkeiKeitaiCode.FD));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_ネットワークを返す() {
        assertThat(RenkeiKeitaiCode.toValue(new RString("02")), is(RenkeiKeitaiCode.ネットワーク));
    }

    @Test
    public void FDを指定した場合_getコードは_01を返す() {
        assertThat(RenkeiKeitaiCode.FD.getコード(), is(new RString("01")));
    }

    @Test
    public void ネットワークを指定した場合_getコードは_02を返す() {
        assertThat(RenkeiKeitaiCode.ネットワーク.getコード(), is(new RString("02")));
    }

    @Test
    public void FDを指定した場合_get名称は_FDを返す() {
        assertThat(RenkeiKeitaiCode.FD.get名称(), is(new RString("FD")));
    }

    @Test
    public void ネットワークを指定した場合_get名称は_ネットワークを返す() {
        assertThat(RenkeiKeitaiCode.ネットワーク.get名称(), is(new RString("ネットワーク")));
    }

}
