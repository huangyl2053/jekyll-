/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7052KoseiShichosonShishoMasterDac;
import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT7052KoseiShichosonShishoMasterDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7052KoseiShichosonShishoMasterDacTest extends DbzTestDacBase {

    private static final RString キー_01 = RString.EMPTY;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7052KoseiShichosonShishoMasterDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7052KoseiShichosonShishoMasterDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

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
            DbT7052KoseiShichosonShishoMasterEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7052KoseiShichosonShishoMasterEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

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

    public static class insertのテスト extends DbzTestDacBase {

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

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
        }

        @Test
        public void 構成市町村支所マスタエンティティを渡すと_updateは_構成市町村支所マスタを更新する() {
            DbT7052KoseiShichosonShishoMasterEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
            updateRecord.setShishoMei(new RString("支所名"));

            sut.save(updateRecord);

            DbT7052KoseiShichosonShishoMasterEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);

            assertThat(updateRecord.getShishoMei(), is(updatedRecord.getShishoMei()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村コード,
                    DEFAULT_支所コード);
        }

        @Test
        public void 構成市町村支所マスタエンティティを渡すと_deleteは_構成市町村支所マスタを削除する() {
            DbT7052KoseiShichosonShishoMasterEntity deletedEntity = sut.selectByKey(
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
            DbT7052KoseiShichosonShishoMasterEntity entity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            entity.setShichosonCode(市町村コード);
            entity.setShishoCode(支所コード);
            sut.save(entity);
        }
    }
}
