/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3075KogakuGassanKyufuJissekiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
 * {@link DbT3075KogakuGassanKyufuJissekiDac}のテストです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class DbT3075KogakuGassanKyufuJissekiDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3075KogakuGassanKyufuJissekiDac sut;
    private static final HihokenshaNo 被保険者番号_1 = new HihokenshaNo(new RString("3"));
    private static final HihokenshaNo 被保険者番号_2 = new HihokenshaNo(new RString("4"));

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3075KogakuGassanKyufuJissekiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    被保険者番号_1,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    null,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 支給申請書整理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    null,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 整理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3075KogakuGassanKyufuJissekiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3075KogakuGassanKyufuJissekiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    被保険者番号_2,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 高額合算給付実績が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    被保険者番号_1,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 高額合算給付実績が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 高額合算給付実績エンティティを渡すと_insertは_高額合算給付実績を追加する() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 高額合算給付実績エンティティを渡すと_updateは_高額合算給付実績を更新する() {
            DbT3075KogakuGassanKyufuJissekiEntity updateRecord = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT3075KogakuGassanKyufuJissekiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 高額合算給付実績エンティティを渡すと_deleteは_高額合算給付実績を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_支給申請書整理番号,
                    DEFAULT_整理番号,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                KokanShikibetsuNo 交換情報識別番号,
                HihokenshaNo 被保険者番号,
                RString 支給申請書整理番号,
                RString 整理番号,
                YMDHMS 処理日時) {
            DbT3075KogakuGassanKyufuJissekiEntity entity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            entity.setKokanJohoShikibetsuNo(交換情報識別番号);
            entity.setHihokenshaNo(被保険者番号);
            entity.setShikyuShinseiSeiriNo(支給申請書整理番号);
            entity.setSeiriNo(整理番号);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
