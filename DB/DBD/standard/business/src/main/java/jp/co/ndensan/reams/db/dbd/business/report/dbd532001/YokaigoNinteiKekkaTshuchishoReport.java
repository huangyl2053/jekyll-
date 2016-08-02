/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd532001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.NinteiKekkaTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd532001.YokaigoNinteiKekkaTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定結果通知書のReportです。
 *
 * @reamsid_L DBD-1430-030 b_zhengs
 */
public final class YokaigoNinteiKekkaTshuchishoReport extends Report<YokaigoNinteiKekkaTshuchishoReportSource> {

    private final NinteiKekkaTsuchishoEntity entity;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定結果通知書
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param ninshoshaSource NinshoshaSource
     */
    public YokaigoNinteiKekkaTshuchishoReport(NinteiKekkaTsuchishoEntity entity,
            ChohyoSeigyoKyotsu 帳票制御共通,
            NinshoshaSource ninshoshaSource) {
        this.entity = entity;
        this.帳票制御共通 = 帳票制御共通;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiKekkaTshuchishoReportSource> writer) {
        IYokaigoNinteiKekkaTshuchishoEditor bodyEditor = new YokaigoNinteiKekkaTshuchishoBodyEditor(entity,
                帳票制御共通,
                ninshoshaSource);
        IYokaigoNinteiKekkaTshuchishoBuilder builder = new YokaigoNinteiKekkaTshuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
