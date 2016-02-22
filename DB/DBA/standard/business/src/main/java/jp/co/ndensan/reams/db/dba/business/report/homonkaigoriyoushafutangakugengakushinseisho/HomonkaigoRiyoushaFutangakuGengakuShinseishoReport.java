/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.homonkaigoriyoushafutangakugengakushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.homonkaigoriyoushafutangakugengakushinseisho.HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 訪問介護利用者負担額減額申請書の帳票作成します。
 *
 */
public final class HomonkaigoRiyoushaFutangakuGengakuShinseishoReport extends Report<HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource> {

    private final HomonkaigoRiyoushaFutangakuGengakuShinseishoItem item;

    private HomonkaigoRiyoushaFutangakuGengakuShinseishoReport(HomonkaigoRiyoushaFutangakuGengakuShinseishoItem item) {
        this.item = item;
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 訪問介護利用者負担額減額申請書Entityリスト
     * @return HomonkaigoRiyoushaFutangakuGengakuShinseishoReport
     */
    public static HomonkaigoRiyoushaFutangakuGengakuShinseishoReport createReport(@NonNull HomonkaigoRiyoushaFutangakuGengakuShinseishoItem item) {
        return new HomonkaigoRiyoushaFutangakuGengakuShinseishoReport(item);
    }

    /**
     * 訪問介護利用者負担額減額申請書writeByします。
     *
     * @param writer 訪問介護利用者負担額減額申請書_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<HomonKaigoRiyoshaFutangakuGengakuShinseishoReportSource> writer) {
        IHomonkaigoRiyoushaFutangakuGengakuShinseishoEditor joho = new HomonkaigoRiyoushaFutangakuGengakuShinseishoEditorImpl(item);
        IHomonkaigoRiyoushaFutangakuGengakuShinseishoBuilder builder = new HomonkaigoRiyoushaFutangakuGengakuShinseishoBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
