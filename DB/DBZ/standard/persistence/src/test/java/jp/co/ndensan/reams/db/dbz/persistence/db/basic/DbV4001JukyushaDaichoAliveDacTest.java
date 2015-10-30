/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV4001JukyushaDaichoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請事由;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV4001JukyushaDaichoEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV4001JukyushaDaichoEntityGenerator.DEFAULT_枝番;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbV4001JukyushaDaichoAliveDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbV4001JukyushaDaichoAliveDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbV4001JukyushaDaichoAliveDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 枝番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 受給申請事由がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbV4001JukyushaDaichoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbV4001JukyushaDaichoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 受給者台帳Aliveが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 受給者台帳Aliveが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 受給者台帳Aliveエンティティを渡すと_insertは_受給者台帳Aliveを追加する() {
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

    public static class updateのテスト extends DbzTestDacBase {

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
        public void 受給者台帳Aliveエンティティを渡すと_updateは_受給者台帳Aliveを更新する() {
            DbV4001JukyushaDaichoEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
            // TODO  主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbV4001JukyushaDaichoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);

            // TODO  主キー以外の項目を変更してください
            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

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
        public void 受給者台帳Aliveエンティティを渡すと_deleteは_受給者台帳Aliveを削除する() {
            DbV4001JukyushaDaichoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号,
                    DEFAULT_枝番,
                    DEFAULT_受給申請事由);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

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
            DbV4001JukyushaDaichoEntity entity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setHihokenshaNo(被保険者番号);
            entity.setRirekiNo(履歴番号);
            entity.setEdaban(枝番);
            entity.setJukyuShinseiJiyu(受給申請事由);
            sut.save(entity);
        }
    }
}
