/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.JogaiShinsainJoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho.JogaiShinsainJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho.dgShozokuKikanIchiran_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 除外審査員情報の画面処理Handlerクラスです。
 *
 * @reamsid_L DBE-1300-040 dongyabin
 */
public class JogaiShinsainJohoHandler {

    private static final RString 追加 = new RString("追加");
    private static final RString 選択 = new RString("選択");
    private static final RString 入力 = new RString("入力");
    private static final RString 照会 = new RString("照会");
    private final JogaiShinsainJohoDiv div;

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
    }

    /**
     * 画面状態を設定します。
     */
    public void set画面状態() {
        if (RString.isNullOrEmpty(div.getHdnModel()) || 入力.equals(div.getHdnModel())) {
            div.getBtnShinkiTsuika().setDisabled(false);
            div.getTxtShinsakaiIinCode().setDisabled(false);
            div.getBtnShinsakaiIinGuide().setDisabled(false);
            div.getBtnToroku().setDisabled(false);
        } else if (照会.equals(div.getHdnModel())) {
            div.getBtnShinkiTsuika().setDisabled(true);
            div.getTxtShinsakaiIinCode().setDisabled(true);
            div.getBtnShinsakaiIinGuide().setDisabled(true);
            div.getBtnToroku().setDisabled(false);
        }
    }

    /**
     * 登録するボタンを押します。
     */
    public void onClick_btnToroku() {
        if (追加.equals(div.getHdnModel())) {
            List<dgShinsakaiIinIchiran_Row> rowList = div.getDgShinsakaiIinIchiran().getDataSource();
            List<dgShozokuKikanIchiran_Row> row所属機関 = div.getDgShozokuKikanIchiran().getDataSource();
            RString 所属機関 = RString.EMPTY;
            if (!row所属機関.isEmpty()) {
                所属機関 = row所属機関.get(0).getShozokuKikanName();
            }
            rowList.add(new dgShinsakaiIinIchiran_Row(div.getTxtShinsakaiIinCode().getValue(),
                    div.getTxtShinsakaiIinName().getValue(), 所属機関));
            div.getDgShinsakaiIinIchiran().setDataSource(rowList);
        } else if (選択.equals(div.getHdnModel())) {
            List<dgShinsakaiIinIchiran_Row> rowList = div.getDgShinsakaiIinIchiran().getDataSource();
            List<dgShozokuKikanIchiran_Row> row所属機関 = div.getDgShozokuKikanIchiran().getDataSource();
            RString 所属機関 = RString.EMPTY;
            if (!row所属機関.isEmpty()) {
                所属機関 = row所属機関.get(0).getShozokuKikanName();
            }
            dgShinsakaiIinIchiran_Row row = rowList.get(div.getDgShinsakaiIinIchiran().getClickedRowId());
            row.setShinsakaiIinCode(div.getTxtShinsakaiIinCode().getValue());
            row.setShimei(div.getTxtShinsakaiIinName().getValue());
            row.setShozokuKikan(所属機関);
        }
    }

}
