/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.ShikakuHenkoRirekiDialog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShikakuHenkoRirekiDialog.ShikakuHenkoRirekiDialogDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.ShikakuTokusoRirekiDiv.DisplayType;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.dgHenko_Row;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 資格変更履歴Dialogのイベントを定義します。
 *
 * @author n8178
 */
public class ShikakuHenkoRirekiDialog {

    /**
     * 初期化処理を行います。初期化はhiddenInputのhihoDataに設定されている被保険者台帳情報を元に行います。
     * hiddenInput.hihoData に何も設定されていない場合は、グリッド上に何も設定しません。
     *
     * @param div 住所地特例ダイアログDiv
     * @return レスポンス
     */
    public ResponseData<ShikakuHenkoRirekiDialogDiv> onLoad(ShikakuHenkoRirekiDialogDiv div) {
        if (isHiddenInputEmpty(div)) {
            div.getCcdShikakuHenkoRireki().initialize(HihokenshaNo.EMPTY, ShikibetsuCode.EMPTY, FlexibleDate.MIN);
        }

        RString mode = div.getMode();
        ShikibetsuCode shikibetsuCode = ShikibetsuCode.EMPTY;
        FlexibleDate shutokuDate = new FlexibleDate(div.getShutokuDate());

        setMode(div, mode);

        if (isGridDataEmpty(div)) {
            ArrayList<HihokenshaDaicho> serialHihoData = DataPassingConverter.deserialize(div.getHihoData(), ArrayList.class);
            IItemList<HihokenshaDaicho> hihoData = ItemList.of(serialHihoData);
            hihoData = new HihokenshaDaichoList(hihoData).toOneSeasonList(shutokuDate);
            hihoData = new HihokenshaDaichoList(hihoData).to資格関連異動List();

            List<dgHenko_Row> dataSource = new ArrayList<>();
            for (HihokenshaDaicho hihoDaicho : hihoData) {
                dgHenko_Row row = toRow(hihoDaicho);
                dataSource.add(row);
            }
            div.getCcdShikakuHenkoRireki().initialize(shikibetsuCode, dataSource);
            return ResponseData.of(div).respond();
        } else {
//            ArrayList<ShikakuHenkoRowData> dataList = DataPassingConverter.deserialize(div.getGridData(), ArrayList.class);
//            List<dgHenko_Row> dataSource = new ArrayList<>();
//            for (ShikakuHenkoRowData rowData : dataList) {
//                dgHenko_Row row = ShikakuHenkoRowData.toRow(rowData);
//                dataSource.add(row);
//            }
//            div.getCcdShikakuHenkoRireki().initialize(shikibetsuCode, dataSource);
            return ResponseData.of(div).respond();
        }

    }

    private boolean isHiddenInputEmpty(ShikakuHenkoRirekiDialogDiv div) {
        if (div.getMode() == null || div.getMode().isEmpty()) {
            return true;
        }
        if (div.getShutokuDate() == null || div.getShutokuDate().isEmpty()) {
            return true;
        }
        return div.getHihoData() == null || div.getHihoData().isEmpty();
    }

    private boolean isGridDataEmpty(ShikakuHenkoRirekiDialogDiv div) {
        return div.getGridData() == null || div.getGridData().isEmpty();
    }

    private void setMode(ShikakuHenkoRirekiDialogDiv div, RString mode) {
        if (ShikakuHenkoState.照会.getStateValue().equals(mode)) {
            div.getCcdShikakuHenkoRireki().setDisplayTypeBykey(new RString(DisplayType.shokai.name()));
        } else if (ShikakuHenkoState.登録.getStateValue().equals(mode)) {
            div.getCcdShikakuHenkoRireki().setDisplayTypeBykey(new RString(DisplayType.teiseitoroku.name()));
        }
    }

