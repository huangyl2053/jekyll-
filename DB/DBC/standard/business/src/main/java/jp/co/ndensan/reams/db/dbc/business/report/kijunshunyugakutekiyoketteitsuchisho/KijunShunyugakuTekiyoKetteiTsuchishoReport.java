/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoketteitsuchisho.KijunShunyugakuTekiyoKetteiTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 基準収入額適用決定通知書Reportのクラスです。
 *
 * @reamsid_L DBC-4610-040 xuhao
 */
public class KijunShunyugakuTekiyoKetteiTsuchishoReport extends Report<KijunShunyugakuTekiyoKetteiTsuchishoSource> {

    private final KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書パラメータ;

    /**
     * コンストラクタです
     *
     * @param 基準収入額適用決定通知書パラメータ KijunShunyugakuTekiyoKetteiTsuchisho
     */
    public KijunShunyugakuTekiyoKetteiTsuchishoReport(KijunShunyugakuTekiyoKetteiTsuchisho 基準収入額適用決定通知書パラメータ) {
        this.基準収入額適用決定通知書パラメータ = 基準収入額適用決定通知書パラメータ;
    }

    @Override
    public void writeBy(ReportSourceWriter<KijunShunyugakuTekiyoKetteiTsuchishoSource> reportSourceWriter) {
        IKijunShunyugakuTekiyoKetteiTsuchishoEditor editor = new KijunShunyugakuTekiyoKetteiTsuchishoEditor(基準収入額適用決定通知書パラメータ);
        IKijunShunyugakuTekiyoKetteiTsuchishoBuilder builder = new KijunShunyugakuTekiyoKetteiTsuchishoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }

}
