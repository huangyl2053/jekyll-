package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 申請状況区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShinseiJokyoKubunTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShinseiJokyoKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShinseiJokyoKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_申請中を返す() {
        assertThat(ShinseiJokyoKubun.toValue(new RString("0")), is(ShinseiJokyoKubun.申請中));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_認定完了を返す() {
        assertThat(ShinseiJokyoKubun.toValue(new RString("1")), is(ShinseiJokyoKubun.認定完了));
    }

    @Test
    public void 申請中を指定した場合_getコードは_0を返す() {
        assertThat(ShinseiJokyoKubun.申請中.getコード(), is(new RString("0")));
    }

    @Test
    public void 認定完了を指定した場合_getコードは_1を返す() {
        assertThat(ShinseiJokyoKubun.認定完了.getコード(), is(new RString("1")));
    }

    @Test
    public void 申請中を指定した場合_get名称は_申請中を返す() {
        assertThat(ShinseiJokyoKubun.申請中.get名称(), is(new RString("申請中")));
    }

    @Test
    public void 認定完了を指定した場合_get名称は_認定完了を返す() {
        assertThat(ShinseiJokyoKubun.認定完了.get名称(), is(new RString("認定完了")));
    }

}
