/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KibetsuIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KibetsuIdentifierTest extends DbbTestBase {

    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static int 履歴番号;
    private static RString 徴収方法;
    private static int 期;

    @BeforeClass
    public static void setUpClass() {

        調定年度 = DbT2003KibetsuEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2003KibetsuEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbT2003KibetsuEntityGenerator.DEFAULT_通知書番号;
        履歴番号 = DbT2003KibetsuEntityGenerator.DEFAULT_履歴番号;
        徴収方法 = DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法;
        期 = DbT2003KibetsuEntityGenerator.DEFAULT_期;
    }

    public static class シリアライズテスト extends DbbTestBase {

        @Test
        public void シリアライズできる() {
            KibetsuIdentifier sut = new KibetsuIdentifier(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }
}
