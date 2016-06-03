/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3113RiyoshaFutanWariaiDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3113RiyoshaFutanWariaiEntityGenerator;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT3113RiyoshaFutanWariaiDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3113RiyoshaFutanWariaiDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3113RiyoshaFutanWariaiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3113RiyoshaFutanWariaiDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3113RiyoshaFutanWariaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3113RiyoshaFutanWariaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 利用者負担割合が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 利用者負担割合が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 利用者負担割合エンティティを渡すと_insertは_利用者負担割合を追加する() {
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 利用者負担割合エンティティを渡すと_updateは_利用者負担割合を更新する() {
            DbT3113RiyoshaFutanWariaiEntity updateRecord = sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            updateRecord.setKofuYMD(new FlexibleDate("201400110"));

            sut.save(updateRecord);

            DbT3113RiyoshaFutanWariaiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getKofuYMD(), is(updatedRecord.getKofuYMD()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 利用者負担割合エンティティを渡すと_deleteは_利用者負担割合を削除する() {
            DbT3113RiyoshaFutanWariaiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYear 年度,
                HihokenshaNo 被保険者番号,
                int 履歴番号) {
            DbT3113RiyoshaFutanWariaiEntity entity = DbT3113RiyoshaFutanWariaiEntityGenerator.createDbT3113RiyoshaFutanWariaiEntity();
            entity.setNendo(年度);
            entity.setHihokenshaNo(被保険者番号);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
