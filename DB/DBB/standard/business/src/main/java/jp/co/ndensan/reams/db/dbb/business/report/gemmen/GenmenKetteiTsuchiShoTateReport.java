/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmen;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.gemmen.KaigoHokenryoGenmenKetteiTsuchishoTateSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 介護保険料減免決定通知書 A4縦タイプReportクラスです。
 *
 * @reamsid_L DBB-0740-030 surun
 */
public class GenmenKetteiTsuchiShoTateReport extends Report<KaigoHokenryoGenmenKetteiTsuchishoTateSource> {

    private final List<GenmenKetteiTsuchiShoItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<GenmenKetteiTsuchiShoItem>
     */
    protected GenmenKetteiTsuchiShoTateReport(List<GenmenKetteiTsuchiShoItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッドです。
     *
     * @param items List<GenmenKetteiTsuchiShoItem>
     * @return GenmenKetteiTsuchiShoTateReport
     */
    public static GenmenKetteiTsuchiShoTateReport createForm(@NonNull List<GenmenKetteiTsuchiShoItem> items) {
        return new GenmenKetteiTsuchiShoTateReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenryoGenmenKetteiTsuchishoTateSource> writer) {
        for (GenmenKetteiTsuchiShoItem target : targets) {
            IGenmenKetteiTsuchiShoTateEditor editor = new GenmenKetteiTsuchiShoTateEditor(target);
            IGenmenKetteiTsuchiShoTateBuilder builder = new GenmenKetteiTsuchiShoTateBuilder(editor);
            writer.writeLine(builder);
        }
    }

}
