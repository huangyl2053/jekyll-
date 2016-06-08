/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5593GogitaiWariateIinJohoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5593GogitaiWariateIinJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5593GogitaiWariateIinJohoEntityGenerator.DEFAULT_介護認定審査会委員コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5593GogitaiWariateIinJohoEntityGenerator.DEFAULT_合議体有効期間開始年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5593GogitaiWariateIinJohoEntityGenerator.DEFAULT_合議体番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link DbT5593GogitaiWariateIinJohoDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT5593GogitaiWariateIinJohoDacTest extends DbeTestDacBase {

    private static final int キー_01 = 1;
    private static final int キー_02 = 2;
    private static final int キー_03 = 3;
    private static DbT5593GogitaiWariateIinJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5593GogitaiWariateIinJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード);
        }

        @Test(expected = NullPointerException.class)
        public void 合議体有効期間開始年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_合議体番号,
                    null,
                    DEFAULT_介護認定審査会委員コード);
        }

        @Test(expected = NullPointerException.class)
        public void 介護認定審査会委員コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5593GogitaiWariateIinJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5593GogitaiWariateIinJohoEntity insertedRecord = sut.selectByKey(
                    キー_03,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 合議体割当委員情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 合議体割当委員情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 合議体割当委員情報エンティティを渡すと_insertは_合議体割当委員情報を追加する() {
            TestSupport.insert(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード);

            assertThat(sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード);
        }

        @Test
        public void 合議体割当委員情報エンティティを渡すと_updateは_合議体割当委員情報を更新する() {
            DbT5593GogitaiWariateIinJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード);
            updateRecord.setGogitaiYukoKikanShuryoYMD(new FlexibleDate("201510"));

            sut.save(updateRecord);

            DbT5593GogitaiWariateIinJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード);

            assertThat(updateRecord.getGogitaiYukoKikanShuryoYMD(), is(updatedRecord.getGogitaiYukoKikanShuryoYMD()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード);
        }

        @Test
        public void 合議体割当委員情報エンティティを渡すと_deleteは_合議体割当委員情報を削除する() {
            DbT5593GogitaiWariateIinJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_合議体番号,
                    DEFAULT_合議体有効期間開始年月日,
                    DEFAULT_介護認定審査会委員コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                int 合議体番号,
                FlexibleDate 合議体有効期間開始年月日,
                RString 介護認定審査会委員コード) {
            DbT5593GogitaiWariateIinJohoEntity entity = DbT5593GogitaiWariateIinJohoEntityGenerator.createDbT5593GogitaiWariateIinJohoEntity();
            entity.setGogitaiNo(合議体番号);
            entity.setGogitaiYukoKikanKaishiYMD(合議体有効期間開始年月日);
            entity.setShinsakaiIinCode(介護認定審査会委員コード);
            sut.save(entity);
        }
    }
}
