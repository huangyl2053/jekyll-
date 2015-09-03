/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3020KyufujissekiTokuteiSinryohiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.NyuryokuShikibetsuNo;
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
 * {@link KyufujissekiTokuteiSinryohiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiTokuteiSinryohiIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 主キー名1;
    private static NyuryokuShikibetsuNo 主キー名2;
    private static RString 主キー名3;
    private static HokenshaNo 主キー名4;
    private static HihokenshaNo 主キー名5;
    private static FlexibleYearMonth 主キー名6;
    private static JigyoshaNo 主キー名7;
    private static RString 主キー名8;
    private static RString 主キー名9;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_交換情報識別番号;
        主キー名2 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_入力識別番号;
        主キー名3 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_レコード種別コード;
        主キー名4 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名7 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_事業所番号;
        主キー名8 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_通し番号;
        主キー名9 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_特定診療情報レコード順次番号;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            KyufujissekiTokuteiSinryohiIdentifier sut = new KyufujissekiTokuteiSinryohiIdentifier(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9);
            assertThat(sut, is(serializable()));
        }
    }
}
