/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
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
 * {@link DbT3074KogakuGassanShikyuFushikyuKetteiDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT3074KogakuGassanShikyuFushikyuKetteiDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3074KogakuGassanShikyuFushikyuKetteiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3074KogakuGassanShikyuFushikyuKetteiDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 対象年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 支給申請書整理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3074KogakuGassanShikyuFushikyuKetteiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3074KogakuGassanShikyuFushikyuKetteiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 高額合算支給不支給決定が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 高額合算支給不支給決定が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 高額合算支給不支給決定エンティティを渡すと_insertは_高額合算支給不支給決定を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 高額合算支給不支給決定エンティティを渡すと_updateは_高額合算支給不支給決定を更新する() {
            DbT3074KogakuGassanShikyuFushikyuKetteiEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
            updateRecord.setFushikyuRiyu(new RString("test1"));

            sut.save(updateRecord);

            DbT3074KogakuGassanShikyuFushikyuKetteiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getFushikyuRiyu(), is(updatedRecord.getFushikyuRiyu()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 高額合算支給不支給決定エンティティを渡すと_deleteは_高額合算支給不支給決定を削除する() {
            DbT3074KogakuGassanShikyuFushikyuKetteiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年度,
                    DEFAULT_保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                FlexibleYear 対象年度,
                HokenshaNo 保険者番号,
                RString 支給申請書整理番号,
                Decimal 履歴番号) {
            DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity = DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator.createDbT3074KogakuGassanShikyuFushikyuKetteiEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setTaishoNendo(対象年度);
            entity.setHokenshaNo(保険者番号);
            entity.setShikyuSeiriNo(支給申請書整理番号);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
