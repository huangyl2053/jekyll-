/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.ShikakuHenkoRirekiDialog;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShikakuHenkoRirekiDialog.ShikakuHenkoRirekiDialogDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho.HihokenshaDaichoList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki.ShikakuTokusoRirekiDiv.DisplayType;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.ShikakuHenkoState;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
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
            div.getCcdShikakuHenkoRireki().initialize(ShikibetsuCode.EMPTY, ItemList.<HihokenshaDaicho>empty());
            setMode(div, ShikakuHenkoState.照会.getStateValue());
        }

        RString mode = div.getMode();
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(div.getShikibetsuCode());
        FlexibleDate shutokuDate = FlexibleDate.EMPTY;
        if (!isShutokuDateEmpty(div)) {
            shutokuDate = new FlexibleDate(div.getShutokuDate());
        }

        setMode(div, mode);

        if (!isGridDataEmpty(div)) {
            ArrayList<HihokenshaDaicho> serialHihoData = (ArrayList<HihokenshaDaicho>) DataPassingConverter
                    .deserialize(div.getGridData(), ArrayList.class);
            IItemList<HihokenshaDaicho> hihoData = ItemList.of(serialHihoData);
            hihoData = new HihokenshaDaichoList(hihoData).to資格関連異動List();

            div.getCcdShikakuHenkoRireki().initialize(shikibetsuCode, hihoData);
        } else if (!isHihoDataEmpty(div)) {
            ArrayList<HihokenshaDaicho> serialHihoData = DataPassingConverter.deserialize(div.getHihoData(), ArrayList.class);
            IItemList<HihokenshaDaicho> hihoData = ItemList.of(serialHihoData);
            if (!shutokuDate.isEmpty()) {
                hihoData = new HihokenshaDaichoList(hihoData).toOneSeasonList(shutokuDate);
                hihoData = new HihokenshaDaichoList(hihoData).to資格関連異動List();
            } else {
                hihoData = ItemList.empty();
            }

            div.getCcdShikakuHenkoRireki().initialize(shikibetsuCode, hihoData);
        }
        return ResponseData.of(div).respond();
    }

    private boolean isHiddenInputEmpty(ShikakuHenkoRirekiDialogDiv div) {
        if (div.getMode() == null || div.getMode().isEmpty()) {
            return true;
        }
        if (div.getHihokenshaNo() == null || div.getHihokenshaNo().isEmpty()) {
            return true;
        }
        return (div.getShikibetsuCode() == null || div.getShikibetsuCode().isEmpty());
    }

    private boolean isShutokuDateEmpty(ShikakuHenkoRirekiDialogDiv div) {
        return (div.getShutokuDate() == null || div.getShutokuDate().isEmpty());
    }

    private boolean isHihoDataEmpty(ShikakuHenkoRirekiDialogDiv div) {
        return div.getHihoData() == null || div.getHihoData().isEmpty();
    }

    private boolean isGridDataEmpty(ShikakuHenkoRirekiDialogDiv div) {
        return div.getGridData() == null || div.getGridData().isEmpty();
    }

    private void setMode(ShikakuHenkoRirekiDialogDiv div, RString mode) {
        if (ShikakuHenkoState.照会.getStateValue().equals(mode)) {
            div.getCcdShikakuHenkoRireki().setDisplayTypeBykey(new RString(DisplayType.shokai.name()));
            div.getCcdShikakuHenkoRireki().setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.setDisplayNone);
        } else if (ShikakuHenkoState.登録.getStateValue().equals(mode)) {
            div.getCcdShikakuHenkoRireki().setDisplayTypeBykey(new RString(DisplayType.teiseitoroku.name()));
            div.getCcdShikakuHenkoRireki().setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.shokai);
        }
    }

    /**
     * 閉じるBTNをクリックした際の処理を行います。
     *
     * @param div 資格変更履歴DialogDiv
     * @return レスポンスデータ
     */
    public ResponseData<ShikakuHenkoRirekiDialogDiv> onClick_btnClose(ShikakuHenkoRirekiDialogDiv div) {

        HihokenshaNo hihoNo = new HihokenshaNo(div.getHihokenshaNo());
        SearchResult<HihokenshaDaicho> gridDataList = div.getCcdShikakuHenkoRireki().getGridDataFor資格詳細異動();

        if (gridDataList != null && !gridDataList.records().isEmpty()) {
            ArrayList<HihokenshaDaicho> arrayData = new ArrayList<>();
            arrayData.addAll(gridDataList.records());
            arrayData = setHihokenshaNoAsList(hihoNo, arrayData);
            RString serialSaveDataList = DataPassingConverter.serialize(arrayData);
            div.setGridData(serialSaveDataList);
        }
        SearchResult<HihokenshaDaicho> saveDataList = div.getCcdShikakuHenkoRireki().getGridDataFor資格詳細異動();
        if (saveDataList != null && !saveDataList.records().isEmpty()) {
            ArrayList<HihokenshaDaicho> arrayData = new ArrayList<>();
            arrayData.addAll(saveDataList.records());
            arrayData = setHihokenshaNoAsList(hihoNo, arrayData);
            RString serialSaveDataList = DataPassingConverter.serialize(arrayData);
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

}
