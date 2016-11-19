/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010000;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.JukyushaDaichoJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KojinKakuteiKey;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiCareManagementHiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiCareManagementHiJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho1;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonShukeiRelate;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiSearchDataBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShakaiFukushiHojinKeigengakuBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShakaiFukushiHojinKeigengakuJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiFukushiYoguHanbaihiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiFukushiYoguHanbaihiJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiJutakuKaishuhiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiJutakuKaishuhiJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKihonJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKinkyuShisetsuRyoyoJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKogakuKaigoServicehiJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKyotakuServiceBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKyotakuServiceJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiJushochiTokureiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiJushochiTokureiJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiShokujiHiyoJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiShoteiShikkanShisetsuRyoyoJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiShukeiJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiTokuteiNyushosyaKaigoServiceHiyoJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiTokuteiSinryoTokubetsuRyoyoJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiTokuteiSinryohiJyohou;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.DBC0010000StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.DBC0010000TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010000.KyufuJissekiShokaiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010000.KyufuJissekiShokaiValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_給付実績照会検索一覧画面
 *
 * @reamsid_L DBC-2970-010 linghuhang
 */
public class KyufuJissekiShokai {

    private static final int INT_ZERO = 0;
    private static final int INT_ICHI = 1;
    private static final int INT_NI = 2;
    private static final int INT_SAN = 3;
    private static final int INT_YON = 4;
    private static final int INT_GO = 5;
    private static final int INT_ROKU = 6;
    private static final int INT_NANA = 7;
    private static final int INT_HACHI = 8;
    private static final int INT_KYU = 9;
    private static final int INT_JYU = 10;
    private static final int INT_JYUI = 11;
    private static final int INT_JYUN = 12;
    private static final int INT_JYUS = 13;
    private static final int INT_JYUY = 14;
    private static final int INT_JYUG = 15;
    private static final int INT_JYUR = 16;
    private static final int INT_JYUNA = 17;
    private static final int INT_JYUH = 18;
    private static final int INT_JYUK = 19;
    private static final int INT_NJYU = 20;
    private static final int INT_NJYUI = 21;
    private static final int INT_NJYUN = 22;
    private static final int INT_NJYUS = 23;
    private static final int INT_NJYUY = 24;
    private static final int INT_NJYUG = 25;
    private static final int INT_NJYUR = 26;
    private static final int INT_NJYUNA = 27;
    private static final int INT_NJYUH = 28;
    private static final int INT_NJYUK = 29;
    private static final int INT_SJYU = 30;
    private static final int INT_SJYUI = 31;
    private static final int INT_SJYUN = 32;
    private static final int INT_SJYUS = 33;
    private static final int INT_SJYUY = 34;
    private static final int INT_SJYUG = 35;
    private static final int INT_SJYUR = 36;
    private static final int INT_47 = 47;
    private static final int INT_NJYUNG = 75;
    private static final RString KEY = new RString("key0");
    private static final RString サービス提供月_開始 = new RString("04");
    private static final RString サービス提供月_終了 = new RString("03");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onLoad(KyufuJissekiShokaiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            InformationMessage message = new InformationMessage(
                    DbcInformationMessages.被保険者でないデータ.getMessage().getCode(),
                    DbcInformationMessages.被保険者でないデータ.getMessage().evaluate());
            TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
            ShikibetsuCode 識別コード = 資格対象者.get識別コード();
            if (被保険者番号 == null || 被保険者番号.isEmpty()) {
                div.getCcdKaigoShikakuKihon().setVisible(false);
                return ResponseData.of(div).addMessage(message).respond();
            } else {
                setアクセスログ(識別コード, 被保険者番号);
                getHandler(div).onLoad(被保険者番号, 識別コード);
                return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会検索);
            }
        }
        if (ResponseHolder.getMessageCode().equals(new RString(DbcInformationMessages.被保険者でないデータ.getMessage().getCode()))
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).forwardWithEventName(DBC0010000TransitionEventName.対象者検索).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「条件をクリアする」ボタン押下する、検索条件パネル内の状態を初期状態にする。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_btnKyufuJissekiSearchClear(KyufuJissekiShokaiDiv div) {
        getHandler(div).onClick_btnKyufuJissekiSearchClear();
        return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会検索);
    }

    /**
     * 抽出範囲を変更する場合、画面を表示する。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onChange_radKyufuJissekiSearchDateType(KyufuJissekiShokaiDiv div) {
        getHandler(div).onChange_radKyufuJissekiSearchDateType();
        return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会検索);
    }

    /**
     * 「検索する」ボタン押下する、画面一覧を表示する。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_btnKyufuJissekiSearch(KyufuJissekiShokaiDiv div) {
        ValidationMessageControlPairs validation = getValidationHandler(div).doチェック();
        if (validation.iterator().hasNext()) {
            div.getKyufuJissekiSearchPanel().setIsOpen(true);
            div.getKyufuJissekiListPanel().setIsOpen(false);
            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        FlexibleYearMonth サービス提供年月_開始 = getサービス提供年月_開始(div);
        FlexibleYearMonth サービス提供年月_終了 = getサービス提供年月_終了(div);
        int 列 = サービス提供年月_終了.getBetweenMonths(サービス提供年月_開始) + INT_ICHI;
        div.setHiddenStartIndex(new RString(0));
        if (列 > INT_SJYUR) {
            div.setHiddenEndIndex(new RString(INT_SJYUG));
        } else {
            div.setHiddenEndIndex(new RString(列 - 1));
        }
        div.setHiddenStartYM(サービス提供年月_開始.toDateString());
        div.setHiddenEndYM(サービス提供年月_終了.toDateString());
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        List<KyufuJissekiHedajyoho1> 給付実績ヘッダ情報1 = KyufuJissekiShokaiFinder.createInstance().
                getKyufuJissekiHeaderJoho1(被保険者番号).records();
        RString 検索対象 = div.getRadTaisho1().getSelectedKey();
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = KyufuJissekiShokaiFinder.createInstance().
                get検索データ(被保険者番号, サービス提供年月_開始, サービス提供年月_終了, KEY.equals(検索対象));
        KyufuJissekiShokaiHandler handler = getHandler(div);
        handler.edit集計データ(サービス提供年月_開始, サービス提供年月_終了, !KEY.equals(検索対象), 給付実績情報照会情報, 被保険者番号);
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).do検索チェック(給付実績情報照会情報, 検索対象);
        if (validationMessages.iterator().hasNext()) {
            div.getKyufuJissekiSearchPanel().setIsOpen(true);
            div.getKyufuJissekiListPanel().setIsOpen(false);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        for (int i = INT_ZERO; i < INT_NJYUNG; i++) {
            div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(i).setVisible(true);
        }
        KyufuJissekiSearchDataBusiness 一覧データ = 給付実績情報照会情報.getSearchData();
        KyufuJissekiHeader 給付実績基本情報子Divデータ
                = handler.onClick_btnKyufuJissekiSearch(給付実績ヘッダ情報1.get(INT_ZERO),
                        サービス提供年月_開始, サービス提供年月_終了, 一覧データ);
        setパラメータ(給付実績情報照会情報, 給付実績基本情報子Divデータ);
        div.getKyufuJissekiSearchPanel().setIsOpen(false);
        div.getKyufuJissekiListPanel().setIsOpen(true);
        div.setHiddenSearchKey(検索対象);
        return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会一覧);
    }

    /**
     * 「再検索する」ボタンを押下する、画面を表示する。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_btnKyufuJissekiResearch(KyufuJissekiShokaiDiv div) {
        for (int i = INT_ZERO; i < INT_NJYUNG; i++) {
            div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(i).setVisible(false);
        }
        return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会検索);
    }

    private int get明細一覧件数(RString searchKey) {
        if (KEY.equals(searchKey)) {
            return INT_47;
        }
        return INT_NJYUI;
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM1(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM1(div);
        }
        setパラメータサービス提供年月(div, INT_ICHI);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM2(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM2(div);
        }
        setパラメータサービス提供年月(div, INT_NI);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM3(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM3(div);
        }
        setパラメータサービス提供年月(div, INT_SAN);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM4(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM4(div);
        }
        setパラメータサービス提供年月(div, INT_YON);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM5(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM5(div);
        }
        setパラメータサービス提供年月(div, INT_GO);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM6(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM6(div);
        }
        setパラメータサービス提供年月(div, INT_ROKU);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM7(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM7(div);
        }
        setパラメータサービス提供年月(div, INT_NANA);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM8(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM8(div);
        }
        setパラメータサービス提供年月(div, INT_HACHI);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM9(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM9(div);
        }
        setパラメータサービス提供年月(div, INT_KYU);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM10(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM10(div);
        }
        setパラメータサービス提供年月(div, INT_JYU);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM11(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM11(div);
        }
        setパラメータサービス提供年月(div, INT_JYUI);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM12(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM12(div);
        }
        setパラメータサービス提供年月(div, INT_JYUN);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM13(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM13(div);
        }
        setパラメータサービス提供年月(div, INT_JYUS);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM14(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM4(div);
        }
        setパラメータサービス提供年月(div, INT_JYUY);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM15(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM15(div);
        }
        setパラメータサービス提供年月(div, INT_JYUG);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM16(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM16(div);
        }
        setパラメータサービス提供年月(div, INT_JYUR);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM17(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM17(div);
        }
        setパラメータサービス提供年月(div, INT_JYUNA);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM18(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM18(div);
        }
        setパラメータサービス提供年月(div, INT_JYUH);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM19(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM19(div);
        }
        setパラメータサービス提供年月(div, INT_JYUK);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM20(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM20(div);
        }
        setパラメータサービス提供年月(div, INT_NJYU);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM21(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM21(div);
        }
        setパラメータサービス提供年月(div, INT_NJYUI);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM22(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM22(div);
        }
        setパラメータサービス提供年月(div, INT_NJYUN);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM23(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM23(div);
        }
        setパラメータサービス提供年月(div, INT_NJYUS);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM24(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM24(div);
        }
        setパラメータサービス提供年月(div, INT_NJYUY);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM25(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM25(div);
        }
        setパラメータサービス提供年月(div, INT_NJYUG);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM26(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM26(div);
        }
        setパラメータサービス提供年月(div, INT_NJYUR);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM27(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM27(div);
        }
        setパラメータサービス提供年月(div, INT_NJYUNA);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM28(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM28(div);
        }
        setパラメータサービス提供年月(div, INT_NJYUH);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM29(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM29(div);
        }
        setパラメータサービス提供年月(div, INT_NJYUK);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM30(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM30(div);
        }
        setパラメータサービス提供年月(div, INT_SJYU);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM31(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM31(div);
        }
        setパラメータサービス提供年月(div, INT_SJYUI);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM32(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM32(div);
        }
        setパラメータサービス提供年月(div, INT_SJYUN);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM33(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM33(div);
        }
        setパラメータサービス提供年月(div, INT_SJYUS);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM34(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM34(div);
        }
        setパラメータサービス提供年月(div, INT_SJYUY);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM35(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM35(div);
        }
        setパラメータサービス提供年月(div, INT_SJYUG);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM36(KyufuJissekiShokaiDiv div) {
        if (div.getDgKyufuJissekiMeisaiList().getClickedRowId() >= get明細一覧件数(div.getHiddenSearchKey())) {
            return onClick_Gokei_btnYM36(div);
        }
        setパラメータサービス提供年月(div, INT_SJYUR);
        return response_Meisai(div);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM1(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_ICHI);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM2(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_NI);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM3(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_SAN);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM4(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_YON);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM5(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_GO);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM6(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_ROKU);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM7(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_NANA);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM8(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_HACHI);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM9(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_KYU);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM10(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_JYU);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM11(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_JYUI);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM12(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_JYUN);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM13(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_JYUS);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM14(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_JYUY);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM15(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_JYUG);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM16(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_JYUR);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM17(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_JYUNA);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM18(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_JYUH);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM19(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_JYUK);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM20(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_NJYU);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM21(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_NJYUI);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM22(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_NJYUN);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM23(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_NJYUS);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM24(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_NJYUY);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM25(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_NJYUG);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM26(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_NJYUR);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM27(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_NJYUNA);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM28(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_NJYUH);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM29(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_NJYUK);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM30(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_SJYU);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM31(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_SJYUI);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM32(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_SJYUN);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM33(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_SJYUS);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM34(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_SJYUY);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM35(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_SJYUG);
    }

    /**
     * 選択ボタンを押下する場合、画面へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Gokei_btnYM36(KyufuJissekiShokaiDiv div) {
        return response_Gokei(div, INT_SJYUR);
    }

    /**
     * 「＜＜」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_btnSento(KyufuJissekiShokaiDiv div) {
        FlexibleYearMonth サービス提供年月_開始 = new FlexibleYearMonth(div.getHiddenStartYM());
        FlexibleYearMonth サービス提供年月_終了 = new FlexibleYearMonth(div.getHiddenEndYM());
        div.setHiddenStartIndex(new RString(0));
        div.setHiddenEndIndex(new RString(INT_SJYU));
        getHandler(div).onClick_btnSento(サービス提供年月_開始, サービス提供年月_終了, get一覧データ());
        return ResponseData.of(div).respond();
    }

    /**
     * 「＜」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_btnMae(KyufuJissekiShokaiDiv div) {
        div.setHiddenStartIndex(new RString(Integer.parseInt(div.getHiddenStartIndex().toString()) - 1));
        div.setHiddenEndIndex(new RString(Integer.parseInt(div.getHiddenEndIndex().toString()) - 1));
        getHandler(div).onClick_btnMae(get一覧データ());
        return ResponseData.of(div).respond();
    }

    /**
     * 「＞」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_btnTsugi(KyufuJissekiShokaiDiv div) {
        div.setHiddenStartIndex(new RString(Integer.parseInt(div.getHiddenStartIndex().toString()) + 1));
        div.setHiddenEndIndex(new RString(Integer.parseInt(div.getHiddenEndIndex().toString()) + 1));
        getHandler(div).onClick_btnTsugi(get一覧データ());
        return ResponseData.of(div).respond();
    }

    /**
     * 「＞＞」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_btnSaigo(KyufuJissekiShokaiDiv div) {
        FlexibleYearMonth サービス提供年月_開始 = new FlexibleYearMonth(div.getHiddenStartYM());
        FlexibleYearMonth サービス提供年月_終了 = new FlexibleYearMonth(div.getHiddenEndYM());
        int 列 = サービス提供年月_終了.getBetweenMonths(サービス提供年月_開始) + INT_ICHI;
        div.setHiddenStartIndex(new RString(列 - INT_SJYUR));
        div.setHiddenEndIndex(new RString(列 - 1));
        getHandler(div).onClick_btnSaigo(サービス提供年月_開始, サービス提供年月_終了, get一覧データ());
        return ResponseData.of(div).respond();
    }

    private void setパラメータサービス提供年月(KyufuJissekiShokaiDiv div, int 列) {
        RString サービス提供年月 = div.getDgKyufuJissekiMeisaiList().getGridSetting().
                getColumns().get(列 * INT_NI + INT_ICHI).getGroupName();
        ViewStateHolder.put(ViewStateKeys.サービス提供年月,
                new FlexibleYearMonth(new RDate(サービス提供年月.toString()).getYearMonth().toDateString()));
    }

    private KyufuJissekiShokaiHandler getHandler(KyufuJissekiShokaiDiv div) {
        return new KyufuJissekiShokaiHandler(div);
    }

    private KyufuJissekiShokaiValidationHandler getValidationHandler(KyufuJissekiShokaiDiv div) {
        return new KyufuJissekiShokaiValidationHandler(div);
    }

    private void setアクセスログ(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        PersonalData personalData = PersonalData.of(識別コード,
                new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value()));
        AccessLogger.log(AccessLogType.照会, personalData);
    }

    private ResponseData<KyufuJissekiShokaiDiv> response_Meisai(KyufuJissekiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010000TransitionEventName.基本情報).respond();
    }

    private FlexibleYearMonth getサービス提供年月_開始(KyufuJissekiShokaiDiv div) {
        if (!RString.isNullOrEmpty(div.getRadNendo().getSelectedKey())) {
            RString 年度 = div.getDdlKyufuJissekiSearchNendo().getSelectedKey();
            if (!RString.isNullOrEmpty(年度)) {
                return new FlexibleYearMonth(年度.concat(サービス提供月_開始));
            }
        } else {
            if (div.getTxtKyufuJissekiSearchServiceTeikyoYM().getFromValue() != null) {
                return new FlexibleYearMonth(div.getTxtKyufuJissekiSearchServiceTeikyoYM().
                        getFromValue().toDateString().substring(INT_ZERO, INT_ROKU));
            }
        }
        return FlexibleYearMonth.EMPTY;
    }

    private FlexibleYearMonth getサービス提供年月_終了(KyufuJissekiShokaiDiv div) {
        if (!RString.isNullOrEmpty(div.getRadNendo().getSelectedKey())) {
            RString 年度 = div.getDdlKyufuJissekiSearchNendo().getSelectedKey();
            if (!RString.isNullOrEmpty(年度)) {
                return new FlexibleYearMonth(
                        new RString(Integer.parseInt(年度.toString()) + 1).concat(サービス提供月_終了));
            }
        } else {
            if (div.getTxtKyufuJissekiSearchServiceTeikyoYM().getToValue() != null) {
                return new FlexibleYearMonth(div.getTxtKyufuJissekiSearchServiceTeikyoYM().
                        getToValue().toDateString().substring(INT_ZERO, INT_ROKU));
            }
        }
        return FlexibleYearMonth.EMPTY;
    }

    private ResponseData<KyufuJissekiShokaiDiv> response_Gokei(KyufuJissekiShokaiDiv div, int ボタン列) {
        if (KEY.equals(div.getHiddenSearchKey())) {
            setパラメータサービス提供年月(div, ボタン列);
            int 選択行 = div.getDgKyufuJissekiMeisaiList().getClickedRowId();
            if (INT_HACHI + INT_47 == 選択行) {
                return response_GokeiKogakuKaigoService(div);
            } else if (INT_KYU + INT_47 == 選択行) {
                return response_GokeiFukushiYogu(div);
            } else if (INT_JYU + INT_47 == 選択行) {
                return response_GokeiJyutakuKayisyu(div);
            }
        }
        return response_Meisai(div);
    }

    private ResponseData<KyufuJissekiShokaiDiv> response_GokeiKogakuKaigoService(KyufuJissekiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010000TransitionEventName.高額介護サービス費).respond();
    }

    private ResponseData<KyufuJissekiShokaiDiv> response_GokeiFukushiYogu(KyufuJissekiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010000TransitionEventName.福祉用具購入費).respond();
    }

    private ResponseData<KyufuJissekiShokaiDiv> response_GokeiJyutakuKayisyu(KyufuJissekiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010000TransitionEventName.住宅改修費).respond();
    }

    private KyufuJissekiSearchDataBusiness get一覧データ() {
        return ViewStateHolder.get(ViewStateKeys.給付実績情報照会検索一覧, KyufuJissekiSearchDataBusiness.class);
    }

    private void setパラメータ(KyufuJissekiPrmBusiness 給付実績情報照会情報, KyufuJissekiHeader 給付実績基本情報子Divデータ) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();
        SetaiCode 世帯コード = 資格対象者.get世帯コード();
        KojinKakuteiKey key = new KojinKakuteiKey();
        key.set識別コード(識別コード);
        key.set被保険者番号(被保険者番号);
        key.set世帯コード(世帯コード);
        給付実績情報照会情報.setKojinKakuteiKey(key);
        ViewStateHolder.put(ViewStateKeys.給付実績情報照会検索一覧, 給付実績情報照会情報.getSearchData());
        KyufujissekiKihonJyohou kyufujissekiKihonJyohou = new KyufujissekiKihonJyohou();
        kyufujissekiKihonJyohou.setCsData_A(給付実績情報照会情報.getCsData_A());
        ViewStateHolder.put(ViewStateKeys.給付実績基本情報, kyufujissekiKihonJyohou);
        KyufujissekiMeisaiJyohou kyufujissekiMeisaiJyohou = new KyufujissekiMeisaiJyohou();
        kyufujissekiMeisaiJyohou.setCsData_B(給付実績情報照会情報.getCsData_B());
        ViewStateHolder.put(ViewStateKeys.給付実績サービス明細情報, kyufujissekiMeisaiJyohou);
        KyufujissekiKinkyuShisetsuRyoyoJyohou kyufujissekiJyohou = new KyufujissekiKinkyuShisetsuRyoyoJyohou();
        kyufujissekiJyohou.setCsData_C(給付実績情報照会情報.getCsData_C());
        ViewStateHolder.put(ViewStateKeys.給付実績施設療養情報, kyufujissekiJyohou);
        KyufujissekiTokuteiSinryohiJyohou tokuteiSinryohiJyohou = new KyufujissekiTokuteiSinryohiJyohou();
        tokuteiSinryohiJyohou.setCsData_D(給付実績情報照会情報.getCsData_D());
        ViewStateHolder.put(ViewStateKeys.給付実績特定診療費情報, tokuteiSinryohiJyohou);
        KyufujissekiTokuteiSinryoTokubetsuRyoyoJyohou tokubetsuRyoyoJyohou
                = new KyufujissekiTokuteiSinryoTokubetsuRyoyoJyohou();
        tokubetsuRyoyoJyohou.setCsData_J(給付実績情報照会情報.getCsData_J());
        ViewStateHolder.put(ViewStateKeys.給付実績特定診療費_特別療養費, tokubetsuRyoyoJyohou);
        KyufujissekiShokujiHiyoJyohou shokujiHiyoJyohou = new KyufujissekiShokujiHiyoJyohou();
        shokujiHiyoJyohou.setCsData_E(給付実績情報照会情報.getCsData_E());
        ViewStateHolder.put(ViewStateKeys.給付実績食事費用情報, shokujiHiyoJyohou);
        KyufujissekiKyotakuServiceJyohou kyotakuServiceJyohou = new KyufujissekiKyotakuServiceJyohou();
        kyotakuServiceJyohou.setCsData_F(給付実績情報照会情報.getCsData_F());
        ViewStateHolder.put(ViewStateKeys.給付実績計画費情報, kyotakuServiceJyohou);
        KyufujissekiFukushiYoguHanbaihiJyohou yoguHanbaihiJyohou = new KyufujissekiFukushiYoguHanbaihiJyohou();
        yoguHanbaihiJyohou.setCsData_G(給付実績情報照会情報.getCsData_G());
        ViewStateHolder.put(ViewStateKeys.給付実績福祉用具情報, yoguHanbaihiJyohou);
        KyufujissekiJutakuKaishuhiJyohou kaishuhiJyohou = new KyufujissekiJutakuKaishuhiJyohou();
        kaishuhiJyohou.setCsData_H(給付実績情報照会情報.getCsData_H());
        ViewStateHolder.put(ViewStateKeys.給付実績住宅改修情報, kaishuhiJyohou);
        KyufujissekiKogakuKaigoServicehiJyohou servicehiJyohou = new KyufujissekiKogakuKaigoServicehiJyohou();
        servicehiJyohou.setCsData_I(給付実績情報照会情報.getCsData_I());
        ViewStateHolder.put(ViewStateKeys.給付実績高額明細管理情報, servicehiJyohou);
        KyufujissekiTokuteiNyushosyaKaigoServiceHiyoJyohou serviceHiyoJyohou
                = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyoJyohou();
        serviceHiyoJyohou.setCsData_K(給付実績情報照会情報.getCsData_K());
        ViewStateHolder.put(ViewStateKeys.給付実績特定入所者介護サービス費用情報, serviceHiyoJyohou);
        KyufuJissekiShakaiFukushiHojinKeigengakuJyohou keigengakuJyohou
                = new KyufuJissekiShakaiFukushiHojinKeigengakuJyohou();
        keigengakuJyohou.setCsData_L(給付実績情報照会情報.getCsData_L());
        ViewStateHolder.put(ViewStateKeys.給付実績社会福祉法人軽減額情報, keigengakuJyohou);
        KyufuJissekiCareManagementHiJyohou managementHiJyohou = new KyufuJissekiCareManagementHiJyohou();
        managementHiJyohou.setCsData_M(給付実績情報照会情報.getCsData_M());
        ViewStateHolder.put(ViewStateKeys.給付実績ケアマネジメント費情報, managementHiJyohou);
        KyufujissekiMeisaiJushochiTokureiJyohou jushochiTokureiJyohou
                = new KyufujissekiMeisaiJushochiTokureiJyohou();
        jushochiTokureiJyohou.setCsData_N(給付実績情報照会情報.getCsData_N());
        ViewStateHolder.put(ViewStateKeys.給付実績明細_住所地特例, jushochiTokureiJyohou);
        KyufujissekiShukeiJyohou shukeiJyohou = new KyufujissekiShukeiJyohou();
        shukeiJyohou.setCsData_Z(給付実績情報照会情報.getCsData_Z());
        ViewStateHolder.put(ViewStateKeys.給付実績集計情報, shukeiJyohou);
        KyufujissekiShoteiShikkanShisetsuRyoyoJyohou shisetsuRyoyoJyohou
                = new KyufujissekiShoteiShikkanShisetsuRyoyoJyohou();
        shisetsuRyoyoJyohou.setCsData_P(給付実績情報照会情報.getCsData_P());
        ViewStateHolder.put(ViewStateKeys.給付実績所定疾患施設療養費, shisetsuRyoyoJyohou);
        JukyushaDaichoJyohou jukyushaDaichoJyohou = new JukyushaDaichoJyohou();
        jukyushaDaichoJyohou.setJukyushaData(給付実績情報照会情報.getJukyushaData());
        ViewStateHolder.put(ViewStateKeys.受給者台帳情報, jukyushaDaichoJyohou);
        clearパラメータ(給付実績情報照会情報);
        ViewStateHolder.put(ViewStateKeys.給付実績基本情報子Div, 給付実績基本情報子Divデータ);
    }

    private void clearパラメータ(KyufuJissekiPrmBusiness 給付実績情報照会情報) {
        KyufuJissekiSearchDataBusiness searchData = new KyufuJissekiSearchDataBusiness();
        給付実績情報照会情報.setSearchData(searchData);
        List<KyufuJissekiKihonShukeiRelate> csData_A = new ArrayList<>();
        給付実績情報照会情報.setCsData_A(csData_A);
        List<KyufujissekiMeisaiBusiness> csData_B = new ArrayList<>();
        給付実績情報照会情報.setCsData_B(csData_B);
        List<KyufujissekiKinkyuShisetsuRyoyo> csData_C = new ArrayList<>();
        給付実績情報照会情報.setCsData_C(csData_C);
        List<KyufujissekiTokuteiSinryohi> csData_D = new ArrayList<>();
        給付実績情報照会情報.setCsData_D(csData_D);
        List<KyufujissekiTokuteiSinryoTokubetsuRyoyo> csData_J = new ArrayList<>();
        給付実績情報照会情報.setCsData_J(csData_J);
        List<KyufujissekiShokujiHiyo> csData_E = new ArrayList<>();
        給付実績情報照会情報.setCsData_E(csData_E);
        List<KyufujissekiKyotakuServiceBusiness> csData_F = new ArrayList<>();
        給付実績情報照会情報.setCsData_F(csData_F);
        List<KyufujissekiFukushiYoguHanbaihiBusiness> csData_G = new ArrayList<>();
        給付実績情報照会情報.setCsData_G(csData_G);
        List<KyufujissekiJutakuKaishuhiBusiness> csData_H = new ArrayList<>();
        給付実績情報照会情報.setCsData_H(csData_H);
        List<KyufujissekiKogakuKaigoServicehi> csData_I = new ArrayList<>();
        給付実績情報照会情報.setCsData_I(csData_I);
        List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> csData_K = new ArrayList<>();
        給付実績情報照会情報.setCsData_K(csData_K);
        List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> csData_L = new ArrayList<>();
        給付実績情報照会情報.setCsData_L(csData_L);
        List<KyufuJissekiCareManagementHiBusiness> csData_M = new ArrayList<>();
        給付実績情報照会情報.setCsData_M(csData_M);
        List<KyufujissekiMeisaiJushochiTokureiBusiness> csData_N = new ArrayList<>();
        給付実績情報照会情報.setCsData_N(csData_N);
        List<KyufujissekiShukei> csData_Z = new ArrayList<>();
        給付実績情報照会情報.setCsData_Z(csData_Z);
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> csData_P = new ArrayList<>();
        給付実績情報照会情報.setCsData_P(csData_P);
        List<JukyushaDaicho> jukyushaData = new ArrayList<>();
        給付実績情報照会情報.setJukyushaData(jukyushaData);
        ViewStateHolder.put(ViewStateKeys.給付実績情報照会情報, 給付実績情報照会情報);
    }
}
