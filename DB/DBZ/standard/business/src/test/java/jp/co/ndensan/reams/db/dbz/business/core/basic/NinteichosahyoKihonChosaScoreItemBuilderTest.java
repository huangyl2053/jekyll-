/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5212NinteichosahyoKihonChosaScoreItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosahyoKihonChosaScoreItemBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoKihonChosaScoreItemBuilderTest extends DbzTestBase {

    private static DbT5212NinteichosahyoKihonChosaScoreItemEntity NinteichosahyoKihonChosaScoreItemEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 要介護認定調査履歴番号;
    private static int 連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_申請書管理番号;
        要介護認定調査履歴番号 = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_要介護認定調査履歴番号;
        連番 = DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_連番;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static NinteichosahyoKihonChosaScoreItemBuilder sut;
        private static NinteichosahyoKihonChosaScoreItem business;

        @Before
        public void setUp() {
            NinteichosahyoKihonChosaScoreItemEntity = new DbT5212NinteichosahyoKihonChosaScoreItemEntity();

            business = new NinteichosahyoKihonChosaScoreItem(NinteichosahyoKihonChosaScoreItemEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の要介護認定調査履歴番号は_設定した値と同じ要介護認定調査履歴番号を返す() {
            business = sut.set要介護認定調査履歴番号(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_要介護認定調査履歴番号).build();
            assertThat(business.get要介護認定調査履歴番号(), is(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_要介護認定調査履歴番号));
        }

        @Test
        public void 戻り値の連番は_設定した値と同じ連番を返す() {
            business = sut.set連番(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_連番).build();
            assertThat(business.get連番(), is(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_連番));
        }

        @Test
        public void 戻り値の厚労省IF識別コードは_設定した値と同じ厚労省IF識別コードを返す() {
            business = sut.set厚労省IF識別コード(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_厚労省IF識別コード).build();
            assertThat(business.get厚労省IF識別コード(), is(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_厚労省IF識別コード));
        }

        @Test
        public void 戻り値の素点項目は_設定した値と同じ素点項目を返す() {
            business = sut.set素点項目(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_素点項目).build();
            assertThat(business.get素点項目(), is(DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator.DEFAULT_素点項目));
        }

    }
}
