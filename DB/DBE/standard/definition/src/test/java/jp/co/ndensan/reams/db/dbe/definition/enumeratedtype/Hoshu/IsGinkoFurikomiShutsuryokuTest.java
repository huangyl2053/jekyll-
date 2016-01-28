package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 銀行振込出力フラグのテストクラスです。
 *
 * @author LDNS
 */
public class IsGinkoFurikomiShutsuryokuTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_出力済を返す() {
        assertThat(IsGinkoFurikomiShutsuryoku.toValue(true), is(IsGinkoFurikomiShutsuryoku.出力済));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_出力未を返す() {
        assertThat(IsGinkoFurikomiShutsuryoku.toValue(false), is(IsGinkoFurikomiShutsuryoku.出力未));
    }

    @Test
    public void 出力済を指定した場合_getコードは_Trueを返す() {
        assertThat(IsGinkoFurikomiShutsuryoku.出力済.getコード(), is(true));
    }

    @Test
    public void 出力未を指定した場合_getコードは_Falseを返す() {
        assertThat(IsGinkoFurikomiShutsuryoku.出力未.getコード(), is(false));
    }

    @Test
    public void 出力済を指定した場合_get名称は_出力済を返す() {
        assertThat(IsGinkoFurikomiShutsuryoku.出力済.get名称(), is(new RString("出力済")));
    }

    @Test
    public void 出力未を指定した場合_get名称は_出力未を返す() {
        assertThat(IsGinkoFurikomiShutsuryoku.出力未.get名称(), is(new RString("出力未")));
    }

}
