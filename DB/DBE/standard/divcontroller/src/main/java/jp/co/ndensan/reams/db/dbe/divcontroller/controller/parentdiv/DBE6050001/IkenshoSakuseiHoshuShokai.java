/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6050001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.ikenshohoshushokai.IkenHoshuIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshohoshushokai.IkenshoHoshuShokaiMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6050001.IkenshoSakuseiHoshuShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6050001.IkenshoSakuseiHoshuShokaiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6050001.IkenshoSakuseiHoshuShokaiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshohoshushokai.IkenshoHoshuShokaiFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 意見書作成報酬照会の処理詳細です。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
public class IkenshoSakuseiHoshuShokai {

    private static final RString CSVを出力する = new RString("1");
    private static final RString 一覧表を発行する = new RString("2");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoSakuseiHoshuShokaiDiv>
     */
    public ResponseData<IkenshoSakuseiHoshuShokaiDiv> onLoad(IkenshoSakuseiHoshuShokaiDiv div) {
        getHandler(div).clear作成依頼日();
        getHandler(div).set初期最大取得件数();
        getHandler(div).set初期状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件をクリアする」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoSakuseiHoshuShokaiDiv>
     */
    public ResponseData<IkenshoSakuseiHoshuShokaiDiv> onClick_BtnKensakuClear(IkenshoSakuseiHoshuShokaiDiv div) {
        getHandler(div).clear作成依頼日();
        getHandler(div).set初期最大取得件数();
        getHandler(div).set初期状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoSakuseiHoshuShokaiDiv>
     */
    public ResponseData<IkenshoSakuseiHoshuShokaiDiv> onClick_BtnKensaku(IkenshoSakuseiHoshuShokaiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForIraishoSakuseiIraiYMD();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        FlexibleDate 作成依頼日開始 = FlexibleDate.EMPTY;
        FlexibleDate 作成依頼日終了 = FlexibleDate.EMPTY;
        if (div.getTxtSakuseiIraibi().getFromValue() != null) {
            作成依頼日開始 = new FlexibleDate(div.getTxtSakuseiIraibi().getFromValue().toDateString());
        }
        if (div.getTxtSakuseiIraibi().getToValue() != null) {
            作成依頼日終了 = new FlexibleDate(div.getTxtSakuseiIraibi().getToValue().toDateString());
        }
        IkenshoHoshuShokaiMapperParameter paramter = IkenshoHoshuShokaiMapperParameter.createSelectBy情報(作成依頼日開始,
                作成依頼日終了, div.getTxtMaxKensu().getValue().intValue());
        getHandler(div).set一覧結果(IkenshoHoshuShokaiFinder.createInstance().select合計額リスト(paramter).records());
        getHandler(div).set一覧状態();
        if (div.getDgIkenshoSakuseiHoshu().getDataSource().isEmpty()) {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnPulish"), false);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnShutsutyoku"), false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件に戻る」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoSakuseiHoshuShokaiDiv>
     */
    public ResponseData<IkenshoSakuseiHoshuShokaiDiv> onClick_BtnModoru(IkenshoSakuseiHoshuShokaiDiv div) {
        getHandler(div).set初期状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「CSVを出力する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoHoshuShokaiIchiranBatchParameter>
     */
    public ResponseData<IkenHoshuIchiranBatchParameter> onClick_BtnShutsutyoku(IkenshoSakuseiHoshuShokaiDiv div) {
        IkenHoshuIchiranBatchParameter parameter = getHandler(div).createBatchParam(CSVを出力する);
        return ResponseData.of(parameter).respond();
    }

    /**
     * 「一覧表を発行する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<IkenshoHoshuShokaiIchiranBatchParameter>
     */
    public ResponseData<IkenHoshuIchiranBatchParameter> onClick_BtnPulish(IkenshoSakuseiHoshuShokaiDiv div) {
        IkenHoshuIchiranBatchParameter parameter = getHandler(div).createBatchParam(一覧表を発行する);
        return ResponseData.of(parameter).respond();
    }

    private IkenshoSakuseiHoshuShokaiHandler getHandler(IkenshoSakuseiHoshuShokaiDiv div) {
        return new IkenshoSakuseiHoshuShokaiHandler(div);
    }

    private IkenshoSakuseiHoshuShokaiValidationHandler getValidationHandler(IkenshoSakuseiHoshuShokaiDiv div) {
        return new IkenshoSakuseiHoshuShokaiValidationHandler(div);
    }
}
