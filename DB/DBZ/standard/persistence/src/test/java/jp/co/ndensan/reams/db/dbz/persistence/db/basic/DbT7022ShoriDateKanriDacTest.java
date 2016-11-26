/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7022ShoriDateKanriEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_サブ業務コード;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理名;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理枝番;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度内連番;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {@link DbT7022ShoriDateKanriDac}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class DbT7022ShoriDateKanriDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7022ShoriDateKanriDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void サブ業務コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void 処理名がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void 処理枝番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void 年度がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void 年度内連番がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7022ShoriDateKanriEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7022ShoriDateKanriEntity insertedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 処理日付管理マスタが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 処理日付管理マスタが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 処理日付管理マスタエンティティを渡すと_insertは_処理日付管理マスタを追加する() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);

            assertThat(sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test
        public void 処理日付管理マスタエンティティを渡すと_updateは_処理日付管理マスタを更新する() {
            DbT7022ShoriDateKanriEntity updateRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT7022ShoriDateKanriEntity updatedRecord = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test
        public void 処理日付管理マスタエンティティを渡すと_deleteは_処理日付管理マスタを削除する() {
            DbT7022ShoriDateKanriEntity deletedEntity = sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    DEFAULT_処理名,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                SubGyomuCode サブ業務コード,
                LasdecCode 市町村コード,
                RString 処理名,
                RString 処理枝番,
                FlexibleYear 年度,
                RString 年度内連番) {
            DbT7022ShoriDateKanriEntity entity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(サブ業務コード);
            entity.setShichosonCode(市町村コード);
            entity.setShoriName(処理名);
            entity.setShoriEdaban(処理枝番);
            entity.setNendo(年度);
            entity.setNendoNaiRenban(年度内連番);
            sut.save(entity);
        }
    }
}
