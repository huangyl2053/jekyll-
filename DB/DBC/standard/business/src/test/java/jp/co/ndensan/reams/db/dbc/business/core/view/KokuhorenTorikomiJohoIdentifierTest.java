/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.view;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbV3104KokuhorenTorikomiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KokuhorenTorikomiJohoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KokuhorenTorikomiJohoIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 処理年月;
    private static RString 交換情報識別番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        処理年月 = DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_処理年月;
        交換情報識別番号 = DbV3104KokuhorenTorikomiJohoEntityGenerator.DEFAULT_交換情報識別番号;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            KokuhorenTorikomiJohoIdentifier sut = new KokuhorenTorikomiJohoIdentifier(処理年月, 交換情報識別番号);
            //TODO
//            assertThat(sut, is(serializable()));
        }
    }
}
