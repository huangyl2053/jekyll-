/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7103TeikeibunJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7103TeikeibunJohoEntityGenerator.DEFAULT_定型区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7103TeikeibunJohoEntityGenerator.DEFAULT_定型文コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7103TeikeibunJohoEntityGenerator.DEFAULT_種別;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
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
 * {@link DbT7103TeikeibunJohoDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7103TeikeibunJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final RString 定型区分 = new RString("2");
    private static final RString 定型区分3 = new RString("3");
    private static DbT7103TeikeibunJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7103TeikeibunJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    定型区分,
                    DEFAULT_種別,
                    DEFAULT_定型文コード);
            TestSupport.insert(
                    DEFAULT_定型区分,
                    DEFAULT_種別,
                    DEFAULT_定型文コード);
        }

        @Test(expected = NullPointerException.class)
        public void 定型区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_種別,
                    DEFAULT_定型文コード);
        }

        @Test(expected = NullPointerException.class)
        public void 種別がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_定型区分,
                    null,
                    DEFAULT_定型文コード);
        }

        @Test(expected = NullPointerException.class)
        public void 定型文コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_定型区分,
                    DEFAULT_種別,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7103TeikeibunJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_定型区分,
                    DEFAULT_種別,
                    DEFAULT_定型文コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7103TeikeibunJohoEntity insertedRecord = sut.selectByKey(
                    定型区分3,
                    DEFAULT_種別,
                    DEFAULT_定型文コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 定型文情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    定型区分,
                    DEFAULT_種別,
                    DEFAULT_定型文コード);
            TestSupport.insert(
                    DEFAULT_定型区分,
                    DEFAULT_種別,
                    DEFAULT_定型文コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 定型文情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 定型文情報エンティティを渡すと_insertは_定型文情報を追加する() {
            TestSupport.insert(
                    DEFAULT_定型区分,
                    DEFAULT_種別,
                    DEFAULT_定型文コード);

            assertThat(sut.selectByKey(
                    DEFAULT_定型区分,
                    DEFAULT_種別,
                    DEFAULT_定型文コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_定型区分,
                    DEFAULT_種別,
                    DEFAULT_定型文コード);
        }

        @Test
        public void 定型文情報エンティティを渡すと_updateは_定型文情報を更新する() {
            DbT7103TeikeibunJohoEntity updateRecord = DbT7103TeikeibunJohoEntityGenerator.createDbT7103TeikeibunJohoEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7103TeikeibunJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_定型区分,
                    DEFAULT_種別,
                    DEFAULT_定型文コード);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_定型区分,
                    DEFAULT_種別,
                    DEFAULT_定型文コード);
        }

        @Test
        public void 定型文情報エンティティを渡すと_deleteは_定型文情報を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_定型区分,
                    DEFAULT_種別,
                    DEFAULT_定型文コード));
            assertThat(sut.selectByKey(
                    DEFAULT_定型区分,
                    DEFAULT_種別,
                    DEFAULT_定型文コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 定型区分,
                RString 種別,
                RString 定型文コード) {
            DbT7103TeikeibunJohoEntity entity = DbT7103TeikeibunJohoEntityGenerator.createDbT7103TeikeibunJohoEntity();
            entity.setTeikeiKubun(定型区分);
            entity.setShubetsu(種別);
            entity.setTeikeibunCd(定型文コード);
            sut.insert(entity);
        }
    }
}
