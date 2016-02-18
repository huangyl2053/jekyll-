/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_契約サービス種類;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_契約事業者番号;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_申請年月日;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
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
 * {@link DbT3078ShokanJuryoininKeiyakushaDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3078ShokanJuryoininKeiyakushaDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3078ShokanJuryoininKeiyakushaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3078ShokanJuryoininKeiyakushaDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
        }

        @Test(expected = NullPointerException.class)
        public void 受付年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3078ShokanJuryoininKeiyakushaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3078ShokanJuryoininKeiyakushaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 償還受領委任契約者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 償還受領委任契約者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 償還受領委任契約者エンティティを渡すと_insertは_償還受領委任契約者を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
        }

        @Test
        public void 償還受領委任契約者エンティティを渡すと_updateは_償還受領委任契約者を更新する() {
            DbT3078ShokanJuryoininKeiyakushaEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
            updateRecord.setJuryoininKaishiYMD(new FlexibleDate("20150101"));

            sut.save(updateRecord);

            DbT3078ShokanJuryoininKeiyakushaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);

            assertThat(updateRecord.getJuryoininKaishiYMD(), is(updatedRecord.getJuryoininKaishiYMD()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
        }

        @Test
        public void 償還受領委任契約者エンティティを渡すと_deleteは_償還受領委任契約者を削除する() {
            DbT3078ShokanJuryoininKeiyakushaEntity deletedEntity = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_申請年月日,
                    DEFAULT_契約事業者番号,
                    DEFAULT_契約サービス種類), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                FlexibleDate 申請年月日,
                RString 契約事業者番号,
                RString 契約サービス種類) {
            DbT3078ShokanJuryoininKeiyakushaEntity entity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setShinseiYMD(申請年月日);
            entity.setKeiyakuJigyoshaNo(契約事業者番号);
            entity.setKeiyakuServiceShurui(契約サービス種類);
            sut.save(entity);
        }
    }
}
