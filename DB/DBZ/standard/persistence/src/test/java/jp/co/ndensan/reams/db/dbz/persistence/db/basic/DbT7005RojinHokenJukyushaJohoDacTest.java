/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7005RojinHokenJukyushaJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_識別コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
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
 * {@link DbT7005RojinHokenJukyushaJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7005RojinHokenJukyushaJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = DEFAULT_キー;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7005RojinHokenJukyushaJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7005RojinHokenJukyushaJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード);
            TestSupport.insert(
                    DEFAULT_識別コード);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7005RojinHokenJukyushaJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_識別コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7005RojinHokenJukyushaJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_識別コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 老人保健受給者情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_識別コード);
            TestSupport.insert(
                    DEFAULT_識別コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 老人保健受給者情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 老人保健受給者情報エンティティを渡すと_insertは_老人保健受給者情報を追加する() {
            TestSupport.insert(
                    DEFAULT_識別コード);

            assertThat(sut.selectByKey(
                    DEFAULT_識別コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード);
        }

        @Test
        public void 老人保健受給者情報エンティティを渡すと_updateは_老人保健受給者情報を更新する() {
            DbT7005RojinHokenJukyushaJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_識別コード);
            updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7005RojinHokenJukyushaJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_識別コード);

            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード);
        }

        @Test
        public void 老人保健受給者情報エンティティを渡すと_deleteは_老人保健受給者情報を削除する() {
            DbT7005RojinHokenJukyushaJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_識別コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_識別コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShikibetsuCode 識別コード) {
            DbT7005RojinHokenJukyushaJohoEntity entity = DbT7005RojinHokenJukyushaJohoEntityGenerator.createDbT7005RojinHokenJukyushaJohoEntity();
            entity.setShikibetsuCode(識別コード);
            sut.save(entity);
        }
    }
}
