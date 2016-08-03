/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3064SaishinsaKetteiMeisaiEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3064SaishinsaKetteiMeisaiEntityGenerator.*;
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
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT3064SaishinsaKetteiMeisaiDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3064SaishinsaKetteiMeisaiDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3064SaishinsaKetteiMeisaiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3064SaishinsaKetteiMeisaiDac.class);
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
            DbT3064SaishinsaKetteiMeisaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3064SaishinsaKetteiMeisaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 再審査決定明細が存在する場合_selectAllは_全件を返す() {
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
        public void 再審査決定明細が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 再審査決定明細エンティティを渡すと_insertは_再審査決定明細を追加する() {
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
        public void 再審査決定明細エンティティを渡すと_updateは_再審査決定明細を更新する() {
            DbT3064SaishinsaKetteiMeisaiEntity updateRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);
            updateRecord.setKohiJukyushaNo(new RString("01"));

            sut.save(updateRecord);

            DbT3064SaishinsaKetteiMeisaiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getKohiJukyushaNo(), is(updatedRecord.getKohiJukyushaNo()));
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
        public void 再審査決定明細エンティティを渡すと_deleteは_再審査決定明細を削除する() {
            DbT3064SaishinsaKetteiMeisaiEntity deletedEntity = sut.selectByKey(
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
                int 履歴番号) {
            DbT3064SaishinsaKetteiMeisaiEntity entity = DbT3064SaishinsaKetteiMeisaiEntityGenerator.createDbT3064SaishinsaKetteiMeisaiEntity();
            entity.setToriatsukaiYM(取扱年月);
            entity.setHokenshaKubun(保険者区分);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
