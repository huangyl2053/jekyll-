/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3016KyufujissekiShuruiDetailEntityGenerator;
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
 * {@link KyufujissekiShuruiDetailIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiShuruiDetailIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 交換情報識別番号;
    private static ShikibetsuCode 入力識別番号;
    private static RString レコード種別コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static JigyoshaNo 事業所番号;
    private static RString 通し番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_事業所番号;
        通し番号 = DbV3016KyufujissekiShuruiDetailEntityGenerator.DEFAULT_通し番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            KyufujissekiShuruiDetailIdentifier sut = new KyufujissekiShuruiDetailIdentifier(交換情報識別番号, 入力識別番号,
                    レコード種別コード, 証記載保険者番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号);
            assertThat(sut, is(serializable()));
        }
    }
}
