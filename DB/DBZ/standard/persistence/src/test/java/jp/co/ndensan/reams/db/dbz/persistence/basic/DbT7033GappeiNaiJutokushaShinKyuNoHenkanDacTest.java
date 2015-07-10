/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_履歴番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7033GappeiNaiJutokushaShinKyuNoHenkanDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final ShikibetsuCode 識別コード = new ShikibetsuCode("000001234567899");
    private static final ShikibetsuCode 識別コード2 = new ShikibetsuCode("000001234567898");
    private static DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7033GappeiNaiJutokushaShinKyuNoHenkanDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    識別コード,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity insertedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity insertedRecord = sut.selectByKey(
                    識別コード2,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 合併内住特者新旧番号変換テーブルが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    識別コード,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 合併内住特者新旧番号変換テーブルが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 合併内住特者新旧番号変換テーブルエンティティを渡すと_insertは_合併内住特者新旧番号変換テーブルを追加する() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 合併内住特者新旧番号変換テーブルエンティティを渡すと_updateは_合併内住特者新旧番号変換テーブルを更新する() {
            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity updateRecord = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity updatedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 合併内住特者新旧番号変換テーブルエンティティを渡すと_deleteは_合併内住特者新旧番号変換テーブルを削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号));
            assertThat(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShikibetsuCode 識別コード,
                RString 履歴番号) {
            DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.createDbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            entity.setShikibetsuCode(識別コード);
            entity.setRirekiNo(履歴番号);
            sut.insert(entity);
        }
    }
}
