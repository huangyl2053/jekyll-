/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5206GaikyoTokkiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GaikyoTokkiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GaikyoTokkiBuilderTest extends DbzTestBase {

    private static DbT5206GaikyoTokkiEntity gaikyoTokkiEntity;
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;
    private static RString 概況特記テキストイメージ区分;

    @BeforeClass
    public static void setUpClass() {
        申請書管理番号 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_認定調査依頼履歴番号;
        概況特記テキストイメージ区分 = DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記テキストイメージ区分;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static GaikyoTokkiBuilder sut;
        private static GaikyoTokki business;

        @Before
        public void setUp() {
            gaikyoTokkiEntity = new DbT5206GaikyoTokkiEntity();

            business = new GaikyoTokki(gaikyoTokkiEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の認定調査依頼履歴番号は_設定した値と同じ認定調査依頼履歴番号を返す() {
            business = sut.set認定調査依頼履歴番号(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_認定調査依頼履歴番号).build();
            assertThat(business.get認定調査依頼履歴番号(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_認定調査依頼履歴番号));
        }

        @Test
        public void 戻り値の概況特記テキストイメージ区分は_設定した値と同じ概況特記テキストイメージ区分を返す() {
            business = sut.set概況特記テキストイメージ区分(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記テキストイメージ区分).build();
            assertThat(business.get概況特記テキストイメージ区分(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記テキストイメージ区分));
        }

        @Test
        public void 戻り値の住宅改修は_設定した値と同じ住宅改修を返す() {
            business = sut.set住宅改修(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_住宅改修).build();
            assertThat(business.get住宅改修(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_住宅改修));
        }

        @Test
        public void 戻り値の市町村特別給付サービス種類名は_設定した値と市町村特別給付サービス種類名を返す() {
            business = sut.set市町村特別給付サービス種類名(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_市町村特別給付サービス種類名).build();
            assertThat(business.get市町村特別給付サービス種類名(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_市町村特別給付サービス種類名));
        }

        @Test
        public void 戻り値の介護保険給付以外の在宅サービス種類名は_設定した値と介護保険給付以外の在宅サービス種類名を返す() {
            business = sut.set介護保険給付以外の在宅サービス種類名(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_介護保険給付以外の在宅サービス種類名).build();
            assertThat(business.get介護保険給付以外の在宅サービス種類名(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_介護保険給付以外の在宅サービス種類名));
        }

        @Test
        public void 戻り値の概況特記事項_主訴は_設定した値と同じ概況特記事項_主訴を返す() {
            business = sut.set概況特記事項_主訴(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記事項_主訴).build();
            assertThat(business.get概況特記事項_主訴(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記事項_主訴));
        }

//        @Test
//        public void 戻り値の概況特記_主訴_イメージ共有ファイルIDは_設定した値と同じ概況特記_主訴_イメージ共有ファイルIDを返す() {
//            business = sut.set概況特記_主訴_イメージ共有ファイルID(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_主訴_イメージ共有ファイルID).build();
//            assertThat(business.get概況特記_主訴_イメージ共有ファイルID(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_主訴_イメージ共有ファイルID));
//        }
//
//        @Test
//        public void 戻り値の概況特記_主訴_マスキングイメージ共有ファイルIDは_設定した値と同じ概況特記_主訴_マスキングイメージ共有ファイルIDを返す() {
//            business = sut.set概況特記_主訴_マスキングイメージ共有ファイルID(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_主訴_マスキングイメージ共有ファイルID).build();
//            assertThat(business.get概況特記_主訴_マスキングイメージ共有ファイルID(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_主訴_マスキングイメージ共有ファイルID));
//        }

        @Test
        public void 戻り値の概況特記事項_家族状況は_設定した値と同じ概況特記事項_家族状況を返す() {
            business = sut.set概況特記事項_家族状況(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記事項_家族状況).build();
            assertThat(business.get概況特記事項_家族状況(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記事項_家族状況));
        }

//        @Test
//        public void 戻り値の概況特記_家族状況_イメージ共有ファイルIDは_設定した値と同じ概況特記_家族状況_イメージ共有ファイルIDを返す() {
//            business = sut.set概況特記_家族状況_イメージ共有ファイルID(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_家族状況_イメージ共有ファイルID).build();
//            assertThat(business.get概況特記_家族状況_イメージ共有ファイルID(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_家族状況_イメージ共有ファイルID));
//        }
//
//        @Test
//        public void 戻り値の概況特記_家族状況_マスキングイメージ共有ファイルIDは_設定した値と同じ概況特記_家族状況_マスキングイメージ共有ファイルIDを返す() {
//            business = sut.set概況特記_家族状況_マスキングイメージ共有ファイルID(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_家族状況_マスキングイメージ共有ファイルID).build();
//            assertThat(business.get概況特記_家族状況_マスキングイメージ共有ファイルID(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_家族状況_マスキングイメージ共有ファイルID));
//        }

        @Test
        public void 戻り値の概況特記事項_居住環境は_設定した値と同じ概況特記事項_居住環境を返す() {
            business = sut.set概況特記事項_居住環境(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記事項_居住環境).build();
            assertThat(business.get概況特記事項_居住環境(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記事項_居住環境));
        }

//        @Test
//        public void 戻り値の概況特記_居住環境_イメージ共有ファイルIDは_設定した値と同じ概況特記_居住環境_イメージ共有ファイルIDを返す() {
//            business = sut.set概況特記_居住環境_イメージ共有ファイルID(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_居住環境_イメージ共有ファイルID).build();
//            assertThat(business.get概況特記_居住環境_イメージ共有ファイルID(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_居住環境_イメージ共有ファイルID));
//        }
//
//        @Test
//        public void 戻り値の概況特記_居住環境_マスキングイメージ共有ファイルIDは_設定した値と同じ概況特記_居住環境_マスキングイメージ共有ファイルIDを返す() {
//            business = sut.set概況特記_居住環境_マスキングイメージ共有ファイルID(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_居住環境_マスキングイメージ共有ファイルID).build();
//            assertThat(business.get概況特記_居住環境_マスキングイメージ共有ファイルID(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_居住環境_マスキングイメージ共有ファイルID));
//        }

        @Test
        public void 戻り値の概況特記事項_機器_器械は_設定した値と同じ概況特記事項_機器_器械を返す() {
            business = sut.set概況特記事項_機器_器械(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記事項_機器_器械).build();
            assertThat(business.get概況特記事項_機器_器械(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記事項_機器_器械));
        }

//        @Test
//        public void 戻り値の概況特記_機器_器械_イメージ共有ファイルIDは_設定した値と同じ概況特記_機器_器械_イメージ共有ファイルIDを返す() {
//            business = sut.set概況特記_機器_器械_イメージ共有ファイルID(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_機器_器械_イメージ共有ファイルID).build();
//            assertThat(business.get概況特記_機器_器械_イメージ共有ファイルID(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_機器_器械_イメージ共有ファイルID));
//        }
//
//        @Test
//        public void 戻り値の概況特記_機器_器械_マスキングイメージ共有ファイルIDは_設定した値と同じ概況特記_機器_器械_マスキングイメージ共有ファイルIDを返す() {
//            business = sut.set概況特記_機器_器械_マスキングイメージ共有ファイルID(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_機器_器械_マスキングイメージ共有ファイルID).build();
//            assertThat(business.get概況特記_機器_器械_マスキングイメージ共有ファイルID(), is(DbT5206GaikyoTokkiEntityGenerator.DEFAULT_概況特記_機器_器械_マスキングイメージ共有ファイルID));
//        }

    }
}
