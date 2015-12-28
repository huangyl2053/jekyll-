/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7055GappeiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7055GappeiJohoDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7055GappeiJohoDacTest extends DbxTestDacBase {

    private static final FlexibleDate キー_01 = new FlexibleDate("20150101");
    private static final FlexibleDate キー_02 = new FlexibleDate("20150202");
    private static final FlexibleDate キー_03 = new FlexibleDate("20150303");
    private static DbT7055GappeiJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7055GappeiJohoDac.class);
    }

    public static class selectByLtChiikiNoのテスト extends DbxTestDacBase {

        private DbT7055GappeiJohoEntity entity;

        @Before
        public void setUp() {
            entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            entity.setChiikiNo(new RString("00"));
            TestSupport.save(entity);
            entity.setChiikiNo(new RString("50"));
            TestSupport.save(entity);
            entity.setChiikiNo(new RString("61"));
            TestSupport.save(entity);
            entity.setChiikiNo(new RString("49"));
            TestSupport.save(entity);
            entity.setChiikiNo(new RString("51"));
            TestSupport.save(entity);
        }

        @Test
        public void selectByLtChikiNo() {
            assertThat(sut.selectByLtChiikiNo(new RString("50")).size(), is(2));
        }

    }

    public static class selectTopOneByShichosonCodeのテスト extends DbxTestDacBase {

        private DbT7055GappeiJohoEntity entity;

        @Before
        public void setUp() {
            entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            entity.setChiikiNo(new RString("12"));
            TestSupport.save(entity);
            entity.setChiikiNo(new RString("21"));
            TestSupport.save(entity);
            entity.setChiikiNo(new RString("01"));
            TestSupport.save(entity);
        }

        @Test
        public void selectTopOneByShichosonCodeは_存在するデータの中で最もChikiNoが最大の物を返却する() {
            assertThat(sut.selectTopOneByShichosonCode(entity.getShichosonCode()).getChiikiNo(), is(new RString("21")));
        }

        @Test
        public void selectTopOneByShichosonCodeは_引数の市町村コードに該当するデータが存在しない場合_nullを返却する() {
            assertThat(sut.selectTopOneByShichosonCode(LasdecCode.EMPTY), is(nullValue()));
        }

    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_地域番号);
        }

        @Test(expected = NullPointerException.class)
        public void 合併年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_地域番号);
        }

        @Test(expected = NullPointerException.class)
        public void 地域番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_合併年月日,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7055GappeiJohoEntity insertedRecord = sut.selectByKey(
                    キー_01,
                    DEFAULT_地域番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7055GappeiJohoEntity insertedRecord = sut.selectByKey(
                    キー_02,
                    DEFAULT_地域番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 合併情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_地域番号);
            TestSupport.insert(
                    キー_03,
                    DEFAULT_地域番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 合併情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 合併情報エンティティを渡すと_saveは_合併情報を追加する() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);

            assertThat(sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
        }

        @Test
        public void 合併情報エンティティを渡すと_saveは_合併情報を更新する() {
            DbT7055GappeiJohoEntity updateRecord = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
            // TODO  主キー以外の項目を変更してください
            updateRecord.setGappeiShurui(new RString("1"));

            sut.save(updateRecord);

            DbT7055GappeiJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);

            // TODO  主キー以外の項目を変更してください
            assertThat(updateRecord.getGappeiShurui(), is(updatedRecord.getGappeiShurui()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
        }

        @Test
        public void 合併情報エンティティを渡すと_saveは_合併情報を削除する() {
            DbT7055GappeiJohoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleDate 合併年月日,
                RString 地域番号) {
            DbT7055GappeiJohoEntity entity = DbT7055GappeiJohoEntityGenerator.createDbT7055GappeiJohoEntity();
            entity.setGappeiYMD(合併年月日);
            entity.setChiikiNo(地域番号);
            sut.save(entity);
        }

        public static void save(DbT7055GappeiJohoEntity entity) {
            sut.save(entity);
        }

        private TestSupport() {
        }
    }
}
