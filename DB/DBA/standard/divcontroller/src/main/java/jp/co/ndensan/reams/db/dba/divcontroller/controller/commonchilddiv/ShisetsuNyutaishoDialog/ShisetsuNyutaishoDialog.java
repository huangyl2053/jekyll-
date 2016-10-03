/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.ShisetsuNyutaishoDialog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoDialog.ShisetsuNyutaishoDialogDiv;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 施設入退所ダイアログのイベントを定義したクラスです。
 *
 * @author n8178
 */
public class ShisetsuNyutaishoDialog {

    /**
     * onLoad時の処理です。ダイアログを開いた際に、親画面側で設定された情報を元に初期化処理を行います。
     *
     * @param div 施設入退所ダイアログDiv
     * @return ResponseData
     */
    public ResponseData<ShisetsuNyutaishoDialogDiv> onLoad(ShisetsuNyutaishoDialogDiv div) {

        if (isEmptyKeyData(div)) {
            setState(div, ShisetsuNyutaishoState.照会);
            return ResponseData.of(div).respond();
        }

        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(div.getShikibetsuCode());
        RString daichoShubetsu = div.getDaichoShubetsu();

        if (isEmptyGridAndSaveData(div)) {
            setState(div);

            div.getCcdShisetsuNyutaisho().initialize(shikibetsuCode, daichoShubetsu);
        } else {
            ArrayList<dgShisetsuNyutaishoRireki_Row> dataSource = new ArrayList<>();
            ArrayList<ShisetsuNyutaishoRowData> rowDataList = DataPassingConverter.deserialize(div.getGridData(), ArrayList.class);
            for (ShisetsuNyutaishoRowData rowData : rowDataList) {
                dgShisetsuNyutaishoRireki_Row row = rowData.toRow();
                dataSource.add(row);
            }

            Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model = DataPassingConverter.deserialize(div.getSaveData(), Models.class);
            setState(div);
            div.getCcdShisetsuNyutaisho().initialize(dataSource, 施設入退所情報Model);
        }

        return ResponseData.of(div).respond();
    }

    private boolean isEmptyKeyData(ShisetsuNyutaishoDialogDiv div) {
        if (div.getMode() == null || div.getMode().isEmpty()) {
            return true;
        }
        if (div.getDaichoShubetsu() == null || div.getDaichoShubetsu().isEmpty()) {
            return true;
        }
        return (div.getShikibetsuCode() == null || div.getShikibetsuCode().isEmpty());
    }

    private boolean isEmptyGridAndSaveData(ShisetsuNyutaishoDialogDiv div) {
        if (div.getGridData() == null || div.getGridData().isEmpty()) {
            return true;
        }
        return (div.getSaveData() == null || div.getSaveData().isEmpty());
    }

    private void setState(ShisetsuNyutaishoDialogDiv div) {
        setState(div, div.getMode());
    }

    private void setState(ShisetsuNyutaishoDialogDiv div, ShisetsuNyutaishoState state) {
        setState(div, state.getStateValue());
    }

    private void setState(ShisetsuNyutaishoDialogDiv div, RString state) {

        if (ShisetsuNyutaishoState.照会.getStateValue().equals(state)) {
            div.getCcdShisetsuNyutaisho().setShokaiMode();
        } else if (ShisetsuNyutaishoState.登録.getStateValue().equals(state)) {
            div.getCcdShisetsuNyutaisho().setTorokuMode();
        }
    }

    /**
     * 閉じるボタンを押した時の処理です。グリッド上のデータと保存対象のデータを、親画面に引き渡すための準備をします。
     *
     * @param div 施設入退所ダイアログDiv
     * @return ResponseData
     */
    public ResponseData<ShisetsuNyutaishoDialogDiv> onClick_btnClose(ShisetsuNyutaishoDialogDiv div) {
        List<dgShisetsuNyutaishoRireki_Row> dataSource = div.getCcdShisetsuNyutaisho().get施設入退所履歴一覧();

        ArrayList<ShisetsuNyutaishoRowData> rowDataList = new ArrayList<>();
        for (dgShisetsuNyutaishoRireki_Row row : dataSource) {
            rowDataList.add(new ShisetsuNyutaishoRowData(row));
        }
        div.setGridData(DataPassingConverter.serialize(rowDataList));

        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model = div.getCcdShisetsuNyutaisho().getSaveData();
        div.setSaveData(DataPassingConverter.serialize(施設入退所情報Model));

        return ResponseData.of(div).respond();
    }
}
