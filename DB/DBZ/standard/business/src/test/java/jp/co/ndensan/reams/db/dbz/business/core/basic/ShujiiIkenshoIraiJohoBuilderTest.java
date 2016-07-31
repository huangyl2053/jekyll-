/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5301ShujiiIkenshoIraiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShujiiIkenshoIraiJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoIraiJohoBuilderTest extends DbzTestBase {

    private static DbT5301ShujiiIkenshoIraiJohoEntity ShujiiIkenshoIraiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 主治医意見書作成依頼履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_申請書管理番号;
        主治医意見書作成依頼履歴番号 = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShujiiIkenshoIraiJohoBuilder sut;
        private static ShujiiIkenshoIraiJoho business;

        @Before
        public void setUp() {
            ShujiiIkenshoIraiJohoEntity = new DbT5301ShujiiIkenshoIraiJohoEntity();

            business = new ShujiiIkenshoIraiJoho(ShujiiIkenshoIraiJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の厚労省IF識別コードは_設定した値と同じ厚労省IF識別コードを返す() {
            business = sut.set厚労省IF識別コード(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_厚労省IF識別コード).build();
            assertThat(business.get厚労省IF識別コード(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_厚労省IF識別コード));
        }

        @Test
        public void 戻り値の主治医医療機関コードは_設定した値と同じ主治医医療機関コードを返す() {
            business = sut.set主治医医療機関コード(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医医療機関コード).build();
            assertThat(business.get主治医医療機関コード(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医医療機関コード));
        }

        @Test
        public void 戻り値の主治医コードは_設定した値と同じ主治医コードを返す() {
            business = sut.set主治医コード(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医コード).build();
            assertThat(business.get主治医コード(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医コード));
        }

        @Test
        public void 戻り値の主治医意見書依頼区分は_設定した値と同じ主治医意見書依頼区分を返す() {
            business = sut.set主治医意見書依頼区分(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書依頼区分).build();
            assertThat(business.get主治医意見書依頼区分(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書依頼区分));
        }

        @Test
        public void 戻り値の主治医意見書作成回数は_設定した値と同じ主治医意見書作成回数を返す() {
            business = sut.set主治医意見書作成回数(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成回数).build();
            assertThat(business.get主治医意見書作成回数(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成回数));
        }

        @Test
        public void 戻り値の医師区分コードは_設定した値と同じ医師区分コードを返す() {
            business = sut.set医師区分コード(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_医師区分コード).build();
            assertThat(business.get医師区分コード(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_医師区分コード));
        }

        @Test
        public void 戻り値の主治医意見書作成依頼年月日は_設定した値と同じ主治医意見書作成依頼年月日を返す() {
            business = sut.set主治医意見書作成依頼年月日(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成依頼年月日).build();
            assertThat(business.get主治医意見書作成依頼年月日(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成依頼年月日));
        }

        @Test
        public void 戻り値の主治医意見書作成期限年月日は_設定した値と同じ主治医意見書作成期限年月日を返す() {
            business = sut.set主治医意見書作成期限年月日(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成期限年月日).build();
            assertThat(business.get主治医意見書作成期限年月日(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成期限年月日));
        }

        @Test
        public void 戻り値の依頼書出力年月日は_設定した値と同じ依頼書出力年月日を返す() {
            business = sut.set依頼書出力年月日(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_依頼書出力年月日).build();
            assertThat(business.get依頼書出力年月日(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_依頼書出力年月日));
        }

        @Test
        public void 戻り値の意見書出力年月日は_設定した値と同じ意見書出力年月日を返す() {
            business = sut.set意見書出力年月日(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_意見書出力年月日).build();
            assertThat(business.get意見書出力年月日(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_意見書出力年月日));
        }

        @Test
        public void 戻り値の請求書出力年月日は_設定した値と同じ請求書出力年月日を返す() {
            business = sut.set請求書出力年月日(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_請求書出力年月日).build();
            assertThat(business.get請求書出力年月日(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_請求書出力年月日));
        }

        @Test
        public void 戻り値の作成料請求区分は_設定した値と同じ作成料請求区分を返す() {
            business = sut.set作成料請求区分(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_作成料請求区分).build();
            assertThat(business.get作成料請求区分(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_作成料請求区分));
        }

        @Test
        public void 戻り値の主治医意見書作成督促年月日は_設定した値と同じ主治医意見書作成督促年月日を返す() {
            business = sut.set主治医意見書作成督促年月日(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成督促年月日).build();
            assertThat(business.get主治医意見書作成督促年月日(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成督促年月日));
        }

        @Test
        public void 戻り値の主治医意見書作成督促方法は_設定した値と同じ主治医意見書作成督促方法を返す() {
            business = sut.set主治医意見書作成督促方法(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成督促方法).build();
            assertThat(business.get主治医意見書作成督促方法(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成督促方法));
        }

        @Test
        public void 戻り値の主治医意見書作成督促回数は_設定した値と同じ主治医意見書作成督促回数を返す() {
            business = sut.set主治医意見書作成督促回数(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成督促回数).build();
            assertThat(business.get主治医意見書作成督促回数(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成督促回数));
        }

        @Test
        public void 戻り値の主治医意見書作成督促メモは_設定した値と同じ主治医意見書作成督促メモを返す() {
            business = sut.set主治医意見書作成督促メモ(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成督促メモ).build();
            assertThat(business.get主治医意見書作成督促メモ(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成督促メモ));
        }

        @Test
        public void 戻り値の認定情報提供希望フラグは_設定した値と同じ認定情報提供希望フラグを返す() {
            business = sut.set認定情報提供希望フラグ(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_認定情報提供希望フラグ).build();
            assertThat(business.is認定情報提供希望フラグ(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_認定情報提供希望フラグ));
        }

        @Test
        public void 戻り値の認定状況提供年月日は_設定した値と同じ認定状況提供年月日を返す() {
            business = sut.set認定状況提供年月日(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_認定状況提供年月日).build();
            assertThat(business.get認定状況提供年月日(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_認定状況提供年月日));
        }

        @Test
        public void 戻り値の論理削除フラグは_設定した値と同じ論理削除フラグを返す() {
            business = sut.set論理削除フラグ(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_論理削除フラグ).build();
            assertThat(business.is論理削除フラグ(), is(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_論理削除フラグ));
        }

    }
}
