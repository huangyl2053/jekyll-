/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.ShoKaishuKirokuDialog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuDialog.ShoKaishuKirokuDialogDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri.dgKoufuKaishu_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishuIdentifier;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 証交付回収記録ダイアログのイベントを定義したクラスです。
 *
 * @author n8178
 */
public class ShoKaishuKirokuDialog {

    /**
     * onLoad時の処理です。ダイアログを開いた際に、親画面側で設定された情報を元に初期化処理を行います。
     *
     * @param div 施設入退所ダイアログDiv
     * @return ResponseData
     */
    public ResponseData<ShoKaishuKirokuDialogDiv> onLoad(ShoKaishuKirokuDialogDiv div) {

        if (isEmptyKeyData(div)) {
            return ResponseData.of(div).respond();
        }

        HihokenshaNo hihokenshaNo = new HihokenshaNo(div.getHihokenshaNo());
        RString mode = div.getMode();

        if (isEmptyGridAndSaveData(div)) {
            div.getCcdShoKaishuKiroku().initialize(mode, hihokenshaNo);
        } else {
            ArrayList<dgKoufuKaishu_Row> dataSource = new ArrayList<>();
            ArrayList<ShoKaishuKirokuRowData> rowDataList = DataPassingConverter.deserialize(div.getGridData(), ArrayList.class);
            for (ShoKaishuKirokuRowData rowData : rowDataList) {
                dgKoufuKaishu_Row row = rowData.toRow();
                dataSource.add(row);
            }

            Models<ShoKofuKaishuIdentifier, ShoKofuKaishu> 証交付回収情報Model = DataPassingConverter.deserialize(div.getSaveData(), Models.class);
            div.getCcdShoKaishuKiroku().initialize(mode, hihokenshaNo, dataSource, 証交付回収情報Model);
        }

        return ResponseData.of(div).respond();
    }

    private boolean isEmptyKeyData(ShoKaishuKirokuDialogDiv div) {
        if (div.getMode() == null || div.getMode().isEmpty()) {
            return true;
        }
        return (div.getHihokenshaNo() == null || div.getHihokenshaNo().isEmpty());
    }

    private boolean isEmptyGridAndSaveData(ShoKaishuKirokuDialogDiv div) {
        if (div.getGridData() == null || div.getGridData().isEmpty()) {
            return true;
        }
        return (div.getSaveData() == null || div.getSaveData().isEmpty());
    }

    /**
     * 閉じるボタンを押した時の処理です。グリッド上のデータと保存対象のデータを、親画面に引き渡すための準備をします。
     *
     * @param div 施設入退所ダイアログDiv
     * @return ResponseData
     */
    public ResponseData<ShoKaishuKirokuDialogDiv> onClick_btnClose(ShoKaishuKirokuDialogDiv div) {

        List<dgKoufuKaishu_Row> dataSource = div.getCcdShoKaishuKiroku().get証交付回収情報一覧();

        ArrayList<ShoKaishuKirokuRowData> rowDataList = new ArrayList<>();
        for (dgKoufuKaishu_Row row : dataSource) {
            rowDataList.add(new ShoKaishuKirokuRowData(row));
        }
        div.setGridData(DataPassingConverter.serialize(rowDataList));

        Models<ShoKofuKaishuIdentifier, ShoKofuKaishu> 証交付回収情報Model = div.getCcdShoKaishuKiroku().getSaveData();
        div.setSaveData(DataPassingConverter.serialize(証交付回収情報Model));

        return ResponseData.of(div).respond();
    }
}
