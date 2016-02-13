/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5303ShujiiIkenshoKinyuItemEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShujiiIkenshoKinyuItemBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoKinyuItemBuilderTest extends DbzTestBase {

    private static DbT5303ShujiiIkenshoKinyuItemEntity ShujiiIkenshoKinyuItemEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 主治医意見書作成依頼履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_申請書管理番号;
        主治医意見書作成依頼履歴番号 = DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShujiiIkenshoKinyuItemBuilder sut;
        private static ShujiiIkenshoKinyuItem business;

        @Before
        public void setUp() {
            ShujiiIkenshoKinyuItemEntity = new DbT5303ShujiiIkenshoKinyuItemEntity();

            business = new ShujiiIkenshoKinyuItem(ShujiiIkenshoKinyuItemEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の主治医意見書作成依頼履歴番号は_設定した値と同じ主治医意見書作成依頼履歴番号を返す() {
            business = sut.set主治医意見書作成依頼履歴番号(DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号).build();
            assertThat(business.get主治医意見書作成依頼履歴番号(), is(DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号));
        }

        @Test
        public void 戻り値の連番は_設定した値と同じ連番を返す() {
            business = sut.set連番(DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_連番).build();
            assertThat(business.get連番(), is(DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_連番));
        }

        @Test
        public void 戻り値の厚労省IF識別コードは_設定した値と同じ厚労省IF識別コードを返す() {
            business = sut.set厚労省IF識別コード(DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_厚労省IF識別コード).build();
            assertThat(business.get厚労省IF識別コード(), is(DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_厚労省IF識別コード));
        }

        @Test
        public void 戻り値の記入項目は_設定した値と同じ記入項目を返す() {
            business = sut.set記入項目(DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_記入項目).build();
            assertThat(business.get記入項目(), is(DbT5303ShujiiIkenshoKinyuItemEntityGenerator.DEFAULT_記入項目));
        }

    }
}
