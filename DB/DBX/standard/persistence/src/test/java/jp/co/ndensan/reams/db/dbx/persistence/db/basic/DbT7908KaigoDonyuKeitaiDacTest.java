/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7908KaigoDonyuKeitaiEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7908KaigoDonyuKeitaiEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7908KaigoDonyuKeitaiDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7908KaigoDonyuKeitaiDacTest {

    private static final Code 導入形態コード_01 = new Code("01");
    private static final Code 導入形態コード_02 = new Code("02");
    private static DbT7908KaigoDonyuKeitaiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7908KaigoDonyuKeitaiDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_業務分類,
                    導入形態コード_01);
        }

        @Test(expected = NullPointerException.class)
        public void selectByKeyは_業務分類がnullの場合_NullPointerExceptionを発生させる() {
            sut.selectByKey(null, 導入形態コード_01);
        }

        @Test(expected = NullPointerException.class)
        public void selectByKeyは_導入形態コードがnullの場合_NullPointerExceptionを発生させる() {
            sut.selectByKey(DEFAULT_業務分類, null);
        }

        @Test
        public void selectByKeyは_存在する主キーを渡すと_該当のエンティティを返す() {
            DbT7908KaigoDonyuKeitaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_業務分類,
                    導入形態コード_01);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void selectByKeyは_存在しない主キーを渡すと_nullを返す() {
            DbT7908KaigoDonyuKeitaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_業務分類,
                    導入形態コード_02);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト_存在する extends DbxTestDacBase {

        @Test
        public void selectAllは_介護導入形態が存在する場合_全件を返す() {
            TestSupport.insert(
                    DEFAULT_業務分類,
                    導入形態コード_01);
            TestSupport.insert(
                    DEFAULT_業務分類,
                    導入形態コード_02);
            assertThat(sut.selectAll().size(), is(2));
        }
    }

    public static class selectAllのテスト_存在しない extends DbxTestDacBase {

        @Test
        public void selectAllは_介護導入形態が存在しない場合_空のリストを返す() {
            assertThat(sut.selectAll().size(), is(0));
        }
    }

    public static class selectByGyomuBunruiのテスト_データ存在 extends DbxTestDacBase {

        private DbT7908KaigoDonyuKeitaiEntity entity;

        @Before
        public void setUp() {
            entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            entity.setDonyuKeitaiCode(導入形態コード_01);
            sut.save(entity);
            entity.setDonyuKeitaiCode(導入形態コード_02);
            sut.save(entity);
        }

        @Test
        public void selectByGyomuBunruiは_同じ業務分類を持つ介護導入形態を_すべて返却する() {
            assertThat(sut.selectByGyomuBunrui(entity.getGyomuBunrui()).size(), is(2));
        }

        @Test
        public void selectByGyomuBunruiは_指定業務分類を持つ介護導入形態が存在しないとき_空のListを返却する() {
            RString gyomuBunrui = GyomuBunrui.介護認定.code();
            assertThat(entity.getGyomuBunrui(), is(not(gyomuBunrui)));
            assertThat(sut.selectByGyomuBunrui(gyomuBunrui).size(), is(0));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void saveは_新規作成した_介護導入形態エンティティを渡すと_介護導入形態を追加する() {
            DbT7908KaigoDonyuKeitaiEntity entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            sut.save(entity);
            assertThat(entity.getState(), is(EntityDataState.Added));
            assertThat(sut.selectByKey(entity.getGyomuBunrui(), entity.getDonyuKeitaiCode()), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
        }

        @Test
        public void saveは_値が更新された_介護導入形態エンティティを渡すと_介護導入形態を更新する() {
            DbT7908KaigoDonyuKeitaiEntity updateRecord = sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
            updateRecord.setShishoKanriUmuFlag(false);
            sut.save(updateRecord);

            DbT7908KaigoDonyuKeitaiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
            assertThat(updateRecord.getShishoKanriUmuFlag(), is(updatedRecord.getShishoKanriUmuFlag()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
        }

        @Test
        public void saveは_EntityDataStateがDeletedの_介護導入形態エンティティを渡すと_介護導入形態を削除する() {
            DbT7908KaigoDonyuKeitaiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_業務分類,
                    DEFAULT_導入形態コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 業務分類,
                Code 導入形態コード) {
            DbT7908KaigoDonyuKeitaiEntity entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            entity.setGyomuBunrui(業務分類);
            entity.setDonyuKeitaiCode(導入形態コード);
            sut.save(entity);
        }

        private TestSupport() {
        }
    }
}
