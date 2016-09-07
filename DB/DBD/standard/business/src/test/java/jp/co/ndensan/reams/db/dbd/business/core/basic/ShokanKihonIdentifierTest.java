/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3038ShokanKihonEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanKihonIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanKihonIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static RString 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3038ShokanKihonEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3038ShokanKihonEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3038ShokanKihonEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3038ShokanKihonEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3038ShokanKihonEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3038ShokanKihonEntityGenerator.DEFAULT_明細番号;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            ShokanKihonIdentifier sut = new ShokanKihonIdentifier(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut, is(serializable()));
        }
    }
}
