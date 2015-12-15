package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHantei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 仮一次判定区分のテストクラスです。
 *
 * @author LDNS
 */
public class KariIchijiHanteiKubunTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_仮一次判定を返す() {
        assertThat(KariIchijiHanteiKubun.toValue(true), is(KariIchijiHanteiKubun.仮一次判定));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_本一次判定を返す() {
        assertThat(KariIchijiHanteiKubun.toValue(false), is(KariIchijiHanteiKubun.本一次判定));
    }

    @Test
    public void 仮一次判定を指定した場合_getコードは_Trueを返す() {
        assertThat(KariIchijiHanteiKubun.仮一次判定.getコード(), is(true));
    }

    @Test
    public void 本一次判定を指定した場合_getコードは_Falseを返す() {
        assertThat(KariIchijiHanteiKubun.本一次判定.getコード(), is(false));
    }

    @Test
    public void 仮一次判定を指定した場合_get名称は_仮一次判定を返す() {
        assertThat(KariIchijiHanteiKubun.仮一次判定.get名称(), is(new RString("仮一次判定")));
    }

    @Test
    public void 本一次判定を指定した場合_get名称は_本一次判定を返す() {
        assertThat(KariIchijiHanteiKubun.本一次判定.get名称(), is(new RString("本一次判定")));
    }

}
