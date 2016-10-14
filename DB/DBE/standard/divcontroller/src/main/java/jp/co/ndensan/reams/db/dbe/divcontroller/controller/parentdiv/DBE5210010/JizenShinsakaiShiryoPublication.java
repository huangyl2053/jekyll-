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
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
        getHandler(div).set審査会資料選択chkの設定();
        RStringBuilder 前排他制御開催番号 = new RStringBuilder();
        前排他制御開催番号.append("DBEShinsakaiNo");
        前排他制御開催番号.append(審査会開催番号);
        前排他ロックキー(前排他制御開催番号.toRString());
        return ResponseData.of(div).respond();
    }

    /**
     * 出力スタイル_印刷サイズddl変更します。
     *
     * @param div JizenShinsakaiShiryoPublicationDiv
     * @return ResponseData<JizenShinsakaiShiryoPublicationDiv>
     */
    public ResponseData<JizenShinsakaiShiryoPublicationDiv> onChange_Ddl(JizenShinsakaiShiryoPublicationDiv div) {
        getHandler(div).set審査会資料選択chkの設定();
        return ResponseData.of(div).respond();
    }

    /**
     * 印刷審査会資料選択チェックボックスの使用可能・不可能を設定します。
     *
     * @param div JizenShinsakaiShiryoPublicationDiv
     * @return ResponseData<JizenShinsakaiShiryoPublicationDiv>
     */
    public ResponseData<JizenShinsakaiShiryoPublicationDiv> onClick_chkPrintChohyoIin(JizenShinsakaiShiryoPublicationDiv div) {
        getHandler(div).set審査会資料選択chkの設定();
        return ResponseData.of(div).respond();
    }

    /**
     * 「指定条件で実行する」を設定します。
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
     * 帳票の出力処理を実施です。
     *
     * @param div JizenShinsakaiShiryoPublicationDiv
     * @return ResponseData<DBE526002_JIzenShinsakekkaTorokuSakuseiParameter>
     */
    public ResponseData<DBE526002_JIzenShinsakekkaTorokuSakuseiParameter> onClick_btnParameter(JizenShinsakaiShiryoPublicationDiv div) {
        RString 審査会開催番号 = ViewStateHolder.get(ViewStateKeys.開催番号, RString.class);
        RStringBuilder 前排他制御開催番号 = new RStringBuilder();
        前排他制御開催番号.append("DBEShinsakaiNo");
        前排他制御開催番号.append(審査会開催番号);
        前排他キーの解除(前排他制御開催番号.toRString());
        return ResponseData.of(getHandler(div).setバッチパラメータの設定()).respond();
    }

    private JizenShinsakaiShiryoPublicationHandler getHandler(JizenShinsakaiShiryoPublicationDiv div) {
        return new JizenShinsakaiShiryoPublicationHandler(div);
    }

    private JizenShinsakaiShiryoPublicationValidationHandler getValidationHandlerHandler() {
        return new JizenShinsakaiShiryoPublicationValidationHandler();
    }

    private void 前排他ロックキー(RString 排他ロックキー) {
        LockingKey 前排他ロックキー = new LockingKey(排他ロックキー);
        if (!RealInitialLocker.tryGetLock(前排他ロックキー)) {
            throw new ApplicationException(UrErrorMessages.排他_他のユーザが使用中.getMessage());
        }
    }

    private void 前排他キーの解除(RString 排他) {
        LockingKey 排他キー = new LockingKey(排他);
        RealInitialLocker.release(排他キー);
    }
}
