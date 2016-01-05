/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7024KoikiShichosonCodeHenkanPatternDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7024KoikiShichosonCodeHenkanPatternEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード区分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7024KoikiShichosonCodeHenkanPatternDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7024KoikiShichosonCodeHenkanPatternDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7024KoikiShichosonCodeHenkanPatternDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7024KoikiShichosonCodeHenkanPatternDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
            TestSupport.insert(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
        }

        @Test(expected = NullPointerException.class)
        public void 広域内市町村番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
        }

        @Test(expected = NullPointerException.class)
        public void コード区分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7024KoikiShichosonCodeHenkanPatternEntity insertedRecord = sut.selectByKey(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7024KoikiShichosonCodeHenkanPatternEntity insertedRecord = sut.selectByKey(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 広域市町村管理コード変換パターンが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
            TestSupport.insert(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 広域市町村管理コード変換パターンが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 広域市町村管理コード変換パターンエンティティを渡すと_insertは_広域市町村管理コード変換パターンを追加する() {
            TestSupport.insert(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);

            assertThat(sut.selectByKey(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
        }

        @Test
        public void 広域市町村管理コード変換パターンエンティティを渡すと_updateは_広域市町村管理コード変換パターンを更新する() {
            DbT7024KoikiShichosonCodeHenkanPatternEntity updateRecord = sut.selectByKey(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7024KoikiShichosonCodeHenkanPatternEntity updatedRecord = sut.selectByKey(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
        }

        @Test
        public void 広域市町村管理コード変換パターンエンティティを渡すと_deleteは_広域市町村管理コード変換パターンを削除する() {
            DbT7024KoikiShichosonCodeHenkanPatternEntity deletedEntity = sut.selectByKey(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_広域内市町村番号,
                    DEFAULT_市町村コード,
                    DEFAULT_コード区分), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 広域内市町村番号,
                LasdecCode 市町村コード,
                RString コード区分) {
            DbT7024KoikiShichosonCodeHenkanPatternEntity entity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            entity.setKoikiShichosonNo(広域内市町村番号);
            entity.setShichosonCode(市町村コード);
            entity.setCodeKubun(コード区分);
            sut.save(entity);
        }
    }
}
