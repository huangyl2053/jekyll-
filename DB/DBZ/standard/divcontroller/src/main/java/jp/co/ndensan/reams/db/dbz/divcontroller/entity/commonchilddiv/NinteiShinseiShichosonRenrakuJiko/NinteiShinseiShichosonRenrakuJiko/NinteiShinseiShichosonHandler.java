/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiShichosonRenrakuJiko.NinteiShinseiShichosonRenrakuJiko;

import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 共有子Div「市町村連絡事項」の実装クラスです。
 *
 * @reamsid_L DBZ-1300-090 suguangjun
 */
public class NinteiShinseiShichosonHandler {

    private final NinteiShinseiShichosonRenrakuJikoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiShinseiShichosonRenrakuJikoDiv
     */
    public NinteiShinseiShichosonHandler(NinteiShinseiShichosonRenrakuJikoDiv div) {
        this.div = div;
    }

    /**
     * 市町村連絡事項に初期化を設定する。
     *
     * @param shinseiCodeModel NinteiShinseiCodeModel
     */
    public void initialize(NinteiShinseiCodeModel shinseiCodeModel) {
        div.getTxtRenrakujiko().clearValue();
        if (NinteiShinseiCodeModel.HyojiMode.InputMode.equals(shinseiCodeModel.get表示モード())) {
            div.getTxtRenrakujiko().setValue(shinseiCodeModel.get連絡事項());
            div.getBtnModoru().setDisabled(false);
            div.getBtnToroku().setDisabled(false);
            div.getTxtRenrakujiko().setDisabled(false);
        } else if (NinteiShinseiCodeModel.HyojiMode.ShokaiMode.equals(shinseiCodeModel.get表示モード())) {
            div.getTxtRenrakujiko().setValue(shinseiCodeModel.get連絡事項());
            div.getBtnModoru().setDisabled(false);
            div.getBtnToroku().setDisabled(true);
            div.getTxtRenrakujiko().setDisabled(true);
        }
    }

    /**
     * 「確定する」ボタンをクリック場合、画面遷移が表示します。
     *
     */
    public void onClick_btnKakutei() {
        NinteiShinseiCodeModel shinseiCodeModel = new NinteiShinseiCodeModel();
        shinseiCodeModel.set連絡事項(div.getTxtRenrakujiko().getValue());
        ViewStateHolder.put(ViewStateKeys.モード, shinseiCodeModel);
    }
}
