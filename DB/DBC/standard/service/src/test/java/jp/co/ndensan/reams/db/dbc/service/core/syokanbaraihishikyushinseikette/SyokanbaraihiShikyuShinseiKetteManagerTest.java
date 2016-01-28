/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.Dbt3034ShokanShinseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanKihonParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanKinkyuShisetsuRyoyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanMeisaiJushochiTokureiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanMeisaiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanServicePlanEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanServicePlanParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanFukushigengakuEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanShakaiFukushiHojinKeigengakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanShinseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanShokujiHiyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanShoteiShikkanShisetsuRyoyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanShukeiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanTokuteiNyushoshaKaigoServiceHiyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanTokuteiShinryohiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3038ShokanKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3039ShokanMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3040ShokanKinkyuShisetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3041ShokanTokuteiShinryohiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3043ShokanShokujiHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3045ShokanServicePlan200004Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3046ShokanServicePlan200604Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3047ShokanServicePlan200904Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3051ShokanShakaiFukushiHojinKeigengakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3052ShokanShoteiShikkanShisetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3107ShokanMeisaiJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7120TokuteiShinryoServiceCodeDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 * {link SyokanbaraihiShikyuShinseiKetteManager}のテストクラスです。
 */
public class SyokanbaraihiShikyuShinseiKetteManagerTest {

    private static DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac 償還払請求特定入所者介護サービス費用Dac;
    private static DbT3047ShokanServicePlan200904Dac 償還払請求サービス計画200904Dac;
    private static DbT3046ShokanServicePlan200604Dac 償還払請求サービス計画200604Dac;
    private static DbT3045ShokanServicePlan200004Dac 償還払請求サービス計画200004Dac;
    private static DbT3043ShokanShokujiHiyoDac 償還払請求食事費用Dac;
    private static DbT3053ShokanShukeiDac 償還払請求集計Dac;
    private static DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private static DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private static DbT7120TokuteiShinryoServiceCodeDac 特定診療サービスコードDac;
    private static DbT3038ShokanKihonDac 償還払請求基本Dac;
    private static DbT3107ShokanMeisaiJushochiTokureiDac 住所地特例Dac;
    private static DbT3039ShokanMeisaiDac 償還払請求明細Dac;
    private static DbT3041ShokanTokuteiShinryohiDac 償還払請求特定診療費Dac;
    private static DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac 特別療養費Dac;
    private static DbT3051ShokanShakaiFukushiHojinKeigengakuDac 償還払請求社会福祉法人軽減額Dac;
    private static DbT3052ShokanShoteiShikkanShisetsuRyoyoDac 償還払請求所定疾患施設療養費等Dac;
    private static DbT3040ShokanKinkyuShisetsuRyoyoDac 償還払請求緊急時施設療養Dac;
    private static DbT3118ShikibetsuNoKanriDac 識別番号管理Dac;
    private static SyokanbaraihiShikyuShinseiKetteManager sut;

    @Before
    public void test() {
        償還払請求特定入所者介護サービス費用Dac = mock(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac.class);
        償還払請求サービス計画200904Dac = mock(DbT3047ShokanServicePlan200904Dac.class);
        償還払請求サービス計画200604Dac = mock(DbT3046ShokanServicePlan200604Dac.class);
        償還払請求サービス計画200004Dac = mock(DbT3045ShokanServicePlan200004Dac.class);
        償還払請求食事費用Dac = mock(DbT3043ShokanShokujiHiyoDac.class);
        償還払請求集計Dac = mock(DbT3053ShokanShukeiDac.class);
        償還払支給判定結果Dac = mock(DbT3036ShokanHanteiKekkaDac.class);
        償還払支給申請Dac = mock(DbT3034ShokanShinseiDac.class);
        特定診療サービスコードDac = mock(DbT7120TokuteiShinryoServiceCodeDac.class);
        償還払請求基本Dac = mock(DbT3038ShokanKihonDac.class);
        住所地特例Dac = mock(DbT3107ShokanMeisaiJushochiTokureiDac.class);
        償還払請求明細Dac = mock(DbT3039ShokanMeisaiDac.class);
        償還払請求特定診療費Dac = mock(DbT3041ShokanTokuteiShinryohiDac.class);
        特別療養費Dac = mock(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac.class);
        償還払請求社会福祉法人軽減額Dac = mock(DbT3051ShokanShakaiFukushiHojinKeigengakuDac.class);
        償還払請求所定疾患施設療養費等Dac = mock(DbT3052ShokanShoteiShikkanShisetsuRyoyoDac.class);
        償還払請求緊急時施設療養Dac = mock(DbT3040ShokanKinkyuShisetsuRyoyoDac.class);
        識別番号管理Dac = mock(DbT3118ShikibetsuNoKanriDac.class);
        sut = new SyokanbaraihiShikyuShinseiKetteManager(償還払請求特定入所者介護サービス費用Dac,
                償還払請求サービス計画200904Dac, 償還払請求サービス計画200604Dac, 償還払請求サービス計画200004Dac,
                償還払請求食事費用Dac, 償還払請求集計Dac, 償還払支給判定結果Dac, 償還払支給申請Dac,
                特定診療サービスコードDac, 償還払請求基本Dac, 住所地特例Dac, 償還払請求明細Dac,
                償還払請求特定診療費Dac, 特別療養費Dac, 償還払請求社会福祉法人軽減額Dac,
                償還払請求所定疾患施設療養費等Dac, 償還払請求緊急時施設療養Dac, 識別番号管理Dac);
    }

