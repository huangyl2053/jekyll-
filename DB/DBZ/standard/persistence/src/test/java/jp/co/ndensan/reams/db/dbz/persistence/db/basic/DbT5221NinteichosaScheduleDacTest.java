///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbz.persistence.db.basic;
//
//import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5221NinteichosaScheduleDac;
//import java.util.Collections;
//import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
//import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5221NinteichosaScheduleEntityGenerator;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定年月日;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定終了時間;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定開始時間;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査員コード;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査委託先コード;
//import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査時間枠;
//import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
//import jp.co.ndensan.reams.uz.uza.biz.Code;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
//import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.CoreMatchers.notNullValue;
//import static org.hamcrest.CoreMatchers.nullValue;
//import static org.junit.Assert.assertThat;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.experimental.runners.Enclosed;
//import org.junit.runner.RunWith;
//
///**
// * {@link DbT5221NinteichosaScheduleDac}のテストです。
// */
//@Ignore
//@RunWith(Enclosed.class)
//public class DbT5221NinteichosaScheduleDacTest extends DbzTestDacBase {
//
//    private static final RString キー_01 = new RString("02");
//    private static final RString キー_02 = new RString("02");
//    private static final RString キー_03 = new RString("03");
//    private static DbT5221NinteichosaScheduleDac sut;
//
//    @BeforeClass
//    public static void setUpClass() {
//        sut = InstanceProvider.create(DbT5221NinteichosaScheduleDac.class);
//    }
//
//    public static class selectByKeyのテスト extends DbzTestDacBase {
//
//        @Before
//        public void setUp() {
//            TestSupport.insert(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//            TestSupport.insert(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 認定調査予定年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 認定調査予定開始時間がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 認定調査予定終了時間がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 認定調査時間枠がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 認定調査委託先コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 認定調査員コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
//            sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//        }
//
//        @Test
//        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
//            DbT5221NinteichosaScheduleEntity insertedRecord = sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//            assertThat(insertedRecord, is(notNullValue()));
//        }
//
//        @Test
//        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
//            DbT5221NinteichosaScheduleEntity insertedRecord = sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//            assertThat(insertedRecord, is(nullValue()));
//        }
//    }
//
//    public static class selectAllのテスト extends DbzTestDacBase {
//
//        @Test
//        public void 認定調査スケジュール情報が存在する場合_selectAllは_全件を返す() {
//            TestSupport.insert(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//            TestSupport.insert(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//            assertThat(sut.selectAll().size(), is(2));
//        }
//
//        @Test
//        public void 認定調査スケジュール情報が存在しない場合_selectAllは_空のリストを返す() {
//            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
//        }
//    }
//
//    public static class insertのテスト extends DbzTestDacBase {
//
//        @Test
//        public void 認定調査スケジュール情報エンティティを渡すと_insertは_認定調査スケジュール情報を追加する() {
//            TestSupport.insert(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//
//            assertThat(sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード), is(notNullValue()));
//        }
//    }
//
//    public static class updateのテスト extends DbzTestDacBase {
//
//        @Before
//        public void setUp() {
//            TestSupport.insert(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//        }
//
//        @Test
//        public void 認定調査スケジュール情報エンティティを渡すと_updateは_認定調査スケジュール情報を更新する() {
//            DbT5221NinteichosaScheduleEntity updateRecord = sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//            // TODO  主キー以外の項目を変更してください
//            // updateRecord.set変更したい項目(75);
//
//            sut.save(updateRecord);
//
//            DbT5221NinteichosaScheduleEntity updatedRecord = sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//
//            // TODO  主キー以外の項目を変更してください
//            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
//        }
//    }
//
//    public static class deleteのテスト extends DbzTestDacBase {
//
//        @Before
//        public void setUp() {
//            TestSupport.insert(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//        }
//
//        @Test
//        public void 認定調査スケジュール情報エンティティを渡すと_deleteは_認定調査スケジュール情報を削除する() {
//            DbT5221NinteichosaScheduleEntity deletedEntity = sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード);
//            deletedEntity.setState(EntityDataState.Deleted);
//
//            sut.save(deletedEntity);
//
//            assertThat(sut.selectByKey(
//                    DEFAULT_認定調査予定年月日,
//                    DEFAULT_認定調査予定開始時間,
//                    DEFAULT_認定調査予定終了時間,
//                    DEFAULT_認定調査時間枠,
//                    DEFAULT_認定調査委託先コード,
//                    DEFAULT_認定調査員コード), is(nullValue()));
//        }
//    }
//
//    private static class TestSupport {
//
//        public static void insert(
//                FlexibleDate 認定調査予定年月日,
//                RString 認定調査予定開始時間,
//                RString 認定調査予定終了時間,
//                Code 認定調査時間枠,
//                RString 認定調査委託先コード,
//                RString 認定調査員コード) {
//            DbT5221NinteichosaScheduleEntity entity = DbT5221NinteichosaScheduleEntityGenerator.createDbT5221NinteichosaScheduleEntity();
//            entity.setNinteiChosaYoteiYMD(認定調査予定年月日);
//            entity.setNinteiChosaYoteiKaishiTime(認定調査予定開始時間);
//            entity.setNinteiChosaYoteiShuryoTime(認定調査予定終了時間);
//            entity.setNinteiChosaJikanWaku(認定調査時間枠);
//            entity.setNinteichosaItakusakiCode(認定調査委託先コード);
//            entity.setNinteiChosainNo(認定調査員コード);
//            sut.save(entity);
//        }
//    }
//}
