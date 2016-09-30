/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeCommonChildDiv.ServiceTypeCommonChildDiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * サービス種類検索の抽象Handlerクラスです。
 *
 * @reamsid_L DBA-0070-010 chengsanyuan
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
     */
    public void initialize(List<KaigoServiceShurui> list) {

        List<dgServiceType_Row> dataList = new ArrayList<>();
        for (KaigoServiceShurui result : list) {
            dgServiceType_Row row = new dgServiceType_Row();
            row.setTxtServiceShuruiCode(result.getサービス種類コード().getColumnValue());
            row.setTxtServiceShuruiName(result.getサービス種類名称());
            row.setTxtServiceRyakusho(result.getサービス種類略称());
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
        if (!div.getDgServiceType().getSelectedItems().isEmpty()) {
            RString serviceShuruiCode = div.getDgServiceType().getSelectedItems().get(0).getTxtServiceShuruiCode();
            RString serviceShuruiName = div.getDgServiceType().getSelectedItems().get(0).getTxtServiceShuruiName();
            RString serviceRyakusho = div.getDgServiceType().getSelectedItems().get(0).getTxtServiceRyakusho();
            div.setHdnServiceType(serviceShuruiCode);
            div.setHdnServiceTypeName(serviceShuruiName);
            div.setHdnServiceRyakusho(serviceRyakusho);
        }
    }
}
