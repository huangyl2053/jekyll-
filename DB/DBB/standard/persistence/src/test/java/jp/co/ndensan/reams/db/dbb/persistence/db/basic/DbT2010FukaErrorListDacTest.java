/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2010FukaErrorListEntityGenerator;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2010FukaErrorListEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT2010FukaErrorListDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT2010FukaErrorListDacTest extends DbbTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT2010FukaErrorListDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2010FukaErrorListDac.class);
    }

    public static class selectByKeyのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void サブ業務コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 内部帳票IDがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2010FukaErrorListEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2010FukaErrorListEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbbTestDacBase {

        @Test
        public void 賦課エラー一覧が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 賦課エラー一覧が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbbTestDacBase {

        @Test
        public void 賦課エラー一覧エンティティを渡すと_insertは_賦課エラー一覧を追加する() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);

            assertThat(sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
        }

        @Test
        public void 賦課エラー一覧エンティティを渡すと_updateは_賦課エラー一覧を更新する() {
            DbT2010FukaErrorListEntity updateRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
            updateRecord.setFukaNendo(new FlexibleYear("2001"));

            sut.save(updateRecord);

            DbT2010FukaErrorListEntity updatedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);

            assertThat(updateRecord.getFukaNendo(), is(updatedRecord.getFukaNendo()));
        }
    }

    public static class deleteのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
        }

        @Test
        public void 賦課エラー一覧エンティティを渡すと_deleteは_賦課エラー一覧を削除する() {
            DbT2010FukaErrorListEntity deletedEntity = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_内部帳票ID,
                    DEFAULT_賦課年度,
                    DEFAULT_通知書番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                SubGyomuCode サブ業務コード,
                RString 内部帳票ID,
                FlexibleYear 賦課年度,
                TsuchishoNo 通知書番号) {
            DbT2010FukaErrorListEntity entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            entity.setSubGyomuCode(サブ業務コード);
            entity.setInternalReportId(内部帳票ID);
            entity.setFukaNendo(賦課年度);
            entity.setTsuchishoNo(通知書番号);
            sut.save(entity);
        }
    }
}
