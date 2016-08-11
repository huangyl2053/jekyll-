/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoketteitsuchiichiran.KijunShunyugakuTekiyoKetteiTsuchiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 基準収入額適用決定通知書Reportのクラスです。
 *
 * @reamsid_L DBC-4610-050 xuhao
 */
public class KijunShunyugakuTekiyoKetteiTsuchiIchiranReport extends Report<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> {

    private final KijunShunyugakuTekiyoKetteiTsuchiIchiran 基準収入額決定通知一覧表パラメータ;

    /**
     * コンストラクタです
     *
     * @param 基準収入額決定通知一覧表パラメータ KijunShunyugakuTekiyoKetteiTsuchiIchiran
     */
    public KijunShunyugakuTekiyoKetteiTsuchiIchiranReport(KijunShunyugakuTekiyoKetteiTsuchiIchiran 基準収入額決定通知一覧表パラメータ) {
        this.基準収入額決定通知一覧表パラメータ = 基準収入額決定通知一覧表パラメータ;
    }

    @Override
    public void writeBy(ReportSourceWriter<KijunShunyugakuTekiyoKetteiTsuchiIchiranSource> reportSourceWriter) {
        IKijunShunyugakuTekiyoKetteiTsuchiIchiranEditor editor
                = new KijunShunyugakuTekiyoKetteiTsuchiIchiranEditor(基準収入額決定通知一覧表パラメータ);
        IKijunShunyugakuTekiyoKetteiTsuchiIchiranBuilder builder = new KijunShunyugakuTekiyoKetteiTsuchiIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
