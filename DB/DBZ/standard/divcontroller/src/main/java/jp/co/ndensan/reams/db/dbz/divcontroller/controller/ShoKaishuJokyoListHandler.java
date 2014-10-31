/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.ShoKaishuJokyoListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.ShoKaishuJokyoListDiv.DataGridのisShowSelectButtonColumn;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.ShoKaishuJokyoListDiv.DataGridのheight;

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
    void setMode_DataGridのisShowSelectButtonColumn(DataGridのisShowSelectButtonColumn DataGridのisShowSelectButtonColumn) {
        div.setMode_DataGridのisShowSelectButtonColumn(DataGridのisShowSelectButtonColumn);
    }

    /**
     * DataGridの高さのモード設定をします。
     */
    void setMode_DataGridのheight(DataGridのheight DataGridのheight) {
        div.setMode_DataGridのheight(DataGridのheight);
    }
}
