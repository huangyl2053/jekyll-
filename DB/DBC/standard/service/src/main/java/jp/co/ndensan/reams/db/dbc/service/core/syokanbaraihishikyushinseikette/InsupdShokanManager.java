/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200004;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200604;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200904;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShakaiFukushiHojinKeigengaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraishikyukettekyufujssekihensyu.KyufujissekiEntity;
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
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3107ShokanMeisaiJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraishikyukettekyufujssekihensyu.SyokanbaraiShikyuKetteKyufuJssekiHensyuManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3038ShokanKihonDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払データ登録更新
 *
 * @reamsid_L DBC-1030-200 donghj
 */
public class InsupdShokanManager {

    private final DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac 償還払請求特定入所者介護サービス費用Dac;
    private final DbT3047ShokanServicePlan200904Dac 償還払請求サービス計画200904Dac;
    private final DbT3046ShokanServicePlan200604Dac 償還払請求サービス計画200604Dac;
    private final DbT3045ShokanServicePlan200004Dac 償還払請求サービス計画200004Dac;
    private final DbT3043ShokanShokujiHiyoDac 償還払請求食事費用Dac;
    private final DbT3053ShokanShukeiDac 償還払請求集計Dac;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private final DbT3038ShokanKihonDac 償還払請求基本Dac;
    private final DbT3107ShokanMeisaiJushochiTokureiDac 住所地特例Dac;
    private final DbT3039ShokanMeisaiDac 償還払請求明細Dac;
    private final DbT3041ShokanTokuteiShinryohiDac 償還払請求特定診療費Dac;
    private final DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac 特別療養費Dac;
    private final DbT3051ShokanShakaiFukushiHojinKeigengakuDac 償還払請求社会福祉法人軽減額Dac;
    private final DbT3052ShokanShoteiShikkanShisetsuRyoyoDac 償還払請求所定疾患施設療養費等Dac;
    private final DbT3040ShokanKinkyuShisetsuRyoyoDac 償還払請求緊急時施設療養Dac;
    private static final FlexibleYearMonth サービス年月_200904 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth サービス年月_200303 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth サービス年月_200304 = new FlexibleYearMonth("200304");
    private static final FlexibleYearMonth サービス年月_200604 = new FlexibleYearMonth("200604");
    private static final FlexibleYearMonth サービス年月_200903 = new FlexibleYearMonth("200903");
    private static final FlexibleYearMonth サービス年月_200603 = new FlexibleYearMonth("200603");

    /**
     * コンストラクタです。
     */
    InsupdShokanManager() {
        this.償還払請求特定入所者介護サービス費用Dac
                = InstanceProvider.create(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac.class);
        this.償還払請求サービス計画200904Dac = InstanceProvider.create(DbT3047ShokanServicePlan200904Dac.class);
        this.償還払請求サービス計画200604Dac = InstanceProvider.create(DbT3046ShokanServicePlan200604Dac.class);
        this.償還払請求サービス計画200004Dac = InstanceProvider.create(DbT3045ShokanServicePlan200004Dac.class);
        this.償還払請求食事費用Dac = InstanceProvider.create(DbT3043ShokanShokujiHiyoDac.class);
        this.償還払請求集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        this.償還払支給申請Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
        this.償還払請求基本Dac = InstanceProvider.create(DbT3038ShokanKihonDac.class);
        this.住所地特例Dac = InstanceProvider.create(DbT3107ShokanMeisaiJushochiTokureiDac.class);
        this.償還払請求明細Dac = InstanceProvider.create(DbT3039ShokanMeisaiDac.class);
        this.償還払請求特定診療費Dac = InstanceProvider.create(DbT3041ShokanTokuteiShinryohiDac.class);
        this.特別療養費Dac = InstanceProvider.create(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac.class);
        this.償還払請求社会福祉法人軽減額Dac
                = InstanceProvider.create(DbT3051ShokanShakaiFukushiHojinKeigengakuDac.class);
        this.償還払請求所定疾患施設療養費等Dac
                = InstanceProvider.create(DbT3052ShokanShoteiShikkanShisetsuRyoyoDac.class);
        this.償還払請求緊急時施設療養Dac = InstanceProvider.create(DbT3040ShokanKinkyuShisetsuRyoyoDac.class);
    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TaishoshaKensaku}のインスタンス
     */
    public static InsupdShokanManager createInstance() {
        return InstanceProvider.create(InsupdShokanManager.class);
    }

