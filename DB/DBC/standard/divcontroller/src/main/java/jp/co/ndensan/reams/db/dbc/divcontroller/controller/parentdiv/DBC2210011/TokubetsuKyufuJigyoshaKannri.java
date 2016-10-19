/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2210011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetsuKyufuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetsuKyufuJigyoshaIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshakannri.ShichosonTokubetsuKyufuJigyoshaViewState;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshakannri.TokubetsuKyufuJigyoshaSearchResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.DBC2210011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.TokubetsuKyufuJigyoshaKannriDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.dgTokubetsuKyufuJigyoshaList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2210011.TokubetsuKyufuJigyoshaKannriHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.ShichosonTokubetsuKyufuJigyoshaManager;
import jp.co.ndensan.reams.db.dbc.service.core.tokubetsukyufujigyoshakannri.TokubetsuKyufuJigyoshaRelateFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.CheckDigitFactory;
import jp.co.ndensan.reams.uz.uza.math.CheckDigitKind;
import jp.co.ndensan.reams.uz.uza.math.ICheckDigit;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMNG1002_市町村特別給付・サービス事業者管理のDivControllerです。
 *
 * @reamsid_L DBC-3430-010 miaojin
 */
public class TokubetsuKyufuJigyoshaKannri {

    /**
     * 画面初期化
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return ResponseData<TokubetsuKyufuJigyoshaKannriDiv>
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onLoad(TokubetsuKyufuJigyoshaKannriDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBC2210011StateName.検索初期);
    }

    /**
     * 「Ｃ／Ｄ　Button」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnSearchCheckDigit(TokubetsuKyufuJigyoshaKannriDiv div) {
        ICheckDigit icheckgigit = CheckDigitFactory.getInstance(CheckDigitKind.Modulus10);
        getHandler(div).setモジュラス１０(icheckgigit);
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnSearch(TokubetsuKyufuJigyoshaKannriDiv div) {
        RString 県コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getDdlSearchKenCode().getSelectedKey();
        RString 事業者区分 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchJigyoshaKubun().getText();
        RString 郡市コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchGunshiCode().getText();
        RString 連番 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchRenban().getText();
        RString cd = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchCheckDigit().getText();
        JigyoshaNo 事業者番号 = new JigyoshaNo(県コード.concat(事業者区分).concat(郡市コード).concat(連番).concat(cd));
        List<TokubetsuKyufuJigyoshaSearchResult> businessList = TokubetsuKyufuJigyoshaRelateFinder.createInstance().select事業者情報(事業者番号).records();
        if (businessList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象者が存在しない.getMessage());
        } else {
            ArrayList<ShichosonTokubetsuKyufuJigyosha> 市町村特別給付サービス事業者一覧 = new ArrayList<>();
            ArrayList<ShichosonTokubetsuKyufuJigyoshaViewState> viewStateList = new ArrayList<>();
            getHandler(div).setサービス事業者一覧(businessList, 市町村特別給付サービス事業者一覧, viewStateList);
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者List, 市町村特別給付サービス事業者一覧);
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者ListViewState, viewStateList);
        }
        return ResponseData.of(div).setState(DBC2210011StateName.一覧);
    }

    /**
     * 「事業者情報を追加する」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnJigyoshaAdd(TokubetsuKyufuJigyoshaKannriDiv div) {
        ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者ViewState, null);
        getHandler(div).set項目クリア();
        getHandler(div).set事業者コード();
        getHandler(div).set追加ボタンを押した状態制御();
        return ResponseData.of(div).setState(DBC2210011StateName.詳細情報);
    }

    /**
     * 「サービス事業者一覧DataGrid.選択」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnSelect(TokubetsuKyufuJigyoshaKannriDiv div) {
        dgTokubetsuKyufuJigyoshaList_Row 選択row = div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().getActiveRow();
        List<ShichosonTokubetsuKyufuJigyosha> 市町村特別給付サービス事業者一覧 = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者List, ArrayList.class);
        ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者 = getHandler(div).get市町村特別給付サービス事業者情報(選択row, 市町村特別給付サービス事業者一覧);
        if (市町村特別給付サービス事業者 != null) {
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者の情報, 市町村特別給付サービス事業者);
        }
        List<ShichosonTokubetsuKyufuJigyoshaViewState> viewStateList = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者ListViewState, ArrayList.class);
        ShichosonTokubetsuKyufuJigyoshaViewState 市町村特別給付サービス事業者ViewState = getHandler(div).get該当申請のViewState(選択row, viewStateList);
        if (市町村特別給付サービス事業者ViewState != null) {
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者ViewState, 市町村特別給付サービス事業者ViewState);
        }
        ShichosonTokubetsuKyufuJigyoshaViewState joho = ViewStateHolder.get(
                ViewStateKeys.市町村特別給付サービス事業者ViewState, ShichosonTokubetsuKyufuJigyoshaViewState.class);
        if (joho != null) {
            市町村特別給付サービス事業者 = joho.get市町村特別給付サービス事業者情報();
        }
        getHandler(div).set項目クリア();
        getHandler(div).set選択項目1_5(選択row, 市町村特別給付サービス事業者);
        getHandler(div).set選択ボタンを押した状態制御();
        return ResponseData.of(div).setState(DBC2210011StateName.詳細情報);
    }

    /**
     * 「サービス事業者一覧DataGrid.修正」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnModify(TokubetsuKyufuJigyoshaKannriDiv div) {
        ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者ViewState, null);
        dgTokubetsuKyufuJigyoshaList_Row 選択row = div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().getActiveRow();
        List<ShichosonTokubetsuKyufuJigyosha> 市町村特別給付サービス事業者一覧 = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者List, ArrayList.class);
        ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者 = getHandler(div).get市町村特別給付サービス事業者情報(選択row, 市町村特別給付サービス事業者一覧);
        if (市町村特別給付サービス事業者 != null) {
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者の情報, 市町村特別給付サービス事業者);
        }
        List<ShichosonTokubetsuKyufuJigyoshaViewState> viewStateList = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者ListViewState, ArrayList.class);
        ShichosonTokubetsuKyufuJigyoshaViewState 市町村特別給付サービス事業者ViewState = getHandler(div).get該当申請のViewState(選択row, viewStateList);
        if (市町村特別給付サービス事業者ViewState != null) {
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者ViewState, 市町村特別給付サービス事業者ViewState);
        }
        ShichosonTokubetsuKyufuJigyoshaViewState joho = ViewStateHolder.get(
                ViewStateKeys.市町村特別給付サービス事業者ViewState, ShichosonTokubetsuKyufuJigyoshaViewState.class);
        if (joho != null) {
            市町村特別給付サービス事業者 = joho.get市町村特別給付サービス事業者情報();
        }
        getHandler(div).set項目クリア();
        getHandler(div).set選択項目1_5(選択row, 市町村特別給付サービス事業者);
        getHandler(div).set修正ボタンを押した状態制御();
        return ResponseData.of(div).setState(DBC2210011StateName.詳細情報);
    }

    /**
     * 「サービス事業者一覧DataGrid.削除」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnDelete(TokubetsuKyufuJigyoshaKannriDiv div) {
        dgTokubetsuKyufuJigyoshaList_Row 選択row = div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().getActiveRow();
        List<ShichosonTokubetsuKyufuJigyosha> 市町村特別給付サービス事業者一覧 = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者List, ArrayList.class);
        ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者 = getHandler(div).get市町村特別給付サービス事業者情報(選択row, 市町村特別給付サービス事業者一覧);
        if (市町村特別給付サービス事業者 != null) {
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者の情報, 市町村特別給付サービス事業者);
        }
        List<ShichosonTokubetsuKyufuJigyoshaViewState> viewStateList = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者ListViewState, ArrayList.class);
        ShichosonTokubetsuKyufuJigyoshaViewState 市町村特別給付サービス事業者ViewState = getHandler(div).get該当申請のViewState(選択row, viewStateList);
        if (市町村特別給付サービス事業者ViewState != null) {
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者ViewState, 市町村特別給付サービス事業者ViewState);
        }
        ShichosonTokubetsuKyufuJigyoshaViewState joho = ViewStateHolder.get(
                ViewStateKeys.市町村特別給付サービス事業者ViewState, ShichosonTokubetsuKyufuJigyoshaViewState.class);
        if (joho != null) {
            市町村特別給付サービス事業者 = joho.get市町村特別給付サービス事業者情報();
        }
        getHandler(div).set項目クリア();
        getHandler(div).set選択項目1_5(選択row, 市町村特別給付サービス事業者);
        getHandler(div).set選択ボタンを押した状態制御();
        return ResponseData.of(div).setState(DBC2210011StateName.詳細情報);
    }

    /**
     * 「事業者情報を確定する」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnSaveTemp(TokubetsuKyufuJigyoshaKannriDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確定の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.確定の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType().equals(MessageDialogSelectedResult.Yes)) {
            set確定す処理(div);
            return ResponseData.of(div).setState(DBC2210011StateName.一覧);
        }
        return ResponseData.of(div).respond();
    }

    private void set確定す処理(TokubetsuKyufuJigyoshaKannriDiv div) {
        ShichosonTokubetsuKyufuJigyoshaViewState 編集情報
                = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者ViewState, ShichosonTokubetsuKyufuJigyoshaViewState.class);
        Integer 追加履歴番号 = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス追加履歴番号, Integer.class);
        if (null == 追加履歴番号 || 追加履歴番号 == 0) {
            追加履歴番号 = -1;
        }
        ShichosonTokubetsuKyufuJigyoshaViewState 最初情報 = null;
        if (編集情報 != null) {
            最初情報 = get最初情報(編集情報);
        }
        List<ShichosonTokubetsuKyufuJigyoshaViewState> viewStateList = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者ListViewState, ArrayList.class);
        getHandler(div).onClick_btnSaveTemp(viewStateList, 編集情報, 追加履歴番号, 最初情報);
//        ArrayList<ShichosonTokubetsuKyufuJigyoshaViewState> viewStateList = ViewStateHolder.get(
//                ViewStateKeys.市町村特別給付サービス事業者ListViewState, ArrayList.class);
//        if (viewStateList == null) {
//            viewStateList = new ArrayList<>();
//        }
//        ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者の情報 = ViewStateHolder.get(
//                ViewStateKeys.市町村特別給付サービス事業者の情報, ShichosonTokubetsuKyufuJigyosha.class);
//        ShichosonTokubetsuKyufuJigyoshaViewState 特別地域加算減免ViewState = ViewStateHolder.get(
//                ViewStateKeys.市町村特別給付サービス事業者ViewState, ShichosonTokubetsuKyufuJigyoshaViewState.class);
//        JigyoshaNo 市町村特別給付用事業者番号;
//        ServiceCode 市町村特別給付用サービスコード;
//        int 履歴番号;
//        EntityDataState state;
//        ShichosonTokubetsuKyufuJigyoshaBuilder builder;
//        if (市町村特別給付サービス事業者の情報 != null) {
//            市町村特別給付用事業者番号 = 市町村特別給付サービス事業者の情報.get市町村特別給付用事業者番号();
//            市町村特別給付用サービスコード = 市町村特別給付サービス事業者の情報.get市町村特別給付用サービスコード();
//            履歴番号 = 市町村特別給付サービス事業者の情報.get履歴番号();
//            boolean 変更あり = getHandler(div).情報変更あり(市町村特別給付サービス事業者の情報);
//            if (変更あり) {
//                state = EntityDataState.Modified;
//            } else {
//                state = EntityDataState.Unchanged;
//            }
//            builder = 市町村特別給付サービス事業者の情報.createBuilderForEdit();
//        } else {
//            state = EntityDataState.Added;
//            RString 県コード = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getDdlKenCode().getSelectedKey();
//            RString 事業者区分 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtJigyoshaKubun().getText();
//            RString 郡市コード = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtGunshiCode().getText();
//            RString 連番 = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtRenban().getText();
//            RString cd = div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailCode().getTxtCheckDigit().getText();
//            市町村特別給付用事業者番号 = new JigyoshaNo(県コード.concat(事業者区分).concat(郡市コード).concat(連番).concat(cd));
//
//        }

    }

    private ShichosonTokubetsuKyufuJigyoshaViewState get最初情報(ShichosonTokubetsuKyufuJigyoshaViewState 編集情報) {
        ShichosonTokubetsuKyufuJigyoshaIdentifier id = 編集情報.get市町村特別給付サービス事業者情報().identifier();
        ArrayList<ShichosonTokubetsuKyufuJigyosha> 最初申請一覧情報 = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者List, ArrayList.class);
        for (ShichosonTokubetsuKyufuJigyosha 最初情報 : 最初申請一覧情報) {
            if (id.equals(最初情報.identifier())) {
                return new ShichosonTokubetsuKyufuJigyoshaViewState(最初情報, RString.EMPTY, 編集情報.getRirekiNo());
            }
        }
        return 編集情報;
    }

    private TokubetsuKyufuJigyoshaKannriHandler getHandler(TokubetsuKyufuJigyoshaKannriDiv div) {
        return new TokubetsuKyufuJigyoshaKannriHandler(div);
    }

}
