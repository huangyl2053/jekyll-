package jp.co.ndensan.reams.db.dbz.definition.core.shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 合議体ダミーフラグのテストクラスです。
 *
 * @author LDNS
 */
public class IsGogitaiDummyTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_ダミーを返す() {
        assertThat(IsGogitaiDummy.toValue(true), is(IsGogitaiDummy.ダミー));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_正規を返す() {
        assertThat(IsGogitaiDummy.toValue(false), is(IsGogitaiDummy.正規));
    }

    @Test
    public void ダミーを指定した場合_getコードは_Trueを返す() {
        assertThat(IsGogitaiDummy.ダミー.is合議体ダミーフラグTrue(), is(true));
    }

    @Test
    public void 正規を指定した場合_getコードは_Falseを返す() {
        assertThat(IsGogitaiDummy.正規.is合議体ダミーフラグTrue(), is(false));
    }

    @Test
    public void ダミーを指定した場合_get名称は_ダミーを返す() {
        assertThat(IsGogitaiDummy.ダミー.get名称(), is(new RString("ダミー")));
    }

    @Test
    public void 正規を指定した場合_get名称は_正規を返す() {
        assertThat(IsGogitaiDummy.正規.get名称(), is(new RString("正規")));
    }

}
