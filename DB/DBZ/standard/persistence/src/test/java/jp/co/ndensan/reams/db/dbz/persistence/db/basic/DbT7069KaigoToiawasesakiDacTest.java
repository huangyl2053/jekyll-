/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7069KaigoToiawasesakiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * {@link DbT7069KaigoToiawasesakiDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7069KaigoToiawasesakiDacTest extends DbzTestDacBase {

    private static final SubGyomuCode 不正サブ業務コード = new SubGyomuCode("XXX");
    private static final SubGyomuCode 共通サブ業務コード = SubGyomuCode.DBZ介護共通;
    private static final SubGyomuCode DBAサブ業務コード = SubGyomuCode.DBA介護資格;
    private static final ReportId 共通帳票分類ID = new ReportId(new RString("000000000"));
    private static DbT7069KaigoToiawasesakiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7069KaigoToiawasesakiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
        }

        @Test(expected = NullPointerException.class)
        public void サブ業務コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_帳票分類ID);
        }

        @Test(expected = NullPointerException.class)
        public void 帳票分類IDがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7069KaigoToiawasesakiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7069KaigoToiawasesakiEntity insertedRecord = sut.selectByKey(
                    不正サブ業務コード,
                    DEFAULT_帳票分類ID);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectKaigoKyotsuのテスト extends DbzTestDacBase {

        @Test
        public void 介護共通の問合せ先が存在すると_selectKaigoKyotsuは_該当のエンティティを返す() {
            TestSupport.deleteData();
            TestSupport.insert(
                    共通サブ業務コード,
                    共通帳票分類ID);
            DbT7069KaigoToiawasesakiEntity insertedRecord = sut.selectKaigoKyotsu();
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 介護共通の問合せ先が存在しないと_selectKaigoKyotsuは_nullを返す() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            DbT7069KaigoToiawasesakiEntity insertedRecord = sut.selectKaigoKyotsu();
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectBySubGyomuCodeのテスト extends DbzTestDacBase {

        @Test(expected = NullPointerException.class)
        public void サブ業務コードがnullの場合_selectBySubGyomuCodeは_NullPointerExceptionを発生させる() {
            sut.selectBySubGyomuCode(null);
        }

        @Test
        public void サブ業務共通の問合せ先が存在すると_selectBySubGyomuCodeは_該当のエンティティを返す() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DBAサブ業務コード,
                    共通帳票分類ID);
            DbT7069KaigoToiawasesakiEntity insertedRecord = sut.selectBySubGyomuCode(DBAサブ業務コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void サブ業務共通の問合せ先が存在しないと_selectBySubGyomuCodeは_nullを返す() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DBAサブ業務コード,
                    DEFAULT_帳票分類ID);
            DbT7069KaigoToiawasesakiEntity insertedRecord = sut.selectBySubGyomuCode(DBAサブ業務コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectByChohyoBunruiIDのテスト extends DbzTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 帳票分類IDがnullの場合_selectByChohyoBunruiIDは_NullPointerExceptionを発生させる() {
            sut.selectByChohyoBunruiID(null);
        }

        @Test
        public void 帳票分類IDの問合せ先が存在すると_selectByChohyoBunruiIDは_該当のエンティティを返す() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            DbT7069KaigoToiawasesakiEntity insertedRecord = sut.selectByChohyoBunruiID(DEFAULT_帳票分類ID);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 帳票分類IDの問合せ先が存在しないと_selectByChohyoBunruiIDは_nullを返す() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    共通帳票分類ID);
            DbT7069KaigoToiawasesakiEntity insertedRecord = sut.selectByChohyoBunruiID(DEFAULT_帳票分類ID);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 介護問合せ先が存在する場合_selectAllは_全件を返す() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            assertThat(sut.selectAll().size(), is(1));
        }

        @Test
        public void 介護問合せ先が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 介護問合せ先エンティティを渡すと_insertは_介護問合せ先を追加する() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);

            assertThat(sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
        }

        @Test
        public void 介護問合せ先エンティティを渡すと_updateは_介護問合せ先を更新する() {
            DbT7069KaigoToiawasesakiEntity updateRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7069KaigoToiawasesakiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
        }

        @Test
        public void 介護問合せ先エンティティを渡すと_deleteは_介護問合せ先を削除する() {
            DbT7069KaigoToiawasesakiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                SubGyomuCode サブ業務コード,
                ReportId 帳票分類ID) {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.setSubGyomuCode(サブ業務コード);
            entity.setChohyoBunruiID(帳票分類ID);
            sut.save(entity);
        }

        public static void deleteData() {
            CSVDataUtilForUseSession utilForUseSession = new CSVDataUtilForUseSession();
            utilForUseSession.clearTable(sqlSession, DbT7069KaigoToiawasesakiEntity.TABLE_NAME.toString());
        }
    }
}