    /**
     * 償還払支給申請を更新する。
     *
     * @param db情報 DbJohoViewState
     *
     */
    public void update償還払支給申請(DbJohoViewState db情報) {
        DbT3034ShokanShinseiEntity dbt3034entity = db情報.get償還払支給申請().toEntity();
        if (EntityDataState.Added.equals(dbt3034entity.getState())
                || EntityDataState.Modified.equals(dbt3034entity.getState())) {
            償還払支給申請Dac.save(dbt3034entity);
        }
    }

    /**
     * 証明書を更新する。
     *
     * @param db情報 DbJohoViewState
     * @param サービス提供年月 FlexibleYearMonth
     *
     */
    public void update証明書(DbJohoViewState db情報, FlexibleYearMonth サービス提供年月) {
        set償還払請求1(db情報, サービス提供年月);
        update償還払請求サービス計画(db情報, サービス提供年月);
        set償還払請求2(db情報);
    }

    /**
     * 償還払支給判定結果を更新する。
     *
     * @param shokanHanteiKekka ShokanHanteiKekka
     *
     */
    public void update償還払支給判定結果(ShokanHanteiKekka shokanHanteiKekka) {
        DbT3036ShokanHanteiKekkaEntity dbt3036entity = shokanHanteiKekka.toEntity();
        if (EntityDataState.Added.equals(dbt3036entity.getState())
                || EntityDataState.Modified.equals(dbt3036entity.getState())) {
            償還払支給判定結果Dac.save(dbt3036entity);
        }
    }

    /**
     * 実績編集の処理を行う
     *
     * @param 修正前支給区分 修正前支給区分
     * @param 決定日 決定日
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 画面モード 画面モード
     * @param 識別コード 識別コード
     *
     */
    public void 実績編集の処理(RString 修正前支給区分, FlexibleDate 決定日, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, RString 画面モード, ShikibetsuCode 識別コード) {
        if (!決定日.isEmpty()) {
            KyufujissekiEntity kyufuentity = SyokanbaraihiShikyuShinseiKetteManager.createInstance().
                    getKyufuJissekiData(被保険者番号, サービス提供年月, 整理番号);
            SyokanbaraiShikyuKetteKyufuJssekiHensyuManager manager
                    = SyokanbaraiShikyuKetteKyufuJssekiHensyuManager.createInstance();
            manager.dealKyufujisseki(画面モード, 識別コード, kyufuentity, 修正前支給区分);

        }
    }

    private void update償還払請求基本(List<ShokanKihon> 償還払請求基本データList) {
        for (ShokanKihon dbT3038entity : 償還払請求基本データList) {
            if (EntityDataState.Added.equals(dbT3038entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbT3038entity.toEntity().getState())) {
                償還払請求基本Dac.save(dbT3038entity.toEntity());
            }
        }
    }

    private void update償還払請求明細_住所地特例(List<ShokanMeisaiJushochiTokurei> 住所地特例データList) {
        for (ShokanMeisaiJushochiTokurei dbT3017entity : 住所地特例データList) {
            if (EntityDataState.Added.equals(dbT3017entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbT3017entity.toEntity().getState())) {
                住所地特例Dac.save(dbT3017entity.toEntity());
            } else if (EntityDataState.Deleted.equals(dbT3017entity.toEntity().getState())) {

                住所地特例Dac.delete(dbT3017entity.toEntity());
            }
        }
    }

    private void update償還払請求明細(List<ShokanMeisai> 償還払請求明細List) {
        for (ShokanMeisai dbT3039entity : 償還払請求明細List) {
            if (EntityDataState.Added.equals(dbT3039entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbT3039entity.toEntity().getState())) {
                償還払請求明細Dac.save(dbT3039entity.toEntity());
            } else if (EntityDataState.Deleted.equals(dbT3039entity.toEntity().getState())) {

                償還払請求明細Dac.delete(dbT3039entity.toEntity());
            }
        }
    }

