/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】CoverのReportです。
 *
 * @reamsid_L DBB-9110-050 huangh
 */
public class KarisanteiNonyuTsuchishoCVSMultiReport extends Report<KarisanteiNonyuTsuchishoCVSMultiSource> {

    private final KariSanteiNonyuTsuchiShoJoho item;
    private final NinshoshaSource ninshoshaSource;
    private final ReportId coverReportId = new ReportId("DBB100026_KarisanteiNonyuTsuchishoCVSMulti");
    private final ReportId nenchoReportId = new ReportId("DBB100027_KarisanteiNonyuTsuchishoCVSMultiRencho");
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】のITEM
     * @param ninshoshaSource NinshoshaSource
     * @return 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】CoverのReport
     */
    public static KarisanteiNonyuTsuchishoCVSMultiReport createFrom(
            KariSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource) {
        return new KarisanteiNonyuTsuchishoCVSMultiReport(item, ninshoshaSource);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】のITEM
     * @param ninshoshaSource NinshoshaSource
     */
    public KarisanteiNonyuTsuchishoCVSMultiReport(
            KariSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource) {

        this.item = item;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiSource> reportSourceWriter) {

        boolean 作成フラグ = true;

        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : item.get納入通知書期情報リスト()) {
            if (Integer.valueOf(納入通知書期情報.get納付書納付額欄().toString()) > 0) {
                作成フラグ = false;
                break;
            }
        }
        if (!作成フラグ) {
            if (coverReportId.equals(item.get帳票ID())) {
                this.writeLineForCover(reportSourceWriter);

            } else if (nenchoReportId.equals(item.get帳票ID())) {
                this.writeLineForRencho(reportSourceWriter);
            }
        }
    }

