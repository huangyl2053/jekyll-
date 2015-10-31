/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT5910NinteichosaItakusakiJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT5910NinteichosaItakusakiJohoDacTest extends DbeTestDacBase {

    private static final LasdecCode キー_01 = new LasdecCode("01");
    private static final LasdecCode キー_02 = new LasdecCode("02");
    private static final LasdecCode キー_03 = new LasdecCode("03");
    private static DbT5910NinteichosaItakusakiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_認定調査委託先コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_認定調査委託先コード);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査委託先コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5910NinteichosaItakusakiJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5910NinteichosaItakusakiJohoEntity insertedRecord = sut.selectByKey(
                    キー_01,
                    DEFAULT_認定調査委託先コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 認定調査委託先情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_02,
                    DEFAULT_認定調査委託先コード);
            TestSupport.insert(
                    キー_03,
                    DEFAULT_認定調査委託先コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 認定調査委託先情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 認定調査委託先情報エンティティを渡すと_insertは_認定調査委託先情報を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
        }

        @Test
        public void 認定調査委託先情報エンティティを渡すと_updateは_認定調査委託先情報を更新する() {
            DbT5910NinteichosaItakusakiJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            updateRecord.setJusho(new RString("00001"));

            sut.save(updateRecord);

            DbT5910NinteichosaItakusakiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);

            assertThat(updateRecord.getJusho(), is(updatedRecord.getJusho()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
        }

        @Test
        public void 認定調査委託先情報エンティティを渡すと_deleteは_認定調査委託先情報を削除する() {
            DbT5910NinteichosaItakusakiJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_認定調査委託先コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                RString 認定調査委託先コード) {
            DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setNinteichosaItakusakiCode(認定調査委託先コード);
            sut.save(entity);
        }
    }
}
