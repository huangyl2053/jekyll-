/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.JushochiTokureiDialog;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JushochiTokureiDialog.JushochiTokureiDialogDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.dgJutoku_Row;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 住所地特例ダイアログで実行されるイベントを定義したクラスです。
 *
 * @author n8178
 */
public class JushochiTokureiDialog {

    /**
     * 初期化処理を行います。初期化はhiddenInputのhihoDataに設定されている被保険者台帳情報を元に行います。
     * hiddenInput.hihoData に何も設定されていない場合は、グリッド上に何も設定しません。
     *
     * @param div 住所地特例ダイアログDiv
     * @return レスポンス
     */
    public ResponseData<JushochiTokureiDialogDiv> onLoad(JushochiTokureiDialogDiv div) {
        if (isHiddenInputEmpty(div)) {
            div.getCcdJushochiTokureiRireki().initialize(HihokenshaNo.EMPTY, ShikibetsuCode.EMPTY, FlexibleDate.MIN);
        }

        RString mode = div.getMode();
        FlexibleDate shutokuDate = new FlexibleDate(div.getShutokuDate());
        setMode(div, mode);

        if (isGridDataEmpty(div)) {
            ArrayList<HihokenshaDaicho> serialHihoData = DataPassingConverter.deserialize(div.getHihoData(), ArrayList.class);
            IItemList<HihokenshaDaicho> hihoData = ItemList.of(serialHihoData);
            hihoData = new HihokenshaDaichoList(hihoData).toOneSeasonList(shutokuDate);
            hihoData = new HihokenshaDaichoList(hihoData).to住所地特例List();

            List<dgJutoku_Row> dataSource = new ArrayList<>();
            for (HihokenshaDaicho hihoDaicho : hihoData) {
                dgJutoku_Row row = toRow(hihoDaicho);
                dataSource.add(row);
            }
            div.getCcdJushochiTokureiRireki().initialize(dataSource);
            return ResponseData.of(div).respond();
        } else {
//            ArrayList<JushochiTokureiRowData> dataList = DataPassingConverter.deserialize(div.getGridData(), ArrayList.class);
//            List<dgJutoku_Row> dataSource = new ArrayList<>();
//            for (JushochiTokureiRowData rowData : dataList) {
//                dgJutoku_Row row = JushochiTokureiRowData.toRow(rowData);
//                dataSource.add(row);
//            }
//            div.getCcdJushochiTokureiRireki().initialize(dataSource);
            return ResponseData.of(div).respond();
        }

    }

    private boolean isHiddenInputEmpty(JushochiTokureiDialogDiv div) {
        if (div.getMode() == null || div.getMode().isEmpty()) {
            return true;
        }
        if (div.getShutokuDate() == null || div.getShutokuDate().isEmpty()) {
            return true;
        }
        return div.getHihoData() == null || div.getHihoData().isEmpty();
    }

    private boolean isGridDataEmpty(JushochiTokureiDialogDiv div) {
        return div.getGridData() == null || div.getGridData().isEmpty();
    }

