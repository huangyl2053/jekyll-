/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd550001.YokaigoNinteiKyakkaTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定却下通知書のReportです。
 *
 * @reamsid_L DBD-1430-060 b_zhengs
 */
public final class YokaigoNinteiKyakkaTshuchishoReport extends Report<YokaigoNinteiKyakkaTshuchishoReportSource> {

    private final NinteikyakkaTsuchishoJoho entity;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定却下通知書
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param ninshoshaSource NinshoshaSource
     */
    public YokaigoNinteiKyakkaTshuchishoReport(NinteikyakkaTsuchishoJoho entity,
            ChohyoSeigyoKyotsu 帳票制御共通,
            NinshoshaSource ninshoshaSource) {
        this.entity = entity;
        this.帳票制御共通 = 帳票制御共通;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiKyakkaTshuchishoReportSource> writer) {
        IYokaigoNinteiKyakkaTshuchishoEditor bodyEditor = new YokaigoNinteiKyakkaTshuchishoBodyEditor(entity,
                帳票制御共通,
                ninshoshaSource);
        IYokaigoNinteiKyakkaTshuchishoBuilder builder = new YokaigoNinteiKyakkaTshuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
