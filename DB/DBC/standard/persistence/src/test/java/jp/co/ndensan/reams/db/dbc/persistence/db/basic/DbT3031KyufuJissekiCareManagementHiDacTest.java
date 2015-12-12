/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3031KyufuJissekiCareManagementHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3031KyufuJissekiCareManagementHiEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3031KyufuJissekiCareManagementHiEntityGenerator.*;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT3031KyufuJissekiCareManagementHiDac}のテストです。
 */
@RunWith(Enclosed.class)
@Ignore
public class DbT3031KyufuJissekiCareManagementHiDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3031KyufuJissekiCareManagementHiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3031KyufuJissekiCareManagementHiDac.class);
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
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
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
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
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
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
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
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
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
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
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
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
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
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
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
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
        }

        @Test(expected = NullPointerException.class)
        public void 指定_基準該当事業所区分コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
        }

        @Test(expected = NullPointerException.class)
        public void 居宅サービス計画作成依頼届出年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
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
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
        }

        @Test(expected = NullPointerException.class)
        public void サービス計画費明細行番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3031KyufuJissekiCareManagementHiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3031KyufuJissekiCareManagementHiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 給付実績ケアマネジメント費が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 給付実績ケアマネジメント費が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 給付実績ケアマネジメント費エンティティを渡すと_insertは_給付実績ケアマネジメント費を追加する() {
            TestSupport.insert(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );

            assertThat(sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            ), is(notNullValue())
            );
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
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
        }

        @Test
        public void 給付実績ケアマネジメント費エンティティを渡すと_updateは_給付実績ケアマネジメント費を更新する() {
            DbT3031KyufuJissekiCareManagementHiEntity updateRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
            updateRecord.setAtoKaisu(new Decimal(5));

            sut.save(updateRecord);

            DbT3031KyufuJissekiCareManagementHiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );

            assertThat(updateRecord.getAtoKaisu(), is(updatedRecord.getAtoKaisu()));
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
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
        }

        @Test
        public void 給付実績ケアマネジメント費エンティティを渡すと_deleteは_給付実績ケアマネジメント費を削除する() {
            DbT3031KyufuJissekiCareManagementHiEntity deletedEntity = sut.selectByKey(
                    DEFAULT_交換情報識別番号,
                    DEFAULT_入力識別番号,
                    DEFAULT_レコード種別コード,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_サービス提供年月,
                    DEFAULT_事業所番号,
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            );
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
                    DEFAULT_指定_基準該当事業所区分コード,
                    DEFAULT_居宅サービス計画作成依頼届出年月日,
                    DEFAULT_通し番号,
                    DEFAULT_サービス計画費明細行番号
            ), is(nullValue())
            );
        }
    }

    private static class TestSupport {

        public static void insert(
                KokanShikibetsuNo 交換情報識別番号,
                NyuryokuShikibetsuNo 入力識別番号,
                RString レコード種別コード,
                HokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                FlexibleYearMonth サービス提供年月,
                JigyoshaNo 事業所番号,
                RString 指定_基準該当事業所区分コード,
                FlexibleDate 居宅サービス計画作成依頼届出年月日,
                RString 通し番号,
                RString サービス計画費明細行番号) {
            DbT3031KyufuJissekiCareManagementHiEntity entity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            entity.setKokanJohoShikibetsuNo(交換情報識別番号);
            entity.setInputShikibetsuNo(入力識別番号);
            entity.setRecodeShubetsuCode(レコード種別コード);
            entity.setShokisaiHokenshaNo(証記載保険者番号);
            entity.setHiHokenshaNo(被保険者番号);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setJigyoshoNo(事業所番号);
            entity.setShiteiKijungaitoJigyoshoKubunCode(指定_基準該当事業所区分コード);
            entity.setKyotakuServiceSakuseiIraiYMD(居宅サービス計画作成依頼届出年月日);
            entity.setToshiNo(通し番号);
            entity.setServicePlanhiMeisaiLineNo(サービス計画費明細行番号);
            sut.save(entity);
        }
    }
}
