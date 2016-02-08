/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinseiIdentifier;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1013KyokaisoSochiShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyokaisoSochiShinseiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyokaisoSochiShinseiIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static int 履歴番号;
    private static int リンク番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_履歴番号;
        リンク番号 = DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_リンク番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            KyokaisoSochiShinseiIdentifier sut = new KyokaisoSochiShinseiIdentifier(被保険者番号, 履歴番号, リンク番号);
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }
}
