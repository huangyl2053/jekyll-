package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 仮算定計算端数調整のテストクラスです。
 *
 * @author LDNS
 */
public class ZanteiKeisanHasuChoseiTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ZanteiKeisanHasuChosei.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ZanteiKeisanHasuChosei.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_なしを返す() {
        assertThat(ZanteiKeisanHasuChosei.toValue(new RString("0")), is(ZanteiKeisanHasuChosei.なし));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_ありを返す() {
        assertThat(ZanteiKeisanHasuChosei.toValue(new RString("1")), is(ZanteiKeisanHasuChosei.あり));
    }

    @Test
    public void なしを指定した場合_getコードは_0を返す() {
        assertThat(ZanteiKeisanHasuChosei.なし.getコード(), is(new RString("0")));
    }

    @Test
    public void ありを指定した場合_getコードは_1を返す() {
        assertThat(ZanteiKeisanHasuChosei.あり.getコード(), is(new RString("1")));
    }

    @Test
    public void なしを指定した場合_get名称は_端数調整なしを返す() {
        assertThat(ZanteiKeisanHasuChosei.なし.get名称(), is(new RString("端数調整なし")));
    }

    @Test
    public void ありを指定した場合_get名称は_端数調整ありを返す() {
        assertThat(ZanteiKeisanHasuChosei.あり.get名称(), is(new RString("端数調整あり")));
    }

    @Test
    public void なしを指定した場合_get略称は_なしを返す() {
        assertThat(ZanteiKeisanHasuChosei.なし.get略称(), is(new RString("なし")));
    }

    @Test
    public void ありを指定した場合_get略称は_ありを返す() {
        assertThat(ZanteiKeisanHasuChosei.あり.get略称(), is(new RString("あり")));
    }

}
