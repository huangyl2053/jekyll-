package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴異動情報作成のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoIdoJohoSakuseiTest extends DbbTestBase {

    @Test
    public void 前年度12月捕捉を指定した場合_get名称は_前年度12月捕捉を返す() {
        assertThat(TokuchoIdoJohoSakusei.前年度12月捕捉.get名称(), is(new RString("前年度12月捕捉")));
    }

    @Test
    public void 前年度2月捕捉を指定した場合_get名称は_前年度2月捕捉を返す() {
        assertThat(TokuchoIdoJohoSakusei.前年度2月捕捉.get名称(), is(new RString("前年度2月捕捉")));
    }

    @Test
    public void _6月捕捉を指定した場合_get名称は__6月捕捉を返す() {
        assertThat(TokuchoIdoJohoSakusei._6月捕捉.get名称(), is(new RString("_6月捕捉")));
    }

    @Test
    public void _8月捕捉を指定した場合_get名称は__8月捕捉を返す() {
        assertThat(TokuchoIdoJohoSakusei._8月捕捉.get名称(), is(new RString("_8月捕捉")));
    }

    @Test
    public void _10月捕捉を指定した場合_get名称は__10月捕捉を返す() {
        assertThat(TokuchoIdoJohoSakusei._10月捕捉.get名称(), is(new RString("_10月捕捉")));
    }

}
