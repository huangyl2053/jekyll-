/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1007KyokaisoHokenryoDankaiDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1007KyokaisoHokenryoDankaiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1007KyokaisoHokenryoDankaiEntityGenerator.*;
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
 * {@link DbT1007KyokaisoHokenryoDankaiDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT1007KyokaisoHokenryoDankaiDacTest extends DbzTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT1007KyokaisoHokenryoDankaiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT1007KyokaisoHokenryoDankaiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
        }

        @Test(expected = NullPointerException.class)
        public void 適用開始年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT1007KyokaisoHokenryoDankaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT1007KyokaisoHokenryoDankaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 境界層保険料段階が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 境界層保険料段階が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 境界層保険料段階エンティティを渡すと_insertは_境界層保険料段階を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
        }

        @Test
        public void 境界層保険料段階エンティティを渡すと_updateは_境界層保険料段階を更新する() {
            DbT1007KyokaisoHokenryoDankaiEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
            updateRecord.setTekiyoKaishiYM(new FlexibleYearMonth("201001"));

            sut.save(updateRecord);

            DbT1007KyokaisoHokenryoDankaiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);

            assertThat(updateRecord.getTekiyoKaishiYM(), is(updatedRecord.getTekiyoKaishiYM()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
        }

        @Test
        public void 境界層保険料段階エンティティを渡すと_deleteは_境界層保険料段階を削除する() {
            DbT1007KyokaisoHokenryoDankaiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_適用開始年月), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                Decimal 履歴番号,
                FlexibleYearMonth 適用開始年月) {
            DbT1007KyokaisoHokenryoDankaiEntity entity = DbT1007KyokaisoHokenryoDankaiEntityGenerator.createDbT1007KyokaisoHokenryoDankaiEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setRirekiNo(履歴番号);
            entity.setTekiyoKaishiYM(適用開始年月);
            sut.save(entity);
        }
    }
}