    private void writeLineForCover(ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiSource> reportSourceWriter) {

        if (item.get編集後仮算定通知書共通情報() != null
                && item.get編集後仮算定通知書共通情報().get更正後() != null
                && item.get仮算定納入通知書制御情報() != null
                && item.get仮算定納入通知書制御情報().get納入通知書制御情報() != null
                && KozaKubun.口座振替.equals(item.get編集後仮算定通知書共通情報().get更正後().get更正後口座区分())
                && HyojiUmu.表示しない.equals(item.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {

            IKarisanteiNonyuTsuchishoCVSMultiCoverEditor coverEditor
                    = new KarisanteiNonyuTsuchishoCVSMultiCoverEditor(item, ninshoshaSource, 1);
            IKarisanteiNonyuTsuchishoCVSMultiCoverBuilder builder
                    = new KarisanteiNonyuTsuchishoCVSMultiCoverBuilder(coverEditor);
            reportSourceWriter.writeLine(builder);
            return;
        }

        IKarisanteiNonyuTsuchishoCVSMultiCoverEditor coverEditor
                = new KarisanteiNonyuTsuchishoCVSMultiCoverEditor(item, ninshoshaSource, 1);
        IKarisanteiNonyuTsuchishoCVSMultiCoverBuilder builder
                = new KarisanteiNonyuTsuchishoCVSMultiCoverBuilder(coverEditor);
        reportSourceWriter.writeLine(builder);

        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = item.get納入通知書期情報リスト();
        Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map1 = new HashMap<>();
        Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map2 = new HashMap<>();
        Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map3 = new HashMap<>();

        this.納入通知書期情報Map作成ForCover(納入通知書期情報リスト, 納入通知書期情報Map1, 納入通知書期情報Map2, 納入通知書期情報Map3);

        if (!納入通知書期情報Map1.isEmpty()) {
            IKarisanteiNonyuTsuchishoCVSMultiNofushoEditor nofushoEditor
                    = new KarisanteiNonyuTsuchishoCVSMultiNofushoEditor(item, 納入通知書期情報Map1);
            IKarisanteiNonyuTsuchishoCVSMultiNofushoBuilder nofushoBuilder
                    = new KarisanteiNonyuTsuchishoCVSMultiNofushoBuilder(nofushoEditor);
            reportSourceWriter.writeLine(nofushoBuilder);
        }

        if (!納入通知書期情報Map2.isEmpty()) {
            IKarisanteiNonyuTsuchishoCVSMultiNofushoEditor nofushoEditor
                    = new KarisanteiNonyuTsuchishoCVSMultiNofushoEditor(item, 納入通知書期情報Map2);
            IKarisanteiNonyuTsuchishoCVSMultiNofushoBuilder nofushoBuilder
                    = new KarisanteiNonyuTsuchishoCVSMultiNofushoBuilder(nofushoEditor);
            reportSourceWriter.writeLine(nofushoBuilder);
        }

        if (!納入通知書期情報Map3.isEmpty()) {
            IKarisanteiNonyuTsuchishoCVSMultiNofushoEditor nofushoEditor
                    = new KarisanteiNonyuTsuchishoCVSMultiNofushoEditor(item, 納入通知書期情報Map3);
            IKarisanteiNonyuTsuchishoCVSMultiNofushoBuilder nofushoBuilder
                    = new KarisanteiNonyuTsuchishoCVSMultiNofushoBuilder(nofushoEditor);
            reportSourceWriter.writeLine(nofushoBuilder);
        }

    }

    private void writeLineForRencho(ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiSource> reportSourceWriter) {

        if (item.get編集後仮算定通知書共通情報() != null
                && item.get編集後仮算定通知書共通情報().get更正後() != null
                && item.get仮算定納入通知書制御情報() != null
                && item.get仮算定納入通知書制御情報().get納入通知書制御情報() != null
                && KozaKubun.口座振替.equals(item.get編集後仮算定通知書共通情報().get更正後().get更正後口座区分())
                && HyojiUmu.表示しない.equals(item.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {
            IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor renchoCoverEditor
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor(item, ninshoshaSource, 1);
            IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder builder
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder(renchoCoverEditor);
            reportSourceWriter.writeLine(builder);
            return;
        }

        IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor renchoCoverEditor
                = new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor(item, ninshoshaSource, 1);
        IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder builder
                = new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder(renchoCoverEditor);
        reportSourceWriter.writeLine(builder);

        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = item.get納入通知書期情報リスト();
        Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map1 = new HashMap<>();
        Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map2 = new HashMap<>();

        this.納入通知書期情報Map作成ForRencho(納入通知書期情報リスト, 納入通知書期情報Map1, 納入通知書期情報Map2);

        if (!納入通知書期情報Map1.isEmpty()) {
            IKarisanteiNonyuTsuchishoCVSMultiRenchoNofushoEditor renchoNofushoEditor
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoEditor(item, 納入通知書期情報Map1);
            IKarisanteiNonyuTsuchishoCVSMultiRenchoNofushoBuilder renchoNofushoBuilder
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoBuilder(renchoNofushoEditor);
            reportSourceWriter.writeLine(renchoNofushoBuilder);
        }

        if (!納入通知書期情報Map2.isEmpty()) {
            IKarisanteiNonyuTsuchishoCVSMultiRenchoNofushoEditor renchoNofushoEditor
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoEditor(item, 納入通知書期情報Map2);
            IKarisanteiNonyuTsuchishoCVSMultiRenchoNofushoBuilder renchoNofushoBuilder
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoNofushoBuilder(renchoNofushoEditor);
            reportSourceWriter.writeLine(renchoNofushoBuilder);
        }
    }

    private void 納入通知書期情報Map作成ForCover(
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map1,
            Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map2,
            Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map3) {

        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {

            if (納入通知書期情報.getコンビニカット印字位置() == 2) {
                納入通知書期情報Map1.put(2, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_3) {
                納入通知書期情報Map1.put(INT_3, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_4) {
                納入通知書期情報Map1.put(INT_4, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_5) {
                納入通知書期情報Map2.put(INT_5, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_6) {
                納入通知書期情報Map2.put(INT_6, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_7) {
                納入通知書期情報Map2.put(INT_7, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_8) {
                納入通知書期情報Map3.put(INT_8, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_9) {
                納入通知書期情報Map3.put(INT_9, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_10) {
                納入通知書期情報Map3.put(INT_10, 納入通知書期情報);
            }
        }
    }

    private void 納入通知書期情報Map作成ForRencho(
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map1,
            Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map2) {

        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {

            if (納入通知書期情報.getコンビニ連帳印字位置() == INT_3) {
                納入通知書期情報Map1.put(INT_3, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニ連帳印字位置() == INT_4) {
                納入通知書期情報Map1.put(INT_4, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニ連帳印字位置() == INT_5) {
                納入通知書期情報Map1.put(INT_5, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニ連帳印字位置() == INT_6) {
                納入通知書期情報Map1.put(INT_6, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニ連帳印字位置() == INT_7) {
                納入通知書期情報Map2.put(INT_7, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニ連帳印字位置() == INT_8) {
                納入通知書期情報Map2.put(INT_8, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニ連帳印字位置() == INT_9) {
                納入通知書期情報Map2.put(INT_9, 納入通知書期情報);
            } else if (納入通知書期情報.getコンビニ連帳印字位置() == INT_10) {
                納入通知書期情報Map2.put(INT_10, 納入通知書期情報);
            }
        }
    }
}
