/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikohijukyusha;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikohijukyusha.SogojigyohiKohiJukyushaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 総合事業費公費受給者別一覧表帳票のPageBreakクラスです。
 *
 * @reamsid_L DBC-4710-040 chenjie
 */
public class SogojigyohiKohiJukyushaPageBreak extends PageBreaker<SogojigyohiKohiJukyushaSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys ページングキー
     */
    public SogojigyohiKohiJukyushaPageBreak(List<RString> breakKeys) {
        this.breakKeysList = Collections.unmodifiableList(breakKeys);
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SogojigyohiKohiJukyushaSource> currentSource,
            ReportLineRecord<SogojigyohiKohiJukyushaSource> nextSource) {
        boolean flag = false;
        if (this.breakKeysList.contains(SogojigyohiKohiJukyushaOutPutOrder.公費負担者番号.get項目ID())
                && !currentSource.getSource().kohiFutanshaNo.equals(nextSource.getSource().kohiFutanshaNo)) {
            flag = true;
        } else if (this.breakKeysList.contains(SogojigyohiKohiJukyushaOutPutOrder.被保険者番号.get項目ID())
                && !currentSource.getSource().listUpper_10.equals(nextSource.getSource().listUpper_10)) {
            flag = true;
        }
        return flag;

    }
}