    private void update償還払請求特定診療費(List<ShokanTokuteiShinryohi> 償還払請求特定診療費データList) {
        for (ShokanTokuteiShinryohi dbT3041entity : 償還払請求特定診療費データList) {
            if (EntityDataState.Added.equals(dbT3041entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbT3041entity.toEntity().getState())) {
                償還払請求特定診療費Dac.save(dbT3041entity.toEntity());
            } else if (EntityDataState.Deleted.equals(dbT3041entity.toEntity().getState())) {

                償還払請求特定診療費Dac.delete(dbT3041entity.toEntity());
            }
        }
    }

    private void update償還払請求特定診療費_特別療養費(List<ShokanTokuteiShinryoTokubetsuRyoyo> 特別療養費データList) {
        for (ShokanTokuteiShinryoTokubetsuRyoyo dbT3042entity : 特別療養費データList) {
            if (EntityDataState.Added.equals(dbT3042entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbT3042entity.toEntity().getState())) {
                特別療養費Dac.save(dbT3042entity.toEntity());
            } else if (EntityDataState.Deleted.equals(dbT3042entity.toEntity().getState())) {

                特別療養費Dac.delete(dbT3042entity.toEntity());
            }
        }
    }

    private void update償還払請求サービス計画(DbJohoViewState db情報, FlexibleYearMonth サービス提供年月) {
        if (サービス年月_200904.isBeforeOrEquals(サービス提供年月)) {
            List<ShokanServicePlan200904> 償還払請求サービス計画200904データList = db情報.get償還払請求サービス計画200904データList();
            if (償還払請求サービス計画200904データList != null && !償還払請求サービス計画200904データList.isEmpty()) {
                サービス計画200904(償還払請求サービス計画200904データList);
            }

        } else if (サービス年月_200604.isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBeforeOrEquals(サービス年月_200903)) {
            List<ShokanServicePlan200604> 償還払請求サービス計画200604データList = db情報.get償還払請求サービス計画200604データList();
            if (償還払請求サービス計画200604データList != null && !償還払請求サービス計画200604データList.isEmpty()) {
                サービス計画200604(償還払請求サービス計画200604データList);
            }

        } else if (サービス提供年月.isBeforeOrEquals(サービス年月_200603)) {
            List<ShokanServicePlan200004> 償還払請求サービス計画200004データList = db情報.get償還払請求サービス計画200004データList();
            if (償還払請求サービス計画200004データList != null && !償還払請求サービス計画200004データList.isEmpty()) {
                サービス計画200004(償還払請求サービス計画200004データList);
            }
        }
    }

    private void サービス計画200904(List<ShokanServicePlan200904> 償還払請求サービス計画200904データList) {
        for (ShokanServicePlan200904 dbt3047entity : 償還払請求サービス計画200904データList) {
            if (EntityDataState.Added.equals(dbt3047entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbt3047entity.toEntity().getState())) {
                償還払請求サービス計画200904Dac.save(dbt3047entity.toEntity());
            }
            if (EntityDataState.Deleted.equals(dbt3047entity.toEntity().getState())) {
                償還払請求サービス計画200904Dac.delete(dbt3047entity.toEntity());
            }
        }
    }

    private void サービス計画200604(List<ShokanServicePlan200604> 償還払請求サービス計画200604データList) {
        for (ShokanServicePlan200604 dbt3046entity : 償還払請求サービス計画200604データList) {
            if (EntityDataState.Added.equals(dbt3046entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbt3046entity.toEntity().getState())) {
                償還払請求サービス計画200604Dac.save(dbt3046entity.toEntity());
            }
            if (EntityDataState.Deleted.equals(dbt3046entity.toEntity().getState())) {
                償還払請求サービス計画200604Dac.delete(dbt3046entity.toEntity());
            }
        }
    }

    private void サービス計画200004(List<ShokanServicePlan200004> 償還払請求サービス計画200004データList) {
        for (ShokanServicePlan200004 dbt3045entity : 償還払請求サービス計画200004データList) {
            if (EntityDataState.Added.equals(dbt3045entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbt3045entity.toEntity().getState())) {
                償還払請求サービス計画200004Dac.save(dbt3045entity.toEntity());
            }
            if (EntityDataState.Deleted.equals(dbt3045entity.toEntity().getState())) {
                償還払請求サービス計画200004Dac.delete(dbt3045entity.toEntity());
            }
        }
    }

