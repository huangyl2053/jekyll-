/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.servicetype.ServiceTypeModel;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceTypeCommonChildDiv.ServiceTypeCommonChildDivDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceTypeCommonChildDiv.ServiceTypeCommonChildHandler;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.mybatis.param.kaigoserviceshurui.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * サービス種類一覧のコントローラです。
 *
 */
public class ServiceTypeCommonChildDiv {

    private final KaigoServiceShuruiManager service;

    /**
     * コンストラクタです。
     */
    public ServiceTypeCommonChildDiv() {
        service = KaigoServiceShuruiManager.createInstance();
    }

    /**
     * サービス種類一覧初期化の設定します。
     *
     * @param div ServiceTypeCommonChildDivDiv
     * @return ResponseData<ServiceTypeCommonChildDivDiv>
     */
    public ResponseData<ServiceTypeCommonChildDivDiv> onLoad(ServiceTypeCommonChildDivDiv div) {
        ServiceTypeModel serviceType = DataPassingConverter.deserialize(div.getServiceType(), ServiceTypeModel.class);
        List<KaigoServiceShurui> list = service.getServiceTypeList(KaigoServiceShuruiMapperParameter.createSelectByKeyParam(
                new KaigoServiceShuruiCode(serviceType.getサービス種類コード()), new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toDateString())));
        getHandler(div).initialize(list, new KaigoServiceShuruiCode(serviceType.getサービス種類コード()));
        return ResponseData.of(div).respond();
    }

    /**
     * 「やめる」ボタンをクリック場合、画面が閉じるします。
     *
     * @param div ServiceTypeCommonChildDivDiv
     * @return ResponseData<ServiceTypeCommonChildDivDiv>
     */
    public ResponseData<ServiceTypeCommonChildDivDiv> onClick_btnYameru(ServiceTypeCommonChildDivDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定する」ボタンをクリック場合、画面遷移が表示します。
     *
     * @param div ServiceTypeCommonChildDivDiv
     * @return ResponseData<ServiceTypeCommonChildDivDiv>
     */
    public ResponseData<ServiceTypeCommonChildDivDiv> onClick_btnKakutei(ServiceTypeCommonChildDivDiv div) {
        if (1 < div.getDgServiceType().getSelectedItems().size()) {
            throw new ApplicationException(UrErrorMessages.選択行が不正.getMessage());
        }
        if (div.getDgServiceType().getSelectedItems().size() < 1) {
            throw new ApplicationException(UrErrorMessages.対象行を選択.getMessage());
        }
        getHandler(div).setParam();
        return ResponseData.of(div).respond();
    }

    private ServiceTypeCommonChildHandler getHandler(ServiceTypeCommonChildDivDiv div) {
        return new ServiceTypeCommonChildHandler(div);
    }
}
