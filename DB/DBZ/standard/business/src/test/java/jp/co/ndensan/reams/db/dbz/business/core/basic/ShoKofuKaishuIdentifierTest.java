/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7037ShoKofuKaishuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShoKofuKaishuIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShoKofuKaishuIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static RString 交付証種類;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_被保険者番号;
        交付証種類 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付証種類;
        履歴番号 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            ShoKofuKaishuIdentifier sut = new ShoKofuKaishuIdentifier(被保険者番号, 交付証種類, 履歴番号);
            assertThat(sut, is(serializable()));
        }
    }
}