    /**
     * 閉じるBTNをクリックした際の処理を行います。
     *
     * @param div 資格変更履歴DialogDiv
     * @return レスポンスデータ
     */
    public ResponseData<ShikakuHenkoRirekiDialogDiv> onClick_btnClose(ShikakuHenkoRirekiDialogDiv div) {

//        ArrayList<ShikakuHenkoRowData> dataList = new ArrayList<>();
//        for (dgHenko_Row row : div.getCcdShikakuHenkoRireki().getDgHenko().getDataSource()) {
//            dataList.add(new ShikakuHenkoRowData(row));
//        }
//        RString serialDataList = DataPassingConverter.serialize(dataList);
//        div.setGridData(serialDataList);
        //ここで、hiddenInput. hihoData に対して、住所地特例の修正結果を反映したデータを設定してあげる。
        //反映は、修正・追加・削除があった場合のみ（state値に変更があったとき）
//        ArrayList<IryohokenKanyuJokyo> saveDataList = div.getCcdIryoHokenRireki().getSaveData();
//        if (!saveDataList.isEmpty()) {
//            RString serialSaveDataList = DataPassingConverter.serialize(saveDataList);
//            div.setSaveData(serialSaveDataList);
//        }
        return ResponseData.of(div).respond();
    }

    /**
     * 引数を元にグリッドに設定可能なデータを用意します。
     *
     * @param hihoDaicho グリッドの元になる、被保険者台帳情報
     * @return 住所地特例のグリッドに設定可能なデータ
     */
    private static dgHenko_Row toRow(HihokenshaDaicho hihoDaicho) {
        dgHenko_Row row = new dgHenko_Row();
        row.setState(new RString(""));
        row.setShichosonCode(hihoDaicho.get市町村コード() == null
                ? RString.EMPTY
                : hihoDaicho.get市町村コード().getColumnValue());
        row.setHihokenshaNo(hihoDaicho.get被保険者番号() == null
                ? RString.EMPTY
                : hihoDaicho.get被保険者番号().getColumnValue());
        row.setShikibetsuCode(hihoDaicho.get識別コード() == null
                ? RString.EMPTY
                : hihoDaicho.get識別コード().getColumnValue());
        row.getHenkoDate().setValue(hihoDaicho.get資格変更年月日());
        row.getHenkoTodokedeDate().setValue(hihoDaicho.get資格変更届出年月日());
        row.setHenkoJiyu(nullOrEmpty(hihoDaicho.get資格変更事由コード())
                ? RString.EMPTY
                : ShikakuHenkoJiyu.toValue(hihoDaicho.get資格変更事由コード()).get名称());
        row.setHenkoJiyuKey(hihoDaicho.get住所地特例適用事由コード());
        row.setShozaiHokensha(hihoDaicho.get市町村コード() == null
                ? RString.EMPTY
                : hihoDaicho.get市町村コード().getColumnValue());
        row.setSochimotoHokensha(hihoDaicho.get広住特措置元市町村コード() == null
                ? RString.EMPTY
                : hihoDaicho.get広住特措置元市町村コード().getColumnValue());
        row.setKyuHokensha(hihoDaicho.get旧市町村コード() == null
                ? RString.EMPTY
                : hihoDaicho.get旧市町村コード().getColumnValue());
        row.getShoriDate().setValue(hihoDaicho.toEntity() == null || hihoDaicho.toEntity().getLastUpdateTimestamp() == null
                ? null
                : new FlexibleDate(hihoDaicho.toEntity().getLastUpdateTimestamp().getDate().toDateString()));
        row.getIdoYMD().setValue(hihoDaicho.get異動日() == null
                ? null
                : hihoDaicho.get異動日());
        row.setEdaNo(hihoDaicho.get枝番());
        return row;
    }

    /*
     private TextBoxFlexibleDate henkoDate;
     private TextBoxFlexibleDate henkoTodokedeDate;
     private RString henkoJiyu;
     private RString henkoJiyuKey;
     */
    private static boolean nullOrEmpty(RString r) {
        return r == null || r.isEmpty();
    }

}
