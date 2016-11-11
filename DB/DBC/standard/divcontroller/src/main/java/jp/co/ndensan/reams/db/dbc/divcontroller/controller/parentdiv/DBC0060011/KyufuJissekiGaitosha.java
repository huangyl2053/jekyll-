/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0060011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiDataModel;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyotakuServiceKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060011.DBC0060011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060011.KyufuJissekiGaitoshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060011.KyufuJissekiGaitoshaHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060011.KyufuJissekiGaitoshaValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufukanrihyoshokai.KyufuKanrihyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.saishinsamoshitatetouroku.HihokenshaDaichoAliveManager;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付管理票照会のControllerです。
 *
 * @reamsid_L DBC-2960-010 chenxiangyu
 */
public class KyufuJissekiGaitosha {

    private static final RString 台帳種別表示無し = new RString("台帳種別表示無し");
    private static final RString なし = new RString("なし");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 給付管理票照会のDIVです。
     * @return 給付管理票照会
     */
    public ResponseData<KyufuJissekiGaitoshaDiv> onLoad(KyufuJissekiGaitoshaDiv div) {
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 台帳種別表示無し);
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 給付管理票照会のDIVです。
     * @return 給付管理票照会
     */
    public ResponseData<KyufuJissekiGaitoshaDiv> onActive(KyufuJissekiGaitoshaDiv div) {
        set被保険者情報(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class), div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタンを押すの場合。
     *
     * @param div 給付管理票照会のDIVです。
     * @return 給付管理票照会
     */
    public ResponseData<KyufuJissekiGaitoshaDiv> onClick_btnSearch(KyufuJissekiGaitoshaDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validateFor必須項目();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        List<KyufuKanrihyoShokaiBusiness> 給付管理票一覧 = KyufuKanrihyoShokai.createInstance().selectKyufuKanrihyoList(
                div.getSearchToKyufujissekiPanel().getTxtHihoNo().getValue(),
                div.getSearchToKyufujissekiPanel().getCcdJigyoshaSentaku().getNyuryokuShisetsuKodo(),
                div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().getFromValue().getYearMonth().toDateString(),
                div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().getToValue().getYearMonth().toDateString());
        if (給付管理票一覧 != null) {
            getHandler(div).onClick_btnSearch(給付管理票一覧);
        } else {
            getHandler(div).set空給付管理票一覧();
            div.setHidden件数(なし);
            ValidationMessageControlPairs pairs2 = getValidationHandler(div).validateFor検索チェック();
            if (pairs2.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs2).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」ボタンを押すの場合。
     *
     * @param div 給付管理票照会のDIVです。
     * @return 給付管理票照会
     */
    public ResponseData<KyufuJissekiGaitoshaDiv> onSelectBySelectButton(KyufuJissekiGaitoshaDiv div) {
        KyufuKanrihyoShokaiDataModel 給付管理票 = getHandler(div).getKyufuKanrihyo200604();
        ArrayList<KyufuKanrihyoShokaiBusiness> 給付管理明細一覧 = (ArrayList) KyufuKanrihyoShokai.createInstance().
                selectKyufuKanriMeisaiList(
                        給付管理票.get審査年月().toDateString(),
                        給付管理票.getサービス提供年月().toDateString(),
                        給付管理票.get被保険者番号().value());
        ArrayList<KyufuKanrihyoShokaiDataModel> 給付管理明細一覧Model = new ArrayList<>();
        boolean 居宅サービスフラグ = false;
        boolean 訪問通所サービスフラグ = false;
        boolean 短期入所サービスフラグ = false;
        for (KyufuKanrihyoShokaiBusiness 給付管理明細 : 給付管理明細一覧) {
            KyufuKanrihyoShokaiDataModel dataModel = new KyufuKanrihyoShokaiDataModel();
            給付管理明細一覧Model.add(dataModel.createDataModel(給付管理明細));
            if (!居宅サービスフラグ && KyotakuServiceKubun.居宅サービス.getコード().equals(
                    給付管理明細.get給付管理票種別区分コード())) {
                居宅サービスフラグ = true;
            } else if (!訪問通所サービスフラグ && KyotakuServiceKubun.訪問通所.getコード().equals(
                    給付管理明細.get給付管理票種別区分コード())) {
                訪問通所サービスフラグ = true;
            } else if (!短期入所サービスフラグ && KyotakuServiceKubun.短期入所.getコード().equals(
                    給付管理明細.get給付管理票種別区分コード())) {
                短期入所サービスフラグ = true;
            }
        }
        ShikibetsuCode 識別コード = new ShikibetsuCode(給付管理票.get識別コード());
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.給付管理明細一覧, 給付管理明細一覧Model);
        ViewStateHolder.put(ViewStateKeys.給付管理票200604Entity, 給付管理票);
        ViewStateHolder.put(ViewStateKeys.訪問通所サービスフラグ, 訪問通所サービスフラグ);
        ViewStateHolder.put(ViewStateKeys.短期入所サービスフラグ, 短期入所サービスフラグ);
        ViewStateHolder.put(ViewStateKeys.居宅サービスフラグ, 居宅サービスフラグ);
        FlexibleYearMonth 支給限度額一本化年月 = new FlexibleYearMonth(div.getHdn支給限度額一本化年月());
        FlexibleYearMonth サービス提供年月 = 給付管理票.getサービス提供年月();
        if (支給限度額一本化年月.isBeforeOrEquals(サービス提供年月)) {
            return ResponseData.of(div).forwardWithEventName(
                    DBC0060011TransitionEventName.居宅サービスの給付管理照会へ).respond();
        } else {
            return ResponseData.of(div).forwardWithEventName(
                    DBC0060011TransitionEventName.訪問通所サービスの給付管理照会へ).respond();
        }
    }

    /**
     * 「被保番号検索」ボタンを押すの場合。
     *
     * @param div 給付管理票照会のDIVです。
     * @return 給付管理票照会
     */
    public ResponseData<KyufuJissekiGaitoshaDiv> onClick_btnSearchHihokensha(KyufuJissekiGaitoshaDiv div) {
        ViewStateHolder.put(ViewStateKeys.資格対象者, null);
        return ResponseData.of(div).forwardWithEventName(DBC0060011TransitionEventName.対象者検索).respond();
    }

    /**
     * 「被保番号」をブラーします。
     *
     * @param div 給付管理票照会のDIVです。
     * @return 給付管理票照会
     */
    public ResponseData<KyufuJissekiGaitoshaDiv> onBlur_txtHihoNo(KyufuJissekiGaitoshaDiv div) {
        if (RString.isNullOrEmpty(div.getSearchToKyufujissekiPanel().getTxtHihoNo().getValue())) {
            div.getSearchToKyufujissekiPanel().getTxtHihoName().clearValue();
        } else {
            HihokenshaDaichoAliveManager manager = new HihokenshaDaichoAliveManager();
            HihokenshaDaichoAlive date = manager.get最新の被保険者台帳情報(div.getTxtHihoNo().getValue());
            if (date == null) {
                div.getTxtHihoName().clearValue();
                return ResponseData.of(div).addValidationMessages(getValidationHandler(div)
                        .get存在しないエラーメッセージ()).respond();
            }
            IShikibetsuTaishoFinder 識別対象Finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
            IShikibetsuTaisho 宛名情報 = 識別対象Finder.get識別対象(
                    GyomuCode.DB介護保険, date.get識別コード(), KensakuYusenKubun.住登外優先);
            RString 被保名称 = 宛名情報.get名称().getName().value();
            div.getTxtHihoName().setValue(被保名称);
        }
        return ResponseData.of(div).respond();
    }

    private void set被保険者情報(TaishoshaKey 資格対象者, KyufuJissekiGaitoshaDiv div) {
        if (資格対象者 == null
                || 資格対象者.get被保険者番号() == null
                || HihokenshaNo.EMPTY.equals(資格対象者.get被保険者番号())) {
            div.getTxtHihoName().setValue(RString.EMPTY);
            return;
        }
        div.getTxtHihoNo().setValue(資格対象者.get被保険者番号().value());
        RString 被保名称 = RString.EMPTY;
        if (資格対象者.get識別コード() != null && !資格対象者.get識別コード().isEmpty()) {
            IShikibetsuTaishoFinder 識別対象Finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
            IShikibetsuTaisho 宛名情報 = 識別対象Finder.get識別対象(
                    GyomuCode.DB介護保険, 資格対象者.get識別コード(), KensakuYusenKubun.住登外優先);
            被保名称 = 宛名情報.get名称().getName().value();
        }
        div.getTxtHihoName().setValue(被保名称);
    }

    private KyufuJissekiGaitoshaHandler getHandler(KyufuJissekiGaitoshaDiv div) {
        return new KyufuJissekiGaitoshaHandler(div);
    }

    private KyufuJissekiGaitoshaValidationHandler getValidationHandler(KyufuJissekiGaitoshaDiv div) {
        return new KyufuJissekiGaitoshaValidationHandler(div);
    }
}
