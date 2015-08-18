/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3078ShokanJuryoininKeiyakushaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanJuryoininKeiyakushaAliveIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanJuryoininKeiyakushaAliveIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static ShoKisaiHokenshaNo 証記載保険者番号;
    private static FlexibleDate 受付年月日;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号;
        証記載保険者番号 = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号;
        受付年月日 = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日;
        履歴番号 = DbV3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            ShokanJuryoininKeiyakushaAliveIdentifier sut = new ShokanJuryoininKeiyakushaAliveIdentifier(被保険者番号, 証記載保険者番号, 受付年月日, 履歴番号);
            assertThat(sut, is(serializable()));
        }
    }
}
