/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsaketteihokenshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.saishinsaketteihokenshain.SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 再審査決定通知書情報取込一覧表帳票用Report
 *
 * @reamsid_L DBC-2520-040 chenaoqi
 */
public class SaishinsaKetteiHokenshaInReport extends Report<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> {

    private final List<SaishinsaKetteiHokenshaInItem> itemList;

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払支給（不支給）決定通知一覧表覧表のITEMリスト
     * @return 償還払支給（不支給）決定通知一覧表覧表のReport
     */
    public static SaishinsaKetteiHokenshaInReport createFrom(
            List<SaishinsaKetteiHokenshaInItem> itemList) {

        return new SaishinsaKetteiHokenshaInReport(itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param itemList 償還払支給（不支給）決定通知一覧表覧表のITEMリスト
     */
    protected SaishinsaKetteiHokenshaInReport(
            List<SaishinsaKetteiHokenshaInItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource> reportSourceWriter) {
        for (SaishinsaKetteiHokenshaInItem item : itemList) {
            ISaishinsaKetteiHokenshaInEditor editor = new SaishinsaKetteiHokenshaInEditor(item);
            ISaishinsaKetteiHokenshaInBuilder builder = new SaishinsaKetteiHokenshaInBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