    private void setMode(JushochiTokureiDialogDiv div, RString mode) {
        if (JushochiTokureiState.照会.getStateValue().equals(mode)) {
            div.getCcdJushochiTokureiRireki().setMeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.displayNone);
            div.getCcdJushochiTokureiRireki().setDisplayType(JushochiTokureiRirekiListDiv.DisplayType.shokai);
            div.getCcdJushochiTokureiRireki().setAddButtonDisplay(JushochiTokureiRirekiListDiv.BtnDisplayMode.SetDisplayNone);
        } else if (JushochiTokureiState.登録.getStateValue().equals(mode)) {
            div.getCcdJushochiTokureiRireki().setMeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.teiseiInput);
            div.getCcdJushochiTokureiRireki().setDisplayType(JushochiTokureiRirekiListDiv.DisplayType.teiseitoroku);
            div.getCcdJushochiTokureiRireki().setAddButtonDisplay(JushochiTokureiRirekiListDiv.BtnDisplayMode.SetDisplay);
        }
    }

    /**
     * 閉じるBTNをクリックした際に発火するイベントを定義します。
     *
     * @param div 住所地特例ダイアログDiv
     * @return レスポンス
     */
    public ResponseData<JushochiTokureiDialogDiv> onClick_btnClose(JushochiTokureiDialogDiv div) {

//        ArrayList<JushochiTokureiRowData> dataList = new ArrayList<>();
//        for (dgJutoku_Row row : div.getCcdJushochiTokureiRireki().getDgJutoku().getDataSource()) {
//            dataList.add(new JushochiTokureiRowData(row));
//        }
//        RString serialDataList = DataPassingConverter.serialize(dataList);
//        div.setGridData(serialDataList);
//
//        //ここで、hiddenInput. hihoData に対して、住所地特例の修正結果を反映したデータを設定してあげる。
//        //反映は、修正・追加・削除があった場合のみ（state値に変更があったとき）
//        ArrayList<HihokenshaDaicho> saveDataList = div.getCcdJushochiTokureiRireki().getDataList();
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
    private static dgJutoku_Row toRow(HihokenshaDaicho hihoDaicho) {
        dgJutoku_Row row = new dgJutoku_Row();
        row.setState(new RString(""));
        row.setShichosonCode(hihoDaicho.get市町村コード() == null
                ? RString.EMPTY
                : hihoDaicho.get市町村コード().getColumnValue());
        row.setHihokenshaNo(hihoDaicho.get被保険者番号() == null
                ? RString.EMPTY
                : hihoDaicho.get被保険者番号().getColumnValue());
        row.setShoriTimestamp(hihoDaicho.toEntity() == null || hihoDaicho.toEntity().getLastUpdateTimestamp() == null
                ? RString.EMPTY
                : hihoDaicho.toEntity().getLastUpdateTimestamp().format西暦("yyyy.MM.dd HH:mm:ss"));
        row.getTekiyoDate().setValue(hihoDaicho.get適用年月日());
        row.getTekiyoTodokedeDate().setValue(hihoDaicho.get適用届出年月日());
        row.setTekiyoJiyu(nullOrEmpty(hihoDaicho.get住所地特例適用事由コード())
                ? RString.EMPTY
                : ShikakuJutokuTekiyoJiyu.toValue(hihoDaicho.get住所地特例適用事由コード()).get名称());
        row.setTekiyoJiyuKey(hihoDaicho.get住所地特例適用事由コード());
        row.getKaijoDate().setValue(hihoDaicho.get解除年月日());
        row.getKaijoTodokedeDate().setValue(hihoDaicho.get解除届出年月日());
        row.setKaijoJiyu(nullOrEmpty(hihoDaicho.get住所地特例解除事由コード())
                ? RString.EMPTY
                : ShikakuJutokuKaijoJiyu.toValue(hihoDaicho.get住所地特例解除事由コード()).get名称());
        row.setKaijoJiyuKey(hihoDaicho.get住所地特例解除事由コード());
        row.setSochimotoHokensha(hihoDaicho.get広住特措置元市町村コード() == null
                ? RString.EMPTY
                : hihoDaicho.get広住特措置元市町村コード().getColumnValue());
        row.setKyuHokensha(hihoDaicho.get旧市町村コード() == null
                ? RString.EMPTY
                : hihoDaicho.get旧市町村コード().getColumnValue());
        row.getShoriDate().setValue(hihoDaicho.toEntity() == null || hihoDaicho.toEntity().getLastUpdateTimestamp() == null
                ? null
                : hihoDaicho.toEntity().getLastUpdateTimestamp().getDate());
        row.getIdoYMD().setValue(hihoDaicho.get異動日() == null
                ? null
                : new RDate(hihoDaicho.get異動日().toString()));
        row.setEdaNo(hihoDaicho.get枝番());
        return row;
    }

    private static boolean nullOrEmpty(RString r) {
        return r == null || r.isEmpty();
    }
}
