/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3061KagoKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3061KagoKetteiMeisaiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_保険者区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3061KagoKetteiMeisaiEntityGenerator.DEFAULT_取扱年月;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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

/**
 * {@link DbT3061KagoKetteiMeisaiDac}のテストです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class DbT3061KagoKetteiMeisaiDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3061KagoKetteiMeisaiDac sut;
    private static final RString 保険者区分_1 = new RString("2");
    private static final RString 保険者区分_2 = new RString("3");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3061KagoKetteiMeisaiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    保険者区分_1,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 取扱年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_保険者区分,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 保険者区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_取扱年月,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3061KagoKetteiMeisaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3061KagoKetteiMeisaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    保険者区分_2,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 過誤決定明細が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    保険者区分_1,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 過誤決定明細が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 過誤決定明細エンティティを渡すと_insertは_過誤決定明細を追加する() {
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_処理日時);
        }

        @Test
        public void 過誤決定明細エンティティを渡すと_updateは_過誤決定明細を更新する() {
            DbT3061KagoKetteiMeisaiEntity updateRecord = DbT3061KagoKetteiMeisaiEntityGenerator.createDbT3061KagoKetteiMeisaiEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT3061KagoKetteiMeisaiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_処理日時);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_処理日時);
        }

        @Test
        public void 過誤決定明細エンティティを渡すと_deleteは_過誤決定明細を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYearMonth 取扱年月,
                RString 保険者区分,
                YMDHMS 処理日時) {
            DbT3061KagoKetteiMeisaiEntity entity = DbT3061KagoKetteiMeisaiEntityGenerator.createDbT3061KagoKetteiMeisaiEntity();
            entity.setToriatsukaiYM(取扱年月);
            entity.setHokenshaKubun(保険者区分);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
