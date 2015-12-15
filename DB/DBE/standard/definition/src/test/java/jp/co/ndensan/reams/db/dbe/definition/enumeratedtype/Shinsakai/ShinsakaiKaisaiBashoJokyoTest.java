package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 審査会開催場所状況のテストクラスです。
 *
 * @author LDNS
 */
public class ShinsakaiKaisaiBashoJokyoTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_有効を返す() {
        assertThat(ShinsakaiKaisaiBashoJokyo.toValue(true), is(ShinsakaiKaisaiBashoJokyo.有効));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_無効を返す() {
        assertThat(ShinsakaiKaisaiBashoJokyo.toValue(false), is(ShinsakaiKaisaiBashoJokyo.無効));
    }

    @Test
    public void 有効を指定した場合_getコードは_Trueを返す() {
        assertThat(ShinsakaiKaisaiBashoJokyo.有効.getコード(), is(true));
    }

    @Test
    public void 無効を指定した場合_getコードは_Falseを返す() {
        assertThat(ShinsakaiKaisaiBashoJokyo.無効.getコード(), is(false));
    }

    @Test
    public void 有効を指定した場合_get名称は_有効を返す() {
        assertThat(ShinsakaiKaisaiBashoJokyo.有効.get名称(), is(new RString("有効")));
    }

    @Test
    public void 無効を指定した場合_get名称は_無効を返す() {
        assertThat(ShinsakaiKaisaiBashoJokyo.無効.get名称(), is(new RString("無効")));
    }

}
