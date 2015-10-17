/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikosakuseiMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuJikosakuseiMeisaiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikosakuseiMeisaiIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth 対象年月;
    private static Decimal 履歴番号;
    private static RString 居宅サービス区分;
    private static JigyoshaNo サービス提供事業者;
    private static ServiceShuruiCode サービス種類コード;
    private static ServiceKomokuCode サービス項目コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号;
        対象年月 = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_対象年月;
        履歴番号 = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_履歴番号;
        居宅サービス区分 = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_居宅サービス区分;
        サービス提供事業者 = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号;
        サービス種類コード = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
        サービス項目コード = DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            KyotakuKeikakuJikosakuseiMeisaiIdentifier sut = new KyotakuKeikakuJikosakuseiMeisaiIdentifier(被保険者番号, 対象年月,
                    履歴番号, 居宅サービス区分, サービス提供事業者, サービス種類コード, サービス項目コード);
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }
}
