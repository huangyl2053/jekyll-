/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigoserviceshurui.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * サービス種類検索の抽象Handlerクラスです。
 *
 * @reamsid_L DBA-0070-010 chengsanyuan
 */
public class ServiceTypeInputCommonChildHandler {

    private final ServiceTypeInputCommonChildDivDiv div;
    private final KaigoServiceShuruiManager service;

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public ServiceTypeInputCommonChildHandler(ServiceTypeInputCommonChildDivDiv div) {
        this.div = div;
        service = KaigoServiceShuruiManager.createInstance();
    }

    /**
     *
     * サービス種類検索初期化の設定します。
     *
     */
    public void initialize() {
        div.getTxtServiceType().clearValue();
        div.getTxtServiceTypeName().clearValue();
        div.getTxtServiceTypeName().setDisabled(true);
    }

    /**
     *
     * サービス種類検索初期化の設定します。
     *
     * @param serviceTypeCode
     */
    public void initialize(RString serviceTypeCode) {
        KaigoServiceShuruiMapperParameter param = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(
                new ServiceShuruiCode(serviceTypeCode),
                new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toDateString()));
        SearchResult<KaigoServiceShurui> focusServiceTypeList = service.getFocusServiceTypeList(param);
        if (focusServiceTypeList.records().isEmpty()) {
            div.getTxtServiceTypeName().setValue(RString.EMPTY);
        } else {
            div.getTxtServiceTypeName().setValue(focusServiceTypeList.records().get(0).getサービス種類名称());
        }
        div.getTxtServiceType().setValue(serviceTypeCode);
        div.getTxtServiceTypeName().setDisabled(true);
    }

    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void clear() {
        div.getTxtServiceType().clearValue();
        div.getTxtServiceTypeName().clearValue();
    }

    /**
     *
     * サービス種類名称の設定します。
     *
     * @param focusServiceTypeList List<KaigoServiceShurui>
     */
    public void setServiceTypeName(List<KaigoServiceShurui> focusServiceTypeList) {

        if (!focusServiceTypeList.isEmpty()) {
            div.getTxtServiceTypeName().setValue(focusServiceTypeList.get(0).getサービス種類名称());
            div.setHdnServiceRyakusho(focusServiceTypeList.get(0).getサービス種類略称());
        }
    }
}
