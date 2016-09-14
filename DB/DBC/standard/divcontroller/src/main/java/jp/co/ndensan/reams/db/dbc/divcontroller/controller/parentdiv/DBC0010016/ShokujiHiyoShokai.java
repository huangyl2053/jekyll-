/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010016;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010016.DBC0010016TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010016.ShokujiHiyoShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010016.ShokujiHiyoShokaiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_(DBC0010016)食事費用のcontrollerです
 *
 * @reamsid_L DBC-2970-080 zhaoran
 */
public class ShokujiHiyoShokai {

    private static final int ZERO_INT = 0;
    private static final int SEX_INT = 6;

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData<ShokujiHiyoShokaiDiv> onLoad(ShokujiHiyoShokaiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        NyuryokuShikibetsuNo 識別番号検索キー = ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class);
        RString 年月 = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_介護給付費見直し,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substringEmptyOnError(ZERO_INT, SEX_INT);
        FlexibleYearMonth 提供年月 = new FlexibleYearMonth(年月);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        div.getCcdKyufuJissekiHeader().initialize(
                給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(), サービス提供年月,
                ViewStateHolder.get(ViewStateKeys.整理番号, RString.class), 識別番号検索キー);
        if (提供年月.isBeforeOrEquals(サービス提供年月)) {
            List<KyufujissekiShokujiHiyo> 給付実績食事費用1504 = 給付実績情報照会情報.getCsData_E();
            getHandler(div).set給付実績食事費用15041(給付実績食事費用1504);
            List<KyufujissekiMeisaiBusiness> 給付実績明細 = 給付実績情報照会情報.getCsData_B();
            getHandler(div).set給付実績明細(給付実績明細);
            div.getDgShokujiHiyoToH1503().setDisplayNone(true);
        } else {
            List<KyufujissekiShokujiHiyo> 給付実績食事費用1503 = 給付実績情報照会情報.getCsData_E();
            getHandler(div).set給付実績食事費用15031(給付実績食事費用1503);
            div.getDgShokujiHiyoGokeiFromH1504().setDisplayNone(true);
            div.getDgShokujiHiyoMeisaiFromH1504().setDisplayNone(true);
        }
        ShikibetsuNoKanri 識別番号管理データ取得 = KyufuJissekiShokaiFinder.createInstance().getShikibetsuBangoKanri(
                サービス提供年月, 識別番号検索キー).records().get(0);
        getHandler(div).setButton(識別番号管理データ取得, サービス提供年月);
        return ResponseData.of(div).respond();

    }

    /**
     * 「前事業者」ボタン押下
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData<ShokujiHiyoShokaiDiv> onClick_MaeJigyosha(ShokujiHiyoShokaiDiv div) {
        List<KyufuJissekiHedajyoho2> 事業者番号リスト
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class)
                .getCommonHeader().get給付実績ヘッダ情報2();
        List<KyufujissekiShokujiHiyo> 給付実績食事費用1504
                = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrmBusiness.class).getCsData_E();
        List<KyufujissekiMeisaiBusiness> 給付実績明細
                = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrmBusiness.class).getCsData_B();
        List<KyufujissekiShokujiHiyo> 給付実績食事費用1503
                = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrmBusiness.class).getCsData_E();
        getHandler(div).change事業者(new RString("前事業者"), 事業者番号リスト, 給付実績食事費用1504, 給付実績明細, 給付実績食事費用1503);
        return ResponseData.of(div).respond();
    }

    /**
     * 「後事業者」ボタン押下
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData<ShokujiHiyoShokaiDiv> onClick_AtoJigyosha(ShokujiHiyoShokaiDiv div) {
        List<KyufuJissekiHedajyoho2> 事業者番号リスト
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class)
                .getCommonHeader().get給付実績ヘッダ情報2();
        List<KyufujissekiShokujiHiyo> 給付実績食事費用1504
                = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrmBusiness.class).getCsData_E();
        List<KyufujissekiMeisaiBusiness> 給付実績明細
                = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrmBusiness.class).getCsData_B();
        List<KyufujissekiShokujiHiyo> 給付実績食事費用1503
                = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrmBusiness.class).getCsData_E();
        getHandler(div).change事業者(new RString("後事業者"), 事業者番号リスト, 給付実績食事費用1504, 給付実績明細, 給付実績食事費用1503);
        return ResponseData.of(div).respond();
    }

    /**
     * 「前月」ボタン押下
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData<ShokujiHiyoShokaiDiv> onClick_btnZengetsu(ShokujiHiyoShokaiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufujissekiShokujiHiyo> 給付実績食事費用1504
                = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrmBusiness.class).getCsData_E();
        List<KyufujissekiMeisaiBusiness> 給付実績明細
                = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrmBusiness.class).getCsData_B();
        List<KyufujissekiShokujiHiyo> 給付実績食事費用1503
                = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrmBusiness.class).getCsData_E();
        RString 年月 = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_介護給付費見直し,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substringEmptyOnError(ZERO_INT, SEX_INT);
        FlexibleYearMonth 提供年月 = new FlexibleYearMonth(年月);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        if (提供年月.isBeforeOrEquals(サービス提供年月)) {
            getHandler(div).change食費1504年月(new RString("前月"), 給付実績食事費用1504,
                    new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString()),
                    ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                    給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                    ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class));
            getHandler(div).change明細年月(new RString("前月"), 給付実績明細,
                    new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString()),
                    ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                    給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                    ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class));
            FlexibleYearMonth 画面提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
            ViewStateHolder.put(ViewStateKeys.サービス提供年月, 画面提供年月);
        } else {
            getHandler(div).change食費1503年月(new RString("前月"), 給付実績食事費用1503,
                    new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString()),
                    ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                    給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                    ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class));
            FlexibleYearMonth 画面提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
            ViewStateHolder.put(ViewStateKeys.サービス提供年月, 画面提供年月);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「次月」ボタン押下
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData<ShokujiHiyoShokaiDiv> onClick_btnJigetsu(ShokujiHiyoShokaiDiv div) {
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        List<KyufujissekiShokujiHiyo> 給付実績食事費用1504
                = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrmBusiness.class).getCsData_E();
        List<KyufujissekiMeisaiBusiness> 給付実績明細
                = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrmBusiness.class).getCsData_B();
        List<KyufujissekiShokujiHiyo> 給付実績食事費用1503
                = ViewStateHolder.get(ViewStateKeys.資格対象者, KyufuJissekiPrmBusiness.class).getCsData_E();
        RString 年月 = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_介護給付費見直し,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substringEmptyOnError(ZERO_INT, SEX_INT);
        FlexibleYearMonth 提供年月 = new FlexibleYearMonth(年月);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        if (提供年月.isBeforeOrEquals(サービス提供年月)) {
            getHandler(div).change食費1504年月(new RString("次月"), 給付実績食事費用1504,
                    new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString()),
                    ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                    給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                    ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class));
            getHandler(div).change明細年月(new RString("次月"), 給付実績明細,
                    new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString()),
                    ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                    給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                    ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class));
            FlexibleYearMonth 画面提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
            ViewStateHolder.put(ViewStateKeys.サービス提供年月, 画面提供年月);
        } else {
            getHandler(div).change食費1503年月(new RString("次月"), 給付実績食事費用1503,
                    new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString()),
                    ViewStateHolder.get(ViewStateKeys.整理番号, RString.class),
                    給付実績情報照会情報.getKojinKakuteiKey().get被保険者番号(),
                    ViewStateHolder.get(ViewStateKeys.識別番号検索キー, NyuryokuShikibetsuNo.class));
            FlexibleYearMonth 画面提供年月 = new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString());
            ViewStateHolder.put(ViewStateKeys.サービス提供年月, 画面提供年月);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 基本情報ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKihon(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.基本情報).respond();
    }

    /**
     * 明細集計ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnMeisaiShukei(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.明細_集計).respond();
    }

    /**
     * 緊急時施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKinkyujiShisetsuRyoyo(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.緊急時施設療養費).respond();
    }

    /**
     * 所定疾患施設療養費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShoteiShikkanShisetsuRyoyo(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.所定疾患施設療養費).respond();
    }

    /**
     * 福祉用具購入費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnFukushiYoguKonyu(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.福祉用具購入費).respond();
    }

    /**
     * 特定入所者費用ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiNyushosha(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.特定入所者費用).respond();
    }

    /**
     * 高額介護サービス費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKogakuKaigoService(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.高額介護サービス費).respond();
    }

    /**
     * 特定診療費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnTokuteiShinryo(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.特定診療費).respond();
    }

    /**
     * 居宅サービス計画費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKyotakuServiceKeikaku(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.居宅サービス計画費).respond();
    }

    /**
     * 住宅改修費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnJutakuKaishu(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.住宅改修費).respond();
    }

    /**
     * ケアマネジメント費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnCareManagement(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.ケアマネジメント費).respond();
    }

    /**
     * 社福軽減費ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData
     */
    public ResponseData onClick_btnShafukuKeigen(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.社福軽減費).respond();
    }

    /**
     * 給付実績一覧に戻るを押します。
     *
     * @param div 画面情報
     * @return ResponseData<ShokujiHiyoShokaiDiv>
     */
    public ResponseData onClick_btnReturn(ShokujiHiyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010016TransitionEventName.給付実績照会検索一覧).respond();
    }

    private ShokujiHiyoShokaiHandler getHandler(ShokujiHiyoShokaiDiv div) {
        return new ShokujiHiyoShokaiHandler(div);
    }
}
