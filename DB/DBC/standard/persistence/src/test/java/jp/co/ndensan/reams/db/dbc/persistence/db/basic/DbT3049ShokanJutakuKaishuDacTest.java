/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3049ShokanJutakuKaishuEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_サービス提供年月;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_事業者番号;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_整理番号;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_明細番号;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_様式番号;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_被保険者番号;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3049ShokanJutakuKaishuEntityGenerator.DEFAULT_連番;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link DbT3049ShokanJutakuKaishuDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3049ShokanJutakuKaishuDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3049ShokanJutakuKaishuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3049ShokanJutakuKaishuDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void サービス提供年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void 整理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void 様式番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void 明細番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
        }

        @Test(expected = NullPointerException.class)
        public void 連番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3049ShokanJutakuKaishuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3049ShokanJutakuKaishuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 償還払請求住宅改修が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 償還払請求住宅改修が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 償還払請求住宅改修エンティティを渡すと_insertは_償還払請求住宅改修を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
        }

        @Test
        public void 償還払請求住宅改修エンティティを渡すと_updateは_償還払請求住宅改修を更新する() {
            DbT3049ShokanJutakuKaishuEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
            updateRecord.setSeiriNo(new RString("10"));

            sut.save(updateRecord);

            DbT3049ShokanJutakuKaishuEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);

            assertThat(updateRecord.getSeiriNo(), is(updatedRecord.getSeiriNo()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
        }

        @Test
        public void 償還払請求住宅改修エンティティを渡すと_deleteは_償還払請求住宅改修を削除する() {
            DbT3049ShokanJutakuKaishuEntity deletedEntity = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_整理番号,
                    DEFAULT_事業者番号,
                    DEFAULT_様式番号,
                    DEFAULT_明細番号,
                    DEFAULT_連番), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                FlexibleYearMonth サービス提供年月,
                RString 整理番号,
                JigyoshaNo 事業者番号,
                RString 様式番号,
                RString 明細番号,
                RString 連番) {
            DbT3049ShokanJutakuKaishuEntity entity = DbT3049ShokanJutakuKaishuEntityGenerator.createDbT3049ShokanJutakuKaishuEntity();
            entity.setHiHokenshaNo(被保険者番号);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setSeiriNo(整理番号);
            entity.setJigyoshaNo(事業者番号);
            entity.setYoshikiNo(様式番号);
            entity.setMeisaiNo(明細番号);
            entity.setRenban(連番);
            sut.save(entity);
        }
    }
}
