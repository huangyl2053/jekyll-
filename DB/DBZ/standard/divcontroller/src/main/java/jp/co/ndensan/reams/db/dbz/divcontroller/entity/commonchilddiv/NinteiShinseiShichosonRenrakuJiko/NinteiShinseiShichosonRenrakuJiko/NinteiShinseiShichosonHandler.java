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
    private static final RString 要介護認定申請登録申請メニューID = new RString("DBDMN51001");
    private static final RString 連絡事項タイトル = new RString("連絡事項");
    private static final RString 認定調査委託先div = new RString("ChosaItakusakiAndChosainInput");
    private static final RString 調査員への連絡事項タイトル = new RString("調査員への連絡事項");
    private static final RString 主治医医療機関div = new RString("ShujiiIryokikanAndShujiiInput");
    private static final RString 主治医への連絡事項タイトル = new RString("主治医への連絡事項");
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
        if (shinseiCodeModel.getメニューID() != null 
                && !shinseiCodeModel.getメニューID().isEmpty()) { 
                if (shinseiCodeModel.getメニューID().equals(要介護認定申請登録申請メニューID)) {
                    div.setTitle(連絡事項タイトル);
                }
                if (shinseiCodeModel.getメニューID().equals(認定調査委託先div)) {
                    div.setTitle(調査員への連絡事項タイトル);
                }
                if (shinseiCodeModel.getメニューID().equals(主治医医療機関div)) {
                    div.setTitle(主治医への連絡事項タイトル);
                }
        }
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
            div.getBtnToroku().setDisplayNone(true);
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
