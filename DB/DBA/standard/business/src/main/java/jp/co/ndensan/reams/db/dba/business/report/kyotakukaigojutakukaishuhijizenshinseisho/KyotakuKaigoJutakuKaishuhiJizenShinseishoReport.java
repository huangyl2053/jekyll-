/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyotakukaigojutakukaishuhijizenshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.kyotakukaigojutakukaishuhijizenshinseisho.JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書の帳票作成します。
 *
 */
public final class KyotakuKaigoJutakuKaishuhiJizenShinseishoReport extends Report<JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource> {

    private final KyotakuKaigoJutakuKaishuhiJizenShinseishoItem item;

    private KyotakuKaigoJutakuKaishuhiJizenShinseishoReport(KyotakuKaigoJutakuKaishuhiJizenShinseishoItem item) {
        this.item = item;
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書Entityリスト
     * @return KyotakuKaigoJutakuKaishuhiJizenShinseishoReport
     */
    public static KyotakuKaigoJutakuKaishuhiJizenShinseishoReport createReport(@NonNull KyotakuKaigoJutakuKaishuhiJizenShinseishoItem item) {
        return new KyotakuKaigoJutakuKaishuhiJizenShinseishoReport(item);
    }

    /**
     * 介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書writeByします。
     *
     * @param writer 介護保険居宅介護（予防）住宅改修費事前（受領委任払）申請書_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<JutakuKaishuhiJizenShinseishoJuryoIninHaraiReportSource> writer) {
        IKyotakuKaigoJutakuKaishuhiJizenShinseishoEditor joho = new KyotakuKaigoJutakuKaishuhiJizenShinseishoEditorImpl(item);
        IKyotakuKaigoJutakuKaishuhiJizenShinseishoBuilder builder = new KyotakuKaigoJutakuKaishuhiJizenShinseishoBuilderImpl(joho);
        writer.writeLine(builder);
    }
}
