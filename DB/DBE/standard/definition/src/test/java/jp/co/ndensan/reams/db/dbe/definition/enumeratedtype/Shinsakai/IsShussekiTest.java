package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 委員出席のテストクラスです。
 *
 * @author LDNS
 */
public class IsShussekiTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_出席を返す() {
        assertThat(IsShusseki.toValue(true), is(IsShusseki.出席));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_欠席を返す() {
        assertThat(IsShusseki.toValue(false), is(IsShusseki.欠席));
    }

    @Test
    public void 出席を指定した場合_getコードは_Trueを返す() {
        assertThat(IsShusseki.出席.getコード(), is(true));
    }

    @Test
    public void 欠席を指定した場合_getコードは_Falseを返す() {
        assertThat(IsShusseki.欠席.getコード(), is(false));
    }

    @Test
    public void 出席を指定した場合_get名称は_出席を返す() {
        assertThat(IsShusseki.出席.get名称(), is(new RString("出席")));
    }

    @Test
    public void 欠席を指定した場合_get名称は_欠席を返す() {
        assertThat(IsShusseki.欠席.get名称(), is(new RString("欠席")));
    }

}
