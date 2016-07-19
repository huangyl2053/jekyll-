/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FukaIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FukaIdentifierTest extends DbbTestBase {

    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
        調定年度 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbT2002FukaEntityGenerator.DEFAULT_通知書番号;
        履歴番号 = DbT2002FukaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbbTestBase {

        @Test
        public void シリアライズできる() {
            FukaIdentifier sut = new FukaIdentifier(調定年度, 賦課年度, 通知書番号, 履歴番号);
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }
}
