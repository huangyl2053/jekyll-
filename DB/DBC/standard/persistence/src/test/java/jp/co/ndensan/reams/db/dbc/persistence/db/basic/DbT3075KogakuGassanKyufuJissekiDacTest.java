/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3075KogakuGassanKyufuJissekiEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3075KogakuGassanKyufuJissekiEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
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
 * {@link DbT3075KogakuGassanKyufuJissekiDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3075KogakuGassanKyufuJissekiDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3075KogakuGassanKyufuJissekiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3075KogakuGassanKyufuJissekiDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
        }

        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
        }

        @Test(expected = NullPointerException.class)
        public void 支給申請書整理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
        }

        @Test(expected = NullPointerException.class)
        public void 整理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3075KogakuGassanKyufuJissekiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3075KogakuGassanKyufuJissekiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 高額合算給付実績が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 高額合算給付実績が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 高額合算給付実績エンティティを渡すと_insertは_高額合算給付実績を追加する() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);

            assertThat(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
        }

        @Test
        public void 高額合算給付実績エンティティを渡すと_updateは_高額合算給付実績を更新する() {
            DbT3075KogakuGassanKyufuJissekiEntity updateRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
            updateRecord.setShikyuGaku(new Decimal(10000));

            sut.save(updateRecord);

            DbT3075KogakuGassanKyufuJissekiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);

            assertThat(updateRecord.getShikyuGaku(), is(updatedRecord.getShikyuGaku()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
        }

        @Test
        public void 高額合算給付実績エンティティを渡すと_deleteは_高額合算給付実績を削除する() {
            DbT3075KogakuGassanKyufuJissekiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                KokanShikibetsuNo 交換情報識別番号,
                HihokenshaNo 被保険者番号,
                RString 支給申請書整理番号,
                RString 整理番号) {
            DbT3075KogakuGassanKyufuJissekiEntity entity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            entity.setKokanJohoShikibetsuNo(交換情報識別番号);
            entity.setHihokenshaNo(被保険者番号);
            entity.setShikyuShinseiSeiriNo(支給申請書整理番号);
            entity.setSeiriNo(整理番号);
            sut.save(entity);
        }
    }
}
