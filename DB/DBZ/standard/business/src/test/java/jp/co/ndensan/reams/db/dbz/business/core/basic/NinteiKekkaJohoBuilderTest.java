/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5102NinteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiKekkaJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiKekkaJohoBuilderTest extends DbzTestBase {

    private static DbT5102NinteiKekkaJohoEntity NinteiKekkaJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static NinteiKekkaJohoBuilder sut;
        private static NinteiKekkaJoho business;

        @Before
        public void setUp() {
            NinteiKekkaJohoEntity = new DbT5102NinteiKekkaJohoEntity();

            business = new NinteiKekkaJoho(NinteiKekkaJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5102NinteiKekkaJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

    }
}
