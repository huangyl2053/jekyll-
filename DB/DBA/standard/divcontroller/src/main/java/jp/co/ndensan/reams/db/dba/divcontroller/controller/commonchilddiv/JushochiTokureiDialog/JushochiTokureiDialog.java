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
import jp.co.ndensan.reams.db.dbz.definition.core.ViewExecutionStatus;
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

        HihokenshaNo hihoNo = new HihokenshaNo(div.getHihokenshaNo());
        RString mode = div.getMode();
        FlexibleDate shutokuDate = FlexibleDate.EMPTY;
        if (!isShutokuDateEmpty(div)) {
            shutokuDate = new FlexibleDate(div.getShutokuDate());
        }
        setMode(div, mode);

        if (!isGridDataEmpty(div)) {
            ArrayList<HihokenshaDaicho> serialHihoData = DataPassingConverter.deserialize(div.getGridData(), ArrayList.class);
            IItemList<HihokenshaDaicho> hihoData = ItemList.of(serialHihoData);
            hihoData = new HihokenshaDaichoList(hihoData).to住所地特例List();
            initialize(hihoNo, hihoData, div);
        } else if (!isHihoDataEmpty(div)) {
            ArrayList<HihokenshaDaicho> serialHihoData = DataPassingConverter.deserialize(div.getHihoData(), ArrayList.class);
            IItemList<HihokenshaDaicho> hihoData = ItemList.of(serialHihoData);
            if (!shutokuDate.isEmpty()) {
                hihoData = new HihokenshaDaichoList(hihoData).toOneSeasonList(shutokuDate);
                hihoData = new HihokenshaDaichoList(hihoData).to住所地特例List();
            } else {
                hihoData = ItemList.empty();
            }
            initialize(hihoNo, hihoData, div);
        }
        return ResponseData.of(div).respond();

    }

    private void initialize(HihokenshaNo hihoNo, IItemList<HihokenshaDaicho> hihoData, JushochiTokureiDialogDiv div) {
        List<dgJutoku_Row> dataSource = new ArrayList<>();
        HihokenshaDaicho kaijoHihoData = null;
        for (HihokenshaDaicho hihoDaicho : hihoData) {
            if (hihoDaicho.get住所地特例解除事由コード() != null && !hihoDaicho.get住所地特例解除事由コード().isEmpty()) {
                kaijoHihoData = hihoDaicho;
                continue;
            }
            dgJutoku_Row row = toRow(hihoNo, hihoDaicho, kaijoHihoData);
            dataSource.add(row);
        }
        div.getCcdJushochiTokureiRireki().initialize(dataSource);
    }

    private boolean isHiddenInputEmpty(JushochiTokureiDialogDiv div) {
        if (div.getMode() == null || div.getMode().isEmpty()) {
            return false;
        }
        return (div.getHihokenshaNo() == null || div.getHihokenshaNo().isEmpty());
    }

    private boolean isShutokuDateEmpty(JushochiTokureiDialogDiv div) {
        return (div.getShutokuDate() == null || div.getShutokuDate().isEmpty());
    }

    private boolean isHihoDataEmpty(JushochiTokureiDialogDiv div) {
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
            div.getCcdJushochiTokureiRireki().setMeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.teiseiShokai);
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

        HihokenshaNo hihoNo = new HihokenshaNo(div.getHihokenshaNo());
        ArrayList<HihokenshaDaicho> gridDataList = new ArrayList<>();
        gridDataList.addAll(div.getCcdJushochiTokureiRireki().getDataList());
        if (!gridDataList.isEmpty()) {
            gridDataList = setHihokenshaNoAsList(hihoNo, gridDataList);
            RString serialSaveDataList = DataPassingConverter.serialize(gridDataList);
            div.setGridData(serialSaveDataList);
        }

        ArrayList<HihokenshaDaicho> saveDataList = new ArrayList<>();
        saveDataList.addAll(div.getCcdJushochiTokureiRireki().getDataList());
        if (!saveDataList.isEmpty()) {
            saveDataList = setHihokenshaNoAsList(hihoNo, saveDataList);
            RString serialSaveDataList = DataPassingConverter.serialize(saveDataList);
            div.setHihoData(serialSaveDataList);
        }
        return ResponseData.of(div).respond();
    }

    private ArrayList<HihokenshaDaicho> setHihokenshaNoAsList(HihokenshaNo hihoNo, ArrayList<HihokenshaDaicho> daichoList) {
        ArrayList<HihokenshaDaicho> retList = new ArrayList<>();
        for (HihokenshaDaicho daicho : daichoList) {
            if (daicho.get被保険者番号() == null || daicho.get被保険者番号().isEmpty()) {
                retList.add(daicho.createBuilderForEdit().set被保険者番号(hihoNo).build());
            } else {
                retList.add(daicho);
            }
        }
        return retList;
    }

    /**
     * 引数を元にグリッドに設定可能なデータを用意します。
     *
     * @param hihoDaicho グリッドの元になる、被保険者台帳情報
     * @return 住所地特例のグリッドに設定可能なデータ
     */
    private static dgJutoku_Row toRow(HihokenshaNo hihoNo, HihokenshaDaicho hihoDaicho, HihokenshaDaicho kaijoHihoData) {
        dgJutoku_Row row = new dgJutoku_Row();
        row.setState(ViewExecutionStatus.toValue(new RString(hihoDaicho.toEntity().getState().name())).get名称());
        row.setShichosonCode(hihoDaicho.get市町村コード() == null
                ? RString.EMPTY
                : hihoDaicho.get市町村コード().getColumnValue());
        row.setHihokenshaNo(hihoDaicho.get被保険者番号() == null
                ? hihoNo.getColumnValue()
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
                : hihoDaicho.get異動日());
        row.setEdaNo(hihoDaicho.get枝番());

        if (kaijoHihoData != null) {
            row.getKaijoDate().setValue(kaijoHihoData.get解除年月日());
            row.getKaijoTodokedeDate().setValue(kaijoHihoData.get解除届出年月日());
            row.setKaijoJiyu(nullOrEmpty(kaijoHihoData.get住所地特例解除事由コード())
                    ? RString.EMPTY
                    : ShikakuJutokuKaijoJiyu.toValue(kaijoHihoData.get住所地特例解除事由コード()).get名称());
            row.setKaijoJiyuKey(kaijoHihoData.get住所地特例解除事由コード());

            row.getKaijoIdoYMD().setValue(kaijoHihoData.get異動日() == null
                    ? null
                    : kaijoHihoData.get異動日());
            row.setKaijoEdaNo(kaijoHihoData.get枝番());
        }
        return row;
    }

    private static boolean nullOrEmpty(RString r) {
        return r == null || r.isEmpty();
    }

}
