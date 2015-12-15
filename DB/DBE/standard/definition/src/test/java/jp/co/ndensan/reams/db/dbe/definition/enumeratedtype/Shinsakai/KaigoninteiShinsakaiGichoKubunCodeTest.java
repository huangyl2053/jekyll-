package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 介護認定審査会議長区分コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class KaigoninteiShinsakaiGichoKubunCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KaigoninteiShinsakaiGichoKubunCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KaigoninteiShinsakaiGichoKubunCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_委員を返す() {
        assertThat(KaigoninteiShinsakaiGichoKubunCode.toValue(new RString("0")), is(KaigoninteiShinsakaiGichoKubunCode.委員));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_議長を返す() {
        assertThat(KaigoninteiShinsakaiGichoKubunCode.toValue(new RString("1")), is(KaigoninteiShinsakaiGichoKubunCode.議長));
    }

    @Test
    public void 委員を指定した場合_getコードは_0を返す() {
        assertThat(KaigoninteiShinsakaiGichoKubunCode.委員.getコード(), is(new RString("0")));
    }

    @Test
    public void 議長を指定した場合_getコードは_1を返す() {
        assertThat(KaigoninteiShinsakaiGichoKubunCode.議長.getコード(), is(new RString("1")));
    }

    @Test
    public void 委員を指定した場合_get名称は_委員を返す() {
        assertThat(KaigoninteiShinsakaiGichoKubunCode.委員.get名称(), is(new RString("委員")));
    }

    @Test
    public void 議長を指定した場合_get名称は_議長を返す() {
        assertThat(KaigoninteiShinsakaiGichoKubunCode.議長.get名称(), is(new RString("議長")));
    }

}
