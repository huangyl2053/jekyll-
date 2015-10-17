/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810000.ShokanShikyuKetteiKanryoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 償還支給申請決定の介護完了メッセージのコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuKetteiKanryo {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(ShokanShikyuKetteiKanryoDiv panel) {
        setKanryoMessage(panel);

        return ResponseData.of(panel).respond();
    }

    private void setKanryoMessage(ShokanShikyuKetteiKanryoDiv panel) {
//        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
//
//        KaigoKanryoMessage.setMessage(panel.getShokanShikyuKetteiKanryoMessage(),
//                cg.getAsRString("完了メッセージ"), cg.getAsRString("識別コード"), cg.getAsRString("氏名"));
    }
}
