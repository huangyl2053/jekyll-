/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;

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
}
