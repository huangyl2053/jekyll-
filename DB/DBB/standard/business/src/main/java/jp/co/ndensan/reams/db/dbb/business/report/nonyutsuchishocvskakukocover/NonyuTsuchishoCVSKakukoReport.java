/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukocover;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukonofusho.INonyuTsuchishoCVSKakukoNofushoBuilder;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukonofusho.INonyuTsuchishoCVSKakukoNofushoEditor;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukonofusho.NonyuTsuchishoCVSKakukoNofushoBuilder;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukonofusho.NonyuTsuchishoCVSKakukoNofushoEditor;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukorenchocover.INonyuTsuchishoCVSKakukoRenchoCoverBuilder;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukorenchocover.INonyuTsuchishoCVSKakukoRenchoCoverEditor;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukorenchocover.NonyuTsuchishoCVSKakukoRenchoCoverBuilder;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukorenchocover.NonyuTsuchishoCVSKakukoRenchoCoverEditor;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukorenchonofusho.INonyuTsuchishoCVSKakukoRenchoNofushoBuilder;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukorenchonofusho.INonyuTsuchishoCVSKakukoRenchoNofushoEditor;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukorenchonofusho.NonyuTsuchishoCVSKakukoRenchoNofushoBuilder;
import jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvskakukorenchonofusho.NonyuTsuchishoCVSKakukoRenchoNofushoEditor;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvskakuko.NonyuTsuchishoCVSKakukoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【コンビニ角公タイプ】のReportです。
 *
 * @reamsid_L DBB-9110-120 huangh
 */
public class NonyuTsuchishoCVSKakukoReport extends Report<NonyuTsuchishoCVSKakukoSource> {

    private final HonSanteiNonyuTsuchiShoJoho item;
    private final NinshoshaSource ninshoshaSource;
    private final ReportId coverReportId = new ReportId("DBB100061_NonyuTsuchishoCVSMulti");
    private final ReportId nenchoReportId = new ReportId("DBB100062_NonyuTsuchishoCVSMultiRencho");
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
     * @param item 保険料納入通知書（本算定）【コンビニ角公タイプ】のITEM
     * @param ninshoshaSource NinshoshaSource
     * @return 保険料納入通知書（本算定）【コンビニ角公タイプ】のReport
     */
    public static NonyuTsuchishoCVSKakukoReport createFrom(
            HonSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource) {
        return new NonyuTsuchishoCVSKakukoReport(item, ninshoshaSource);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】のITEM
     * @param ninshoshaSource NinshoshaSource
     */
    public NonyuTsuchishoCVSKakukoReport(
            HonSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource) {

        this.item = item;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchishoCVSKakukoSource> reportSourceWriter) {

        boolean 作成フラグ = true;

        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : item.get納入通知書期情報リスト()) {
            if (Integer.valueOf(納入通知書期情報.get納付書納付額欄().toString()) > 0) {
                作成フラグ = false;
                break;
            }
        }
        if (!作成フラグ) {
            if (coverReportId.equals(item.get帳票ID())) {
                this.writeLineForFutuu(reportSourceWriter);

            } else if (nenchoReportId.equals(item.get帳票ID())) {
                this.writeLineForRencho(reportSourceWriter);
            }
        }
    }

