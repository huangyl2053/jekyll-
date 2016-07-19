/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHohoIdentifier;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2001ChoshuHohoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChoshuHohoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChoshuHohoIdentifierTest extends DbxTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 賦課年度;
    private static HihokenshaNo 被保険者番号;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        賦課年度 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度;
        被保険者番号 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_被保険者番号;
    }

    public static class シリアライズテスト extends DbxTestBase {

        @Test
        public void シリアライズできる() {
            ChoshuHohoIdentifier sut = new ChoshuHohoIdentifier(賦課年度, 被保険者番号, 履歴番号);
//            assertThat(sut, is(serializable()));
        }
    }
}
