/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
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
 * {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilderTest extends DbcTestBase {

    private static DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
    private static RString 主キー名9;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_交換情報識別番号;
        主キー名2 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_入力識別番号;
        主キー名3 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_レコード種別コード;
        主キー名4 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス提供年月;
        主キー名7 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_事業所番号;
        主キー名8 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_通し番号;
        主キー名9 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_特定入所者介護サービス費用情報レコード順次番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBuilder sut;
        private static KyufujissekiTokuteiNyushosyaKaigoServiceHiyo business;

        @Before
        public void setUp() {
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity = new DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setInputShikibetsuNo(主キー名2);

            business = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の特定入所者介護サービス費用情報レコード順次番号は_設定した値と同じ特定入所者介護サービス費用情報レコード順次番号を返す() {
            business = sut.set特定入所者介護サービス費用情報レコード順次番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_特定入所者介護サービス費用情報レコード順次番号).build();
            assertThat(business.get特定入所者介護サービス費用情報レコード順次番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_特定入所者介護サービス費用情報レコード順次番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            business = sut.setサービス項目コード(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス項目コード).build();
            assertThat(business.getサービス項目コード(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の費用単価は_設定した値と同じ費用単価を返す() {
            business = sut.set費用単価(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_費用単価).build();
            assertThat(business.get費用単価(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_費用単価));
        }

        @Test
        public void 戻り値の負担限度額は_設定した値と同じ負担限度額を返す() {
            business = sut.set負担限度額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_負担限度額).build();
            assertThat(business.get負担限度額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_負担限度額));
        }

        @Test
        public void 戻り値の日数は_設定した値と同じ日数を返す() {
            business = sut.set日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_日数).build();
            assertThat(business.get日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_日数));
        }

        @Test
        public void 戻り値の公費１日数は_設定した値と同じ公費１日数を返す() {
            business = sut.set公費１日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１日数).build();
            assertThat(business.get公費１日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１日数));
        }

        @Test
        public void 戻り値の公費２日数は_設定した値と同じ公費２日数を返す() {
            business = sut.set公費２日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２日数).build();
            assertThat(business.get公費２日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２日数));
        }

        @Test
        public void 戻り値の公費３日数は_設定した値と同じ公費３日数を返す() {
            business = sut.set公費３日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３日数).build();
            assertThat(business.get公費３日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３日数));
        }

        @Test
        public void 戻り値の費用額は_設定した値と同じ費用額を返す() {
            business = sut.set費用額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額).build();
            assertThat(business.get費用額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額));
        }

        @Test
        public void 戻り値の保険分請求額は_設定した値と同じ保険分請求額を返す() {
            business = sut.set保険分請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額).build();
            assertThat(business.get保険分請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額));
        }

        @Test
        public void 戻り値の公費１負担額_明細は_設定した値と同じ公費１負担額_明細を返す() {
            business = sut.set公費１負担額_明細(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１負担額_明細).build();
            assertThat(business.get公費１負担額_明細(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１負担額_明細));
        }

        @Test
        public void 戻り値の公費２負担額_明細は_設定した値と同じ公費２負担額_明細を返す() {
            business = sut.set公費２負担額_明細(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２負担額_明細).build();
            assertThat(business.get公費２負担額_明細(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２負担額_明細));
        }

        @Test
        public void 戻り値の公費３負担額_明細は_設定した値と同じ公費３負担額_明細を返す() {
            business = sut.set公費３負担額_明細(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３負担額_明細).build();
            assertThat(business.get公費３負担額_明細(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３負担額_明細));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            business = sut.set利用者負担額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額).build();
            assertThat(business.get利用者負担額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の費用額合計は_設定した値と同じ費用額合計を返す() {
            business = sut.set費用額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額合計).build();
            assertThat(business.get費用額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_費用額合計));
        }

        @Test
        public void 戻り値の保険分請求額合計は_設定した値と同じ保険分請求額合計を返す() {
            business = sut.set保険分請求額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額合計).build();
            assertThat(business.get保険分請求額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_保険分請求額合計));
        }

        @Test
        public void 戻り値の利用者負担額合計は_設定した値と同じ利用者負担額合計を返す() {
            business = sut.set利用者負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額合計).build();
            assertThat(business.get利用者負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_利用者負担額合計));
        }

        @Test
        public void 戻り値の公費１_負担額合計は_設定した値と同じ公費１_負担額合計を返す() {
            business = sut.set公費１_負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１_負担額合計).build();
            assertThat(business.get公費１_負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１_負担額合計));
        }

        @Test
        public void 戻り値の公費１_請求額は_設定した値と同じ公費１_請求額を返す() {
            business = sut.set公費１_請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１_請求額).build();
            assertThat(business.get公費１_請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１_請求額));
        }

        @Test
        public void 戻り値の公費１_本人負担月額は_設定した値と同じ公費１_本人負担月額を返す() {
            business = sut.set公費１_本人負担月額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１_本人負担月額).build();
            assertThat(business.get公費１_本人負担月額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費１_本人負担月額));
        }

        @Test
        public void 戻り値の公費２_負担額合計は_設定した値と同じ公費２_負担額合計を返す() {
            business = sut.set公費２_負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２_負担額合計).build();
            assertThat(business.get公費２_負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２_負担額合計));
        }

        @Test
        public void 戻り値の公費２_請求額は_設定した値と同じ公費２_請求額を返す() {
            business = sut.set公費２_請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２_請求額).build();
            assertThat(business.get公費２_請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２_請求額));
        }

        @Test
        public void 戻り値の公費２_本人負担月額は_設定した値と同じ公費２_本人負担月額を返す() {
            business = sut.set公費２_本人負担月額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２_本人負担月額).build();
            assertThat(business.get公費２_本人負担月額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費２_本人負担月額));
        }

        @Test
        public void 戻り値の公費３_負担額合計は_設定した値と同じ公費３_負担額合計を返す() {
            business = sut.set公費３_負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３_負担額合計).build();
            assertThat(business.get公費３_負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３_負担額合計));
        }

        @Test
        public void 戻り値の公費３_請求額は_設定した値と同じ公費３_請求額を返す() {
            business = sut.set公費３_請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３_請求額).build();
            assertThat(business.get公費３_請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３_請求額));
        }

        @Test
        public void 戻り値の公費３_本人負担月額は_設定した値と同じ公費３_本人負担月額を返す() {
            business = sut.set公費３_本人負担月額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３_本人負担月額).build();
            assertThat(business.get公費３_本人負担月額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_公費３_本人負担月額));
        }

        @Test
        public void 戻り値の後_費用単価は_設定した値と同じ後_費用単価を返す() {
            business = sut.set後_費用単価(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_費用単価).build();
            assertThat(business.get後_費用単価(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_費用単価));
        }

        @Test
        public void 戻り値の後_日数は_設定した値と同じ後_日数を返す() {
            business = sut.set後_日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_日数).build();
            assertThat(business.get後_日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_日数));
        }

        @Test
        public void 戻り値の後_公費１日数は_設定した値と同じ後_公費１日数を返す() {
            business = sut.set後_公費１日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費１日数).build();
            assertThat(business.get後_公費１日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費１日数));
        }

        @Test
        public void 戻り値の後_公費２日数は_設定した値と同じ後_公費２日数を返す() {
            business = sut.set後_公費２日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費２日数).build();
            assertThat(business.get後_公費２日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費２日数));
        }

        @Test
        public void 戻り値の後_公費３日数は_設定した値と同じ後_公費３日数を返す() {
            business = sut.set後_公費３日数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費３日数).build();
            assertThat(business.get後_公費３日数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費３日数));
        }

        @Test
        public void 戻り値の後_費用額は_設定した値と同じ後_費用額を返す() {
            business = sut.set後_費用額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_費用額).build();
            assertThat(business.get後_費用額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_費用額));
        }

        @Test
        public void 戻り値の後_保険分請求額は_設定した値と同じ後_保険分請求額を返す() {
            business = sut.set後_保険分請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_保険分請求額).build();
            assertThat(business.get後_保険分請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_保険分請求額));
        }

        @Test
        public void 戻り値の後_公費１負担額_明細は_設定した値と同じ後_公費１負担額_明細を返す() {
            business = sut.set後_公費１負担額_明細(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費１負担額_明細).build();
            assertThat(business.get後_公費１負担額_明細(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費１負担額_明細));
        }

        @Test
        public void 戻り値の後_公費２負担額_明細は_設定した値と同じ後_公費２負担額_明細を返す() {
            business = sut.set後_公費２負担額_明細(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費２負担額_明細).build();
            assertThat(business.get後_公費２負担額_明細(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費２負担額_明細));
        }

        @Test
        public void 戻り値の後_公費３負担額_明細は_設定した値と同じ後_公費３負担額_明細を返す() {
            business = sut.set後_公費３負担額_明細(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費３負担額_明細).build();
            assertThat(business.get後_公費３負担額_明細(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費３負担額_明細));
        }

        @Test
        public void 戻り値の後_利用者負担額は_設定した値と同じ後_利用者負担額を返す() {
            business = sut.set後_利用者負担額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_利用者負担額).build();
            assertThat(business.get後_利用者負担額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_利用者負担額));
        }

        @Test
        public void 戻り値の後_費用額合計は_設定した値と同じ後_費用額合計を返す() {
            business = sut.set後_費用額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_費用額合計).build();
            assertThat(business.get後_費用額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_費用額合計));
        }

        @Test
        public void 戻り値の後_保険分請求額合計は_設定した値と同じ後_保険分請求額合計を返す() {
            business = sut.set後_保険分請求額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_保険分請求額合計).build();
            assertThat(business.get後_保険分請求額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_保険分請求額合計));
        }

        @Test
        public void 戻り値の後_利用者負担額合計は_設定した値と同じ後_利用者負担額合計を返す() {
            business = sut.set後_利用者負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_利用者負担額合計).build();
            assertThat(business.get後_利用者負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_利用者負担額合計));
        }

        @Test
        public void 戻り値の後_公費１_負担額合計は_設定した値と同じ後_公費１_負担額合計を返す() {
            business = sut.set後_公費１_負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費１_負担額合計).build();
            assertThat(business.get後_公費１_負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費１_負担額合計));
        }

        @Test
        public void 戻り値の後_公費１_請求額は_設定した値と同じ後_公費１_請求額を返す() {
            business = sut.set後_公費１_請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費１_請求額).build();
            assertThat(business.get後_公費１_請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費１_請求額));
        }

        @Test
        public void 戻り値の後_公費１_本人負担月額は_設定した値と同じ後_公費１_本人負担月額を返す() {
            business = sut.set後_公費１_本人負担月額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費１_本人負担月額).build();
            assertThat(business.get後_公費１_本人負担月額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費１_本人負担月額));
        }

        @Test
        public void 戻り値の後_公費２_負担額合計は_設定した値と同じ後_公費２_負担額合計を返す() {
            business = sut.set後_公費２_負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費２_負担額合計).build();
            assertThat(business.get後_公費２_負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費２_負担額合計));
        }

        @Test
        public void 戻り値の後_公費２_請求額は_設定した値と同じ後_公費２_請求額を返す() {
            business = sut.set後_公費２_請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費２_請求額).build();
            assertThat(business.get後_公費２_請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費２_請求額));
        }

        @Test
        public void 戻り値の後_公費２_本人負担月額は_設定した値と同じ後_公費２_本人負担月額を返す() {
            business = sut.set後_公費２_本人負担月額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費２_本人負担月額).build();
            assertThat(business.get後_公費２_本人負担月額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費２_本人負担月額));
        }

        @Test
        public void 戻り値の後_公費３_負担額合計は_設定した値と同じ後_公費３_負担額合計を返す() {
            business = sut.set後_公費３_負担額合計(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費３_負担額合計).build();
            assertThat(business.get後_公費３_負担額合計(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費３_負担額合計));
        }

        @Test
        public void 戻り値の後_公費３_請求額は_設定した値と同じ後_公費３_請求額を返す() {
            business = sut.set後_公費３_請求額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費３_請求額).build();
            assertThat(business.get後_公費３_請求額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費３_請求額));
        }

        @Test
        public void 戻り値の後_公費３_本人負担月額は_設定した値と同じ後_公費３_本人負担月額を返す() {
            business = sut.set後_公費３_本人負担月額(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費３_本人負担月額).build();
            assertThat(business.get後_公費３_本人負担月額(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_後_公費３_本人負担月額));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            business = sut.set再審査回数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_再審査回数).build();
            assertThat(business.get再審査回数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            business = sut.set過誤回数(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_過誤回数).build();
            assertThat(business.get過誤回数(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_取込年月));
        }

    }
}
