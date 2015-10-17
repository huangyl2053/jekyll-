/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5191RenkeiyoDataSofuKirokuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RenkeiyoDataSofuKirokuIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RenkeiyoDataSofuKirokuIdentifierTest extends DbeTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static FlexibleDate 資料作成日;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_申請書管理番号;
        資料作成日 = DbT5191RenkeiyoDataSofuKirokuEntityGenerator.DEFAULT_資料作成日;
    }

    public static class シリアライズテスト extends DbeTestBase {

        @Test
        public void シリアライズできる() {
            RenkeiyoDataSofuKirokuIdentifier sut = new RenkeiyoDataSofuKirokuIdentifier(申請書管理番号, 資料作成日);
            assertThat(sut, is(serializable()));
        }
    }
}
