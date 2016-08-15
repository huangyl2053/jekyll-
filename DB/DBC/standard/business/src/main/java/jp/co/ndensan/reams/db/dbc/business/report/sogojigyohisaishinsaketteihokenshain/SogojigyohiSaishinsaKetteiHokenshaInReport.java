/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbc.entity.db.report.source.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 総合事業費再審査決定通知書情報取込一覧表（保険者分）帳票Report
 *
 * @reamsid_L DBC-4680-040 wangxue
 */
public class SogojigyohiSaishinsaKetteiHokenshaInReport
        extends Report<SogojigyohiSaishinsaKetteiHokenshaInSource> {

    private final SogojigyohiSaishinsaKetteiHokenshaInItem item;

    /**
     * コンストラクタです。
     *
     * @param item SogojigyohiSaishinsaKetteiHokenshaInItem
     */
    public SogojigyohiSaishinsaKetteiHokenshaInReport(SogojigyohiSaishinsaKetteiHokenshaInItem item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiSaishinsaKetteiHokenshaInSource> reportSourceWriter) {

        ISogojigyohiSaishinsaKetteiHokenshaInEditor editor = new SogojigyohiSaishinsaKetteiHokenshaInEditor(item);
        ISogojigyohiSaishinsaKetteiHokenshaInBuilder builder = new SogojigyohiSaishinsaKetteiHokenshaInBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
