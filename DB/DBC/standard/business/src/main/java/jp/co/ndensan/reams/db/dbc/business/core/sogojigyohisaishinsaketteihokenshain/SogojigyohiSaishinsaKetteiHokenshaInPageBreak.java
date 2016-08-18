/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.sogojigyohisaishinsaketteihokenshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.report.source.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 総合事業費再審査決定通知書情報取込一覧表PageBreakクラスです。
 *
 * @reamsid_L DBC-4680-040 wangxue
 */
public class SogojigyohiSaishinsaKetteiHokenshaInPageBreak
        extends PageBreaker<SogojigyohiSaishinsaKetteiHokenshaInSource> {

    private final List<RString> breakKeysList;

    /**
     *
     * @param breakKeys List<RString>
     */
    public SogojigyohiSaishinsaKetteiHokenshaInPageBreak(List<RString> breakKeys) {
        this.breakKeysList = breakKeys;
    }

    @Override
    public List<RString> breakKeys() {
        return breakKeysList;
    }

    @Override
    public boolean isBreak(ReportLineRecord<SogojigyohiSaishinsaKetteiHokenshaInSource> currentSource,
            ReportLineRecord<SogojigyohiSaishinsaKetteiHokenshaInSource> nextSource) {
        boolean flg = false;
        if (this.breakKeysList.contains(SogojigyohiSaishinsaKetteiHokenshaInOutPutOrder.証記載保険者番号.get項目ID())
                && !currentSource.getSource().shoKisaiHokenshaNo.equals(nextSource.getSource().shoKisaiHokenshaNo)) {
            flg = true;
        }
        return flg;
    }
}
