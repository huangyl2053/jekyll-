///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbz.business.core.basic;
//
//import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
//import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
//import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5221NinteichosaScheduleEntityGenerator;
//import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
//import jp.co.ndensan.reams.uz.uza.biz.Code;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.not;
//import static org.junit.Assert.assertThat;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.experimental.runners.Enclosed;
//import org.junit.runner.RunWith;
//
///**
// * {@link NinteichosaSchedule}のテストクラスです。
// */
//@Ignore
//@RunWith(Enclosed.class)
//public class NinteichosaScheduleTest extends DbzTestBase {
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
//    public static class 主キーコンストラクタテスト extends DbzTestBase {
//
//        private static NinteichosaSchedule sut;
//
//        @BeforeClass
//        public static void setUpClass() {
//            NinteichosaScheduleEntity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//        }
//
////TODO 主キー名を置換してください
//        @Test(expected = NullPointerException.class)
//        public void 認定調査予定年月日がnullである場合に_NullPointerExceptionが発生する() {
//            sut = new NinteichosaSchedule(null, 認定調査予定開始時間, 認定調査予定終了時間, 認定調査時間枠, 認定調査委託先コード, 認定調査員コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 認定調査予定開始時間がnullである場合に_NullPointerExceptionが発生する() {
//            sut = new NinteichosaSchedule(認定調査予定年月日, null, 認定調査予定終了時間, 認定調査時間枠, 認定調査委託先コード, 認定調査員コード);
//        }
//
//        @Test
//        public void 指定したキーが保持するDbT5221NinteichosaScheduleEntityにセットされている() {
//            sut = new NinteichosaSchedule(認定調査予定年月日, 認定調査予定開始時間, 認定調査予定終了時間, 認定調査時間枠, 認定調査委託先コード, 認定調査員コード);
//            assertThat(sut.get認定調査予定年月日(), is(認定調査予定年月日));
//            assertThat(sut.get認定調査予定開始時間(), is(認定調査予定開始時間));
//        }
//
//        @Test
//        public void 指定したキーが保持するNinteichosaScheduleIdentifierにセットされている() {
//            sut = new NinteichosaSchedule(認定調査予定年月日, 認定調査予定開始時間, 認定調査予定終了時間, 認定調査時間枠, 認定調査委託先コード, 認定調査員コード);
//            assertThat(sut.identifier().get認定調査予定年月日(), is(認定調査予定年月日));
//            assertThat(sut.identifier().get認定調査予定開始時間(), is(認定調査予定開始時間));
//        }
//    }
//
//    public static class Entityコンストラクタテスト extends DbzTestBase {
//
//        private static NinteichosaSchedule sut;
//
//        @BeforeClass
//        public static void setUpClass() {
//            NinteichosaScheduleEntity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
//            sut = new NinteichosaSchedule(null);
//        }
//
//        @Test
//        public void 指定したDbT5221NinteichosaScheduleEntityのキー情報を識別子が持つ() {
//
//            sut = new NinteichosaSchedule(NinteichosaScheduleEntity);
//
//            assertThat(sut.identifier().get認定調査予定年月日(), is(認定調査予定年月日));
//            assertThat(sut.identifier().get認定調査予定開始時間(), is(認定調査予定開始時間));
//        }
//    }
//
//    public static class getterテスト extends DbzTestBase {
//
//        private static NinteichosaSchedule sut;
//
//        @BeforeClass
//        public static void setUpClass() {
//            NinteichosaScheduleEntity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//
//            sut = new NinteichosaSchedule(NinteichosaScheduleEntity);
//        }
//
//        @Test
//        public void get認定調査予定年月日は_entityが持つ認定調査予定年月日を返す() {
//            assertThat(sut.get認定調査予定年月日(), is(NinteichosaScheduleEntity.getNinteiChosaYoteiYMD()));
//        }
//
//        @Test
//        public void get認定調査予定開始時間は_entityが持つ認定調査予定開始時間を返す() {
//            assertThat(sut.get認定調査予定開始時間(), is(NinteichosaScheduleEntity.getNinteiChosaYoteiKaishiTime()));
//        }
//
//        @Test
//        public void get認定調査予定終了時間は_entityが持つ認定調査予定終了時間を返す() {
//            assertThat(sut.get認定調査予定終了時間(), is(NinteichosaScheduleEntity.getNinteiChosaYoteiShuryoTime()));
//        }
//
//        @Test
//        public void get認定調査時間枠は_entityが持つ認定調査時間枠を返す() {
//            assertThat(sut.get認定調査時間枠(), is(NinteichosaScheduleEntity.getNinteiChosaJikanWaku()));
//        }
//
//        @Test
//        public void get調査地区コードは_entityが持つ調査地区コードを返す() {
//            assertThat(sut.get調査地区コード(), is(NinteichosaScheduleEntity.getChosaChikuCode()));
//        }
//
//        @Test
//        public void get認定調査委託先コードは_entityが持つ認定調査委託先コードを返す() {
//            assertThat(sut.get認定調査委託先コード(), is(NinteichosaScheduleEntity.getNinteichosaItakusakiCode()));
//        }
//
//        @Test
//        public void get認定調査員コードは_entityが持つ認定調査員コードを返す() {
//            assertThat(sut.get認定調査員コード(), is(NinteichosaScheduleEntity.getNinteiChosainNo()));
//        }
//
//        @Test
//        public void get市町村コードは_entityが持つ市町村コードを返す() {
//            assertThat(sut.get市町村コード(), is(NinteichosaScheduleEntity.getShichosonCode()));
//        }
//
//        @Test
//        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
//            assertThat(sut.get申請書管理番号(), is(NinteichosaScheduleEntity.getShinseishoKanriNo()));
//        }
//
//        @Test
//        public void get予約状況は_entityが持つ予約状況を返す() {
//            assertThat(sut.get予約状況(), is(NinteichosaScheduleEntity.getYoyakuJokyo()));
//        }
//
//        @Test
//        public void is予約可能フラグは_entityが持つ予約可能フラグを返す() {
//            assertThat(sut.is予約可能フラグ(), is(NinteichosaScheduleEntity.getYoyakuKaoFlag()));
//        }
//
//        @Test
//        public void get備考は_entityが持つ備考を返す() {
//            assertThat(sut.get備考(), is(NinteichosaScheduleEntity.getBiko()));
//        }
//
//        @Test
//        public void get場所は_entityが持つ場所を返す() {
//            assertThat(sut.get場所(), is(NinteichosaScheduleEntity.getBasho()));
//        }
//
//        @Test
//        public void get駐車場は_entityが持つ駐車場を返す() {
//            assertThat(sut.get駐車場(), is(NinteichosaScheduleEntity.getChushajo()));
//        }
//
//        @Test
//        public void get立会人１は_entityが持つ立会人１を返す() {
//            assertThat(sut.get立会人１(), is(NinteichosaScheduleEntity.getTachiainin1()));
//        }
//
//        @Test
//        public void get連絡先１は_entityが持つ連絡先１を返す() {
//            assertThat(sut.get連絡先１(), is(NinteichosaScheduleEntity.getRenrakusaki1()));
//        }
//
//        @Test
//        public void get立会人２は_entityが持つ立会人２を返す() {
//            assertThat(sut.get立会人２(), is(NinteichosaScheduleEntity.getTachiainin2()));
//        }
//
//        @Test
//        public void get連絡先２は_entityが持つ連絡先２を返す() {
//            assertThat(sut.get連絡先２(), is(NinteichosaScheduleEntity.getRenrakusaki2()));
//        }
//
//        @Test
//        public void get対象者メモは_entityが持つ対象者メモを返す() {
//            assertThat(sut.get対象者メモ(), is(NinteichosaScheduleEntity.getTaishoshaMemo()));
//        }
//    }
//
//    public static class toEntityテスト extends DbzTestBase {
//
//        private static NinteichosaSchedule sut;
//
//        @BeforeClass
//        public static void setUpClass() {
//            NinteichosaScheduleEntity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//
//            sut = new NinteichosaSchedule(NinteichosaScheduleEntity);
//        }
//
//        @Test
//        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
//            assertThat(sut.toEntity(), not(NinteichosaScheduleEntity));
//        }
//    }
//
//    public static class SerializationProxyテスト extends DbzTestBase {
//
//        private static NinteichosaSchedule sut;
//
//        @BeforeClass
//        public static void setUpClass() {
//            NinteichosaScheduleEntity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//
//            sut = new NinteichosaSchedule(NinteichosaScheduleEntity);
//        }
//
//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
//        }
//    }
//
//    public static class deletedテスト extends DbzTestBase {
//
//        private static NinteichosaSchedule sut;
//        private static NinteichosaSchedule result;
//
//        @BeforeClass
//        public static void setUpClass() {
//            NinteichosaScheduleEntity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//
//        }
//
//        @Test
//        public void NinteichosaScheduleが保持するDbT5221NinteichosaScheduleEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosaScheduleが保持するDbT5221NinteichosaScheduleEntityのEntityDataStateがDeletedに指定されたNinteichosaScheduleが返る() {
//            sut = TestSupport.setStateNinteichosaSchedule(EntityDataState.Unchanged);
//            result = sut.deleted();
//            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
//        }
//
//        @Test
//        public void NinteichosaScheduleが保持するDbT5221NinteichosaScheduleEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosaScheduleが保持するDbT5221NinteichosaScheduleEntityのEntityDataStateがDeletedに指定されたNinteichosaScheduleが返る() {
//            sut = TestSupport.setStateNinteichosaSchedule(EntityDataState.Modified);
//            result = sut.deleted();
//            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
//        }
//
//        @Test
//        public void NinteichosaScheduleが保持するDbT5221NinteichosaScheduleEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosaScheduleが保持するDbT5221NinteichosaScheduleEntityのEntityDataStateがDeletedに指定されたNinteichosaScheduleが返る() {
//            sut = TestSupport.setStateNinteichosaSchedule(EntityDataState.Deleted);
//            result = sut.deleted();
//            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
//        }
//
//        @Test(expected = IllegalStateException.class)
//        public void NinteichosaScheduleが保持するDbT5221NinteichosaScheduleEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
//            sut = TestSupport.setStateNinteichosaSchedule(EntityDataState.Added);
//            result = sut.deleted();
//        }
//    }
//
//    private static class TestSupport {
//
//        public static NinteichosaSchedule setStateNinteichosaSchedule(EntityDataState parentState) {
//            NinteichosaScheduleEntity.setState(parentState);
//            return new NinteichosaSchedule(NinteichosaScheduleEntity);
//        }
//    }
//}
