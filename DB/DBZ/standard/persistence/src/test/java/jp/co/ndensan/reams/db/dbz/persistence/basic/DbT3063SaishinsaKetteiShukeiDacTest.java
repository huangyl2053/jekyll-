/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3063SaishinsaKetteiShukeiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_保険者区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3063SaishinsaKetteiShukeiEntityGenerator.DEFAULT_取扱年月;
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
 * {@link DbT3063SaishinsaKetteiShukeiDac}のテストです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class DbT3063SaishinsaKetteiShukeiDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3063SaishinsaKetteiShukeiDac sut;
    private static final RString 保険者区分_1 = new RString("2");
    private static final RString 保険者区分_2 = new RString("3");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3063SaishinsaKetteiShukeiDac.class);
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
            DbT3063SaishinsaKetteiShukeiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    DEFAULT_保険者区分,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3063SaishinsaKetteiShukeiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_取扱年月,
                    保険者区分_2,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 再審査決定集計が存在する場合_selectAllは_全件を返す() {
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
        public void 再審査決定集計が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 再審査決定集計エンティティを渡すと_insertは_再審査決定集計を追加する() {
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
        public void 再審査決定集計エンティティを渡すと_updateは_再審査決定集計を更新する() {
            DbT3063SaishinsaKetteiShukeiEntity updateRecord = DbT3063SaishinsaKetteiShukeiEntityGenerator.createDbT3063SaishinsaKetteiShukeiEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT3063SaishinsaKetteiShukeiEntity updatedRecord = sut.selectByKey(
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
        public void 再審査決定集計エンティティを渡すと_deleteは_再審査決定集計を削除する() {
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
            DbT3063SaishinsaKetteiShukeiEntity entity = DbT3063SaishinsaKetteiShukeiEntityGenerator.createDbT3063SaishinsaKetteiShukeiEntity();
            entity.setToriatsukaiYM(取扱年月);
            entity.setHokenshaKubun(保険者区分);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
