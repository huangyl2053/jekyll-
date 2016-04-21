package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 委員遅刻有無のテストクラスです。
 *
 * @author LDNS
 */
public class IsChikokuUmuTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_遅刻を返す() {
        assertThat(IsChikokuUmu.toValue(true), is(IsChikokuUmu.遅刻));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_遅刻なしを返す() {
        assertThat(IsChikokuUmu.toValue(false), is(IsChikokuUmu.遅刻なし));
    }

    @Test
    public void 遅刻を指定した場合_getコードは_Trueを返す() {
        assertThat(IsChikokuUmu.遅刻.is委員遅刻(), is(true));
    }

    @Test
    public void 遅刻なしを指定した場合_getコードは_Falseを返す() {
        assertThat(IsChikokuUmu.遅刻なし.is委員遅刻(), is(false));
    }

    @Test
    public void 遅刻を指定した場合_get名称は_遅刻を返す() {
        assertThat(IsChikokuUmu.遅刻.get名称(), is(new RString("遅刻")));
    }

    @Test
    public void 遅刻なしを指定した場合_get名称は_遅刻なしを返す() {
        assertThat(IsChikokuUmu.遅刻なし.get名称(), is(new RString("遅刻なし")));
    }

}
