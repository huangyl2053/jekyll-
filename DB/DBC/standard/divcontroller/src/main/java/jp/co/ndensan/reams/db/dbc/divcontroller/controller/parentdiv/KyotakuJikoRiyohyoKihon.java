/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0120000.KyotakuJikoRiyohyoKihonDiv;
//import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoShikakuKihon;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 居宅サービス計画作成依頼届出情報登録の基本情報のコントロールです。
 *
 * @author N8187 久保田 英男
 */
//TODO n3317塚田　Yamlを使わないようにする
public class KyotakuJikoRiyohyoKihon {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuJikoRiyohyoKihonDiv panel) {
        setKihonData(panel);

        return ResponseData.of(panel).respond();
    }

    private void setKihonData(KyotakuJikoRiyohyoKihonDiv panel) {
//        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
//        ShikibetsuCode 識別コード = new ShikibetsuCode(cg.getAsRString("識別コード"));
//        int rowId = 0;

//        KaigoShikakuKihon.setData(panel.getKyotakuJikoRiyohyoKihonAtena(), panel.getKyotakuJikoRiyohyoKaigoKihon(), 識別コード, rowId);
    }
}
