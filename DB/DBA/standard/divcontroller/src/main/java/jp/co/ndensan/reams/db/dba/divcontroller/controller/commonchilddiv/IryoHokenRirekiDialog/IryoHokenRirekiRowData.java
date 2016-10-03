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
     * @param row {@link dgIryohokenIchiran_Row}
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

    /**
     * {@link dgIryohokenIchiran_Row}へ変換します。
     *
     * @return {@link dgIryohokenIchiran_Row}
     */
    public dgIryohokenIchiran_Row toRow() {
        dgIryohokenIchiran_Row row = new dgIryohokenIchiran_Row();
        row.setShikibetsuCode(this.shikibetsuCode);
        row.setShichosonCode(this.shichosonCode);
        row.setState(this.state);
        row.getKanyuDate().setValue(this.kanyuDate);
        row.getDattaiDate().setValue(this.dattaiDate);
        row.setShubetsu(this.shubetsu);
        row.setShubetsuCode(this.shubetsuCode);
        row.setHokensha(this.hokensha);
        row.setHokenshaCode(this.hokenshaCode);
        row.setHokenshaName(this.hokenshaName);
        row.setKigoNo(this.kigoNo);
        row.getRirekiNo().setValue(this.rirekiNo);
        return row;
    }
}
