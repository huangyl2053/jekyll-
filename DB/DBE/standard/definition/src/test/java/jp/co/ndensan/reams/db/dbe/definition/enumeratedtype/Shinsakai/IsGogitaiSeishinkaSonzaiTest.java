package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 合議体精神科医存在フラグのテストクラスです。
 *
 * @author LDNS
 */
public class IsGogitaiSeishinkaSonzaiTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_存在を返す() {
        assertThat(IsGogitaiSeishinkaSonzai.toValue(true), is(IsGogitaiSeishinkaSonzai.存在));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_不在を返す() {
        assertThat(IsGogitaiSeishinkaSonzai.toValue(false), is(IsGogitaiSeishinkaSonzai.不在));
    }

    @Test
    public void 存在を指定した場合_getコードは_Trueを返す() {
        assertThat(IsGogitaiSeishinkaSonzai.存在.getコード(), is(true));
    }

    @Test
    public void 不在を指定した場合_getコードは_Falseを返す() {
        assertThat(IsGogitaiSeishinkaSonzai.不在.getコード(), is(false));
    }

    @Test
    public void 存在を指定した場合_get名称は_存在を返す() {
        assertThat(IsGogitaiSeishinkaSonzai.存在.get名称(), is(new RString("存在")));
    }

    @Test
    public void 不在を指定した場合_get名称は_不在を返す() {
        assertThat(IsGogitaiSeishinkaSonzai.不在.get名称(), is(new RString("不在")));
    }

}
