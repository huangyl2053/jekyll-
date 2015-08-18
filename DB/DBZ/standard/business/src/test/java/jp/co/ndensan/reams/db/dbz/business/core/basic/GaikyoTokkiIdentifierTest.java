/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5206GaikyoTokkiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GaikyoTokkiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GaikyoTokkiIdentifierTest extends DbzTestBase {

    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;

    @BeforeClass
    public static void setUpClass() {
        申請書管理番号 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_認定調査依頼履歴番号;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            GaikyoTokkiIdentifier sut = new GaikyoTokkiIdentifier(申請書管理番号, 認定調査依頼履歴番号);
            assertThat(sut, is(serializable()));
        }
    }
}
