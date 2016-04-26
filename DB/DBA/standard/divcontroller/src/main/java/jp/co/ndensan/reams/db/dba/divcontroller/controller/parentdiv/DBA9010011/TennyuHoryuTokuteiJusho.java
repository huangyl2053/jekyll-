/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA9010011;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tennyuhoryutokuteijushoichiran.TennyuHoryuTokuteiBusiness;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA9010011.TennyuHoryuTokuteiJushoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA9010011.TennyuHoryuTokuteiHandler;
import jp.co.ndensan.reams.db.dba.service.core.tennyuhoryutokuteijushotoroku.TennyuHoryuTokuteiManager;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RendoHoryuTokuteiJusho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RendoHoryuTokuteiJushoIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 転入保留特定住所登録のクラスです。
 *
 * @reamsid_L DBA-0480-010 zhangzhiming
 */
public class TennyuHoryuTokuteiJusho {

    /**
     * 転入保留特定住所一覧初期化の設定します。<br/>
     *
     * @param requestDiv 転入保留特定住所一覧Div
     * @return ResponseData<TennyuHoryuTokuteiJushoDiv>
     */
    public ResponseData<TennyuHoryuTokuteiJushoDiv> onLoad(TennyuHoryuTokuteiJushoDiv requestDiv) {
        TennyuHoryuTokuteiManager manager = TennyuHoryuTokuteiManager.createInstance();
        List<TennyuHoryuTokuteiBusiness> businessList = manager.getTennyuHoryuTokuteiJushoIchiran().records();
        createHandlerOf(requestDiv).onLoad(businessList);
        List<RendoHoryuTokuteiJusho> 転入保留特定住所情報 = manager.get連動保留特定住所().records();
        Models<RendoHoryuTokuteiJushoIdentifier, RendoHoryuTokuteiJusho> rendoHoryuTokutei
                = Models.create(転入保留特定住所情報);
        ViewStateHolder.put(ViewStateKeys.転入保留特定住所一覧情報, rendoHoryuTokutei);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「転入保留特定住所を追加する」ボタンをクリックします。
     *
     * @param requestDiv 転入保留特定住所一覧Div
     * @return ResponseData<TennyuHoryuTokuteiJushoDiv>
     */
    public ResponseData<TennyuHoryuTokuteiJushoDiv> onClick_btnAdd(TennyuHoryuTokuteiJushoDiv requestDiv) {
        createHandlerOf(requestDiv).onClick_btnAdd();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「転入保留特定住所を確定する」ボタンをクリックします。
     *
     * @param requestDiv 転入保留特定住所一覧Div
     * @return ResponseData<TennyuHoryuTokuteiJushoDiv>
     */
    public ResponseData<TennyuHoryuTokuteiJushoDiv> onClick_btnKakutei(TennyuHoryuTokuteiJushoDiv requestDiv) {
        ValidationMessageControlPairs validationMessageControlPairs = createHandlerOf(requestDiv).detaCheck();
        if (validationMessageControlPairs.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(validationMessageControlPairs).respond();
        }
        createHandlerOf(requestDiv).onClick_btnKakutei();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「修正」ボタンをクリックします。
     *
     * @param requestDiv 転入保留特定住所一覧Div
     * @return ResponseData<TennyuHoryuTokuteiJushoDiv>
     */
    public ResponseData<TennyuHoryuTokuteiJushoDiv> onClick_btnModify(TennyuHoryuTokuteiJushoDiv requestDiv) {
        createHandlerOf(requestDiv).onClick_btnModify();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「削除」ボタンをクリックします。
     *
     * @param requestDiv 転入保留特定住所一覧Div
     * @return ResponseData<TennyuHoryuTokuteiJushoDiv>
     */
    public ResponseData<TennyuHoryuTokuteiJushoDiv> onClick_btnDelete(TennyuHoryuTokuteiJushoDiv requestDiv) {
        createHandlerOf(requestDiv).onClick_btnDelete();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 転入保留特定住所を保存するボタンします。<br/>
     *
     * @param requestDiv 転入保留特定住所一覧Div
     * @return ResponseData<TennyuHoryuTokuteiJushoDiv>
     */
    public ResponseData<TennyuHoryuTokuteiJushoDiv> onClick_SaveButton(TennyuHoryuTokuteiJushoDiv requestDiv) {
        createHandlerOf(requestDiv).onClick_SaveButton();
        onLoad(requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    private TennyuHoryuTokuteiHandler createHandlerOf(TennyuHoryuTokuteiJushoDiv requestDiv) {
        return new TennyuHoryuTokuteiHandler(requestDiv);
    }
}
