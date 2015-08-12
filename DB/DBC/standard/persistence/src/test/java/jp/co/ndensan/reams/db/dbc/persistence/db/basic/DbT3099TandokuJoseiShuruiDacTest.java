/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3099TandokuJoseiShuruiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3099TandokuJoseiShuruiEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3099TandokuJoseiShuruiEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT3099TandokuJoseiShuruiDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT3099TandokuJoseiShuruiDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3099TandokuJoseiShuruiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3099TandokuJoseiShuruiDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村単独助成種類がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 助成サービス種類コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 適用開始年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3099TandokuJoseiShuruiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3099TandokuJoseiShuruiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 市町村単独助成種類が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 市町村単独助成種類が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 市町村単独助成種類エンティティを渡すと_insertは_市町村単独助成種類を追加する() {
            TestSupport.insert(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 市町村単独助成種類エンティティを渡すと_updateは_市町村単独助成種類を更新する() {
            DbT3099TandokuJoseiShuruiEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            updateRecord.setTekiyoShuryoYM(new FlexibleYearMonth("201001"));

            sut.save(updateRecord);

            DbT3099TandokuJoseiShuruiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getTekiyoShuryoYM(), is(updatedRecord.getTekiyoShuryoYM()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 市町村単独助成種類エンティティを渡すと_deleteは_市町村単独助成種類を削除する() {
            DbT3099TandokuJoseiShuruiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村単独助成種類,
                    DEFAULT_助成サービス種類コード,
                    DEFAULT_適用開始年月,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 市町村単独助成種類,
                ServiceShuruiCode 助成サービス種類コード,
                FlexibleYearMonth 適用開始年月,
                Decimal 履歴番号) {
            DbT3099TandokuJoseiShuruiEntity entity = DbT3099TandokuJoseiShuruiEntityGenerator.createDbT3099TandokuJoseiShuruiEntity();
            entity.setTandokuJoseiShuruiCode(市町村単独助成種類);
            entity.setJoseiServiceShuruiCode(助成サービス種類コード);
            entity.setTekiyoKaishiYM(適用開始年月);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
