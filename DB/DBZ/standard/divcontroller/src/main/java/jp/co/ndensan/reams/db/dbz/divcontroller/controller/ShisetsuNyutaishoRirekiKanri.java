/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.ShisetsuJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.IShisetsuNyutaishoRirekiKanriDiv;
//import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 施設入退所履歴管理に対応するコントローラです。
 *
 * @author n8178 城間篤人
 */
public class ShisetsuNyutaishoRirekiKanri {

    private static final RString SHUSEI_MODE = new RString("shusei");
    private static final RString DELETE_MODE = new RString("delete");
    private static final RString ADD_MODE = new RString("add");
    private static final RString NONE = RString.EMPTY;

    /**
     * 入力モードに合わせて、コントロールの表示非表示を切り替えます。
     *
     * @param rirekiDiv 施設入退所履歴管理Div
     * @param mode モード
     * @return レスポンス
     */
    public static IShisetsuNyutaishoRirekiKanriDiv setMode(IShisetsuNyutaishoRirekiKanriDiv rirekiDiv, ModeType mode) {
//        rirekiDiv.setInputMode(mode.toValue());
//        if (ModeType.SHOKAI_MODE.toValue().equals(rirekiDiv.getInputMode())) {
//            rirekiDiv.getBtnAddShisetsuNyutaisho().setDisplayNone(true);
//            rirekiDiv.getBtnUpdateShisetsuNyutaisho().setDisplayNone(true);
//            rirekiDiv.getDgShisetsuNyutaishoRireki().getGridSetting().setIsShowDeleteButtonColumn(false);
//            rirekiDiv.getDgShisetsuNyutaishoRireki().getGridSetting().setIsShowModifyButtonColumn(false);
//            rirekiDiv.getShisetsuNyutaishoInput().setDisplayNone(true);
//        } else {
//
//        }
        return rirekiDiv;
    }

