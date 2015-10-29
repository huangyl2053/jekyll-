/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link DbT7908KaigoDonyuKeitaiDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7908KaigoDonyuKeitaiDacTest extends DbxTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7908KaigoDonyuKeitaiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7908KaigoDonyuKeitaiDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
            TestSupport.insert(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
        }

        @Test(expected = NullPointerException.class)
        public void 業務分類がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
        }

        @Test(expected = NullPointerException.class)
        public void 導入形態コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7908KaigoDonyuKeitaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7908KaigoDonyuKeitaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 介護導入形態が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
            TestSupport.insert(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護導入形態が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 介護導入形態エンティティを渡すと_insertは_介護導入形態を追加する() {
            TestSupport.insert(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);

            assertThat(sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
        }

        @Test
        public void 介護導入形態エンティティを渡すと_updateは_介護導入形態を更新する() {
            DbT7908KaigoDonyuKeitaiEntity updateRecord = sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
            updateRecord.setDonyuKeitaiCode(new Code("209007"));

            sut.save(updateRecord);

            DbT7908KaigoDonyuKeitaiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);

            assertThat(updateRecord.getDonyuKeitaiCode(), is(updatedRecord.getDonyuKeitaiCode()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
        }

        @Test
        public void 介護導入形態エンティティを渡すと_deleteは_介護導入形態を削除する() {
            DbT7908KaigoDonyuKeitaiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 業務分類,
                Code 導入形態コード) {
            DbT7908KaigoDonyuKeitaiEntity entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            entity.setGyomuBunrui(業務分類);
            entity.setDonyuKeitaiCode(導入形態コード);
            sut.save(entity);
        }
    }
}
