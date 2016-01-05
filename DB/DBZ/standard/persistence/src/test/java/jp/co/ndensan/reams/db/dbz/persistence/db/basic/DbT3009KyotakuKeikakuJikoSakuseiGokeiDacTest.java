/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT3009KyotakuKeikakuJikoSakuseiGokeiDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT3009KyotakuKeikakuJikoSakuseiGokeiDacTest extends DbzTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3009KyotakuKeikakuJikoSakuseiGokeiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3009KyotakuKeikakuJikoSakuseiGokeiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
        }

        @Test(expected = NullPointerException.class)
        public void 対象年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
        }

        @Test(expected = NullPointerException.class)
        public void 居宅サービス区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
        }

        @Test(expected = NullPointerException.class)
        public void サービス提供事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 居宅給付計画自己作成合計が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 居宅給付計画自己作成合計が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 居宅給付計画自己作成合計エンティティを渡すと_insertは_居宅給付計画自己作成合計を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
        }

        @Test
        public void 居宅給付計画自己作成合計エンティティを渡すと_updateは_居宅給付計画自己作成合計を更新する() {
            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
            updateRecord.setTaishoYM(new FlexibleYearMonth("199901"));

            sut.save(updateRecord);

            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);

            assertThat(updateRecord.getTaishoYM(), is(updatedRecord.getTaishoYM()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
        }

        @Test
        public void 居宅給付計画自己作成合計エンティティを渡すと_deleteは_居宅給付計画自己作成合計を削除する() {
            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_対象年月,
                    DEFAULT_履歴番号,
                    DEFAULT_居宅サービス区分,
                    DEFAULT_サービス提供事業者番号,
                    DEFAULT_サービス種類コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                FlexibleYearMonth 対象年月,
                Decimal 履歴番号,
                RString 居宅サービス区分,
                JigyoshaNo サービス提供事業者番号,
                ServiceShuruiCode サービス種類コード) {
            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity = DbT3009KyotakuKeikakuJikoSakuseiGokeiEntityGenerator.createDbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setTaishoYM(対象年月);
            entity.setRirekiNo(履歴番号);
            entity.setKyotakuServiceKubun(居宅サービス区分);
            entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
            entity.setServiceShuruiCode(サービス種類コード);
            sut.save(entity);
        }
    }
}
