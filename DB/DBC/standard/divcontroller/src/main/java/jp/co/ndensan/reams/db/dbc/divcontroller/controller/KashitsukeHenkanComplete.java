/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1810000.KashitsukeHenkanCompleteDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoKanryoMessage;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付費貸付金返還徴収登録 処理完了のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class KashitsukeHenkanComplete {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<KashitsukeHenkanCompleteDiv> onLoad(KashitsukeHenkanCompleteDiv panel) {
//        ControlGenerator cg = new ControlGenerator(getYamlData(YML_COMPLETE).get(0));
//        KaigoKanryoMessage.setMessage(panel.getKashitsukeHenkanInfoCompleteInfo(), cg.getAsRString("メッセージ"));

        return ResponseData.of(panel).respond();
    }
}
