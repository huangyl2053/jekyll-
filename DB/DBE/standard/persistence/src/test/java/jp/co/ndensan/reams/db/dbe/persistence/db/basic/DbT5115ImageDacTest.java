/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5115ImageEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5115ImageEntityGenerator.DEFAULT_イメージ共有ファイルID;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5115ImageEntityGenerator.DEFAULT_申請書管理番号;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
 * {@link DbT5115ImageDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT5115ImageDacTest extends DbeTestDacBase {

    private static final ShinseishoKanriNo キー_01 = new ShinseishoKanriNo("01");
    private static final ShinseishoKanriNo キー_02 = new ShinseishoKanriNo("02");
    private static final ShinseishoKanriNo キー_03 = new ShinseishoKanriNo("03");
    private static DbT5115ImageDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5115ImageDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_イメージ共有ファイルID);
            TestSupport.insert(
                    キー_02,
                    DEFAULT_イメージ共有ファイルID);
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_イメージ共有ファイルID);
        }

        @Test(expected = NullPointerException.class)
        public void イメージ共有ファイルIDがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5115ImageEntity insertedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_イメージ共有ファイルID);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5115ImageEntity insertedRecord = sut.selectByKey(
                    キー_01,
                    DEFAULT_イメージ共有ファイルID);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void イメージ情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    キー_02,
                    DEFAULT_イメージ共有ファイルID);
            TestSupport.insert(
                    キー_03,
                    DEFAULT_イメージ共有ファイルID);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void イメージ情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void イメージ情報エンティティを渡すと_insertは_イメージ情報を追加する() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_イメージ共有ファイルID);

            assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_イメージ共有ファイルID), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_イメージ共有ファイルID);
        }

        @Test
        public void イメージ情報エンティティを渡すと_updateは_イメージ情報を更新する() {
            DbT5115ImageEntity updateRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_イメージ共有ファイルID);
            updateRecord.setImageSharedFileId(RDateTime.now());

            sut.save(updateRecord);

            DbT5115ImageEntity updatedRecord = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_イメージ共有ファイルID);

            assertThat(updateRecord.getImageSharedFileId(), is(updatedRecord.getImageSharedFileId()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_申請書管理番号,
                    DEFAULT_イメージ共有ファイルID);
        }

        @Test
        public void イメージ情報エンティティを渡すと_deleteは_イメージ情報を削除する() {
            DbT5115ImageEntity deletedEntity = sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_イメージ共有ファイルID);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_申請書管理番号,
                    DEFAULT_イメージ共有ファイルID), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShinseishoKanriNo 申請書管理番号,
                RDateTime イメージ共有ファイルID) {
            DbT5115ImageEntity entity = DbT5115ImageEntityGenerator.createDbT5115ImageEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setImageSharedFileId(イメージ共有ファイルID);
            sut.save(entity);
        }
    }
}
