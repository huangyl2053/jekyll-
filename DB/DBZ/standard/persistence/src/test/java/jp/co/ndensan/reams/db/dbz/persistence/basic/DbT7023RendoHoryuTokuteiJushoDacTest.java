/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7023RendoHoryuTokuteiJushoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_管理番号;
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
 * {@link DbT7023RendoHoryuTokuteiJushoDac}のテストです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DbT7023RendoHoryuTokuteiJushoDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7023RendoHoryuTokuteiJushoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7023RendoHoryuTokuteiJushoDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new RString("1222"),
                    DEFAULT_市町村コード);
            TestSupport.insert(
                    DEFAULT_管理番号,
                    DEFAULT_市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 管理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_市町村コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_管理番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7023RendoHoryuTokuteiJushoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_管理番号,
                    DEFAULT_市町村コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7023RendoHoryuTokuteiJushoEntity insertedRecord = sut.selectByKey(
                    new RString("45612"),
                    DEFAULT_市町村コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 連動保留特定住所マスタが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new RString("45678"),
                    DEFAULT_市町村コード);
            TestSupport.insert(
                    DEFAULT_管理番号,
                    DEFAULT_市町村コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 連動保留特定住所マスタが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 連動保留特定住所マスタエンティティを渡すと_insertは_連動保留特定住所マスタを追加する() {
            TestSupport.insert(
                    DEFAULT_管理番号,
                    DEFAULT_市町村コード);

            assertThat(sut.selectByKey(
                    DEFAULT_管理番号,
                    DEFAULT_市町村コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_管理番号,
                    DEFAULT_市町村コード);
        }

        @Test
        public void 連動保留特定住所マスタエンティティを渡すと_updateは_連動保留特定住所マスタを更新する() {
            DbT7023RendoHoryuTokuteiJushoEntity updateRecord = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            //TODO  主キー以外の項目を変更してください
// updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7023RendoHoryuTokuteiJushoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_管理番号,
                    DEFAULT_市町村コード);

            //TODO  主キー以外の項目を変更してください
//  assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_管理番号,
                    DEFAULT_市町村コード);
        }

        @Test
        public void 連動保留特定住所マスタエンティティを渡すと_deleteは_連動保留特定住所マスタを削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_管理番号,
                    DEFAULT_市町村コード));
            assertThat(sut.selectByKey(
                    DEFAULT_管理番号,
                    DEFAULT_市町村コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 管理番号,
                LasdecCode 市町村コード) {
            DbT7023RendoHoryuTokuteiJushoEntity entity = DbT7023RendoHoryuTokuteiJushoEntityGenerator.createDbT7023RendoHoryuTokuteiJushoEntity();
            entity.setKanriNo(管理番号);
            entity.setShichosonCode(市町村コード);
            sut.insert(entity);
        }
    }
}
