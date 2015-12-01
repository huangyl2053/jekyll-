///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbz.service.core.basic;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaSchedule;
//import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
//import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5221NinteichosaScheduleEntityGenerator;
//import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5221NinteichosaScheduleDac;
//import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
//import jp.co.ndensan.reams.uz.uza.biz.Code;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.nullValue;
//import static org.junit.Assert.assertThat;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.experimental.runners.Enclosed;
//import org.junit.runner.RunWith;
//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
///**
// * {link NinteichosaScheduleManager}のテストクラスです。
// */
//@Ignore
//@RunWith(Enclosed.class)
//public class NinteichosaScheduleManagerTest {
//
//    private static DbT5221NinteichosaScheduleDac dac;
//    private static NinteichosaScheduleManager sut;
//
//    @BeforeClass
//    public static void test() {
//        dac = mock(DbT5221NinteichosaScheduleDac.class);
//        sut = new NinteichosaScheduleManager(dac);
//    }
//
//    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
//    public static class get認定調査スケジュール情報 extends DbzTestBase {
//
//        FlexibleDate 認定調査予定年月日 = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定年月日;
//        RString 認定調査予定開始時間 = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定開始時間;
//        RString 認定調査予定終了時間 = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定終了時間;
//        Code 認定調査時間枠 = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査時間枠;
//        RString 認定調査委託先コード = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査委託先コード;
//        RString 認定調査員コード = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査員コード;
//
//        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
//        @Test(expected = NullPointerException.class)
//        public void 引数の認定調査予定年月日にnullを指定した場合_NullPointerExceptionが発生する() {
//            sut.get認定調査スケジュール情報(null, 認定調査予定開始時間, 認定調査予定終了時間, 認定調査時間枠, 認定調査委託先コード, 認定調査員コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 引数の認定調査予定開始時間にnullを指定した場合_NullPointerExceptionが発生する() {
//            sut.get認定調査スケジュール情報(認定調査予定年月日, null, 認定調査予定終了時間, 認定調査時間枠, 認定調査委託先コード, 認定調査員コード);
//        }
//
//        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
//        @Test
//        public void 検索結果がnullの場合() {
//            when(dac.selectByKey(any(FlexibleDate.class), any(RString.class), any(RString.class), any(Code.class), any(RString.class), any(RString.class))).thenReturn(null);
//            NinteichosaSchedule result = sut.get認定調査スケジュール情報(認定調査予定年月日, 認定調査予定開始時間, 認定調査予定終了時間, 認定調査時間枠, 認定調査委託先コード, 認定調査員コード);
//
//            assertThat(result, is(nullValue()));
//        }
//
//        @Test
//        public void 検索結果が存在する場合() {
//            DbT5221NinteichosaScheduleEntity entity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//            when(dac.selectByKey(any(FlexibleDate.class), any(RString.class), any(RString.class), any(Code.class), any(RString.class), any(RString.class))).thenReturn(entity);
//            NinteichosaSchedule result = sut.get認定調査スケジュール情報(認定調査予定年月日, 認定調査予定開始時間, 認定調査予定終了時間, 認定調査時間枠, 認定調査委託先コード, 認定調査員コード);
//
//            assertThat(result.get認定調査予定年月日(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定年月日));
//        }
//    }
//
//    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
//    public static class get認定調査スケジュール情報一覧 extends DbzTestBase {
//
//        @Test
//        public void 検索結果が空の場合() {
//            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);
//
//            List<NinteichosaSchedule> result = sut.get認定調査スケジュール情報一覧();
//
//            assertThat(result.isEmpty(), is(true));
//        }
//
//        @Test
//        public void 検索結果が存在する場合() {
//            List<DbT5221NinteichosaScheduleEntity> entityList = Arrays.asList(DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity());
//            when(dac.selectAll()).thenReturn(entityList);
//
//            List<NinteichosaSchedule> result = sut.get認定調査スケジュール情報一覧();
//
//            assertThat(result.size(), is(1));
//            assertThat(result.get(0).get認定調査予定年月日(), is(DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定年月日));
//        }
//    }
//
//    public static class save認定調査スケジュール情報 extends DbzTestBase {
//
//        @Test
//        public void insertに成功するとtrueが返る() {
//            when(dac.save(any(DbT5221NinteichosaScheduleEntity.class))).thenReturn(1);
//
//            DbT5221NinteichosaScheduleEntity entity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//            NinteichosaSchedule 認定調査スケジュール情報 = new NinteichosaSchedule(entity);
//
//            assertThat(sut.save認定調査スケジュール情報(認定調査スケジュール情報), is(true));
//        }
//
//        @Test
//        public void insertに失敗するとfalseが返る() {
//            when(dac.save(any(DbT5221NinteichosaScheduleEntity.class))).thenReturn(0);
//
//            DbT5221NinteichosaScheduleEntity entity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//            NinteichosaSchedule 認定調査スケジュール情報 = new NinteichosaSchedule(entity);
//
//            assertThat(sut.save認定調査スケジュール情報(認定調査スケジュール情報), is(false));
//        }
//
//        @Test
//        public void updateに成功するとtrueが返る() {
//            when(dac.save(any(DbT5221NinteichosaScheduleEntity.class))).thenReturn(1);
//
//            DbT5221NinteichosaScheduleEntity entity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//            entity.initializeMd5();
//            NinteichosaSchedule 認定調査スケジュール情報 = new NinteichosaSchedule(entity);
//            認定調査スケジュール情報 = 認定調査スケジュール情報.createBuilderForEdit().set認定調査予定開始時間(new RString("認定調査予定開始時間を変更")).build();
//
//            assertThat(sut.save認定調査スケジュール情報(認定調査スケジュール情報), is(true));
//        }
//
//        @Test
//        public void updateに失敗するとfalseが返る() {
//            when(dac.save(any(DbT5221NinteichosaScheduleEntity.class))).thenReturn(0);
//
//            DbT5221NinteichosaScheduleEntity entity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//            entity.initializeMd5();
//            NinteichosaSchedule 認定調査スケジュール情報 = new NinteichosaSchedule(entity);
//            認定調査スケジュール情報 = 認定調査スケジュール情報.createBuilderForEdit().set認定調査予定開始時間(new RString("認定調査予定開始時間を変更")).build();
//
//            assertThat(sut.save認定調査スケジュール情報(認定調査スケジュール情報), is(false));
//        }
//
//        @Test
//        public void deleteに成功するとtrueが返る() {
//            when(dac.save(any(DbT5221NinteichosaScheduleEntity.class))).thenReturn(1);
//
//            DbT5221NinteichosaScheduleEntity entity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//            entity.initializeMd5();
//            NinteichosaSchedule 認定調査スケジュール情報 = new NinteichosaSchedule(entity);
//            認定調査スケジュール情報 = 認定調査スケジュール情報.deleted();
//
//            assertThat(sut.save認定調査スケジュール情報(認定調査スケジュール情報), is(true));
//        }
//
//        @Test
//        public void deleteに失敗するとfalseが返る() {
//            when(dac.save(any(DbT5221NinteichosaScheduleEntity.class))).thenReturn(0);
//
//            DbT5221NinteichosaScheduleEntity entity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//            entity.initializeMd5();
//            NinteichosaSchedule 認定調査スケジュール情報 = new NinteichosaSchedule(entity);
//            認定調査スケジュール情報 = 認定調査スケジュール情報.deleted();
//
//            assertThat(sut.save認定調査スケジュール情報(認定調査スケジュール情報), is(false));
//        }
//
//        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
//            DbT5221NinteichosaScheduleEntity entity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//            entity.initializeMd5();
//            NinteichosaSchedule 認定調査スケジュール情報 = new NinteichosaSchedule(entity);
//
//            assertThat(sut.save認定調査スケジュール情報(認定調査スケジュール情報), is(false));
//        }
//    }
//}
