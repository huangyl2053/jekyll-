/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.JogaiShinsainJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho.JogaiShinsainJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho.dgShozokuKikanIchiran_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;

/**
 * 除外審査員情報の画面処理Handlerクラスです。
 *
 * @reamsid_L DBZ-1300-040 dongyabin
 */
public class JogaiShinsainJohoHandler {

    private static final RString 入力 = new RString("入力");
    private static final RString 照会 = new RString("照会");
    private final JogaiShinsainJohoDiv div;

    private enum _状態 {

        追加("追加"),
        削除("削除");

        private final RString state;

        private _状態(String state) {

            this.state = new RString(state);
        }

        private RString get状態() {
            return state;
        }
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public JogaiShinsainJohoHandler(JogaiShinsainJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面項目にセットされている値をクリアします。
     */
    public void 画面項目にセットされている値をクリア() {
        div.getTxtShinsakaiIinCode().clearValue();
        div.getTxtShinsakaiIinName().clearValue();
        div.getDgShozokuKikanIchiran().setDataSource(new ArrayList<dgShozokuKikanIchiran_Row>());
    }

    /**
     * 画面状態を設定します。
     */
    public void set画面初期状態() {
        if (入力.equals(div.getHdnModel())) {
            div.getBtnShinkiTsuika().setDisabled(false);
        } else {
            div.getBtnShinkiTsuika().setDisabled(true);
            div.getBtnKakutei().setDisabled(true);
            div.getDgShinsakaiIinIchiran().setDisabled(true);
            if (div.getDgShinsakaiIinIchiran().getClickedItem() != null) {
                div.getDgShinsakaiIinIchiran().getClickedItem().setDeleteButtonState(DataGridButtonState.Disabled);
            }
        }

        div.getTxtShinsakaiIinCode().setDisabled(true);
        div.getBtnShinsakaiIinGuide().setDisabled(true);
        div.getBtnToroku().setDisabled(true);
        div.getBtnCancel().setDisabled(true);
        div.getDgShinsakaiIinIchiran().setReadOnly(false);
        div.getShinsakaiIinJoho().setHdnState(RString.EMPTY);
        List<dgShinsakaiIinIchiran_Row> selectedRow = new ArrayList<>();
        div.getDgShinsakaiIinIchiran().setSelectedItems(selectedRow);
    }

    /**
     * 登録するボタンを押します。
     */
    public void onClick_btnToroku() {
        if (div.getShinsakaiIinJoho().getHdnState().equals(_状態.追加.get状態())) {
            List<dgShinsakaiIinIchiran_Row> rowList = div.getDgShinsakaiIinIchiran().getDataSource();
            List<dgShozokuKikanIchiran_Row> row所属機関 = div.getDgShozokuKikanIchiran().getDataSource();
            RString 所属機関 = RString.EMPTY;
            if (!row所属機関.isEmpty()) {
                所属機関 = row所属機関.get(0).getShozokuKikanName();
            }
            rowList.add(new dgShinsakaiIinIchiran_Row(div.getShinsakaiIinJoho().getHdnState(), div.getTxtShinsakaiIinCode().getValue(),
                    div.getTxtShinsakaiIinName().getValue(), 所属機関));
            div.getDgShinsakaiIinIchiran().setDataSource(rowList);
        } else if (div.getShinsakaiIinJoho().getHdnState().equals(_状態.削除.get状態())) {
            dgShinsakaiIinIchiran_Row row = div.getDgShinsakaiIinIchiran().getClickedItem();
            row.setState(_状態.削除.get状態());
        }
    }

    /**
     * 審査会委員コードの重複チェックを行います。
     *
     *
     * @return boolean true:重複あり false:重複なし
     */
    public boolean isDupulicationIinCode() {
        RString iinCode = div.getShinsakaiIinJoho().getTxtShinsakaiIinCode().getText();
        for (dgShinsakaiIinIchiran_Row row : div.getDgShinsakaiIinIchiran().getDataSource()) {
            if (row.getShinsakaiIinCode().equals(iinCode)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 未入力のメッセージを定義します。
     */
    public static enum RRVMessages implements IValidationMessage {

        /**
         * 未入力
         */
        未入力(UrWarningMessages.未入力, "審査会委員コード"),
        /**
         * 未入力
         */
        重複(UrErrorMessages.既に存在, "追加しようとしている審査会委員コード");

        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
