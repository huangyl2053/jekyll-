/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7028KakushuShinKyuNoHenkanDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7028KakushuShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7028KakushuShinKyuNoHenkanEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_旧番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_番号区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
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
 * {@link DbT7028KakushuShinKyuNoHenkanDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7028KakushuShinKyuNoHenkanDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7028KakushuShinKyuNoHenkanDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7028KakushuShinKyuNoHenkanDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
        }

        @Test(expected = NullPointerException.class)
        public void 番号区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
        }

        @Test(expected = NullPointerException.class)
        public void 旧番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7028KakushuShinKyuNoHenkanEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7028KakushuShinKyuNoHenkanEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 各種新旧番号変換テーブルが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 各種新旧番号変換テーブルが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 各種新旧番号変換テーブルエンティティを渡すと_insertは_各種新旧番号変換テーブルを追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
        }

        @Test
        public void 各種新旧番号変換テーブルエンティティを渡すと_updateは_各種新旧番号変換テーブルを更新する() {
            DbT7028KakushuShinKyuNoHenkanEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7028KakushuShinKyuNoHenkanEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
        }

        @Test
        public void 各種新旧番号変換テーブルエンティティを渡すと_deleteは_各種新旧番号変換テーブルを削除する() {
            DbT7028KakushuShinKyuNoHenkanEntity deletedEntity = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_番号区分,
                    DEFAULT_旧番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                RString 番号区分,
                RString 旧番号) {
            DbT7028KakushuShinKyuNoHenkanEntity entity = DbT7028KakushuShinKyuNoHenkanEntityGenerator.createDbT7028KakushuShinKyuNoHenkanEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setNoKubun(番号区分);
            entity.setKyuNo(旧番号);
            sut.save(entity);
        }
    }
}