    private void writeLineForFutuu(ReportSourceWriter<NonyuTsuchishoCVSKakukoSource> reportSourceWriter) {

        if (item.get編集後本算定通知書共通情報() != null
                && item.get編集後本算定通知書共通情報().get更正後() != null
                && item.get本算定納入通知書制御情報() != null
                && item.get本算定納入通知書制御情報().get納入通知書制御情報() != null
                && KozaKubun.口座振替.equals(item.get編集後本算定通知書共通情報().get更正後().get口座区分())
                && HyojiUmu.表示しない.equals(item.get本算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {

            INonyuTsuchishoCVSKakukoCoverEditor coverEditor
                    = new NonyuTsuchishoCVSKakukoCoverEditor(item, ninshoshaSource, 1);
            INonyuTsuchishoCVSKakukoCoverBuilder builder
                    = new NonyuTsuchishoCVSKakukoCoverBuilder(coverEditor);
            reportSourceWriter.writeLine(builder);
            return;
        }

        INonyuTsuchishoCVSKakukoCoverEditor coverEditor
                = new NonyuTsuchishoCVSKakukoCoverEditor(item, ninshoshaSource, 1);
        INonyuTsuchishoCVSKakukoCoverBuilder builder
                = new NonyuTsuchishoCVSKakukoCoverBuilder(coverEditor);
        reportSourceWriter.writeLine(builder);

        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = item.get納入通知書期情報リスト();
        Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map1 = new HashMap<>();
        Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map2 = new HashMap<>();
        Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map3 = new HashMap<>();

        this.納入通知書期情報Map作成ForCover(納入通知書期情報リスト, 納入通知書期情報Map1, 納入通知書期情報Map2, 納入通知書期情報Map3);

        if (!納入通知書期情報Map1.isEmpty()) {
            INonyuTsuchishoCVSKakukoNofushoEditor nofushoEditor
                    = new NonyuTsuchishoCVSKakukoNofushoEditor(item, 納入通知書期情報Map1);
            INonyuTsuchishoCVSKakukoNofushoBuilder nofushoBuilder
                    = new NonyuTsuchishoCVSKakukoNofushoBuilder(nofushoEditor);
            reportSourceWriter.writeLine(nofushoBuilder);
        }

        if (!納入通知書期情報Map2.isEmpty()) {
            INonyuTsuchishoCVSKakukoNofushoEditor nofushoEditor
                    = new NonyuTsuchishoCVSKakukoNofushoEditor(item, 納入通知書期情報Map2);
            INonyuTsuchishoCVSKakukoNofushoBuilder nofushoBuilder
                    = new NonyuTsuchishoCVSKakukoNofushoBuilder(nofushoEditor);
            reportSourceWriter.writeLine(nofushoBuilder);
        }

        if (!納入通知書期情報Map3.isEmpty()) {
            INonyuTsuchishoCVSKakukoNofushoEditor nofushoEditor
                    = new NonyuTsuchishoCVSKakukoNofushoEditor(item, 納入通知書期情報Map3);
            INonyuTsuchishoCVSKakukoNofushoBuilder nofushoBuilder
                    = new NonyuTsuchishoCVSKakukoNofushoBuilder(nofushoEditor);
            reportSourceWriter.writeLine(nofushoBuilder);
        }

    }

    private void writeLineForRencho(ReportSourceWriter<NonyuTsuchishoCVSKakukoSource> reportSourceWriter) {

        if (item.get編集後本算定通知書共通情報() != null
                && item.get編集後本算定通知書共通情報().get更正後() != null
                && item.get本算定納入通知書制御情報() != null
                && item.get本算定納入通知書制御情報().get納入通知書制御情報() != null
                && KozaKubun.口座振替.equals(item.get編集後本算定通知書共通情報().get更正後().get口座区分())
                && HyojiUmu.表示しない.equals(item.get本算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {
            INonyuTsuchishoCVSKakukoRenchoCoverEditor renchoCoverEditor
                    = new NonyuTsuchishoCVSKakukoRenchoCoverEditor(item, ninshoshaSource, 1);
            INonyuTsuchishoCVSKakukoRenchoCoverBuilder builder
                    = new NonyuTsuchishoCVSKakukoRenchoCoverBuilder(renchoCoverEditor);
            reportSourceWriter.writeLine(builder);
            return;
        }

        INonyuTsuchishoCVSKakukoRenchoCoverEditor renchoCoverEditor
                = new NonyuTsuchishoCVSKakukoRenchoCoverEditor(item, ninshoshaSource, 1);
        INonyuTsuchishoCVSKakukoRenchoCoverBuilder builder
                = new NonyuTsuchishoCVSKakukoRenchoCoverBuilder(renchoCoverEditor);
        reportSourceWriter.writeLine(builder);

        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = item.get納入通知書期情報リスト();
        Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map1 = new HashMap<>();
        Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map2 = new HashMap<>();

        this.納入通知書期情報Map作成ForRencho(納入通知書期情報リスト, 納入通知書期情報Map1, 納入通知書期情報Map2);

        if (!納入通知書期情報Map1.isEmpty()) {
            INonyuTsuchishoCVSKakukoRenchoNofushoEditor renchoNofushoEditor
                    = new NonyuTsuchishoCVSKakukoRenchoNofushoEditor(item, 納入通知書期情報Map1);
            INonyuTsuchishoCVSKakukoRenchoNofushoBuilder renchoNofushoBuilder
                    = new NonyuTsuchishoCVSKakukoRenchoNofushoBuilder(renchoNofushoEditor);
            reportSourceWriter.writeLine(renchoNofushoBuilder);
        }

        if (!納入通知書期情報Map2.isEmpty()) {
            INonyuTsuchishoCVSKakukoRenchoNofushoEditor renchoNofushoEditor
                    = new NonyuTsuchishoCVSKakukoRenchoNofushoEditor(item, 納入通知書期情報Map2);
            INonyuTsuchishoCVSKakukoRenchoNofushoBuilder renchoNofushoBuilder
                    = new NonyuTsuchishoCVSKakukoRenchoNofushoBuilder(renchoNofushoEditor);
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
