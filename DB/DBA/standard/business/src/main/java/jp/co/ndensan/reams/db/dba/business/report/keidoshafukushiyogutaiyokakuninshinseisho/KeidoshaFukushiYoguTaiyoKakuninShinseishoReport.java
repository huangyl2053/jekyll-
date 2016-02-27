/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho.KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書の帳票作成します。
 *
 */
public final class KeidoshaFukushiYoguTaiyoKakuninShinseishoReport extends Report<KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource> {

    private final KeidoshaFukushiYoguTaiyoKakuninShinseishoItem item;

    private KeidoshaFukushiYoguTaiyoKakuninShinseishoReport(KeidoshaFukushiYoguTaiyoKakuninShinseishoItem item) {
        this.item = item;
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書Entityリスト
     * @return KeidoshaFukushiYoguTaiyoKakuninShinseishoReport
     */
    public static KeidoshaFukushiYoguTaiyoKakuninShinseishoReport createReport(@NonNull KeidoshaFukushiYoguTaiyoKakuninShinseishoItem item) {
        return new KeidoshaFukushiYoguTaiyoKakuninShinseishoReport(item);
    }

    /**
     * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書writeByします。
     *
     * @param writer 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource> writer) {
        IKeidoshaFukushiYoguTaiyoKakuninShinseishoEditor joho = new KeidoshaFukushiYoguTaiyoKakuninShinseishoEditorImpl(item);
        IKeidoshaFukushiYoguTaiyoKakuninShinseishoBuilder builder = new KeidoshaFukushiYoguTaiyoKakuninShinseishoBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
