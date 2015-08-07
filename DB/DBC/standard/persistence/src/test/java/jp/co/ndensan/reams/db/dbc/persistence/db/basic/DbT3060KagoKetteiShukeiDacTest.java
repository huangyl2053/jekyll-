/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3060KagoKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3060KagoKetteiShukeiEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3060KagoKetteiShukeiEntityGenerator.*;
import jp.co.ndensan.reams.db.dbc.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link DbT3060KagoKetteiShukeiDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT3060KagoKetteiShukeiDacTest extends DbcTestDacBase {

    private static final RString キー_01 = DEFAULT_キー;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3060KagoKetteiShukeiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3060KagoKetteiShukeiDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 取扱年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 保険者区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3060KagoKetteiShukeiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3060KagoKetteiShukeiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 過誤決定集計が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 過誤決定集計が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 過誤決定集計エンティティを渡すと_insertは_過誤決定集計を追加する() {
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 過誤決定集計エンティティを渡すと_updateは_過誤決定集計を更新する() {
            DbT3060KagoKetteiShukeiEntity updateRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
            updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT3060KagoKetteiShukeiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 過誤決定集計エンティティを渡すと_deleteは_過誤決定集計を削除する() {
            DbT3060KagoKetteiShukeiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYearMonth 取扱年月,
                RString 保険者区分,
                Decimal 履歴番号) {
            DbT3060KagoKetteiShukeiEntity entity = DbT3060KagoKetteiShukeiEntityGenerator.createDbT3060KagoKetteiShukeiEntity();
            entity.setToriatsukaiYM(取扱年月);
            entity.setHokenshaKubun(保険者区分);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
