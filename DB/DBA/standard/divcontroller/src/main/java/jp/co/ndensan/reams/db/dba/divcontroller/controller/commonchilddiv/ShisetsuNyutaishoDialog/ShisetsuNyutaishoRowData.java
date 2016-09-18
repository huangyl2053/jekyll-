/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.ShisetsuNyutaishoDialog;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.dgShisetsuNyutaishoRireki_Row;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設入退所履歴のグリッドデータを保持するためのクラスです。
 *
 * @author n8178
 */
public class ShisetsuNyutaishoRowData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final RString state;
    private final FlexibleDate nyushoDate;
    private final FlexibleDate taishoDate;
    private final RString shisetsuCode;
    private final RString shisetsuMeisho;
    private final RString shisetsu;
    private final RString daichoShubetsuKey;
    private final RString daichoShubetsu;
    private final RString shisetsuShuruiKey;
    private final RString shisetsuShurui;
    private final RString rirekiNo;

    public ShisetsuNyutaishoRowData(dgShisetsuNyutaishoRireki_Row row) {
        state = row.getState();
        nyushoDate = row.getNyushoDate().getValue();
        taishoDate = row.getTaishoDate().getValue();
        shisetsuCode = row.getShisetsuCode();
        shisetsuMeisho = row.getShisetsuMeisho();
        shisetsu = row.getShisetsu();
        daichoShubetsuKey = row.getDaichoShubetsuKey();
        daichoShubetsu = row.getDaichoShubetsu();
        shisetsuShuruiKey = row.getShisetsuShuruiKey();
        shisetsuShurui = row.getShisetsuShurui();
        rirekiNo = row.getRirekiNo();
    }

    public static dgShisetsuNyutaishoRireki_Row toRow(ShisetsuNyutaishoRowData rowData) {
        dgShisetsuNyutaishoRireki_Row row = new dgShisetsuNyutaishoRireki_Row();
        row.setState(rowData.state);
        row.getNyushoDate().setValue(rowData.nyushoDate);
        row.getTaishoDate().setValue(rowData.taishoDate);
        row.setShisetsuCode(rowData.shisetsuCode);
        row.setShisetsuMeisho(rowData.shisetsuMeisho);
        row.setShisetsu(rowData.shisetsu);
        row.setDaichoShubetsuKey(rowData.daichoShubetsuKey);
        row.setDaichoShubetsu(rowData.daichoShubetsu);
        row.setShisetsuShuruiKey(rowData.shisetsuShuruiKey);
        row.setShisetsuShurui(rowData.shisetsuShurui);
        row.setRirekiNo(rowData.rirekiNo);
        return row;
    }
}
