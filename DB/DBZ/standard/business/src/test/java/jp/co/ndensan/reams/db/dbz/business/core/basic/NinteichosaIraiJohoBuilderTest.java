/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5201NinteichosaIraiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosaIraiJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiJohoBuilderTest extends DbzTestBase {

    private static DbT5201NinteichosaIraiJohoEntity NinteichosaIraiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static NinteichosaIraiJohoBuilder sut;
        private static NinteichosaIraiJoho business;

        @Before
        public void setUp() {
            NinteichosaIraiJohoEntity = new DbT5201NinteichosaIraiJohoEntity();

            business = new NinteichosaIraiJoho(NinteichosaIraiJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の認定調査依頼履歴番号は_設定した値と同じ認定調査依頼履歴番号を返す() {
            business = sut.set認定調査依頼履歴番号(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査依頼履歴番号).build();
            assertThat(business.get認定調査依頼履歴番号(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査依頼履歴番号));
        }

        @Test
        public void 戻り値の厚労省IF識別コードは_設定した値と同じ厚労省IF識別コードを返す() {
            business = sut.set厚労省IF識別コード(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_厚労省IF識別コード).build();
            assertThat(business.get厚労省IF識別コード(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_厚労省IF識別コード));
        }

        @Test
        public void 戻り値の認定調査委託先コードは_設定した値と同じ認定調査委託先コードを返す() {
            business = sut.set認定調査委託先コード(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査委託先コード).build();
            assertThat(business.get認定調査委託先コード(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査委託先コード));
        }

        @Test
        public void 戻り値の認定調査員コードは_設定した値と同じ認定調査員コードを返す() {
            business = sut.set認定調査員コード(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査員コード).build();
            assertThat(business.get認定調査員コード(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査員コード));
        }

        @Test
        public void 戻り値の認定調査依頼区分コードは_設定した値と同じ認定調査依頼区分コードを返す() {
            business = sut.set認定調査依頼区分コード(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査依頼区分コード).build();
            assertThat(business.get認定調査依頼区分コード(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査依頼区分コード));
        }

        @Test
        public void 戻り値の認定調査回数は_設定した値と同じ認定調査回数を返す() {
            business = sut.set認定調査回数(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査回数).build();
            assertThat(business.get認定調査回数(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査回数));
        }

        @Test
        public void 戻り値の認定調査依頼年月日は_設定した値と同じ認定調査依頼年月日を返す() {
            business = sut.set認定調査依頼年月日(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査依頼年月日).build();
            assertThat(business.get認定調査依頼年月日(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査依頼年月日));
        }

        @Test
        public void 戻り値の認定調査期限年月日は_設定した値と同じ認定調査期限年月日を返す() {
            business = sut.set認定調査期限年月日(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査期限年月日).build();
            assertThat(business.get認定調査期限年月日(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査期限年月日));
        }

        @Test
        public void 戻り値の依頼書出力年月日は_設定した値と同じ依頼書出力年月日を返す() {
            business = sut.set依頼書出力年月日(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_依頼書出力年月日).build();
            assertThat(business.get依頼書出力年月日(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_依頼書出力年月日));
        }

        @Test
        public void 戻り値の調査票等出力年月日は_設定した値と同じ調査票等出力年月日を返す() {
            business = sut.set調査票等出力年月日(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_調査票等出力年月日).build();
            assertThat(business.get調査票等出力年月日(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_調査票等出力年月日));
        }

        @Test
        public void 戻り値のモバイルデータ出力済フラグは_設定した値と同じモバイルデータ出力済フラグを返す() {
            business = sut.setモバイルデータ出力済フラグ(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_モバイルデータ出力済フラグ).build();
            assertThat(business.getモバイルデータ出力済フラグ(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_モバイルデータ出力済フラグ));
        }

        @Test
        public void 戻り値の事前調査フラグは_設定した値と同じ事前調査フラグを返す() {
            business = sut.set事前調査フラグ(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_事前調査フラグ).build();
            assertThat(business.get事前調査フラグ(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_事前調査フラグ));
        }

        @Test
        public void 戻り値の認定調査督促年月日は_設定した値と同じ認定調査督促年月日を返す() {
            business = sut.set認定調査督促年月日(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査督促年月日).build();
            assertThat(business.get認定調査督促年月日(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査督促年月日));
        }

        @Test
        public void 戻り値の認定調査督促方法は_設定した値と同じ認定調査督促方法を返す() {
            business = sut.set認定調査督促方法(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査督促方法).build();
            assertThat(business.get認定調査督促方法(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査督促方法));
        }

        @Test
        public void 戻り値の認定調査督促回数は_設定した値と同じ認定調査督促回数を返す() {
            business = sut.set認定調査督促回数(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査督促回数).build();
            assertThat(business.get認定調査督促回数(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査督促回数));
        }

        @Test
        public void 戻り値の認定調査督促メモは_設定した値と同じ認定調査督促メモを返す() {
            business = sut.set認定調査督促メモ(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査督促メモ).build();
            assertThat(business.get認定調査督促メモ(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査督促メモ));
        }

        @Test
        public void 戻り値の論理削除フラグは_設定した値と同じ論理削除フラグを返す() {
            business = sut.set論理削除フラグ(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_論理削除フラグ).build();
            assertThat(business.get論理削除フラグ(), is(DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_論理削除フラグ));
        }

    }
}
