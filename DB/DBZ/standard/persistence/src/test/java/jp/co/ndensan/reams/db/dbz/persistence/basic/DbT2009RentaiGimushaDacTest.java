/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2009RentaiGimushaEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2009RentaiGimushaEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2009RentaiGimushaEntityGenerator.DEFAULT_被保険者番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
 * {@link DbT2009RentaiGimushaDac}のテストです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class DbT2009RentaiGimushaDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final HihokenshaNo 被保険者番号1 = new HihokenshaNo(new RString("1"));
    private static final HihokenshaNo 被保険者番号3 = new HihokenshaNo(new RString("3"));
    private static DbT2009RentaiGimushaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2009RentaiGimushaDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    被保険者番号1,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2009RentaiGimushaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2009RentaiGimushaEntity insertedRecord = sut.selectByKey(
                    被保険者番号3,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 連帯納付義務者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    被保険者番号1,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 連帯納付義務者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 連帯納付義務者エンティティを渡すと_insertは_連帯納付義務者を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 連帯納付義務者エンティティを渡すと_updateは_連帯納付義務者を更新する() {
            DbT2009RentaiGimushaEntity updateRecord = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            // TODO 主キー以外の項目を変更してください
//            updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT2009RentaiGimushaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);

//            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 連帯納付義務者エンティティを渡すと_deleteは_連帯納付義務者を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                RDateTime 処理日時) {
            DbT2009RentaiGimushaEntity entity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
