/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5302ShujiiIkenshoJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShujiiIkenshoJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoJohoBuilderTest extends DbzTestBase {

    private static DbT5302ShujiiIkenshoJohoEntity ShujiiIkenshoJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShujiiIkenshoJohoBuilder sut;
        private static ShujiiIkenshoJoho business;

        @Before
        public void setUp() {
            ShujiiIkenshoJohoEntity = new DbT5302ShujiiIkenshoJohoEntity();

            business = new ShujiiIkenshoJoho(ShujiiIkenshoJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の主治医意見書作成依頼履歴番号は_設定した値と同じ主治医意見書作成依頼履歴番号を返す() {
            business = sut.set主治医意見書作成依頼履歴番号(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号).build();
            assertThat(business.get主治医意見書作成依頼履歴番号(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号));
        }

        @Test
        public void 戻り値の厚労省IF識別コードは_設定した値と同じ厚労省IF識別コードを返す() {
            business = sut.set厚労省IF識別コード(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_厚労省IF識別コード).build();
            assertThat(business.get厚労省IF識別コード(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_厚労省IF識別コード));
        }

        @Test
        public void 戻り値の主治医意見書依頼区分は_設定した値と同じ主治医意見書依頼区分を返す() {
            business = sut.set主治医意見書依頼区分(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主治医意見書依頼区分).build();
            assertThat(business.get主治医意見書依頼区分(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主治医意見書依頼区分));
        }

        @Test
        public void 戻り値の主治医医療機関コードは_設定した値と同じ主治医医療機関コードを返す() {
            business = sut.set主治医医療機関コード(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主治医医療機関コード).build();
            assertThat(business.get主治医医療機関コード(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主治医医療機関コード));
        }

        @Test
        public void 戻り値の主治医コードは_設定した値と同じ主治医コードを返す() {
            business = sut.set主治医コード(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主治医コード).build();
            assertThat(business.get主治医コード(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主治医コード));
        }

        @Test
        public void 戻り値の主治医意見書受領年月日は_設定した値と同じ主治医意見書受領年月日を返す() {
            business = sut.set主治医意見書受領年月日(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主治医意見書受領年月日).build();
            assertThat(business.get主治医意見書受領年月日(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主治医意見書受領年月日));
        }

        @Test
        public void 戻り値の主治医意見書記入年月日は_設定した値と同じ主治医意見書記入年月日を返す() {
            business = sut.set主治医意見書記入年月日(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主治医意見書記入年月日).build();
            assertThat(business.get主治医意見書記入年月日(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主治医意見書記入年月日));
        }

        @Test
        public void 戻り値の意見書作成回数区分は_設定した値と同じ意見書作成回数区分を返す() {
            business = sut.set意見書作成回数区分(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_意見書作成回数区分).build();
            assertThat(business.get意見書作成回数区分(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_意見書作成回数区分));
        }

        @Test
        public void 戻り値の在宅／施設区分は_設定した値と同じ在宅

        ／施設区分を返す() {
            business = sut.set在宅
            ／施設区分(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_在宅／施設区分
            ).build();
            assertThat(business.get在宅
            ／施設区分()
            , is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_在宅／施設区分


        ));
        }

        @Test
        public void 戻り値の意見書同意フラグは_設定した値と同じ意見書同意フラグを返す() {
            business = sut.set意見書同意フラグ(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_意見書同意フラグ).build();
            assertThat(business.get意見書同意フラグ(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_意見書同意フラグ));
        }

        @Test
        public void 戻り値の最終診療日は_設定した値と同じ最終診療日を返す() {
            business = sut.set最終診療日(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_最終診療日).build();
            assertThat(business.get最終診療日(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_最終診療日));
        }

        @Test
        public void 戻り値の他科受診の有無は_設定した値と同じ他科受診の有無を返す() {
            business = sut.set他科受診の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_他科受診の有無).build();
            assertThat(business.get他科受診の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_他科受診の有無));
        }

        @Test
        public void 戻り値の内科受診の有無は_設定した値と同じ内科受診の有無を返す() {
            business = sut.set内科受診の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_内科受診の有無).build();
            assertThat(business.get内科受診の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_内科受診の有無));
        }

        @Test
        public void 戻り値の精神科受診の有無は_設定した値と同じ精神科受診の有無を返す() {
            business = sut.set精神科受診の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_精神科受診の有無).build();
            assertThat(business.get精神科受診の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_精神科受診の有無));
        }

        @Test
        public void 戻り値の外科受診の有無は_設定した値と同じ外科受診の有無を返す() {
            business = sut.set外科受診の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_外科受診の有無).build();
            assertThat(business.get外科受診の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_外科受診の有無));
        }

        @Test
        public void 戻り値の整形外科受診の有無は_設定した値と同じ整形外科受診の有無を返す() {
            business = sut.set整形外科受診の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_整形外科受診の有無).build();
            assertThat(business.get整形外科受診の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_整形外科受診の有無));
        }

        @Test
        public void 戻り値の脳神経外科の有無は_設定した値と同じ脳神経外科の有無を返す() {
            business = sut.set脳神経外科の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_脳神経外科の有無).build();
            assertThat(business.get脳神経外科の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_脳神経外科の有無));
        }

        @Test
        public void 戻り値の皮膚科受診の有無は_設定した値と同じ皮膚科受診の有無を返す() {
            business = sut.set皮膚科受診の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_皮膚科受診の有無).build();
            assertThat(business.get皮膚科受診の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_皮膚科受診の有無));
        }

        @Test
        public void 戻り値の泌尿器科受診の有無は_設定した値と同じ泌尿器科受診の有無を返す() {
            business = sut.set泌尿器科受診の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_泌尿器科受診の有無).build();
            assertThat(business.get泌尿器科受診の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_泌尿器科受診の有無));
        }

        @Test
        public void 戻り値の婦人科受診の有無は_設定した値と同じ婦人科受診の有無を返す() {
            business = sut.set婦人科受診の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_婦人科受診の有無).build();
            assertThat(business.get婦人科受診の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_婦人科受診の有無));
        }

        @Test
        public void 戻り値の耳鼻咽喉科受診の有無は_設定した値と同じ耳鼻咽喉科受診の有無を返す() {
            business = sut.set耳鼻咽喉科受診の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_耳鼻咽喉科受診の有無).build();
            assertThat(business.get耳鼻咽喉科受診の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_耳鼻咽喉科受診の有無));
        }

        @Test
        public void 戻り値のリハビリテーション科受診の有無は_設定した値と同じリハビリテーション科受診の有無を返す() {
            business = sut.setリハビリテーション科受診の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_リハビリテーション科受診の有無).build();
            assertThat(business.getリハビリテーション科受診の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_リハビリテーション科受診の有無));
        }

        @Test
        public void 戻り値の歯科受診の有無は_設定した値と同じ歯科受診の有無を返す() {
            business = sut.set歯科受診の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_歯科受診の有無).build();
            assertThat(business.get歯科受診の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_歯科受診の有無));
        }

        @Test
        public void 戻り値の眼科の有無は_設定した値と同じ眼科の有無を返す() {
            business = sut.set眼科の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_眼科の有無).build();
            assertThat(business.get眼科の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_眼科の有無));
        }

        @Test
        public void 戻り値のその他受診科の有無は_設定した値と同じその他受診科の有無を返す() {
            business = sut.setその他受診科の有無(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_その他受診科の有無).build();
            assertThat(business.getその他受診科の有無(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_その他受診科の有無));
        }

        @Test
        public void 戻り値のその他受診科名は_設定した値と同じその他受診科名を返す() {
            business = sut.setその他受診科名(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_その他受診科名).build();
            assertThat(business.getその他受診科名(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_その他受診科名));
        }

        @Test
        public void 戻り値の意見書メモは_設定した値と同じ意見書メモを返す() {
            business = sut.set意見書メモ(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_意見書メモ).build();
            assertThat(business.get意見書メモ(), is(DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_意見書メモ));
        }

    }
}
