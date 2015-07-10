/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_サービス提供年月;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_レコード種別コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_事業所番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_交換情報識別番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_入力識別番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績区分コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_給付実績情報作成区分コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_被保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_証記載保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3017KyufujissekiKihonEntityGenerator.DEFAULT_通し番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {@link DbT3017KyufujissekiKihonDac}のテストです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class DbT3017KyufujissekiKihonDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final KokanShikibetsuNo 交換情報識別番号1 = new KokanShikibetsuNo(new RString("1"));
    private static final KokanShikibetsuNo 交換情報識別番号3 = new KokanShikibetsuNo(new RString("3"));
    private static DbT3017KyufujissekiKihonDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3017KyufujissekiKihonDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
            TestSupport.insert(
                    交換情報識別番号1,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 入力識別番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    null,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void レコード種別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    null,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 給付実績情報作成区分コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    null,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    null,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    null,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void サービス提供年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    null,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 給付実績区分コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    null,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 事業所番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    null,
                    DEFAULT_通し番号);
        }

        @Test(expected = NullPointerException.class)
        public void 通し番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3017KyufujissekiKihonEntity insertedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3017KyufujissekiKihonEntity insertedRecord = sut.selectByKey(
                    交換情報識別番号3,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 給付実績基本が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
            TestSupport.insert(
                    交換情報識別番号1,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 給付実績基本が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 給付実績基本エンティティを渡すと_insertは_給付実績基本を追加する() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);

            assertThat(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test
        public void 給付実績基本エンティティを渡すと_updateは_給付実績基本を更新する() {
            DbT3017KyufujissekiKihonEntity updateRecord = DbT3017KyufujissekiKihonEntityGenerator.createDbT3017KyufujissekiKihonEntity();
            // TODO 主キー以外の項目を変更してください
//            updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT3017KyufujissekiKihonEntity updatedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);

//            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号);
        }

        @Test
        public void 給付実績基本エンティティを渡すと_deleteは_給付実績基本を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号));
            assertThat(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_給付実績情報作成区分コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_給付実績区分コード,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                KokanShikibetsuNo 交換情報識別番号,
                NyuryokuShikibetsuNo 入力識別番号,
                RString レコード種別コード,
                RString 給付実績情報作成区分コード,
                HokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                FlexibleYearMonth サービス提供年月,
                RString 給付実績区分コード,
                JigyoshaNo 事業所番号,
                RString 通し番号) {
            DbT3017KyufujissekiKihonEntity entity = DbT3017KyufujissekiKihonEntityGenerator.createDbT3017KyufujissekiKihonEntity();
            entity.setKokanShikibetsuNo(交換情報識別番号);
            entity.setInputShikibetsuNo(入力識別番号);
            entity.setRecodeShubetsuCode(レコード種別コード);
            entity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
            entity.setHokenshaNo(証記載保険者番号);
            entity.setHiHokenshaNo(被保険者番号);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setKyufuJissekiKubunCode(給付実績区分コード);
            entity.setJigyoshoNo(事業所番号);
            entity.setToshiNo(通し番号);
            sut.insert(entity);
        }
    }
}
