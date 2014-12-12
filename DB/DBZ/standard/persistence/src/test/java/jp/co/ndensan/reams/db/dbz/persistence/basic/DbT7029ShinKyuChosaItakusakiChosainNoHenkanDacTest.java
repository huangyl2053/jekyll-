/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_旧調査員番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.DEFAULT_旧調査委託先番号;
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
 * {@link DbT7029ShinKyuChosaItakusakiChosainNoHenkanDac}のテストです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class DbT7029ShinKyuChosaItakusakiChosainNoHenkanDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7029ShinKyuChosaItakusakiChosainNoHenkanDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7029ShinKyuChosaItakusakiChosainNoHenkanDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    new LasdecCode("564125"),
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号);
        }

        @Test(expected = NullPointerException.class)
        public void 旧調査委託先番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    null,
                    DEFAULT_旧調査員番号);
        }

        @Test(expected = NullPointerException.class)
        public void 旧調査員番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧調査委託先番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity insertedRecord = sut.selectByKey(
                    new LasdecCode("548796"),
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 新旧調査委託先調査員番号変換テーブルが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    new LasdecCode("548776"),
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 新旧調査委託先調査員番号変換テーブルが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 新旧調査委託先調査員番号変換テーブルエンティティを渡すと_insertは_新旧調査委託先調査員番号変換テーブルを追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号);
        }

        @Test
        public void 新旧調査委託先調査員番号変換テーブルエンティティを渡すと_updateは_新旧調査委託先調査員番号変換テーブルを更新する() {
            DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity updateRecord = DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.createDbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity();
            //TODO  主キー以外の項目を変更してください
//   updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号);

            //TODO  主キー以外の項目を変更してください
//   assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号);
        }

        @Test
        public void 新旧調査委託先調査員番号変換テーブルエンティティを渡すと_deleteは_新旧調査委託先調査員番号変換テーブルを削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号));
            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧調査委託先番号,
                    DEFAULT_旧調査員番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                RString 旧調査委託先番号,
                RString 旧調査員番号) {
            DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity = DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator.createDbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity();
            entity.setShichosonCode(市町村コード);
            entity.setKyuChosaItakusakiNo(旧調査委託先番号);
            entity.setKyuChosainNo(旧調査員番号);
            sut.insert(entity);
        }
    }
}
