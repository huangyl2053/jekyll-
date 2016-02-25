/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0210011;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210011.TsukibetsuSuiihyoSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0210011.TsukibetsuSuiihyoSakuseiHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 月別推移表Divのコントローラです。
 */
public class TsukibetsuSuiihyoSakusei {

    private static final int 年齢_65 = 65;

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TsukibetsuSuiihyoSakuseiDiv> onLoad(TsukibetsuSuiihyoSakuseiDiv div) {
        getHandler(div).onload();
        return ResponseData.of(div).respond();
    }

    /**
     * 月別推移表作成を「実行する」を押下チェックする。<br/>
     *
     * @param div
     * {@link KobetsuJikoRenkeiInfoSakuseiDiv 介護住民票個別事項連携情報作成【他社住基】情報Div}
     * @return 介護住民票個別事項連携情報作成【他社住基】情報Divを持つResponseData
     */
    public ResponseData<TsukibetsuSuiihyoSakuseiDiv> onClick_btnJikkouBefore(TsukibetsuSuiihyoSakuseiDiv div) {
        Decimal ageStart = div.getTxtNenreiSt().getValue();
        Decimal ageEnd = div.getTxtNenreiEd().getValue();
        RDate 年齢基準日 = div.getTxtNenreiKijunYMD().getValue();
        RDate 生年月日F = div.getTxtUmareSt().getValue();
        RDate 生年月日E = div.getTxtUmareEd().getValue();
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getRadNenrei().getSelectedKey() != null && !div.getRadNenrei().getSelectedKey().isEmpty()
                && ageStart.intValue() <= 年齢_65) {
            validationMessages.add(getHandler(div).年齢65歳未満チェック());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (div.getRadNenrei().getSelectedKey() != null && !div.getRadNenrei().getSelectedKey().isEmpty()
                && ageStart != null && ageEnd != null && 年齢基準日 == null) {
            throw new ApplicationException(UrWarningMessages.未入力.getMessage().replace("年齢基準日"));
        }
        if (div.getRadNenrei().getSelectedKey() != null && !div.getRadNenrei().getSelectedKey().isEmpty()
                && ageStart != null && ageEnd != null && ageStart.compareTo(ageEnd) > 0) {
            validationMessages.add(getHandler(div).抽出開始年齢大小不整合チェック());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        if (div.getRadUmareYMD().getSelectedKey() != null && !div.getRadUmareYMD().getSelectedKey().isEmpty()
                && 生年月日F != null && 生年月日E != null && 生年月日E.isBefore(生年月日F)) {
            validationMessages.add(getHandler(div).抽出開始生年月日大小不整合チェック());
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン押下時の処理です。<br/>
     *
     * @param div {@link TsukibetsuSuiihyoSakuseiDiv  資格得喪履歴Div}
     * @return 月別推移表作成Divを持つResponseData
     */
    public ResponseData onClick_btnJikou(TsukibetsuSuiihyoSakuseiDiv div) {
        ResponseData<CreateTsukibetsuSuiihyoBatchParameter> response = new ResponseData<>();
        response.data = getHandler(div).batchParameter(div);
        return response;
    }

    private TsukibetsuSuiihyoSakuseiHandler getHandler(TsukibetsuSuiihyoSakuseiDiv div) {
        return new TsukibetsuSuiihyoSakuseiHandler(div);
    }
}
