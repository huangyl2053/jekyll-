/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7056GappeiShichosonEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7056GappeiShichosonEntityGenerator.DEFAULT_合併年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7056GappeiShichosonEntityGenerator.DEFAULT_地域番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
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
 * {@link DbT7056GappeiShichosonDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7056GappeiShichosonDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7056GappeiShichosonDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7056GappeiShichosonDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 合併年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 地域番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 旧市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
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
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 合併市町村が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
            TestSupport.insert(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 合併市町村が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

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

    public static class updateのテスト extends DbzTestDacBase {

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
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7056GappeiShichosonEntity updatedRecord = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

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
