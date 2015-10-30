/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3077JuryoininKeiyakuJigyoshaEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
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
 * {@link DbT3077JuryoininKeiyakuJigyoshaDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3077JuryoininKeiyakuJigyoshaDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3077JuryoininKeiyakuJigyoshaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3077JuryoininKeiyakuJigyoshaDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者契約番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 開始年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3077JuryoininKeiyakuJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3077JuryoininKeiyakuJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 受領委任契約事業者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 受領委任契約事業者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 受領委任契約事業者エンティティを渡すと_insertは_受領委任契約事業者を追加する() {
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 受領委任契約事業者エンティティを渡すと_updateは_受領委任契約事業者を更新する() {
            DbT3077JuryoininKeiyakuJigyoshaEntity updateRecord = sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
            updateRecord.setEigyoKeitai(new RString("test1"));

            sut.save(updateRecord);

            DbT3077JuryoininKeiyakuJigyoshaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getEigyoKeitai(), is(updatedRecord.getEigyoKeitai()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 受領委任契約事業者エンティティを渡すと_deleteは_受領委任契約事業者を削除する() {
            DbT3077JuryoininKeiyakuJigyoshaEntity deletedEntity = sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 事業者契約番号,
                FlexibleDate 開始年月日,
                Decimal 履歴番号) {
            DbT3077JuryoininKeiyakuJigyoshaEntity entity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            entity.setJigyoshaKeiyakuNo(事業者契約番号);
            entity.setKaishiYMD(開始年月日);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
