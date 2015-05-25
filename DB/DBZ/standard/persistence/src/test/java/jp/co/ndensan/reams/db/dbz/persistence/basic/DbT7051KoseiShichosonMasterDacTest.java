/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link DbT7051KoseiShichosonMasterDac}のテストです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class DbT7051KoseiShichosonMasterDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final RString 市町村識別ID = new RString("2");
    private static final RString 市町村識別ID3 = new RString("3");
    private static DbT7051KoseiShichosonMasterDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    市町村識別ID);
            TestSupport.insert(
                    DEFAULT_市町村識別ID);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村識別IDがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村識別ID);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村識別ID);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            Optional<DbT7051KoseiShichosonMasterEntity> insertedRecord = sut.selectByKey(
                    DEFAULT_市町村識別ID);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            Optional<DbT7051KoseiShichosonMasterEntity> insertedRecord = sut.selectByKey(
                    市町村識別ID3);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    @Ignore("テストデータの件数は可変なので、エラーとしない")
    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 構成市町村マスタが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    市町村識別ID);
            TestSupport.insert(
                    DEFAULT_市町村識別ID);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 構成市町村マスタが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 構成市町村マスタエンティティを渡すと_insertは_構成市町村マスタを追加する() {
            TestSupport.insert(
                    DEFAULT_市町村識別ID);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村識別ID), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村識別ID);
        }

        @Test
        public void 構成市町村マスタエンティティを渡すと_updateは_構成市町村マスタを更新する() {
            DbT7051KoseiShichosonMasterEntity updateRecord = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            updateRecord.setJusho(DEFAULT_住所);

            sut.update(updateRecord);

            Optional<DbT7051KoseiShichosonMasterEntity> updatedRecord = sut.selectByKey(
                    DEFAULT_市町村識別ID);

            assertThat(updateRecord.getJusho(), is(updatedRecord.get().getJusho()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村識別ID);
        }

        @Test
        public void 構成市町村マスタエンティティを渡すと_deleteは_構成市町村マスタを削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_市町村識別ID).get());
            assertThat(sut.selectByKey(
                    DEFAULT_市町村識別ID).isPresent(), is(false));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 市町村識別ID) {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(市町村識別ID);
            sut.insert(entity);
        }
    }
}
