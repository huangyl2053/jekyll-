package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 認定審査会意見種類のテストクラスです。
 * 
 * @author LDNS 
 */
public class NinteiShinsakaiIkenShuruiTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NinteiShinsakaiIkenShurui.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NinteiShinsakaiIkenShurui.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_必要な療養への意見を返す() {
        assertThat(NinteiShinsakaiIkenShurui.toValue(new RString("1")), is(NinteiShinsakaiIkenShurui.必要な療養への意見));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_有効期間への意見を返す() {
        assertThat(NinteiShinsakaiIkenShurui.toValue(new RString("2")), is(NinteiShinsakaiIkenShurui.有効期間への意見));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_サービス利用への意見を返す() {
        assertThat(NinteiShinsakaiIkenShurui.toValue(new RString("3")), is(NinteiShinsakaiIkenShurui.サービス利用への意見));
    }

    @Test
    public void 必要な療養への意見を指定した場合_getコードは_1を返す() {
        assertThat(NinteiShinsakaiIkenShurui.必要な療養への意見.getコード(), is(new RString("1")));
    }

    @Test
    public void 有効期間への意見を指定した場合_getコードは_2を返す() {
        assertThat(NinteiShinsakaiIkenShurui.有効期間への意見.getコード(), is(new RString("2")));
    }

    @Test
    public void サービス利用への意見を指定した場合_getコードは_3を返す() {
        assertThat(NinteiShinsakaiIkenShurui.サービス利用への意見.getコード(), is(new RString("3")));
    }

    @Test
    public void 必要な療養への意見を指定した場合_get名称は_必要な療養への意見を返す() {
        assertThat(NinteiShinsakaiIkenShurui.必要な療養への意見.get名称(), is(new RString("必要な療養への意見")));
    }

    @Test
    public void 有効期間への意見を指定した場合_get名称は_有効期間への意見を返す() {
        assertThat(NinteiShinsakaiIkenShurui.有効期間への意見.get名称(), is(new RString("有効期間への意見")));
    }

    @Test
    public void サービス利用への意見を指定した場合_get名称は_サービス利用への意見を返す() {
        assertThat(NinteiShinsakaiIkenShurui.サービス利用への意見.get名称(), is(new RString("サービス利用への意見")));
    }

}
