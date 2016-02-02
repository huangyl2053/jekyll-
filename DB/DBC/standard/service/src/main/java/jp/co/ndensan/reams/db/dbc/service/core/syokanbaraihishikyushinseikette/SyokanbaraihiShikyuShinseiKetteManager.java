/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraishikyukettekyufujssekihensyu.KyufujissekiEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.nyuryokushikibetsuno.NyuryokuShikibetsuNoShokan3Keta;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanFukushigengakuEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanKihonParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanKinkyuShisetsuRyoyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanMeisaiJushochiTokureiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanMeisaiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanServicePlanEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.ShokanServicePlanParameter;
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
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3039ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3040ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3041ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3053ShokanShukeiEntity;
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
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraishikyukettekyufujssekihensyu.SyokanbaraiShikyuKetteKyufuJssekiHensyuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払い費支給申請決定クラスです。
 */
public class SyokanbaraihiShikyuShinseiKetteManager {

    private final DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac 償還払請求特定入所者介護サービス費用Dac;
    private final DbT3047ShokanServicePlan200904Dac 償還払請求サービス計画200904Dac;
    private final DbT3046ShokanServicePlan200604Dac 償還払請求サービス計画200604Dac;
    private final DbT3045ShokanServicePlan200004Dac 償還払請求サービス計画200004Dac;
    private final DbT3043ShokanShokujiHiyoDac 償還払請求食事費用Dac;
    private final DbT3053ShokanShukeiDac 償還払請求集計Dac;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private final DbT7120TokuteiShinryoServiceCodeDac 特定診療サービスコードDac;
    private final DbT3038ShokanKihonDac 償還払請求基本Dac;
    private final DbT3107ShokanMeisaiJushochiTokureiDac 住所地特例Dac;
    private final DbT3039ShokanMeisaiDac 償還払請求明細Dac;
    private final DbT3041ShokanTokuteiShinryohiDac 償還払請求特定診療費Dac;
    private final DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac 特別療養費Dac;
    private final DbT3051ShokanShakaiFukushiHojinKeigengakuDac 償還払請求社会福祉法人軽減額Dac;
    private final DbT3052ShokanShoteiShikkanShisetsuRyoyoDac 償還払請求所定疾患施設療養費等Dac;
    private final DbT3040ShokanKinkyuShisetsuRyoyoDac 償還払請求緊急時施設療養Dac;
    private final DbT3118ShikibetsuNoKanriDac 識別番号管理Dac;
    private static final RString モード_登録 = new RString("登録");
    private static final RString モード_修正 = new RString("修正");
    private static final RString モード_削除 = new RString("削除");

    /**
     * コンストラクタです。
     */
    SyokanbaraihiShikyuShinseiKetteManager() {
        this.償還払請求特定入所者介護サービス費用Dac
                = InstanceProvider.create(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac.class);
        this.償還払請求サービス計画200904Dac = InstanceProvider.create(DbT3047ShokanServicePlan200904Dac.class);
        this.償還払請求サービス計画200604Dac = InstanceProvider.create(DbT3046ShokanServicePlan200604Dac.class);
        this.償還払請求サービス計画200004Dac = InstanceProvider.create(DbT3045ShokanServicePlan200004Dac.class);
        this.償還払請求食事費用Dac = InstanceProvider.create(DbT3043ShokanShokujiHiyoDac.class);
        this.償還払請求集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        this.償還払支給申請Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
        this.特定診療サービスコードDac = InstanceProvider.create(DbT7120TokuteiShinryoServiceCodeDac.class);
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
        this.識別番号管理Dac = InstanceProvider.create(DbT3118ShikibetsuNoKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SyokanbaraihiShikyuShinseiKetteManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SyokanbaraihiShikyuShinseiKetteManager}のインスタンス
     */
    public static SyokanbaraihiShikyuShinseiKetteManager createInstance() {

        return InstanceProvider.create(SyokanbaraihiShikyuShinseiKetteManager.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 特定診療サービスコードDac
     */
    SyokanbaraihiShikyuShinseiKetteManager(
            DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac 償還払請求特定入所者介護サービス費用Dac,
            DbT3047ShokanServicePlan200904Dac 償還払請求サービス計画200904Dac,
            DbT3046ShokanServicePlan200604Dac 償還払請求サービス計画200604Dac,
            DbT3045ShokanServicePlan200004Dac 償還払請求サービス計画200004Dac,
            DbT3043ShokanShokujiHiyoDac 償還払請求食事費用Dac,
            DbT3053ShokanShukeiDac 償還払請求集計Dac,
            DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac,
            DbT3034ShokanShinseiDac 償還払支給申請Dac,
            DbT7120TokuteiShinryoServiceCodeDac 特定診療サービスコードDac,
            DbT3038ShokanKihonDac 償還払請求基本Dac,
            DbT3107ShokanMeisaiJushochiTokureiDac 住所地特例Dac,
            DbT3039ShokanMeisaiDac 償還払請求明細Dac,
            DbT3041ShokanTokuteiShinryohiDac 償還払請求特定診療費Dac,
            DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac 特別療養費Dac,
            DbT3051ShokanShakaiFukushiHojinKeigengakuDac 償還払請求社会福祉法人軽減額Dac,
            DbT3052ShokanShoteiShikkanShisetsuRyoyoDac 償還払請求所定疾患施設療養費等Dac,
            DbT3040ShokanKinkyuShisetsuRyoyoDac 償還払請求緊急時施設療養Dac,
            DbT3118ShikibetsuNoKanriDac 識別番号管理Dac
    ) {
        this.償還払請求特定入所者介護サービス費用Dac = 償還払請求特定入所者介護サービス費用Dac;
        this.償還払請求サービス計画200904Dac = 償還払請求サービス計画200904Dac;
        this.償還払請求サービス計画200604Dac = 償還払請求サービス計画200604Dac;
        this.償還払請求サービス計画200004Dac = 償還払請求サービス計画200004Dac;
        this.償還払請求食事費用Dac = 償還払請求食事費用Dac;
        this.償還払請求集計Dac = 償還払請求集計Dac;
        this.償還払支給判定結果Dac = 償還払支給判定結果Dac;
        this.償還払支給申請Dac = 償還払支給申請Dac;
        this.特定診療サービスコードDac = 特定診療サービスコードDac;
        this.償還払請求基本Dac = 償還払請求基本Dac;
        this.住所地特例Dac = 住所地特例Dac;
        this.償還払請求明細Dac = 償還払請求明細Dac;
        this.償還払請求特定診療費Dac = 償還払請求特定診療費Dac;
        this.特別療養費Dac = 特別療養費Dac;
        this.償還払請求社会福祉法人軽減額Dac = 償還払請求社会福祉法人軽減額Dac;
        this.償還払請求所定疾患施設療養費等Dac = 償還払請求所定疾患施設療養費等Dac;
        this.償還払請求緊急時施設療養Dac = 償還払請求緊急時施設療養Dac;
        this.識別番号管理Dac = 識別番号管理Dac;
    }

    /**
     * 償還払支給判定結果取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @return DbT3036ShokanHanteiKekkaEntity
     */
    public DbT3036ShokanHanteiKekkaEntity getSyokanbaraiketteKekka(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        DbT3036ShokanHanteiKekkaEntity entity
                = 償還払支給判定結果Dac.selectByKey(被保険者番号, サービス提供年月, 整理番号);
        return entity;
    }

    /**
     * 証明書件数取得する。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @return 取得件数
     */
    public int getShikibetsuNoKanri(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号) {
        int 件数 = 償還払請求基本Dac.selectデータ件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号);
        if (件数 > 0) {
            return 件数;
        }
        if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス提供年月)) {
            return 償還払請求サービス計画200904Dac.selectデータ件数(被保険者番号,
                    サービス提供年月, 整理番号, 事業者番号, 様式番号);
        }
        if (new FlexibleYearMonth("200604").isBeforeOrEquals(サービス提供年月)) {
            return 償還払請求サービス計画200604Dac.selectデータ件数(被保険者番号,
                    サービス提供年月, 整理番号, 事業者番号, 様式番号);
        }
        return 償還払請求サービス計画200004Dac.selectデータ件数(被保険者番号,
                サービス提供年月, 整理番号, 事業者番号, 様式番号);
    }

    /**
     * 識別番号管理情報取得する。
     *
     * @param サービス提供年月
     * @param 識別番号
     * @return DbT3118ShikibetsuNoKanriEntity
     */
    public DbT3118ShikibetsuNoKanriEntity getShikibetsuNoKanri(FlexibleYearMonth サービス提供年月,
            RString 識別番号) {
        DbT3118ShikibetsuNoKanriEntity entity = 識別番号管理Dac.select識別番号管理(識別番号, サービス提供年月);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return entity;
    }

    /**
     * 支給申請登録
     *
     * @param parameter
     * @return 整理番号
     */
    public RString insDbT3034ShokanShinsei(ShokanShinseiParameter parameter) {

        RString 整理番号
                = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.実績管理番号.getコード()).nextString();

