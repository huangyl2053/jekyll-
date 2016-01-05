/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FufukuMoshitateBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FufukuMoshitateBuilderTest extends DbzTestBase {
//
//    private static DbT7001FufukuMoshitateEntity FufukuMoshitateEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
////TODO 主キー型と変数名を置換してください
////TODO 主キーの数が足りない場合、追加してください。
//    private static ShoKisaiHokenshaNo 主キー名1;
//    private static ShikibetsuCode 主キー名2;
//    private static HihokenshaNo 主キー名3;
//    private static FlexibleDate 主キー名4;
//
//    @BeforeClass
//    public static void setUpClass() {
////TODO 主キー値を適切な値に置換してください
//        主キー名1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//        主キー名2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//    }
//
//    public static class getterSetterTest extends DbzTestBase {
//
//        private static FufukuMoshitateBuilder sut;
//        private static FufukuMoshitate business;
//
//        @Before
//        public void setUp() {
//            FufukuMoshitateEntity = new DbT7001FufukuMoshitateEntity();
//            FufukuMoshitateEntity.setShoKisaiHokenshaNo(主キー名1);
//            FufukuMoshitateEntity.setShikibetsuCode(主キー名2);
//
//            business = new FufukuMoshitate(FufukuMoshitateEntity);
//
//            sut = business.createBuilderForEdit();
//        }
////TODO Key項目のテストメソッドは削除して下さい。
//
//        @Test
//        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
//            business = sut.set証記載保険者番号(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号).build();
//            assertThat(business.get証記載保険者番号(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号));
//        }
//
//        @Test
//        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
//            business = sut.set識別コード(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード).build();
//            assertThat(business.get識別コード(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード));
//        }
//
//        @Test
//        public void 戻り値の原処分被保険者番号は_設定した値と同じ原処分被保険者番号を返す() {
//            business = sut.set原処分被保険者番号(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者番号).build();
//            assertThat(business.get原処分被保険者番号(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者番号));
//        }
//
//        @Test
//        public void 戻り値の審査請求届出日は_設定した値と同じ審査請求届出日を返す() {
//            business = sut.set審査請求届出日(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求届出日).build();
//            assertThat(business.get審査請求届出日(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求届出日));
//        }
//
//        @Test
//        public void 戻り値の原処分被保険者郵便番号は_設定した値と同じ原処分被保険者郵便番号を返す() {
//            business = sut.set原処分被保険者郵便番号(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者郵便番号).build();
//            assertThat(business.get原処分被保険者郵便番号(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者郵便番号));
//        }
//
//        @Test
//        public void 戻り値の原処分被保険者住所は_設定した値と同じ原処分被保険者住所を返す() {
//            business = sut.set原処分被保険者住所(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者住所).build();
//            assertThat(business.get原処分被保険者住所(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者住所));
//        }
//
//        @Test
//        public void 戻り値の原処分被保険者氏名は_設定した値と同じ原処分被保険者氏名を返す() {
//            business = sut.set原処分被保険者氏名(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者氏名).build();
//            assertThat(business.get原処分被保険者氏名(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者氏名));
//        }
//
//        @Test
//        public void 戻り値の原処分被保険者電話番号は_設定した値と同じ原処分被保険者電話番号を返す() {
//            business = sut.set原処分被保険者電話番号(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者電話番号).build();
//            assertThat(business.get原処分被保険者電話番号(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者電話番号));
//        }
//
//        @Test
//        public void 戻り値の原処分被保険者生年月日は_設定した値と同じ原処分被保険者生年月日を返す() {
//            business = sut.set原処分被保険者生年月日(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者生年月日).build();
//            assertThat(business.get原処分被保険者生年月日(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_原処分被保険者生年月日));
//        }
//
//        @Test
//        public void 戻り値の審査請求人郵便番号は_設定した値と同じ審査請求人郵便番号を返す() {
//            business = sut.set審査請求人郵便番号(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求人郵便番号).build();
//            assertThat(business.get審査請求人郵便番号(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求人郵便番号));
//        }
//
//        @Test
//        public void 戻り値の審査請求人住所は_設定した値と同じ審査請求人住所を返す() {
//            business = sut.set審査請求人住所(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求人住所).build();
//            assertThat(business.get審査請求人住所(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求人住所));
//        }
//
//        @Test
//        public void 戻り値の審査請求人氏名は_設定した値と同じ審査請求人氏名を返す() {
//            business = sut.set審査請求人氏名(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求人氏名).build();
//            assertThat(business.get審査請求人氏名(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求人氏名));
//        }
//
//        @Test
//        public void 戻り値の審査請求人電話番号は_設定した値と同じ審査請求人電話番号を返す() {
//            business = sut.set審査請求人電話番号(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求人電話番号).build();
//            assertThat(business.get審査請求人電話番号(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求人電話番号));
//        }
//
//        @Test
//        public void 戻り値の被保険者との関係コードは_設定した値と同じ被保険者との関係コードを返す() {
//            business = sut.set被保険者との関係コード(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_被保険者との関係コード).build();
//            assertThat(business.get被保険者との関係コード(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_被保険者との関係コード));
//        }
//
//        @Test
//        public void 戻り値の代理人郵便番号は_設定した値と同じ代理人郵便番号を返す() {
//            business = sut.set代理人郵便番号(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_代理人郵便番号).build();
//            assertThat(business.get代理人郵便番号(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_代理人郵便番号));
//        }
//
//        @Test
//        public void 戻り値の代理人住所は_設定した値と同じ代理人住所を返す() {
//            business = sut.set代理人住所(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_代理人住所).build();
//            assertThat(business.get代理人住所(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_代理人住所));
//        }
//
//        @Test
//        public void 戻り値の代理人氏名は_設定した値と同じ代理人氏名を返す() {
//            business = sut.set代理人氏名(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_代理人氏名).build();
//            assertThat(business.get代理人氏名(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_代理人氏名));
//        }
//
//        @Test
//        public void 戻り値の代理人電話番号は_設定した値と同じ代理人電話番号を返す() {
//            business = sut.set代理人電話番号(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_代理人電話番号).build();
//            assertThat(business.get代理人電話番号(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_代理人電話番号));
//        }
//
//        @Test
//        public void 戻り値の処分庁は_設定した値と同じ処分庁を返す() {
//            business = sut.set処分庁(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_処分庁).build();
//            assertThat(business.get処分庁(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_処分庁));
//        }
//
//        @Test
//        public void 戻り値の処分日は_設定した値と同じ処分日を返す() {
//            business = sut.set処分日(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_処分日).build();
//            assertThat(business.get処分日(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_処分日));
//        }
//
//        @Test
//        public void 戻り値の処分種類コードは_設定した値と同じ処分種類コードを返す() {
//            business = sut.set処分種類コード(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_処分種類コード).build();
//            assertThat(business.get処分種類コード(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_処分種類コード));
//        }
//
//        @Test
//        public void 戻り値の処分があったことを知った日は_設定した値と同じ処分があったことを知った日を返す() {
//            business = sut.set処分があったことを知った日(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_処分があったことを知った日).build();
//            assertThat(business.get処分があったことを知った日(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_処分があったことを知った日));
//        }
//
//        @Test
//        public void 戻り値の審査請求の理由は_設定した値と同じ審査請求の理由を返す() {
//            business = sut.set審査請求の理由(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求の理由).build();
//            assertThat(business.get審査請求の理由(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求の理由));
//        }
//
//        @Test
//        public void 戻り値の処分庁教示の有無及び教示の内容は_設定した値と同じ処分庁教示の有無及び教示の内容を返す() {
//            business = sut.set処分庁教示の有無及び教示の内容(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_処分庁教示の有無及び教示の内容).build();
//            assertThat(business.get処分庁教示の有無及び教示の内容(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_処分庁教示の有無及び教示の内容));
//        }
//
//        @Test
//        public void 戻り値の添付書類等は_設定した値と同じ添付書類等を返す() {
//            business = sut.set添付書類等(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_添付書類等).build();
//            assertThat(business.is添付書類等(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_添付書類等));
//        }
//
//        @Test
//        public void 戻り値の審査請求取下日は_設定した値と同じ審査請求取下日を返す() {
//            business = sut.set審査請求取下日(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求取下日).build();
//            assertThat(business.get審査請求取下日(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_審査請求取下日));
//        }
//
//        @Test
//        public void 戻り値の弁明書登録フラグは_設定した値と同じ弁明書登録フラグを返す() {
//            business = sut.set弁明書登録フラグ(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_弁明書登録フラグ).build();
//            assertThat(business.is弁明書登録フラグ(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_弁明書登録フラグ));
//        }
//
//        @Test
//        public void 戻り値の弁明書作成日は_設定した値と同じ弁明書作成日を返す() {
//            business = sut.set弁明書作成日(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_弁明書作成日).build();
//            assertThat(business.get弁明書作成日(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_弁明書作成日));
//        }
//
//        @Test
//        public void 戻り値の裁決日は_設定した値と同じ裁決日を返す() {
//            business = sut.set裁決日(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_裁決日).build();
//            assertThat(business.get裁決日(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_裁決日));
//        }
//
//        @Test
//        public void 戻り値の裁決結果は_設定した値と同じ裁決結果を返す() {
//            business = sut.set裁決結果(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_裁決結果).build();
//            assertThat(business.get裁決結果(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_裁決結果));
//        }
//
//        @Test
//        public void 戻り値の裁決理由は_設定した値と同じ裁決理由を返す() {
//            business = sut.set裁決理由(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_裁決理由).build();
//            assertThat(business.get裁決理由(), is(DbT7001FufukuMoshitateEntityGenerator.DEFAULT_裁決理由));
//        }
//
//    }
}
