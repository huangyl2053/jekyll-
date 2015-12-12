/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2009RentaiGimushaEntityGenerator;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2009RentaiGimushaEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link DbT2009RentaiGimushaDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT2009RentaiGimushaDacTest extends DbbTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT2009RentaiGimushaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2009RentaiGimushaDac.class);
    }

    public static class selectByKeyのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2009RentaiGimushaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2009RentaiGimushaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbbTestDacBase {

        @Test
        public void 連帯納付義務者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 連帯納付義務者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbbTestDacBase {

        @Test
        public void 連帯納付義務者エンティティを渡すと_insertは_連帯納付義務者を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 連帯納付義務者エンティティを渡すと_updateは_連帯納付義務者を更新する() {
            DbT2009RentaiGimushaEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            updateRecord.setStartYMD(new FlexibleDate("20110101"));

            sut.save(updateRecord);

            DbT2009RentaiGimushaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getStartYMD(), is(updatedRecord.getStartYMD()));
        }
    }

    public static class deleteのテスト extends DbbTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 連帯納付義務者エンティティを渡すと_deleteは_連帯納付義務者を削除する() {
            DbT2009RentaiGimushaEntity deletedEntity = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                Decimal 履歴番号) {
            DbT2009RentaiGimushaEntity entity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
