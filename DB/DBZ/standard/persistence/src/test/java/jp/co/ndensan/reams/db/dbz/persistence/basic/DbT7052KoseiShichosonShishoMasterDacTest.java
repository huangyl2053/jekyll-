/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_証記載保険者番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
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
 * {@link DbT7052KoseiShichosonShishoMasterDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7052KoseiShichosonShishoMasterDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("1"));
    private static final ShoKisaiHokenshaNo 証記載保険者番号3 = new ShoKisaiHokenshaNo(new RString("3"));
    private static DbT7052KoseiShichosonShishoMasterDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7052KoseiShichosonShishoMasterDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    証記載保険者番号,
                    DEFAULT_支所コード);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_支所コード);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_支所コード);
        }

        @Test(expected = NullPointerException.class)
        public void 支所コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7052KoseiShichosonShishoMasterEntity insertedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_支所コード);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7052KoseiShichosonShishoMasterEntity insertedRecord = sut.selectByKey(
                    証記載保険者番号3,
                    DEFAULT_支所コード);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 構成市町村支所マスタが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    証記載保険者番号,
                    DEFAULT_支所コード);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
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
                    DEFAULT_証記載保険者番号,
                    DEFAULT_支所コード);

            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_支所コード), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_支所コード);
        }

        @Test
        public void 構成市町村支所マスタエンティティを渡すと_updateは_構成市町村支所マスタを更新する() {
            DbT7052KoseiShichosonShishoMasterEntity updateRecord = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            // TODO 主キー以外の項目を変更してください
            //updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT7052KoseiShichosonShishoMasterEntity updatedRecord = sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_支所コード);

            //assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_支所コード);
        }

        @Test
        public void 構成市町村支所マスタエンティティを渡すと_deleteは_構成市町村支所マスタを削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_支所コード));
            assertThat(sut.selectByKey(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_支所コード), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShoKisaiHokenshaNo 証記載保険者番号,
                ShishoCode 支所コード) {
            DbT7052KoseiShichosonShishoMasterEntity entity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setShishoCode(支所コード);
            sut.insert(entity);
        }
    }
}
