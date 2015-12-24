/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntityGenerator.DEFAULT_旧市町村コード;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7056GappeiShichosonEntityGenerator;
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
import org.junit.Ignore;

/**
 * {@link DbT7056GappeiShichosonDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7056GappeiShichosonDacTest extends DbxTestDacBase {

    private static final FlexibleDate キー_01 = new FlexibleDate("20150101");
    private static final FlexibleDate キー_02 = new FlexibleDate("20150202");
    private static final FlexibleDate キー_03 = new FlexibleDate("20150303");
    private static DbT7056GappeiShichosonDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7056GappeiShichosonDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    キー_01,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 合併年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 地域番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_合併年月日,
                    null,
                    DEFAULT_旧市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 旧市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7056GappeiShichosonEntity insertedRecord = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7056GappeiShichosonEntity insertedRecord = sut.selectByKey(
                    キー_01,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 合併市町村が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_02,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
            TestSupport.insert(
                    キー_03,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 合併市町村が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 合併市町村エンティティを渡すと_insertは_合併市町村を追加する() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);

            assertThat(sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
        }

        @Test
        public void 合併市町村エンティティを渡すと_updateは_合併市町村を更新する() {
            DbT7056GappeiShichosonEntity updateRecord = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);

            updateRecord.setHyojiUmu(new RString("0001"));

            sut.save(updateRecord);

            DbT7056GappeiShichosonEntity updatedRecord = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);

            assertThat(updateRecord.getHyojiUmu(), is(updatedRecord.getHyojiUmu()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
        }

        @Test
        public void 合併市町村エンティティを渡すと_deleteは_合併市町村を削除する() {
            DbT7056GappeiShichosonEntity deletedEntity = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleDate 合併年月日,
                RString 地域番号,
                LasdecCode 旧市町村コード) {
            DbT7056GappeiShichosonEntity entity = DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity();
            entity.setGappeiYMD(合併年月日);
            entity.setChiikiNo(地域番号);
            entity.setKyuShichosonCode(旧市町村コード);
            sut.save(entity);
        }
    }
}
