package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHantei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 要介護認定状態の安定性コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class JotaiAnteiseiCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JotaiAnteiseiCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JotaiAnteiseiCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_安定を返す() {
        assertThat(JotaiAnteiseiCode.toValue(new RString("1")), is(JotaiAnteiseiCode.安定));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_不安定を返す() {
        assertThat(JotaiAnteiseiCode.toValue(new RString("2")), is(JotaiAnteiseiCode.不安定));
    }

    @Test
    public void 安定を指定した場合_getコードは_1を返す() {
        assertThat(JotaiAnteiseiCode.安定.getコード(), is(new RString("1")));
    }

    @Test
    public void 不安定を指定した場合_getコードは_2を返す() {
        assertThat(JotaiAnteiseiCode.不安定.getコード(), is(new RString("2")));
    }

    @Test
    public void 安定を指定した場合_get名称は_安定を返す() {
        assertThat(JotaiAnteiseiCode.安定.get名称(), is(new RString("安定")));
    }

    @Test
    public void 不安定を指定した場合_get名称は_不安定を返す() {
        assertThat(JotaiAnteiseiCode.不安定.get名称(), is(new RString("不安定")));
    }

}
