/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7068ChohyoBunruiKanriDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7068ChohyoBunruiKanriEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_サブ業務コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_帳票ID;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7068ChohyoBunruiKanriDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7068ChohyoBunruiKanriDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7068ChohyoBunruiKanriDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7068ChohyoBunruiKanriDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);
        }

        @Test(expected = NullPointerException.class)
        public void サブ業務コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);
        }

        @Test(expected = NullPointerException.class)
        public void 帳票IDがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7068ChohyoBunruiKanriEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7068ChohyoBunruiKanriEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 帳票分類管理が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 帳票分類管理が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 帳票分類管理エンティティを渡すと_insertは_帳票分類管理を追加する() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);

            assertThat(sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);
        }

        @Test
        public void 帳票分類管理エンティティを渡すと_updateは_帳票分類管理を更新する() {
            DbT7068ChohyoBunruiKanriEntity updateRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7068ChohyoBunruiKanriEntity updatedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);
        }

        @Test
        public void 帳票分類管理エンティティを渡すと_deleteは_帳票分類管理を削除する() {
            DbT7068ChohyoBunruiKanriEntity deletedEntity = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票ID), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                SubGyomuCode サブ業務コード,
                ReportId 帳票ID) {
            DbT7068ChohyoBunruiKanriEntity entity = DbT7068ChohyoBunruiKanriEntityGenerator.createDbT7068ChohyoBunruiKanriEntity();
            entity.setSubGyomuCode(サブ業務コード);
            entity.setReportID(帳票ID);
            sut.save(entity);
        }
    }
}
