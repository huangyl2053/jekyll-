/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5510001;

import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteishinchokujohoshokai.HihokenshaJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteishinchokujohoshokai.YokaigoNinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.business.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteishinchokujohoshokai.YokaigoNinteiParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001.YokaigoNinteiShinchokuJohoShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5510001.YokaigoNinteiShinchokuJohoShokaiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5510001.YokaigoNinteiShinchokuJohoShokaiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteishinchokujohoshokai.YokaigoNinteiShinchokuJohoShokaiFinder;
import jp.co.ndensan.reams.db.dbe.service.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteiShinseiJohoManager;

/**
 *
 * 要介護認定進捗状況照会クラスです。
 *
 * @reamsid_L DBE-0210-010 dongyabin
 */
public class YokaigoNinteiShinchokuJohoShokai {
    
    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> onload(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        getHandler(div).onload();
        return ResponseData.of(div).respond();
    }

    /**
     * onActive処理です。
     *
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> onActive(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        getHandler(div).set検索条件切替(false);
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
        NinteiShinseiJoho ninteiShinseiJoho = null;
        NinteiShinseiJohoManager shinseiJohoManager;
        shinseiJohoManager = NinteiShinseiJohoManager.createInstance();
        if (申請書管理番号 != null && !申請書管理番号.isEmpty()) {
            ninteiShinseiJoho = shinseiJohoManager.get要介護認定申請情報(new ShinseishoKanriNo(申請書管理番号));
        }
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getTxtHihokenshaNo().setValue(被保険者番号);
        }
        if (ninteiShinseiJoho != null) {
            div.getTxtShimei().setDomain(ninteiShinseiJoho.get被保険者氏名());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onBlur_txtHihokenshaNo処理。
     *
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> onBlur_txtHihokenshaNo(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        div.getTxtShimei().clearDomain();
        HihokenshaJohoBusiness hihokenshaJohoBusiness = YokaigoNinteiShinchokuJohoShokaiFinder
                .createInstance().select被保険者情報(div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().getColumnValue(), div.getTxtHihokenshaNo().getValue());
        if (hihokenshaJohoBusiness != null && !hihokenshaJohoBusiness.get被保険者氏名().isEmpty()) {
            div.getTxtShimei().setDomain(hihokenshaJohoBusiness.get被保険者氏名());
        }
        return ResponseData.of(div).respond();
    }
    
        /**
     * onClick_btnHihokenshaKensaku処理。
     *
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> onClick_btnHihokenshaKensaku(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        ViewStateHolder.put(ViewStateKeys.証記載保険者番号, div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号());
        return ResponseData.of(div).respond();
    }

    /**
     * 検索する場合、選択変更します。
     *
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> radKensakuHohoChange(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        getHandler(div).radKensakuHohoChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 日付範囲、選択変更します。
     *
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> radHizukeHaniChange(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        getHandler(div).radHizukeHaniChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件をクリアするボタン押下します。
     *
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> btnConditionClear(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        getHandler(div).btnConditionClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタン押下します。
     *
     * @param div 画面情報
     * @return {@code ResponseData}
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> btnKensaku(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs;
        pairs = getValidationHandler(div).被保険者番号必須チェック();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        pairs = getValidationHandler(div).日付チェック();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        SearchResult<YokaigoNinteiShinchokuJoho> searchResult = YokaigoNinteiShinchokuJohoShokaiFinder
                .createInstance().selectItirannJoho(get検索パラメータ(div));
        getHandler(div).btnKensaku(searchResult);
        if (searchResult.records().isEmpty()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        div.getShinseiJohoIchiran().setIsOpen(true);
        return ResponseData.of(div).respond();
    }
    
    /**
     * 「再検索する」ボタン押下します。
     *
     * @param div 画面情報
     * @return {@code ResponseData}
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> btnReSearch(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        getHandler(div).set検索条件切替(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」ボタン押下します。
     *
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
        public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> onClick_Select(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, div.getDgShinseiJoho().
                getClickedItem().getShinseishoKanriNo());
        ViewStateHolder.put(ViewStateKeys.認定調査履歴番号, div.getDgShinseiJoho().
                getClickedItem().getNinteichosaIraiRirekiNo().toInt());
        return ResponseData.of(div).respond();
    }

    /**
     * 「進捗状況一覧表を発行する」ボタン押下の場合、入力チェック実行します。
     *
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> btnPrintCheck(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        if (!ResponseHolder.isReRequest() && div.getDgShinseiJoho().getDataSource().isEmpty()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 進捗状況一覧表を発行する」ボタン押下の場合、帳票を印刷します。
     *
     * @param div 画面情報
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> btnPrint(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        return ResponseData.of(new NiteiGyomuShinchokuJokyoIchiranhyoPrintService().print(ceratePrint(div))).respond();
    }

    /**
     * 進捗状況一覧表を発行する」ボタン押下の場合、完了メッセージの表示します。
     *
     * @param div 画面情報
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> btnPrintAfter(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        return ResponseData.of(div).respond();
    }
    
    private YokaigoNinteiParamter get検索パラメータ(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        return YokaigoNinteiParamter.createParamter(
                div.getCcdHokenshaList().getSelectedItem().get市町村コード().getColumnValue(),
                div.getRadKensakuHoho().getSelectedKey(),
                div.getTxtShiteiHizukeRange().getFromValue() == null ? RString.EMPTY : div.getTxtShiteiHizukeRange().getFromValue().toDateString(),
                div.getTxtShiteiHizukeRange().getToValue() == null ? RString.EMPTY : div.getTxtShiteiHizukeRange().getToValue().toDateString(),
                div.getTxtHihokenshaNo().getValue() == null ? RString.EMPTY : div.getTxtHihokenshaNo().getValue(),
                div.getTxtShikibetsuCode().getValue() == null ? RString.EMPTY : div.getTxtShikibetsuCode().getValue(),
                div.getTxtShimei().getDomain().getColumnValue() == null ? RString.EMPTY : div.getTxtShimei().getDomain().getColumnValue(),
                div.getRadHizukeHani().getSelectedKey(),
                div.getChkNinteiChosaIrai().getSelectedKeys(),
                div.getChkNinteiChosaJisshi().getSelectedKeys(),
                div.getChkNinteiChosaTokki().getSelectedKeys(),
                div.getChkShujiiIkenshoIrai().getSelectedKeys(),
                div.getChkShujiiIkenshoJuryo().getSelectedKeys(),
                div.getChkIchijiHanteiKanryo().getSelectedKeys(),
                div.getChkMaskingKanryo().getSelectedKeys(),
                div.getChkShinsakaiWaritsuke().getSelectedKeys(),
                div.getChkShinsakaiJisshi().getSelectedKeys(),
                div.getChkKensakuOption().getSelectedKeys(),
                div.getTxtMaximumDisplayNumber().getValue().intValue());
    }

    private NiteiGyomuShinchokuJokyoIchiranhyoJoho ceratePrint(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        return new NiteiGyomuShinchokuJokyoIchiranhyoJoho(getHandler(div).createBodyItem());
    }

    private YokaigoNinteiShinchokuJohoShokaiHandler getHandler(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        return new YokaigoNinteiShinchokuJohoShokaiHandler(div);
    }
    
    private YokaigoNinteiShinchokuJohoShokaiValidationHandler getValidationHandler(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        return new YokaigoNinteiShinchokuJohoShokaiValidationHandler(div);
    }

}
