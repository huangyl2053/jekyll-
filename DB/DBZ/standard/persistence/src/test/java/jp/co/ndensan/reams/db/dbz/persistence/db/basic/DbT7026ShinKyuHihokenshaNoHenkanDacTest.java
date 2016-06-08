/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7026ShinKyuHihokenshaNoHenkanDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号;
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
 * {@link DbT7026ShinKyuHihokenshaNoHenkanDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7026ShinKyuHihokenshaNoHenkanDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7026ShinKyuHihokenshaNoHenkanDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7026ShinKyuHihokenshaNoHenkanDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);
        }

        @Test(expected = NullPointerException.class)
        public void 旧番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7026ShinKyuHihokenshaNoHenkanEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7026ShinKyuHihokenshaNoHenkanEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 新旧被保険者番号変換テーブルが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 新旧被保険者番号変換テーブルが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 新旧被保険者番号変換テーブルエンティティを渡すと_insertは_新旧被保険者番号変換テーブルを追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);
        }

        @Test
        public void 新旧被保険者番号変換テーブルエンティティを渡すと_updateは_新旧被保険者番号変換テーブルを更新する() {
            DbT7026ShinKyuHihokenshaNoHenkanEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7026ShinKyuHihokenshaNoHenkanEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);
        }

        @Test
        public void 新旧被保険者番号変換テーブルエンティティを渡すと_deleteは_新旧被保険者番号変換テーブルを削除する() {
            DbT7026ShinKyuHihokenshaNoHenkanEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_旧番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                RString 旧番号) {
            DbT7026ShinKyuHihokenshaNoHenkanEntity entity = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.createDbT7026ShinKyuHihokenshaNoHenkanEntity();
            entity.setShichosonCode(市町村コード);
            entity.setKyuNo(旧番号);
            sut.save(entity);
        }
    }
}
