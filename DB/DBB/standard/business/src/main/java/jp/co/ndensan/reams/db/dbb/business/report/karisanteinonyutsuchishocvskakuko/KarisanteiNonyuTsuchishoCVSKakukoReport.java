/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvskakuko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvskakuko.KarisanteiNonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（仮算定）【コンビニ角公タイプ】のReportです。
 *
 * @reamsid_L DBB-9110-060 huangh
 */
public class KarisanteiNonyuTsuchishoCVSKakukoReport extends Report<KarisanteiNonyuTsuchishoCVSKakukoSource> {

    private final KariSanteiNonyuTsuchiShoJoho item;
    private final ReportId coverReportId = new ReportId("DBB100026_KarisanteiNonyuTsuchishoCVSMulti");
    private final ReportId nenchoReportId = new ReportId("DBB100027_KarisanteiNonyuTsuchishoCVSMultiRencho");

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（仮算定）【コンビニ角公タイプ】のITEM
     * @return 保険料納入通知書（仮算定）【コンビニ角公タイプ】CoverのReport
     */
    public static KarisanteiNonyuTsuchishoCVSKakukoReport createFrom(
            KariSanteiNonyuTsuchiShoJoho item) {
        return new KarisanteiNonyuTsuchishoCVSKakukoReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（仮算定）【コンビニ角公タイプ】のITEM
     */
    protected KarisanteiNonyuTsuchishoCVSKakukoReport(
            KariSanteiNonyuTsuchiShoJoho item) {

        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoSource> reportSourceWriter) {

        boolean 作成フラグ = true;

        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : item.get納入通知書期情報リスト()) {
            if (Integer.valueOf(納入通知書期情報.get納付書納付額欄().toString()) > 0) {
                作成フラグ = false;
                break;
            }
        }
        if (!作成フラグ) {
            this.writeLine(reportSourceWriter);
        }
    }

    private void writeLine(ReportSourceWriter<KarisanteiNonyuTsuchishoCVSKakukoSource> reportSourceWriter) {

        if (coverReportId.equals(item.get帳票ID())) {
            if (item.get編集後仮算定通知書共通情報() != null
                    && item.get編集後仮算定通知書共通情報().get更正後() != null
                    && item.get仮算定納入通知書制御情報() != null
                    && item.get仮算定納入通知書制御情報().get納入通知書制御情報() != null
                    && KozaKubun.口座振替.equals(item.get編集後仮算定通知書共通情報().get更正後().get更正後口座区分())
                    && HyojiUmu.表示しない.equals(item.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {

                IKarisanteiNonyuTsuchishoCVSKakukoCoverEditor coverEditor
                        = new KarisanteiNonyuTsuchishoCVSKakukoCoverEditor(item);
                IKarisanteiNonyuTsuchishoCVSKakukoCoverBuilder builder
                        = new KarisanteiNonyuTsuchishoCVSKakukoCoverBuilder(coverEditor);
                reportSourceWriter.writeLine(builder);
                return;
            }

            IKarisanteiNonyuTsuchishoCVSKakukoCoverEditor coverEditor
                    = new KarisanteiNonyuTsuchishoCVSKakukoCoverEditor(item);
            IKarisanteiNonyuTsuchishoCVSKakukoCoverBuilder builder
                    = new KarisanteiNonyuTsuchishoCVSKakukoCoverBuilder(coverEditor);
            reportSourceWriter.writeLine(builder);

            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = item.get納入通知書期情報リスト();
            for (int i = 0; i < 納入通知書期情報リスト.size(); i++) {

                IKarisanteiNonyuTsuchishoCVSKakukoNofushoEditor nofushoEditor
                        = new KarisanteiNonyuTsuchishoCVSKakukoNofushoEditor(item, i);
                IKarisanteiNonyuTsuchishoCVSKakukoNofushoBuilder nofushoBuilder
                        = new KarisanteiNonyuTsuchishoCVSKakukoNofushoBuilder(nofushoEditor);
                reportSourceWriter.writeLine(nofushoBuilder);
            }

        } else if (nenchoReportId.equals(item.get帳票ID())) {
            if (item.get編集後仮算定通知書共通情報() != null
                    && item.get編集後仮算定通知書共通情報().get更正後() != null
                    && item.get仮算定納入通知書制御情報() != null
                    && item.get仮算定納入通知書制御情報().get納入通知書制御情報() != null
                    && KozaKubun.口座振替.equals(item.get編集後仮算定通知書共通情報().get更正後().get更正後口座区分())
                    && HyojiUmu.表示しない.equals(item.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {
                KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverEditor renchoCoverEditor
                        = new KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverEditor(item);
                IKarisanteiNonyuTsuchishoCVSKakukoRenchoCoverBuilder builder
                        = new KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverBuilder(renchoCoverEditor);
                reportSourceWriter.writeLine(builder);
                return;
            }

            KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverEditor renchoCoverEditor
                    = new KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverEditor(item);
            IKarisanteiNonyuTsuchishoCVSKakukoRenchoCoverBuilder builder
                    = new KarisanteiNonyuTsuchishoCVSKakukoRenchoCoverBuilder(renchoCoverEditor);
            reportSourceWriter.writeLine(builder);

            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = item.get納入通知書期情報リスト();
            for (int i = 2; i < 納入通知書期情報リスト.size(); i++) {

                IKarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoEditor renchoNofushoEditor
                        = new KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoEditor(item, i);
                IKarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoBuilder renchoNofushoBuilder
                        = new KarisanteiNonyuTsuchishoCVSKakukoRenchoNofushoBuilder(renchoNofushoEditor);
                reportSourceWriter.writeLine(renchoNofushoBuilder);
            }
        }
    }
}
