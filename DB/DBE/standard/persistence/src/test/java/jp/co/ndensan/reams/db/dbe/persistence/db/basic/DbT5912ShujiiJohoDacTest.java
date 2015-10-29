/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5912ShujiiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5912ShujiiJohoEntityGenerator.DEFAULT_主治医コード;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5912ShujiiJohoEntityGenerator.DEFAULT_主治医医療機関コード;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5912ShujiiJohoEntityGenerator.DEFAULT_市町村コード;
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
 * {@link DbT5912ShujiiJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT5912ShujiiJohoDacTest extends DbeTestDacBase {

    private static final LasdecCode キー_01 = DEFAULT_市町村コード;
    private static final LasdecCode キー_02 = new LasdecCode("02");
    private static final LasdecCode キー_03 = new LasdecCode("03");
    private static DbT5912ShujiiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5912ShujiiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医医療機関コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null,
                    DEFAULT_主治医コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5912ShujiiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5912ShujiiJohoEntity insertedRecord = sut.selectByKey(
                    キー_02,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 主治医情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);
            TestSupport.insert(
                    キー_03,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 主治医情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 主治医情報エンティティを渡すと_insertは_主治医情報を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);
        }

        @Test
        public void 主治医情報エンティティを渡すと_updateは_主治医情報を更新する() {
            DbT5912ShujiiJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);
            updateRecord.setShinryokaName(new RString("001"));

            sut.save(updateRecord);

            DbT5912ShujiiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);

            assertThat(updateRecord.getShinryokaName(), is(updatedRecord.getShinryokaName()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);
        }

        @Test
        public void 主治医情報エンティティを渡すと_deleteは_主治医情報を削除する() {
            DbT5912ShujiiJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_主治医医療機関コード,
                    DEFAULT_主治医コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                RString 主治医医療機関コード,
                RString 主治医コード) {
            DbT5912ShujiiJohoEntity entity = DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setShujiiIryokikanCode(主治医医療機関コード);
            entity.setShujiiCode(主治医コード);
            sut.save(entity);
        }
    }
}
