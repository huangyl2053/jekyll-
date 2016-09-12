/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.KogakuShinseiList;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuShinseiList.KogakuShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuShinseiList.KogakuShinseiListDivHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuShinseiList.KogakuShinseiListDivValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCKD00005_高額申請一覧共有子Div
 *
 * @reamsid_L DBC-2020-010 quxiaodong
 */
public class KogakuShinseiList {

    private static final RString 参照モード = new RString("参照モード");
    private static final RString 修正モード = new RString("修正モード");
    private static final RString 削除モード = new RString("削除モード");

    /**
     * 「申請情報を追加する」ボタン
     *
     * @param div KogakuShinseiListDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShinseiListDiv> onClick_btnShinseiJohoTsuika(
            KogakuShinseiListDiv div) {
        FlexibleYearMonth サービス年月 = FlexibleYearMonth.EMPTY;
        if (div.getTxtServiceYM().getDomain() != null) {
            サービス年月 = new FlexibleYearMonth(div.getTxtServiceYM().getDomain().toString());
        }
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, div.getTxtShokisai().getValue());
        int 履歴番号 = 0;
        ViewStateHolder.put(ViewStateKeys.履歴番号, 履歴番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 「対象者情報を追加する」ボタン
     *
     * @param div KogakuShinseiListDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShinseiListDiv> onClick_btnTaishosyaJoho(
            KogakuShinseiListDiv div) {
        FlexibleYearMonth サービス年月 = FlexibleYearMonth.EMPTY;
        if (div.getTxtServiceYM().getDomain() != null) {
            サービス年月 = new FlexibleYearMonth(div.getTxtServiceYM().getDomain().toString());
        }
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, div.getTxtShokisai().getValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索」ボタン
     *
     * @param div KogakuShinseiListDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShinseiListDiv> onClick_btnKensaku(
            KogakuShinseiListDiv div) {
        getValidationHandler(div).入力チェック();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).入力チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).検索一覧(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                ViewStateHolder.get(ViewStateKeys.メニューID, RString.class));
        return ResponseData.of(div).respond();
    }

    /**
     * 選択マック
     *
     * @param div KogakuShinseiListDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShinseiListDiv> onClick_select(
            KogakuShinseiListDiv div) {
        ViewStateHolder.put(ViewStateKeys.画面モード, 参照モード);
        return ResponseData.of(div).respond();
    }

    /**
     * 修正マック
     *
     * @param div KogakuShinseiListDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShinseiListDiv> onClick_modify(
            KogakuShinseiListDiv div) {
        FlexibleYearMonth サービス年月 = FlexibleYearMonth.EMPTY;
        if (div.getTxtServiceYM().getDomain() != null) {
            サービス年月 = new FlexibleYearMonth(div.getTxtServiceYM().getDomain().toString());
        }
        int 履歴番号 = getHandler(div).get履歴番号();
        boolean 審査決定フラグ = getHandler(div).is審査決定フラグ();
        boolean 支給区分フラグ = getHandler(div).is支給区分フラグ();
        ViewStateHolder.put(ViewStateKeys.画面モード, 修正モード);
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, div.getTxtShokisai().getValue());
        ViewStateHolder.put(ViewStateKeys.履歴番号, 履歴番号);
        ViewStateHolder.put(ViewStateKeys.審査決定フラグ, 審査決定フラグ);
        ViewStateHolder.put(ViewStateKeys.支給区分フラグ, 支給区分フラグ);
        return ResponseData.of(div).respond();
    }

    /**
     * 削除マック
     *
     * @param div KogakuShinseiListDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShinseiListDiv> onClick_delete(
            KogakuShinseiListDiv div) {
        FlexibleYearMonth サービス年月 = FlexibleYearMonth.EMPTY;
        if (div.getTxtServiceYM().getDomain() != null) {
            サービス年月 = new FlexibleYearMonth(div.getTxtServiceYM().getDomain().toString());
        }
        ViewStateHolder.put(ViewStateKeys.画面モード, 削除モード);
        int 履歴番号 = getHandler(div).get履歴番号();
        ViewStateHolder.put(ViewStateKeys.履歴番号, 履歴番号);
        ViewStateHolder.put(ViewStateKeys.サービス年月, サービス年月);
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, div.getTxtShokisai().getValue());
        return ResponseData.of(div).respond();
    }

    /**
     * サービス年月
     *
     * @param div KogakuShinseiListDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShinseiListDiv> onFocus_txtServiceYM(
            KogakuShinseiListDiv div) {
        FlexibleYearMonth サービス年月 = FlexibleYearMonth.EMPTY;
        if (div.getTxtServiceYM().getDomain() != null) {
            サービス年月 = new FlexibleYearMonth(div.getTxtServiceYM().getDomain().toString());
        }
        getHandler(div).set証記載保険者番号(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                サービス年月, ViewStateHolder.get(ViewStateKeys.導入形態コード, RString.class));
        return ResponseData.of(div).respond();
    }

    private KogakuShinseiListDivHandler getHandler(KogakuShinseiListDiv div) {
        return new KogakuShinseiListDivHandler(div);
    }

    private KogakuShinseiListDivValidationHandler getValidationHandler(KogakuShinseiListDiv div) {
        return new KogakuShinseiListDivValidationHandler(div);
    }

}
