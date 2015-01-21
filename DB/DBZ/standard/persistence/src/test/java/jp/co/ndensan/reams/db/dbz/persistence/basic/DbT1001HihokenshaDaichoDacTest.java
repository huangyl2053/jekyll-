/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1009ShikakuShutokuJogaishaEntityGenerator.DEFAULT_市町村コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
 * {@link DbT1001HihokenshaDaichoDac}のテストです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class DbT1001HihokenshaDaichoDacTest extends DbzTestDacBase {

    private static final LasdecCode 市町村コード202012 = new LasdecCode("202012");
    private static final LasdecCode 市町村コード202013 = new LasdecCode("202013");
    private static DbT1001HihokenshaDaichoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    市町村コード202012,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT1001HihokenshaDaichoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT1001HihokenshaDaichoEntity insertedRecord = sut.selectByKey(
                    市町村コード202013,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    @Ignore//テストデータは変更される場合があるため、スキップする
    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 被保険者台帳管理が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    市町村コード202012,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(15));
        }

        @Test
        public void 被保険者台帳管理が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 被保険者台帳管理エンティティを渡すと_insertは_被保険者台帳管理を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 被保険者台帳管理エンティティを渡すと_updateは_被保険者台帳管理を更新する() {
            DbT1001HihokenshaDaichoEntity updateRecord = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            updateRecord.setSaikofuKubun(new RString("9"));

            sut.update(updateRecord);

            DbT1001HihokenshaDaichoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);

            assertThat(updateRecord.getSaikofuKubun(), is(updatedRecord.getSaikofuKubun()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 被保険者台帳管理エンティティを渡すと_deleteは_被保険者台帳管理を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                HihokenshaNo 被保険者番号,
                ShoriTimestamp 処理日時) {
            DbT1001HihokenshaDaichoEntity entity = DbT1001HihokenshaDaichoEntityGenerator.createDbT1001HihokenshaDaichoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setHihokenshaNo(被保険者番号);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
