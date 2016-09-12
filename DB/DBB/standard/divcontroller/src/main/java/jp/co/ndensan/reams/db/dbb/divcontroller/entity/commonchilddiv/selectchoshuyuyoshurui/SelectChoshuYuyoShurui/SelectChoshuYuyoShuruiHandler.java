/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.selectchoshuyuyoshurui.SelectChoshuYuyoShurui;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.service.core.choshuyuyoshuruiselect.ChoshuYuyoShuruiSelect;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 徴収猶予種類選択の画面
 *
 * @reamsid_L DBB-1680-030 xupeng
 */
public class SelectChoshuYuyoShuruiHandler {

    private final SelectChoshuYuyoShuruiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SelectChoshuYuyoShuruiDiv
     */
    public SelectChoshuYuyoShuruiHandler(SelectChoshuYuyoShuruiDiv div) {
        this.div = div;
    }

    /**
     * 初期値設定
     */
    public void init() {
        ChoshuYuyoShuruiSelect manager = new ChoshuYuyoShuruiSelect();
        List<UzT0007CodeEntity> list = manager.getChoshuYuyoShurui(FlexibleDate.getNowDate());
        List<dgYuyoShurui_Row> dgList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (UzT0007CodeEntity entity : list) {
                dgYuyoShurui_Row row = new dgYuyoShurui_Row();
                row.setNaiyo(entity.getコード名称());
                row.setHyojiMongon(entity.getコード略称());
                row.setCode(entity.getコード().value());
                dgList.add(row);
            }
        }
        div.getDgYuyoShurui().setDataSource(dgList);
    }

    /**
     * 選択対象レコードのコード、表示文言を呼び元に返す
     */
    public void setSelect() {
        dgYuyoShurui_Row row = div.getDgYuyoShurui().getClickedItem();
        div.setChoshuYuyoShuruiCode(DataPassingConverter.serialize(row.getCode()));
        div.setChoshuYuyoShuruiHyojiMongon(DataPassingConverter.serialize(row.getHyojiMongon()));
    }
}
