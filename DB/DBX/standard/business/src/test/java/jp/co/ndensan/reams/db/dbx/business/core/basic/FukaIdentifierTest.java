/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.business.core.fuka.FukaIdentifier;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
//import static jp.co.ndensan.reams.db.dbb.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FukaIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FukaIdentifierTest extends DbxTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 調停年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        調停年度 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
    }

    public static class シリアライズテスト extends DbxTestBase {

        @Test
        public void シリアライズできる() {
            FukaIdentifier sut = new FukaIdentifier(調停年度, 賦課年度, 通知書番号, 履歴番号);
//            assertThat(sut, is(serializable()));
        }
    }
}
