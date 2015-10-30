/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT3065ShichosonTokubetsuKyufuJigyoshaDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3065ShichosonTokubetsuKyufuJigyoshaDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3065ShichosonTokubetsuKyufuJigyoshaDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3065ShichosonTokubetsuKyufuJigyoshaDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村特別給付用事業者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村特別給付用サービスコードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 市町村特別給付サービス事業者が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 市町村特別給付サービス事業者が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 市町村特別給付サービス事業者エンティティを渡すと_insertは_市町村特別給付サービス事業者を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 市町村特別給付サービス事業者エンティティを渡すと_updateは_市町村特別給付サービス事業者を更新する() {
            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
            updateRecord.setJigyoshoDaihyoshaAddressKana(new RString("ﾃｽﾄ"));

            sut.save(updateRecord);

            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getJigyoshoDaihyoshaAddressKana(), is(updatedRecord.getJigyoshoDaihyoshaAddressKana()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 市町村特別給付サービス事業者エンティティを渡すと_deleteは_市町村特別給付サービス事業者を削除する() {
            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村特別給付用事業者番号,
                    DEFAULT_市町村特別給付用サービスコード,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                JigyoshaNo 市町村特別給付用事業者番号,
                ServiceCode 市町村特別給付用サービスコード,
                Decimal 履歴番号) {
            DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity = DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator.createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
            entity.setJigyoshaNo(市町村特別給付用事業者番号);
            entity.setServiceCode(市町村特別給付用サービスコード);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
