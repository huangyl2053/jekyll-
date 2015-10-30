/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5591GogitaiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5593GogitaiWariateIinJohoEntityGenerator.DEFAULT_合議体有効期間開始年月日;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5593GogitaiWariateIinJohoEntityGenerator.DEFAULT_合議体番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Ignore;

/**
 * {@link DbT5591GogitaiJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT5591GogitaiJohoDacTest extends DbeTestDacBase {

    private static final int キー_01 = 1;
    private static final int キー_02 = 2;
    private static final int キー_03 = 3;
    private static DbT5591GogitaiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5591GogitaiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_合議体有効期間開始年月日);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_合議体有効期間開始年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 合議体有効期間開始年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_合議体番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5591GogitaiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5591GogitaiJohoEntity insertedRecord = sut.selectByKey(
                    キー_03,
                    DEFAULT_合議体有効期間開始年月日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 合議体情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_合議体有効期間開始年月日);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_合議体有効期間開始年月日);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 合議体情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 合議体情報エンティティを渡すと_insertは_合議体情報を追加する() {
            TestSupport.insert(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日);

            assertThat(sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日);
        }

        @Test
        public void 合議体情報エンティティを渡すと_updateは_合議体情報を更新する() {
            DbT5591GogitaiJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日);
            updateRecord.setGogitaiYukoKikanShuryoYMD(new FlexibleDate("201510"));

            sut.save(updateRecord);

            DbT5591GogitaiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日);

            assertThat(updateRecord.getGogitaiYukoKikanShuryoYMD(), is(updatedRecord.getGogitaiYukoKikanShuryoYMD()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日);
        }

        @Test
        public void 合議体情報エンティティを渡すと_deleteは_合議体情報を削除する() {
            DbT5591GogitaiJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                int 合議体番号,
                FlexibleDate 合議体有効期間開始年月日) {
            DbT5591GogitaiJohoEntity entity = DbT5591GogitaiJohoEntityGenerator.createDbT5591GogitaiJohoEntity();
            entity.setGogitaiNo(合議体番号);
            entity.setGogitaiYukoKikanKaishiYMD(合議体有効期間開始年月日);
            sut.save(entity);
        }
    }
}
