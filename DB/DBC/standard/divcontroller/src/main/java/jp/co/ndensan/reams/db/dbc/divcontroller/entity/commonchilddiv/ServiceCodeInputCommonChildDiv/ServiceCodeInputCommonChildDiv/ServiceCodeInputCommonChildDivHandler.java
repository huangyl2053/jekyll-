/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDiv;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.servicecode.ServiceCodeModel;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * サービス種類検索の抽象Handlerクラスです。
 *
 * @reamsid_L DBA-0340-060 dongyabin
 */
public class ServiceCodeInputCommonChildDivHandler {

    private final ServiceCodeInputCommonChildDivDiv div;

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public ServiceCodeInputCommonChildDivHandler(ServiceCodeInputCommonChildDivDiv div) {
        this.div = div;
    }

    /**
     *
     * 「サービスコードのフォーカスアウト」の設定します。
     *
     * @param focusServiceCodeList
     */
    public void initialize(List<KaigoServiceNaiyou> focusServiceCodeList) {
        if (!focusServiceCodeList.isEmpty()) {
            div.getTxtServiceCodeName().setValue(focusServiceCodeList.get(0).getサービス名称());
        } else {
            div.getTxtServiceCodeName().clearValue();
        }
    }

    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void clear() {
        div.getTxtServiceCode1().clearValue();
        div.getTxtServiceCode2().clearValue();
        div.getTxtServiceCodeName().clearValue();
    }

    /**
     * 「検索」ボタンをクリック場合、サービスコード検索一覧ダイアログ画面が表示します。
     *
     */
    public void onBeforeOpenDialog_btnSearch() {
        ServiceCodeModel serviceCode = DataPassingConverter.deserialize(div.getServiceCodeModel(), ServiceCodeModel.class);
        serviceCode.setサービス種類コード(div.getTxtServiceCode1().getValue());
        serviceCode.setサービス項目コード(div.getTxtServiceCode2().getValue());
        div.setServiceCodeModel(DataPassingConverter.serialize(serviceCode));
    }

    /**
     * 「検索」ボタンをクリック場合、サービスコード検索一覧ダイアログ画面が表示します。
     *
     */
    public void onOkClose_btnSearch() {
        ServiceCodeModel serviceCode = DataPassingConverter.deserialize(div.getServiceCodeModel(), ServiceCodeModel.class);
        div.getTxtServiceCode1().setValue(serviceCode.getサービス種類コード());
        div.getTxtServiceCode2().setValue(serviceCode.getサービス項目コード());
        div.getTxtServiceCodeName().setValue(serviceCode.getサービス種類名称());
    }
}
