/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ServiceTypeCommonChildDiv;

import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigoserviceshurui.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiManager;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeCommonChildDiv.ServiceTypeCommonChildDiv.ServiceTypeCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeCommonChildDiv.ServiceTypeCommonChildDiv.ServiceTypeCommonChildHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * サービス種類一覧のコントローラです。
 *
 * @reamsid_L DBA-0070-010 chengsanyuan
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
        SearchResult<KaigoServiceShurui> list = service.getServiceTypeList(KaigoServiceShuruiMapperParameter.createSelectByKeyParam(
                new ServiceShuruiCode(div.getHdnServiceType()), new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toDateString())));
        getHandler(div).initialize(list.records(), new ServiceShuruiCode(div.getHdnServiceType()));
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
        return ResponseData.of(div).dialogOKClose();
    }

    private ServiceTypeCommonChildHandler getHandler(ServiceTypeCommonChildDivDiv div) {
        return new ServiceTypeCommonChildHandler(div);
    }
}
