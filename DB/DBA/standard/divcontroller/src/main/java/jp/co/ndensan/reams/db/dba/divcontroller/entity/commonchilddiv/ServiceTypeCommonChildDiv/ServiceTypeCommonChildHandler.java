/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceTypeCommonChildDiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.servicetype.ServiceTypeModel;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * サービス種類検索の抽象Handlerクラスです。
 *
 */
public class ServiceTypeCommonChildHandler {

    private final ServiceTypeCommonChildDivDiv div;

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public ServiceTypeCommonChildHandler(ServiceTypeCommonChildDivDiv div) {
        this.div = div;

    }

    /**
     *
     * サービス種類検索初期化の設定します。
     *
     * @param list List<KaigoServiceShurui>
     * @param サービス種類コード KaigoServiceShuruiCode
     */
    public void initialize(List<KaigoServiceShurui> list, KaigoServiceShuruiCode サービス種類コード) {

        List<dgServiceType_Row> dataList = new ArrayList();
        for (KaigoServiceShurui result : list) {
            dgServiceType_Row row = new dgServiceType_Row();
            row.setTxtServiceShuruiCode(result.getサービス種類コード().getColumnValue());
            row.setTxtServiceShuruiName(result.getサービス種類名称());
            if (result.getサービス種類コード().getColumnValue().equals(サービス種類コード.getColumnValue())) {
                row.setSelected(Boolean.TRUE);
            }
            dataList.add(row);
        }
        div.getDgServiceType().setDataSource(dataList);
    }

    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void clear() {
        div.getDgServiceType().getDataSource().clear();
    }

    /**
     *
     * サービス種類ダイアログ画面のパラメータを設定します。
     *
     */
    public void setParam() {

        ServiceTypeModel serviceType = new ServiceTypeModel();
        if (!div.getDgServiceType().getSelectedItems().isEmpty()) {
            RString serviceShuruiCode = div.getDgServiceType().getSelectedItems().get(0).getTxtServiceShuruiCode();
            RString serviceShuruiName = div.getDgServiceType().getSelectedItems().get(0).getTxtServiceShuruiName();
            serviceType.setサービス種類コード(serviceShuruiCode);
            serviceType.setサービス種類名称(serviceShuruiName);
        }
        div.setServiceType(DataPassingConverter.serialize(serviceType));
    }
}
