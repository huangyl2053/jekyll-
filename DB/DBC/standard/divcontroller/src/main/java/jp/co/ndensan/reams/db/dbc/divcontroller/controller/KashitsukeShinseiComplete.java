/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1800000.KashitsukeShinseiCompleteDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 給付費貸付金申請登録 処理完了のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class KashitsukeShinseiComplete {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeShinseiCompleteDiv> onLoad(KashitsukeShinseiCompleteDiv panel) {
//        ControlGenerator cg = new ControlGenerator(getYamlData(YML_COMPLETE).get(0));
//        KaigoKanryoMessage.setMessage(
//                panel.getKashitsukeShinseiCompleteInfo(),
//                cg.getAsRString("メッセージ"),
//                cg.getAsRString("上部"),
//                cg.getAsRString("下部"));

        return ResponseData.of(panel).respond();
    }
}
