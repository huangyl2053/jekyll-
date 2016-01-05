/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5202NinteichosahyoGaikyoChosaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosahyoGaikyoChosaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoGaikyoChosaBuilderTest extends DbzTestBase {

    private static DbT5202NinteichosahyoGaikyoChosaEntity NinteichosahyoGaikyoChosaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査依頼履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static NinteichosahyoGaikyoChosaBuilder sut;
        private static NinteichosahyoGaikyoChosa business;

        @Before
        public void setUp() {
            NinteichosahyoGaikyoChosaEntity = new DbT5202NinteichosahyoGaikyoChosaEntity();

            business = new NinteichosahyoGaikyoChosa(NinteichosahyoGaikyoChosaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の認定調査依頼履歴番号は_設定した値と同じ認定調査依頼履歴番号を返す() {
            business = sut.set認定調査依頼履歴番号(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査依頼履歴番号).build();
            assertThat(business.get認定調査依頼履歴番号(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査依頼履歴番号));
        }

        @Test
        public void 戻り値の厚労省IF識別コードは_設定した値と同じ厚労省IF識別コードを返す() {
            business = sut.set厚労省IF識別コード(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_厚労省IF識別コード).build();
            assertThat(business.get厚労省IF識別コード(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_厚労省IF識別コード));
        }

        @Test
        public void 戻り値の認定調査依頼区分コードは_設定した値と同じ認定調査依頼区分コードを返す() {
            business = sut.set認定調査依頼区分コード(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査依頼区分コード).build();
            assertThat(business.get認定調査依頼区分コード(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査依頼区分コード));
        }

        @Test
        public void 戻り値の認定調査回数は_設定した値と同じ認定調査回数を返す() {
            business = sut.set認定調査回数(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査回数).build();
            assertThat(business.get認定調査回数(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査回数));
        }

        @Test
        public void 戻り値の認定調査実施年月日は_設定した値と同じ認定調査実施年月日を返す() {
            business = sut.set認定調査実施年月日(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査実施年月日).build();
            assertThat(business.get認定調査実施年月日(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査実施年月日));
        }

        @Test
        public void 戻り値の認定調査受領年月日は_設定した値と同じ認定調査受領年月日を返す() {
            business = sut.set認定調査受領年月日(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査受領年月日).build();
            assertThat(business.get認定調査受領年月日(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査受領年月日));
        }

        @Test
        public void 戻り値の調査委託区分コードは_設定した値と同じ調査委託区分コードを返す() {
            business = sut.set調査委託区分コード(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_調査委託区分コード).build();
            assertThat(business.get調査委託区分コード(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_調査委託区分コード));
        }

        @Test
        public void 戻り値の認定調査区分コードは_設定した値と同じ認定調査区分コードを返す() {
            business = sut.set認定調査区分コード(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査区分コード).build();
            assertThat(business.get認定調査区分コード(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査区分コード));
        }

        @Test
        public void 戻り値の認定調査委託先コードは_設定した値と同じ認定調査委託先コードを返す() {
            business = sut.set認定調査委託先コード(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査委託先コード).build();
            assertThat(business.get認定調査委託先コード(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査委託先コード));
        }

        @Test
        public void 戻り値の認定調査員コードは_設定した値と同じ認定調査員コードを返す() {
            business = sut.set認定調査員コード(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査員コード).build();
            assertThat(business.get認定調査員コード(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査員コード));
        }

        @Test
        public void 戻り値の認定調査実施場所コードは_設定した値と同じ認定調査実施場所コードを返す() {
            business = sut.set認定調査実施場所コード(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査実施場所コード).build();
            assertThat(business.get認定調査実施場所コード(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査実施場所コード));
        }

        @Test
        public void 戻り値の認定調査実施場所名称は_設定した値と同じ認定調査実施場所名称を返す() {
            business = sut.set認定調査実施場所名称(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査実施場所名称).build();
            assertThat(business.get認定調査実施場所名称(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査実施場所名称));
        }

        @Test
        public void 戻り値の実施場所イメージ共有ファイルIDは_設定した値と同じ実施場所イメージ共有ファイルIDを返す() {
            business = sut.set実施場所イメージ共有ファイルID(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_実施場所イメージ共有ファイルID).build();
            assertThat(business.get実施場所イメージ共有ファイルID(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_実施場所イメージ共有ファイルID));
        }

//        @Test
//        public void 戻り値の認定調査_現在の状況コードは_設定した値と同じ認定調査_現在の状況コードを返す() {
//            business = sut.set認定調査_現在の状況コード(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査_現在の状況コード).build();
//            assertThat(business.get認定調査_現在の状況コード(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査_現在の状況コード));
//        }
        @Test
        public void 戻り値の認定調査_サービス区分コードは_設定した値と同じ認定調査_サービス区分コードを返す() {
            business = sut.set認定調査_サービス区分コード(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査_サービス区分コード).build();
            assertThat(business.get認定調査_サービス区分コード(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査_サービス区分コード));
        }

        @Test
        public void 戻り値の利用施設名は_設定した値と同じ利用施設名を返す() {
            business = sut.set利用施設名(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設名).build();
            assertThat(business.get利用施設名(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設名));
        }

        @Test
        public void 戻り値の利用施設住所は_設定した値と同じ利用施設住所を返す() {
            business = sut.set利用施設住所(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設住所).build();
            assertThat(business.get利用施設住所(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設住所));
        }

        @Test
        public void 戻り値の利用施設電話番号は_設定した値と同じ利用施設電話番号を返す() {
            business = sut.set利用施設電話番号(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設電話番号).build();
            assertThat(business.get利用施設電話番号(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設電話番号));
        }

        @Test
        public void 戻り値の利用施設郵便番号は_設定した値と同じ利用施設郵便番号を返す() {
            business = sut.set利用施設郵便番号(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設郵便番号).build();
            assertThat(business.get利用施設郵便番号(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設郵便番号));
        }

        @Test
        public void 戻り値の利用施設名イメージ共有ファイルIDは_設定した値と同じ利用施設名イメージ共有ファイルIDを返す() {
            business = sut.set利用施設名イメージ共有ファイルID(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設名イメージ共有ファイルID).build();
            assertThat(business.get利用施設名イメージ共有ファイルID(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設名イメージ共有ファイルID));
        }

        @Test
        public void 戻り値の利用施設住所イメージ共有ファイルIDは_設定した値と同じ利用施設住所イメージ共有ファイルIDを返す() {
            business = sut.set利用施設住所イメージ共有ファイルID(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設住所イメージ共有ファイルID).build();
            assertThat(business.get利用施設住所イメージ共有ファイルID(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設住所イメージ共有ファイルID));
        }

        @Test
        public void 戻り値の利用施設電話番号イメージ共有ファイルIDは_設定した値と同じ利用施設電話番号イメージ共有ファイルIDを返す() {
            business = sut.set利用施設電話番号イメージ共有ファイルID(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設電話番号イメージ共有ファイルID).build();
            assertThat(business.get利用施設電話番号イメージ共有ファイルID(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_利用施設電話番号イメージ共有ファイルID));
        }

        @Test
        public void 戻り値の特記は_設定した値と同じ特記を返す() {
            business = sut.set特記(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_特記).build();
            assertThat(business.get特記(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_特記));
        }

        @Test
        public void 戻り値の特記イメージ共有ファイルIDは_設定した値と同じ特記イメージ共有ファイルIDを返す() {
            business = sut.set特記イメージ共有ファイルID(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_特記イメージ共有ファイルID).build();
            assertThat(business.get特記イメージ共有ファイルID(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_特記イメージ共有ファイルID));
        }

        @Test
        public void 戻り値の認定調査特記事項受付年月日は_設定した値と同じ認定調査特記事項受付年月日を返す() {
            business = sut.set認定調査特記事項受付年月日(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査特記事項受付年月日).build();
            assertThat(business.get認定調査特記事項受付年月日(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査特記事項受付年月日));
        }

        @Test
        public void 戻り値の認定調査特記事項受領年月日は_設定した値と同じ認定調査特記事項受領年月日を返す() {
            business = sut.set認定調査特記事項受領年月日(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査特記事項受領年月日).build();
            assertThat(business.get認定調査特記事項受領年月日(), is(DbT5202NinteichosahyoGaikyoChosaEntityGenerator.DEFAULT_認定調査特記事項受領年月日));
        }

    }
}
