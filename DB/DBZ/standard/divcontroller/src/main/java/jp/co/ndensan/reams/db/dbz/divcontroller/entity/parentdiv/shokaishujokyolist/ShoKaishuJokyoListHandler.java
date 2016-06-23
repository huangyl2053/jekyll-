/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shokaishujokyolist;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shokaishujokyolist.ShoKaishuJokyoListDiv.GridHyojiMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shokaishujokyolist.ShoKaishuJokyoListDiv.IchiranPanelTakasa;

/**
 *
 * @author N8211 田辺 紘一
 */
public class ShoKaishuJokyoListHandler {

    private final ShoKaishuJokyoListDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 施設情報共有子Divのエンティティ
     */
    public ShoKaishuJokyoListHandler(ShoKaishuJokyoListDiv div) {
        this.div = div;
    }

    /**
     * DataGridの選択ボタンのモード設定をします。（表示する/表示しない)
     */
    void setMode_DataGridのisShowSelectButtonColumn(GridHyojiMode gridViewMode) {
        div.setMode_GridHyojiMode(gridViewMode);
    }

    /**
     * DataGridの高さのモード設定をします。
     */
    void setMode_DataGridのheight(IchiranPanelTakasa gridHeight) {
        div.setMode_IchiranPanelTakasa(gridHeight);
    }
}
