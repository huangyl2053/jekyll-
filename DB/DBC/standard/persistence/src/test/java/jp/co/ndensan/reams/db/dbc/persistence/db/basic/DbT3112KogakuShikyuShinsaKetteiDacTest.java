/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3112KogakuShikyuShinsaKetteiEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3112KogakuShikyuShinsaKetteiEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT3112KogakuShikyuShinsaKetteiDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT3112KogakuShikyuShinsaKetteiDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3112KogakuShikyuShinsaKetteiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3112KogakuShikyuShinsaKetteiDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 決定者受取年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void サービス提供年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3112KogakuShikyuShinsaKetteiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3112KogakuShikyuShinsaKetteiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 事業高額介護サービス費支給審査決定が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 事業高額介護サービス費支給審査決定が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 事業高額介護サービス費支給審査決定エンティティを渡すと_insertは_事業高額介護サービス費支給審査決定を追加する() {
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);

            assertThat(sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test
        public void 事業高額介護サービス費支給審査決定エンティティを渡すと_updateは_事業高額介護サービス費支給審査決定を更新する() {
            DbT3112KogakuShikyuShinsaKetteiEntity updateRecord = sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
            updateRecord.setTsuchishoNo(new RString("12"));

            sut.save(updateRecord);

            DbT3112KogakuShikyuShinsaKetteiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);

            assertThat(updateRecord.getTsuchishoNo(), is(updatedRecord.getTsuchishoNo()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
        }

        @Test
        public void 事業高額介護サービス費支給審査決定エンティティを渡すと_deleteは_事業高額介護サービス費支給審査決定を削除する() {
            DbT3112KogakuShikyuShinsaKetteiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_決定者受取年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_通知書番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYearMonth 決定者受取年月,
                HokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                FlexibleYearMonth サービス提供年月,
                RString 通知書番号) {
            DbT3112KogakuShikyuShinsaKetteiEntity entity = DbT3112KogakuShikyuShinsaKetteiEntityGenerator.createDbT3112KogakuShikyuShinsaKetteiEntity();
            entity.setKetteishaUketoriYM(決定者受取年月);
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHihokenshaNo(被保険者番号);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setTsuchishoNo(通知書番号);
            sut.save(entity);
        }
    }
}