        DbT3034ShokanShinseiEntity entity = new DbT3034ShokanShinseiEntity();
        entity.setHiHokenshaNo(parameter.get被保険者番号());
        entity.setServiceTeikyoYM(parameter.get提供購入年月());
        entity.setSeiriNo(整理番号);
        entity.setShoKisaiHokenshaNo(parameter.get証記載保険者番号());
        entity.setUketsukeYMD(parameter.get受付年月日());
        entity.setShinseiYMD(parameter.get申請日());
        entity.setShinseiRiyu(parameter.get申請理由());
        entity.setShinseishaKubun(parameter.get申請者区分());
        entity.setShinseishaNameKanji(parameter.get氏名());
        entity.setShinseishaNameKana(parameter.get氏名カナ());
        entity.setShinseishaTelNo(parameter.get電話番号());
        entity.setShiharaiKingakuTotal(parameter.get支払金額合計());
        entity.setHokenTaishoHiyogaku(parameter.get支払金額合計());
        entity.setHokenKyufuritsu(parameter.get保険給付額());
        entity.setRiyoshaFutangaku(parameter.get利用者給付額());
        entity.setShikyuShinseiShinsaKubun(parameter.get支給申請審査区分());
        entity.setShinsaHohoKubun(parameter.get審査方法区分());
        entity.setKokuhorenSaisofuFlag(parameter.is国保連再送付フラグ());
        entity.setState(EntityDataState.Added);
        償還払支給申請Dac.save(entity);
        return 整理番号;
    }

    /**
     * 支給申請更新
     *
     * @param parameter
     */
    public void updDbT3034ShokanShinsei(ShokanShinseiParameter parameter) {

        DbT3034ShokanShinseiEntity entity = new DbT3034ShokanShinseiEntity();
        entity.setHiHokenshaNo(parameter.get被保険者番号());
        entity.setServiceTeikyoYM(parameter.get提供購入年月());
        entity.setSeiriNo(parameter.get整理番号());
        entity.setShoKisaiHokenshaNo(parameter.get証記載保険者番号());
        entity.setUketsukeYMD(parameter.get受付年月日());
        entity.setShinseiYMD(parameter.get申請日());
        entity.setShinseiRiyu(parameter.get申請理由());
        entity.setShinseishaKubun(parameter.get申請者区分());
        entity.setShinseishaNameKanji(parameter.get氏名());
        entity.setShinseishaNameKana(parameter.get氏名カナ());
        entity.setShinseishaTelNo(parameter.get電話番号());
        entity.setShiharaiKingakuTotal(parameter.get支払金額合計());
        entity.setHokenTaishoHiyogaku(parameter.get支払金額合計());
        entity.setHokenKyufuritsu(parameter.get保険給付額());
        entity.setRiyoshaFutangaku(parameter.get利用者給付額());
        entity.setShiharaiHohoKubunCode(parameter.get選択された支払方法コード());
        entity.setShiharaiBasho(parameter.get支払場所());
        entity.setShiharaiKaishiYMD(parameter.get支払期間開始年月日());
        entity.setShiharaiShuryoYMD(parameter.get支払期間終了年月日());
        entity.setShiharaiKaishiTime(parameter.get支払窓口開始時間());
        entity.setShiharaiShuryoTime(parameter.get支払窓口終了時間());
        entity.setKozaID(parameter.get口座ID());
        entity.setJuryoininKeiyakuNo(parameter.get受領委任契約番号());
        entity.setState(EntityDataState.Modified);
        償還払支給申請Dac.save(entity);
    }

    /**
     * 支給申請削除
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 識別コード
     */
    public void delDbT3034ShokanShinsei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            ShikibetsuCode 識別コード) {
        boolean 給付実績処理フラグ;
        KyufujissekiEntity Kyufuentity = null;
        DbT3036ShokanHanteiKekkaEntity entity = 償還払支給判定結果Dac.selectByKey(被保険者番号,
                サービス提供年月, 整理番号);
        if (entity == null) {
            給付実績処理フラグ = false;
        } else {
            Kyufuentity = getKyufujisseki(被保険者番号, サービス提供年月, 整理番号);
            entity.setHiHokenshaNo(被保険者番号);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setSeiriNo(整理番号);
            entity.setState(EntityDataState.Deleted);
            償還払支給判定結果Dac.save(entity);
            給付実績処理フラグ = true;
        }
        DbT3038ShokanKihonEntity DbT3038entity = new DbT3038ShokanKihonEntity();
        DbT3038entity.setHiHokenshaNo(被保険者番号);
        DbT3038entity.setServiceTeikyoYM(サービス提供年月);
        DbT3038entity.setSeiriNp(整理番号);
        DbT3038entity.setState(EntityDataState.Deleted);
        償還払請求基本Dac.save(DbT3038entity);

        DbT3107ShokanMeisaiJushochiTokureiEntity DbT3107entity = new DbT3107ShokanMeisaiJushochiTokureiEntity();
        DbT3107entity.setHiHokenshaNo(被保険者番号);
        DbT3107entity.setServiceTeikyoYM(サービス提供年月);
        DbT3107entity.setSeiriNp(整理番号);
        DbT3107entity.setState(EntityDataState.Deleted);
        住所地特例Dac.save(DbT3107entity);

        DbT3039ShokanMeisaiEntity DbT3039entity = new DbT3039ShokanMeisaiEntity();
        DbT3039entity.setHiHokenshaNo(被保険者番号);
        DbT3039entity.setServiceTeikyoYM(サービス提供年月);
        DbT3039entity.setSeiriNp(整理番号);
        DbT3039entity.setState(EntityDataState.Deleted);
        償還払請求明細Dac.save(DbT3039entity);

        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200303"))) {
            DbT3041ShokanTokuteiShinryohiEntity DbT3041entity = new DbT3041ShokanTokuteiShinryohiEntity();
            DbT3041entity.setHiHokenshaNo(被保険者番号);
            DbT3041entity.setServiceTeikyoYM(サービス提供年月);
            DbT3041entity.setSeiriNo(整理番号);
            DbT3041entity.setState(EntityDataState.Deleted);
            償還払請求特定診療費Dac.save(DbT3041entity);
        } else {
            DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity DbT3042entity
                    = new DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
            DbT3042entity.setHiHokenshaNo(被保険者番号);
            DbT3042entity.setServiceTeikyoYM(サービス提供年月);
            DbT3042entity.setSeiriNo(整理番号);
            DbT3042entity.setState(EntityDataState.Deleted);
            特別療養費Dac.save(DbT3042entity);
        }

        if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス提供年月)) {
            DbT3047ShokanServicePlan200904Entity DbT3047entity = new DbT3047ShokanServicePlan200904Entity();
            DbT3047entity.setHiHokenshaNo(被保険者番号);
            DbT3047entity.setServiceTeikyoYM(サービス提供年月);
            DbT3047entity.setSeiriNp(整理番号);
            DbT3047entity.setState(EntityDataState.Deleted);
            償還払請求サービス計画200904Dac.save(DbT3047entity);
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200903"))
                && new FlexibleYearMonth("200604").isBeforeOrEquals(サービス提供年月)) {
            DbT3046ShokanServicePlan200604Entity DbT3046entity = new DbT3046ShokanServicePlan200604Entity();
            DbT3046entity.setHiHokenshaNo(被保険者番号);
            DbT3046entity.setServiceTeikyoYM(サービス提供年月);
            DbT3046entity.setSeiriNp(整理番号);
            DbT3046entity.setState(EntityDataState.Deleted);
            償還払請求サービス計画200604Dac.save(DbT3046entity);
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
            DbT3045ShokanServicePlan200004Entity DbT3045entity = new DbT3045ShokanServicePlan200004Entity();
            DbT3045entity.setHiHokenshaNo(被保険者番号);
            DbT3045entity.setServiceTeikyoYM(サービス提供年月);
            DbT3045entity.setSeiriNp(整理番号);
            DbT3045entity.setState(EntityDataState.Deleted);
            償還払請求サービス計画200004Dac.save(DbT3045entity);
        }

        DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity DbT3050entity
                = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
        DbT3050entity.setHiHokenshaNo(被保険者番号);
        DbT3050entity.setServiceTeikyoYM(サービス提供年月);
        DbT3050entity.setSeiriNo(整理番号);
        DbT3050entity.setState(EntityDataState.Deleted);
        償還払請求特定入所者介護サービス費用Dac.save(DbT3050entity);

        DbT3051ShokanShakaiFukushiHojinKeigengakuEntity DbT3051ntity
                = new DbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
        DbT3051ntity.setHiHokenshaNo(被保険者番号);
        DbT3051ntity.setServiceTeikyoYM(サービス提供年月);
        DbT3051ntity.setSeiriNo(整理番号);
        DbT3051ntity.setState(EntityDataState.Deleted);
        償還払請求社会福祉法人軽減額Dac.save(DbT3051ntity);

        DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity DbT3052ntity
                = new DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
        DbT3052ntity.setHiHokenshaNo(被保険者番号);
        DbT3052ntity.setServiceTeikyoYM(サービス提供年月);
        DbT3052ntity.setSeiriNo(整理番号);
        DbT3052ntity.setState(EntityDataState.Deleted);
        償還払請求所定疾患施設療養費等Dac.save(DbT3052ntity);

        DbT3040ShokanKinkyuShisetsuRyoyoEntity DbT3040ntity = new DbT3040ShokanKinkyuShisetsuRyoyoEntity();
        DbT3040ntity.setHiHokenshaNo(被保険者番号);
        DbT3040ntity.setServiceTeikyoYM(サービス提供年月);
        DbT3040ntity.setSeiriNo(整理番号);
        DbT3040ntity.setState(EntityDataState.Deleted);
        償還払請求緊急時施設療養Dac.save(DbT3040ntity);

        DbT3053ShokanShukeiEntity DbT3053entity = new DbT3053ShokanShukeiEntity();
        DbT3053entity.setHiHokenshaNo(被保険者番号);
        DbT3053entity.setServiceTeikyoYM(サービス提供年月);
        DbT3053entity.setSeiriNo(整理番号);
        DbT3053entity.setState(EntityDataState.Deleted);
        償還払請求集計Dac.save(DbT3053entity);

        DbT3043ShokanShokujiHiyoEntity DbT3043ntity = new DbT3043ShokanShokujiHiyoEntity();
        DbT3043ntity.setHiHokenshaNo(被保険者番号);
        DbT3043ntity.setServiceTeikyoYM(サービス提供年月);
        DbT3043ntity.setSeiriNp(整理番号);
        DbT3043ntity.setState(EntityDataState.Deleted);
        償還払請求食事費用Dac.save(DbT3043ntity);

        DbT3034ShokanShinseiEntity DbT3034ntity = new DbT3034ShokanShinseiEntity();
        DbT3034ntity.setHiHokenshaNo(被保険者番号);
        DbT3034ntity.setServiceTeikyoYM(サービス提供年月);
        DbT3034ntity.setSeiriNo(整理番号);
        DbT3034ntity.setState(EntityDataState.Deleted);
        償還払支給申請Dac.save(DbT3034ntity);

        if (給付実績処理フラグ) {
            SyokanbaraiShikyuKetteKyufuJssekiHensyuManager manager
                    = SyokanbaraiShikyuKetteKyufuJssekiHensyuManager.createInstance();
            manager.dealKyufujisseki(new RString("削除"), 識別コード, Kyufuentity, null);
        }
    }

    /**
     * 証明書管理一覧取得
     *
     * @param サービス提供年月
     * @return List<DbT3118ShikibetsuNoKanri>
     */
    public List<DbT3118ShikibetsuNoKanriEntity> getShikibetsuNoKanri(FlexibleYearMonth サービス提供年月) {

        RString 福祉用具販売費 = NyuryokuShikibetsuNoShokan3Keta.福祉用具販売費.getコード();
        RString 住宅改修費 = NyuryokuShikibetsuNoShokan3Keta.住宅改修費.getコード();
        List<DbT3118ShikibetsuNoKanriEntity> entityList
                = 識別番号管理Dac.select識別番号管理(サービス提供年月, 福祉用具販売費, 住宅改修費);
        if (entityList == null) {
            return new ArrayList<>();
        }
        for (DbT3118ShikibetsuNoKanriEntity entity : entityList) {
            entity.initializeMd5();
        }
        return entityList;
    }

    /**
     * 基本情報件数を取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public int getShokanKihonCount(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        DbT3038ShokanKihonEntity entity = 償還払請求基本Dac.selectByKey(被保険者番号, サービス提供年月,
                整理番号, 事業者番号, 様式番号, 明細番号);
        if (entity == null) {
            return 0;
        }
        return 1;
    }

    /**
     * 給付費明細（住特）情報件数します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public int getShokanMeisaiJushochiTokureiCount(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 住所地特例Dac.selectデータ件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 給付費明細情報件数します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public int delShokanMeisaiCount(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求明細Dac.selectデータ件数(被保険者番号, サービス提供年月,
                整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 特定診療費情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public int updShokanTokuteiShinryohi(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200303"))) {
            return 償還払請求特定診療費Dac.select件数(被保険者番号, サービス提供年月,
                    整理番号, 事業者番号, 様式番号, 明細番号);
        }
        return 特別療養費Dac.select件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 特定入所者費用情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public int updShokanTokuteiNyushoshaKaigoServiceHiyo(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求特定入所者介護サービス費用Dac.select件数(被保険者番号, サービス提供年月,
                整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 社福軽減額情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public int updShokanShakaiFukushiHojinKeigengaku(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求社会福祉法人軽減額Dac.select件数(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号, 明細番号);
    }

    /**
     * 緊急時・所定疾患情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public int updShokanShoteiShikkanShisetsuRyoyo(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求所定疾患施設療養費等Dac.select件数(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号, 明細番号);
    }

    /**
     * 緊急時施設療養費情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public int updShokanKinkyuShisetsuRyoyo(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求緊急時施設療養Dac.select件数(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号, 明細番号);
    }

    /**
     * 請求額集計情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public int updShokanShukei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求集計Dac.select件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 食事費用情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public int updShokanShokujiHiyo(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求食事費用Dac.select件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 明細番号);
    }

    /**
     * 証明書削除処理
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     */
    public void delShokanSyomeisyo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {

        DbT3038ShokanKihonEntity dbT3038entity = new DbT3038ShokanKihonEntity();
        dbT3038entity.setHiHokenshaNo(被保険者番号);
        dbT3038entity.setServiceTeikyoYM(サービス提供年月);
        dbT3038entity.setSeiriNp(整理番号);
        dbT3038entity.setJigyoshaNo(事業者番号);
        dbT3038entity.setYoshikiNo(様式番号);
        dbT3038entity.setMeisaiNo(明細番号);
        dbT3038entity.setState(EntityDataState.Deleted);
        償還払請求基本Dac.save(dbT3038entity);

        DbT3107ShokanMeisaiJushochiTokureiEntity dbT3107entity = new DbT3107ShokanMeisaiJushochiTokureiEntity();
        dbT3107entity.setHiHokenshaNo(被保険者番号);
        dbT3107entity.setServiceTeikyoYM(サービス提供年月);
        dbT3107entity.setSeiriNp(整理番号);
        dbT3107entity.setJigyoshaNo(事業者番号);
        dbT3107entity.setYoshikiNo(様式番号);
        dbT3107entity.setMeisaiNo(明細番号);
        dbT3107entity.setState(EntityDataState.Deleted);
        住所地特例Dac.save(dbT3107entity);

        DbT3039ShokanMeisaiEntity dbT3039entity = new DbT3039ShokanMeisaiEntity();
        dbT3039entity.setHiHokenshaNo(被保険者番号);
        dbT3039entity.setServiceTeikyoYM(サービス提供年月);
        dbT3039entity.setSeiriNp(整理番号);
        dbT3039entity.setJigyoshaNo(事業者番号);
        dbT3039entity.setYoshikiNo(様式番号);
        dbT3039entity.setMeisaiNo(明細番号);
        dbT3039entity.setState(EntityDataState.Deleted);
        償還払請求明細Dac.save(dbT3039entity);

        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200303"))) {
            DbT3041ShokanTokuteiShinryohiEntity dbT3041entity = new DbT3041ShokanTokuteiShinryohiEntity();
            dbT3041entity.setHiHokenshaNo(被保険者番号);
            dbT3041entity.setServiceTeikyoYM(サービス提供年月);
            dbT3041entity.setSeiriNo(整理番号);
            dbT3041entity.setJigyoshaNo(事業者番号);
            dbT3041entity.setYoshikiNo(様式番号);
            dbT3041entity.setMeisaiNo(明細番号);
            dbT3041entity.setState(EntityDataState.Deleted);
            償還払請求特定診療費Dac.save(dbT3041entity);
        } else {
            DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity dbT3042entity
                    = new DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
            dbT3042entity.setHiHokenshaNo(被保険者番号);
            dbT3042entity.setServiceTeikyoYM(サービス提供年月);
            dbT3042entity.setSeiriNo(整理番号);
            dbT3042entity.setJigyoshaNo(事業者番号);
            dbT3042entity.setYoshikiNo(様式番号);
            dbT3042entity.setMeisaiNo(明細番号);
            dbT3042entity.setState(EntityDataState.Deleted);
            特別療養費Dac.save(dbT3042entity);
        }

        if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス提供年月)) {
            DbT3047ShokanServicePlan200904Entity dbT3047entity = new DbT3047ShokanServicePlan200904Entity();
            dbT3047entity.setHiHokenshaNo(被保険者番号);
            dbT3047entity.setServiceTeikyoYM(サービス提供年月);
            dbT3047entity.setSeiriNp(整理番号);
            dbT3047entity.setJigyoshaNo(事業者番号);
            dbT3047entity.setYoshikiNo(様式番号);
            dbT3047entity.setMeisaiNo(明細番号);
            dbT3047entity.setState(EntityDataState.Deleted);
            償還払請求サービス計画200904Dac.save(dbT3047entity);
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200903"))
                && new FlexibleYearMonth("200604").isBeforeOrEquals(サービス提供年月)) {
            DbT3046ShokanServicePlan200604Entity dbT3046entity = new DbT3046ShokanServicePlan200604Entity();
            dbT3046entity.setHiHokenshaNo(被保険者番号);
            dbT3046entity.setServiceTeikyoYM(サービス提供年月);
            dbT3046entity.setSeiriNp(整理番号);
            dbT3046entity.setJigyoshaNo(事業者番号);
            dbT3046entity.setYoshikiNo(様式番号);
            dbT3046entity.setMeisaiNo(明細番号);
            dbT3046entity.setState(EntityDataState.Deleted);
            償還払請求サービス計画200604Dac.save(dbT3046entity);
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
            DbT3045ShokanServicePlan200004Entity dbT3045entity = new DbT3045ShokanServicePlan200004Entity();
            dbT3045entity.setHiHokenshaNo(被保険者番号);
            dbT3045entity.setServiceTeikyoYM(サービス提供年月);
            dbT3045entity.setSeiriNp(整理番号);
            dbT3045entity.setJigyoshaNo(事業者番号);
            dbT3045entity.setYoshikiNo(様式番号);
            dbT3045entity.setMeisaiNo(明細番号);
            dbT3045entity.setState(EntityDataState.Deleted);
            償還払請求サービス計画200004Dac.save(dbT3045entity);
        }
        DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity dbT3050entity
                = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
        dbT3050entity.setHiHokenshaNo(被保険者番号);
        dbT3050entity.setServiceTeikyoYM(サービス提供年月);
        dbT3050entity.setSeiriNo(整理番号);
        dbT3050entity.setJigyoshaNo(事業者番号);
        dbT3050entity.setYoshikiNo(様式番号);
        dbT3050entity.setMeisaiNo(明細番号);
        dbT3050entity.setState(EntityDataState.Deleted);
        償還払請求特定入所者介護サービス費用Dac.save(dbT3050entity);

        DbT3051ShokanShakaiFukushiHojinKeigengakuEntity dbT3051entity
                = new DbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
        dbT3051entity.setHiHokenshaNo(被保険者番号);
        dbT3051entity.setServiceTeikyoYM(サービス提供年月);
        dbT3051entity.setSeiriNo(整理番号);
        dbT3051entity.setJigyoshaNo(事業者番号);
        dbT3051entity.setYoshikiNo(様式番号);
        dbT3051entity.setMeisaiNo(明細番号);
        dbT3051entity.setState(EntityDataState.Deleted);
        償還払請求社会福祉法人軽減額Dac.save(dbT3051entity);

        DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity dbT3052entity
                = new DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
        dbT3052entity.setHiHokenshaNo(被保険者番号);
        dbT3052entity.setServiceTeikyoYM(サービス提供年月);
        dbT3052entity.setSeiriNo(整理番号);
        dbT3052entity.setJigyoshaNo(事業者番号);
        dbT3052entity.setYoshikiNo(様式番号);
        dbT3052entity.setMeisaiNo(明細番号);
        dbT3052entity.setState(EntityDataState.Deleted);
        償還払請求所定疾患施設療養費等Dac.save(dbT3052entity);

        DbT3040ShokanKinkyuShisetsuRyoyoEntity dbT3040entity = new DbT3040ShokanKinkyuShisetsuRyoyoEntity();
        dbT3040entity.setHiHokenshaNo(被保険者番号);
        dbT3040entity.setServiceTeikyoYM(サービス提供年月);
        dbT3040entity.setSeiriNo(整理番号);
        dbT3040entity.setJigyoshaNo(事業者番号);
        dbT3040entity.setYoshikiNo(様式番号);
        dbT3040entity.setMeisaiNo(明細番号);
        dbT3040entity.setState(EntityDataState.Deleted);
        償還払請求緊急時施設療養Dac.save(dbT3040entity);

        DbT3053ShokanShukeiEntity dbT3053entity = new DbT3053ShokanShukeiEntity();
        dbT3053entity.setHiHokenshaNo(被保険者番号);
        dbT3053entity.setServiceTeikyoYM(サービス提供年月);
        dbT3053entity.setSeiriNo(整理番号);
        dbT3053entity.setJigyoshaNo(事業者番号);
        dbT3053entity.setYoshikiNo(様式番号);
        dbT3053entity.setMeisaiNo(明細番号);
        dbT3053entity.setState(EntityDataState.Deleted);
        償還払請求集計Dac.save(dbT3053entity);

        DbT3043ShokanShokujiHiyoEntity dbT3043entity = new DbT3043ShokanShokujiHiyoEntity();
        dbT3043entity.setHiHokenshaNo(被保険者番号);
        dbT3043entity.setServiceTeikyoYM(サービス提供年月);
        dbT3043entity.setSeiriNp(整理番号);
        dbT3043entity.setJigyoshaNo(事業者番号);
        dbT3043entity.setYoshikiNo(様式番号);
        dbT3043entity.setMeisaiNo(明細番号);
        dbT3043entity.setState(EntityDataState.Deleted);
        償還払請求食事費用Dac.save(dbT3043entity);
    }

    /**
     * 基本情報登録更新処理
     *
     * @param paramter
     * @return 明細番号
     */
    public RString updShokanKihon(ShokanKihonParameter paramter) {

        RString 明細番号;
        if (paramter.get明細番号() == null || paramter.get明細番号().isEmpty()) {
            明細番号 = new RString("0001");
            DbT3038ShokanKihonEntity dbT3038entity = new DbT3038ShokanKihonEntity();
            dbT3038entity.setHiHokenshaNo(paramter.get被保険者番号());
            dbT3038entity.setServiceTeikyoYM(paramter.get提供購入年月());
            dbT3038entity.setSeiriNp(paramter.get整理番号());
            dbT3038entity.setJigyoshaNo(paramter.get事業者番号());
            dbT3038entity.setYoshikiNo(paramter.get証明書コード());
            dbT3038entity.setMeisaiNo(明細番号);
            dbT3038entity.setKyuSochiNyushoshaTokureiCode(paramter.get旧措置入所者特例コード());
            dbT3038entity.setKyotakuServiceSakuseiKubunCode(paramter.get計画作成区分());
            dbT3038entity.setKyotakuserviceJigyoshaNo(paramter.get事業者番号());
            dbT3038entity.setKaishiYMD(paramter.getサービス期間FROM());
            dbT3038entity.setChushiYMD(paramter.getサービス期間TO());
            dbT3038entity.setChushiRiyuNyushomaeJyokyoCode(paramter.get中止理由入所院前の状況());
            dbT3038entity.setNyushoYMD(paramter.get入所院年月日());
            dbT3038entity.setTaishoYMD(paramter.get退所院年月日());
            dbT3038entity.setNyushoJitsuNissu(paramter.get入所院実日数());
            dbT3038entity.setGaihakuNissu(paramter.get外泊日数());
            dbT3038entity.setTaishogoJotaiCode(paramter.get退所院後の状態コード());
            dbT3038entity.setHokenKyufuritsu(paramter.get給付率());
            dbT3038entity.setState(EntityDataState.Added);
            償還払請求基本Dac.save(dbT3038entity);
        } else {
            明細番号 = paramter.get明細番号();
            DbT3038ShokanKihonEntity dbT3038entity = new DbT3038ShokanKihonEntity();
            dbT3038entity.setHiHokenshaNo(paramter.get被保険者番号());
            dbT3038entity.setServiceTeikyoYM(paramter.get提供購入年月());
            dbT3038entity.setSeiriNp(paramter.get整理番号());
            dbT3038entity.setJigyoshaNo(paramter.get事業者番号());
            dbT3038entity.setYoshikiNo(paramter.get証明書コード());
            dbT3038entity.setMeisaiNo(paramter.get明細番号());
            dbT3038entity.setKyuSochiNyushoshaTokureiCode(paramter.get旧措置入所者特例コード());
            dbT3038entity.setKyotakuServiceSakuseiKubunCode(paramter.get計画作成区分());
            dbT3038entity.setKyotakuserviceJigyoshaNo(paramter.get事業者番号());
            dbT3038entity.setKaishiYMD(paramter.getサービス期間FROM());
            dbT3038entity.setChushiYMD(paramter.getサービス期間TO());
            dbT3038entity.setChushiRiyuNyushomaeJyokyoCode(paramter.get中止理由入所院前の状況());
            dbT3038entity.setNyushoYMD(paramter.get入所院年月日());
            dbT3038entity.setTaishoYMD(paramter.get退所院年月日());
            dbT3038entity.setNyushoJitsuNissu(paramter.get入所院実日数());
            dbT3038entity.setGaihakuNissu(paramter.get外泊日数());
            dbT3038entity.setTaishogoJotaiCode(paramter.get退所院後の状態コード());
            dbT3038entity.setHokenKyufuritsu(paramter.get給付率());
            dbT3038entity.setState(EntityDataState.Modified);
            償還払請求基本Dac.save(dbT3038entity);
        }
        return 明細番号;
    }

    /**
     * 給付費明細（住特）登録更新処理
     *
     * @param parameter
     */
    public void updShokanMeisaiJushochiTokurei(ShokanMeisaiJushochiTokureiParameter parameter) {

        List<ShokanMeisaiJushochiTokureiEntity> 給付費明細住特List = parameter.get給付費明細住特List();
        if (給付費明細住特List != null && !給付費明細住特List.isEmpty()) {
            for (ShokanMeisaiJushochiTokureiEntity 給付費明細住特 : 給付費明細住特List) {
                if (モード_登録.equals(給付費明細住特.get状態())) {
                    DbT3107ShokanMeisaiJushochiTokureiEntity entity = new DbT3107ShokanMeisaiJushochiTokureiEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNp(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(給付費明細住特.get連番());
                    entity.setServiceShuruiCode(給付費明細住特.getサービス種類コード());
                    entity.setServiceKomokuCode(給付費明細住特.getサービス項目コード());
                    entity.setTanisu(給付費明細住特.get単位());
                    entity.setNissuKaisu(給付費明細住特.get回数日数());
                    entity.setServiceTanisu(給付費明細住特.getサービス単位());
                    entity.setShisetsuShozaiHokenshaNo(給付費明細住特.get施設所在保険者番号());
                    entity.setTekiyo(給付費明細住特.get摘要());
                    entity.setState(EntityDataState.Added);
                    住所地特例Dac.save(entity);
                } else if (モード_修正.equals(給付費明細住特.get状態())) {
                    DbT3107ShokanMeisaiJushochiTokureiEntity entity = new DbT3107ShokanMeisaiJushochiTokureiEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNp(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(給付費明細住特.get連番());
                    entity.setServiceShuruiCode(給付費明細住特.getサービス種類コード());
                    entity.setServiceKomokuCode(給付費明細住特.getサービス項目コード());
                    entity.setTanisu(給付費明細住特.get単位());
                    entity.setNissuKaisu(給付費明細住特.get回数日数());
                    entity.setServiceTanisu(給付費明細住特.getサービス単位());
                    entity.setShisetsuShozaiHokenshaNo(給付費明細住特.get施設所在保険者番号());
                    entity.setTekiyo(給付費明細住特.get摘要());
                    entity.setState(EntityDataState.Modified);
                    住所地特例Dac.save(entity);
                } else if (モード_削除.equals(給付費明細住特.get状態())) {
                    DbT3107ShokanMeisaiJushochiTokureiEntity entity = new DbT3107ShokanMeisaiJushochiTokureiEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNp(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(給付費明細住特.get連番());
                    entity.setState(EntityDataState.Deleted);
                    住所地特例Dac.save(entity);
                }
            }
        }
    }

    /**
     * 給付費明細登録更新処理
     *
     * @param parameter
     */
    public void updShokanMeisai(ShokanMeisaiParameter parameter) {

        List<ShokanMeisaiEntity> 給付費明細List = parameter.get給付費明細List();
        if (給付費明細List != null && !給付費明細List.isEmpty()) {
            for (ShokanMeisaiEntity 給付費明細 : 給付費明細List) {
                if (モード_登録.equals(給付費明細.get状態())) {
                    DbT3039ShokanMeisaiEntity entity = new DbT3039ShokanMeisaiEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNp(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(給付費明細.get連番());
                    entity.setServiceShuruiCode(給付費明細.getサービス種類コード());
                    entity.setServiceKomokuCode(給付費明細.getサービス項目コード());
                    entity.setTanisu(給付費明細.get単位());
                    entity.setNissuKaisu(給付費明細.get回数日数());
                    entity.setServiceTanisu(給付費明細.getサービス単位());
                    entity.setTekiyo(給付費明細.get摘要());
                    entity.setState(EntityDataState.Added);
                    償還払請求明細Dac.save(entity);
                } else if (モード_修正.equals(給付費明細.get状態())) {
                    DbT3039ShokanMeisaiEntity entity = new DbT3039ShokanMeisaiEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNp(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(給付費明細.get連番());
                    entity.setServiceShuruiCode(給付費明細.getサービス種類コード());
                    entity.setServiceKomokuCode(給付費明細.getサービス項目コード());
                    entity.setTanisu(給付費明細.get単位());
                    entity.setNissuKaisu(給付費明細.get回数日数());
                    entity.setServiceTanisu(給付費明細.getサービス単位());
                    entity.setTekiyo(給付費明細.get摘要());
                    entity.setState(EntityDataState.Modified);
                    償還払請求明細Dac.save(entity);
                } else if (モード_削除.equals(給付費明細.get状態())) {
                    DbT3039ShokanMeisaiEntity entity = new DbT3039ShokanMeisaiEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNp(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(給付費明細.get連番());
                    entity.setState(EntityDataState.Deleted);
                    償還払請求明細Dac.save(entity);
                }
            }
        }
    }

    /**
     * 特定診療費登録更新処理
     *
     * @param parameter
     */
    public void updShokanTokuteiShinryohi(ShokanTokuteiShinryohiParameter parameter) {

        int 合計金額 = 0;
        List<ShokanTokuteiShinryohiEntity> 特定診療費List = parameter.get特定診療費List();
        if (特定診療費List != null && !特定診療費List.isEmpty()) {
            if (parameter.get提供購入年月().isBeforeOrEquals(new FlexibleYearMonth("200303"))) {
                for (ShokanTokuteiShinryohiEntity 特定診療費 : 特定診療費List) {
                    if (モード_登録.equals(特定診療費.get状態())) {
                        合計金額 = 合計金額 + 特定診療費.get合計();
                        DbT3041ShokanTokuteiShinryohiEntity entity = new DbT3041ShokanTokuteiShinryohiEntity();
                        entity.setHiHokenshaNo(parameter.get被保険者番号());
                        entity.setServiceTeikyoYM(parameter.get提供購入年月());
                        entity.setSeiriNo(parameter.get整理番号());
                        entity.setJigyoshaNo(parameter.get事業者番号());
                        entity.setYoshikiNo(parameter.get証明書コード());
                        entity.setMeisaiNo(parameter.get明細番号());
                        entity.setRenban(特定診療費.get連番());
                        entity.setShobyoName(特定診療費.get傷病名());
                        entity.setShidoKanriryoTanisu(特定診療費.get指導管理());
                        entity.setTanjunXsenTanisu(特定診療費.getエックス線());
                        entity.setRehabilitationTanisu(特定診療費.getリハビリ());
                        entity.setSeishinkaSemmonRyoyohouTanisu(特定診療費.get精神科());
                        entity.setSochiTanisu(特定診療費.getその他1());
                        entity.setShujutsuTanisu(特定診療費.getその他2());
                        entity.setTotalTanisu(特定診療費.get合計());
                        entity.setTekiyo1(特定診療費.get摘要1());
                        entity.setTekiyo2(特定診療費.get摘要2());
                        entity.setTekiyo3(特定診療費.get摘要3());
                        entity.setTekiyo4(特定診療費.get摘要4());
                        entity.setTekiyo5(特定診療費.get摘要5());
                        entity.setTekiyo6(特定診療費.get摘要6());
                        entity.setTekiyo7(特定診療費.get摘要7());
                        entity.setTekiyo8(特定診療費.get摘要8());
                        entity.setTekiyo9(特定診療費.get摘要9());
                        entity.setTekiyo10(特定診療費.get摘要10());
                        entity.setTekiyo11(特定診療費.get摘要11());
                        entity.setTekiyo12(特定診療費.get摘要12());
                        entity.setTekiyo13(特定診療費.get摘要13());
                        entity.setTekiyo14(特定診療費.get摘要14());
                        entity.setTekiyo15(特定診療費.get摘要15());
                        entity.setTekiyo16(特定診療費.get摘要16());
                        entity.setTekiyo17(特定診療費.get摘要17());
                        entity.setTekiyo18(特定診療費.get摘要18());
                        entity.setTekiyo19(特定診療費.get摘要19());
                        entity.setTekiyo20(特定診療費.get摘要20());
                        entity.setState(EntityDataState.Added);
                        償還払請求特定診療費Dac.save(entity);
                    } else if (モード_修正.equals(特定診療費.get状態())) {
                        合計金額 = 合計金額 + 特定診療費.get合計();
                        DbT3041ShokanTokuteiShinryohiEntity entity = new DbT3041ShokanTokuteiShinryohiEntity();
                        entity.setHiHokenshaNo(parameter.get被保険者番号());
                        entity.setServiceTeikyoYM(parameter.get提供購入年月());
                        entity.setSeiriNo(parameter.get整理番号());
                        entity.setJigyoshaNo(parameter.get事業者番号());
                        entity.setYoshikiNo(parameter.get証明書コード());
                        entity.setMeisaiNo(parameter.get明細番号());
                        entity.setRenban(特定診療費.get連番());
                        entity.setShobyoName(特定診療費.get傷病名());
                        entity.setShidoKanriryoTanisu(特定診療費.get指導管理());
                        entity.setTanjunXsenTanisu(特定診療費.getエックス線());
                        entity.setRehabilitationTanisu(特定診療費.getリハビリ());
                        entity.setSeishinkaSemmonRyoyohouTanisu(特定診療費.get精神科());
                        entity.setSochiTanisu(特定診療費.getその他1());
                        entity.setShujutsuTanisu(特定診療費.getその他2());
                        entity.setTotalTanisu(特定診療費.get合計());
                        entity.setTekiyo1(特定診療費.get摘要1());
                        entity.setTekiyo2(特定診療費.get摘要2());
                        entity.setTekiyo3(特定診療費.get摘要3());
                        entity.setTekiyo4(特定診療費.get摘要4());
                        entity.setTekiyo5(特定診療費.get摘要5());
                        entity.setTekiyo6(特定診療費.get摘要6());
                        entity.setTekiyo7(特定診療費.get摘要7());
                        entity.setTekiyo8(特定診療費.get摘要8());
                        entity.setTekiyo9(特定診療費.get摘要9());
                        entity.setTekiyo10(特定診療費.get摘要10());
                        entity.setTekiyo11(特定診療費.get摘要11());
                        entity.setTekiyo12(特定診療費.get摘要12());
                        entity.setTekiyo13(特定診療費.get摘要13());
                        entity.setTekiyo14(特定診療費.get摘要14());
                        entity.setTekiyo15(特定診療費.get摘要15());
                        entity.setTekiyo16(特定診療費.get摘要16());
                        entity.setTekiyo17(特定診療費.get摘要17());
                        entity.setTekiyo18(特定診療費.get摘要18());
                        entity.setTekiyo19(特定診療費.get摘要19());
                        entity.setTekiyo20(特定診療費.get摘要20());
                        entity.setState(EntityDataState.Modified);
                        償還払請求特定診療費Dac.save(entity);
                    } else if (モード_削除.equals(特定診療費.get状態())) {
                        DbT3041ShokanTokuteiShinryohiEntity entity = new DbT3041ShokanTokuteiShinryohiEntity();
                        entity.setHiHokenshaNo(parameter.get被保険者番号());
                        entity.setServiceTeikyoYM(parameter.get提供購入年月());
                        entity.setSeiriNo(parameter.get整理番号());
                        entity.setJigyoshaNo(parameter.get事業者番号());
                        entity.setYoshikiNo(parameter.get証明書コード());
                        entity.setMeisaiNo(parameter.get明細番号());
                        entity.setRenban(特定診療費.get連番());
                        entity.setState(EntityDataState.Deleted);
                        償還払請求特定診療費Dac.save(entity);
                    }
                }
            } else {
                for (ShokanTokuteiShinryohiEntity 特定診療費 : 特定診療費List) {
                    if (モード_登録.equals(特定診療費.get状態())) {
                        合計金額 = 合計金額 + 特定診療費.get合計();
                        DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity
                                = new DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
                        entity.setHiHokenshaNo(parameter.get被保険者番号());
                        entity.setServiceTeikyoYM(parameter.get提供購入年月());
                        entity.setSeiriNo(parameter.get整理番号());
                        entity.setJigyoshaNo(parameter.get事業者番号());
                        entity.setYoshikiNo(parameter.get証明書コード());
                        entity.setMeisaiNo(parameter.get明細番号());
                        entity.setRenban(特定診療費.get連番());
                        entity.setShobyoName(特定診療費.get傷病名());
                        entity.setShikibetsuNo(特定診療費.get識別コード());
                        entity.setTanisu(特定診療費.get単位());
                        entity.setKaisu(特定診療費.get回数日数());
                        entity.setServiceTanisu(特定診療費.getサービス単位());
                        entity.setTotalTanisu(特定診療費.get合計());
                        entity.setTekiyo(特定診療費.get摘要());
                        entity.setState(EntityDataState.Added);
                        特別療養費Dac.save(entity);
                    } else if (モード_修正.equals(特定診療費.get状態())) {
                        合計金額 = 合計金額 + 特定診療費.get合計();
                        DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity
                                = new DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
                        entity.setHiHokenshaNo(parameter.get被保険者番号());
                        entity.setServiceTeikyoYM(parameter.get提供購入年月());
                        entity.setSeiriNo(parameter.get整理番号());
                        entity.setJigyoshaNo(parameter.get事業者番号());
                        entity.setYoshikiNo(parameter.get証明書コード());
                        entity.setMeisaiNo(parameter.get明細番号());
                        entity.setRenban(特定診療費.get連番());
                        entity.setShobyoName(特定診療費.get傷病名());
                        entity.setShikibetsuNo(特定診療費.get識別コード());
                        entity.setTanisu(特定診療費.get単位());
                        entity.setKaisu(特定診療費.get回数日数());
                        entity.setServiceTanisu(特定診療費.getサービス単位());
                        entity.setTotalTanisu(特定診療費.get合計());
                        entity.setTekiyo(特定診療費.get摘要());
                        entity.setState(EntityDataState.Modified);
                        特別療養費Dac.save(entity);
                    } else if (モード_削除.equals(特定診療費.get状態())) {
                        DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity
                                = new DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
                        entity.setHiHokenshaNo(parameter.get被保険者番号());
                        entity.setServiceTeikyoYM(parameter.get提供購入年月());
                        entity.setSeiriNo(parameter.get整理番号());
                        entity.setJigyoshaNo(parameter.get事業者番号());
                        entity.setYoshikiNo(parameter.get証明書コード());
                        entity.setMeisaiNo(parameter.get明細番号());
                        entity.setRenban(特定診療費.get連番());
                        entity.setState(EntityDataState.Deleted);
                        特別療養費Dac.save(entity);
                    }
                }
            }
            DbT3038ShokanKihonEntity dbT3038entity = new DbT3038ShokanKihonEntity();
            dbT3038entity.setHiHokenshaNo(parameter.get被保険者番号());
            dbT3038entity.setServiceTeikyoYM(parameter.get提供購入年月());
            dbT3038entity.setSeiriNp(parameter.get整理番号());
            dbT3038entity.setJigyoshaNo(parameter.get事業者番号());
            dbT3038entity.setYoshikiNo(parameter.get証明書コード());
            dbT3038entity.setMeisaiNo(parameter.get明細番号());
            dbT3038entity.setTokuteiShinryoSeikyugaku(new Decimal(合計金額));
            dbT3038entity.setState(EntityDataState.Modified);
            償還払請求基本Dac.save(dbT3038entity);
        }
    }

    /**
     * サービス計画費登録更新処理
     *
     * @param parameter
     * @return 明細番号
     */
    public RString updShokanServicePlan(ShokanServicePlanParameter parameter) {

        RString 明細番号 = null;
        List<ShokanServicePlanEntity> サービルList = parameter.getサービルList();
        if (new FlexibleYearMonth("200904").isBeforeOrEquals(parameter.getサービス提供年月())) {
            if (サービルList != null && !サービルList.isEmpty()) {
                if (parameter.get明細番号() == null || parameter.get明細番号().isEmpty()) {
                    明細番号 = new RString("0001");
                    for (ShokanServicePlanEntity サービル : サービルList) {
                        if (!モード_削除.equals(サービル.get状態())) {
                            DbT3047ShokanServicePlan200904Entity entity = new DbT3047ShokanServicePlan200904Entity();
                            entity.setHiHokenshaNo(parameter.get被保険者番号());
                            entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                            entity.setSeiriNp(parameter.get整理番号());
                            entity.setJigyoshaNo(parameter.get事業者番号());
                            entity.setYoshikiNo(parameter.get証明書コード());
                            entity.setMeisaiNo(明細番号);
                            entity.setRenban(サービル.get連番());
                            entity.setShiteiKijunGaitoJigyoshaKubunCode(サービル.get事業者区分コード());
                            entity.setKyotakuServiceSakuseiIraiYMD(サービル.get届出日());
                            entity.setServiceCode(サービル.getサービスコード());
                            entity.setTanisu(サービル.get単位数());
                            entity.setKaisu(サービル.get回数());
                            entity.setServiceTanisu(サービル.getサービス単位数());
                            entity.setTanisuTanka(サービル.get単位数単価());
                            entity.setServiceTanisuTotal(サービル.getサービス単位数合計());
                            entity.setTantokangoshienSemmoninNo(サービル.get担当介護支援専門員番号());
                            entity.setTekiyo(サービル.get摘要());
                            entity.setShinsaHohoKubunCode(サービル.get審査方法コード());
                            entity.setState(EntityDataState.Added);
                            償還払請求サービス計画200904Dac.save(entity);
                        }
                    }
                } else {
                    明細番号 = parameter.get明細番号();
                    for (ShokanServicePlanEntity サービル : サービルList) {
                        if (モード_登録.equals(サービル.get状態())) {
                            DbT3047ShokanServicePlan200904Entity entity = new DbT3047ShokanServicePlan200904Entity();
                            entity.setHiHokenshaNo(parameter.get被保険者番号());
                            entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                            entity.setSeiriNp(parameter.get整理番号());
                            entity.setJigyoshaNo(parameter.get事業者番号());
                            entity.setYoshikiNo(parameter.get証明書コード());
                            entity.setMeisaiNo(parameter.get明細番号());
                            entity.setRenban(サービル.get連番());
                            entity.setShiteiKijunGaitoJigyoshaKubunCode(サービル.get事業者区分コード());
                            entity.setKyotakuServiceSakuseiIraiYMD(サービル.get届出日());
                            entity.setServiceCode(サービル.getサービスコード());
                            entity.setTanisu(サービル.get単位数());
                            entity.setKaisu(サービル.get回数());
                            entity.setServiceTanisu(サービル.getサービス単位数());
                            entity.setTanisuTanka(サービル.get単位数単価());
                            entity.setServiceTanisuTotal(サービル.getサービス単位数合計());
                            entity.setTantokangoshienSemmoninNo(サービル.get担当介護支援専門員番号());
                            entity.setTekiyo(サービル.get摘要());
                            entity.setShinsaHohoKubunCode(サービル.get審査方法コード());
                            entity.setState(EntityDataState.Added);
                            償還払請求サービス計画200904Dac.save(entity);
                        } else if (モード_修正.equals(サービル.get状態())) {
                            DbT3047ShokanServicePlan200904Entity entity = new DbT3047ShokanServicePlan200904Entity();
                            entity.setHiHokenshaNo(parameter.get被保険者番号());
                            entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                            entity.setSeiriNp(parameter.get整理番号());
                            entity.setJigyoshaNo(parameter.get事業者番号());
                            entity.setYoshikiNo(parameter.get証明書コード());
                            entity.setMeisaiNo(parameter.get明細番号());
                            entity.setRenban(サービル.get連番());
                            entity.setShiteiKijunGaitoJigyoshaKubunCode(サービル.get事業者区分コード());
                            entity.setKyotakuServiceSakuseiIraiYMD(サービル.get届出日());
                            entity.setServiceCode(サービル.getサービスコード());
                            entity.setTanisu(サービル.get単位数());
                            entity.setKaisu(サービル.get回数());
                            entity.setServiceTanisu(サービル.getサービス単位数());
                            entity.setTanisuTanka(サービル.get単位数単価());
                            entity.setServiceTanisuTotal(サービル.getサービス単位数合計());
                            entity.setTantokangoshienSemmoninNo(サービル.get担当介護支援専門員番号());
                            entity.setTekiyo(サービル.get摘要());
                            entity.setShinsaHohoKubunCode(サービル.get審査方法コード());
                            entity.setState(EntityDataState.Modified);
                            償還払請求サービス計画200904Dac.save(entity);
                        } else if (モード_削除.equals(サービル.get状態())) {
                            DbT3047ShokanServicePlan200904Entity entity = new DbT3047ShokanServicePlan200904Entity();
                            entity.setHiHokenshaNo(parameter.get被保険者番号());
                            entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                            entity.setSeiriNp(parameter.get整理番号());
                            entity.setJigyoshaNo(parameter.get事業者番号());
                            entity.setYoshikiNo(parameter.get証明書コード());
                            entity.setMeisaiNo(明細番号);
                            entity.setRenban(サービル.get連番());
                            entity.setState(EntityDataState.Deleted);
                            償還払請求サービス計画200904Dac.save(entity);
                        }
                    }
                }
            }
        } else if (new FlexibleYearMonth("200604").isBeforeOrEquals(parameter.getサービス提供年月())
                && (parameter.getサービス提供年月().isBeforeOrEquals(new FlexibleYearMonth("200903")))) {
            if (parameter.get明細番号() == null || parameter.get明細番号().isEmpty()) {
                明細番号 = new RString("0001");
                DbT3046ShokanServicePlan200604Entity entity = new DbT3046ShokanServicePlan200604Entity();
                entity.setHiHokenshaNo(parameter.get被保険者番号());
                entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                entity.setSeiriNp(parameter.get整理番号());
                entity.setJigyoshaNo(parameter.get事業者番号());
                entity.setYoshikiNo(parameter.get証明書コード());
                entity.setMeisaiNo(明細番号);
                entity.setRenban(parameter.get連番());
                entity.setShiteiKijunGaitoJigyoshaKubunCode(parameter.get事業者区分コード());
                entity.setKyotakuServiceSakuseiIraiYMD(parameter.get届出日());
                entity.setServiceCode(parameter.getサービスコード());
                entity.setTanisu(parameter.get単位数());
                entity.setTanisuTanka(parameter.get単位数単価());
                entity.setSeikyuKingaku(parameter.get請求金額());
                entity.setTantokangoshienSemmoninNo(parameter.get担当介護支援専門員番号());
                entity.setTekiyo(parameter.get摘要());
                entity.setShinsaHohoKubunCode(parameter.get審査方法コード());
                entity.setState(EntityDataState.Added);
                償還払請求サービス計画200604Dac.save(entity);
            } else {
                明細番号 = parameter.get明細番号();
                DbT3046ShokanServicePlan200604Entity entity = new DbT3046ShokanServicePlan200604Entity();
                entity.setHiHokenshaNo(parameter.get被保険者番号());
                entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                entity.setSeiriNp(parameter.get整理番号());
                entity.setJigyoshaNo(parameter.get事業者番号());
                entity.setYoshikiNo(parameter.get証明書コード());
                entity.setMeisaiNo(明細番号);
                entity.setRenban(parameter.get連番());
                entity.setShiteiKijunGaitoJigyoshaKubunCode(parameter.get事業者区分コード());
                entity.setKyotakuServiceSakuseiIraiYMD(parameter.get届出日());
                entity.setServiceCode(parameter.getサービスコード());
                entity.setTanisu(parameter.get単位数());
                entity.setTanisuTanka(parameter.get単位数単価());
                entity.setSeikyuKingaku(parameter.get請求金額());
                entity.setTantokangoshienSemmoninNo(parameter.get担当介護支援専門員番号());
                entity.setTekiyo(parameter.get摘要());
                entity.setShinsaHohoKubunCode(parameter.get審査方法コード());
                entity.setState(EntityDataState.Modified);
                償還払請求サービス計画200604Dac.save(entity);
            }
        } else if (parameter.getサービス提供年月().isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
            if (parameter.get明細番号() == null || parameter.get明細番号().isEmpty()) {
                明細番号 = new RString("0001");
                DbT3045ShokanServicePlan200004Entity entity = new DbT3045ShokanServicePlan200004Entity();
                entity.setHiHokenshaNo(parameter.get被保険者番号());
                entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                entity.setSeiriNp(parameter.get整理番号());
                entity.setJigyoshaNo(parameter.get事業者番号());
                entity.setYoshikiNo(parameter.get証明書コード());
                entity.setMeisaiNo(明細番号);
                entity.setRenban(parameter.get連番());
                entity.setShiteiKijunGaitoJigyoshaKubunCode(parameter.get事業者区分コード());
                entity.setKyotakuServiceSakuseiIraiYMD(parameter.get届出日());
                entity.setServiceCode(parameter.getサービスコード());
                entity.setTanisu(parameter.get単位数());
                entity.setTanisuTanka(parameter.get単位数単価());
                entity.setSeikyuKingaku(parameter.get請求金額());
                entity.setShinsaHohoKubunCode(parameter.get審査方法コード());
                entity.setState(EntityDataState.Added);
                償還払請求サービス計画200004Dac.save(entity);

            } else {
                明細番号 = parameter.get明細番号();
                DbT3045ShokanServicePlan200004Entity entity = new DbT3045ShokanServicePlan200004Entity();
                entity.setHiHokenshaNo(parameter.get被保険者番号());
                entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                entity.setSeiriNp(parameter.get整理番号());
                entity.setJigyoshaNo(parameter.get事業者番号());
                entity.setYoshikiNo(parameter.get証明書コード());
                entity.setMeisaiNo(明細番号);
                entity.setRenban(parameter.get連番());
                entity.setShiteiKijunGaitoJigyoshaKubunCode(parameter.get事業者区分コード());
                entity.setKyotakuServiceSakuseiIraiYMD(parameter.get届出日());
                entity.setServiceCode(parameter.getサービスコード());
                entity.setTanisu(parameter.get単位数());
                entity.setTanisuTanka(parameter.get単位数単価());
                entity.setSeikyuKingaku(parameter.get請求金額());
                entity.setShinsaHohoKubunCode(parameter.get審査方法コード());
                entity.setState(EntityDataState.Modified);
                償還払請求サービス計画200004Dac.save(entity);
            }
        }
        return 明細番号;
    }

    /**
     * 特定入所者費用登録更新処理
     *
     * @param parameter
     */
    public void updShokanTokuteiNyushoshaKaigoServiceHiyo(
            ShokanTokuteiNyushoshaKaigoServiceHiyoParameter parameter) {

        List<ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> 特定入所者費用List = parameter.get特定入所者費用List();
        if (特定入所者費用List != null && !特定入所者費用List.isEmpty()) {
            for (ShokanTokuteiNyushoshaKaigoServiceHiyoEntity 特定入所者費用 : 特定入所者費用List) {
                if (モード_登録.equals(特定入所者費用.get状態())) {
                    DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity
                            = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(特定入所者費用.get連番());
                    entity.setServiceShuruiCode(特定入所者費用.getサービス種類コード());
                    entity.setServiceKomokuCode(特定入所者費用.getサービス項目コード());
                    entity.setHiyoTanka(特定入所者費用.get標準単価());
                    entity.setFutanGendogaku(特定入所者費用.get負担限度額());
                    entity.setNissu(特定入所者費用.get日数());
                    entity.setHiyogaku(特定入所者費用.get費用額());
                    entity.setHokenbunSeikyugaku(特定入所者費用.get保険分());
                    entity.setRiyoshaFutangaku(特定入所者費用.get利用者負担額());
                    entity.setHiyogakuTotal(parameter.get合計費用額());
                    entity.setHokenbunSeikyugakuTotal(parameter.get合計保険分請求額());
                    entity.setRiyoshaFutangakuTotal(parameter.get合計利用者負担額());
                    entity.setState(EntityDataState.Added);
                    償還払請求特定入所者介護サービス費用Dac.save(entity);
                } else if (モード_修正.equals(特定入所者費用.get状態())) {
                    DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity
                            = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(特定入所者費用.get連番());
                    entity.setServiceShuruiCode(特定入所者費用.getサービス種類コード());
                    entity.setServiceKomokuCode(特定入所者費用.getサービス項目コード());
                    entity.setHiyoTanka(特定入所者費用.get標準単価());
                    entity.setFutanGendogaku(特定入所者費用.get負担限度額());
                    entity.setNissu(特定入所者費用.get日数());
                    entity.setHiyogaku(特定入所者費用.get費用額());
                    entity.setHokenbunSeikyugaku(特定入所者費用.get保険分());
                    entity.setRiyoshaFutangaku(特定入所者費用.get利用者負担額());
                    entity.setHiyogakuTotal(parameter.get合計費用額());
                    entity.setHokenbunSeikyugakuTotal(parameter.get合計保険分請求額());
                    entity.setRiyoshaFutangakuTotal(parameter.get合計利用者負担額());
                    entity.setState(EntityDataState.Modified);
                    償還払請求特定入所者介護サービス費用Dac.save(entity);
                } else if (モード_削除.equals(特定入所者費用.get状態())) {
                    DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity
                            = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(特定入所者費用.get連番());
                    entity.setState(EntityDataState.Deleted);
                    償還払請求特定入所者介護サービス費用Dac.save(entity);
                }
            }
            DbT3038ShokanKihonEntity dbT3038entity = new DbT3038ShokanKihonEntity();
            dbT3038entity.setHiHokenshaNo(parameter.get被保険者番号());
            dbT3038entity.setServiceTeikyoYM(parameter.get提供購入年月());
            dbT3038entity.setSeiriNp(parameter.get整理番号());
            dbT3038entity.setJigyoshaNo(parameter.get事業者番号());
            dbT3038entity.setYoshikiNo(parameter.get証明書コード());
            dbT3038entity.setMeisaiNo(parameter.get明細番号());
            dbT3038entity.setTokuteiNyushoshaKaigoServiceSeikyugaku(parameter.get合計費用額());
            dbT3038entity.setState(EntityDataState.Modified);
            償還払請求基本Dac.save(dbT3038entity);
        }
    }

    /**
     * 社福軽減額登録更新処理
     *
     * @param parameter
     */
    public void updShokanShakaiFukushiHojinKeigengaku(ShokanShakaiFukushiHojinKeigengakuParameter parameter) {

        List<ShokanFukushigengakuEntity> 社福軽減額List = parameter.get社福軽減額List();
        if (社福軽減額List != null && !社福軽減額List.isEmpty()) {
            for (ShokanFukushigengakuEntity 社福軽減額 : 社福軽減額List) {
                if (モード_登録.equals(社福軽減額.get状態())) {
                    DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity
                            = new DbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(社福軽減額.get連番());
                    entity.setKeigenritsu(社福軽減額.get軽減率());
                    entity.setServiceShuruiCode(社福軽減額.getサービス種類コード());
                    entity.setRiyoshaFutangakuTotal(社福軽減額.get受領すべき利用者負担の総額());
                    entity.setKeigengaku(社福軽減額.get軽減額());
                    entity.setKeigengoRiyoshaFutangaku(社福軽減額.get軽減後利用者負担額());
                    entity.setBiko(社福軽減額.get備考());
                    entity.setState(EntityDataState.Added);
                    償還払請求社会福祉法人軽減額Dac.save(entity);
                } else if (モード_修正.equals(社福軽減額.get状態())) {
                    DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity
                            = new DbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(社福軽減額.get連番());
                    entity.setKeigenritsu(社福軽減額.get軽減率());
                    entity.setServiceShuruiCode(社福軽減額.getサービス種類コード());
                    entity.setRiyoshaFutangakuTotal(社福軽減額.get受領すべき利用者負担の総額());
                    entity.setKeigengaku(社福軽減額.get軽減額());
                    entity.setKeigengoRiyoshaFutangaku(社福軽減額.get軽減後利用者負担額());
                    entity.setBiko(社福軽減額.get備考());
                    entity.setState(EntityDataState.Modified);
                    償還払請求社会福祉法人軽減額Dac.save(entity);
                } else if (モード_削除.equals(社福軽減額.get状態())) {
                    DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity
                            = new DbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(社福軽減額.get連番());
                    entity.setState(EntityDataState.Deleted);
                    償還払請求社会福祉法人軽減額Dac.save(entity);
                }
            }
        }
    }

    /**
     * 緊急時・所定疾患登録更新処理
     *
     * @param parameter
     */
    public void updShokanShoteiShikkanShisetsuRyoyo(ShokanShoteiShikkanShisetsuRyoyoParameter parameter) {
        int 金額合計 = 0;
        List<ShokanShoteiShikkanShisetsuRyoyoEntity> 緊急時所定疾患List = parameter.get緊急時所定疾患List();
        if (緊急時所定疾患List != null && !緊急時所定疾患List.isEmpty()) {
            for (ShokanShoteiShikkanShisetsuRyoyoEntity 緊急時所定疾患 : 緊急時所定疾患List) {
                if (モード_登録.equals(緊急時所定疾患.get状態())) {
                    金額合計 = 金額合計 + 緊急時所定疾患.get緊急時施設療養費合計単位数()
                            + 緊急時所定疾患.get所定疾患施設療養費小計();
                    DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity
                            = new DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(緊急時所定疾患.get連番());
                    entity.setKinkyuShobyoName1(緊急時所定疾患.get緊急時傷病名1());
                    entity.setKinkyuShobyoName2(緊急時所定疾患.get緊急時傷病名2());
                    entity.setKinkyuShobyoName3(緊急時所定疾患.get緊急時傷病名3());
                    entity.setKinkyuChiryoKaishiYMD1(緊急時所定疾患.get緊急時治療開始年月日1());
                    entity.setKinkyuChiryoKaishiYMD2(緊急時所定疾患.get緊急時治療開始年月日2());
                    entity.setKinkyuChiryoKaishiYMD3(緊急時所定疾患.get緊急時治療開始年月日3());
                    entity.setOshinNissu(緊急時所定疾患.get往診日数());
                    entity.setOshinIryoKikanName(緊急時所定疾患.get往診医療機関名());
                    entity.setTsuinNissu(緊急時所定疾患.get通院日数());
                    entity.setTsuinKikanName(緊急時所定疾患.get通院医療機関名());
                    entity.setKinkyuChiryoKanriTanisu(緊急時所定疾患.get緊急時治療管理単位数());
                    entity.setKinkyuChiryoKanriNissu(緊急時所定疾患.get緊急時治療管理日数());
                    entity.setKinkyuChiryoKanriSubTotal(緊急時所定疾患.get緊急時治療管理小計());
                    entity.setRehabilitationTanisu(緊急時所定疾患.getリハビリテーション単位数());
                    entity.setShochiTanisu(緊急時所定疾患.get処置単位数());
                    entity.setShujutsuTanisu(緊急時所定疾患.get手術単位数());
                    entity.setMasuiTanisu(緊急時所定疾患.get麻酔単位数());
                    entity.setHoshasenChiryoTanisu(緊急時所定疾患.get放射線治療単位数());
                    entity.setTekiyo1(緊急時所定疾患.get摘要1());
                    entity.setTekiyo2(緊急時所定疾患.get摘要2());
                    entity.setTekiyo3(緊急時所定疾患.get摘要3());
                    entity.setTekiyo4(緊急時所定疾患.get摘要4());
                    entity.setTekiyo5(緊急時所定疾患.get摘要5());
                    entity.setTekiyo6(緊急時所定疾患.get摘要6());
                    entity.setTekiyo7(緊急時所定疾患.get摘要7());
                    entity.setTekiyo8(緊急時所定疾患.get摘要8());
                    entity.setTekiyo9(緊急時所定疾患.get摘要9());
                    entity.setTekiyo10(緊急時所定疾患.get摘要10());
                    entity.setTekiyo11(緊急時所定疾患.get摘要11());
                    entity.setTekiyo12(緊急時所定疾患.get摘要12());
                    entity.setTekiyo13(緊急時所定疾患.get摘要13());
                    entity.setTekiyo14(緊急時所定疾患.get摘要14());
                    entity.setTekiyo15(緊急時所定疾患.get摘要15());
                    entity.setTekiyo16(緊急時所定疾患.get摘要16());
                    entity.setTekiyo17(緊急時所定疾患.get摘要17());
                    entity.setTekiyo18(緊急時所定疾患.get摘要18());
                    entity.setTekiyo19(緊急時所定疾患.get摘要19());
                    entity.setTekiyo20(緊急時所定疾患.get摘要20());
                    entity.setKinkyuShisetsuRyoyohiTotalTanisu(緊急時所定疾患.get緊急時施設療養費合計単位数());
                    entity.setShoteiShikkanShobyoName1(緊急時所定疾患.get所定疾患施設療養費傷病名1());
                    entity.setShoteiShikkanShobyoName2(緊急時所定疾患.get所定疾患施設療養費傷病名2());
                    entity.setShoteiShikkanShobyoName3(緊急時所定疾患.get所定疾患施設療養費傷病名3());
                    entity.setShoteiShikkanShobyoKaishiYMD1(緊急時所定疾患.get所定疾患施設療養費開始年月日1());
                    entity.setShoteiShikkanShobyoKaishiYMD2(緊急時所定疾患.get所定疾患施設療養費開始年月日2());
                    entity.setShoteiShikkanShobyoKaishiYMD3(緊急時所定疾患.get所定疾患施設療養費開始年月日3());
                    entity.setShoteiShikkanNissu(緊急時所定疾患.get所定疾患施設療養費日数());
                    entity.setShoteiShikkanSubTotal(緊急時所定疾患.get所定疾患施設療養費小計());
                    entity.setState(EntityDataState.Added);
                    償還払請求所定疾患施設療養費等Dac.save(entity);
                } else if (モード_修正.equals(緊急時所定疾患.get状態())) {
                    金額合計 = 金額合計 + 緊急時所定疾患.get緊急時施設療養費合計単位数()
                            + 緊急時所定疾患.get所定疾患施設療養費小計();
                    DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity
                            = new DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(緊急時所定疾患.get連番());
                    entity.setKinkyuShobyoName1(緊急時所定疾患.get緊急時傷病名1());
                    entity.setKinkyuShobyoName2(緊急時所定疾患.get緊急時傷病名2());
                    entity.setKinkyuShobyoName3(緊急時所定疾患.get緊急時傷病名3());
                    entity.setKinkyuChiryoKaishiYMD1(緊急時所定疾患.get緊急時治療開始年月日1());
                    entity.setKinkyuChiryoKaishiYMD2(緊急時所定疾患.get緊急時治療開始年月日2());
                    entity.setKinkyuChiryoKaishiYMD3(緊急時所定疾患.get緊急時治療開始年月日3());
                    entity.setOshinNissu(緊急時所定疾患.get往診日数());
                    entity.setOshinIryoKikanName(緊急時所定疾患.get往診医療機関名());
                    entity.setTsuinNissu(緊急時所定疾患.get通院日数());
                    entity.setTsuinKikanName(緊急時所定疾患.get通院医療機関名());
                    entity.setKinkyuChiryoKanriTanisu(緊急時所定疾患.get緊急時治療管理単位数());
                    entity.setKinkyuChiryoKanriNissu(緊急時所定疾患.get緊急時治療管理日数());
                    entity.setKinkyuChiryoKanriSubTotal(緊急時所定疾患.get緊急時治療管理小計());
                    entity.setRehabilitationTanisu(緊急時所定疾患.getリハビリテーション単位数());
                    entity.setShochiTanisu(緊急時所定疾患.get処置単位数());
                    entity.setShujutsuTanisu(緊急時所定疾患.get手術単位数());
                    entity.setMasuiTanisu(緊急時所定疾患.get麻酔単位数());
                    entity.setHoshasenChiryoTanisu(緊急時所定疾患.get放射線治療単位数());
                    entity.setTekiyo1(緊急時所定疾患.get摘要1());
                    entity.setTekiyo2(緊急時所定疾患.get摘要2());
                    entity.setTekiyo3(緊急時所定疾患.get摘要3());
                    entity.setTekiyo4(緊急時所定疾患.get摘要4());
                    entity.setTekiyo5(緊急時所定疾患.get摘要5());
                    entity.setTekiyo6(緊急時所定疾患.get摘要6());
                    entity.setTekiyo7(緊急時所定疾患.get摘要7());
                    entity.setTekiyo8(緊急時所定疾患.get摘要8());
                    entity.setTekiyo9(緊急時所定疾患.get摘要9());
                    entity.setTekiyo10(緊急時所定疾患.get摘要10());
                    entity.setTekiyo11(緊急時所定疾患.get摘要11());
                    entity.setTekiyo12(緊急時所定疾患.get摘要12());
                    entity.setTekiyo13(緊急時所定疾患.get摘要13());
                    entity.setTekiyo14(緊急時所定疾患.get摘要14());
                    entity.setTekiyo15(緊急時所定疾患.get摘要15());
                    entity.setTekiyo16(緊急時所定疾患.get摘要16());
                    entity.setTekiyo17(緊急時所定疾患.get摘要17());
                    entity.setTekiyo18(緊急時所定疾患.get摘要18());
                    entity.setTekiyo19(緊急時所定疾患.get摘要19());
                    entity.setTekiyo20(緊急時所定疾患.get摘要20());
                    entity.setKinkyuShisetsuRyoyohiTotalTanisu(緊急時所定疾患.get緊急時施設療養費合計単位数());
                    entity.setShoteiShikkanShobyoName1(緊急時所定疾患.get所定疾患施設療養費傷病名1());
                    entity.setShoteiShikkanShobyoName2(緊急時所定疾患.get所定疾患施設療養費傷病名2());
                    entity.setShoteiShikkanShobyoName3(緊急時所定疾患.get所定疾患施設療養費傷病名3());
                    entity.setShoteiShikkanShobyoKaishiYMD1(緊急時所定疾患.get所定疾患施設療養費開始年月日1());
                    entity.setShoteiShikkanShobyoKaishiYMD2(緊急時所定疾患.get所定疾患施設療養費開始年月日2());
                    entity.setShoteiShikkanShobyoKaishiYMD3(緊急時所定疾患.get所定疾患施設療養費開始年月日3());
                    entity.setShoteiShikkanNissu(緊急時所定疾患.get所定疾患施設療養費日数());
                    entity.setShoteiShikkanSubTotal(緊急時所定疾患.get所定疾患施設療養費小計());
                    entity.setState(EntityDataState.Modified);
                    償還払請求所定疾患施設療養費等Dac.save(entity);
                } else if (モード_削除.equals(緊急時所定疾患.get状態())) {
                    DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity
                            = new DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(緊急時所定疾患.get連番());
                    entity.setState(EntityDataState.Deleted);
                    償還払請求所定疾患施設療養費等Dac.save(entity);
                }
            }
            DbT3038ShokanKihonEntity dbT3038entity = new DbT3038ShokanKihonEntity();
            dbT3038entity.setHiHokenshaNo(parameter.get被保険者番号());
            dbT3038entity.setServiceTeikyoYM(parameter.get提供購入年月());
            dbT3038entity.setSeiriNp(parameter.get整理番号());
            dbT3038entity.setJigyoshaNo(parameter.get事業者番号());
            dbT3038entity.setYoshikiNo(parameter.get証明書コード());
            dbT3038entity.setMeisaiNo(parameter.get明細番号());
            dbT3038entity.setKinkyuShisetsuRyoyoSeikyugaku(new Decimal(金額合計));
            dbT3038entity.setState(EntityDataState.Modified);
            償還払請求基本Dac.save(dbT3038entity);
        }
    }

    /**
     * 緊急時施設療養費登録更新処理
     *
     * @param parameter
     */
    public void updShokanKinkyuShisetsuRyoyo(ShokanKinkyuShisetsuRyoyoParameter parameter) {

        int 金額合計 = 0;
        List<ShokanKinkyuShisetsuRyoyoEntity> 緊急時施設療養費List = parameter.get緊急時施設療養費List();
        if (緊急時施設療養費List != null && !緊急時施設療養費List.isEmpty()) {
            for (ShokanKinkyuShisetsuRyoyoEntity 緊急時施設療養費 : 緊急時施設療養費List) {
                if (モード_登録.equals(緊急時施設療養費.get状態())) {
                    金額合計 = 金額合計 + 緊急時施設療養費.get緊急時施設療養費合計単位数();
                    DbT3040ShokanKinkyuShisetsuRyoyoEntity entity = new DbT3040ShokanKinkyuShisetsuRyoyoEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(緊急時施設療養費.get連番());
                    entity.setKinkyuShobyoName1(緊急時施設療養費.get緊急時傷病名1());
                    entity.setKinkyuShobyoName2(緊急時施設療養費.get緊急時傷病名2());
                    entity.setKinkyuShobyoName3(緊急時施設療養費.get緊急時傷病名3());
                    entity.setKinkyuChiryoKaishiYMD1(緊急時施設療養費.get緊急時治療開始年月日1());
                    entity.setKinkyuChiryoKaishiYMD2(緊急時施設療養費.get緊急時治療開始年月日2());
                    entity.setKinkyuChiryoKaishiYMD3(緊急時施設療養費.get緊急時治療開始年月日3());
                    entity.setOshinNissu(緊急時施設療養費.get往診日数());
                    entity.setOshinIryoKikanName(緊急時施設療養費.get往診医療機関名());
                    entity.setTsuinNissu(緊急時施設療養費.get通院日数());
                    entity.setTsuinKikanName(緊急時施設療養費.get通院医療機関名());
                    entity.setKinkyuChiryoKanriTanisu(緊急時施設療養費.get緊急時治療管理単位数());
                    entity.setKinkyuChiryoKanriNissu(緊急時施設療養費.get緊急時治療管理日数());
                    entity.setKinkyuChiryoKanriSubTotal(緊急時施設療養費.get緊急時治療管理小計());
                    entity.setRehabilitationTanisu(緊急時施設療養費.getリハビリテーション単位数());
                    entity.setShochiTanisu(緊急時施設療養費.get処置単位数());
                    entity.setShujutsuTanisu(緊急時施設療養費.get手術単位数());
                    entity.setMasuiTanisu(緊急時施設療養費.get麻酔単位数());
                    entity.setHoshasenChiryoTanisu(緊急時施設療養費.get放射線治療単位数());
                    entity.setTekiyo1(緊急時施設療養費.get摘要1());
                    entity.setTekiyo2(緊急時施設療養費.get摘要2());
                    entity.setTekiyo3(緊急時施設療養費.get摘要3());
                    entity.setTekiyo4(緊急時施設療養費.get摘要4());
                    entity.setTekiyo5(緊急時施設療養費.get摘要5());
                    entity.setTekiyo6(緊急時施設療養費.get摘要6());
                    entity.setTekiyo7(緊急時施設療養費.get摘要7());
                    entity.setTekiyo8(緊急時施設療養費.get摘要8());
                    entity.setTekiyo9(緊急時施設療養費.get摘要9());
                    entity.setTekiyo10(緊急時施設療養費.get摘要10());
                    entity.setTekiyo11(緊急時施設療養費.get摘要11());
                    entity.setTekiyo12(緊急時施設療養費.get摘要12());
                    entity.setTekiyo13(緊急時施設療養費.get摘要13());
                    entity.setTekiyo14(緊急時施設療養費.get摘要14());
                    entity.setTekiyo15(緊急時施設療養費.get摘要15());
                    entity.setTekiyo16(緊急時施設療養費.get摘要16());
                    entity.setTekiyo17(緊急時施設療養費.get摘要17());
                    entity.setTekiyo18(緊急時施設療養費.get摘要18());
                    entity.setTekiyo19(緊急時施設療養費.get摘要19());
                    entity.setTekiyo20(緊急時施設療養費.get摘要20());
                    entity.setKinkyuShisetsuRyoyohiTotalTanisu(緊急時施設療養費.get緊急時施設療養費合計単位数());
                    entity.setState(EntityDataState.Added);
                    償還払請求緊急時施設療養Dac.save(entity);
                } else if (モード_修正.equals(緊急時施設療養費.get状態())) {
                    金額合計 = 金額合計 + 緊急時施設療養費.get緊急時施設療養費合計単位数();
                    DbT3040ShokanKinkyuShisetsuRyoyoEntity entity = new DbT3040ShokanKinkyuShisetsuRyoyoEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(緊急時施設療養費.get連番());
                    entity.setKinkyuShobyoName1(緊急時施設療養費.get緊急時傷病名1());
                    entity.setKinkyuShobyoName2(緊急時施設療養費.get緊急時傷病名2());
                    entity.setKinkyuShobyoName3(緊急時施設療養費.get緊急時傷病名3());
                    entity.setKinkyuChiryoKaishiYMD1(緊急時施設療養費.get緊急時治療開始年月日1());
                    entity.setKinkyuChiryoKaishiYMD2(緊急時施設療養費.get緊急時治療開始年月日2());
                    entity.setKinkyuChiryoKaishiYMD3(緊急時施設療養費.get緊急時治療開始年月日3());
                    entity.setOshinNissu(緊急時施設療養費.get往診日数());
                    entity.setOshinIryoKikanName(緊急時施設療養費.get往診医療機関名());
                    entity.setTsuinNissu(緊急時施設療養費.get通院日数());
                    entity.setTsuinKikanName(緊急時施設療養費.get通院医療機関名());
                    entity.setKinkyuChiryoKanriTanisu(緊急時施設療養費.get緊急時治療管理単位数());
                    entity.setKinkyuChiryoKanriNissu(緊急時施設療養費.get緊急時治療管理日数());
                    entity.setKinkyuChiryoKanriSubTotal(緊急時施設療養費.get緊急時治療管理小計());
                    entity.setRehabilitationTanisu(緊急時施設療養費.getリハビリテーション単位数());
                    entity.setShochiTanisu(緊急時施設療養費.get処置単位数());
                    entity.setShujutsuTanisu(緊急時施設療養費.get手術単位数());
                    entity.setMasuiTanisu(緊急時施設療養費.get麻酔単位数());
                    entity.setHoshasenChiryoTanisu(緊急時施設療養費.get放射線治療単位数());
                    entity.setTekiyo1(緊急時施設療養費.get摘要1());
                    entity.setTekiyo2(緊急時施設療養費.get摘要2());
                    entity.setTekiyo3(緊急時施設療養費.get摘要3());
                    entity.setTekiyo4(緊急時施設療養費.get摘要4());
                    entity.setTekiyo5(緊急時施設療養費.get摘要5());
                    entity.setTekiyo6(緊急時施設療養費.get摘要6());
                    entity.setTekiyo7(緊急時施設療養費.get摘要7());
                    entity.setTekiyo8(緊急時施設療養費.get摘要8());
                    entity.setTekiyo9(緊急時施設療養費.get摘要9());
                    entity.setTekiyo10(緊急時施設療養費.get摘要10());
                    entity.setTekiyo11(緊急時施設療養費.get摘要11());
                    entity.setTekiyo12(緊急時施設療養費.get摘要12());
                    entity.setTekiyo13(緊急時施設療養費.get摘要13());
                    entity.setTekiyo14(緊急時施設療養費.get摘要14());
                    entity.setTekiyo15(緊急時施設療養費.get摘要15());
                    entity.setTekiyo16(緊急時施設療養費.get摘要16());
                    entity.setTekiyo17(緊急時施設療養費.get摘要17());
                    entity.setTekiyo18(緊急時施設療養費.get摘要18());
                    entity.setTekiyo19(緊急時施設療養費.get摘要19());
                    entity.setTekiyo20(緊急時施設療養費.get摘要20());
                    entity.setKinkyuShisetsuRyoyohiTotalTanisu(緊急時施設療養費.get緊急時施設療養費合計単位数());
                    entity.setState(EntityDataState.Modified);
                    償還払請求緊急時施設療養Dac.save(entity);
                } else if (モード_削除.equals(緊急時施設療養費.get状態())) {
                    DbT3040ShokanKinkyuShisetsuRyoyoEntity entity = new DbT3040ShokanKinkyuShisetsuRyoyoEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(緊急時施設療養費.get連番());
                    entity.setState(EntityDataState.Deleted);
                    償還払請求緊急時施設療養Dac.save(entity);
                }
            }
            DbT3038ShokanKihonEntity dbT3038entity = new DbT3038ShokanKihonEntity();
            dbT3038entity.setHiHokenshaNo(parameter.get被保険者番号());
            dbT3038entity.setServiceTeikyoYM(parameter.get提供購入年月());
            dbT3038entity.setSeiriNp(parameter.get整理番号());
            dbT3038entity.setJigyoshaNo(parameter.get事業者番号());
            dbT3038entity.setYoshikiNo(parameter.get証明書コード());
            dbT3038entity.setMeisaiNo(parameter.get明細番号());
            dbT3038entity.setKinkyuShisetsuRyoyoSeikyugaku(new Decimal(金額合計));
            dbT3038entity.setState(EntityDataState.Modified);
            償還払請求基本Dac.save(dbT3038entity);
        }
    }

    /**
     * 請求額集計登録更新処理
     *
     * @param parameter
     */
    public void updShokanShukei(ShokanShukeiParameter parameter) {

        int 請求額合計 = 0;
        int 利用者負担額合計 = 0;
        List<ShokanShukeiEntity> 請求集計List = parameter.get請求集計List();
        if (請求集計List != null && !請求集計List.isEmpty()) {
            for (ShokanShukeiEntity 請求集計 : 請求集計List) {
                if (モード_登録.equals(請求集計.get状態())) {
                    請求額合計 = 請求額合計 + Integer.parseInt(請求集計.get請求額().toString());
                    利用者負担額合計 = 利用者負担額合計 + 請求集計.get利用者負担();
                    DbT3053ShokanShukeiEntity entity = new DbT3053ShokanShukeiEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(請求集計.get連番());
                    entity.setServiceShuruiCode(請求集計.getサービス種類());
                    entity.setServiceJitsunissu(請求集計.getサービス実日数());
                    entity.setPlanTanisu(請求集計.get計画単位数());
                    entity.setGendogakuKanriTaishoTanisu(請求集計.get限度額管理対象単位数());
                    entity.setGendogakuKanriTaishogaiTanisu(請求集計.get限度額管理対象外単位数());
                    entity.setTankiNyushoPlanNissu(請求集計.get短期入所計画日数());
                    entity.setTankiNyushoJitsunissu(請求集計.get短期入所実日数());
                    entity.setTanisuTotal(請求集計.get単位数合計());
                    entity.setTanisuTanka(請求集計.get単位数単価());
                    entity.setSeikyugaku(請求集計.get請求額());
                    entity.setRiyoshaFutangaku(請求集計.get利用者負担());
                    entity.setDekidakaIryohiTanisuTotal(請求集計.get出来高医療費単位数合計());
                    entity.setDekidakaIryohiSeikyugaku(請求集計.get出来高医療費請求額());
                    entity.setDekidakaIryohiRiyoshaFutangaku(請求集計.get出来高医療費利用者負担額());
                    entity.setShinsaHohoKubunCode(請求集計.get審査方法区分コード());
                    entity.setState(EntityDataState.Added);
                    償還払請求集計Dac.save(entity);
                } else if (モード_修正.equals(請求集計.get状態())) {
                    請求額合計 = 請求額合計 + Integer.parseInt(請求集計.get請求額().toString());
                    利用者負担額合計 = 利用者負担額合計 + 請求集計.get利用者負担();
                    DbT3053ShokanShukeiEntity entity = new DbT3053ShokanShukeiEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(請求集計.get連番());
                    entity.setServiceShuruiCode(請求集計.getサービス種類());
                    entity.setServiceJitsunissu(請求集計.getサービス実日数());
                    entity.setPlanTanisu(請求集計.get計画単位数());
                    entity.setGendogakuKanriTaishoTanisu(請求集計.get限度額管理対象単位数());
                    entity.setGendogakuKanriTaishogaiTanisu(請求集計.get限度額管理対象外単位数());
                    entity.setTankiNyushoPlanNissu(請求集計.get短期入所計画日数());
                    entity.setTankiNyushoJitsunissu(請求集計.get短期入所実日数());
                    entity.setTanisuTotal(請求集計.get単位数合計());
                    entity.setTanisuTanka(請求集計.get単位数単価());
                    entity.setSeikyugaku(請求集計.get請求額());
                    entity.setRiyoshaFutangaku(請求集計.get利用者負担());
                    entity.setDekidakaIryohiTanisuTotal(請求集計.get出来高医療費単位数合計());
                    entity.setDekidakaIryohiSeikyugaku(請求集計.get出来高医療費請求額());
                    entity.setDekidakaIryohiRiyoshaFutangaku(請求集計.get出来高医療費利用者負担額());
                    entity.setShinsaHohoKubunCode(請求集計.get審査方法区分コード());
                    entity.setState(EntityDataState.Modified);
                    償還払請求集計Dac.save(entity);
                } else if (モード_削除.equals(請求集計.get状態())) {
                    DbT3053ShokanShukeiEntity entity = new DbT3053ShokanShukeiEntity();
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.get提供購入年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setJigyoshaNo(parameter.get事業者番号());
                    entity.setYoshikiNo(parameter.get証明書コード());
                    entity.setMeisaiNo(parameter.get明細番号());
                    entity.setRenban(請求集計.get連番());
                    entity.setState(EntityDataState.Deleted);
                    償還払請求集計Dac.save(entity);
                }
            }
            DbT3038ShokanKihonEntity dbT3038entity = new DbT3038ShokanKihonEntity();
            dbT3038entity.setHiHokenshaNo(parameter.get被保険者番号());
            dbT3038entity.setServiceTeikyoYM(parameter.get提供購入年月());
            dbT3038entity.setSeiriNp(parameter.get整理番号());
            dbT3038entity.setJigyoshaNo(parameter.get事業者番号());
            dbT3038entity.setYoshikiNo(parameter.get証明書コード());
            dbT3038entity.setMeisaiNo(parameter.get明細番号());
            dbT3038entity.setHokenSeikyugaku(new Decimal(請求額合計));
            dbT3038entity.setRiyoshaFutangaku(利用者負担額合計);
            dbT3038entity.setState(EntityDataState.Modified);
            償還払請求基本Dac.save(dbT3038entity);
        }
    }

    /**
     * 食事費用登録更新処理
     *
     * @param parameter
     */
    public void updShokanShokujiHiyo(ShokanShokujiHiyoParameter parameter) {

        List<DbT3043ShokanShokujiHiyoEntity> entityList
                = 償還払請求食事費用Dac.selectByKey(parameter.get被保険者番号(), parameter.get提供購入年月(),
                        parameter.get整理番号(), parameter.get事業者番号(),
                        parameter.get証明書コード(), parameter.get明細番号());
        if (parameter.get提供購入年月().isBefore(new FlexibleYearMonth("200304"))) {
            if (entityList == null || entityList.isEmpty()) {
                DbT3043ShokanShokujiHiyoEntity dbT3043entity = new DbT3043ShokanShokujiHiyoEntity();
                dbT3043entity.setHiHokenshaNo(parameter.get被保険者番号());
                dbT3043entity.setServiceTeikyoYM(parameter.get提供購入年月());
                dbT3043entity.setSeiriNp(parameter.get整理番号());
                dbT3043entity.setJigyoshaNo(parameter.get事業者番号());
                dbT3043entity.setYoshikiNo(parameter.get証明書コード());
                dbT3043entity.setMeisaiNo(parameter.get明細番号());
                dbT3043entity.setRenban(parameter.get連番());
                dbT3043entity.setKihonTeikyoNissu(parameter.get基本提供日数());
                dbT3043entity.setKihonTeikyoTanka(parameter.get基本提供単価());
                dbT3043entity.setKihonTeikyoKingaku(parameter.get基本提供金額());
                dbT3043entity.setTokubetsuTeikyoNissu(parameter.get特別提供日数());
                dbT3043entity.setTokubetsuTeikyoTanka(parameter.get特別提供単価());
                dbT3043entity.setTokubetsuTeikyoKingaku(parameter.get特別提供金額());
                dbT3043entity.setShokujiTeikyoTotalNissu(parameter.get食事提供延べ日数());
                dbT3043entity.setShokujiTeikyohiTotal(parameter.get食事提供費合計());
                dbT3043entity.setGetsugakuHyojunFutangaku(parameter.get標準負担月額());
                dbT3043entity.setShokujiTeikyohiSeikyugaku(parameter.get食事提供費請求額());
                dbT3043entity.setNichigakuHyojunFutangaku(parameter.get標準負担日額());
                dbT3043entity.setState(EntityDataState.Added);
                償還払請求食事費用Dac.save(dbT3043entity);
            } else {
                DbT3043ShokanShokujiHiyoEntity dbT3043entity = new DbT3043ShokanShokujiHiyoEntity();
                dbT3043entity.setHiHokenshaNo(parameter.get被保険者番号());
                dbT3043entity.setServiceTeikyoYM(parameter.get提供購入年月());
                dbT3043entity.setSeiriNp(parameter.get整理番号());
                dbT3043entity.setJigyoshaNo(parameter.get事業者番号());
                dbT3043entity.setYoshikiNo(parameter.get証明書コード());
                dbT3043entity.setMeisaiNo(parameter.get明細番号());
                dbT3043entity.setRenban(parameter.get連番());
                dbT3043entity.setKihonTeikyoNissu(parameter.get基本提供日数());
                dbT3043entity.setKihonTeikyoTanka(parameter.get基本提供単価());
                dbT3043entity.setKihonTeikyoKingaku(parameter.get基本提供金額());
                dbT3043entity.setTokubetsuTeikyoNissu(parameter.get特別提供日数());
                dbT3043entity.setTokubetsuTeikyoTanka(parameter.get特別提供単価());
                dbT3043entity.setTokubetsuTeikyoKingaku(parameter.get特別提供金額());
                dbT3043entity.setShokujiTeikyoTotalNissu(parameter.get食事提供延べ日数());
                dbT3043entity.setShokujiTeikyohiTotal(parameter.get食事提供費合計());
                dbT3043entity.setGetsugakuHyojunFutangaku(parameter.get標準負担月額());
                dbT3043entity.setShokujiTeikyohiSeikyugaku(parameter.get食事提供費請求額());
                dbT3043entity.setNichigakuHyojunFutangaku(parameter.get標準負担日額());
                dbT3043entity.setState(EntityDataState.Modified);
                償還払請求食事費用Dac.save(dbT3043entity);
            }
        } else {
            if (parameter.get提供購入年月().isBeforeOrEquals(new FlexibleYearMonth("200509"))) {
                List<ShokanShokujiHiyoEntity> 食事費用List = parameter.get食事費用List();
                if (食事費用List != null && !食事費用List.isEmpty()) {
                    for (ShokanShokujiHiyoEntity 食事費用 : 食事費用List) {
                        if (モード_登録.equals(食事費用.get状態())) {
                            DbT3039ShokanMeisaiEntity dbT3039entity = new DbT3039ShokanMeisaiEntity();
                            dbT3039entity.setHiHokenshaNo(parameter.get被保険者番号());
                            dbT3039entity.setServiceTeikyoYM(parameter.get提供購入年月());
                            dbT3039entity.setSeiriNp(parameter.get整理番号());
                            dbT3039entity.setJigyoshaNo(parameter.get事業者番号());
                            dbT3039entity.setYoshikiNo(parameter.get証明書コード());
                            dbT3039entity.setMeisaiNo(parameter.get明細番号());
                            dbT3039entity.setRenban(食事費用.get連番());
                            dbT3039entity.setServiceShuruiCode(食事費用.getサービス種類コード());
                            dbT3039entity.setServiceKomokuCode(食事費用.getサービス項目コード());
                            dbT3039entity.setTanisu(食事費用.get単位());
                            dbT3039entity.setNissuKaisu(食事費用.get回数日数());
                            dbT3039entity.setServiceTanisu(食事費用.get金額());
                            dbT3039entity.setState(EntityDataState.Added);
                            償還払請求明細Dac.save(dbT3039entity);
                        } else if (モード_修正.equals(食事費用.get状態())) {
                            DbT3039ShokanMeisaiEntity dbT3039entity = new DbT3039ShokanMeisaiEntity();
                            dbT3039entity.setHiHokenshaNo(parameter.get被保険者番号());
                            dbT3039entity.setServiceTeikyoYM(parameter.get提供購入年月());
                            dbT3039entity.setSeiriNp(parameter.get整理番号());
                            dbT3039entity.setJigyoshaNo(parameter.get事業者番号());
                            dbT3039entity.setYoshikiNo(parameter.get証明書コード());
                            dbT3039entity.setMeisaiNo(parameter.get明細番号());
                            dbT3039entity.setRenban(食事費用.get連番());
                            dbT3039entity.setServiceShuruiCode(食事費用.getサービス種類コード());
                            dbT3039entity.setServiceKomokuCode(食事費用.getサービス項目コード());
                            dbT3039entity.setTanisu(食事費用.get単位());
                            dbT3039entity.setNissuKaisu(食事費用.get回数日数());
                            dbT3039entity.setServiceTanisu(食事費用.get金額());
                            dbT3039entity.setState(EntityDataState.Modified);
                            償還払請求明細Dac.save(dbT3039entity);
                        } else if (モード_削除.equals(食事費用.get状態())) {
                            DbT3039ShokanMeisaiEntity dbT3039entity = new DbT3039ShokanMeisaiEntity();
                            dbT3039entity.setHiHokenshaNo(parameter.get被保険者番号());
                            dbT3039entity.setServiceTeikyoYM(parameter.get提供購入年月());
                            dbT3039entity.setSeiriNp(parameter.get整理番号());
                            dbT3039entity.setJigyoshaNo(parameter.get事業者番号());
                            dbT3039entity.setYoshikiNo(parameter.get証明書コード());
                            dbT3039entity.setMeisaiNo(parameter.get明細番号());
                            dbT3039entity.setRenban(食事費用.get連番());
                            dbT3039entity.setState(EntityDataState.Deleted);
                            償還払請求明細Dac.save(dbT3039entity);
                        }
                    }
                }
            }
            if (entityList == null || entityList.isEmpty()) {
                DbT3043ShokanShokujiHiyoEntity dbT3043entity = new DbT3043ShokanShokujiHiyoEntity();
                dbT3043entity.setHiHokenshaNo(parameter.get被保険者番号());
                dbT3043entity.setServiceTeikyoYM(parameter.get提供購入年月());
                dbT3043entity.setSeiriNp(parameter.get整理番号());
                dbT3043entity.setJigyoshaNo(parameter.get事業者番号());
                dbT3043entity.setYoshikiNo(parameter.get証明書コード());
                dbT3043entity.setMeisaiNo(parameter.get明細番号());
                dbT3043entity.setRenban(parameter.get連番());
                dbT3043entity.setShokujiTeikyoTotalNissu(parameter.get食事提供延べ日数());
                dbT3043entity.setShokujiTeikyohiTotal(parameter.get食事提供費合計());
                dbT3043entity.setGetsugakuHyojunFutangaku(parameter.get標準負担月額());
                dbT3043entity.setShokujiTeikyohiSeikyugaku(parameter.get食事提供費請求額());
                dbT3043entity.setNichigakuHyojunFutangaku(parameter.get標準負担日額());
                dbT3043entity.setState(EntityDataState.Added);
                償還払請求食事費用Dac.save(dbT3043entity);

            } else {
                DbT3043ShokanShokujiHiyoEntity dbT3043entity = new DbT3043ShokanShokujiHiyoEntity();
                dbT3043entity.setHiHokenshaNo(parameter.get被保険者番号());
                dbT3043entity.setServiceTeikyoYM(parameter.get提供購入年月());
                dbT3043entity.setSeiriNp(parameter.get整理番号());
                dbT3043entity.setJigyoshaNo(parameter.get事業者番号());
                dbT3043entity.setYoshikiNo(parameter.get証明書コード());
                dbT3043entity.setMeisaiNo(parameter.get明細番号());
                dbT3043entity.setRenban(parameter.get連番());
                dbT3043entity.setShokujiTeikyoTotalNissu(parameter.get食事提供延べ日数());
                dbT3043entity.setShokujiTeikyohiTotal(parameter.get食事提供費合計());
                dbT3043entity.setGetsugakuHyojunFutangaku(parameter.get標準負担月額());
                dbT3043entity.setShokujiTeikyohiSeikyugaku(parameter.get食事提供費請求額());
                dbT3043entity.setNichigakuHyojunFutangaku(parameter.get標準負担日額());
                dbT3043entity.setState(EntityDataState.Modified);
                償還払請求食事費用Dac.save(dbT3043entity);
            }
        }
    }

    /**
     * 決定情報登録更新
     *
     * @param parameter
     */
    public void updKetteJoho(SyokanbaraihiShikyuShinseiKetteParameter parameter) {

        RString 修正前支給区分 = null;
        List<SyokanbaraihiShikyuShinseiKetteEntity> 決定情報一覧List = parameter.get決定情報一覧List();
        if (parameter.get決定年月日() != null && parameter.get決定年月日().isEmpty()) {
            DbT3036ShokanHanteiKekkaEntity dbT3036entity
                    = 償還払支給判定結果Dac.selectByKey(parameter.get被保険者番号(),
                            parameter.getサービス提供年月(), parameter.get整理番号());
            if (dbT3036entity == null) {
                DbT3034ShokanShinseiEntity dbT3034entity
                        = 償還払支給申請Dac.selectByKey(parameter.get被保険者番号(),
                                parameter.getサービス提供年月(), parameter.get整理番号());
                DbT3036ShokanHanteiKekkaEntity entity = new DbT3036ShokanHanteiKekkaEntity();
                entity.setHiHokenshaNo(parameter.get被保険者番号());
                entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                entity.setSeiriNo(parameter.get整理番号());
                if (dbT3034entity != null) {
                    entity.setShoKisaiHokenshaNo(dbT3034entity.getShoKisaiHokenshaNo());
                }
                entity.setKetteiYMD(parameter.get決定年月日());
                entity.setShikyuHushikyuKetteiKubun(parameter.get支給区分());
                entity.setShiharaiKingaku(parameter.get支払金額合計());
                entity.setState(EntityDataState.Added);
                償還払支給判定結果Dac.save(entity);
                修正前支給区分 = ShikyuFushikyuKubun.不支給.getコード();

            } else {
                DbT3036ShokanHanteiKekkaEntity entity = new DbT3036ShokanHanteiKekkaEntity();
                entity.setHiHokenshaNo(parameter.get被保険者番号());
                entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                entity.setSeiriNo(parameter.get整理番号());
                entity.setKetteiYMD(parameter.get決定年月日());
                entity.setShikyuHushikyuKetteiKubun(parameter.get支給区分());
                entity.setShiharaiKingaku(parameter.get支払金額合計());
                entity.setState(EntityDataState.Modified);
                償還払支給判定結果Dac.save(entity);
                修正前支給区分 = dbT3036entity.getShikyuHushikyuKetteiKubun();
            }
            DbT3053ShokanShukeiEntity dbT3053entity = new DbT3053ShokanShukeiEntity();
            dbT3053entity.setHiHokenshaNo(parameter.get被保険者番号());
            dbT3053entity.setServiceTeikyoYM(parameter.getサービス提供年月());
            dbT3053entity.setSeiriNo(parameter.get整理番号());
            dbT3053entity.setShikyuKubunCode(parameter.get支給区分());
            dbT3053entity.setSeikyugakuSagakuKingaku(parameter.get差額金額());
            dbT3053entity.setDekidakaSeikyugakuSagaku(parameter.get差額金額());
            dbT3053entity.setZougenRiyu(parameter.get増減理由等());
            dbT3053entity.setHushikyuRiyu(parameter.get不支給理由等1());
            dbT3053entity.setKounyuKaishuRireki(parameter.get不支給理由等2());
            dbT3053entity.setState(EntityDataState.Modified);
            int 更新件数 = 償還払請求集計Dac.save(dbT3053entity);
            if (更新件数 == 0) {
                if (決定情報一覧List != null && !決定情報一覧List.isEmpty()) {
                    for (SyokanbaraihiShikyuShinseiKetteEntity 決定情報一覧 : 決定情報一覧List) {
                        if (new FlexibleYearMonth("200904").isBeforeOrEquals(parameter.getサービス提供年月())) {
                            DbT3047ShokanServicePlan200904Entity dbT3047entity
                                    = new DbT3047ShokanServicePlan200904Entity();
                            dbT3047entity.setHiHokenshaNo(parameter.get被保険者番号());
                            dbT3047entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                            dbT3047entity.setSeiriNp(parameter.get整理番号());
                            dbT3047entity.setShikyuKubunCode(parameter.get支給区分());
                            dbT3047entity.setZougenTen(parameter.get増減単位());
                            dbT3047entity.setSagakuKingaku(決定情報一覧.get差額金額());
                            dbT3047entity.setZougenRiyu(parameter.get増減理由等());
                            dbT3047entity.setFushikyuRiyu(parameter.get不支給理由等1());
                            dbT3047entity.setKounyuKaishuRireki(parameter.get不支給理由等2());
                            dbT3047entity.setState(EntityDataState.Modified);
                            償還払請求サービス計画200904Dac.save(dbT3047entity);
                        } else if (parameter.getサービス提供年月().isBeforeOrEquals(new FlexibleYearMonth("200903"))
                                && new FlexibleYearMonth("200604").isBeforeOrEquals(parameter.getサービス提供年月())) {
                            DbT3046ShokanServicePlan200604Entity dbT3046entity
                                    = new DbT3046ShokanServicePlan200604Entity();
                            dbT3046entity.setHiHokenshaNo(parameter.get被保険者番号());
                            dbT3046entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                            dbT3046entity.setSeiriNp(parameter.get整理番号());
                            dbT3046entity.setShikyuKubunCode(parameter.get支給区分());
                            dbT3046entity.setZougenTen(parameter.get増減単位());
                            dbT3046entity.setSagakuKingaku(決定情報一覧.get差額金額());
                            dbT3046entity.setZougenRiyu(parameter.get増減理由等());
                            dbT3046entity.setFushikyuRiyu(parameter.get不支給理由等1());
                            dbT3046entity.setKounyuKaishuRireki(parameter.get不支給理由等2());
                            dbT3046entity.setState(EntityDataState.Modified);
                            償還払請求サービス計画200604Dac.save(dbT3046entity);
                        } else if (parameter.getサービス提供年月().isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
                            DbT3045ShokanServicePlan200004Entity dbT3045entity
                                    = new DbT3045ShokanServicePlan200004Entity();
                            dbT3045entity.setHiHokenshaNo(parameter.get被保険者番号());
                            dbT3045entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                            dbT3045entity.setSeiriNp(parameter.get整理番号());
                            dbT3045entity.setShikyuKubunCode(parameter.get支給区分());
                            dbT3045entity.setZougenTen(parameter.get増減単位());
                            dbT3045entity.setSagakuKingaku(決定情報一覧.get差額金額());
                            dbT3045entity.setZougenRiyu(parameter.get増減理由等());
                            dbT3045entity.setFushikyuRiyu(parameter.get不支給理由等1());
                            dbT3045entity.setKounyuKaishuRireki(parameter.get不支給理由等2());
                            dbT3045entity.setState(EntityDataState.Modified);
                            償還払請求サービス計画200004Dac.save(dbT3045entity);
                        }
                    }
                }
            }
        }
        if (parameter.is差額金額登録フラグ()) {
            if (決定情報一覧List != null && !決定情報一覧List.isEmpty()) {
                for (SyokanbaraihiShikyuShinseiKetteEntity 決定情報一覧 : 決定情報一覧List) {
                    if (決定情報一覧.getテーブル区分() != null && !決定情報一覧.getテーブル区分().isEmpty()) {
                        DbT3043ShokanShokujiHiyoEntity dbT3043entity = new DbT3043ShokanShokujiHiyoEntity();
                        DbT3053ShokanShukeiEntity dbT3053entity = new DbT3053ShokanShukeiEntity();
                        DbT3047ShokanServicePlan200904Entity dbT3047entity
                                = new DbT3047ShokanServicePlan200904Entity();
                        DbT3046ShokanServicePlan200604Entity dbT3046entity
                                = new DbT3046ShokanServicePlan200604Entity();
                        DbT3045ShokanServicePlan200004Entity dbT3045entity
                                = new DbT3045ShokanServicePlan200004Entity();
                        DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity dbT3050entity
                                = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
                        switch (Integer.valueOf(決定情報一覧.getテーブル区分().toString())) {
                            case 3:
                                dbT3053entity.setHiHokenshaNo(parameter.get被保険者番号());
                                dbT3053entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                                dbT3053entity.setSeiriNo(parameter.get整理番号());
                                dbT3053entity.setJigyoshaNo(決定情報一覧.get事業者番号());
                                dbT3053entity.setYoshikiNo(決定情報一覧.get証明書コード());
                                dbT3053entity.setMeisaiNo(決定情報一覧.get明細番号());
                                dbT3053entity.setRenban(決定情報一覧.get連番());
                                dbT3053entity.setShikyuKubunCode(parameter.get支給区分());
                                dbT3053entity.setSeikyugakuSagakuKingaku(決定情報一覧.get差額金額());
                                dbT3053entity.setDekidakaSeikyugakuSagaku(決定情報一覧.get差額金額());
                                dbT3053entity.setState(EntityDataState.Modified);
                                償還払請求集計Dac.save(dbT3053entity);
                                break;
                            case 4:
                                dbT3043entity.setHiHokenshaNo(parameter.get被保険者番号());
                                dbT3043entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                                dbT3043entity.setSeiriNp(parameter.get整理番号());
                                dbT3043entity.setJigyoshaNo(決定情報一覧.get事業者番号());
                                dbT3043entity.setYoshikiNo(決定情報一覧.get証明書コード());
                                dbT3043entity.setMeisaiNo(決定情報一覧.get明細番号());
                                dbT3043entity.setRenban(決定情報一覧.get連番());
                                dbT3043entity.setSagakuKingaku(決定情報一覧.get差額金額());
                                dbT3043entity.setState(EntityDataState.Modified);
                                償還払請求食事費用Dac.save(dbT3043entity);
                                break;
                            case 5:
                                dbT3050entity.setHiHokenshaNo(parameter.get被保険者番号());
                                dbT3050entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                                dbT3050entity.setSeiriNo(parameter.get整理番号());
                                dbT3050entity.setJigyoshaNo(決定情報一覧.get事業者番号());
                                dbT3050entity.setYoshikiNo(決定情報一覧.get証明書コード());
                                dbT3050entity.setMeisaiNo(決定情報一覧.get明細番号());
                                dbT3050entity.setRenban(決定情報一覧.get連番());
                                dbT3050entity.setSagakuKingaku(決定情報一覧.get差額金額());
                                dbT3050entity.setState(EntityDataState.Modified);
                                償還払請求特定入所者介護サービス費用Dac.save(dbT3050entity);
                                break;
                            case 6:
                                dbT3047entity.setHiHokenshaNo(parameter.get被保険者番号());
                                dbT3047entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                                dbT3047entity.setSeiriNp(parameter.get整理番号());
                                dbT3047entity.setJigyoshaNo(決定情報一覧.get事業者番号());
                                dbT3047entity.setYoshikiNo(決定情報一覧.get証明書コード());
                                dbT3047entity.setMeisaiNo(決定情報一覧.get明細番号());
                                dbT3047entity.setRenban(決定情報一覧.get連番());
                                dbT3047entity.setSagakuKingaku(決定情報一覧.get差額金額());
                                dbT3047entity.setState(EntityDataState.Modified);
                                償還払請求サービス計画200904Dac.save(dbT3047entity);
                                break;
                            case 7:
                                dbT3046entity.setHiHokenshaNo(parameter.get被保険者番号());
                                dbT3046entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                                dbT3046entity.setSeiriNp(parameter.get整理番号());
                                dbT3046entity.setJigyoshaNo(決定情報一覧.get事業者番号());
                                dbT3046entity.setYoshikiNo(決定情報一覧.get証明書コード());
                                dbT3046entity.setMeisaiNo(決定情報一覧.get明細番号());
                                dbT3046entity.setRenban(決定情報一覧.get連番());
                                dbT3046entity.setSagakuKingaku(決定情報一覧.get差額金額());
                                dbT3046entity.setState(EntityDataState.Modified);
                                償還払請求サービス計画200604Dac.save(dbT3046entity);
                                break;
                            case 8:
                                dbT3045entity.setHiHokenshaNo(parameter.get被保険者番号());
                                dbT3045entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                                dbT3045entity.setSeiriNp(parameter.get整理番号());
                                dbT3045entity.setJigyoshaNo(決定情報一覧.get事業者番号());
                                dbT3045entity.setYoshikiNo(決定情報一覧.get証明書コード());
                                dbT3045entity.setMeisaiNo(決定情報一覧.get明細番号());
                                dbT3045entity.setRenban(決定情報一覧.get連番());
                                dbT3045entity.setShikyuKubunCode(parameter.get支給区分());
                                dbT3045entity.setSagakuKingaku(決定情報一覧.get差額金額());
                                dbT3045entity.setState(EntityDataState.Modified);
                                償還払請求サービス計画200004Dac.save(dbT3045entity);
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        UrErrorMessages.不正.getMessage().replace("テーブル区分").evaluate());
                        }
                    }
                }
            }
        }
        if (parameter.get決定年月日() != null && parameter.get決定年月日().isEmpty()) {
            KyufujissekiEntity entity = getKyufujisseki(parameter.get被保険者番号(),
                    parameter.getサービス提供年月(), parameter.get整理番号());
            SyokanbaraiShikyuKetteKyufuJssekiHensyuManager manager
                    = SyokanbaraiShikyuKetteKyufuJssekiHensyuManager.createInstance();
            manager.dealKyufujisseki(parameter.get画面モード(), parameter.get識別コード(), entity, 修正前支給区分);
        }
    }

    /**
     * 社福軽減額サービス種類取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public List<DbT3053ShokanShukeiEntity> getShafukukeigenServiceList(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        List<DbT3053ShokanShukeiEntity> entityList = null;
        return entityList;
    }

    /**
     * 社福軽減額軽減率取得
     *
     * @param 被保険者番号
     * @param サービス年月
     * @param 整理番号
     * @return
     */
    public KyufujissekiEntity getShafukukeigenKeigenrichiList(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号) {
        DbT3034ShokanShinseiEntity dbT3034entity = 償還払支給申請Dac.selectByKey(被保険者番号, サービス年月, 整理番号);
        HokenshaNo 証記載保険者番号 = dbT3034entity.getShoKisaiHokenshaNo();

//        List<DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity> entityList;
        return null;

    }

    /**
     * 標準負担額（日額）取得
     *
     * @param 被保険者番号
     * @param サービス年月
     * @param 整理番号
     * @return
     */
    public int getHyojyunfutangaku(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号) {
        DbT3034ShokanShinseiEntity dbT3034entity = 償還払支給申請Dac.selectByKey(被保険者番号, サービス年月, 整理番号);
        HokenshaNo 証記載保険者番号 = dbT3034entity.getShoKisaiHokenshaNo();
        //標準負担額（日額）を取得する。

//        DbT7131KaigoServiceNaiyouEntity entity;
        return 1;

    }

    /**
     * 給付実績データ取得
     *
     * @param 被保険者番号
     * @param サービス年月
     * @param 整理番号
     * @return
     */
    public KyufujissekiEntity getKyufujisseki(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            RString 整理番号) {
        return null;

    }

    /**
     * 識別番号一覧データ取得
     *
     * @param 特定診療のサービス種類コード
     * @param 識別コード2
     * @param 基準年月
     * @return
     */
    public List<DbT7120TokuteiShinryoServiceCodeEntity> getShikibetsuBangoIchiran(
            ServiceShuruiCode 特定診療のサービス種類コード,
            ServiceKomokuCode 識別コード2, FlexibleYearMonth 基準年月) {
        List<DbT7120TokuteiShinryoServiceCodeEntity> entityList
                = 特定診療サービスコードDac.selectAllByKey(特定診療のサービス種類コード, 識別コード2, 基準年月);
        return entityList;
    }

    /**
     *
     * サービス計画費情報件数取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return データ件数
     */
    public int updShokanServicePlan(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス提供年月)) {
            return 償還払請求サービス計画200904Dac.selectサービス計画費情報件数(被保険者番号, サービス提供年月,
                    整理番号, 事業者番号, 様式番号, 明細番号);
        }
        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
            return 償還払請求サービス計画200004Dac.selectサービス計画費情報件数(被保険者番号, サービス提供年月,
                    整理番号, 事業者番号, 様式番号, 明細番号);
        }
        return 償還払請求サービス計画200604Dac.selectサービス計画費情報件数(被保険者番号, サービス提供年月,
                整理番号, 事業者番号, 様式番号, 明細番号);
    }
}
