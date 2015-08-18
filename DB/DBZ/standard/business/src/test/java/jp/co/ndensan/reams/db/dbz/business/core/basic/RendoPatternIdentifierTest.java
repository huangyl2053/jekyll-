/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RendoPatternIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RendoPatternIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 送信元市町村コード;
    private static LasdecCode 送信先市町村コード;
    private static RString 種別;
    private static FlexibleDate 有効開始年月日;
    private static FlexibleDate 有効終了年月日;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        送信元市町村コード = DbT7035RendoPatternEntityGenerator.DEFAULT_送信元市町村コード;
        送信先市町村コード = DbT7035RendoPatternEntityGenerator.DEFAULT_送信先市町村コード;
        種別 = DbT7035RendoPatternEntityGenerator.DEFAULT_種別;
        有効開始年月日 = DbT7035RendoPatternEntityGenerator.DEFAULT_有効開始年月日;
        有効終了年月日 = DbT7035RendoPatternEntityGenerator.DEFAULT_有効終了年月日;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            RendoPatternIdentifier sut = new RendoPatternIdentifier(送信元市町村コード, 送信先市町村コード, 種別, 有効開始年月日, 有効終了年月日);
            assertThat(sut, is(serializable()));
        }
    }
}