    private void update償還払請求特定入所者介護サービス費用(
            List<ShokanTokuteiNyushoshaKaigoServiceHiyo> 償還払請求特定入所者介護サービス費用データList) {
        for (ShokanTokuteiNyushoshaKaigoServiceHiyo dbT3050entity : 償還払請求特定入所者介護サービス費用データList) {
            if (EntityDataState.Added.equals(dbT3050entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbT3050entity.toEntity().getState())) {
                償還払請求特定入所者介護サービス費用Dac.save(dbT3050entity.toEntity());
            } else if (EntityDataState.Deleted.equals(dbT3050entity.toEntity().getState())) {

                償還払請求特定入所者介護サービス費用Dac.delete(dbT3050entity.toEntity());
            }
        }
    }

    private void update償還払請求社会福祉法人軽減額(
            List<ShokanShakaiFukushiHojinKeigengaku> 償還払請求社会福祉法人軽減額データList) {
        for (ShokanShakaiFukushiHojinKeigengaku dbT3051entity : 償還払請求社会福祉法人軽減額データList) {
            if (EntityDataState.Added.equals(dbT3051entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbT3051entity.toEntity().getState())) {
                償還払請求社会福祉法人軽減額Dac.save(dbT3051entity.toEntity());
            } else if (EntityDataState.Deleted.equals(dbT3051entity.toEntity().getState())) {

                償還払請求社会福祉法人軽減額Dac.delete(dbT3051entity.toEntity());
            }
        }
    }

    private void update償還払請求所定疾患施設療養費等(
            List<ShokanShoteiShikkanShisetsuRyoyo> 償還払請求所定疾患施設療養費等データList) {
        for (ShokanShoteiShikkanShisetsuRyoyo dbT3052entity : 償還払請求所定疾患施設療養費等データList) {
            if (EntityDataState.Added.equals(dbT3052entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbT3052entity.toEntity().getState())) {
                償還払請求所定疾患施設療養費等Dac.save(dbT3052entity.toEntity());
            } else if (EntityDataState.Deleted.equals(dbT3052entity.toEntity().getState())) {

                償還払請求所定疾患施設療養費等Dac.delete(dbT3052entity.toEntity());
            }
        }
    }

    private void update償還払請求緊急時施設療養(List<ShokanKinkyuShisetsuRyoyo> 償還払請求緊急時施設療養データList) {
        for (ShokanKinkyuShisetsuRyoyo dbT3040entity : 償還払請求緊急時施設療養データList) {
            if (EntityDataState.Added.equals(dbT3040entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbT3040entity.toEntity().getState())) {
                償還払請求緊急時施設療養Dac.save(dbT3040entity.toEntity());
            } else if (EntityDataState.Deleted.equals(dbT3040entity.toEntity().getState())) {

                償還払請求緊急時施設療養Dac.delete(dbT3040entity.toEntity());
            }
        }
    }

    private void update償還払請求集計(List<ShokanShukeiResult> 償還払請求集計データList) {
        for (ShokanShukeiResult dbT3053entity : 償還払請求集計データList) {
            if (EntityDataState.Added.equals(dbT3053entity.getShukei().toEntity().getState())
                    || EntityDataState.Modified.equals(dbT3053entity.getShukei().toEntity().getState())) {
                償還払請求集計Dac.save(dbT3053entity.getShukei().toEntity());
            } else if (EntityDataState.Deleted.equals(dbT3053entity.getShukei().toEntity().getState())) {

                償還払請求集計Dac.delete(dbT3053entity.getShukei().toEntity());
            }
        }

    }

