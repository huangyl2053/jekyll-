/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDivDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildHandler;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.mybatis.param.kaigoserviceshurui.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiManager;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * サービス種類検索のコントローラです。
 *
 */
public class ServiceTypeInputCommonChildDiv {

    private final KaigoServiceShuruiManager service;

    /**
     * コンストラクタです。
     *
     */
    public ServiceTypeInputCommonChildDiv() {
        service = KaigoServiceShuruiManager.createInstance();

    }

    /**
     * サービス種類コードのフォーカスアウトの設定します。
     *
     * @param div ServiceTypeInputCommonChildDivDiv
     * @return ResponseData<ServiceTypeInputCommonChildDivDiv>
     */
    public ResponseData<ServiceTypeInputCommonChildDivDiv> onBlur_txtServiceType(ServiceTypeInputCommonChildDivDiv div) {
        if (div.getTxtServiceType().getValue().isEmpty()) {
            div.getTxtServiceTypeName().clearValue();
            return ResponseData.of(div).respond();
        }
        div.getTxtServiceTypeName().clearValue();
        KaigoServiceShuruiMapperParameter param = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(
                new KaigoServiceShuruiCode(div.getTxtServiceType().getValue()),
                new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toDateString()));
        SearchResult<KaigoServiceShurui> focusServiceTypeList = service.getFocusServiceTypeList(param);
        getHandler(div).setServiceTypeName(focusServiceTypeList.records());
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索」ボタンをクリック場合、サービス種類一覧ダイアログ画面が表示します。
     *
     * @param div ServiceTypeInputCommonChildDivDiv
     * @return ResponseData<ServiceTypeInputCommonChildDivDiv>
     */
    public ResponseData<ServiceTypeInputCommonChildDivDiv> onBeforeOpenDialog_btnSearch(ServiceTypeInputCommonChildDivDiv div) {
        getHandler(div).setParam();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索」ボタンをクリック場合、サービス種類一覧ダイアログ画面が表示します。
     *
     * @param div ServiceTypeInputCommonChildDivDiv
     * @return ResponseData<ServiceTypeInputCommonChildDivDiv>
     */
    public ResponseData<ServiceTypeInputCommonChildDivDiv> onOkClose_btnSearch(ServiceTypeInputCommonChildDivDiv div) {
        getHandler(div).getParam();
        return ResponseData.of(div).respond();
    }

    private ServiceTypeInputCommonChildHandler getHandler(ServiceTypeInputCommonChildDivDiv div) {
        return new ServiceTypeInputCommonChildHandler(div);
    }
}
