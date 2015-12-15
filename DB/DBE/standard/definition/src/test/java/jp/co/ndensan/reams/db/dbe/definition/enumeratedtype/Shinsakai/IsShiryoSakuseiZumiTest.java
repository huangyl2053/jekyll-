package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 資料作成済区分のテストクラスです。
 *
 * @author LDNS
 */
public class IsShiryoSakuseiZumiTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_作成済を返す() {
        assertThat(IsShiryoSakuseiZumi.toValue(true), is(IsShiryoSakuseiZumi.作成済));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_未作成を返す() {
        assertThat(IsShiryoSakuseiZumi.toValue(false), is(IsShiryoSakuseiZumi.未作成));
    }

    @Test
    public void 作成済を指定した場合_getコードは_Trueを返す() {
        assertThat(IsShiryoSakuseiZumi.作成済.getコード(), is(true));
    }

    @Test
    public void 未作成を指定した場合_getコードは_Falseを返す() {
        assertThat(IsShiryoSakuseiZumi.未作成.getコード(), is(false));
    }

    @Test
    public void 作成済を指定した場合_get名称は_作成済を返す() {
        assertThat(IsShiryoSakuseiZumi.作成済.get名称(), is(new RString("作成済")));
    }

    @Test
    public void 未作成を指定した場合_get名称は_未作成を返す() {
        assertThat(IsShiryoSakuseiZumi.未作成.get名称(), is(new RString("未作成")));
    }

}
