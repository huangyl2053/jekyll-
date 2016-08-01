/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd532001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.NinteiKekkaTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd532001.YokaigoNinteiKekkaTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 要介護認定結果通知書のReportです。
 *
 * @reamsid_L DBD-1430-030 b_zhengs
 */
public final class YokaigoNinteiKekkaTshuchishoReport extends Report<YokaigoNinteiKekkaTshuchishoReportSource> {

    private final NinteiKekkaTsuchishoEntity entity;
    private final List<RString> 通知書定型文リスト;
    private final ChohyoSeigyoKyotsu 帳票制御共通;

    /**
     * インスタンスを生成します。
     *
     * @param entity 要介護認定結果通知書
     * @param 通知書定型文リスト List
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @return 要介護認定結果通知書
     */
    public static YokaigoNinteiKekkaTshuchishoReport createReport(@NonNull NinteiKekkaTsuchishoEntity entity,
            List<RString> 通知書定型文リスト,
            ChohyoSeigyoKyotsu 帳票制御共通) {
        return new YokaigoNinteiKekkaTshuchishoReport(entity,
                通知書定型文リスト,
                帳票制御共通);

    }

    private YokaigoNinteiKekkaTshuchishoReport(NinteiKekkaTsuchishoEntity entity,
            List<RString> 通知書定型文リスト,
            ChohyoSeigyoKyotsu 帳票制御共通) {
        this.entity = entity;
        this.通知書定型文リスト = 通知書定型文リスト;
        this.帳票制御共通 = 帳票制御共通;
    }

    @Override
    public void writeBy(ReportSourceWriter<YokaigoNinteiKekkaTshuchishoReportSource> writer) {
        IYokaigoNinteiKekkaTshuchishoEditor bodyEditor = new YokaigoNinteiKekkaTshuchishoBodyEditor(entity,
                通知書定型文リスト,
                帳票制御共通);
        IYokaigoNinteiKekkaTshuchishoBuilder builder = new YokaigoNinteiKekkaTshuchishoBuilderImpl(bodyEditor);
        writer.writeLine(builder);
    }

}
