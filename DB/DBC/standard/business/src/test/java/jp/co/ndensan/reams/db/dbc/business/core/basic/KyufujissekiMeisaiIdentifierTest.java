/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3018KyufujissekiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
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
 * {@link KyufujissekiMeisaiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiMeisaiIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 交換情報識別番号;
    private static NyuryokuShikibetsuNo 入力識別番号;
    private static RString レコード種別コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static JigyoshaNo 事業所番号;
    private static RString 通し番号;
    private static ServiceShuruiCode サービス種類コード;
    private static ServiceKomokuCode サービス項目コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_事業所番号;
        通し番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_通し番号;
        サービス種類コード = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
        サービス項目コード = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            KyufujissekiMeisaiIdentifier sut = new KyufujissekiMeisaiIdentifier(交換情報識別番号, 入力識別番号,
                    レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月,
                    事業所番号, 通し番号, サービス種類コード, サービス項目コード);
            assertThat(sut, is(serializable()));
        }
    }
}
