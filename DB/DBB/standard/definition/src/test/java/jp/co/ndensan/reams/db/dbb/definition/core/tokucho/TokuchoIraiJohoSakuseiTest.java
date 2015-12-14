package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴依頼情報作成のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoIraiJohoSakuseiTest extends DbbTestBase {

    @Test
    public void _4月捕捉を指定した場合_get名称は__4月捕捉を返す() {
        assertThat(TokuchoIraiJohoSakusei._4月捕捉.get名称(), is(new RString("_4月捕捉")));
    }

}
