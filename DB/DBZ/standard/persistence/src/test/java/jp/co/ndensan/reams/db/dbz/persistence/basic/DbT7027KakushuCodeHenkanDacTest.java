/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7027KakushuCodeHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7027KakushuCodeHenkanEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_コード区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード;
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
 * {@link DbT7027KakushuCodeHenkanDac}のテストです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DbT7027KakushuCodeHenkanDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7027KakushuCodeHenkanDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7027KakushuCodeHenkanDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new LasdecCode("456152"),
                    DEFAULT_コード区分,
                    DEFAULT_外部コード);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分,
                    DEFAULT_外部コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_コード区分,
                    DEFAULT_外部コード);
        }

        @Test(expected = NullPointerException.class)
        public void コード区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null,
                    DEFAULT_外部コード);
        }

        @Test(expected = NullPointerException.class)
        public void 外部コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7027KakushuCodeHenkanEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分,
                    DEFAULT_外部コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7027KakushuCodeHenkanEntity insertedRecord = sut.selectByKey(
                    new LasdecCode("462154"),
                    DEFAULT_コード区分,
                    DEFAULT_外部コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 各種コード変換テーブルが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new LasdecCode("789421"),
                    DEFAULT_コード区分,
                    DEFAULT_外部コード);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分,
                    DEFAULT_外部コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 各種コード変換テーブルが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 各種コード変換テーブルエンティティを渡すと_insertは_各種コード変換テーブルを追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分,
                    DEFAULT_外部コード);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分,
                    DEFAULT_外部コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分,
                    DEFAULT_外部コード);
        }

        @Test
        public void 各種コード変換テーブルエンティティを渡すと_updateは_各種コード変換テーブルを更新する() {
            DbT7027KakushuCodeHenkanEntity updateRecord = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            //TODO  主キー以外の項目を変更してください
//            updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7027KakushuCodeHenkanEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分,
                    DEFAULT_外部コード);

            //TODO  主キー以外の項目を変更してください
// assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分,
                    DEFAULT_外部コード);
        }

        @Test
        public void 各種コード変換テーブルエンティティを渡すと_deleteは_各種コード変換テーブルを削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分,
                    DEFAULT_外部コード));
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分,
                    DEFAULT_外部コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                RString コード区分,
                RString 外部コード) {
            DbT7027KakushuCodeHenkanEntity entity = DbT7027KakushuCodeHenkanEntityGenerator.createDbT7027KakushuCodeHenkanEntity();
            entity.setShichosonCode(市町村コード);
            entity.setCodeKubun(コード区分);
            entity.setGaibuCode(外部コード);
            sut.insert(entity);
        }
    }
}
