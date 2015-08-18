/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FukaAliveIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FukaAliveIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        調定年度 = DbV2002FukaEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbV2002FukaEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbV2002FukaEntityGenerator.DEFAULT_通知書番号;
        履歴番号 = DbV2002FukaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            FukaAliveIdentifier sut = new FukaAliveIdentifier(調定年度, 賦課年度, 通知書番号, 履歴番号);
            assertThat(sut, is(serializable()));
        }
    }
}
