/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JukyushaGendoGakuKanriIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JukyushaGendoGakuKanriIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static int 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_識別区分;
        主キー名3 = jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効開始年月;
        主キー名4 = jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbcTestBase {

//        @Test
//        public void シリアライズできる() {
//            JukyushaGendoGakuKanriIdentifier sut = new JukyushaGendoGakuKanriIdentifier(主キー名1, 主キー名2, 主キー名3, 主キー名4);
//            assertThat(sut, is(serializable()));
//        }
    }
}
