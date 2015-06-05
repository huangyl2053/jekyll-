/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import static jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link DbT4001JukyushaDaichoDac}のテストです。
 *
 * @author n8235 船山洋介
 */
@RunWith(Enclosed.class)
public class DbT4001JukyushaDaichoDacTest extends DbdTestDacBase {

    public static final LasdecCode OTHER_市町村コード = new LasdecCode("100001");
    public static final HihokenshaNo OTHER_被保険者番号 = new HihokenshaNo("100000001");
    public static final RString OTHER_履歴番号 = new RString("1001");
    public static final RString OTHER_枝番 = new RString("11");
    public static final Code OTHER_受給申請事由 = new Code("9");
    public static final LasdecCode NotDEFAULT_市町村コード = new LasdecCode("999999");

    private static DbT4001JukyushaDaichoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    public static class selectByKeyのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
            TestSupport.insert(
                    OTHER_市町村コード,
                    OTHER_被保険者番号,
                    OTHER_履歴番号,
                    OTHER_枝番,
                    OTHER_受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    null,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 枝番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    null,
                    DEFAULT_受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 受給申請事由がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT4001JukyushaDaichoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT4001JukyushaDaichoEntity insertedRecord = sut.selectByKey(
                    NotDEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    @Ignore("テストデータの件数は可変なので、エラーとしない")
    public static class selectAllのテスト extends DbdTestDacBase {

        @Test
        public void 受給者台帳が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
            TestSupport.insert(
                    OTHER_市町村コード,
                    OTHER_被保険者番号,
                    OTHER_履歴番号,
                    OTHER_枝番,
                    OTHER_受給申請事由);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 受給者台帳が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbdTestDacBase {

        @Test
        public void 受給者台帳エンティティを渡すと_insertは_受給者台帳を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
        }

        @Test
        public void 受給者台帳エンティティを渡すと_updateは_受給者台帳を更新する() {
            DbT4001JukyushaDaichoEntity updateRecord = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            updateRecord.setShinseiRiyu(new RString("申請理由"));

            sut.update(updateRecord);

            DbT4001JukyushaDaichoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);

            assertThat(updateRecord.getShinseiRiyu(), is(updatedRecord.getShinseiRiyu()));
        }
    }

    public static class deleteのテスト extends DbdTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
        }

        @Test
        public void 受給者台帳エンティティを渡すと_deleteは_受給者台帳を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由));
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                HihokenshaNo 被保険者番号,
                RString 履歴番号,
                RString 枝番,
                Code 受給申請事由) {
            DbT4001JukyushaDaichoEntity entity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setHihokenshaNo(被保険者番号);
            entity.setRirekiNo(履歴番号);
            entity.setEdaban(枝番);
            entity.setJukyuShinseiJiyu(受給申請事由);
            sut.insert(entity);
        }
    }
}
