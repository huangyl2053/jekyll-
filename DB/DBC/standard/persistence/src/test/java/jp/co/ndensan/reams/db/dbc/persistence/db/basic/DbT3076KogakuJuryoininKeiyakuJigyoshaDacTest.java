/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_被保険者番号;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT3076KogakuJuryoininKeiyakuJigyoshaDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3076KogakuJuryoininKeiyakuJigyoshaDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3076KogakuJuryoininKeiyakuJigyoshaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3076KogakuJuryoininKeiyakuJigyoshaDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

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
        public void 受付年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
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
            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 高額受領委任契約事業者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 高額受領委任契約事業者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 高額受領委任契約事業者エンティティを渡すと_insertは_高額受領委任契約事業者を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 高額受領委任契約事業者エンティティを渡すと_updateは_高額受領委任契約事業者を更新する() {
            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            updateRecord.setShinseiYMD(new FlexibleDate("20150101"));

            sut.save(updateRecord);

            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getShinseiYMD(), is(updatedRecord.getShinseiYMD()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 高額受領委任契約事業者エンティティを渡すと_deleteは_高額受領委任契約事業者を削除する() {
            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity deletedEntity = sut.selectByKey(
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
                int 履歴番号) {
            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity = DbT3076KogakuJuryoininKeiyakuJigyoshaEntityGenerator.createDbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
