/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsushunoritsuichiran;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu.DankaibetsuShunoritsuIchiran;
import jp.co.ndensan.reams.db.dbb.entity.report.dankaibetsushunoritsu.ShotokuDankaiBetsuShunoritsuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料段階別収納率一覧表Reportのクラスです。
 *
 * @reamsid_L DBB-1630-040 tianshuai
 */
public class ShotokuDankaiBetsuShunoritsuIchiranReport extends Report<ShotokuDankaiBetsuShunoritsuIchiranSource> {

    private final DankaibetsuShunoritsuIchiran 保険料段階別収納率一覧表パラメータ;

    /**
     * コンストラクタです
     *
     * @param 保険料段階別収納率一覧表パラメータ DankaibetsuShunoritsuIchiran
     */
    public ShotokuDankaiBetsuShunoritsuIchiranReport(DankaibetsuShunoritsuIchiran 保険料段階別収納率一覧表パラメータ) {
        this.保険料段階別収納率一覧表パラメータ = 保険料段階別収納率一覧表パラメータ;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShotokuDankaiBetsuShunoritsuIchiranSource> reportSourceWriter) {
        IShotokuDankaiBetsuShunoritsuIchiranEditor editor = new ShotokuDankaiBetsuShunoritsuIchiranEditor(保険料段階別収納率一覧表パラメータ);
        IShotokuDankaiBetsuShunoritsuIchiranBuilder builder = new ShotokuDankaiBetsuShunoritsuIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
