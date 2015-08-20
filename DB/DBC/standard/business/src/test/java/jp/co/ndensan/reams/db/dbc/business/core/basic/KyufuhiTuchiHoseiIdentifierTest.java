/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3067KyufuhiTuchiHoseiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuhiTuchiHoseiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiTuchiHoseiIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static JigyoshaNo 事業所番号;
    private static ServiceShuruiCode サービス種類コード;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        証記載保険者番号 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_事業所番号;
        サービス種類コード = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_サービス種類コード;
        履歴番号 = DbT3067KyufuhiTuchiHoseiEntityGenerator.DEFAULT_履歴番号;

    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            KyufuhiTuchiHoseiIdentifier sut = new KyufuhiTuchiHoseiIdentifier(証記載保険者番号,
                    被保険者番号, サービス提供年月, 事業所番号, サービス種類コード, 履歴番号);
            assertThat(sut, is(serializable()));
        }
    }
}
