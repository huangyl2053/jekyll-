/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmen;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.gemmen.KaigoHokenryoGenmenKetteiTsuchishoYokoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 介護保険料減免決定通知書 B5横タイプReportクラスです。
 *
 * @reamsid_L DBB-0740-030 surun
 */
public class GenmenKetteiTsuchiShoYokoReport extends Report<KaigoHokenryoGenmenKetteiTsuchishoYokoSource> {

    private final List<GenmenKetteiTsuchiShoItem> targets;

    /**
     * コンストラクタです。
     *
     * @param targets List<GenmenKetteiTsuchiShoItem>
     */
    protected GenmenKetteiTsuchiShoYokoReport(List<GenmenKetteiTsuchiShoItem> targets) {
        this.targets = targets;
    }

    /**
     * createFormメソッドです。
     *
     * @param items List<GenmenKetteiTsuchiShoItem>
     * @return GenmenKetteiTsuchiShoYokoReport
     */
    public static GenmenKetteiTsuchiShoYokoReport createForm(@NonNull List<GenmenKetteiTsuchiShoItem> items) {
        return new GenmenKetteiTsuchiShoYokoReport(items);
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenryoGenmenKetteiTsuchishoYokoSource> writer) {
        for (GenmenKetteiTsuchiShoItem target : targets) {
            IGenmenKetteiTsuchiShoYokoEditor editor = new GenmenKetteiTsuchiShoYokoEditor(target);
            IGenmenKetteiTsuchiShoYokoBuilder builder = new GenmenKetteiTsuchiShoYokoBuilder(editor);
            writer.writeLine(builder);
        }
    }

}