    @Test
    public void getSyokanbaraiketteKekka_償還払支給判定結果取得() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("1");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("199001");
        RString 整理番号 = new RString("1");
        sut.getSyokanbaraiketteKekka(被保険者番号, サービス提供年月, 整理番号);
    }

    @Test
    public void getShikibetsuNoKanri1_証明書件数取得() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("201601");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        sut.getShikibetsuNoKanri(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号);
    }

    @Test
    public void getShikibetsuNoKanri2_証明書件数取得() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200301");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        sut.getShikibetsuNoKanri(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号);
    }

    @Test
    public void getShikibetsuNoKanri3_証明書件数取得() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        sut.getShikibetsuNoKanri(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号);
    }

    @Test
    public void getShikibetsuNoKanri_識別番号管理情報取得() {
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        RString 識別番号 = new RString("0001");
        sut.getShikibetsuNoKanri(サービス提供年月, 識別番号);
    }

    @Test
    public void insDbT3034ShokanShinsei_支給申請登録() {
        int 保険給付額 = 1;
        int 利用者給付額 = 1;
        int 口座ID = 1;
        ShokanShinseiParameter parameter = ShokanShinseiParameter.createSelectByKeyParam(new HihokenshaNo("000000003"),
                new FlexibleYearMonth("200701"),
                new RString("0000000003"),
                new HokenshaNo("00"),
                new FlexibleDate("200101"),
                new FlexibleDate("200101"),
                new RString("0000000003"),
                new RString("0000000003"),
                new RString("0000000003"),
                new RString("0000000003"),
                new Decimal(0),
                保険給付額,
                利用者給付額,
                new RString("0000000003"),
                new RString("0000000003"),
                true,
                new RString("0000000003"),
                new RString("0000000003"),
                new FlexibleDate("200101"),
                new FlexibleDate("200101"),
                new RString("0000000003"),
                new RString("0000000003"),
                口座ID,
                new RString("0000000003"));
        sut.insDbT3034ShokanShinsei(parameter);

    }

    @Test
    public void updDbT3034ShokanShinsei_支給申請更新() {
        int 保険給付額 = 1;
        int 利用者給付額 = 1;
        int 口座ID = 1;
        ShokanShinseiParameter parameter = ShokanShinseiParameter.createSelectByKeyParam(new HihokenshaNo("000000003"),
                new FlexibleYearMonth("200701"),
                new RString("0000000003"),
                new HokenshaNo("00"),
                new FlexibleDate("200101"),
                new FlexibleDate("200101"),
                new RString("0000000003"),
                new RString("0000000003"),
                new RString("0000000003"),
                new RString("0000000003"),
                new Decimal(0),
                保険給付額,
                利用者給付額,
                new RString("0000000003"),
                new RString("0000000003"),
                true,
                new RString("0000000003"),
                new RString("0000000003"),
                new FlexibleDate("200101"),
                new FlexibleDate("200101"),
                new RString("0000000003"),
                new RString("0000000003"),
                口座ID,
                new RString("0000000003"));
        sut.updDbT3034ShokanShinsei(parameter);

    }

    @Test
    public void delDbT3034ShokanShinsei_支給申請削除() {
        Dbt3034ShokanShinseiParameter parameter = Dbt3034ShokanShinseiParameter.createSelectByKeyParam(
                new HihokenshaNo("000000003"),
                new FlexibleYearMonth("200701"),
                new RString("0000000003"),
                new FlexibleDate("200101"),
                new RString("0000000003"),
                new Decimal(0),
                new Decimal(0),
                new FlexibleYearMonth("200701"),
                new ShikibetsuCode("111"),
                new RString("0000000003"));
        sut.delDbT3034ShokanShinsei(parameter);
    }

    @Test
    public void getShikibetsuNoKanri_証明書管理一覧取得() {
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        sut.getShikibetsuNoKanri(サービス提供年月);
    }

    @Test
    public void getShokanKihonCount_基本情報件数を取得() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        RString 明細番号 = new RString("111111112");
        sut.getShokanKihonCount(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    @Test
    public void getShokanMeisaiJushochiTokureiCount_給付費明細住特情報件数() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        RString 明細番号 = new RString("111111112");
        sut.getShokanMeisaiJushochiTokureiCount(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    @Test
    public void delShokanMeisaiCount_給付費明細情報件数() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        RString 明細番号 = new RString("111111112");
        sut.delShokanMeisaiCount(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    @Test
    public void updShokanTokuteiShinryohi_特定診療費情報件数取得() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        RString 明細番号 = new RString("111111112");
        sut.updShokanTokuteiShinryohi(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    @Test
    public void updShokanTokuteiNyushoshaKaigoServiceHiyo_特定入所者費用情報件数取得() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        RString 明細番号 = new RString("111111112");
        sut.updShokanTokuteiNyushoshaKaigoServiceHiyo(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号, 明細番号);
    }

    @Test
    public void updShokanShakaiFukushiHojinKeigengaku_社福軽減額情報件数取得() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        RString 明細番号 = new RString("111111112");
        sut.updShokanShakaiFukushiHojinKeigengaku(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号, 明細番号);
    }

    @Test
    public void updShokanShoteiShikkanShisetsuRyoyo_緊急時所定疾患情報件数取得() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        RString 明細番号 = new RString("111111112");
        sut.updShokanShoteiShikkanShisetsuRyoyo(被保険者番号, サービス提供年月, 整理番号, 事業者番号,
                様式番号, 明細番号);
    }

    @Test
    public void updShokanKinkyuShisetsuRyoyo_緊急時施設療養費情報件数取得() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        RString 明細番号 = new RString("111111112");
        sut.updShokanKinkyuShisetsuRyoyo(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    @Test
    public void updShokanShukei_請求額集計情報件数取得() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        RString 明細番号 = new RString("111111112");
        sut.updShokanShukei(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    @Test
    public void updShokanShokujiHiyo_食事費用情報件数取得() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000003");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("200701");
        RString 整理番号 = new RString("0000000003");
        JigyoshaNo 事業者番号 = new JigyoshaNo("1111");
        RString 様式番号 = new RString("0000000003");
        RString 明細番号 = new RString("111111112");
        sut.updShokanShokujiHiyo(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    @Test
    public void delShokanSyomeisyoTest() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("000000006");
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("201601");
        RString 整理番号 = new RString("0000000006");
        JigyoshaNo 事業者番号 = new JigyoshaNo("0000000006");
        RString 様式番号 = new RString("0006");
        RString 明細番号 = new RString("0006");
        sut.delShokanSyomeisyo(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    @Test
    public void getShikibetsuBangoIchiranTest() {
        ServiceShuruiCode 特定診療のサービス種類コード = new ServiceShuruiCode(new RString("00"));
        ServiceKomokuCode 識別コード2 = new ServiceKomokuCode(new RString("11"));
        FlexibleYearMonth 基準年月 = new FlexibleYearMonth(new RString("201406"));
        sut.getShikibetsuBangoIchiran(特定診療のサービス種類コード, 識別コード2, 基準年月);
    }

    @Test
    public void updShokanKihonTest() {
        RString 明細番号;
        RString DEFAULT_明細番号 = new RString("0001");
        HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("3321");
        ShokanKihonParameter paramter = ShokanKihonParameter.createSelectByKeyParam(HihokenshaNo.EMPTY,
                FlexibleYearMonth.MAX, RString.EMPTY, JigyoshaNo.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, FlexibleDate.MAX,
                FlexibleDate.EMPTY, RString.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX, Decimal.ZERO,
                Decimal.ZERO, RString.EMPTY, HokenKyufuRitsu.ZERO);
        明細番号 = sut.updShokanKihon(paramter);
        assertThat(明細番号, is(DEFAULT_明細番号));

        DEFAULT_明細番号 = new RString("002");
        ShokanKihonParameter paramter1 = ShokanKihonParameter.createSelectByKeyParam(DEFAULT_被保険者番号,
                FlexibleYearMonth.MAX, RString.EMPTY, JigyoshaNo.EMPTY, RString.EMPTY, DEFAULT_明細番号,
                RString.EMPTY, RString.EMPTY, FlexibleDate.MAX,
                FlexibleDate.EMPTY, RString.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX, Decimal.ZERO,
                Decimal.ZERO, RString.EMPTY, HokenKyufuRitsu.ZERO);
        明細番号 = sut.updShokanKihon(paramter1);
        assertThat(明細番号, is(DEFAULT_明細番号));
    }

    @Test
    public void updShokanMeisaiJushochiTokureiTest() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("131");
        FlexibleYearMonth 提供購入年月 = new FlexibleYearMonth("198801");
        RString 整理番号 = new RString("001");
        JigyoshaNo 事業者番号 = new JigyoshaNo("31");
        RString 証明書コード = new RString("321");
        RString 明細番号 = new RString("23");

        RString 連番;
        RString サービスコード;
        Decimal 単位;
        Decimal 回数日数;
        int サービス単位;
        ShoKisaiHokenshaNo 施設所在保険者番号;
        RString 摘要;
        RString 状態;
        ShokanMeisaiJushochiTokureiEntity entity;
        List<ShokanMeisaiJushochiTokureiEntity> 給付費明細住特List = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            連番 = new RString("22");
            サービスコード = new RString("221245");
            単位 = new Decimal("32");
            回数日数 = new Decimal("32");
            サービス単位 = 33;
            施設所在保険者番号 = new ShoKisaiHokenshaNo("33");
            摘要 = new RString("22");
            状態 = new RString("");
            if (i == 1 || i == 3) {
                状態 = new RString("登録");
            }
            if (i == 2 || i == 5) {
                状態 = new RString("修正");
            }
            if (i == 4) {
                状態 = new RString("削除");
            }
            entity = ShokanMeisaiJushochiTokureiEntity.createSelectByKeyParam(連番,
                    サービスコード, 単位, 回数日数, サービス単位, 施設所在保険者番号, 摘要, 状態);
            給付費明細住特List.add(entity);
        }
        ShokanMeisaiJushochiTokureiParameter parameter
                = ShokanMeisaiJushochiTokureiParameter.createSelectByKeyParam(被保険者番号,
                        提供購入年月, 整理番号, 事業者番号, 証明書コード, 明細番号, 給付費明細住特List);
        sut.updShokanMeisaiJushochiTokurei(parameter);
    }

    @Test
    public void updShokanMeisaiTest() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("131");
        FlexibleYearMonth 提供購入年月 = new FlexibleYearMonth("198801");
        RString 整理番号 = new RString("001");
        JigyoshaNo 事業者番号 = new JigyoshaNo("31");
        RString 証明書コード = new RString("321");
        RString 明細番号 = new RString("23");

        RString 連番;
        RString サービスコード;
        Decimal 単位;
        Decimal 回数日数;
        int サービス単位;
        RString 摘要;
        RString 状態;
        ShokanMeisaiEntity entity;
        List<ShokanMeisaiEntity> 給付費明細List = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            連番 = new RString("22");
            サービスコード = new RString("221245");
            単位 = new Decimal("32");
            回数日数 = new Decimal("32");
            サービス単位 = 33;
            摘要 = new RString("22");
            状態 = new RString("");
            if (i == 1 || i == 3) {
                状態 = new RString("登録");
            }
            if (i == 2 || i == 5) {
                状態 = new RString("修正");
            }
            if (i == 4) {
                状態 = new RString("削除");
            }
            entity = ShokanMeisaiEntity.createSelectByKeyParam(連番, サービスコード,
                    単位, 回数日数, サービス単位, 摘要, 状態);
            給付費明細List.add(entity);
        }
        ShokanMeisaiParameter parameter = ShokanMeisaiParameter.createSelectByKeyParam(被保険者番号,
                提供購入年月, 整理番号, 事業者番号, 証明書コード, 明細番号, 給付費明細List);
        sut.updShokanMeisai(parameter);
    }

    @Test
    public void updShokanTokuteiShinryohiTest() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("131");
        FlexibleYearMonth 提供購入年月 = new FlexibleYearMonth("198801");
        RString 整理番号 = new RString("001");
        JigyoshaNo 事業者番号 = new JigyoshaNo("31");
        RString 証明書コード = new RString("321");
        RString 明細番号 = new RString("23");

        RString 連番;
        RString 傷病名;
        int 指導管理;
        int エックス線;
        int リハビリ;
        int 精神科;
        int その他1;
        int その他2;
        int 合計;
        RString 識別コード;
        Decimal 単位;
        Decimal 回数日数;
        int サービス単位;
        ShoKisaiHokenshaNo 施設所在保険者番号;
        RString 摘要;
        RString 状態;
        ShokanTokuteiShinryohiEntity entity;
        List<ShokanTokuteiShinryohiEntity> 特定診療費List = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            連番 = new RString("22");
            傷病名 = new RString("傷病名");
            指導管理 = 1;
            エックス線 = 2;
            リハビリ = 3;
            精神科 = 4;
            その他1 = 5;
            その他2 = 6;
            合計 = 7;
            識別コード = new RString("322");
            単位 = new Decimal("32");
            回数日数 = new Decimal("32");
            サービス単位 = 33;
            施設所在保険者番号 = new ShoKisaiHokenshaNo("98");
            摘要 = new RString("22");
            状態 = new RString("");
            if (i == 1 || i == 3) {
                状態 = new RString("登録");
            }
            if (i == 2 || i == 5) {
                状態 = new RString("修正");
            }
            if (i == 4) {
                状態 = new RString("削除");
            }
            entity = ShokanTokuteiShinryohiEntity.createSelectByKeyParam(連番, 傷病名, 指導管理, エックス線, リハビリ,
                    精神科, その他1, その他2, 合計, 識別コード, 単位,
                    回数日数, サービス単位, 施設所在保険者番号, 摘要, 状態);
            特定診療費List.add(entity);
        }
        ShokanTokuteiShinryohiParameter parameter
                = ShokanTokuteiShinryohiParameter.createSelectByKeyParam(被保険者番号,
                        提供購入年月, 整理番号, 事業者番号, 証明書コード, 明細番号, 特定診療費List);
        sut.updShokanTokuteiShinryohi(parameter);
    }

    @Test
    public void updShokanServicePlanTest() {
        RString 明細番号test;
        HihokenshaNo 被保険者番号 = new HihokenshaNo("131");
        FlexibleYearMonth 提供購入年月;
        RString 整理番号 = new RString("001");
        JigyoshaNo 事業者番号 = new JigyoshaNo("31");
        RString 証明書コード = new RString("321");
        RString 明細番号;
        RString 連番 = new RString("004");
        RString 事業者区分コード = new RString("014");
        FlexibleDate 届出日 = new FlexibleDate("19770110");
        ServiceCode サービスコード = new ServiceCode("31");
        int 単位数 = 1;
        Decimal 単位数単価 = new Decimal(32);
        RString 担当介護支援専門員番号 = new RString("014");
        RString 摘要 = new RString("摘要");
        RString 審査方法コード = new RString("01");
        int 請求金額 = 45;

        RString 連番1;
        RString 事業者区分コード1;
        FlexibleDate 届出日1;
        ServiceCode サービスコード1;
        int 単位数1;
        int 回数1;
        int サービス単位数1;
        Decimal 単位数単価1;
        int サービス単位数合計1;
        RString 担当介護支援専門員番号1;
        RString 摘要1;
        RString 審査方法コード1;
        RString 状態;
        ShokanServicePlanEntity entity;
        List<ShokanServicePlanEntity> サービルList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            連番1 = new RString("22");
            事業者区分コード1 = new RString("10");
            届出日1 = new FlexibleDate("19870110");
            サービスコード1 = new ServiceCode("21");
            単位数1 = 1;
            回数1 = 2;
            サービス単位数1 = 3;
            単位数単価1 = new Decimal(31);
            サービス単位数合計1 = 5;
            担当介護支援専門員番号1 = new RString("11");
            摘要1 = new RString("22");
            審査方法コード1 = new RString("322");
            状態 = new RString("");
            if (i == 1 || i == 3) {
                状態 = new RString("登録");
            }
            if (i == 2 || i == 5) {
                状態 = new RString("修正");
            }
            if (i == 4) {
                状態 = new RString("削除");
            }
            entity = ShokanServicePlanEntity.createSelectByKeyParam(連番1, 事業者区分コード1,
                    届出日1, サービスコード1, 単位数1, 回数1, サービス単位数1, 単位数単価1, サービス単位数合計1,
                    担当介護支援専門員番号1, 摘要1, 審査方法コード1, 状態);
            サービルList.add(entity);
        }
        提供購入年月 = new FlexibleYearMonth("200905");
        明細番号 = new RString("");
        ShokanServicePlanParameter parameter
                = ShokanServicePlanParameter.createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号,
                        事業者番号, 証明書コード, 明細番号, 連番, 事業者区分コード, 届出日, サービスコード, 単位数, 単位数単価,
                        担当介護支援専門員番号, 摘要, 審査方法コード, 請求金額, サービルList);
        sut.updShokanServicePlan(parameter);

        提供購入年月 = new FlexibleYearMonth("200905");
        明細番号 = new RString("33");
        ShokanServicePlanParameter parameter6
                = ShokanServicePlanParameter.createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号,
                        事業者番号, 証明書コード, 明細番号, 連番, 事業者区分コード, 届出日, サービスコード, 単位数, 単位数単価,
                        担当介護支援専門員番号, 摘要, 審査方法コード, 請求金額, サービルList);
        sut.updShokanServicePlan(parameter6);

        提供購入年月 = new FlexibleYearMonth("200704");
        明細番号 = new RString("");
        ShokanServicePlanParameter parameter1
                = ShokanServicePlanParameter.createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号,
                        事業者番号, 証明書コード, 明細番号, 連番, 事業者区分コード, 届出日, サービスコード, 単位数, 単位数単価,
                        担当介護支援専門員番号, 摘要, 審査方法コード, 請求金額, サービルList);
        明細番号test = sut.updShokanServicePlan(parameter1);
        assertThat(明細番号test, is(new RString("0001")));

        提供購入年月 = new FlexibleYearMonth("200704");
        明細番号 = new RString("11");
        ShokanServicePlanParameter parameter2
                = ShokanServicePlanParameter.createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号,
                        事業者番号, 証明書コード, 明細番号, 連番, 事業者区分コード, 届出日, サービスコード, 単位数, 単位数単価,
                        担当介護支援専門員番号, 摘要, 審査方法コード, 請求金額, サービルList);
        明細番号test = sut.updShokanServicePlan(parameter2);
        assertThat(明細番号test, is(new RString("11")));

        提供購入年月 = new FlexibleYearMonth("200504");
        明細番号 = new RString("");
        ShokanServicePlanParameter parameter3
                = ShokanServicePlanParameter.createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号,
                        事業者番号, 証明書コード, 明細番号, 連番, 事業者区分コード, 届出日, サービスコード, 単位数, 単位数単価,
                        担当介護支援専門員番号, 摘要, 審査方法コード, 請求金額, サービルList);
        明細番号test = sut.updShokanServicePlan(parameter3);
        assertThat(明細番号test, is(new RString("0001")));

        提供購入年月 = new FlexibleYearMonth("200504");
        明細番号 = new RString("22");
        ShokanServicePlanParameter parameter4
                = ShokanServicePlanParameter.createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号,
                        事業者番号, 証明書コード, 明細番号, 連番, 事業者区分コード, 届出日, サービスコード, 単位数, 単位数単価,
                        担当介護支援専門員番号, 摘要, 審査方法コード, 請求金額, サービルList);
        明細番号test = sut.updShokanServicePlan(parameter4);
        assertThat(明細番号test, is(new RString("22")));
    }

    @Test
    public void updShokanTokuteiNyushoshaKaigoServiceHiyoTest() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("131");
        FlexibleYearMonth 提供購入年月 = new FlexibleYearMonth("198801");
        RString 整理番号 = new RString("001");
        JigyoshaNo 事業者番号 = new JigyoshaNo("31");
        RString 証明書コード = new RString("321");
        RString 明細番号 = new RString("23");
        int 合計費用額 = 10;
        int 合計保険分請求額 = 20;
        int 合計利用者負担額 = 40;

        RString 連番;
        RString サービスコード;
        Decimal 標準単価;
        Decimal 負担限度額;
        Decimal 日数;
        int 費用額;
        int 保険分;
        int 利用者負担額;
        RString 状態;
        ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity;
        List<ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> 特定入所者費用List = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            連番 = new RString("22");
            サービスコード = new RString("221245");
            標準単価 = new Decimal("32");
            負担限度額 = new Decimal("33");
            日数 = new Decimal("31");
            費用額 = 33;
            保険分 = 33;
            利用者負担額 = 33;
            状態 = new RString("");
            if (i == 1 || i == 3) {
                状態 = new RString("登録");
            }
            if (i == 2 || i == 5) {
                状態 = new RString("修正");
            }
            if (i == 4) {
                状態 = new RString("削除");
            }
            entity = ShokanTokuteiNyushoshaKaigoServiceHiyoEntity.createSelectByKeyParam(連番, サービスコード,
                    標準単価, 負担限度額, 日数, 費用額, 保険分, 利用者負担額, 状態);
            特定入所者費用List.add(entity);
        }
        ShokanTokuteiNyushoshaKaigoServiceHiyoParameter parameter
                = ShokanTokuteiNyushoshaKaigoServiceHiyoParameter.createSelectByKeyParam(被保険者番号, 提供購入年月,
                        整理番号, 事業者番号, 証明書コード, 明細番号, 合計費用額,
                        合計保険分請求額, 合計利用者負担額, 特定入所者費用List);
        sut.updShokanTokuteiNyushoshaKaigoServiceHiyo(parameter);
    }

    @Test
    public void updShokanShakaiFukushiHojinKeigengakuTest() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("131");
        FlexibleYearMonth 提供購入年月 = new FlexibleYearMonth("198801");
        RString 整理番号 = new RString("001");
        JigyoshaNo 事業者番号 = new JigyoshaNo("31");
        RString 証明書コード = new RString("321");
        RString 明細番号 = new RString("23");

        RString 連番;
        Decimal 軽減率;
        ServiceShuruiCode サービス種類コード;
        int 受領すべき利用者負担の総額;
        int 軽減額;
        int 軽減後利用者負担額;
        RString 備考;
        RString 状態;
        ShokanFukushigengakuEntity entity;
        List<ShokanFukushigengakuEntity> 社福軽減額List = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            連番 = new RString("22");
            軽減率 = new Decimal("32");
            サービス種類コード = new ServiceShuruiCode("331");
            受領すべき利用者負担の総額 = 33;
            軽減額 = 33;
            軽減後利用者負担額 = 33;
            備考 = new RString("備考備考");
            状態 = new RString("");
            if (i == 1 || i == 3) {
                状態 = new RString("登録");
            }
            if (i == 2 || i == 5) {
                状態 = new RString("修正");
            }
            if (i == 4) {
                状態 = new RString("削除");
            }
            entity = ShokanFukushigengakuEntity.createSelectByKeyParam(連番, 軽減率, サービス種類コード,
                    受領すべき利用者負担の総額, 軽減額, 軽減後利用者負担額, 備考, 状態);
            社福軽減額List.add(entity);
        }
        ShokanShakaiFukushiHojinKeigengakuParameter parameter
                = ShokanShakaiFukushiHojinKeigengakuParameter.createSelectByKeyParam(被保険者番号, 提供購入年月,
                        整理番号, 事業者番号, 証明書コード, 明細番号, 社福軽減額List);
        sut.updShokanShakaiFukushiHojinKeigengaku(parameter);
    }

    @Test
    public void updShokanShoteiShikkanShisetsuRyoyoTest() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("131");
        FlexibleYearMonth 提供購入年月 = new FlexibleYearMonth("198801");
        RString 整理番号 = new RString("001");
        JigyoshaNo 事業者番号 = new JigyoshaNo("31");
        RString 証明書コード = new RString("321");
        RString 明細番号 = new RString("23");

        RString 連番;
        RString 緊急時傷病名1;
        RString 緊急時傷病名2;
        RString 緊急時傷病名3;
        FlexibleDate 緊急時治療開始年月日1;
        FlexibleDate 緊急時治療開始年月日2;
        FlexibleDate 緊急時治療開始年月日3;
        Decimal 往診日数;
        RString 往診医療機関名;
        Decimal 通院日数;
        RString 通院医療機関名;
        int 緊急時治療管理単位数;
        Decimal 緊急時治療管理日数;
        int 緊急時治療管理小計;
        int リハビリテーション単位数;
        int 処置単位数;
        int 手術単位数;
        int 麻酔単位数;
        int 放射線治療単位数;
        RString 摘要;
        int 緊急時施設療養費合計単位数;
        RString 所定疾患施設療養費傷病名1;
        RString 所定疾患施設療養費傷病名2;
        RString 所定疾患施設療養費傷病名3;
        FlexibleDate 所定疾患施設療養費開始年月日1;
        FlexibleDate 所定疾患施設療養費開始年月日2;
        FlexibleDate 所定疾患施設療養費開始年月日3;
        int 所定疾患施設療養費単位数;
        Decimal 所定疾患施設療養費日数;
        int 所定疾患施設療養費小計;
        RString 状態;
        ShokanShoteiShikkanShisetsuRyoyoEntity entity;
        List<ShokanShoteiShikkanShisetsuRyoyoEntity> 緊急時所定疾患List = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            連番 = new RString("22");
            緊急時傷病名1 = new RString("緊急時傷病名1");
            緊急時傷病名2 = new RString("緊急時傷病名2");
            緊急時傷病名3 = new RString("緊急時傷病名3");
            緊急時治療開始年月日1 = new FlexibleDate("19881001");
            緊急時治療開始年月日2 = new FlexibleDate("19881002");
            緊急時治療開始年月日3 = new FlexibleDate("19881003");
            往診日数 = new Decimal("32");
            往診医療機関名 = new RString("往診医療機関名");
            通院日数 = new Decimal("32");
            通院医療機関名 = new RString("通院医療機関名");
            緊急時治療管理単位数 = 1;
            緊急時治療管理日数 = new Decimal("32");
            緊急時治療管理小計 = 2;
            リハビリテーション単位数 = 2;
            処置単位数 = 2;
            手術単位数 = 2;
            麻酔単位数 = 2;
            放射線治療単位数 = 2;
            摘要 = new RString("摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要");
            緊急時施設療養費合計単位数 = 5;
            所定疾患施設療養費傷病名1 = new RString("所定疾患施設療養費傷病名1");
            所定疾患施設療養費傷病名2 = new RString("所定疾患施設療養費傷病名2");
            所定疾患施設療養費傷病名3 = new RString("所定疾患施設療養費傷病名3");
            所定疾患施設療養費開始年月日1 = new FlexibleDate("19881001");
            所定疾患施設療養費開始年月日2 = new FlexibleDate("19881002");
            所定疾患施設療養費開始年月日3 = new FlexibleDate("19881003");
            所定疾患施設療養費単位数 = 10;
            所定疾患施設療養費日数 = new Decimal("32");
            所定疾患施設療養費小計 = 2;
            状態 = new RString("");
            if (i == 1 || i == 3) {
                状態 = new RString("登録");
            }
            if (i == 2 || i == 5) {
                状態 = new RString("修正");
            }
            if (i == 4) {
                状態 = new RString("削除");
            }
            entity = ShokanShoteiShikkanShisetsuRyoyoEntity.createSelectByKeyParam(連番, 緊急時傷病名1, 緊急時傷病名2,
                    緊急時傷病名3, 緊急時治療開始年月日1, 緊急時治療開始年月日2, 緊急時治療開始年月日3, 往診日数,
                    往診医療機関名, 通院日数, 通院医療機関名, 緊急時治療管理単位数,
                    緊急時治療管理日数, 緊急時治療管理小計,
                    リハビリテーション単位数, 処置単位数, 手術単位数, 麻酔単位数, 放射線治療単位数, 摘要,
                    緊急時施設療養費合計単位数, 所定疾患施設療養費傷病名1, 所定疾患施設療養費傷病名2,
                    所定疾患施設療養費傷病名3, 所定疾患施設療養費開始年月日1, 所定疾患施設療養費開始年月日2,
                    所定疾患施設療養費開始年月日3, 所定疾患施設療養費単位数, 所定疾患施設療養費日数,
                    所定疾患施設療養費小計, 状態);
            緊急時所定疾患List.add(entity);
        }
        ShokanShoteiShikkanShisetsuRyoyoParameter parameter
                = ShokanShoteiShikkanShisetsuRyoyoParameter.createSelectByKeyParam(被保険者番号, 提供購入年月,
                        整理番号, 事業者番号, 証明書コード, 明細番号, 緊急時所定疾患List);
        sut.updShokanShoteiShikkanShisetsuRyoyo(parameter);
    }

    @Test
    public void updShokanKinkyuShisetsuRyoyoTest() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("131");
        FlexibleYearMonth 提供購入年月 = new FlexibleYearMonth("198801");
        RString 整理番号 = new RString("001");
        JigyoshaNo 事業者番号 = new JigyoshaNo("31");
        RString 証明書コード = new RString("321");
        RString 明細番号 = new RString("23");

        RString 連番;
        RString 緊急時傷病名1;
        RString 緊急時傷病名2;
        RString 緊急時傷病名3;
        FlexibleDate 緊急時治療開始年月日1;
        FlexibleDate 緊急時治療開始年月日2;
        FlexibleDate 緊急時治療開始年月日3;
        Decimal 往診日数;
        RString 往診医療機関名;
        Decimal 通院日数;
        RString 通院医療機関名;
        int 緊急時治療管理単位数;
        Decimal 緊急時治療管理日数;
        int 緊急時治療管理小計;
        int リハビリテーション単位数;
        int 処置単位数;
        int 手術単位数;
        int 麻酔単位数;
        int 放射線治療単位数;
        RString 摘要;
        int 緊急時施設療養費合計単位数;
        RString 状態;
        ShokanKinkyuShisetsuRyoyoEntity entity;
        List<ShokanKinkyuShisetsuRyoyoEntity> 緊急時施設療養費List = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            連番 = new RString("22");
            緊急時傷病名1 = new RString("緊急時傷病名1");
            緊急時傷病名2 = new RString("緊急時傷病名2");
            緊急時傷病名3 = new RString("緊急時傷病名3");
            緊急時治療開始年月日1 = new FlexibleDate("19881001");
            緊急時治療開始年月日2 = new FlexibleDate("19881002");
            緊急時治療開始年月日3 = new FlexibleDate("19881003");
            往診日数 = new Decimal("32");
            往診医療機関名 = new RString("往診医療機関名");
            通院日数 = new Decimal("32");
            通院医療機関名 = new RString("通院医療機関名");
            緊急時治療管理単位数 = 1;
            緊急時治療管理日数 = new Decimal("32");
            緊急時治療管理小計 = 2;
            リハビリテーション単位数 = 2;
            処置単位数 = 2;
            手術単位数 = 2;
            麻酔単位数 = 2;
            放射線治療単位数 = 2;
            摘要 = new RString("摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要摘要");
            緊急時施設療養費合計単位数 = 2;
            状態 = new RString("");
            if (i == 1 || i == 3) {
                状態 = new RString("登録");
            }
            if (i == 2 || i == 5) {
                状態 = new RString("修正");
            }
            if (i == 4) {
                状態 = new RString("削除");
            }
            entity = ShokanKinkyuShisetsuRyoyoEntity.createSelectByKeyParam(連番, 緊急時傷病名1, 緊急時傷病名2,
                    緊急時傷病名3, 緊急時治療開始年月日1, 緊急時治療開始年月日2, 緊急時治療開始年月日3, 往診日数,
                    往診医療機関名, 通院日数, 通院医療機関名, 緊急時治療管理単位数,
                    緊急時治療管理日数, 緊急時治療管理小計,
                    リハビリテーション単位数, 処置単位数, 手術単位数, 麻酔単位数, 放射線治療単位数, 摘要,
                    緊急時施設療養費合計単位数, 状態);
            緊急時施設療養費List.add(entity);
        }
        ShokanKinkyuShisetsuRyoyoParameter parameter
                = ShokanKinkyuShisetsuRyoyoParameter.createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号,
                        事業者番号, 証明書コード, 明細番号, 緊急時施設療養費List);
        sut.updShokanKinkyuShisetsuRyoyo(parameter);
    }

    @Test
    public void updShokanShukeiTest() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("131");
        FlexibleYearMonth 提供購入年月 = new FlexibleYearMonth("198801");
        RString 整理番号 = new RString("001");
        JigyoshaNo 事業者番号 = new JigyoshaNo("31");
        RString 証明書コード = new RString("321");
        RString 明細番号 = new RString("23");

        RString 連番;
        ServiceShuruiCode サービス種類;
        int サービス実日数;
        int 計画単位数;
        int 限度額管理対象単位数;
        int 限度額管理対象外単位数;
        int 短期入所計画日数;
        int 短期入所実日数;
        int 単位数合計;
        Decimal 単位数単価;
        Decimal 請求額;
        int 利用者負担;
        int 出来高医療費単位数合計;
        Decimal 出来高医療費請求額;
        Decimal 出来高医療費利用者負担額;
        RString 審査方法区分コード;
        RString 状態;
        ShokanShukeiEntity entity;
        List<ShokanShukeiEntity> 請求集計List = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            連番 = new RString("1");
            サービス種類 = new ServiceShuruiCode("3232");
            サービス実日数 = 1;
            計画単位数 = 1;
            限度額管理対象単位数 = 1;
            限度額管理対象外単位数 = 1;
            短期入所計画日数 = 1;
            短期入所実日数 = 1;
            単位数合計 = 1;
            単位数単価 = new Decimal("32");
            請求額 = new Decimal("32");
            利用者負担 = 1;
            出来高医療費単位数合計 = 2;
            出来高医療費請求額 = new Decimal("32");
            出来高医療費利用者負担額 = new Decimal("32");
            審査方法区分コード = new RString("10");
            状態 = new RString("");
            if (i == 1 || i == 3) {
                状態 = new RString("登録");
            }
            if (i == 2 || i == 5) {
                状態 = new RString("修正");
            }
            if (i == 4) {
                状態 = new RString("削除");
            }
            entity = ShokanShukeiEntity.createSelectByKeyParam(連番, サービス種類, サービス実日数, 計画単位数,
                    限度額管理対象単位数, 限度額管理対象外単位数, 短期入所計画日数, 短期入所実日数, 単位数合計,
                    単位数単価, 請求額, 利用者負担, 出来高医療費単位数合計, 出来高医療費請求額,
                    出来高医療費利用者負担額, 審査方法区分コード, 状態);
            請求集計List.add(entity);
        }
        ShokanShukeiParameter parameter
                = ShokanShukeiParameter.createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号,
                        事業者番号, 証明書コード, 明細番号, 請求集計List);
        sut.updShokanShukei(parameter);
    }

    @Test
    public void updShokanShokujiHiyoTest() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("131");
        FlexibleYearMonth 提供購入年月;
        RString 整理番号 = new RString("001");
        JigyoshaNo 事業者番号 = new JigyoshaNo("31");
        RString 証明書コード = new RString("321");
        RString 明細番号 = new RString("23");
        RString 連番 = new RString("1");
        Decimal 基本提供日数 = new Decimal("32");
        Decimal 基本提供単価 = new Decimal("32");
        int 基本提供金額 = 1;
        Decimal 特別提供日数 = new Decimal("32");
        Decimal 特別提供単価 = new Decimal("32");
        int 特別提供金額 = 2;
        Decimal 食事提供延べ日数 = new Decimal("32");
        int 食事提供費合計 = 44;
        int 標準負担月額 = 33;
        int 食事提供費請求額 = 22;
        Decimal 標準負担日額 = new Decimal("32");

        RString 連番1;
        RString サービスコード;
        Decimal 単位;
        Decimal 回数日数;
        int 金額;
        RString 状態;
        ShokanShokujiHiyoEntity entity;
        List<ShokanShokujiHiyoEntity> 食事費用List = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            連番1 = new RString("2");
            サービスコード = new RString("10");
            単位 = new Decimal("32");
            回数日数 = new Decimal("32");
            金額 = 2;
            状態 = new RString("");
            if (i == 1 || i == 3) {
                状態 = new RString("登録");
            }
            if (i == 2 || i == 5) {
                状態 = new RString("修正");
            }
            if (i == 4) {
                状態 = new RString("削除");
            }
            entity = ShokanShokujiHiyoEntity.createSelectByKeyParam(連番1, サービスコード, 単位, 回数日数, 金額, 状態);
            食事費用List.add(entity);
        }
        提供購入年月 = new FlexibleYearMonth("198801");
        ShokanShokujiHiyoParameter parameter
                = ShokanShokujiHiyoParameter.createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号, 事業者番号,
                        証明書コード, 明細番号, 連番, 基本提供日数, 基本提供単価, 基本提供金額, 特別提供日数,
                        特別提供単価, 特別提供金額, 食事提供延べ日数, 食事提供費合計, 標準負担月額,
                        食事提供費請求額, 標準負担日額, 食事費用List);
        sut.updShokanShokujiHiyo(parameter);

        提供購入年月 = new FlexibleYearMonth("200401");
        ShokanShokujiHiyoParameter parameter1
                = ShokanShokujiHiyoParameter.createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号, 事業者番号,
                        証明書コード, 明細番号, 連番, 基本提供日数, 基本提供単価, 基本提供金額, 特別提供日数,
                        特別提供単価, 特別提供金額, 食事提供延べ日数, 食事提供費合計, 標準負担月額,
                        食事提供費請求額, 標準負担日額, 食事費用List);
        sut.updShokanShokujiHiyo(parameter1);

        提供購入年月 = new FlexibleYearMonth("201401");
        ShokanShokujiHiyoParameter parameter2
                = ShokanShokujiHiyoParameter.createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号, 事業者番号,
                        証明書コード, 明細番号, 連番, 基本提供日数, 基本提供単価, 基本提供金額, 特別提供日数,
                        特別提供単価, 特別提供金額, 食事提供延べ日数, 食事提供費合計, 標準負担月額,
                        食事提供費請求額, 標準負担日額, 食事費用List);
        sut.updShokanShokujiHiyo(parameter2);
    }

    @Test
    public void updKetteJohoTest() {
        HihokenshaNo 被保険者番号 = new HihokenshaNo("131");
        FlexibleYearMonth 提供購入年月;
        RString 整理番号 = new RString("001");
        FlexibleDate 決定年月日 = new FlexibleDate("18880110");
        RString 支給区分 = new RString("321");
        Decimal 支払金額合計 = new Decimal("32");
        int 差額金額 = 1;
        RString 増減理由等 = new RString("増減理由等");
        RString 不支給理由等1 = new RString("不支給理由等1");
        RString 不支給理由等2 = new RString("不支給理由等2");
        int 増減単位 = 2;
        boolean 差額金額登録フラグ = true;
        JigyoshaNo 事業者番号 = new JigyoshaNo("111");
        RString 証明書コード = new RString("21");
        RString 明細番号 = new RString("21");
        RString 連番 = new RString("1");
        RString 画面モード = new RString("登録");
        ShikibetsuCode 識別コード = new ShikibetsuCode("11");

        JigyoshaNo 事業者番号1;
        RString 証明書コード1;
        RString 明細番号1;
        RString 連番1;
        int 差額金額1;
        RString テーブル区分;
        SyokanbaraihiShikyuShinseiKetteEntity entity;
        List<SyokanbaraihiShikyuShinseiKetteEntity> 決定情報一覧List = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            事業者番号1 = new JigyoshaNo("111");
            証明書コード1 = new RString("21");
            明細番号1 = new RString("21");
            連番1 = new RString("1");
            差額金額1 = 1;
            テーブル区分 = new RString("5");
            entity = SyokanbaraihiShikyuShinseiKetteEntity.createSelectByKeyParam(事業者番号1, 証明書コード1,
                    明細番号1, 連番1, 差額金額1, テーブル区分);
            決定情報一覧List.add(entity);
        }
        提供購入年月 = new FlexibleYearMonth("198801");
        SyokanbaraihiShikyuShinseiKetteParameter parameter
                = SyokanbaraihiShikyuShinseiKetteParameter.createSelectByKeyParam(被保険者番号, 提供購入年月, 整理番号,
                        決定年月日, 支給区分, 支払金額合計, 差額金額, 増減理由等, 不支給理由等1,
                        不支給理由等2, 増減単位, 差額金額登録フラグ, 事業者番号, 証明書コード,
                        明細番号, 連番, 画面モード, 識別コード, 決定情報一覧List);
        sut.updKetteJoho(parameter);
    }
}
