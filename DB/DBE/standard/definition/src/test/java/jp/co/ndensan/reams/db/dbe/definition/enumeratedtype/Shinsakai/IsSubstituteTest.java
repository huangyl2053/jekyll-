package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 補欠のテストクラスです。
 *
 * @author LDNS
 */
public class IsSubstituteTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_補欠を返す() {
        assertThat(IsSubstitute.toValue(true), is(IsSubstitute.補欠));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_通常を返す() {
        assertThat(IsSubstitute.toValue(false), is(IsSubstitute.通常));
    }

    @Test
    public void 補欠を指定した場合_getコードは_Trueを返す() {
        assertThat(IsSubstitute.補欠.getコード(), is(true));
    }

    @Test
    public void 通常を指定した場合_getコードは_Falseを返す() {
        assertThat(IsSubstitute.通常.getコード(), is(false));
    }

    @Test
    public void 補欠を指定した場合_get名称は_補欠を返す() {
        assertThat(IsSubstitute.補欠.get名称(), is(new RString("補欠")));
    }

    @Test
    public void 通常を指定した場合_get名称は_通常を返す() {
        assertThat(IsSubstitute.通常.get名称(), is(new RString("通常")));
    }

}
