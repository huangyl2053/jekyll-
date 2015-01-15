/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2001ChoshuHohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2001ChoshuHohoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
 * {@link DbT2001ChoshuHohoDac}のテストです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class DbT2001ChoshuHohoDacTest extends DbzTestDacBase {

    private static final FukaNendo 賦課年度2013 = new FukaNendo(new FlexibleYear("2013"));
    private static final FukaNendo 賦課年度2015 = new FukaNendo(new FlexibleYear("2015"));
    private static DbT2001ChoshuHohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    賦課年度2013,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_被保険者番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT2001ChoshuHohoEntity insertedRecord = sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT2001ChoshuHohoEntity insertedRecord = sut.selectByKey(
                    賦課年度2015,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護徴収方法が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    賦課年度2013,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 介護徴収方法が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護徴収方法エンティティを渡すと_insertは_介護徴収方法を追加する() {
            TestSupport.insert(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 介護徴収方法エンティティを渡すと_updateは_介護徴収方法を更新する() {
            DbT2001ChoshuHohoEntity updateRecord = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();

            updateRecord.setChoshuHoho4gatsu(new RString("9"));

            sut.update(updateRecord);

            DbT2001ChoshuHohoEntity updatedRecord = sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);

            assertThat(updateRecord.getChoshuHoho4gatsu(), is(updatedRecord.getChoshuHoho4gatsu()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 介護徴収方法エンティティを渡すと_deleteは_介護徴収方法を削除する() {
            sut.delete(sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FukaNendo 賦課年度,
                HihokenshaNo 被保険者番号,
                RDateTime 処理日時) {
            DbT2001ChoshuHohoEntity entity
                    = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            entity.setFukaNendo(賦課年度.value());
            entity.setHihokenshaNo(被保険者番号);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
