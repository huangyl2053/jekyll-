/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.chosaitakusakiandchosaininput;

import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel.HyojiMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideDiv.TaishoMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputValidationHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 共有子Div「調査委託先/調査員入力」のDivControllerです。
 *
 * @reamsid_L DBZ-1300-030 zhangguopeng
 */
public class ChosaItakusakiAndChosainInput {

    /**
     * 入力された調査委託先コードより、調査委託先名称を取得します。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return 調査委託先投票区名称
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onBlur_TxtChosaItakusakiCode(ChosaItakusakiAndChosainInputDiv div) {
        getHandler(div).onBlurTxtChosaItakusakiCode();
        ValidationMessageControlPairs validationResult = getValidationHandler(div).validate調査委託先コード();
        if (validationResult.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationResult).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 共有子Div上で入力された調査員コードから調査員名称を取得します。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return 調査員名称
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onBlur_TxtChosainCode(ChosaItakusakiAndChosainInputDiv div) {
        getHandler(div).onBlurTxtChosainCode();
        ValidationMessageControlPairs validationResult = getValidationHandler(div).validate調査員コード();
        if (validationResult.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationResult).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 共有子Div上で前回(委託先情報)を複写するボタンを押下すると前回(委託先情報)を取得します。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return 前回(委託先情報)
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onClick_BtnZenkaiFukusha(ChosaItakusakiAndChosainInputDiv div) {
        getHandler(div).onClickBtnZenkaiFukusha();
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnClearボタンを押下した際に動作するメソッドです。<br/>
     * 共有子Div内の項目に設定された値をすべてクリアします。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onClick_BtnClear(ChosaItakusakiAndChosainInputDiv div) {
        getHandler(div).onClick_BtnClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先ガイドボタンを押下した際に動作するメソッドです。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onClick_BtnChosaItakusakiGuide(ChosaItakusakiAndChosainInputDiv div) {
        KijuntsukiShichosonjohoiDataPassModel modle = new KijuntsukiShichosonjohoiDataPassModel();
        modle.set市町村コード(div.getHdnShichosonCode());
        modle.set対象モード(new RString(TaishoMode.Itakusaki.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(modle));
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先/調査員ガイドDivに選択ボタンを押下した際に動作するメソッドです。（委託先対象モード）
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onOKClose_BtnChosaItakusakiGuide(ChosaItakusakiAndChosainInputDiv div) {
        KijuntsukiShichosonjohoiDataPassModel modle = DataPassingConverter.deserialize(div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        div.getTxtChosaItakusakiCode().setValue(modle.get委託先コード());
        div.getTxtChosaItakusakiName().setValue(modle.get委託先名());
        return ResponseData.of(div).respond();
    }

    /**
     * 調査員ガイドボタンを押下した際に動作するメソッドです。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onClick_BtnChosainGuide(ChosaItakusakiAndChosainInputDiv div) {
        KijuntsukiShichosonjohoiDataPassModel modle = new KijuntsukiShichosonjohoiDataPassModel();
        modle.set市町村コード(div.getHdnShichosonCode());
        modle.set委託先コード(div.getTxtChosaItakusakiCode().getValue());
        modle.set委託先名(div.getTxtChosaItakusakiName().getValue());
        modle.set対象モード(new RString(TaishoMode.Chosain.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(modle));
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先/調査員ガイドDivに選択ボタンを押下した際に動作するメソッドです。（調査員対象モード）
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return レスポンス
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onOKClose_BtnChosainGuide(ChosaItakusakiAndChosainInputDiv div) {
        KijuntsukiShichosonjohoiDataPassModel modle = DataPassingConverter.deserialize(div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        div.getTxtChosaItakusakiCode().setValue(modle.get委託先コード());
        div.getTxtChosaItakusakiName().setValue(modle.get委託先名());
        div.getTxtChosainCode().setValue(modle.get調査員コード());
        div.getTxtChosainName().setValue(modle.get調査員名());
        return ResponseData.of(div).respond();
    }

    /**
     * 調査員への連絡事項のデータを設定します。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return ResponseData<ChosaItakusakiAndChosainInputDiv>
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onBefore_btnChosainRenrakuJiko(ChosaItakusakiAndChosainInputDiv div) {
        NinteiShinseiCodeModel ninteiShinseiCodeModel = new NinteiShinseiCodeModel();
        if (!RString.isNullOrEmpty(div.getHdnChosainRenrakuJiko())) {
            ninteiShinseiCodeModel.set連絡事項(div.getHdnChosainRenrakuJiko());
        }
        ninteiShinseiCodeModel.set表示モード(HyojiMode.InputMode);
        ninteiShinseiCodeModel.setメニューID(new RString("ChosaItakusakiAndChosainInput"));
        ViewStateHolder.put(ViewStateKeys.モード, ninteiShinseiCodeModel);

        return ResponseData.of(div).respond();
    }

    /**
     * 調査員への連絡事項のデータを設定します。
     *
     * @param div 調査委託先/調査員入力共有子Div
     * @return ResponseData<ChosaItakusakiAndChosainInputDiv>
     */
    public ResponseData<ChosaItakusakiAndChosainInputDiv> onOKClose_btnChosainRenrakuJiko(ChosaItakusakiAndChosainInputDiv div) {
        NinteiShinseiCodeModel ninteiShinseiCodeModel = ViewStateHolder.get(ViewStateKeys.モード, NinteiShinseiCodeModel.class);
        div.setHdnChosainRenrakuJiko(ninteiShinseiCodeModel.get連絡事項());
        return ResponseData.of(div).respond();
    }

    private ChosaItakusakiAndChosainInputHandler getHandler(ChosaItakusakiAndChosainInputDiv div) {
        return new ChosaItakusakiAndChosainInputHandler(div);
    }

    private ChosaItakusakiAndChosainInputValidationHandler getValidationHandler(ChosaItakusakiAndChosainInputDiv div) {
        return new ChosaItakusakiAndChosainInputValidationHandler(div);
    }
}
