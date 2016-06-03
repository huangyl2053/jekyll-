package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ikensho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * その他受診科の有無のテストクラスです。
 *
 * @author LDNS
 */
public class SonotaJushinkaUmuTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_ありを返す() {
        assertThat(SonotaJushinkaUmu.toValue(true), is(SonotaJushinkaUmu.あり));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_なしを返す() {
        assertThat(SonotaJushinkaUmu.toValue(false), is(SonotaJushinkaUmu.なし));
    }

    @Test
    public void ありを指定した場合_getコードは_Trueを返す() {
        assertThat(SonotaJushinkaUmu.あり.isその他受診科(), is(true));
    }

    @Test
    public void なしを指定した場合_getコードは_Falseを返す() {
        assertThat(SonotaJushinkaUmu.なし.isその他受診科(), is(false));
    }

    @Test
    public void ありを指定した場合_get名称は_ありを返す() {
        assertThat(SonotaJushinkaUmu.あり.get名称(), is(new RString("あり")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(SonotaJushinkaUmu.なし.get名称(), is(new RString("なし")));
    }

}
