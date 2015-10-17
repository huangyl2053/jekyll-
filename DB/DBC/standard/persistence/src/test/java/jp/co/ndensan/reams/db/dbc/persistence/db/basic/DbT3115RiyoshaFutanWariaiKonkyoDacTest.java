/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT3115RiyoshaFutanWariaiKonkyoDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT3115RiyoshaFutanWariaiKonkyoDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3115RiyoshaFutanWariaiKonkyoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3115RiyoshaFutanWariaiKonkyoDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
        }

        @Test(expected = NullPointerException.class)
        public void 年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
        }

        @Test(expected = NullPointerException.class)
        public void 枝番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
        }

        @Test(expected = NullPointerException.class)
        public void 世帯員被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3115RiyoshaFutanWariaiKonkyoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3115RiyoshaFutanWariaiKonkyoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 利用者負担割合世帯員が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 利用者負担割合世帯員が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 利用者負担割合世帯員エンティティを渡すと_insertは_利用者負担割合世帯員を追加する() {
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);

            assertThat(sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
        }

        @Test
        public void 利用者負担割合世帯員エンティティを渡すと_updateは_利用者負担割合世帯員を更新する() {
            DbT3115RiyoshaFutanWariaiKonkyoEntity updateRecord = sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
            updateRecord.setSetaiinHihokenshaNo(new HihokenshaNo("1562"));

            sut.save(updateRecord);

            DbT3115RiyoshaFutanWariaiKonkyoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);

            assertThat(updateRecord.getSetaiinHihokenshaNo(), is(updatedRecord.getSetaiinHihokenshaNo()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
        }

        @Test
        public void 利用者負担割合世帯員エンティティを渡すと_deleteは_利用者負担割合世帯員を削除する() {
            DbT3115RiyoshaFutanWariaiKonkyoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_年度,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番号,
                    DEFAULT_世帯員被保険者番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYear 年度,
                HihokenshaNo 被保険者番号,
                Decimal 履歴番号,
                Decimal 枝番号,
                HihokenshaNo 世帯員被保険者番号) {
            DbT3115RiyoshaFutanWariaiKonkyoEntity entity = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.createDbT3115RiyoshaFutanWariaiKonkyoEntity();
            entity.setNendo(年度);
            entity.setHihokenshaNo(被保険者番号);
            entity.setRirekiNo(履歴番号);
            entity.setEdaNo(枝番号);
            entity.setSetaiinHihokenshaNo(世帯員被保険者番号);
            sut.save(entity);
        }
    }
}
