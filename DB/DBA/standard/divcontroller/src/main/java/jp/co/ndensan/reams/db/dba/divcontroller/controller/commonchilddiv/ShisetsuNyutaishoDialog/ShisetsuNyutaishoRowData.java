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

    /**
     * {@link dgShisetsuNyutaishoRireki_Row}の情報を保持したインスタンスを生成します。
     *
     * @param row {@link dgShisetsuNyutaishoRireki_Row}
     */
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

    /**
     * {@link dgShisetsuNyutaishoRireki_Row}へ変換します。
     *
     * @return {@link dgShisetsuNyutaishoRireki_Row}
     */
    public dgShisetsuNyutaishoRireki_Row toRow() {
        dgShisetsuNyutaishoRireki_Row row = new dgShisetsuNyutaishoRireki_Row();
        row.setState(this.state);
        row.getNyushoDate().setValue(this.nyushoDate);
        row.getTaishoDate().setValue(this.taishoDate);
        row.setShisetsuCode(this.shisetsuCode);
        row.setShisetsuMeisho(this.shisetsuMeisho);
        row.setShisetsu(this.shisetsu);
        row.setDaichoShubetsuKey(this.daichoShubetsuKey);
        row.setDaichoShubetsu(this.daichoShubetsu);
        row.setShisetsuShuruiKey(this.shisetsuShuruiKey);
        row.setShisetsuShurui(this.shisetsuShurui);
        row.setRirekiNo(this.rirekiNo);
        return row;
    }
}
