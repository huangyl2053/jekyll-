///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbz.business.core.basic;
//
//import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
//import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5221NinteichosaScheduleEntityGenerator;
//import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
//import jp.co.ndensan.reams.uz.uza.biz.Code;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.experimental.runners.Enclosed;
//import org.junit.runner.RunWith;
//
///**
// * {@link NinteichosaScheduleBuilder}のテストクラスです。
// */
//@RunWith(Enclosed.class)
//public class NinteichosaScheduleBuilderTest extends DbzTestBase {
//
//    private static DbT5221NinteichosaScheduleEntity NinteichosaScheduleEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
////TODO 主キー型と変数名を置換してください
////TODO 主キーの数が足りない場合、追加してください。
//    private static FlexibleDate 認定調査予定年月日;
//    private static RString 認定調査予定開始時間;
//    private static RString 認定調査予定終了時間;
//    private static Code 認定調査時間枠;
//    private static RString 認定調査委託先コード;
//    private static RString 認定調査員コード;
//
//    @BeforeClass
//    public static void setUpClass() {
////TODO 主キー値を適切な値に置換してください
//        認定調査予定年月日 = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定年月日;
//        認定調査予定開始時間 = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定開始時間;
//        認定調査予定終了時間 = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定終了時間;
//        認定調査時間枠 = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査時間枠;
//        認定調査委託先コード = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査委託先コード;
//        認定調査員コード = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査員コード;
//    }
//
//    public static class getterSetterTest extends DbzTestBase {
//
//        private static NinteichosaScheduleBuilder sut;
//        private static NinteichosaSchedule business;
//
//        @Before
//        public void setUp() {
//            NinteichosaScheduleEntity = new DbT5221NinteichosaScheduleEntity();
//
//            business = new NinteichosaSchedule(NinteichosaScheduleEntity);
//
//            sut = business.createBuilderForEdit();
//        }
////TODO Key項目のテストメソッドは削除して下さい。
//
//        @Test
//        public void 戻り値の認定調査予定年月日は_設定した値と同じ認定調査予定年月日を返す() {
//            business = sut.set認定調査予定年月日(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定年月日).build();
//            assertThat(business.get認定調査予定年月日(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定年月日));
//        }
//
//        @Test
//        public void 戻り値の認定調査予定開始時間は_設定した値と同じ認定調査予定開始時間を返す() {
//            business = sut.set認定調査予定開始時間(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定開始時間).build();
//            assertThat(business.get認定調査予定開始時間(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定開始時間));
//        }
//
//        @Test
//        public void 戻り値の認定調査予定終了時間は_設定した値と同じ認定調査予定終了時間を返す() {
//            business = sut.set認定調査予定終了時間(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定終了時間).build();
//            assertThat(business.get認定調査予定終了時間(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定終了時間));
//        }
//
//        @Test
//        public void 戻り値の認定調査時間枠は_設定した値と同じ認定調査時間枠を返す() {
//            business = sut.set認定調査時間枠(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査時間枠).build();
//            assertThat(business.get認定調査時間枠(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査時間枠));
//        }
//
//        @Test
//        public void 戻り値の調査地区コードは_設定した値と同じ調査地区コードを返す() {
//            business = sut.set調査地区コード(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_調査地区コード).build();
//            assertThat(business.get調査地区コード(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_調査地区コード));
//        }
//
//        @Test
//        public void 戻り値の認定調査委託先コードは_設定した値と同じ認定調査委託先コードを返す() {
//            business = sut.set認定調査委託先コード(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査委託先コード).build();
//            assertThat(business.get認定調査委託先コード(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査委託先コード));
//        }
//
//        @Test
//        public void 戻り値の認定調査員コードは_設定した値と同じ認定調査員コードを返す() {
//            business = sut.set認定調査員コード(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査員コード).build();
//            assertThat(business.get認定調査員コード(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査員コード));
//        }
//
//        @Test
//        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
//            business = sut.set市町村コード(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_市町村コード).build();
//            assertThat(business.get市町村コード(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_市町村コード));
//        }
//
//        @Test
//        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
//            business = sut.set申請書管理番号(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_申請書管理番号).build();
//            assertThat(business.get申請書管理番号(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_申請書管理番号));
//        }
//
//        @Test
//        public void 戻り値の予約状況は_設定した値と同じ予約状況を返す() {
//            business = sut.set予約状況(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_予約状況).build();
//            assertThat(business.get予約状況(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_予約状況));
//        }
//
//        @Test
//        public void 戻り値の予約可能フラグは_設定した値と同じ予約可能フラグを返す() {
//            business = sut.set予約可能フラグ(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_予約可能フラグ).build();
//            assertThat(business.is予約可能フラグ(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_予約可能フラグ));
//        }
//
//        @Test
//        public void 戻り値の備考は_設定した値と同じ備考を返す() {
//            business = sut.set備考(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_備考).build();
//            assertThat(business.get備考(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_備考));
//        }
//
//        @Test
//        public void 戻り値の場所は_設定した値と同じ場所を返す() {
//            business = sut.set場所(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_場所).build();
//            assertThat(business.get場所(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_場所));
//        }
//
//        @Test
//        public void 戻り値の駐車場は_設定した値と同じ駐車場を返す() {
//            business = sut.set駐車場(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_駐車場).build();
//            assertThat(business.get駐車場(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_駐車場));
//        }
//
//        @Test
//        public void 戻り値の立会人１は_設定した値と同じ立会人１を返す() {
//            business = sut.set立会人１(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_立会人１).build();
//            assertThat(business.get立会人１(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_立会人１));
//        }
//
//        @Test
//        public void 戻り値の連絡先１は_設定した値と同じ連絡先１を返す() {
//            business = sut.set連絡先１(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_連絡先１).build();
//            assertThat(business.get連絡先１(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_連絡先１));
//        }
//
//        @Test
//        public void 戻り値の立会人２は_設定した値と同じ立会人２を返す() {
//            business = sut.set立会人２(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_立会人２).build();
//            assertThat(business.get立会人２(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_立会人２));
//        }
//
//        @Test
//        public void 戻り値の連絡先２は_設定した値と同じ連絡先２を返す() {
//            business = sut.set連絡先２(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_連絡先２).build();
//            assertThat(business.get連絡先２(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_連絡先２));
//        }
//
//        @Test
//        public void 戻り値の対象者メモは_設定した値と同じ対象者メモを返す() {
//            business = sut.set対象者メモ(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_対象者メモ).build();
//            assertThat(business.get対象者メモ(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_対象者メモ));
//        }
//
//    }
//}