    private void update償還払請求食事費用(List<ShokanShokujiHiyo> 償還払請求食事費用データList) {
        for (ShokanShokujiHiyo dbT3043entity : 償還払請求食事費用データList) {
            if (EntityDataState.Added.equals(dbT3043entity.toEntity().getState())
                    || EntityDataState.Modified.equals(dbT3043entity.toEntity().getState())) {
                償還払請求食事費用Dac.save(dbT3043entity.toEntity());
            } else if (EntityDataState.Deleted.equals(dbT3043entity.toEntity().getState())) {

                償還払請求食事費用Dac.delete(dbT3043entity.toEntity());
            }
        }
    }

    private void set償還払請求1(DbJohoViewState db情報, FlexibleYearMonth サービス提供年月) {
        List<ShokanKihon> 償還払請求基本データList = db情報.get償還払請求基本データList();
        if (償還払請求基本データList != null && !償還払請求基本データList.isEmpty()) {
            update償還払請求基本(償還払請求基本データList);
        }
        List<ShokanMeisaiJushochiTokurei> 住所地特例データList = db情報.get住所地特例データList();
        if (住所地特例データList != null && !住所地特例データList.isEmpty()) {
            update償還払請求明細_住所地特例(住所地特例データList);
        }
        List<ShokanMeisai> 償還払請求明細List = db情報.get償還払請求明細データList();
        if (償還払請求明細List != null && !償還払請求明細List.isEmpty()) {
            update償還払請求明細(償還払請求明細List);
        }
        if (サービス提供年月.isBeforeOrEquals(サービス年月_200303)) {
            List<ShokanTokuteiShinryohi> 償還払請求特定診療費データList = db情報.get償還払請求特定診療費データList();
            if (償還払請求特定診療費データList != null && !償還払請求特定診療費データList.isEmpty()) {
                update償還払請求特定診療費(償還払請求特定診療費データList);
            }
        } else if (サービス年月_200304.isBeforeOrEquals(サービス提供年月)) {
            List<ShokanTokuteiShinryoTokubetsuRyoyo> 特別療養費データList = db情報.get特別療養費データList();
            if (特別療養費データList != null && !特別療養費データList.isEmpty()) {
                update償還払請求特定診療費_特別療養費(特別療養費データList);
            }
        }
    }

    private void set償還払請求2(DbJohoViewState db情報) {
        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> 償還払請求特定入所者介護サービス費用データList
                = db情報.get償還払請求特定入所者介護サービス費用データList();
        if (償還払請求特定入所者介護サービス費用データList != null && !償還払請求特定入所者介護サービス費用データList.isEmpty()) {
            update償還払請求特定入所者介護サービス費用(償還払請求特定入所者介護サービス費用データList);
        }
        List<ShokanShakaiFukushiHojinKeigengaku> 償還払請求社会福祉法人軽減額データList
                = db情報.get償還払請求社会福祉法人軽減額データList();
        if (償還払請求社会福祉法人軽減額データList != null && !償還払請求社会福祉法人軽減額データList.isEmpty()) {
            update償還払請求社会福祉法人軽減額(償還払請求社会福祉法人軽減額データList);
        }
        List<ShokanShoteiShikkanShisetsuRyoyo> 償還払請求所定疾患施設療養費等データList
                = db情報.get償還払請求所定疾患施設療養費等データList();
        if (償還払請求所定疾患施設療養費等データList != null && !償還払請求所定疾患施設療養費等データList.isEmpty()) {
            update償還払請求所定疾患施設療養費等(償還払請求所定疾患施設療養費等データList);
        }
        List<ShokanKinkyuShisetsuRyoyo> 償還払請求緊急時施設療養データList = db情報.get償還払請求緊急時施設療養データList();
        if (償還払請求緊急時施設療養データList != null && !償還払請求緊急時施設療養データList.isEmpty()) {
            update償還払請求緊急時施設療養(償還払請求緊急時施設療養データList);
        }
        List<ShokanShukeiResult> 償還払請求集計データList = db情報.get償還払請求集計データList();
        if (償還払請求集計データList != null && !償還払請求集計データList.isEmpty()) {
            update償還払請求集計(償還払請求集計データList);
        }
        List<ShokanShokujiHiyo> 償還払請求食事費用データList = db情報.get償還払請求食事費用データList();
        if (償還払請求食事費用データList != null && !償還払請求食事費用データList.isEmpty()) {
            update償還払請求食事費用(償還払請求食事費用データList);
        }
    }

}
