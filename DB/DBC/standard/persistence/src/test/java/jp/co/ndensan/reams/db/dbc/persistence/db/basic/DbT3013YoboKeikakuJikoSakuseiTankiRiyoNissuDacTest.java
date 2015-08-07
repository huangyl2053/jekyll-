/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator.*;
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
 * {@link DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDacTest extends DbcTestDacBase {

    private static final RString キー_01 = DEFAULT_キー;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 対象年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 予防給付計画自己作成短期利用日数が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 予防給付計画自己作成短期利用日数が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 予防給付計画自己作成短期利用日数エンティティを渡すと_insertは_予防給付計画自己作成短期利用日数を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 予防給付計画自己作成短期利用日数エンティティを渡すと_updateは_予防給付計画自己作成短期利用日数を更新する() {
            DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
            updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 予防給付計画自己作成短期利用日数エンティティを渡すと_deleteは_予防給付計画自己作成短期利用日数を削除する() {
            DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity deletedEntity = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                FlexibleYearMonth 対象年月,
                Decimal 履歴番号) {
            DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity = DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator.createDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setTaishoYM(対象年月);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
