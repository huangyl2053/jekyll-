/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.selecttorikeshishurui.SelectTorikeshiShurui;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.service.core.choshuyuyotorikeshishuruiselect.ChoshuYuyoTorikeshiShuruiSelect;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 取消種類選択の画面のハンドラクラスです。
 *
 * @reamsid_L DBB-1680-040 xupeng
 */
public class SelectTorikeshiShuruiHandler {

    private final SelectTorikeshiShuruiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SelectTorikeshiShuruiDiv
     */
    public SelectTorikeshiShuruiHandler(SelectTorikeshiShuruiDiv div) {
        this.div = div;
    }

    /**
     * 初期値設定
     */
    public void init() {
        ChoshuYuyoTorikeshiShuruiSelect manager = new ChoshuYuyoTorikeshiShuruiSelect();
        List<UzT0007CodeEntity> list = manager.getChoshuYuyoTorikeshiShurui(FlexibleDate.getNowDate());
        List<dgTorikeshiShurui_Row> dgList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (UzT0007CodeEntity entity : list) {
                dgTorikeshiShurui_Row row = new dgTorikeshiShurui_Row();
                row.setNaiyo(entity.getコード名称());
                row.setHyojiMongon(entity.getコード略称());
                row.setCode(entity.getコード().value());
                dgList.add(row);
            }
        }
        div.getDgTorikeshiShurui().setDataSource(dgList);
    }

    /**
     * 選択対象レコードのコード、表示文言を呼び元に返す
     */
    public void setSelect() {
        dgTorikeshiShurui_Row row = div.getDgTorikeshiShurui().getClickedItem();
        div.setTorikeshiShuruiCode(DataPassingConverter.serialize(row.getCode()));
        div.setTorikeshiShuruiHyojiMongon(DataPassingConverter.serialize(row.getHyojiMongon()));
    }
}
