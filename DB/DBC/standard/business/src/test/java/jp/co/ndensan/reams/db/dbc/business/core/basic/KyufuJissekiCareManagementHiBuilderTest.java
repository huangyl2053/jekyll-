/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3031KyufuJissekiCareManagementHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3031KyufuJissekiCareManagementHiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuJissekiCareManagementHiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuJissekiCareManagementHiBuilderTest extends DbcTestBase {

    private static DbT3031KyufuJissekiCareManagementHiEntity KyufuJissekiCareManagementHiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 主キー名1;
    private static NyuryokuShikibetsuNo 主キー名2;
    private static RString 主キー名3;
    private static HokenshaNo 主キー名4;
    private static HihokenshaNo 主キー名5;
    private static FlexibleYearMonth 主キー名6;
    private static JigyoshaNo 主キー名7;
    private static RString 主キー名8;
    private static FlexibleDate 主キー名9;
    private static RString 主キー名10;
    private static RString 主キー名11;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
        主キー名2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
        主キー名3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
        主キー名4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
        主キー名8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
        主キー名9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
        主キー名10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
        主キー名11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyufuJissekiCareManagementHiBuilder sut;
        private static KyufuJissekiCareManagementHi business;

        @Before
        public void setUp() {
            KyufuJissekiCareManagementHiEntity = new DbT3031KyufuJissekiCareManagementHiEntity();
            KyufuJissekiCareManagementHiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufuJissekiCareManagementHiEntity.setInputShikibetsuNo(主キー名2);

            business = new KyufuJissekiCareManagementHi(KyufuJissekiCareManagementHiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の指定_基準該当事業所区分コードは_設定した値と同じ指定_基準該当事業所区分コードを返す() {
            business = sut.set指定_基準該当事業所区分コード(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード).build();
            assertThat(business.get指定_基準該当事業所区分コード(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード));
        }

        @Test
        public void 戻り値の居宅サービス計画作成依頼届出年月日は_設定した値と同じ居宅サービス計画作成依頼届出年月日を返す() {
            business = sut.set居宅サービス計画作成依頼届出年月日(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日).build();
            assertThat(business.get居宅サービス計画作成依頼届出年月日(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値のサービス計画費明細行番号は_設定した値と同じサービス計画費明細行番号を返す() {
            business = sut.setサービス計画費明細行番号(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号).build();
            assertThat(business.getサービス計画費明細行番号(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号));
        }

        @Test
        public void 戻り値の単位数単価は_設定した値と同じ単位数単価を返す() {
            business = sut.set単位数単価(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_単位数単価).build();
            assertThat(business.get単位数単価(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_単位数単価));
        }

        @Test
        public void 戻り値のサービスコードは_設定した値と同じサービスコードを返す() {
            business = sut.setサービスコード(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービスコード).build();
            assertThat(business.getサービスコード(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービスコード));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の回数は_設定した値と同じ回数を返す() {
            business = sut.set回数(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_回数).build();
            assertThat(business.get回数(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_回数));
        }

        @Test
        public void 戻り値のサービス単位数は_設定した値と同じサービス単位数を返す() {
            business = sut.setサービス単位数(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス単位数).build();
            assertThat(business.getサービス単位数(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス単位数));
        }

        @Test
        public void 戻り値のサービス単位数合計は_設定した値と同じサービス単位数合計を返す() {
            business = sut.setサービス単位数合計(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス単位数合計).build();
            assertThat(business.getサービス単位数合計(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス単位数合計));
        }

        @Test
        public void 戻り値の請求金額は_設定した値と同じ請求金額を返す() {
            business = sut.set請求金額(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_請求金額).build();
            assertThat(business.get請求金額(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_請求金額));
        }

        @Test
        public void 戻り値の担当介護支援専門員番号は_設定した値と同じ担当介護支援専門員番号を返す() {
            business = sut.set担当介護支援専門員番号(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_担当介護支援専門員番号).build();
            assertThat(business.get担当介護支援専門員番号(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_担当介護支援専門員番号));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            business = sut.set摘要(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_摘要).build();
            assertThat(business.get摘要(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_摘要));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            business = sut.set利用者負担額(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_利用者負担額).build();
            assertThat(business.get利用者負担額(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の後_単位数は_設定した値と同じ後_単位数を返す() {
            business = sut.set後_単位数(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_後_単位数).build();
            assertThat(business.get後_単位数(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_後_単位数));
        }

        @Test
        public void 戻り値の後_回数は_設定した値と同じ後_回数を返す() {
            business = sut.set後_回数(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_後_回数).build();
            assertThat(business.get後_回数(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_後_回数));
        }

        @Test
        public void 戻り値の後_サービス単位数は_設定した値と同じ後_サービス単位数を返す() {
            business = sut.set後_サービス単位数(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_後_サービス単位数).build();
            assertThat(business.get後_サービス単位数(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_後_サービス単位数));
        }

        @Test
        public void 戻り値の後_サービス単位数合計は_設定した値と同じ後_サービス単位数合計を返す() {
            business = sut.set後_サービス単位数合計(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_後_サービス単位数合計).build();
            assertThat(business.get後_サービス単位数合計(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_後_サービス単位数合計));
        }

        @Test
        public void 戻り値の後_請求金額は_設定した値と同じ後_請求金額を返す() {
            business = sut.set後_請求金額(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_後_請求金額).build();
            assertThat(business.get後_請求金額(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_後_請求金額));
        }

        @Test
        public void 戻り値の後_利用者負担額は_設定した値と同じ後_利用者負担額を返す() {
            business = sut.set後_利用者負担額(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_後_利用者負担額).build();
            assertThat(business.get後_利用者負担額(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_後_利用者負担額));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            business = sut.set再審査回数(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_再審査回数).build();
            assertThat(business.get再審査回数(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            business = sut.set過誤回数(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_過誤回数).build();
            assertThat(business.get過誤回数(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_取込年月));
        }

    }
}
