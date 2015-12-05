/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.servicetype.ServiceTypeModel;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * サービス種類検索の抽象Handlerクラスです。
 *
 */
public class ServiceTypeInputCommonChildHandler {

    private final ServiceTypeInputCommonChildDivDiv div;

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public ServiceTypeInputCommonChildHandler(ServiceTypeInputCommonChildDivDiv div) {
        this.div = div;

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
        }
    }

    /**
     *
     * サービス種類ダイアログ画面のパラメータを設定します。
     *
     */
    public void setParam() {
        ServiceTypeModel serviceType = new ServiceTypeModel();
        serviceType.setサービス種類コード(div.getTxtServiceType().getValue());
        div.setServiceType(DataPassingConverter.serialize(serviceType));
    }

    /**
     *
     * サービス種類ダイアログ画面のパラメータを取得します。
     *
     */
    public void getParam() {
        ServiceTypeModel serviceType = DataPassingConverter.deserialize(div.getServiceType(), ServiceTypeModel.class);
        div.getTxtServiceType().setValue(serviceType.getサービス種類コード());
        div.getTxtServiceTypeName().setValue(serviceType.getサービス種類名称());
    }
}
