/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link DbT3094JutakuKaishuRiyushoTesuryoKetteiDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3094JutakuKaishuRiyushoTesuryoKetteiDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3094JutakuKaishuRiyushoTesuryoKetteiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3094JutakuKaishuRiyushoTesuryoKetteiDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 介護住宅改修理由書作成事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 決定年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 住宅改修理由書作成手数料請求決定が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 住宅改修理由書作成手数料請求決定が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 住宅改修理由書作成手数料請求決定エンティティを渡すと_insertは_住宅改修理由書作成手数料請求決定を追加する() {
            TestSupport.insert(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 住宅改修理由書作成手数料請求決定エンティティを渡すと_updateは_住宅改修理由書作成手数料請求決定を更新する() {
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity updateRecord = sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
            updateRecord.setTesuryoShiharaiYoteiYMD(new FlexibleDate("20140101"));

            sut.save(updateRecord);

            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getTesuryoShiharaiYoteiYMD(), is(updatedRecord.getTesuryoShiharaiYoteiYMD()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 住宅改修理由書作成手数料請求決定エンティティを渡すと_deleteは_住宅改修理由書作成手数料請求決定を削除する() {
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_介護住宅改修理由書作成事業者番号,
                    DEFAULT_決定年月日,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                JigyoshaNo 介護住宅改修理由書作成事業者番号,
                FlexibleDate 決定年月日,
                int 履歴番号) {
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            entity.setRiyushoSakuseiJigyoshaNo(介護住宅改修理由書作成事業者番号);
            entity.setKetteiYMD(決定年月日);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
