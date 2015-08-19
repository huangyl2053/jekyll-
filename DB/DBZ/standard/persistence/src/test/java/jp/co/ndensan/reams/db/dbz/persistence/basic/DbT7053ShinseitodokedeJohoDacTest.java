/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7053ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7053ShinseitodokedeJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_申請届出年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_被保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7053ShinseitodokedeJohoEntityGenerator.DEFAULT_証記載保険者番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
 * {@link DbT7053ShinseitodokedeJohoDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7053ShinseitodokedeJohoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("1"));
    private static final ShoKisaiHokenshaNo 証記載保険者番号3 = new ShoKisaiHokenshaNo(new RString("3"));
    private static DbT7053ShinseitodokedeJohoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7053ShinseitodokedeJohoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    null,
                    DEFAULT_申請届出年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 申請届出年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7053ShinseitodokedeJohoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7053ShinseitodokedeJohoEntity insertedRecord = sut.selectByKey(
                    証記載保険者番号3,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 申請届出情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 申請届出情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 申請届出情報エンティティを渡すと_insertは_申請届出情報を追加する() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日);

            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日);
        }

        @Test
        public void 申請届出情報エンティティを渡すと_updateは_申請届出情報を更新する() {
            DbT7053ShinseitodokedeJohoEntity updateRecord = DbT7053ShinseitodokedeJohoEntityGenerator.createDbT7053ShinseitodokedeJohoEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7053ShinseitodokedeJohoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日);
        }

        @Test
        public void 申請届出情報エンティティを渡すと_deleteは_申請届出情報を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日));
            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_申請届出年月日), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShoKisaiHokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                RDate 申請届出年月日) {
            DbT7053ShinseitodokedeJohoEntity entity = DbT7053ShinseitodokedeJohoEntityGenerator.createDbT7053ShinseitodokedeJohoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHihokenshaNo(被保険者番号);
            entity.setShinseiTodokedeYMD(申請届出年月日);
            sut.insert(entity);
        }
    }
}
