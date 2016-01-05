/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.HihokenshaDaichoDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_枝番;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link HihokenshaDaichoDac}のテストです。
 *
 * @author n8178 城間篤人
 */
@Ignore
@RunWith(Enclosed.class)
public class HihokenshaDaichoDacTest extends DbzTestDacBase {

    private static final HihokenshaNo OTHER_被保険者番号 = new HihokenshaNo("1234500001");
    private static final FlexibleDate OTHER_異動日 = new FlexibleDate("20150808");
    private static final RString OTHER_枝番 = new RString("001");
    private static final HihokenshaNo NONE_被保険者番号 = new HihokenshaNo("9999999999");
    private static final FlexibleDate NONE_異動日 = new FlexibleDate("99999999");
    private static final RString NONE_枝番 = new RString("001");
    private static HihokenshaDaichoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(HihokenshaDaichoDac.class);
    }

    public static class selectByKey_市町村コード_被保険者番号_処理日時のテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            TestSupport.insert(
                    OTHER_被保険者番号,
                    OTHER_異動日,
                    OTHER_枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 異動日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    null,
                    DEFAULT_枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 枝番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT1001HihokenshaDaichoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT1001HihokenshaDaichoEntity insertedRecord = sut.selectByKey(
                    NONE_被保険者番号,
                    NONE_異動日,
                    NONE_枝番);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectByKey_市町村コード_被保険者番号のテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            TestSupport.insert(
                    OTHER_被保険者番号,
                    OTHER_異動日,
                    OTHER_枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_異動日);
        }

        @Test(expected = NullPointerException.class)
        public void 異動日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            IItemList<DbT1001HihokenshaDaichoEntity> selectByKey = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日);
            assertThat(selectByKey, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            IItemList<DbT1001HihokenshaDaichoEntity> selectByKey = sut.selectByKey(
                    null,
                    NONE_異動日);
            assertThat(selectByKey.isEmpty(), is(true));
        }
    }

    public static class selectByKey_市町村コードのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            TestSupport.insert(
                    OTHER_被保険者番号,
                    OTHER_異動日,
                    OTHER_枝番);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            ItemList<DbT1001HihokenshaDaichoEntity> selectByKey = sut.selectByKey(DEFAULT_被保険者番号);
            assertThat(selectByKey, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            ItemList<DbT1001HihokenshaDaichoEntity> selectByKey = sut.selectByKey(NONE_被保険者番号);
            assertThat(selectByKey.isEmpty(), is(true));
        }
    }

    @Ignore//テストデータは変更される場合があるため、スキップする。
    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 被保険者台帳が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
            assertThat(sut.selectAll().size(), is(14));
        }

        @Test
        public void 被保険者台帳が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 被保険者台帳エンティティを渡すと_insertは_被保険者台帳を追加する() {
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

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
        }

        @Test
        public void 被保険者台帳エンティティを渡すと_updateは_被保険者台帳を更新する() {
            DbT1001HihokenshaDaichoEntity updateRecord = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            updateRecord.setShikakuShutokuYMD(new FlexibleDate("20091111"));

            sut.update(updateRecord);

            DbT1001HihokenshaDaichoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);

            assertThat(updateRecord.getShikakuShutokuYMD(), is(updatedRecord.getShikakuShutokuYMD()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番);
        }

        @Test
        public void 被保険者台帳エンティティを渡すと_deleteは_被保険者台帳を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番));
            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_異動日,
                    DEFAULT_枝番), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(HihokenshaNo 被保険者番号,
                FlexibleDate 異動日,
                RString 枝番) {
            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setIdoYMD(異動日);
            entity.setEdaNo(枝番);
            sut.insert(entity);
        }
    }
}
