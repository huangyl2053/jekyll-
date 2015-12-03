/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceCodeCommonChildDiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.servicecode.ServiceCodeModel;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * サービスコード検索の抽象Handlerクラスです。
 *
 */
public class ServiceCodeCommonChildDivHandler {
    
    private final ServiceCodeCommonChildDivDiv div;
    
    /**
     * コンストラクタです。
     *
     * @param div
     */
    public ServiceCodeCommonChildDivHandler(ServiceCodeCommonChildDivDiv div) {
        this.div = div;
    }
    
    /**
     * サービスコード検索一覧初期化の設定します。
     *
     */
    public void onLoad() {
        ServiceCodeModel serviceCode = DataPassingConverter.deserialize(div.getServiceCodeModel(), ServiceCodeModel.class);
        RStringBuilder sb = new RStringBuilder();
        sb.append(serviceCode.getサービス種類コード());
        // sb.append(serviceCode.getサービス項目コード());
        div.getTxtServiceCode().setValue(sb.toRString());
    }
    
    /**
     *
     * サービスコードを検索の設定します。
     *
     * @param list
     */
    public void initialize(List<KaigoServiceNaiyou> list) {
        KaigoServiceShuruiCode サービス種類コード = new KaigoServiceShuruiCode(div.getTxtServiceCode().getValue().substring(0, 2));
        List<dgCodeIchiran_Row> dataList = new ArrayList();
        for (KaigoServiceNaiyou serviceCode : list) {
            dgCodeIchiran_Row row = new dgCodeIchiran_Row();
            RStringBuilder sb = new RStringBuilder();
            sb.append(サービス種類コード.getColumnValue());
            sb.append(serviceCode.getサービス項目コード());
            row.setTxtServiceCode(sb.toRString());
            row.setTxtServiceName(serviceCode.getサービス名称());
            if (serviceCode.getサービス種類コード().equals(サービス種類コード)) {
                row.setSelected(Boolean.TRUE);
            }
            dataList.add(row);
        }
        div.getDgCodeIchiran().setDataSource(dataList);
    }
    
    /**
     * 「確定する」ボタンをクリック場合、画面遷移が表示します。
     *
     */
    public void onClick_btnKakutei() {
        ServiceCodeModel serviceCode = new ServiceCodeModel();
        serviceCode.setサービス種類コード(div.getDgCodeIchiran().getClickedItem().getTxtServiceCode().substring(0, 2));
        // TODO 董亜彬 QA:47の回答する、2015/11/30まで
        // serviceCode.setサービス項目コード(serviceShuruiCode.substring(2, 6));
        serviceCode.setサービス項目コード(new RString("1001"));
        serviceCode.setサービス種類名称(div.getDgCodeIchiran().getClickedItem().getTxtServiceName());
        div.setServiceCodeModel(DataPassingConverter.serialize(serviceCode));
    }
    
    /**
     *
     * サービス種類検索初期化のデータを全てクリアします。
     *
     */
    public void clear() {
        div.getDgCodeIchiran().getDataSource().clear();
    }
    
}
