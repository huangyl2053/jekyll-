/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbV1001HihokenshaDaichoAliveDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbV1001HihokenshaDaichoAliveDacTest extends DbxTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbV1001HihokenshaDaichoAliveDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 異動日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 枝番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbV1001HihokenshaDaichoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbV1001HihokenshaDaichoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void 被保険者台帳管理Aliveが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 被保険者台帳管理Aliveが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void 被保険者台帳管理Aliveエンティティを渡すと_insertは_被保険者台帳管理Aliveを追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
        }

        @Test
        public void 被保険者台帳管理Aliveエンティティを渡すと_updateは_被保険者台帳管理Aliveを更新する() {
            DbV1001HihokenshaDaichoEntity updateRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            updateRecord.setShikakuHenkoTodokedeYMD(new FlexibleDate("20150908"));

            sut.save(updateRecord);

            DbV1001HihokenshaDaichoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);

            assertThat(updateRecord.getShikakuHenkoTodokedeYMD(), is(updatedRecord.getShikakuHenkoTodokedeYMD()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
        }

        @Test
        public void 被保険者台帳管理Aliveエンティティを渡すと_deleteは_被保険者台帳管理Aliveを削除する() {
            DbV1001HihokenshaDaichoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                FlexibleDate 異動日,
                RString 枝番) {
            DbV1001HihokenshaDaichoEntity entity = DbV1001HihokenshaDaichoEntityGenerator.createDbV1001HihokenshaDaichoEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setIdoYMD(異動日);
            entity.setEdaNo(枝番);
            sut.save(entity);
        }
    }
}
