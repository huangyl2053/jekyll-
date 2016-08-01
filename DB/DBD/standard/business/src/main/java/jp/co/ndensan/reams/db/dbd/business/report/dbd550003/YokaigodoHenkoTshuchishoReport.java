/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550003;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.YokaigodoHenkoTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550003.YokaigodoHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護度変更通知書のReportです。
 *
 * @reamsid_L DBD-1430-050 b_zhengs
 */
public final class YokaigodoHenkoTshuchishoReport extends Report<YokaigodoHenkoTshuchishoReportSource> {

    private final YokaigodoHenkoTsuchishoEntity entity;
    private final List<RString> 通知書定型文リスト;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護度変更通知書
     * @param 通知書定型文リスト List
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param ninshoshaSource NinshoshaSource
     */
    public YokaigodoHenkoTshuchishoReport(YokaigodoHenkoTsuchishoEntity entity,
            List<RString> 通知書定型文リスト,
            ChohyoSeigyoKyotsu 帳票制御共通,
            NinshoshaSource ninshoshaSource) {
        this.entity = entity;
        this.通知書定型文リスト = 通知書定型文リスト;
        this.帳票制御共通 = 帳票制御共通;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigodoHenkoTshuchishoReportSource> writer) {
        IYokaigodoHenkoTshuchishoEditor bodyEditor = new YokaigodoHenkoTshuchishoBodyEditor(entity,
                通知書定型文リスト,
                帳票制御共通,
                ninshoshaSource);
        IYokaigodoHenkoTshuchishoBuilder builder = new YokaigodoHenkoTshuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