    /**
     * 施設入退所履歴グリッドから、修正したい行を選択した際に実行されます。<br/>
     * 入力を修正モードに切り替え、グリッドの内容を入力Divに表示します。
     *
     * @param rirekiDiv 施設入退所履歴管理Div
     * @return レスポンス
     */
    public ResponseData onSelectByModifyButton_dgShisetsuNyutaishoRireki(IShisetsuNyutaishoRirekiKanriDiv rirekiDiv) {
        ResponseData<IShisetsuNyutaishoRirekiKanriDiv> response = new ResponseData<>();

//        ShisetsuNyutaishoInputDiv inputDiv = rirekiDiv.getShisetsuNyutaishoInput();
//        dgShisetsuNyutaishoRireki_Row row = rirekiDiv.getDgShisetsuNyutaishoRireki().getClickedItem();
//        setInputMode(rirekiDiv, SHUSEI_MODE);
//        rirekiDiv.setSelectRow(new RString(Integer.toString(row.getId())));
//        setInputData(inputDiv, row);
//
//        setShowShisetsuShurui(rirekiDiv);
        response.data = rirekiDiv;
        return response;
    }

//    private void setInputData(ShisetsuNyutaishoInputDiv inputDiv, dgShisetsuNyutaishoRireki_Row row) {
//        inputDiv.getDdlTaishoJoho().setSelectedItem(row.getTaishoJohoKey());
//        inputDiv.getTxtNyushoDate().setValue(row.getNyushoDate().getValue());
//        inputDiv.getTxtTaishoDate().setValue(row.getTaishoDate().getValue());
//        inputDiv.getShisetsuJoho().getRadShisetsuShurui().setSelectedItem(row.getShisetsuShuruiKey());
//        inputDiv.getShisetsuJoho().getTxtShisetsuCode().setValue(row.getShisetsuCode());
//        inputDiv.getShisetsuJoho().getTxtShisetsuMeisho().setValue(row.getShisetsuMeisho());
//    }
    /**
     * 施設入退所情報を追加するボタンを押した際に実行されます。<br/>
     * 入力モードを追加モードに変更し、入力Divの値を初期化します。
     *
     * @param rirekiDiv 施設入退所履歴管理Div
     * @return レスポンス
     */
    public ResponseData onClick_btnAddShisetsuNyutaisho(ShisetsuNyutaishoRirekiKanriDiv rirekiDiv) {
        ResponseData<ShisetsuNyutaishoRirekiKanriDiv> response = new ResponseData<>();

//        ShisetsuNyutaishoInputDiv inputDiv = rirekiDiv.getShisetsuNyutaishoInput();
//        setInputMode(rirekiDiv, ADD_MODE);
//        clearInputData(inputDiv);
//
//        setShowShisetsuShurui(rirekiDiv);
        response.data = rirekiDiv;
        return response;
    }

//    private dgShisetsuNyutaishoRireki_Row createNewRow() {
//        return new dgShisetsuNyutaishoRireki_Row(new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
//                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
//    }
    /**
     * 施設入退所情報を確定するボタンを押した際に実行されます。<br/>
     * 入力した施設入退所の情報をグリッドに反映させます。入力モードが追加の場合は新規追加、修正の場合は修正対象行のデータが変更されます。<br/>
     * また、入力情報をグリッドに追加したあと、入力モードが未設定に切り替わります。
     *
     * @param rirekiDiv 施設入退所履歴管理Div
     * @return レスポンス
     */
    public ResponseData onClick_btnUpdateShisetsuNyutaisho(ShisetsuNyutaishoRirekiKanriDiv rirekiDiv) {
        ResponseData<ShisetsuNyutaishoRirekiKanriDiv> response = new ResponseData<>();
//
//        ShisetsuNyutaishoInputDiv inputDiv = rirekiDiv.getShisetsuNyutaishoInput();
//        DataGrid<dgShisetsuNyutaishoRireki_Row> grid = rirekiDiv.getDgShisetsuNyutaishoRireki();
//        dgShisetsuNyutaishoRireki_Row row = createNewRow();
//
//        if (SHUSEI_MODE.equals(rirekiDiv.getInputMode())) {
//            int selectRow = Integer.parseInt(rirekiDiv.getSelectRow().toString());
//            row = grid.getDataSource().get(selectRow);
//            setRirekiRow(row, inputDiv);
//            if (!row.getRowState().equals(RowState.Added)) {
//                row.setRowState(RowState.Modified);
//            }
//        } else if (DELETE_MODE.equals(rirekiDiv.getInputMode())) {
//            int selectRow = Integer.parseInt(rirekiDiv.getSelectRow().toString());
//            row = grid.getDataSource().get(selectRow);
//            if (row.getRowState().equals(RowState.Added)) {
//                rirekiDiv.getDgShisetsuNyutaishoRireki().getDataSource().remove(selectRow);
//            } else {
//                row.setRowState(RowState.Deleted);
//            }
//        } else {
//            row.setRowState(RowState.Added);
//            setRirekiRow(row, inputDiv);
//            grid.getDataSource().add(0, row);
//            setBeforeDataTaishoDate(grid.getDataSource());
//        }
//
//        clearInputData(rirekiDiv.getShisetsuNyutaishoInput());
//        setInputMode(rirekiDiv, NONE);
        response.data = rirekiDiv;
        return response;
    }

//    private void setRirekiRow(dgShisetsuNyutaishoRireki_Row row, ShisetsuNyutaishoInputDiv inputDiv) {
//        row.getNyushoDate().setValue(inputDiv.getTxtNyushoDate().getValue());
//        row.getTaishoDate().setValue(inputDiv.getTxtTaishoDate().getValue());
//        row.setShisetsuCode(inputDiv.getShisetsuJoho().getTxtShisetsuCode().getValue());
//        row.setShisetsuMeisho(inputDiv.getShisetsuJoho().getTxtShisetsuMeisho().getValue());
//        row.setShisetsu(row.getShisetsuCode().concat(":").concat(row.getShisetsuMeisho()));
//        row.setTaishoJohoKey(inputDiv.getDdlTaishoJoho().getSelectedItem());
//        row.setTaishoJoho(inputDiv.getDdlTaishoJoho().getSelectedValue());
//        row.setShisetsuShuruiKey(inputDiv.getShisetsuJoho().getRadShisetsuShurui().getSelectedItem());
//        row.setShisetsuShurui(inputDiv.getShisetsuJoho().getRadShisetsuShurui().getSelectedValue());
//    }
//    private void clearInputData(ShisetsuNyutaishoInputDiv inputDiv) {
//        inputDiv.getDdlTaishoJoho().setSelectedItem(new RString("kannai"));
//        inputDiv.getShisetsuJoho().getRadShisetsuShurui().setSelectedItem(new RString("kaigoHokenShisetsu"));
//        inputDiv.getTxtNyushoDate().setValue(null);
//        inputDiv.getTxtNyushoDate().setValue(null);
//        inputDiv.getTxtTaishoDate().setValue(null);
//        inputDiv.getShisetsuJoho().getTxtShisetsuCode().setValue(null);
//        inputDiv.getShisetsuJoho().getTxtShisetsuMeisho().setValue(null);
//    }
//    private void setBeforeDataTaishoDate(List<dgShisetsuNyutaishoRireki_Row> dataSource) {
//        if (dataSource.size() < 2) {
//            return;
//        }
//
//        dgShisetsuNyutaishoRireki_Row addRow = dataSource.get(0);
//        dgShisetsuNyutaishoRireki_Row beforeRow = dataSource.get(1);
//        if (beforeRow.getTaishoDate().getValue() == null) {
//            beforeRow.getTaishoDate().setValue(addRow.getNyushoDate().getValue());
//        }
//    }
    /**
     * 施設入退所履歴グリッドから、削除したい行を選択した際に実行されます。<br/>
     * 対象の行の状態に削除を設定します（既に削除が設定されている場合は削除を解除します）。
     *
     * @param rirekiDiv 施設入退所履歴管理Div
     * @return レスポンス
     */
    public ResponseData onSelectByDeleteButton_dgShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiKanriDiv rirekiDiv) {
        ResponseData<ShisetsuNyutaishoRirekiKanriDiv> response = new ResponseData<>();
//        dgShisetsuNyutaishoRireki_Row row = rirekiDiv.getDgShisetsuNyutaishoRireki().getClickedItem();
//
//        ShisetsuNyutaishoInputDiv inputDiv = rirekiDiv.getShisetsuNyutaishoInput();
//        setInputMode(rirekiDiv, DELETE_MODE);
//        rirekiDiv.setSelectRow(new RString(Integer.toString(row.getId())));
//        setInputData(inputDiv, row);
//
//        setShowShisetsuShurui(rirekiDiv);

        response.data = rirekiDiv;
        return response;
    }

    /**
     * 施設入退所履歴グリッドの件数が0件のときに実行します。<br/>
     * グリッドが0件の場合、削除・修正は行えないので、あらかじめ追加モードを設定します。<br/>
     * 現在、グリッドが0件である間、延々と実行してしまうため（不具合？）このメソッドはイベントに関連付けられていません。
     *
     * @param rirekiDiv 施設入退所履歴管理Div
     * @return レスポンス
     */
    public ResponseData onNoRow_dgShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiKanriDiv rirekiDiv) {
        ResponseData<ShisetsuNyutaishoRirekiKanriDiv> response = new ResponseData<>();

        setInputMode(rirekiDiv, ADD_MODE);

        setShowShisetsuShurui(rirekiDiv);
        response.data = rirekiDiv;
        return response;
    }

    private void setInputMode(IShisetsuNyutaishoRirekiKanriDiv rirekiDiv, RString mode) {
//        ShisetsuNyutaishoInputDiv inputDiv = rirekiDiv.getShisetsuNyutaishoInput();
//        rirekiDiv.setInputMode(mode);
//
//        if (SHUSEI_MODE.equals(rirekiDiv.getInputMode())) {
//            inputDiv.setDisabled(false);
//            rirekiDiv.getBtnUpdateShisetsuNyutaisho().setDisabled(false);
//        } else if (ADD_MODE.equals(rirekiDiv.getInputMode())) {
//            inputDiv.setDisabled(false);
//            rirekiDiv.getBtnUpdateShisetsuNyutaisho().setDisabled(false);
//        } else if (DELETE_MODE.equals(rirekiDiv.getInputMode())) {
//            inputDiv.setDisabled(true);
//            rirekiDiv.getBtnUpdateShisetsuNyutaisho().setDisabled(false);
//        } else {
//            inputDiv.setDisabled(true);
//            rirekiDiv.getBtnUpdateShisetsuNyutaisho().setDisabled(true);
//        }
    }

    private void setShowShisetsuShurui(IShisetsuNyutaishoRirekiKanriDiv rirekiDiv) {
//        ShisetsuNyutaishoInputDiv inputDiv = rirekiDiv.getShisetsuNyutaishoInput();
//        DropDownList ddl = inputDiv.getDdlTaishoJoho();
//        RadioButton rad = inputDiv.getShisetsuJoho().getRadShisetsuShurui();
//        List<KeyValueDataSource> sourceList = new ArrayList();
//
//        if (ddl.getSelectedItem().toString().equals("tekiyoJogai")) {
//            KeyValueDataSource source = new KeyValueDataSource(new RString("tekiyoJogaiShisetsu"), new RString("適用除外施設"));
//            sourceList.add(source);
//            rad.setDataSource(sourceList);
//            rad.setSelectedItem(new RString("tekiyoJogaiShisetsu"));
//        } else {
//            KeyValueDataSource source1 = new KeyValueDataSource(new RString("kaigoHokenShisetsu"), new RString("介護保険施設"));
//            KeyValueDataSource source2 = new KeyValueDataSource(new RString("other"), new RString("その他特例施設"));
//            sourceList.add(source1);
//            sourceList.add(source2);
//            rad.setDataSource(sourceList);
//            rad.setSelectedItem(new RString("kaigoHokenShisetsu"));
//        }
//        setShowShisetsuInputGuide(inputDiv.getShisetsuJoho());
    }

    private void setShowShisetsuInputGuide(ShisetsuJohoDiv div) {
//        RadioButton rad = div.getRadShisetsuShurui();
//        div.getBtnJigyoshaInputGuide().setDisplayNone(true);
//        div.getBtnOtherTokureiShisetsuInputGuide().setDisplayNone(true);
//        div.getBtnJogaiShisetsuInputGuide().setDisplayNone(true);
//
//        switch (rad.getSelectedItem().toString()) {
//            case "kaigoHokenShisetsu":
//                div.getBtnJigyoshaInputGuide().setDisplayNone(false);
//                break;
//            case "other":
//                div.getBtnOtherTokureiShisetsuInputGuide().setDisplayNone(false);
//                break;
//            default:
//                div.getBtnJogaiShisetsuInputGuide().setDisplayNone(false);
//                break;
//        }
    }

    /**
     * 対象情報を選択するドロップダウンリストの選択項目が変更された際に動作します。<br/>
     * 選択した内容に合わせて、使用する施設入力補助ダイアログを決定します。
     *
     * @param rirekiDiv 施設入退所履歴管理Div
     * @return レスポンス
     */
    public ResponseData onChange_ddlTaishoJoho(ShisetsuNyutaishoRirekiKanriDiv rirekiDiv) {
        ResponseData<ShisetsuNyutaishoRirekiKanriDiv> response = new ResponseData<>();

        setShowShisetsuShurui(rirekiDiv);
        response.data = rirekiDiv;
        return response;
    }
}
