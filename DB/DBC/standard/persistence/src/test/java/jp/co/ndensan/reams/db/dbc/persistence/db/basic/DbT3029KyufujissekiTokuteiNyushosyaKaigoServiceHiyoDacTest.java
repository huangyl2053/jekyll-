/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbc.testhelper.DbcTestDacBase;
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
 * {@link DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoDacTest extends DbcTestDacBase {

    private static final RString キー_01 = DEFAULT_キー;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        }

        @Test(expected = NullPointerException.class)
        public void 交換情報識別番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        }

        @Test(expected = NullPointerException.class)
        public void 入力識別番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        }

        @Test(expected = NullPointerException.class)
        public void レコード種別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        }

        @Test(expected = NullPointerException.class)
        public void サービス提供年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        }

        @Test(expected = NullPointerException.class)
        public void 事業所番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        }

        @Test(expected = NullPointerException.class)
        public void 通し番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        }

        @Test(expected = NullPointerException.class)
        public void 特定入所者介護サービス費用情報レコード順次番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity insertedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 給付実績特定入所者介護サービス費用が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 給付実績特定入所者介護サービス費用が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 給付実績特定入所者介護サービス費用エンティティを渡すと_insertは_給付実績特定入所者介護サービス費用を追加する() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);

            assertThat(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        }

        @Test
        public void 給付実績特定入所者介護サービス費用エンティティを渡すと_updateは_給付実績特定入所者介護サービス費用を更新する() {
            DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity updateRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
            updateRecord.set変更したい項目(75);

            sut.save(updateRecord);

            DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity updatedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);

            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
        }

        @Test
        public void 給付実績特定入所者介護サービス費用エンティティを渡すと_deleteは_給付実績特定入所者介護サービス費用を削除する() {
            DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity deletedEntity = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_通し番号,
                    DEFAULT_特定入所者介護サービス費用情報レコード順次番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                KokanShikibetsuCode 交換情報識別番号,
                NyuryokuShikibetsuCode 入力識別番号,
                RString レコード種別コード,
                HokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                FlexibleYearMonth サービス提供年月,
                JigyoshaNo 事業所番号,
                RString 通し番号,
                RString 特定入所者介護サービス費用情報レコード順次番号) {
            DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.createDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
            entity.setKokanJohoShikibetsuNo(交換情報識別番号);
            entity.setInputShikibetsuNo(入力識別番号);
            entity.setRecodeShubetsuCode(レコード種別コード);
            entity.setShokisaiHokenshaNo(証記載保険者番号);
            entity.setHiHokenshaNo(被保険者番号);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setJigyoshoNo(事業所番号);
            entity.setToshiNo(通し番号);
            entity.setRecodeJunjiNo(特定入所者介護サービス費用情報レコード順次番号);
            sut.save(entity);
        }
    }
}
