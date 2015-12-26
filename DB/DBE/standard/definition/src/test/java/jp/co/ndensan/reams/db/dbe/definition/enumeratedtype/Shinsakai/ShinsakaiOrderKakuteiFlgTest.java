package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 介護認定審査会審査順確定フラグのテストクラスです。
 *
 * @author LDNS
 */
public class ShinsakaiOrderKakuteiFlgTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_確定を返す() {
        assertThat(ShinsakaiOrderKakuteiFlg.toValue(true), is(ShinsakaiOrderKakuteiFlg.確定));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_未確定を返す() {
        assertThat(ShinsakaiOrderKakuteiFlg.toValue(false), is(ShinsakaiOrderKakuteiFlg.未確定));
    }

    @Test
    public void 確定を指定した場合_getコードは_Trueを返す() {
        assertThat(ShinsakaiOrderKakuteiFlg.確定.getコード(), is(true));
    }

    @Test
    public void 未確定を指定した場合_getコードは_Falseを返す() {
        assertThat(ShinsakaiOrderKakuteiFlg.未確定.getコード(), is(false));
    }

    @Test
    public void 確定を指定した場合_get名称は_確定を返す() {
        assertThat(ShinsakaiOrderKakuteiFlg.確定.get名称(), is(new RString("確定")));
    }

    @Test
    public void 未確定を指定した場合_get名称は_未確定を返す() {
        assertThat(ShinsakaiOrderKakuteiFlg.未確定.get名称(), is(new RString("未確定")));
    }

}
