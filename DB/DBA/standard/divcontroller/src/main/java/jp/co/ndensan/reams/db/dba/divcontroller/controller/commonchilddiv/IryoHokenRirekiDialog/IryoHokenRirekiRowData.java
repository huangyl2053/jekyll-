/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.IryoHokenRirekiDialog;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv.dgIryohokenIchiran_Row;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 医療保険履歴グリッドのデータを、直列化可能な状態で保持するためのクラスです。
 *
 * @author n8178
 */
public class IryoHokenRirekiRowData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final RString shikibetsuCode;
    private final RString shichosonCode;
    private final RString state;
    private final FlexibleDate kanyuDate;
    private final FlexibleDate dattaiDate;
    private final RString shubetsu;
    private final RString shubetsuCode;
    private final RString hokensha;
    private final RString hokenshaCode;
    private final RString hokenshaName;
    private final RString kigoNo;
    private final Decimal rirekiNo;

    /**
     * グリッドの情報を元にシリアライズ可能なクラスを作成します。
     *
     * @param row
     */
    public IryoHokenRirekiRowData(dgIryohokenIchiran_Row row) {
        this.shikibetsuCode = row.getShikibetsuCode();
        this.shichosonCode = row.getShichosonCode();
        this.state = row.getState();
        this.kanyuDate = row.getKanyuDate().getValue();
        this.dattaiDate = row.getDattaiDate().getValue();
        this.shubetsu = row.getShubetsu();
        this.shubetsuCode = row.getShubetsuCode();
        this.hokensha = row.getHokensha();
        this.hokenshaCode = row.getHokenshaCode();
        this.hokenshaName = row.getHokenshaName();
        this.kigoNo = row.getKigoNo();
        this.rirekiNo = row.getRirekiNo().getValue();
    }

    public static dgIryohokenIchiran_Row toRow(IryoHokenRirekiRowData rowData) {
        dgIryohokenIchiran_Row row = new dgIryohokenIchiran_Row();
        row.setShikibetsuCode(rowData.shikibetsuCode);
        row.setShichosonCode(rowData.shichosonCode);
        row.setState(rowData.state);
        row.getKanyuDate().setValue(rowData.kanyuDate);
        row.getDattaiDate().setValue(rowData.dattaiDate);
        row.setShubetsu(rowData.shubetsu);
        row.setShubetsuCode(rowData.shubetsuCode);
        row.setHokensha(rowData.hokensha);
        row.setHokenshaCode(rowData.hokenshaCode);
        row.setHokenshaName(rowData.hokenshaName);
        row.setKigoNo(rowData.kigoNo);
        row.getRirekiNo().setValue(rowData.rirekiNo);
        return row;
    }
}
