/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.syokanbaraishikyukettekyufujssekihensyu;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuHi.ServiceKeikakuHiRealtEntity;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraishikyukettekyufujssekihensyu.KyufujissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3034ShokanShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3036ShokanHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3038ShokanKihonEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3039ShokanMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3041ShokanTokuteiShinryohiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3043ShokanShokujiHiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3053ShokanShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3107ShokanMeisaiJushochiTokureiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3039ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3040ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3041ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3017KyufujissekiKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3018KyufujissekiMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3019KyufujissekiKinkyuShisetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3020KyufujissekiTokuteiSinryohiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3022KyufujissekiShokujiHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3025KyufujissekiKyotakuServiceDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3033KyufujissekiShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3106KyufujissekiMeisaiJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 * {link SyokanbaraiShikyuKetteKyufuJssekiHensyuManager}のテストクラスです。
 */
public class SyokanbaraiShikyuKetteKyufuJssekiHensyuManagerTest extends DbcTestBase {

    private static DbT4001JukyushaDaichoDac 受給者台帳Dac;
    private static DbT3118ShikibetsuNoKanriDac 識別番号管理Dac;
    private static DbT3017KyufujissekiKihonDac 給付実績基本Dac;
    private static DbT3018KyufujissekiMeisaiDac 給付実績明細Dac;
    private static DbT3106KyufujissekiMeisaiJushochiTokureiDac 住所地特例Dac;
    private static DbT3019KyufujissekiKinkyuShisetsuRyoyoDac 給付実績緊急時施設療養Dac;
    private static DbT3020KyufujissekiTokuteiSinryohiDac 給付実績特定診療費Dac;
    private static DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac 特別療養費Dac;
    private static DbT3022KyufujissekiShokujiHiyoDac 給付実績食事費用Dac;
    private static DbT3025KyufujissekiKyotakuServiceDac 給付実績居宅サービス計画費Dac;
    private static DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoDac 給付実績特定入所者介護サービス費用Dac;
    private static DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuDac 給付実績社会福祉法人軽減額Dac;
    private static DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoDac 給付実績所定疾患施設療養費等Dac;
    private static DbT3033KyufujissekiShukeiDac 給付実績集計Dac;
    private static SyokanbaraiShikyuKetteKyufuJssekiHensyuManager sut;

    @Before
    public void test() {
        受給者台帳Dac = mock(DbT4001JukyushaDaichoDac.class);
        識別番号管理Dac = mock(DbT3118ShikibetsuNoKanriDac.class);
        給付実績基本Dac = mock(DbT3017KyufujissekiKihonDac.class);
        給付実績明細Dac = mock(DbT3018KyufujissekiMeisaiDac.class);
        住所地特例Dac = mock(DbT3106KyufujissekiMeisaiJushochiTokureiDac.class);
        給付実績緊急時施設療養Dac = mock(DbT3019KyufujissekiKinkyuShisetsuRyoyoDac.class);
        給付実績特定診療費Dac = mock(DbT3020KyufujissekiTokuteiSinryohiDac.class);
        特別療養費Dac = mock(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac.class);
        給付実績食事費用Dac = mock(DbT3022KyufujissekiShokujiHiyoDac.class);
        給付実績居宅サービス計画費Dac = mock(DbT3025KyufujissekiKyotakuServiceDac.class);
        給付実績特定入所者介護サービス費用Dac = mock(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoDac.class);
        給付実績社会福祉法人軽減額Dac = mock(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuDac.class);
        給付実績所定疾患施設療養費等Dac = mock(DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoDac.class);
        給付実績集計Dac = mock(DbT3033KyufujissekiShukeiDac.class);
        sut = new SyokanbaraiShikyuKetteKyufuJssekiHensyuManager(受給者台帳Dac, 識別番号管理Dac,
                給付実績基本Dac, 給付実績明細Dac,
                住所地特例Dac, 給付実績緊急時施設療養Dac, 給付実績特定診療費Dac, 特別療養費Dac, 給付実績食事費用Dac,
                給付実績居宅サービス計画費Dac, 給付実績特定入所者介護サービス費用Dac, 給付実績社会福祉法人軽減額Dac,
                給付実績所定疾患施設療養費等Dac, 給付実績集計Dac);
    }

    DbT3038ShokanKihonEntity DbT3038entity = DbT3038ShokanKihonEntityGenerator.createDbT3038ShokanKihonEntity();
    DbT3034ShokanShinseiEntity DbT3034entity = DbT3034ShokanShinseiEntityGenerator.createDbT3034ShokanShinseiEntity();
    DbT3036ShokanHanteiKekkaEntity DbT3036entity
            = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
    List<DbT3039ShokanMeisaiEntity> DbT3039entityList
            = Arrays.asList(DbT3039ShokanMeisaiEntityGenerator.createDbT3039ShokanMeisaiEntity());
    List<DbT3107ShokanMeisaiJushochiTokureiEntity> DbT3107entityList
            = Arrays.asList(DbT3107ShokanMeisaiJushochiTokureiEntityGenerator
                    .createDbT3107ShokanMeisaiJushochiTokureiEntity());
    List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> DbT3040entityList
            = Arrays.asList(DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator
                    .createDbT3040ShokanKinkyuShisetsuRyoyoEntity());
    List<DbT3041ShokanTokuteiShinryohiEntity> DbT3041entityList
            = Arrays.asList(DbT3041ShokanTokuteiShinryohiEntityGenerator.createDbT3041ShokanTokuteiShinryohiEntity());
    List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> DbT3042entityList
            = Arrays.asList(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntityGenerator
                    .createDbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity());
    List<DbT3043ShokanShokujiHiyoEntity> DbT3043entityList
            = Arrays.asList(DbT3043ShokanShokujiHiyoEntityGenerator.createDbT3043ShokanShokujiHiyoEntity());
    ServiceKeikakuHiRealtEntity 償還払請求サービス;
    List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> DbT3050entityList
            = Arrays.asList(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntityGenerator
                    .createDbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity());
    List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> DbT3051entityList
            = Arrays.asList(DbT3051ShokanShakaiFukushiHojinKeigengakuEntityGenerator
                    .createDbT3051ShokanShakaiFukushiHojinKeigengakuEntity());
    List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> DbT3052entityList
            = Arrays.asList(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntityGenerator
                    .createDbT3052ShokanShoteiShikkanShisetsuRyoyoEntity());
    List<DbT3053ShokanShukeiEntity> DbT3053entityList
            = Arrays.asList(DbT3053ShokanShukeiEntityGenerator.createDbT3053ShokanShukeiEntity());
    KyufujissekiEntity entity = new KyufujissekiEntity(DbT3038entity, DbT3034entity, DbT3036entity,
            DbT3039entityList, DbT3107entityList, DbT3040entityList, DbT3041entityList,
            DbT3042entityList, DbT3043entityList, null, DbT3050entityList, DbT3051entityList,
            DbT3052entityList, DbT3053entityList);

    @Test
    public void service() {
        RString 画面モード = new RString("登録");
        ShikibetsuCode 識別コード = new ShikibetsuCode("1111");
        RString 修正前支給区分 = null;
        sut.dealKyufujisseki(画面モード, 識別コード, entity, 修正前支給区分);
    }

}
