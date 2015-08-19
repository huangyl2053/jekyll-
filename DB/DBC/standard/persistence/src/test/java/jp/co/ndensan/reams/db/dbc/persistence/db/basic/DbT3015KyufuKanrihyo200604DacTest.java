/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3015KyufuKanrihyo200604EntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3015KyufuKanrihyo200604EntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link DbT3015KyufuKanrihyo200604Dac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT3015KyufuKanrihyo200604DacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3015KyufuKanrihyo200604Dac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3015KyufuKanrihyo200604Dac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
            TestSupport.insert(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
        }

        @Test(expected = NullPointerException.class)
        public void 審査年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
        }

        @Test(expected = NullPointerException.class)
        public void サービス提供年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
        }

        @Test(expected = NullPointerException.class)
        public void 居宅支援事業所番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
        }

        @Test(expected = NullPointerException.class)
        public void 給付管理票情報作成区分コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
        }

        @Test(expected = NullPointerException.class)
        public void 給付管理票作成年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
        }

        @Test(expected = NullPointerException.class)
        public void 給付管理票種別区分コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
        }

        @Test(expected = NullPointerException.class)
        public void 給付管理票明細行番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3015KyufuKanrihyo200604Entity insertedRecord = sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3015KyufuKanrihyo200604Entity insertedRecord = sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 給付管理票200604が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
            TestSupport.insert(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 給付管理票200604が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 給付管理票200604エンティティを渡すと_insertは_給付管理票200604を追加する() {
            TestSupport.insert(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);

            assertThat(sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
        }

        @Test
        public void 給付管理票200604エンティティを渡すと_updateは_給付管理票200604を更新する() {
            DbT3015KyufuKanrihyo200604Entity updateRecord = sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
            updateRecord.setKijyunGaitoServiceSubTotal(75);

            sut.save(updateRecord);

            DbT3015KyufuKanrihyo200604Entity updatedRecord = sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);

            assertThat(updateRecord.getKijyunGaitoServiceSubTotal(), is(updatedRecord.getKijyunGaitoServiceSubTotal()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
        }

        @Test
        public void 給付管理票200604エンティティを渡すと_deleteは_給付管理票200604を削除する() {
            DbT3015KyufuKanrihyo200604Entity deletedEntity = sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_審査年月,
                    DEFAULT_サービス提供年月,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_居宅支援事業所番号,
                    DEFAULT_給付管理票情報作成区分コード,
                    DEFAULT_給付管理票作成年月日,
                    DEFAULT_給付管理票種別区分コード,
                    DEFAULT_給付管理票明細行番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleYearMonth 審査年月,
                FlexibleYearMonth サービス提供年月,
                HokenshaNo 証記載保険者番号,
                JigyoshaNo 居宅支援事業所番号,
                RString 給付管理票情報作成区分コード,
                FlexibleDate 給付管理票作成年月日,
                RString 給付管理票種別区分コード,
                RString 給付管理票明細行番号) {
            DbT3015KyufuKanrihyo200604Entity entity = DbT3015KyufuKanrihyo200604EntityGenerator.createDbT3015KyufuKanrihyo200604Entity();
            entity.setShinsaYM(審査年月);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setShokisaiHokenshaNo(証記載保険者番号);
            entity.setKyotakushienJigyoshoNo(居宅支援事業所番号);
            entity.setKyufuSakuseiKubunCode(給付管理票情報作成区分コード);
            entity.setKyufuSakuseiYMD(給付管理票作成年月日);
            entity.setKyufuShubetsuKubunCode(給付管理票種別区分コード);
            entity.setKyufuMeisaiLineNo(給付管理票明細行番号);
            sut.save(entity);
        }
    }
}
