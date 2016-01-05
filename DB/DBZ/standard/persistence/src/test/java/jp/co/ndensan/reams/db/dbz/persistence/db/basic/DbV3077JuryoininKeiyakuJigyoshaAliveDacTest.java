/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV3077JuryoininKeiyakuJigyoshaAliveDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3077JuryoininKeiyakuJigyoshaEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者契約番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
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
 * {@link DbV3077JuryoininKeiyakuJigyoshaAliveDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbV3077JuryoininKeiyakuJigyoshaAliveDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbV3077JuryoininKeiyakuJigyoshaAliveDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbV3077JuryoininKeiyakuJigyoshaAliveDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

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
            DbV3077JuryoininKeiyakuJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbV3077JuryoininKeiyakuJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 受領委任事業者Aliveが存在する場合_selectAllは_全件を返す() {
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
        public void 受領委任事業者Aliveが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 受領委任事業者Aliveエンティティを渡すと_insertは_受領委任事業者Aliveを追加する() {
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

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 受領委任事業者Aliveエンティティを渡すと_updateは_受領委任事業者Aliveを更新する() {
            DbV3077JuryoininKeiyakuJigyoshaEntity updateRecord = sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
            // TODO  主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbV3077JuryoininKeiyakuJigyoshaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);

            // TODO  主キー以外の項目を変更してください
            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 受領委任事業者Aliveエンティティを渡すと_deleteは_受領委任事業者Aliveを削除する() {
            DbV3077JuryoininKeiyakuJigyoshaEntity deletedEntity = sut.selectByKey(
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
                int 履歴番号) {
            DbV3077JuryoininKeiyakuJigyoshaEntity entity = DbV3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbV3077JuryoininKeiyakuJigyoshaEntity();
            entity.setJigyoshaKeiyakuNo(事業者契約番号);
            entity.setKaishiYMD(開始年月日);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
