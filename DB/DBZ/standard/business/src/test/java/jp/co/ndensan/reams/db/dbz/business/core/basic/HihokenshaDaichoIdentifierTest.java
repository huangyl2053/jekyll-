/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HihokenshaDaichoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleDate 異動日;
    private static RString 枝番;

    @BeforeClass
    public static void setUpClass() {
        //TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
        異動日 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
        枝番 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_枝番;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            HihokenshaDaichoIdentifier sut = new HihokenshaDaichoIdentifier(被保険者番号, 異動日, 枝番);
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }
}
