/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosahyoServiceJokyoFlagIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoServiceJokyoFlagIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;
    private static int 連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.DEFAULT_認定調査依頼履歴番号;
        連番 = DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator.DEFAULT_連番;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            NinteichosahyoServiceJokyoFlagIdentifier sut = new NinteichosahyoServiceJokyoFlagIdentifier(申請書管理番号, 認定調査依頼履歴番号, 連番);
            assertThat(sut, is(serializable()));
        }
    }
}
