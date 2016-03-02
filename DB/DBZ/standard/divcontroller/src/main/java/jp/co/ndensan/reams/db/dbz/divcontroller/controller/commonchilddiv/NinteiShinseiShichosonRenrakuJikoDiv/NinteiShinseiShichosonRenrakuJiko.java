/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiShinseiShichosonRenrakuJikoDiv;

import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiShichosonRenrakuJiko.NinteiShinseiShichosonRenrakuJiko.NinteiShinseiShichosonRenrakuJikoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiShichosonRenrakuJiko.NinteiShinseiShichosonRenrakuJiko.NinteiShinseiShichosonHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 市町村連絡事項共有子Divです。
 */
public class NinteiShinseiShichosonRenrakuJiko {

    /**
     * 市町村連絡事項を初期化する。
     *
     * @param requestDiv NinteiShinseiShichosonRenrakuJikoDiv
     * @return ResponseData<NinteiShinseiShichosonRenrakuJikoDiv>
     */
    public ResponseData<NinteiShinseiShichosonRenrakuJikoDiv> onLoad(NinteiShinseiShichosonRenrakuJikoDiv requestDiv) {
        NinteiShinseiCodeModel shinseiCodeModel = ViewStateHolder.get(ViewStateKeys.モード, NinteiShinseiCodeModel.class);
        getHandler(requestDiv).initialize(shinseiCodeModel);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 確定するボタンが押下された場合、入力されている内容を親画面に渡す。
     *
     * @param requestDiv NinteiShinseiShichosonRenrakuJikoDiv
     * @return ResponseData<NinteiShinseiShichosonRenrakuJikoDiv>
     */
    public ResponseData<NinteiShinseiShichosonRenrakuJikoDiv> onClick_btnKakutei(NinteiShinseiShichosonRenrakuJikoDiv requestDiv) {
        getHandler(requestDiv).onClick_btnKakutei();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 戻るボタンが押下された場合、結果を親画面に反映せずにダイアログを閉じる。
     *
     * @param requestDiv NinteiShinseiShichosonRenrakuJikoDiv
     * @return ResponseData<NinteiShinseiShichosonRenrakuJikoDiv>
     */
    public ResponseData<NinteiShinseiShichosonRenrakuJikoDiv> onClick_btnTorikeshi(NinteiShinseiShichosonRenrakuJikoDiv requestDiv) {
        return ResponseData.of(requestDiv).respond();
    }

    private NinteiShinseiShichosonHandler getHandler(NinteiShinseiShichosonRenrakuJikoDiv requestDiv) {
        return new NinteiShinseiShichosonHandler(requestDiv);
    }
}
