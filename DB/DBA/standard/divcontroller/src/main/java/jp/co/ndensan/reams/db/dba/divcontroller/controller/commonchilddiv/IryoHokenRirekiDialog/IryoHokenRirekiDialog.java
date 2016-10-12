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
import jp.co.ndensan.reams.db.dbz.definition.core.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.IryoHokenRirekiState;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.dgIryohokenIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 医療保険履歴ダイアログのイベントを定義しています。
 *
 * @author n8178 城間篤人
 */
public class IryoHokenRirekiDialog {

    /**
     * ダイアログを開いた際の初期化処理を行います。
     *
     * @param div 医療保険履歴DialogDiv
     * @return レスポンスデータ
     */
    public ResponseData<IryoHokenRirekiDialogDiv> onLoad(IryoHokenRirekiDialogDiv div) {
        if (isHiddenInputEmpty(div)) {
            div.getCcdIryoHokenRireki().initialize(IryoHokenRirekiState.照会.getStateValue(), RString.EMPTY, HihokenshaNo.EMPTY);
        }

        HihokenshaNo hihokenshaNo = new HihokenshaNo(div.getHihokenshaNo());
        RString mode = div.getMode();
        RString shikibetsuCode = div.getShikibetsuCode();
        LasdecCode lasdecCode = new LasdecCode(div.getLasdecCode());

        if (isSaveDataEmpty(div)) {
            div.getCcdIryoHokenRireki().initialize(mode, shikibetsuCode, hihokenshaNo, lasdecCode);
            return ResponseData.of(div).respond();
        } else {
            ArrayList<IryohokenKanyuJokyo> iryoHokenList = DataPassingConverter.deserialize(div.getSaveData(), ArrayList.class);

            List<dgIryohokenIchiran_Row> dataSource = new ArrayList<>();
            for (IryohokenKanyuJokyo iryoHoken : iryoHokenList) {
                dgIryohokenIchiran_Row row = toRow(iryoHoken);
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

    private boolean isSaveDataEmpty(IryoHokenRirekiDialogDiv div) {
        return div.getSaveData() == null || div.getSaveData().isEmpty();
    }

    /**
     * 閉じるBTNをクリックした際の処理です。
     *
     * @param div 医療保険履歴DialogDiv
     * @return レスポンスデータ
     */
    public ResponseData<IryoHokenRirekiDialogDiv> onClick_btnClose(IryoHokenRirekiDialogDiv div) {
        ArrayList<IryohokenKanyuJokyo> saveDataList = div.getCcdIryoHokenRireki().getSaveData();
        System.out.println("saveData is empty ? -> : " + saveDataList.isEmpty());
        if (!saveDataList.isEmpty()) {
            RString serialSaveDataList = DataPassingConverter.serialize(saveDataList);
            div.setSaveData(serialSaveDataList);
        }
        return ResponseData.of(div).respond();
    }

    private dgIryohokenIchiran_Row toRow(IryohokenKanyuJokyo iryoHoken) {
        dgIryohokenIchiran_Row row = new dgIryohokenIchiran_Row();
        row.setShikibetsuCode(iryoHoken.get識別コード() == null
                              ? RString.EMPTY
                              : iryoHoken.get識別コード().getColumnValue());
        row.setShichosonCode(iryoHoken.get市町村コード() == null
                             ? RString.EMPTY
                             : iryoHoken.get市町村コード().getColumnValue());
        ViewExecutionStatus status = iryoHoken.toEntity() == null
                                     ? ViewExecutionStatus.None
                                     : ViewExecutionStatus.toValue(new RString(iryoHoken.toEntity().getState().name()));
        row.setState(status.get名称());
        row.getKanyuDate().setValue(iryoHoken.get医療保険加入年月日());
        row.getDattaiDate().setValue(iryoHoken.get医療保険脱退年月日());
        row.setShubetsu(CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.医療保険種類.getCodeShubetsu(),
                new Code(iryoHoken.get医療保険種別コード()), FlexibleDate.getNowDate()));
        row.setShubetsuCode(iryoHoken.get医療保険種別コード());
        row.setHokensha(createHokenshaStr(iryoHoken.get医療保険者番号(), iryoHoken.get医療保険者名称()));
        row.setHokenshaCode(iryoHoken.get医療保険者番号());
        row.setHokenshaName(iryoHoken.get医療保険者名称());
        row.setKigoNo(iryoHoken.get医療保険記号番号());
        row.getRirekiNo().setValue(new Decimal(iryoHoken.get履歴番号()));
        return row;
    }

    private static RString createHokenshaStr(RString no, RString name) {
        RStringBuilder builder = new RStringBuilder("");
        if (no != null && no.length() != 0) {
            builder.append(no);
            builder.append(" ");
        }
        if (name != null && name.length() != 0) {
            builder.append(name);
        }
        return name;
    }
}
