/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3077JuryoininKeiyakuJigyoshaEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_事業者契約番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.DEFAULT_開始年月日;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link DbT3077JuryoininKeiyakuJigyoshaDac}のテストです。
 *
 * @author LDNS 周杏月
 */
@RunWith(Enclosed.class)
public class DbT3077JuryoininKeiyakuJigyoshaDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3077JuryoininKeiyakuJigyoshaDac sut;
    private static final RString 事業者契約番号_1 = new RString("2");
    private static final RString 事業者契約番号_2 = new RString("3");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3077JuryoininKeiyakuJigyoshaDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    事業者契約番号_1,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者契約番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 開始年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3077JuryoininKeiyakuJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3077JuryoininKeiyakuJigyoshaEntity insertedRecord = sut.selectByKey(
                    事業者契約番号_2,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 受領委任契約事業者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    事業者契約番号_1,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 受領委任契約事業者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 受領委任契約事業者エンティティを渡すと_insertは_受領委任契約事業者を追加する() {
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時);
        }

        @Test
        public void 受領委任契約事業者エンティティを渡すと_updateは_受領委任契約事業者を更新する() {
            DbT3077JuryoininKeiyakuJigyoshaEntity updateRecord = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT3077JuryoininKeiyakuJigyoshaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時);
        }

        @Test
        public void 受領委任契約事業者エンティティを渡すと_deleteは_受領委任契約事業者を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_事業者契約番号,
                    DEFAULT_開始年月日,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 事業者契約番号,
                FlexibleDate 開始年月日,
                YMDHMS 処理日時) {
            DbT3077JuryoininKeiyakuJigyoshaEntity entity = DbT3077JuryoininKeiyakuJigyoshaEntityGenerator.createDbT3077JuryoininKeiyakuJigyoshaEntity();
            entity.setJigyoshaKeiyakuNo(事業者契約番号);
            entity.setKaishiYMD(開始年月日);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
