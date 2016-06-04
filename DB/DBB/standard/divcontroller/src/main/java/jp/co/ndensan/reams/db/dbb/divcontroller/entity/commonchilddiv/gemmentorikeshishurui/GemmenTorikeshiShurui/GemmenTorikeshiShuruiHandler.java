/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.gemmentorikeshishurui.GemmenTorikeshiShurui;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.service.core.torikeshishuruiselect.TorikeshiShuruiSelect;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護保険料減免の取消種類選択画面のハンドラクラスです。
 *
 * @reamsid_L DBB-1660-040 xupeng
 */
public class GemmenTorikeshiShuruiHandler {

    private final GemmenTorikeshiShuruiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div GemmenTorikeshiShuruiDiv
     */
    public GemmenTorikeshiShuruiHandler(GemmenTorikeshiShuruiDiv div) {
        this.div = div;
    }

    /**
     * 初期値設定
     */
    public void init() {
        TorikeshiShuruiSelect manager = new TorikeshiShuruiSelect();
        List<UzT0007CodeEntity> list = manager.getTorikeshiShurui(FlexibleDate.getNowDate());
        List<dgGemmenTorikeshiShurui_Row> dgList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (UzT0007CodeEntity entity : list) {
                dgGemmenTorikeshiShurui_Row row = new dgGemmenTorikeshiShurui_Row();
                row.setTxtNaiyo(entity.getコード名称());
                row.setTxtHyojiMongon(entity.getコード略称());
                row.setTxtCode(entity.getコード().value());
                dgList.add(row);
            }
        }
        div.getDgGemmenTorikeshiShurui().setDataSource(dgList);
    }

    /**
     * 選択対象レコードのコード、表示文言を呼び元に返す
     */
    public void setSelect() {
        dgGemmenTorikeshiShurui_Row row = div.getDgGemmenTorikeshiShurui().getClickedItem();
        div.setGemmenTorikeshiShuruiCode(DataPassingConverter.serialize(row.getTxtCode()));
        div.setGemmenTorikeshiShuruiHyojiMongon(DataPassingConverter.serialize(row.getTxtHyojiMongon()));
    }
}
