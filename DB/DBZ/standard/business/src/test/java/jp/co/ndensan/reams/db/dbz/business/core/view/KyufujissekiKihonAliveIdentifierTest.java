/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3017KyufujissekiKihonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiKihonAliveIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiKihonAliveIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 交換情報識別番号;
    private static ShikibetsuCode 入力識別番号;
    private static RString レコード種別コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static JigyoshaNo 事業所番号;
    private static RString 給付実績情報作成区分コード;
    private static RString 給付実績区分コード;
    private static RString 通し番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbV3017KyufujissekiKihonEntityGenerator.DEFAULT_入力識別番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            KyufujissekiKihonAliveIdentifier sut = new KyufujissekiKihonAliveIdentifier(交換情報識別番号, 入力識別番号,
                    レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 給付実績情報作成区分コード, 給付実績区分コード, 通し番号);
            assertThat(sut, is(serializable()));
        }
    }
}
