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
 * {@link KyufujissekiShukei}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiShukeiTest extends DbcTestBase {

    private static DbT3033KyufujissekiShukeiEntity KyufujissekiShukeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3033KyufujissekiShukeiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiShukei sut;

        @Before
        public void setUp() {
            KyufujissekiShukeiEntity = DbT3033KyufujissekiShukeiEntityGenerator.createDbT3033KyufujissekiShukeiEntity();
            KyufujissekiShukeiEntity.setXXX(主キー名1);
            KyufujissekiShukeiEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiShukei(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiShukei(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3033KyufujissekiShukeiEntityにセットされている() {
            sut = new KyufujissekiShukei(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiShukeiIdentifierにセットされている() {
            sut = new KyufujissekiShukei(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiShukei sut;

        @Before
        public void setUp() {
            KyufujissekiShukeiEntity = DbT3033KyufujissekiShukeiEntityGenerator.createDbT3033KyufujissekiShukeiEntity();
            KyufujissekiShukeiEntity.setXXX(主キー名1);
            KyufujissekiShukeiEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiShukei(null);
        }

        @Test
        public void 指定したDbT3033KyufujissekiShukeiEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiShukei(KyufujissekiShukeiEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiShukei sut;

        @Before
        public void setUp() {
            KyufujissekiShukeiEntity = DbT3033KyufujissekiShukeiEntityGenerator.createDbT3033KyufujissekiShukeiEntity();
            KyufujissekiShukeiEntity.setXXX(主キー名1);
            KyufujissekiShukeiEntity.setXXX(主キー名2);

            sut = new KyufujissekiShukei(KyufujissekiShukeiEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiShukeiEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiShukeiEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiShukeiEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiShukeiEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiShukeiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiShukeiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufujissekiShukeiEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiShukeiEntity.getToshiNo()));
        }

        @Test
        public void getサービス種類コードは_entityが持つサービス種類コードを返す() {
            assertThat(sut.getサービス種類コード(), is(KyufujissekiShukeiEntity.getServiceSyuruiCode()));
        }

        @Test
        public void getサービス実日数は_entityが持つサービス実日数を返す() {
            assertThat(sut.getサービス実日数(), is(KyufujissekiShukeiEntity.getServiceJitsunissu()));
        }

        @Test
        public void get計画単位数は_entityが持つ計画単位数を返す() {
            assertThat(sut.get計画単位数(), is(KyufujissekiShukeiEntity.getPlanTanisu()));
        }

        @Test
        public void get限度額管理対象単位数は_entityが持つ限度額管理対象単位数を返す() {
            assertThat(sut.get限度額管理対象単位数(), is(KyufujissekiShukeiEntity.getGendogakuKanriTaishoTanisu()));
        }

        @Test
        public void get限度額管理対象外単位数は_entityが持つ限度額管理対象外単位数を返す() {
            assertThat(sut.get限度額管理対象外単位数(), is(KyufujissekiShukeiEntity.getGendogakuKanritaishogaiTanisu()));
        }

        @Test
        public void get短期入所計画日数は_entityが持つ短期入所計画日数を返す() {
            assertThat(sut.get短期入所計画日数(), is(KyufujissekiShukeiEntity.getTankiNyushoPlanNissu()));
        }

        @Test
        public void get短期入所実日数は_entityが持つ短期入所実日数を返す() {
            assertThat(sut.get短期入所実日数(), is(KyufujissekiShukeiEntity.getTankiNyushoJitsunissu()));
        }

        @Test
        public void get保険・単位数合計は_entityが持つ保険・単位数合計を返す() {
            assertThat(sut.get保険・単位数合計(), is(KyufujissekiShukeiEntity.getHokenTanisuTotal()));
        }

        @Test
        public void get保険・単位数単価は_entityが持つ保険・単位数単価を返す() {
            assertThat(sut.get保険・単位数単価(), is(KyufujissekiShukeiEntity.getHokenTanisuTani()));
        }

        @Test
        public void get保険・請求額は_entityが持つ保険・請求額を返す() {
            assertThat(sut.get保険・請求額(), is(KyufujissekiShukeiEntity.getHokenSeikyugaku()));
        }

        @Test
        public void get保険・利用者負担額は_entityが持つ保険・利用者負担額を返す() {
            assertThat(sut.get保険・利用者負担額(), is(KyufujissekiShukeiEntity.getHokenRiyoshaFutangaku()));
        }

        @Test
        public void get公費１・単位数合計は_entityが持つ公費１・単位数合計を返す() {
            assertThat(sut.get公費１・単位数合計(), is(KyufujissekiShukeiEntity.getKohi1TanisuTotal()));
        }

        @Test
        public void get公費１・請求額は_entityが持つ公費１・請求額を返す() {
            assertThat(sut.get公費１・請求額(), is(KyufujissekiShukeiEntity.getKohi1Seikyugaku()));
        }

        @Test
        public void get公費１・本人負担額は_entityが持つ公費１・本人負担額を返す() {
            assertThat(sut.get公費１・本人負担額(), is(KyufujissekiShukeiEntity.getKohi1HonninFutangaku()));
        }

        @Test
        public void get公費２・単位数合計は_entityが持つ公費２・単位数合計を返す() {
            assertThat(sut.get公費２・単位数合計(), is(KyufujissekiShukeiEntity.getKohi2TanisuTotal()));
        }

        @Test
        public void get公費２・請求額は_entityが持つ公費２・請求額を返す() {
            assertThat(sut.get公費２・請求額(), is(KyufujissekiShukeiEntity.getKohi2Seikyugaku()));
        }

        @Test
        public void get公費２・本人負担額は_entityが持つ公費２・本人負担額を返す() {
            assertThat(sut.get公費２・本人負担額(), is(KyufujissekiShukeiEntity.getKohi2HonninFutangaku()));
        }

        @Test
        public void get公費３・単位数合計は_entityが持つ公費３・単位数合計を返す() {
            assertThat(sut.get公費３・単位数合計(), is(KyufujissekiShukeiEntity.getKohi3TanisuTotal()));
        }

        @Test
        public void get公費３・請求額は_entityが持つ公費３・請求額を返す() {
            assertThat(sut.get公費３・請求額(), is(KyufujissekiShukeiEntity.getKohi3Seikyugaku()));
        }

        @Test
        public void get公費３・本人負担額は_entityが持つ公費３・本人負担額を返す() {
            assertThat(sut.get公費３・本人負担額(), is(KyufujissekiShukeiEntity.getKohi3HonninFutangaku()));
        }

        @Test
        public void get保険・出来高単位数合計は_entityが持つ保険・出来高単位数合計を返す() {
            assertThat(sut.get保険・出来高単位数合計(), is(KyufujissekiShukeiEntity.getHokenDekidakaTanisuTotal()));
        }

        @Test
        public void get保険・出来高請求額は_entityが持つ保険・出来高請求額を返す() {
            assertThat(sut.get保険・出来高請求額(), is(KyufujissekiShukeiEntity.getHokenDekidakaSeikyugaku()));
        }

        @Test
        public void get保険・出来高医療費利用者負担額は_entityが持つ保険・出来高医療費利用者負担額を返す() {
            assertThat(sut.get保険・出来高医療費利用者負担額(), is(KyufujissekiShukeiEntity.getHokenDekidakaIryohiRiyoshaFutangaku()));
        }

        @Test
        public void get公費１・出来高単位数合計は_entityが持つ公費１・出来高単位数合計を返す() {
            assertThat(sut.get公費１・出来高単位数合計(), is(KyufujissekiShukeiEntity.getKohi1DekidakaTanisuTotal()));
        }

        @Test
        public void get公費１・出来高請求額は_entityが持つ公費１・出来高請求額を返す() {
            assertThat(sut.get公費１・出来高請求額(), is(KyufujissekiShukeiEntity.getKohi1DekidakaSeikyugaku()));
        }

        @Test
        public void get公費１・出来高医療費利用者負担額は_entityが持つ公費１・出来高医療費利用者負担額を返す() {
            assertThat(sut.get公費１・出来高医療費利用者負担額(), is(KyufujissekiShukeiEntity.getKohi1DekidakaIryohiRiyoshaFutangaku()));
        }

        @Test
        public void get公費２・出来高単位数合計は_entityが持つ公費２・出来高単位数合計を返す() {
            assertThat(sut.get公費２・出来高単位数合計(), is(KyufujissekiShukeiEntity.getKohi2DekidakaTanisuTotal()));
        }

        @Test
        public void get公費２・出来高請求額は_entityが持つ公費２・出来高請求額を返す() {
            assertThat(sut.get公費２・出来高請求額(), is(KyufujissekiShukeiEntity.getKohi2DekidakaSeikyugaku()));
        }

        @Test
        public void get公費２・出来高医療費本人負担額は_entityが持つ公費２・出来高医療費本人負担額を返す() {
            assertThat(sut.get公費２・出来高医療費本人負担額(), is(KyufujissekiShukeiEntity.getKohi2DekidakaIryohiRiyoshaFutangaku()));
        }

        @Test
        public void get公費３・出来高単位数合計は_entityが持つ公費３・出来高単位数合計を返す() {
            assertThat(sut.get公費３・出来高単位数合計(), is(KyufujissekiShukeiEntity.getKohi3DekidakaTanisuTotal()));
        }

        @Test
        public void get公費３・出来高請求額は_entityが持つ公費３・出来高請求額を返す() {
            assertThat(sut.get公費３・出来高請求額(), is(KyufujissekiShukeiEntity.getKohi3DekidakaSeikyugaku()));
        }

        @Test
        public void get公費３・出来高医療費本人負担額は_entityが持つ公費３・出来高医療費本人負担額を返す() {
            assertThat(sut.get公費３・出来高医療費本人負担額(), is(KyufujissekiShukeiEntity.getKohi3DekidakaIryohiRiyoshaFutangaku()));
        }

        @Test
        public void get後・短期入所実日数は_entityが持つ後・短期入所実日数を返す() {
            assertThat(sut.get後・短期入所実日数(), is(KyufujissekiShukeiEntity.getAtoTankiNyushoJitsunissu()));
        }

        @Test
        public void get後・単位数合計は_entityが持つ後・単位数合計を返す() {
            assertThat(sut.get後・単位数合計(), is(KyufujissekiShukeiEntity.getAtoHokenTanisuTotal()));
        }

        @Test
        public void get後・保険請求分請求額は_entityが持つ後・保険請求分請求額を返す() {
            assertThat(sut.get後・保険請求分請求額(), is(KyufujissekiShukeiEntity.getAtoHokenSeikyugaku()));
        }

        @Test
        public void get後・公費１・単位数合計は_entityが持つ後・公費１・単位数合計を返す() {
            assertThat(sut.get後・公費１・単位数合計(), is(KyufujissekiShukeiEntity.getAtoKohi1TanisuTotal()));
        }

        @Test
        public void get後・公費１・請求額は_entityが持つ後・公費１・請求額を返す() {
            assertThat(sut.get後・公費１・請求額(), is(KyufujissekiShukeiEntity.getAtoKohi1Seikyugaku()));
        }

        @Test
        public void get後・公費２・単位数合計は_entityが持つ後・公費２・単位数合計を返す() {
            assertThat(sut.get後・公費２・単位数合計(), is(KyufujissekiShukeiEntity.getAtoKohi2TanisuTotal()));
        }

        @Test
        public void get後・公費２・請求額は_entityが持つ後・公費２・請求額を返す() {
            assertThat(sut.get後・公費２・請求額(), is(KyufujissekiShukeiEntity.getAtoKohi2Seikyugaku()));
        }

        @Test
        public void get後・公費３・単位数合計は_entityが持つ後・公費３・単位数合計を返す() {
            assertThat(sut.get後・公費３・単位数合計(), is(KyufujissekiShukeiEntity.getAtoKohi3TanisuTotal()));
        }

        @Test
        public void get後・公費３・請求額は_entityが持つ後・公費３・請求額を返す() {
            assertThat(sut.get後・公費３・請求額(), is(KyufujissekiShukeiEntity.getAtoKohi3Seikyugaku()));
        }

        @Test
        public void get後・保険・出来高単位数合計は_entityが持つ後・保険・出来高単位数合計を返す() {
            assertThat(sut.get後・保険・出来高単位数合計(), is(KyufujissekiShukeiEntity.getAtoHokenDekidakaTanisuTotal()));
        }

        @Test
        public void get後・保険・出来高請求額は_entityが持つ後・保険・出来高請求額を返す() {
            assertThat(sut.get後・保険・出来高請求額(), is(KyufujissekiShukeiEntity.getAtoHokenDekidakaSeikyugaku()));
        }

        @Test
        public void get後・公費１・出来高単位数合計は_entityが持つ後・公費１・出来高単位数合計を返す() {
            assertThat(sut.get後・公費１・出来高単位数合計(), is(KyufujissekiShukeiEntity.getAtoKohi1DekidakaTanisuTotal()));
        }

        @Test
        public void get後・公費１・出来高請求額は_entityが持つ後・公費１・出来高請求額を返す() {
            assertThat(sut.get後・公費１・出来高請求額(), is(KyufujissekiShukeiEntity.getAtoKohi1DekidakaSeikyugaku()));
        }

        @Test
        public void get後・公費２・出来高単位数合計は_entityが持つ後・公費２・出来高単位数合計を返す() {
            assertThat(sut.get後・公費２・出来高単位数合計(), is(KyufujissekiShukeiEntity.getAtoKohi2DekidakaTanisuTotal()));
        }

        @Test
        public void get後・公費２・出来高請求額は_entityが持つ後・公費２・出来高請求額を返す() {
            assertThat(sut.get後・公費２・出来高請求額(), is(KyufujissekiShukeiEntity.getAtoKohi2DekidakaSeikyugaku()));
        }

        @Test
        public void get後・公費３・出来高単位数合計は_entityが持つ後・公費３・出来高単位数合計を返す() {
            assertThat(sut.get後・公費３・出来高単位数合計(), is(KyufujissekiShukeiEntity.getAtoKohi3DekidakaTanisuTotal()));
        }

        @Test
        public void get後・公費３・出来高請求額は_entityが持つ後・公費３・出来高請求額を返す() {
            assertThat(sut.get後・公費３・出来高請求額(), is(KyufujissekiShukeiEntity.getAtoKohi3DekidakaSeikyugaku()));
        }

        @Test
        public void get再審査回数は_entityが持つ再審査回数を返す() {
            assertThat(sut.get再審査回数(), is(KyufujissekiShukeiEntity.getSaishinsaKaisu()));
        }

        @Test
        public void get過誤回数は_entityが持つ過誤回数を返す() {
            assertThat(sut.get過誤回数(), is(KyufujissekiShukeiEntity.getKagoKaisu()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufujissekiShukeiEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufujissekiShukeiEntity.getSeiriNo()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufujissekiShukeiEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufujissekiShukei sut;

        @Before
        public void setUp() {
            KyufujissekiShukeiEntity = DbT3033KyufujissekiShukeiEntityGenerator.createDbT3033KyufujissekiShukeiEntity();
            KyufujissekiShukeiEntity.setXXX(主キー名1);
            KyufujissekiShukeiEntity.setXXX(主キー名2);

            sut = new KyufujissekiShukei(KyufujissekiShukeiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiShukeiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufujissekiShukei sut;

        @Before
        public void setUp() {
            KyufujissekiShukeiEntity = DbT3033KyufujissekiShukeiEntityGenerator.createDbT3033KyufujissekiShukeiEntity();
            KyufujissekiShukeiEntity.setXXX(主キー名1);
            KyufujissekiShukeiEntity.setXXX(主キー名2);

            sut = new KyufujissekiShukei(KyufujissekiShukeiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufujissekiShukei sut;
        private static KyufujissekiShukei result;

        @Before
        public void setUp() {
            KyufujissekiShukeiEntity = DbT3033KyufujissekiShukeiEntityGenerator.createDbT3033KyufujissekiShukeiEntity();
            KyufujissekiShukeiEntity.setXXX(主キー名1);
            KyufujissekiShukeiEntity.setXXX(主キー名2);

        }

        @Test
        public void KyufujissekiShukeiが保持するDbT3033KyufujissekiShukeiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiShukeiが保持するDbT3033KyufujissekiShukeiEntityのEntityDataStateがDeletedに指定されたKyufujissekiShukeiが返る() {
            sut = TestSupport.setStateKyufujissekiShukei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiShukeiが保持するDbT3033KyufujissekiShukeiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiShukeiが保持するDbT3033KyufujissekiShukeiEntityのEntityDataStateがDeletedに指定されたKyufujissekiShukeiが返る() {
            sut = TestSupport.setStateKyufujissekiShukei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiShukeiが保持するDbT3033KyufujissekiShukeiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiShukeiが保持するDbT3033KyufujissekiShukeiEntityのEntityDataStateがDeletedに指定されたKyufujissekiShukeiが返る() {
            sut = TestSupport.setStateKyufujissekiShukei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiShukeiが保持するDbT3033KyufujissekiShukeiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiShukei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiShukei setStateKyufujissekiShukei(EntityDataState parentState) {
            KyufujissekiShukeiEntity.setState(parentState);
            return new KyufujissekiShukei(KyufujissekiShukeiEntity);
        }
    }
}
