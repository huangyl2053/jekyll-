package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 事前調査フラグのテストクラスです。
 *
 * @author LDNS
 */
public class IsJizenChosaTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_出力を返す() {
        assertThat(IsJizenChosa.toValue(true), is(IsJizenChosa.出力));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_未出力を返す() {
        assertThat(IsJizenChosa.toValue(false), is(IsJizenChosa.未出力));
    }

    @Test
    public void 出力を指定した場合_getコードは_Trueを返す() {
        assertThat(IsJizenChosa.出力.getコード(), is(true));
    }

    @Test
    public void 未出力を指定した場合_getコードは_Falseを返す() {
        assertThat(IsJizenChosa.未出力.getコード(), is(false));
    }

    @Test
    public void 出力を指定した場合_get名称は_出力を返す() {
        assertThat(IsJizenChosa.出力.get名称(), is(new RString("出力")));
    }

    @Test
    public void 未出力を指定した場合_get名称は_未出力を返す() {
        assertThat(IsJizenChosa.未出力.get名称(), is(new RString("未出力")));
    }

}
