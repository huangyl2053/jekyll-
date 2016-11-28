/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho1;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonShukeiRelate;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiSearchDataBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShukeiKekkaDataBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKihonJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKogakuKaigoServicehiJyohou;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKogakuKaigoServicehiRelate;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.DBC0010000StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.DBC0010000TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010000.KyufuJissekiShokaiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010000.KyufuJissekiShokaiHandler2;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010000.KyufuJissekiShokaiValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
    private static final int INT_37 = 37;
    private static final int INT_38 = 38;
    private static final int INT_39 = 39;
    private static final int INT_40 = 40;
    private static final int INT_41 = 41;
    private static final int INT_42 = 42;
    private static final int INT_43 = 43;
    private static final int INT_44 = 44;
    private static final int INT_45 = 45;
    private static final int INT_46 = 46;
    private static final int INT_47 = 47;
    private static final int INT_48 = 48;
    private static final int INT_49 = 49;
    private static final int INT_50 = 50;
    private static final int INT_51 = 51;
    private static final int INT_52 = 52;
    private static final int INT_53 = 53;
    private static final int INT_54 = 54;
    private static final int INT_55 = 55;
    private static final int INT_56 = 56;
    private static final int INT_57 = 57;
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
                getHandler2(div).onLoad(被保険者番号, 識別コード);
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
        getHandler2(div).onClick_btnKyufuJissekiSearchClear();
        return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会検索);
    }

    /**
     * 抽出範囲を変更する場合、画面を表示する。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onChange_radKyufuJissekiSearchDateType(KyufuJissekiShokaiDiv div) {
        getHandler2(div).onChange_radKyufuJissekiSearchDateType();
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
        div.setHiddenSearchKey(検索対象);
        KyufuJissekiShokaiHandler handler = getHandler(div);
        KyufuJissekiSearchDataBusiness 一覧データ = new KyufuJissekiSearchDataBusiness();
        List<KyufuJissekiShukeiKekkaDataBusiness> 集計データ
                = getHandler2(div).edit集計データ(サービス提供年月_開始, サービス提供年月_終了, !KEY.equals(検索対象), 一覧データ, 被保険者番号);
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).do検索チェック(集計データ);
        if (validationMessages.iterator().hasNext()) {
            div.getKyufuJissekiSearchPanel().setIsOpen(true);
            div.getKyufuJissekiListPanel().setIsOpen(false);
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        for (int i = INT_ZERO; i < INT_NJYUNG; i++) {
            div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(i).setVisible(true);
        }
        KyufuJissekiHeader 給付実績基本情報子Divデータ
                = handler.onClick_btnKyufuJissekiSearch(給付実績ヘッダ情報1.get(INT_ZERO),
                        サービス提供年月_開始, サービス提供年月_終了, 一覧データ);
        ViewStateHolder.put(ViewStateKeys.給付実績情報照会検索一覧, 一覧データ);
        ViewStateHolder.put(ViewStateKeys.給付実績基本情報子Div, 給付実績基本情報子Divデータ);
        div.getKyufuJissekiSearchPanel().setIsOpen(false);
        div.getKyufuJissekiListPanel().setIsOpen(true);
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
        setパラメータ(div, INT_ICHI);
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
        setパラメータ(div, INT_NI);
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
        setパラメータ(div, INT_SAN);
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
        setパラメータ(div, INT_YON);
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
        setパラメータ(div, INT_GO);
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
        setパラメータ(div, INT_ROKU);
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
        setパラメータ(div, INT_NANA);
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
        setパラメータ(div, INT_HACHI);
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
        setパラメータ(div, INT_KYU);
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
        setパラメータ(div, INT_JYU);
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
        setパラメータ(div, INT_JYUI);
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
        setパラメータ(div, INT_JYUN);
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
        setパラメータ(div, INT_JYUS);
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
        setパラメータ(div, INT_JYUY);
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
        setパラメータ(div, INT_JYUG);
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
        setパラメータ(div, INT_JYUR);
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
        setパラメータ(div, INT_JYUNA);
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
        setパラメータ(div, INT_JYUH);
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
        setパラメータ(div, INT_JYUK);
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
        setパラメータ(div, INT_NJYU);
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
        setパラメータ(div, INT_NJYUI);
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
        setパラメータ(div, INT_NJYUN);
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
        setパラメータ(div, INT_NJYUS);
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
        setパラメータ(div, INT_NJYUY);
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
        setパラメータ(div, INT_NJYUG);
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
        setパラメータ(div, INT_NJYUR);
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
        setパラメータ(div, INT_NJYUNA);
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
        setパラメータ(div, INT_NJYUH);
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
        setパラメータ(div, INT_NJYUK);
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
        setパラメータ(div, INT_SJYU);
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
        setパラメータ(div, INT_SJYUI);
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
        setパラメータ(div, INT_SJYUN);
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
        setパラメータ(div, INT_SJYUS);
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
        setパラメータ(div, INT_SJYUY);
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
        setパラメータ(div, INT_SJYUG);
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
        setパラメータ(div, INT_SJYUR);
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
        div.setHiddenEndIndex(new RString(INT_SJYUG));
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

    private void setパラメータ(KyufuJissekiShokaiDiv div, int 列) {
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(new RDate(div.getDgKyufuJissekiMeisaiList().getGridSetting().
                getColumns().get(列 * INT_NI + INT_ICHI).getGroupName().toString()).getYearMonth().toDateString());
        ViewStateHolder.put(ViewStateKeys.サービス提供年月, サービス提供年月);
        int rowId = div.getDgKyufuJissekiMeisaiList().getClickedRowId();
        if (rowId == INT_55) {
            TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            FlexibleYearMonth サービス提供年月_開始 = new FlexibleYearMonth(div.getHiddenStartYM());
            FlexibleYearMonth サービス提供年月_終了 = new FlexibleYearMonth(div.getHiddenEndYM());
            HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
            List<KyufujissekiKogakuKaigoServicehiRelate> 給付実績高額介護サービス費データリスト
                    = KyufuJissekiShokaiFinder.createInstance().get給付実績高額介護サービス費データ(
                            被保険者番号, サービス提供年月_開始, サービス提供年月_終了, KEY.equals(div.getHiddenSearchKey()));
            KyufujissekiKogakuKaigoServicehiJyohou servicehiJyohou = new KyufujissekiKogakuKaigoServicehiJyohou();
            servicehiJyohou.setCsData_I(給付実績高額介護サービス費データリスト);
            ViewStateHolder.put(ViewStateKeys.給付実績高額明細管理情報, servicehiJyohou);
        } else {
            List<KyufuJissekiKihonShukeiRelate> 給付実績基本データ = get給付実績基本データ(div);
            KyufujissekiKihonJyohou kyufujissekiKihonJyohou = new KyufujissekiKihonJyohou();
            kyufujissekiKihonJyohou.setCsData_A(給付実績基本データ);
            ViewStateHolder.put(ViewStateKeys.給付実績基本情報, kyufujissekiKihonJyohou);
        }
    }

    private List<KyufuJissekiKihonShukeiRelate> get給付実績基本データ(KyufuJissekiShokaiDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        FlexibleYearMonth サービス提供年月_開始 = new FlexibleYearMonth(div.getHiddenStartYM());
        FlexibleYearMonth サービス提供年月_終了 = new FlexibleYearMonth(div.getHiddenEndYM());
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        List<RString> サービス種類コードList = new ArrayList<>();
        RString 検索条件番目;
        int rowId = div.getDgKyufuJissekiMeisaiList().getClickedRowId();
        if (KEY.equals(div.getHiddenSearchKey())) {
            if (rowId == INT_NJYUR) {
                検索条件番目 = new RString(INT_ICHI);
            } else if (rowId == INT_51 || rowId == INT_53) {
                検索条件番目 = new RString(INT_YON);
            } else if (rowId == INT_52 || rowId == INT_54) {
                検索条件番目 = new RString(INT_GO);
            } else {
                検索条件番目 = new RString(INT_SAN);
                サービス種類コードList = getサービス種類コードList(div);
            }
        } else {
            if (rowId == INT_JYUNA) {
                検索条件番目 = new RString(INT_NI);
            } else if (rowId == INT_NJYUY || rowId == INT_NJYUG) {
                検索条件番目 = new RString(INT_NANA);
            } else {
                検索条件番目 = new RString(INT_SAN);
                サービス種類コードList = getサービス種類コードList(div);
            }
        }
        return KyufuJissekiShokaiFinder.createInstance().get給付実績基本データ(被保険者番号, サービス提供年月_開始,
                サービス提供年月_終了, KEY.equals(div.getHiddenSearchKey()), 検索条件番目, サービス種類コードList);
    }

    private List<RString> getサービス種類コードList(KyufuJissekiShokaiDiv div) {
        if (KEY.equals(div.getHiddenSearchKey())) {
            return getサービス種類コード_日常生活支援総合事業(div);
        } else {
            return getサービス種類コード_経過措置(div);
        }
    }

    private List<RString> getサービス種類コード_日常生活支援総合事業(KyufuJissekiShokaiDiv div) {
        List<RString> サービス種類コード_日常生活支援総合事業 = new ArrayList<>();
        int rowId = div.getDgKyufuJissekiMeisaiList().getClickedRowId();
        if (rowId == INT_56) {
            サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.用具販売.getコード());
            サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予用販売.getコード());
        } else if (rowId == INT_57) {
            サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.住宅改修.getコード());
            サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予住改修.getコード());
        } else {
            List<Integer> rowIdList = new ArrayList<>();
            if (rowId <= INT_46) {
                rowIdList.add(rowId);
            } else {
                List<Integer> 合計Index = get合計Index(rowId);
                for (int index = 合計Index.get(0); index <= 合計Index.get(1); index++) {
                    rowIdList.add(index);
                }
            }
            サービス種類コード_日常生活支援総合事業.addAll(getサービス種類コード_日常生活支援総合事業(rowIdList));
        }
        Set<RString> サービス種類コード = new HashSet(サービス種類コード_日常生活支援総合事業);
        サービス種類コード_日常生活支援総合事業 = new ArrayList<>(サービス種類コード);
        return サービス種類コード_日常生活支援総合事業;
    }

    private List<Integer> get合計Index(int 合計一覧のINDEX) {
        List<Integer> 合計Index = new ArrayList<>();
        if (合計一覧のINDEX == INT_47) {
            合計Index.add(INT_ZERO);
            合計Index.add(INT_JYUS);
        } else if (合計一覧のINDEX == INT_48) {
            合計Index.add(INT_NJYUNA);
            合計Index.add(INT_SJYUI);
        } else if (合計一覧のINDEX == INT_49) {
            合計Index.add(INT_JYUY);
            合計Index.add(INT_NJYUG);
        } else if (合計一覧のINDEX == INT_50) {
            合計Index.add(INT_SJYUN);
            合計Index.add(INT_46);
        }
        return 合計Index;
    }

    private List<RString> getサービス種類コード_日常生活支援総合事業(List<Integer> rowIdList) {
        List<RString> サービス種類コード_日常生活支援総合事業 = new ArrayList<>();
        for (int rowId : rowIdList) {
            switch (rowId) {
                case INT_ZERO:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.訪問介護.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予訪介護.getコード());
                    break;
                case INT_ICHI:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.訪問入浴.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予訪入浴.getコード());
                    break;
                case INT_NI:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.訪問看護.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予訪看護.getコード());
                    break;
                case INT_SAN:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.訪問リハ.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予訪リハ.getコード());
                    break;
                case INT_YON:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.通所介護.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予通介護.getコード());
                    break;
                case INT_GO:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.通所リハ.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予通リハ.getコード());
                    break;
                case INT_ROKU:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.用具貸与.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予用貸与.getコード());
                    break;
                case INT_NANA:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.短期生活.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予短介護.getコード());
                    break;
                case INT_HACHI:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.短期老健.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予短老健.getコード());
                    break;
                case INT_KYU:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.短期医療.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予短医療.getコード());
                    break;
                case INT_JYU:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.短期老健.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予短老健.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.短期医療.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予短医療.getコード());
                    break;
                case INT_JYUI:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.療養指導.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予療養指.getコード());
                    break;
                case INT_JYUN:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.特施短外.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予特施設.getコード());
                    break;
                case INT_JYUS:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.特施短期.getコード());
                    break;
                case INT_JYUY:
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地共同介.getコード());
                    サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地予共同.getコード());
                    break;
                default:
                    getサービス種類コード_日常生活支援総合事業_1(rowId, サービス種類コード_日常生活支援総合事業);
                    break;
            }
        }
        return サービス種類コード_日常生活支援総合事業;
    }

    private void getサービス種類コード_日常生活支援総合事業_1(int rowId, List<RString> サービス種類コード_日常生活支援総合事業) {
        switch (rowId) {
            case INT_JYUG:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地施短外.getコード());
                break;
            case INT_JYUR:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地施短期.getコード());
                break;
            case INT_JYUNA:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地共同短.getコード());
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地予共短.getコード());
                break;
            case INT_JYUH:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地夜間訪.getコード());
                break;
            case INT_JYUK:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地通所介.getコード());
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地予通所.getコード());
                break;
            case INT_NJYU:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地小短外.getコード());
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地予小外.getコード());
                break;
            case INT_NJYUI:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地小規単.getコード());
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地予小短.getコード());
                break;
            case INT_NJYUN:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.定期随時.getコード());
                break;
            case INT_NJYUS:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.看小短外.getコード());
                break;
            case INT_NJYUY:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.看小規短.getコード());
                break;
            case INT_NJYUG:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地域通所.getコード());
                break;
            case INT_NJYUR:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.居宅支援.getコード());
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予防支援.getコード());
                break;
            case INT_NJYUNA:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.福祉施設.getコード());
                break;
            case INT_NJYUH:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.老健施設.getコード());
                break;
            case INT_NJYUK:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.医療施設.getコード());
                break;
            case INT_SJYU:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.地福祉生.getコード());
                break;
            case INT_SJYUI:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.老健施設.getコード());
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.医療施設.getコード());
                break;
            default:
                getサービス種類コード_日常生活支援総合事業_2(rowId, サービス種類コード_日常生活支援総合事業);
                break;
        }
    }

    private void getサービス種類コード_日常生活支援総合事業_2(int rowId, List<RString> サービス種類コード_日常生活支援総合事業) {
        switch (rowId) {
            case INT_SJYUN:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.訪問みな.getコード());
                break;
            case INT_SJYUS:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.訪問独自.getコード());
                break;
            case INT_SJYUY:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.訪問定率.getコード());
                break;
            case INT_SJYUG:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.訪問定額.getコード());
                break;
            case INT_SJYUR:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.通所みな.getコード());
                break;
            case INT_37:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.通所独自.getコード());
                break;
            case INT_38:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.通所定率.getコード());
                break;
            case INT_39:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.通所定額.getコード());
                break;
            case INT_40:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.予防ケア.getコード());
                break;
            case INT_41:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.配食定率.getコード());
                break;
            case INT_42:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.配食定額.getコード());
                break;
            case INT_43:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.見守定率.getコード());
                break;
            case INT_44:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.見守定額.getコード());
                break;
            case INT_45:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.その他率.getコード());
                break;
            case INT_46:
                サービス種類コード_日常生活支援総合事業.add(ServiceCategoryShurui.その他額.getコード());
                break;
            default:
                break;
        }
    }

    private List<RString> getサービス種類コード_経過措置(KyufuJissekiShokaiDiv div) {
        int rowId = div.getDgKyufuJissekiMeisaiList().getClickedRowId();
        List<Integer> rowIdList = new ArrayList<>();
        if (rowId <= INT_NJYU) {
            rowIdList.add(rowId);
        } else {
            int beginInde;
            int endIndex;
            if (rowId == INT_NJYUI) {
                beginInde = INT_ZERO;
                endIndex = INT_JYUN;
            } else if (rowId == INT_NJYUN) {
                beginInde = INT_JYUS;
                endIndex = INT_JYUR;
            } else {
                beginInde = INT_JYUH;
                endIndex = INT_NJYU;
            }
            for (int index = beginInde; index <= endIndex; index++) {
                rowIdList.add(index);
            }
        }
        List<RString> サービス種類コード_経過措置 = new ArrayList<>();
        getサービス種類コード_経過措置(rowIdList, サービス種類コード_経過措置);
        return サービス種類コード_経過措置;
    }

    private void getサービス種類コード_経過措置(List<Integer> rowIdList, List<RString> サービス種類コード_経過措置) {
        for (int rowId : rowIdList) {
            switch (rowId) {
                case INT_ZERO:
                    サービス種類コード_経過措置.add(ServiceCategoryShurui.総訪予防.getコード());
                    break;
                case INT_ICHI:
                    サービス種類コード_経過措置.add(ServiceCategoryShurui.総訪入浴.getコード());
                    break;
                case INT_NI:
                    サービス種類コード_経過措置.add(ServiceCategoryShurui.総訪看護.getコード());
                    break;
                case INT_SAN:
                    サービス種類コード_経過措置.add(ServiceCategoryShurui.総訪リハ.getコード());
                    break;
                case INT_YON:
                    サービス種類コード_経過措置.add(ServiceCategoryShurui.総通予防.getコード());
                    break;
                case INT_GO:
                    サービス種類コード_経過措置.add(ServiceCategoryShurui.総通リハ.getコード());
                    break;
                case INT_ROKU:
                    サービス種類コード_経過措置.add(ServiceCategoryShurui.総用貸与.getコード());
                    break;
                case INT_NANA:
                    サービス種類コード_経過措置.add(ServiceCategoryShurui.総短介護.getコード());
                    break;
                case INT_HACHI:
                    サービス種類コード_経過措置.add(ServiceCategoryShurui.総短老健.getコード());
                    break;
                case INT_KYU:
                    サービス種類コード_経過措置.add(ServiceCategoryShurui.総短医療.getコード());
                    break;
                case INT_JYU:
                    サービス種類コード_経過措置.add(ServiceCategoryShurui.総短老健.getコード());
                    サービス種類コード_経過措置.add(ServiceCategoryShurui.総短医療.getコード());
                    break;
                default:
                    getサービス種類コード_経過措置_1(rowId, サービス種類コード_経過措置);
                    break;
            }
        }
    }

    private void getサービス種類コード_経過措置_1(int rowId, List<RString> サービス種類コード_経過措置) {
        switch (rowId) {
            case INT_JYUI:
                サービス種類コード_経過措置.add(ServiceCategoryShurui.総療養指.getコード());
                break;
            case INT_JYUN:
                サービス種類コード_経過措置.add(ServiceCategoryShurui.総特施設.getコード());
                break;
            case INT_JYUS:
                サービス種類コード_経過措置.add(ServiceCategoryShurui.地総通所.getコード());
                break;
            case INT_JYUY:
                サービス種類コード_経過措置.add(ServiceCategoryShurui.地総共短.getコード());
                break;
            case INT_JYUG:
                サービス種類コード_経過措置.add(ServiceCategoryShurui.地総共同.getコード());
                break;
            case INT_JYUR:
                サービス種類コード_経過措置.add(ServiceCategoryShurui.地総小規.getコード());
                break;
            case INT_JYUH:
                サービス種類コード_経過措置.add(ServiceCategoryShurui.生活配食.getコード());
                break;
            case INT_JYUK:
                サービス種類コード_経過措置.add(ServiceCategoryShurui.生活見守.getコード());
                break;
            case INT_NJYU:
                サービス種類コード_経過措置.add(ServiceCategoryShurui.生活他.getコード());
                break;
            default:
                break;
        }
    }

    private KyufuJissekiShokaiHandler getHandler(KyufuJissekiShokaiDiv div) {
        return new KyufuJissekiShokaiHandler(div);
    }

    private KyufuJissekiShokaiHandler2 getHandler2(KyufuJissekiShokaiDiv div) {
        return new KyufuJissekiShokaiHandler2(div);
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
        setパラメータ(div, ボタン列);
        if (KEY.equals(div.getHiddenSearchKey())) {
            int 選択行 = div.getDgKyufuJissekiMeisaiList().getClickedRowId();
            if (INT_HACHI + INT_47 == 選択行) {
                return response_GokeiKogakuKaigoService(div);
            }
        }
        return response_Meisai(div);
    }

    private ResponseData<KyufuJissekiShokaiDiv> response_GokeiKogakuKaigoService(KyufuJissekiShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0010000TransitionEventName.高額介護サービス費).respond();
    }

    private KyufuJissekiSearchDataBusiness get一覧データ() {
        return ViewStateHolder.get(ViewStateKeys.給付実績情報照会検索一覧, KyufuJissekiSearchDataBusiness.class);
    }
}
