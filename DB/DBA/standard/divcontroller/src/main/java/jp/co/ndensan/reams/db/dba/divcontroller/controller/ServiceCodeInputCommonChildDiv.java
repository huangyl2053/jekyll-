/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDivDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDivHandler;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyouManager;
import jp.co.ndensan.reams.db.dbx.definition.mybatis.param.servicecode.SabisuKodoParameter;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * サービスコードのフォーカスアウトです。
 */
public class ServiceCodeInputCommonChildDiv {
    
    private static final int INDEX_6 = 6;
    
    private final KaigoServiceNaiyouManager service;

    /**
     * コンストラクタです。
     */
    public ServiceCodeInputCommonChildDiv() {
        service = KaigoServiceNaiyouManager.createInstance();
    }
    
    
     /**
     * 「サービスコードのフォーカスアウト」ボタンをクリックの設定します。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<ServiceCodeInputCommonChildDivDiv> focusOut(ServiceCodeInputCommonChildDivDiv div) {
        if (div.getTxtServiceCode1().getValue().isEmpty()
                || div.getTxtServiceCode2().getValue().isEmpty()) {
            return ResponseData.of(div).respond();
        }
        SabisuKodoParameter param  = SabisuKodoParameter.createSearchParam(
                div.getTxtServiceCode1().getValue(),
                div.getTxtServiceCode2().getValue(), new FlexibleYearMonth(RDate.getNowDate().toString().substring(0, INDEX_6)));
        List<KaigoServiceNaiyou> focusServiceCodeList = service.getFouceServiceCodeList(param);
        getHandler(div).initialize(focusServiceCodeList);
        return ResponseData.of(div).respond();
    }
    
    /**
     * 「検索」ボタンをクリック場合、サービスコード検索一覧ダイアログ画面が表示します。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<ServiceCodeInputCommonChildDivDiv> onBeforeOpenDialog_btnSearch(ServiceCodeInputCommonChildDivDiv div) {
        getHandler(div).onBeforeOpenDialog_btnSearch();
        return ResponseData.of(div).respond();
    }
    
    /**
     * 「検索」ボタンをクリック場合、サービスコード検索一覧ダイアログ画面が表示します。
     *
     * @param div ServiceCodeCommonChildDivDiv
     * @return ResponseData<ServiceCodeCommonChildDivDiv>
     */
    public ResponseData<ServiceCodeInputCommonChildDivDiv> onOkClose_btnSearch(ServiceCodeInputCommonChildDivDiv div) {
        getHandler(div).onOkClose_btnSearch();
        return ResponseData.of(div).respond();
    }
    
    private ServiceCodeInputCommonChildDivHandler getHandler(ServiceCodeInputCommonChildDivDiv div) {
        return new ServiceCodeInputCommonChildDivHandler(div);
    }
    
}
