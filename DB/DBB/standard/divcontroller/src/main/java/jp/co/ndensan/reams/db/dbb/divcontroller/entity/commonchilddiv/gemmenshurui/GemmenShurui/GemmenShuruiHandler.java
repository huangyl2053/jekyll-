/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.gemmenshurui.GemmenShurui;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.service.core.gemmenshuruiselect.GemmenShuruiSelect;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護保険料減免の減免種類選択画面のハンドラクラスです。
 *
 * @reamsid_L DBB-1660-030 xupeng
 */
public class GemmenShuruiHandler {

    private final GemmenShuruiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div GemmenShuruiDiv
     */
    public GemmenShuruiHandler(GemmenShuruiDiv div) {
        this.div = div;
    }

    /**
     * 初期値設定
     */
    public void init() {
        GemmenShuruiSelect manager = new GemmenShuruiSelect();
        List<UzT0007CodeEntity> list = manager.getGemmenShurui(FlexibleDate.getNowDate());
        List<dgGemmenShurui_Row> dgList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (UzT0007CodeEntity entity : list) {
                dgGemmenShurui_Row row = new dgGemmenShurui_Row();
                row.setTxtNaiyo(entity.getコード名称());
                row.setTxtHyojiMongon(entity.getコード略称());
                row.setTxtCode(entity.getコード().value());
                dgList.add(row);
            }
        }
        div.getDgGemmenShurui().setDataSource(dgList);
    }

    /**
     * 選択対象レコードのコード、表示文言を呼び元に返す
     */
    public void setSelect() {
        dgGemmenShurui_Row row = div.getDgGemmenShurui().getClickedItem();
        div.setGemmenShuruiCode(DataPassingConverter.serialize(row.getTxtCode()));
        div.setGemmenShuruiHyojiMongon(DataPassingConverter.serialize(row.getTxtHyojiMongon()));
    }
}
