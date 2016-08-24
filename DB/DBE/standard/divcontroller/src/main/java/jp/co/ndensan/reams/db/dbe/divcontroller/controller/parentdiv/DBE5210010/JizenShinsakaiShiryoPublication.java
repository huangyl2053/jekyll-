/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5210010;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jizenshinsakaishiryopublication.JizenShinsakaiShiryoPublicationBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE526002.DBE526002_JIzenShinsakekkaTorokuSakuseiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210010.JizenShinsakaiShiryoPublicationDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210010.JizenShinsakaiShiryoPublicationHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210010.JizenShinsakaiShiryoPublicationValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.jizenshinsakaishiryopublication.JizenShinsakaiShiryoPublicationManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 介護認定審査会委員事前審査 のコントローラです。
 *
 * @reamsid_L DBE-1630-010 dangjingjing
 */
public class JizenShinsakaiShiryoPublication {

    /**
     * 画面初期化処理です。
     *
     * @param div JizenShinsakaiShiryoPublicationDiv
     * @return ResponseData<JizenShinsakaiShiryoPublicationDiv>
     */
    public ResponseData<JizenShinsakaiShiryoPublicationDiv> onLoad(JizenShinsakaiShiryoPublicationDiv div) {
        RString 審査会開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        JizenShinsakaiShiryoPublicationBusiness 対象審査会情報
                = JizenShinsakaiShiryoPublicationManager.creatInstance().get審査会開催番号(審査会開催番号);
        getHandler(div).onLoad(対象審査会情報, 審査会開催番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 印刷審査会資料選択チェックボックスの使用可能・不可能を設定する。
     *
     * @param div JizenShinsakaiShiryoPublicationDiv
     * @return ResponseData<JizenShinsakaiShiryoPublicationDiv>
     */
    public ResponseData<JizenShinsakaiShiryoPublicationDiv> onClick_chkPrintChohyoIin(JizenShinsakaiShiryoPublicationDiv div) {
        getHandler(div).set審査会資料選択chkの設定();
        return ResponseData.of(div).respond();
    }

    /**
     * 「指定条件で実行する」ボタン。
     *
     * @param div JizenShinsakaiShiryoPublicationDiv
     * @return ResponseData<JizenShinsakaiShiryoPublicationDiv>
     */
    public ResponseData<JizenShinsakaiShiryoPublicationDiv> onClick_btnCriteria(JizenShinsakaiShiryoPublicationDiv div) {
        Decimal ゼロ = new Decimal("0");
        Decimal 部数 = div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getTxtCopyNumForShinsakaiIin1().getValue();
        List<RString> 印刷帳票未選択 = div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin().getSelectedKeys();
        if (部数.equals(ゼロ)) {
            return ResponseData.of(div).addValidationMessages(getValidationHandlerHandler().check入力値が不正()).respond();
        }
        if (印刷帳票未選択 == null || 印刷帳票未選択.isEmpty()) {
            return ResponseData.of(div).addValidationMessages(getValidationHandlerHandler().check選択され()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 帳票の出力処理を実施する。
     *
     * @param div JizenShinsakaiShiryoPublicationDiv
     * @return ResponseData<DBE526002_JIzenShinsakekkaTorokuSakuseiParameter>
     */
    public ResponseData<DBE526002_JIzenShinsakekkaTorokuSakuseiParameter> onClick_btnParameter(JizenShinsakaiShiryoPublicationDiv div) {
        return ResponseData.of(getHandler(div).setバッチパラメータの設定()).respond();
    }

    private JizenShinsakaiShiryoPublicationHandler getHandler(JizenShinsakaiShiryoPublicationDiv div) {
        return new JizenShinsakaiShiryoPublicationHandler(div);
    }

    private JizenShinsakaiShiryoPublicationValidationHandler getValidationHandlerHandler() {
        return new JizenShinsakaiShiryoPublicationValidationHandler();
    }
}
