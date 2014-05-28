/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.JogaishaTekiyoInputDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJogaiJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJogaiTaishoGaitoshaDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJogaiTorokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dgTekiyoJogaiRireki_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.helper.TekiyoJogaiValueSetter;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 適用除外情報を表示するDivに対応したControllerです。
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaiJoho {

    /**
     * 適用除外情報を確定するボタンを押した際に、適用除外情報グリッドに情報を追加します。<br/>
     * 追加された入力情報は、適用除外情報入力Divからクリアされます。
     *
     * @param tekiyoJogaiJohoDiv 適用除外情報Div
     * @param tekiyoJogaiTaishoGaitoshaDiv 適用除外対象該当者Div
     * @return レスポンス
     */
    public ResponseData onClick_btnInsertTekiyoJogaiJoho(TekiyoJogaiJohoDiv tekiyoJogaiJohoDiv,
            TekiyoJogaiTaishoGaitoshaDiv tekiyoJogaiTaishoGaitoshaDiv) {
        ResponseData<TekiyoJogaiJohoDiv> response = new ResponseData<>();

        insertNewData(tekiyoJogaiJohoDiv.getDgTekiyoJogaiRireki(),
                tekiyoJogaiJohoDiv.getTekiyoJogaiToroku());

        TekiyoJogaiValueSetter.clear(tekiyoJogaiJohoDiv.getTekiyoJogaiToroku());

        response.data = tekiyoJogaiJohoDiv;
        return response;
    }

    private void insertNewData(DataGrid<dgTekiyoJogaiRireki_Row> dgTekiyoJogaiRireki, TekiyoJogaiTorokuDiv tekiyoJogaiToroku) {
        List<dgTekiyoJogaiRireki_Row> tekiyoJogaiRirekiList = new ArrayList<>();
        dgTekiyoJogaiRireki_Row item = createTekiyoJogaiRirekiRow(tekiyoJogaiToroku.getJogaishaTekiyoInput(), createTekiyoJogaiRirekiRow());
        tekiyoJogaiRirekiList.add(item);
        dgTekiyoJogaiRireki.setDataSource(tekiyoJogaiRirekiList);
    }

    private dgTekiyoJogaiRireki_Row createTekiyoJogaiRirekiRow() {
        return new dgTekiyoJogaiRireki_Row(new Button(), RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.HALF_SPACE, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    private dgTekiyoJogaiRireki_Row createTekiyoJogaiRirekiRow(JogaishaTekiyoInputDiv jogaishaTekiyoInput, dgTekiyoJogaiRireki_Row row) {
        row.setTekiyoJiyuKey(jogaishaTekiyoInput.getDdlTekiyoJiyu().getSelectedItem());
        row.setTekiyoJiyu(jogaishaTekiyoInput.getDdlTekiyoJiyu().getSelectedValue());
        row.getTekiyoDate().setValue(jogaishaTekiyoInput.getTxtTekiyoDate().getValue());
        row.getTekiyoTodokedeDate().setValue(jogaishaTekiyoInput.getTxtTekiyoTodokedeDate().getValue());
        row.getNyushoDate().setValue(jogaishaTekiyoInput.getTxtShisetsuNyushoDate().getValue());
        row.setShisetsuCode(jogaishaTekiyoInput.getTxtNyushoShisetsuCode().getValue());
        row.setShisetsuMeisho(jogaishaTekiyoInput.getTxtNyushoShisetsuMeisho().getValue());
        row.setShisetsu(row.getShisetsuCode().concat(new RString(":")).concat(row.getShisetsuMeisho()));
        return row;
    }

    /**
     * 対象者が選択された際に、適用除外情報入力Divに対してデモ用初期値を設定します。
     *
     * @param tekiyoJogaiJohoDiv 適用除外情報Div
     * @param tekiyoJogaiTaishoGaitoshaDiv 適用除外対象該当者Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSelectGaitosha(TekiyoJogaiJohoDiv tekiyoJogaiJohoDiv,
            TekiyoJogaiTaishoGaitoshaDiv tekiyoJogaiTaishoGaitoshaDiv) {
        ResponseData<TekiyoJogaiJohoDiv> response = new ResponseData<>();
        TekiyoJogaiValueSetter.setDefaultValue(tekiyoJogaiJohoDiv.getTekiyoJogaiToroku());
        response.data = tekiyoJogaiJohoDiv;
        return response;
    }

    /**
     * 検索した対象者が一件しか見つからなかった際に、適用除外情報入力Divに対してデモ用初期値を設定します。
     *
     * @param tekiyoJogaiJohoDiv 適用除外情報Div
     * @param tekiyoJogaiTaishoGaitoshaDiv 適用除外対象該当者Div
     * @return レスポンス
     */
    public ResponseData onOnlyRow_dgTekiyoJogaiTaishoGaitosha(TekiyoJogaiJohoDiv tekiyoJogaiJohoDiv,
            TekiyoJogaiTaishoGaitoshaDiv tekiyoJogaiTaishoGaitoshaDiv) {
        ResponseData<TekiyoJogaiJohoDiv> response = new ResponseData<>();
        TekiyoJogaiValueSetter.setDefaultValue(tekiyoJogaiJohoDiv.getTekiyoJogaiToroku());
        response.data = tekiyoJogaiJohoDiv;
        return response;
    }

    /**
     * グリッド内の修正ボタンを押した際に、修正する行の情報を入力Divに表示します。
     *
     * @param tekiyoJogaiJohoDiv 適用除外情報Div
     * @param tekiyoJogaiTaishoGaitoshaDiv 適用除外対象該当者Div
     * @return レスポンス
     */
    public ResponseData onClick_btnShusei(TekiyoJogaiJohoDiv tekiyoJogaiJohoDiv,
            TekiyoJogaiTaishoGaitoshaDiv tekiyoJogaiTaishoGaitoshaDiv) {
        ResponseData<TekiyoJogaiJohoDiv> response = new ResponseData<>();
        setTekiyoJogaiToroku(tekiyoJogaiJohoDiv.getTekiyoJogaiToroku(), tekiyoJogaiJohoDiv.getDgTekiyoJogaiRireki().getClickedItem());
        response.data = tekiyoJogaiJohoDiv;
        return response;
    }

    private void setTekiyoJogaiToroku(TekiyoJogaiTorokuDiv tekiyoJogaiToroku, dgTekiyoJogaiRireki_Row clickedItem) {
        JogaishaTekiyoInputDiv inputDiv = tekiyoJogaiToroku.getJogaishaTekiyoInput();
        inputDiv.getDdlTekiyoJiyu().setSelectedItem(clickedItem.getTekiyoJiyuKey());
        inputDiv.getTxtShisetsuNyushoDate().setValue(clickedItem.getNyushoDate().getValue());
        inputDiv.getTxtTekiyoDate().setValue(clickedItem.getTekiyoDate().getValue());
        inputDiv.getTxtTekiyoTodokedeDate().setValue(clickedItem.getTekiyoTodokedeDate().getValue());
        inputDiv.getTxtNyushoShisetsuCode().setValue(clickedItem.getShisetsuCode());
        inputDiv.getTxtNyushoShisetsuMeisho().setValue(clickedItem.getShisetsuMeisho());
    }
}
