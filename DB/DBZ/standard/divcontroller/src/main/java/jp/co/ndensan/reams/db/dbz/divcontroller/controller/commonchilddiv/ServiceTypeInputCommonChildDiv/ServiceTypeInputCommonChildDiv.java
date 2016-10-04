/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ServiceTypeInputCommonChildDiv;

import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigoserviceshurui.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiManager;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ServiceTypeModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * サービス種類検索のコントローラです。
 *
 * @reamsid_L DBA-0070-010 chengsanyuan
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
                new ServiceShuruiCode(div.getTxtServiceType().getValue()),
                new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toDateString()));
        SearchResult<KaigoServiceShurui> focusServiceTypeList = service.getFocusServiceTypeList(param);
        getHandler(div).setServiceTypeName(focusServiceTypeList.records());
        return ResponseData.of(div).respond();
    }

    /**
     * サービス種類コードのボタンを押します。
     *
     * @param div ServiceTypeInputCommonChildDivDiv
     * @return ResponseData<ServiceTypeInputCommonChildDivDiv>
     */
    public ResponseData<ServiceTypeInputCommonChildDivDiv> onBeforeDialg(ServiceTypeInputCommonChildDivDiv div) {
        ServiceTypeModel model = DataPassingConverter.deserialize(div.getHdnServiceModel(), ServiceTypeModel.class);
        if (model == null) {
            model = new ServiceTypeModel();
        }
        model.setサービス種類コード(div.getTxtServiceType().getValue());
        div.setHdnServiceModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    private ServiceTypeInputCommonChildHandler getHandler(ServiceTypeInputCommonChildDivDiv div) {
        return new ServiceTypeInputCommonChildHandler(div);
    }
}
