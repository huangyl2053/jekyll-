/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.IryoHokenRirekiDialog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryoHokenRirekiDialog.IryoHokenRirekiDialogDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryoHokenRirekiState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.dgIryohokenIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 医療保険履歴ダイアログのイベントを定義しています。
 *
 * @author n8178 城間篤人
 */
public class IryoHokenRirekiDialog {

    public ResponseData<IryoHokenRirekiDialogDiv> onLoad(IryoHokenRirekiDialogDiv div) {
        if (isHiddenInputEmpty(div)) {
            div.getCcdIryoHokenRireki().initialize(IryoHokenRirekiState.照会.getStateValue(), RString.EMPTY, HihokenshaNo.EMPTY);
        }

        HihokenshaNo hihokenshaNo = new HihokenshaNo(div.getHihokenshaNo());
        RString mode = div.getMode();
        RString shikibetsuCode = div.getShikibetsuCode();
        LasdecCode lasdecCode = new LasdecCode(div.getLasdecCode());

        if (isGridDataEmpty(div)) {
            div.getCcdIryoHokenRireki().initialize(mode, shikibetsuCode, hihokenshaNo, lasdecCode);
            return ResponseData.of(div).respond();
        } else {
            ArrayList<IryoHokenRirekiRowData> dataList = DataPassingConverter.deserialize(div.getGridData(), ArrayList.class);
            List<dgIryohokenIchiran_Row> dataSource = new ArrayList<>();
            for (IryoHokenRirekiRowData rowData : dataList) {
                dgIryohokenIchiran_Row row = IryoHokenRirekiRowData.toRow(rowData);
                dataSource.add(row);
            }
            div.getCcdIryoHokenRireki().initialize(mode, shikibetsuCode, hihokenshaNo, lasdecCode, dataSource);
            return ResponseData.of(div).respond();
        }

    }

    private boolean isHiddenInputEmpty(IryoHokenRirekiDialogDiv div) {
        if (div.getHihokenshaNo() == null || div.getHihokenshaNo().isEmpty()) {
            return true;
        }
        if (div.getMode() == null || div.getMode().isEmpty()) {
            return true;
        }
        if (div.getLasdecCode() == null || div.getLasdecCode().isEmpty()) {
            return true;
        }
        return (div.getShikibetsuCode() == null || div.getShikibetsuCode().isEmpty());
    }

    private boolean isGridDataEmpty(IryoHokenRirekiDialogDiv div) {
        return div.getGridData() == null || div.getGridData().isEmpty();
    }

    public ResponseData<IryoHokenRirekiDialogDiv> onClick_btnClose(IryoHokenRirekiDialogDiv div) {

        ArrayList<IryoHokenRirekiRowData> dataList = new ArrayList<>();
        for (dgIryohokenIchiran_Row row : div.getCcdIryoHokenRireki().getDataGridList()) {
            dataList.add(new IryoHokenRirekiRowData(row));
        }
        RString serialDataList = DataPassingConverter.serialize(dataList);
        div.setGridData(serialDataList);

        ArrayList<IryohokenKanyuJokyo> saveDataList = div.getCcdIryoHokenRireki().getSaveData();
        if (!saveDataList.isEmpty()) {
            RString serialSaveDataList = DataPassingConverter.serialize(saveDataList);
            div.setSaveData(serialSaveDataList);
        }
        return ResponseData.of(div).respond();
    }
}
