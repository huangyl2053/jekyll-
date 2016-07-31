/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1008IryohokenKanyuJokyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IryohokenKanyuJokyoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IryohokenKanyuJokyoIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード;
        履歴番号 = DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            IryohokenKanyuJokyoIdentifier sut = new IryohokenKanyuJokyoIdentifier(識別コード, 履歴番号);
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }
}
