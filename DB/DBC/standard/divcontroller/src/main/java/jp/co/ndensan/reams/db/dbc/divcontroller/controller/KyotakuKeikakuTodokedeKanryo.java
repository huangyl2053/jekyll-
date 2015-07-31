/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0100000.KyotakuKeikakuTodokedeKanryoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 居宅サービス計画作成依頼届出情報登録の介護完了メッセージのコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuKeikakuTodokedeKanryo {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuKeikakuTodokedeKanryoDiv panel) {
        setKanryoMessage(panel);
        return ResponseData.of(panel).respond();
    }

    private void setKanryoMessage(KyotakuKeikakuTodokedeKanryoDiv panel) {
        //TODO n3317塚田　Yamlを使わないよう変更
//        KaigoKanryoMessage.setMessage(panel.getKyotakuKeikakuTodokedeKanryoMessage(),
//                cg.getAsRString("完了メッセージ"), cg.getAsRString("識別コード"), cg.getAsRString("氏名"));
    }
}
