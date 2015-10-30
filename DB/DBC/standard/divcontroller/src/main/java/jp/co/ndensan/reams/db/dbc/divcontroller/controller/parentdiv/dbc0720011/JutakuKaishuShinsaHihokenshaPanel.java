/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0720011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.JutakuKaishuShinsaHihokenshaPanelDiv;
//import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoShikakuKihon;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 住宅改修費支給申請審査の被保険者パネルです。
 *
 * @author N3317 塚田 萌
 */
//TODO n3317塚田　Yamlを使わないようにする
public class JutakuKaishuShinsaHihokenshaPanel {

    /**
     * 未審査住宅改修費支給申請一覧から修正ボタンを押したときの処理です。
     *
     * @param panel 被保険者panel
     * @return response
     */
    public ResponseData<JutakuKaishuShinsaHihokenshaPanelDiv> onLoad(JutakuKaishuShinsaHihokenshaPanelDiv panel) {
//        ControlGenerator targetSource = new ControlGenerator(targetSourceList.get(0));
//
//        ShikibetsuCode 識別コード = new ShikibetsuCode(targetSource.getAsRString("識別コード"));
//        int rowId = 0;
//        KaigoShikakuKihon.setData(panel.getKaigoAtena(), panel.getKaigoShikakuKihon(), 識別コード, rowId);

        return ResponseData.of(panel).respond();
    }
}
