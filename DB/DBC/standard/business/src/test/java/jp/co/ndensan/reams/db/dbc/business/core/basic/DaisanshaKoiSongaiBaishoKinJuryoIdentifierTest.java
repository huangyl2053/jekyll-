/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DaisanshaKoiSongaiBaishoKinJuryoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiSongaiBaishoKinJuryoIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static RString 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為届出管理番号;
        主キー名3 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為求償請求番号;
        主キー名4 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbcTestBase {

//        @Test
//        public void シリアライズできる() {
//            DaisanshaKoiSongaiBaishoKinJuryoIdentifier sut = new DaisanshaKoiSongaiBaishoKinJuryoIdentifier(主キー名1, 主キー名2, 主キー名3, 主キー名4);
//            assertThat(sut, is(serializable()));
//        }
    }
}
