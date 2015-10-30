/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5913ChosainJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5913ChosainJohoEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5913ChosainJohoEntityGenerator.DEFAULT_認定調査員コード;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5913ChosainJohoEntityGenerator.DEFAULT_認定調査委託先コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT5913ChosainJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT5913ChosainJohoDacTest extends DbeTestDacBase {

    private static final LasdecCode キー_01 = DEFAULT_市町村コード;
    private static final LasdecCode キー_02 = new LasdecCode("02");
    private static final LasdecCode キー_03 = new LasdecCode("03");
    private static DbT5913ChosainJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5913ChosainJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査委託先コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null,
                    DEFAULT_認定調査員コード);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査員コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5913ChosainJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5913ChosainJohoEntity insertedRecord = sut.selectByKey(
                    キー_03,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 調査員情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 調査員情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 調査員情報エンティティを渡すと_insertは_調査員情報を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
        }

        @Test
        public void 調査員情報エンティティを渡すと_updateは_調査員情報を更新する() {
            DbT5913ChosainJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
            updateRecord.setShozokuKikanName(new RString("001"));

            sut.save(updateRecord);

            DbT5913ChosainJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);

            assertThat(updateRecord.getShozokuKikanName(), is(updatedRecord.getShozokuKikanName()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
        }

        @Test
        public void 調査員情報エンティティを渡すと_deleteは_調査員情報を削除する() {
            DbT5913ChosainJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード,
                    DEFAULT_認定調査員コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                RString 認定調査委託先コード,
                RString 認定調査員コード) {
            DbT5913ChosainJohoEntity entity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setNinteichosaItakusakiCode(認定調査委託先コード);
            entity.setNinteiChosainNo(認定調査員コード);
            sut.save(entity);
        }
    }
}
