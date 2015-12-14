package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特徴開始通知書仮算定出力条件のテストクラスです。
 *
 * @author LDNS
 */
public class TokuchoKaishiTsuhishoKariOutputJokenTest extends DbbTestBase {

    @Test
    public void 全件_追加候補者含むを指定した場合_get名称は_全件_追加候補者含むを返す() {
        assertThat(TokuchoKaishiTsuhishoKariOutputJoken.全件_追加候補者含む.get名称(), is(new RString("全件_追加候補者含む")));
    }

    @Test
    public void 全件_追加候補者含まないを指定した場合_get名称は_全件_追加候補者含まないを返す() {
        assertThat(TokuchoKaishiTsuhishoKariOutputJoken.全件_追加候補者含まない.get名称(), is(new RString("全件_追加候補者含まない")));
    }

    @Test
    public void 追加候補者のみ全てを指定した場合_get名称は_追加候補者のみ全てを返す() {
        assertThat(TokuchoKaishiTsuhishoKariOutputJoken.追加候補者のみ全て.get名称(), is(new RString("追加候補者のみ全て")));
    }

    @Test
    public void _4月特別徴収開始の追加候補者のみを指定した場合_get名称は__4月特別徴収開始の追加候補者のみを返す() {
        assertThat(TokuchoKaishiTsuhishoKariOutputJoken._4月特別徴収開始の追加候補者のみ.get名称(), is(new RString("_4月特別徴収開始の追加候補者のみ")));
    }

    @Test
    public void _6月特別徴収開始の追加候補者のみを指定した場合_get名称は__6月特別徴収開始の追加候補者のみを返す() {
        assertThat(TokuchoKaishiTsuhishoKariOutputJoken._6月特別徴収開始の追加候補者のみ.get名称(), is(new RString("_6月特別徴収開始の追加候補者のみ")));
    }

}
