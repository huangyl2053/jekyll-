/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.testhelper.DbcTestBase;
import static jp.co.ndensan.reams.db.dbc.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiTokuteiNyushosyaKaigoServiceHiyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiTokuteiNyushosyaKaigoServiceHiyoTest extends DbcTestBase {

    private static DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiTokuteiNyushosyaKaigoServiceHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.createDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityにセットされている() {
            sut = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiTokuteiNyushosyaKaigoServiceHiyoIdentifierにセットされている() {
            sut = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiTokuteiNyushosyaKaigoServiceHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.createDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(null);
        }

        @Test
        public void 指定したDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiTokuteiNyushosyaKaigoServiceHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.createDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名2);

            sut = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getToshiNo()));
        }

        @Test
        public void get特定入所者介護サービス費用情報レコード順次番号は_entityが持つ特定入所者介護サービス費用情報レコード順次番号を返す() {
            assertThat(sut.get特定入所者介護サービス費用情報レコード順次番号(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getRecodeJunjiNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getServiceSyuruiCode()));
        }

        @Test
        public void getサービス項目コードは_entityが持つサービス項目コードを返す() {
            assertThat(sut.getサービス項目コード(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getServiceKomokuCode()));
        }

        @Test
        public void get費用単価は_entityが持つ費用単価を返す() {
            assertThat(sut.get費用単価(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getHiyoTanka()));
        }

        @Test
        public void get負担限度額は_entityが持つ負担限度額を返す() {
            assertThat(sut.get負担限度額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getFutanGendogaku()));
        }

        @Test
        public void get日数は_entityが持つ日数を返す() {
            assertThat(sut.get日数(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getNissu()));
        }

        @Test
        public void get公費１日数は_entityが持つ公費１日数を返す() {
            assertThat(sut.get公費１日数(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi1Nissu()));
        }

        @Test
        public void get公費２日数は_entityが持つ公費２日数を返す() {
            assertThat(sut.get公費２日数(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi2Nissu()));
        }

        @Test
        public void get公費３日数は_entityが持つ公費３日数を返す() {
            assertThat(sut.get公費３日数(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi3Nissu()));
        }

        @Test
        public void get費用額は_entityが持つ費用額を返す() {
            assertThat(sut.get費用額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getHiyogaku()));
        }

        @Test
        public void get保険分請求額は_entityが持つ保険分請求額を返す() {
            assertThat(sut.get保険分請求額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getHokenbunSeikyugaku()));
        }

        @Test
        public void get公費１負担額（明細）は_entityが持つ公費１負担額（明細）を返す() {
            assertThat(sut.get公費１負担額（明細）(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi1Futangaku()));
        }

        @Test
        public void get公費２負担額（明細）は_entityが持つ公費２負担額（明細）を返す() {
            assertThat(sut.get公費２負担額（明細）(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi2Futangaku()));
        }

        @Test
        public void get公費３負担額（明細）は_entityが持つ公費３負担額（明細）を返す() {
            assertThat(sut.get公費３負担額（明細）(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi3Futangaku()));
        }

        @Test
        public void get利用者負担額は_entityが持つ利用者負担額を返す() {
            assertThat(sut.get利用者負担額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getRiyoshaFutangaku()));
        }

        @Test
        public void get費用額合計は_entityが持つ費用額合計を返す() {
            assertThat(sut.get費用額合計(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getHiyogakuTotal()));
        }

        @Test
        public void get保険分請求額合計は_entityが持つ保険分請求額合計を返す() {
            assertThat(sut.get保険分請求額合計(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getHokenbunSeikyugakuTotal()));
        }

        @Test
        public void get利用者負担額合計は_entityが持つ利用者負担額合計を返す() {
            assertThat(sut.get利用者負担額合計(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getRiyoshaFutangakuTotal()));
        }

        @Test
        public void get公費１・負担額合計は_entityが持つ公費１・負担額合計を返す() {
            assertThat(sut.get公費１・負担額合計(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi1FutangakuTotal()));
        }

        @Test
        public void get公費１・請求額は_entityが持つ公費１・請求額を返す() {
            assertThat(sut.get公費１・請求額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi1Seikyugaku()));
        }

        @Test
        public void get公費１・本人負担月額は_entityが持つ公費１・本人負担月額を返す() {
            assertThat(sut.get公費１・本人負担月額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi1HonninFutanGetsugaku()));
        }

        @Test
        public void get公費２・負担額合計は_entityが持つ公費２・負担額合計を返す() {
            assertThat(sut.get公費２・負担額合計(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi2FutangakuTotal()));
        }

        @Test
        public void get公費２・請求額は_entityが持つ公費２・請求額を返す() {
            assertThat(sut.get公費２・請求額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi2Seikyugaku()));
        }

        @Test
        public void get公費２・本人負担月額は_entityが持つ公費２・本人負担月額を返す() {
            assertThat(sut.get公費２・本人負担月額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi2HonninFutanGetsugaku()));
        }

        @Test
        public void get公費３・負担額合計は_entityが持つ公費３・負担額合計を返す() {
            assertThat(sut.get公費３・負担額合計(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi3FutangakuTotal()));
        }

        @Test
        public void get公費３・請求額は_entityが持つ公費３・請求額を返す() {
            assertThat(sut.get公費３・請求額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi3Seikyugaku()));
        }

        @Test
        public void get公費３・本人負担月額は_entityが持つ公費３・本人負担月額を返す() {
            assertThat(sut.get公費３・本人負担月額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKohi3HonninFutanGetsugaku()));
        }

        @Test
        public void get後・費用単価は_entityが持つ後・費用単価を返す() {
            assertThat(sut.get後・費用単価(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoHiyoTanka()));
        }

        @Test
        public void get後・日数は_entityが持つ後・日数を返す() {
            assertThat(sut.get後・日数(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoNissu()));
        }

        @Test
        public void get後・公費１日数は_entityが持つ後・公費１日数を返す() {
            assertThat(sut.get後・公費１日数(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi1Nissu()));
        }

        @Test
        public void get後・公費２日数は_entityが持つ後・公費２日数を返す() {
            assertThat(sut.get後・公費２日数(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi2Nissu()));
        }

        @Test
        public void get後・公費３日数は_entityが持つ後・公費３日数を返す() {
            assertThat(sut.get後・公費３日数(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi3Nissu()));
        }

        @Test
        public void get後・費用額は_entityが持つ後・費用額を返す() {
            assertThat(sut.get後・費用額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoHiyogaku()));
        }

        @Test
        public void get後・保険分請求額は_entityが持つ後・保険分請求額を返す() {
            assertThat(sut.get後・保険分請求額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoHokenbunSeikyugaku()));
        }

        @Test
        public void get後・公費１負担額（明細）は_entityが持つ後・公費１負担額（明細）を返す() {
            assertThat(sut.get後・公費１負担額（明細）(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi1Futangaku()));
        }

        @Test
        public void get後・公費２負担額（明細）は_entityが持つ後・公費２負担額（明細）を返す() {
            assertThat(sut.get後・公費２負担額（明細）(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi2Futangaku()));
        }

        @Test
        public void get後・公費３負担額（明細）は_entityが持つ後・公費３負担額（明細）を返す() {
            assertThat(sut.get後・公費３負担額（明細）(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi3Futangaku()));
        }

        @Test
        public void get後・利用者負担額は_entityが持つ後・利用者負担額を返す() {
            assertThat(sut.get後・利用者負担額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoRiyoshaFutangaku()));
        }

        @Test
        public void get後・費用額合計は_entityが持つ後・費用額合計を返す() {
            assertThat(sut.get後・費用額合計(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoHiyogakuTotal()));
        }

        @Test
        public void get後・保険分請求額合計は_entityが持つ後・保険分請求額合計を返す() {
            assertThat(sut.get後・保険分請求額合計(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoHokenbunSeikyugakuTotal()));
        }

        @Test
        public void get後・利用者負担額合計は_entityが持つ後・利用者負担額合計を返す() {
            assertThat(sut.get後・利用者負担額合計(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoRiyoshaFutangakuTotal()));
        }

        @Test
        public void get後・公費１・負担額合計は_entityが持つ後・公費１・負担額合計を返す() {
            assertThat(sut.get後・公費１・負担額合計(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi1FutangakuTotal()));
        }

        @Test
        public void get後・公費１・請求額は_entityが持つ後・公費１・請求額を返す() {
            assertThat(sut.get後・公費１・請求額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi1Seikyugaku()));
        }

        @Test
        public void get後・公費１・本人負担月額は_entityが持つ後・公費１・本人負担月額を返す() {
            assertThat(sut.get後・公費１・本人負担月額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi1HonninFutanGetsugaku()));
        }

        @Test
        public void get後・公費２・負担額合計は_entityが持つ後・公費２・負担額合計を返す() {
            assertThat(sut.get後・公費２・負担額合計(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi2FutangakuTotal()));
        }

        @Test
        public void get後・公費２・請求額は_entityが持つ後・公費２・請求額を返す() {
            assertThat(sut.get後・公費２・請求額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi2Seikyugaku()));
        }

        @Test
        public void get後・公費２・本人負担月額は_entityが持つ後・公費２・本人負担月額を返す() {
            assertThat(sut.get後・公費２・本人負担月額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi2HonninFutanGetsugaku()));
        }

        @Test
        public void get後・公費３・負担額合計は_entityが持つ後・公費３・負担額合計を返す() {
            assertThat(sut.get後・公費３・負担額合計(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi3FutangakuTotal()));
        }

        @Test
        public void get後・公費３・請求額は_entityが持つ後・公費３・請求額を返す() {
            assertThat(sut.get後・公費３・請求額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi3Seikyugaku()));
        }

        @Test
        public void get後・公費３・本人負担月額は_entityが持つ後・公費３・本人負担月額を返す() {
            assertThat(sut.get後・公費３・本人負担月額(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getAtoKohi3HonninFutanGetsugaku()));
        }

        @Test
        public void get再審査回数は_entityが持つ再審査回数を返す() {
            assertThat(sut.get再審査回数(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getSaishinsaKaisu()));
        }

        @Test
        public void get過誤回数は_entityが持つ過誤回数を返す() {
            assertThat(sut.get過誤回数(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getKagoKaisu()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getSeiriNo()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufujissekiTokuteiNyushosyaKaigoServiceHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.createDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名2);

            sut = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufujissekiTokuteiNyushosyaKaigoServiceHiyo sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.createDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名2);

            sut = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufujissekiTokuteiNyushosyaKaigoServiceHiyo sut;
        private static KyufujissekiTokuteiNyushosyaKaigoServiceHiyo result;

        @Before
        public void setUp() {
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity = DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityGenerator.createDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名1);
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setXXX(主キー名2);

        }

        @Test
        public void KyufujissekiTokuteiNyushosyaKaigoServiceHiyoが保持するDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiTokuteiNyushosyaKaigoServiceHiyoが保持するDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityのEntityDataStateがDeletedに指定されたKyufujissekiTokuteiNyushosyaKaigoServiceHiyoが返る() {
            sut = TestSupport.setStateKyufujissekiTokuteiNyushosyaKaigoServiceHiyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiTokuteiNyushosyaKaigoServiceHiyoが保持するDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiTokuteiNyushosyaKaigoServiceHiyoが保持するDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityのEntityDataStateがDeletedに指定されたKyufujissekiTokuteiNyushosyaKaigoServiceHiyoが返る() {
            sut = TestSupport.setStateKyufujissekiTokuteiNyushosyaKaigoServiceHiyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiTokuteiNyushosyaKaigoServiceHiyoが保持するDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiTokuteiNyushosyaKaigoServiceHiyoが保持するDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityのEntityDataStateがDeletedに指定されたKyufujissekiTokuteiNyushosyaKaigoServiceHiyoが返る() {
            sut = TestSupport.setStateKyufujissekiTokuteiNyushosyaKaigoServiceHiyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiTokuteiNyushosyaKaigoServiceHiyoが保持するDbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiTokuteiNyushosyaKaigoServiceHiyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiTokuteiNyushosyaKaigoServiceHiyo setStateKyufujissekiTokuteiNyushosyaKaigoServiceHiyo(EntityDataState parentState) {
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity.setState(parentState);
            return new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity);
        }
    }
}
