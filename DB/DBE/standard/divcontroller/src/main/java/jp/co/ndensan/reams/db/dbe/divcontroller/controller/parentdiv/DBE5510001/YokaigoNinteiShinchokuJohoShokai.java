/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5510001;

import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteishinchokujohoshokai.YokaigoNinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.business.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.yokaigoninteishinchokujohoshokai.YokaigoNinteiParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001.YokaigoNinteiShinchokuJohoShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5510001.YokaigoNinteiShinchokuJohoShokaiHandler;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteishinchokujohoshokai.YokaigoNinteiShinchokuJohoShokaiFinder;
import jp.co.ndensan.reams.db.dbe.service.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * 要介護認定進捗状況照会クラスです。
 */
public class YokaigoNinteiShinchokuJohoShokai {
    
    /**
     * 画面初期化処理です。
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> onload(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        getHandler(div).onload();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 検索する場合、選択変更します。
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> radKensakuHohoChange(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        getHandler(div).radKensakuHohoChange();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 日付範囲、選択変更します。
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> radHizukeHaniChange(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        getHandler(div).radHizukeHaniChange();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 条件をクリアするボタン押下します。
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> btnConditionClear(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        getHandler(div).btnConditionClear();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 「検索する」ボタン押下します。
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> btnKensaku(YokaigoNinteiShinchokuJohoShokaiDiv div) {
       
        SearchResult<YokaigoNinteiShinchokuJoho> serchResult = YokaigoNinteiShinchokuJohoShokaiFinder
                .createInstance().selectItirannJoho(get検索パラメータ(div));
        getHandler(div).btnKensaku(serchResult);
        return ResponseData.of(div).respond();
    }
    
    /**
     * 「照会」ボタン押下します。
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> btnShokai(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        ViewStateHolder.put(SaibanHanyokeyName.申請書整理番号, new ShinseishoKanriNo(div.getDgShinseiJoho().
                getActiveRow().getShinseishoKanriNo()));
        return ResponseData.of(div).respond();
    }
    
    /**
     * 「進捗状況一覧表を発行する」ボタン押下の場合、入力チェック実行します。
     * @param div 画面情報
     * @return ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv>
     */
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> btnPrintCheck(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        if (div.getDgShinseiJoho().getDataSource().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
        }
        return ResponseData.of(div).respond();
    }
    
    /**
     * 進捗状況一覧表を発行する」ボタン押下の場合、帳票を印刷します。
     * @param div 画面情報
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> btnPrint(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        return ResponseData.of(new NiteiGyomuShinchokuJokyoIchiranhyoPrintService().print(ceratePrint(div))).respond();
    }
    
    public ResponseData<YokaigoNinteiShinchokuJohoShokaiDiv> btnPrintAfter(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        throw new ApplicationException(UrInformationMessages.正常終了.getMessage().replace("進捗状況一覧印刷"));
    }
    
    private YokaigoNinteiParamter get検索パラメータ(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        return YokaigoNinteiParamter.createParamter(div.getCcdHokenshaList().getSelectedItem().get市町村コード().getColumnValue(),
                div.getRadMatchType().getSelectedKey(),
                div.getRadKensakuHoho().getSelectedKey(),
                div.getTxtShiteiHizukeForm().getValue() == null ? RString.EMPTY : div.getTxtShiteiHizukeForm().getValue().toDateString(),
                div.getTxtShiteiHizukeTo().getValue() == null ? RString.EMPTY : div.getTxtShiteiHizukeTo().getValue().toDateString(),
                div.getTxtHihokenshaNo().getValue() == null ? RString.EMPTY : div.getTxtHihokenshaNo().getValue(),
                div.getTxtShikibetsuCode().getValue() == null ? RString.EMPTY : div.getTxtShikibetsuCode().getValue(),
                div.getTxtShimei().getValue() == null ? RString.EMPTY : div.getTxtShimei().getValue(),
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
                div.getTxtMaximumDisplayNumber().getValue().isEmpty() ? -1 : Integer.parseInt(div
                        .getTxtMaximumDisplayNumber().getValue().toString()));
    }
    
    private NiteiGyomuShinchokuJokyoIchiranhyoJoho ceratePrint(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        return new NiteiGyomuShinchokuJokyoIchiranhyoJoho(getHandler(div).createBodyItem());
    }
    
    private YokaigoNinteiShinchokuJohoShokaiHandler getHandler(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        return new YokaigoNinteiShinchokuJohoShokaiHandler(div);
    }
    
}
