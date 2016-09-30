/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010000;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho1;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiSearchDataBusiness;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.DBC0010000StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.DBC0010000TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010000.KyufuJissekiShokaiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010000.KyufuJissekiShokaiValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
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
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            div.getCcdKaigoShikakuKihon().setVisible(true);
            return ResponseData.of(div).addMessage(new InformationMessage(
                    DbcInformationMessages.被保険者でないデータ.getMessage().getCode(),
                    DbcInformationMessages.被保険者でないデータ.getMessage().evaluate())).respond();
        }
        setアクセスログ(識別コード, 被保険者番号);
        getHandler(div).onLoad(被保険者番号, 識別コード);
        return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会検索);
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
            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        FlexibleYearMonth サービス提供年月_開始 = getサービス提供年月_開始(div);
        FlexibleYearMonth サービス提供年月_終了 = getサービス提供年月_終了(div);
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        List<KyufuJissekiHedajyoho1> 給付実績ヘッダ情報1 = KyufuJissekiShokaiFinder.createInstance().
                getKyufuJissekiHeaderJoho1(被保険者番号).records();
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = KyufuJissekiShokaiFinder.createInstance().
                get検索データ(被保険者番号, サービス提供年月_開始, サービス提供年月_終了);
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).do検索チェック(給付実績情報照会情報);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        KyufuJissekiSearchDataBusiness 一覧データ = 給付実績情報照会情報.getSearchData();
        getHandler(div).onClick_btnKyufuJissekiSearch(給付実績ヘッダ情報1.get(INT_ZERO),
                サービス提供年月_開始, サービス提供年月_終了, 一覧データ);
        ViewStateHolder.put(ViewStateKeys.給付実績情報照会情報, 給付実績情報照会情報);
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
            div.getDgKyufuJissekiGokeiList().getGridSetting().getColumns().get(i).setVisible(false);
        }
        return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会検索);
    }

    /**
     * 選択ボタンを押下する場合、基本情報照会画面（DBC0010011）へ遷移します。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_Meisai_btnYM1(KyufuJissekiShokaiDiv div) {
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
        FlexibleYearMonth サービス提供年月_開始 = getサービス提供年月_開始(div);
        FlexibleYearMonth サービス提供年月_終了 = getサービス提供年月_終了(div);
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
        FlexibleYearMonth サービス提供年月_開始 = getサービス提供年月_開始(div);
        FlexibleYearMonth サービス提供年月_終了 = getサービス提供年月_終了(div);
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
        return ResponseData.of(div).forwardWithEventName(DBC0010000TransitionEventName.明細_集計).respond();
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
        if (KEY.equals(div.getRadTaisho1().getSelectedKey())) {
            setパラメータサービス提供年月(div, ボタン列);
            int 選択行 = div.getDgKyufuJissekiGokeiList().getClickedRowId();
            if (INT_HACHI == 選択行) {
                return response_GokeiKogakuKaigoService(div);
            } else if (INT_KYU == 選択行) {
                return response_GokeiFukushiYogu(div);
            } else if (INT_JYU == 選択行) {
                return response_GokeiJyutakuKayisyu(div);
            }
        }
        return ResponseData.of(div).respond();
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
        KyufuJissekiPrmBusiness 給付実績情報照会情報
                = ViewStateHolder.get(ViewStateKeys.給付実績情報照会情報, KyufuJissekiPrmBusiness.class);
        return 給付実績情報照会情報.getSearchData();
    }
}
