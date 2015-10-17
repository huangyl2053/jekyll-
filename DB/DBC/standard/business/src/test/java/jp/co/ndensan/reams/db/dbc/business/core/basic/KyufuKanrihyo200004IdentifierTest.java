/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3014KyufuKanrihyo200004EntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuKanrihyo200004Identifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuKanrihyo200004IdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYearMonth 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static HokenshaNo 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static FlexibleDate 主キー名6;
    private static RString 主キー名7;
    private static RString 主キー名8;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_審査年月;
        主キー名2 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_証記載保険者番号;
        主キー名4 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_居宅支援事業所番号;
        主キー名5 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票情報作成区分コード;
        主キー名6 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票作成年月日;
        主キー名7 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票種別区分コード;
        主キー名8 = DbT3014KyufuKanrihyo200004EntityGenerator.DEFAULT_給付管理票明細行番号;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            KyufuKanrihyo200004Identifier sut = new KyufuKanrihyo200004Identifier(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8);
            assertThat(sut, is(serializable()));
        }
    }
}
