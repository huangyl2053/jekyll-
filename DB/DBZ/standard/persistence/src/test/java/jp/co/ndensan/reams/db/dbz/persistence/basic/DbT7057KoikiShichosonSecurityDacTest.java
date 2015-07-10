/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurityEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7057KoikiShichosonSecurityEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7057KoikiShichosonSecurityEntityGenerator.DEFAULT_グループID;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {@link DbT7057KoikiShichosonSecurityDac}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class DbT7057KoikiShichosonSecurityDacTest extends DbzTestDacBase {

    private static final RString グループID = new RString("11");
    private static final RString グループID2 = new RString("99");
    private static DbT7057KoikiShichosonSecurityDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7057KoikiShichosonSecurityDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    グループID);
            TestSupport.insert(
                    DEFAULT_グループID);
        }

        @Test(expected = NullPointerException.class)
        public void グループIDがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7057KoikiShichosonSecurityEntity insertedRecord = sut.selectByKey(
                    DEFAULT_グループID);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7057KoikiShichosonSecurityEntity insertedRecord = sut.selectByKey(
                    グループID2);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 広域市町村セキュリティが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    グループID);
            TestSupport.insert(
                    DEFAULT_グループID);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 広域市町村セキュリティが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 広域市町村セキュリティエンティティを渡すと_insertは_広域市町村セキュリティを追加する() {
            TestSupport.insert(
                    DEFAULT_グループID);

            assertThat(sut.selectByKey(
                    DEFAULT_グループID), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_グループID);
        }

        @Test
        public void 広域市町村セキュリティエンティティを渡すと_updateは_広域市町村セキュリティを更新する() {
            DbT7057KoikiShichosonSecurityEntity updateRecord = DbT7057KoikiShichosonSecurityEntityGenerator.createDbT7057KoikiShichosonSecurityEntity();
            updateRecord.setShichosonCode(new LasdecCode("999999"));

            sut.update(updateRecord);

            DbT7057KoikiShichosonSecurityEntity updatedRecord = sut.selectByKey(
                    DEFAULT_グループID);

            assertThat(updateRecord.getShichosonCode(), is(updatedRecord.getShichosonCode()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_グループID);
        }

        @Test
        public void 広域市町村セキュリティエンティティを渡すと_deleteは_広域市町村セキュリティを削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_グループID));
            assertThat(sut.selectByKey(
                    DEFAULT_グループID), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString グループID) {
            DbT7057KoikiShichosonSecurityEntity entity = DbT7057KoikiShichosonSecurityEntityGenerator.createDbT7057KoikiShichosonSecurityEntity();
            entity.setGroupID(グループID);
            sut.insert(entity);
        }
    }
}
