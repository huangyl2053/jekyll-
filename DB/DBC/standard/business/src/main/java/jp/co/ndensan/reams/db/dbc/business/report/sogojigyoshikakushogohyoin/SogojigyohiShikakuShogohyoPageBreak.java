/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyoshikakushogohyoin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 総合事業費資格照合表情報取込の帳票PageBreak
 *
 * @reamsid_L DBC-2890-012 wangxue
 */
public class SogojigyohiShikakuShogohyoPageBreak extends PageBreaker<SogojigyohiShikakuShogohyoInSource> {

    private static final RString 固定改頁項目 = new RString("保険者番号");
    private final List<RString> breakKeysList;

    /**
     * コンストラクタです。
     *
     * @param breakKeysList List<RString>
     */
    public SogojigyohiShikakuShogohyoPageBreak(List<RString> breakKeysList) {
        this.breakKeysList = breakKeysList;
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SogojigyohiShikakuShogohyoInSource> currentSource,
            ReportLineRecord<SogojigyohiShikakuShogohyoInSource> nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(固定改頁項目)
                && !currentSource.getSource().hokenshaNo.equals(nextSource.getSource().hokenshaNo)) {
            flg = true;
        }
        return flg;
    }

}
