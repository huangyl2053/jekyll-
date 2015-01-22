/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link DbT7056GappeiShichosonDac}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class DbT7056GappeiShichosonDacTest extends DbzTestDacBase {

    private static final FlexibleDate 合併年月日 = new FlexibleDate("20150101");
    private static final FlexibleDate 合併年月日2 = new FlexibleDate("20150102");
    private static final RString 地域番号 = new RString("11");
    private static final LasdecCode 旧市町村コード = new LasdecCode("999999");
    private static DbT7056GappeiShichosonDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7056GappeiShichosonDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    合併年月日,
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
                    合併年月日2,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 合併市町村が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    合併年月日,
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
            DbT7056GappeiShichosonEntity updateRecord = DbT7056GappeiShichosonEntityGenerator.createDbT7056GappeiShichosonEntity();

            updateRecord.setTelNo(new TelNo("09099991234"));

            sut.update(updateRecord);

            DbT7056GappeiShichosonEntity updatedRecord = sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード);

            assertThat(updateRecord.getTelNo(), is(updatedRecord.getTelNo()));
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
            sut.delete(sut.selectByKey(
                    DEFAULT_合併年月日,
                    DEFAULT_地域番号,
                    DEFAULT_旧市町村コード));
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
            sut.insert(entity);
        }
    }
}
