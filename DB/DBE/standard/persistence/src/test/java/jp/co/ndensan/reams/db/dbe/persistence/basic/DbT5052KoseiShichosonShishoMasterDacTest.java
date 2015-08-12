/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5052KoseiShichosonShishoMasterEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
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
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT5052KoseiShichosonShishoMasterDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT5052KoseiShichosonShishoMasterDacTest extends DbeTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT5052KoseiShichosonShishoMasterDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT5052KoseiShichosonShishoMasterDac.class);
    }

    public static class selectByKeyのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
        }

        @Test(expected = NullPointerException.class)
        public void 支所コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT5052KoseiShichosonShishoMasterEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT5052KoseiShichosonShishoMasterEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbeTestDacBase {

        @Test
        public void 構成市町村支所マスタが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 構成市町村支所マスタが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbeTestDacBase {

        @Test
        public void 構成市町村支所マスタエンティティを渡すと_insertは_構成市町村支所マスタを追加する() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
        }

        @Test
        public void 構成市町村支所マスタエンティティを渡すと_updateは_構成市町村支所マスタを更新する() {
            DbT5052KoseiShichosonShishoMasterEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
            // TODO  主キー以外の項目を変更してください
            // updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT5052KoseiShichosonShishoMasterEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);

            // TODO  主キー以外の項目を変更してください
            // assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
        }

        @Test
        public void 構成市町村支所マスタエンティティを渡すと_deleteは_構成市町村支所マスタを削除する() {
            DbT5052KoseiShichosonShishoMasterEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                LasdecCode 市町村コード,
                ShishoCode 支所コード) {
            DbT5052KoseiShichosonShishoMasterEntity entity = DbT5052KoseiShichosonShishoMasterEntityGenerator.createDbT5052KoseiShichosonShishoMasterEntity();
            entity.setShichosonCode(市町村コード);
            entity.setShishoCode(支所コード);
            sut.save(entity);
        }
    }
}
