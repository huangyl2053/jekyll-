/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.ShoKaishuJokyoListDiv.グリッド表示モード;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.ShoKaishuJokyoListDiv.一覧パネル高さ;

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
    void setMode_DataGridのisShowSelectButtonColumn(グリッド表示モード gridViewMode) {
        div.setMode_グリッド表示モード(gridViewMode);
    }

    /**
     * DataGridの高さのモード設定をします。
     */
    void setMode_DataGridのheight(一覧パネル高さ gridHeight) {
        div.setMode_一覧パネル高さ(gridHeight);
    }
}
