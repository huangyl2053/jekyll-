/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4115ImageDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4115ImageEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4115ImageEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4115ImageEntityGenerator.DEFAULT_原本マスク分;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4115ImageEntityGenerator.DEFAULT_取込ページ番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4115ImageEntityGenerator.DEFAULT_申請書管理番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * {@link DbT4115ImageDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT4115ImageDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT4115ImageDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT4115ImageDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
        }

        @Test(expected = NullPointerException.class)
        public void 取込ページ番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
        }

        @Test(expected = NullPointerException.class)
        public void 原本マスク分がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT4115ImageEntity insertedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT4115ImageEntity insertedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void イメージ情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void イメージ情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void イメージ情報エンティティを渡すと_insertは_イメージ情報を追加する() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);

            assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
        }

        @Test
        public void イメージ情報エンティティを渡すと_updateは_イメージ情報を更新する() {
            DbT4115ImageEntity updateRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT4115ImageEntity updatedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
        }

        @Test
        public void イメージ情報エンティティを渡すと_deleteは_イメージ情報を削除する() {
            DbT4115ImageEntity deletedEntity = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_取込ページ番号,
                    DEFAULT_原本マスク分), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShinseishoKanriNo 申請書管理番号,
                int 取込ページ番号,
                Code 原本マスク分) {
            DbT4115ImageEntity entity = DbT4115ImageEntityGenerator.createDbT4115ImageEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setTorikomiPageNo(取込ページ番号);
            entity.setGenponMaskKubun(原本マスク分);
            sut.save(entity);
        }
    }
}
