/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishocvsmulti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishocvsmulti.NonyuTsuchishoCVSMultiRenchoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】（連帳）CoverのReportです。
 *
 * @reamsid_L DBB-9110-110 huangh
 */
public class NonyuTsuchishoCVSMultiRenchoReport extends NonyuTsuchisho<NonyuTsuchishoCVSMultiRenchoSource> {

    private final HonSanteiNonyuTsuchiShoJoho item;
    private final NinshoshaSource ninshoshaSource;
    private final List<NonyuTsuchisho<NonyuTsuchishoCVSMultiRenchoSource>> nonyuTsuchishoList = new ArrayList<>();

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
     * @param item 保険料納入通知書（本算定）【コンビニマルチ収納タイプ】のITEM
     * @param ninshoshaSource NinshoshaSource
     */
    public NonyuTsuchishoCVSMultiRenchoReport(
            HonSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource) {

        this.item = item;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchishoCVSMultiRenchoSource> reportSourceWriter) {

        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : item.get納入通知書期情報リスト()) {
            if (納入通知書期情報.get納付額().compareTo(Decimal.ZERO) > 0) {
                this.writeLine(reportSourceWriter);
                break;
            }
        }
    }

    private void writeLine(ReportSourceWriter<NonyuTsuchishoCVSMultiRenchoSource> reportSourceWriter) {

        this.set準備データ(reportSourceWriter);
        if (!HenshuHaniKubun.Detailのみ.equals(item.get編集範囲区分()) && !HenshuHaniKubun.全てのレイアウト.equals(item.get編集範囲区分())) {
            return;
        }

        INonyuTsuchishoCVSMultiRenchoCoverEditor renchoCoverEditor
                = new NonyuTsuchishoCVSMultiRenchoCoverEditor(item, ninshoshaSource);
        INonyuTsuchishoCVSMultiRenchoCoverBuilder builder
                = new NonyuTsuchishoCVSMultiRenchoCoverBuilder(renchoCoverEditor);
        reportSourceWriter.writeLine(builder);

        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = item.get納入通知書期情報リスト();
        Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map1 = new HashMap<>();
        Map<Integer, NonyuTsuchiShoKiJoho> 納入通知書期情報Map2 = new HashMap<>();

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

        if (!納入通知書期情報Map1.isEmpty()) {
            INonyuTsuchishoCVSMultiRenchoNofushoEditor renchoNofushoEditor
                    = new NonyuTsuchishoCVSMultiRenchoNofushoEditor(item, 納入通知書期情報Map1);
            INonyuTsuchishoCVSMultiRenchoNofushoBuilder renchoNofushoBuilder
                    = new NonyuTsuchishoCVSMultiRenchoNofushoBuilder(renchoNofushoEditor);
            reportSourceWriter.writeLine(renchoNofushoBuilder);
        }

        if (!納入通知書期情報Map2.isEmpty()) {
            INonyuTsuchishoCVSMultiRenchoNofushoEditor renchoNofushoEditor
                    = new NonyuTsuchishoCVSMultiRenchoNofushoEditor(item, 納入通知書期情報Map2);
            INonyuTsuchishoCVSMultiRenchoNofushoBuilder renchoNofushoBuilder
                    = new NonyuTsuchishoCVSMultiRenchoNofushoBuilder(renchoNofushoEditor);
            reportSourceWriter.writeLine(renchoNofushoBuilder);
        }
    }

    @Override
    public List<NonyuTsuchisho<NonyuTsuchishoCVSMultiRenchoSource>> devidedByPage() {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = item.get納入通知書期情報リスト();

        if (HenshuHaniKubun.Coverのみ.equals(item.get編集範囲区分())) {
            editCover(納入通知書期情報リスト);
        } else if (HenshuHaniKubun.Detailのみ.equals(item.get編集範囲区分())) {
            editDetail(納入通知書期情報リスト);
        } else if (HenshuHaniKubun.全てのレイアウト.equals(item.get編集範囲区分())) {
            editCover(納入通知書期情報リスト);
            editDetail(納入通知書期情報リスト);
        }
        return nonyuTsuchishoList;
    }

    private void set準備データ(ReportSourceWriter<NonyuTsuchishoCVSMultiRenchoSource> reportSourceWriter) {

        if (item.get編集後本算定通知書共通情報() != null
                && item.get編集後本算定通知書共通情報().get更正後() != null
                && item.get本算定納入通知書制御情報() != null
                && item.get本算定納入通知書制御情報().get納入通知書制御情報() != null
                && KozaKubun.口座振替.equals(item.get編集後本算定通知書共通情報().get更正後().get口座区分())
                && HyojiUmu.表示しない.equals(item.get本算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {
            item.set編集範囲区分(HenshuHaniKubun.Coverのみ);
        }

        if (HenshuHaniKubun.Coverのみ.equals(item.get編集範囲区分())) {
            INonyuTsuchishoCVSMultiRenchoCoverEditor renchoCoverEditor
                    = new NonyuTsuchishoCVSMultiRenchoCoverEditor(item, ninshoshaSource);
            INonyuTsuchishoCVSMultiRenchoCoverBuilder builder
                    = new NonyuTsuchishoCVSMultiRenchoCoverBuilder(renchoCoverEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private void editCover(
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストCover) {
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報Cover = getNew本算定納入通知書情報(HenshuHaniKubun.Coverのみ, 納入通知書期情報リストCover);
        NonyuTsuchishoCVSMultiRenchoReport reportCover
                = new NonyuTsuchishoCVSMultiRenchoReport(本算定納入通知書情報Cover, ninshoshaSource);
        nonyuTsuchishoList.add(reportCover);
    }

    private void editDetail(
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストDetail1 = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストDetail2 = new ArrayList<>();
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {

            if (納入通知書期情報.getコンビニカット印字位置() == INT_3) {
                納入通知書期情報リストDetail1.add(納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_4) {
                納入通知書期情報リストDetail1.add(納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_5) {
                納入通知書期情報リストDetail1.add(納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_6) {
                納入通知書期情報リストDetail1.add(納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_7) {
                納入通知書期情報リストDetail2.add(納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_8) {
                納入通知書期情報リストDetail2.add(納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_9) {
                納入通知書期情報リストDetail2.add(納入通知書期情報);
            } else if (納入通知書期情報.getコンビニカット印字位置() == INT_10) {
                納入通知書期情報リストDetail2.add(納入通知書期情報);
            }
        }

        if (納入通知書期情報リストDetail1 != null && !納入通知書期情報リストDetail1.isEmpty()) {
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報Detail1
                    = getNew本算定納入通知書情報(HenshuHaniKubun.Detailのみ, 納入通知書期情報リストDetail1);
            NonyuTsuchishoCVSMultiRenchoReport reportDetail1
                    = new NonyuTsuchishoCVSMultiRenchoReport(本算定納入通知書情報Detail1, ninshoshaSource);
            nonyuTsuchishoList.add(reportDetail1);
        }
        if (納入通知書期情報リストDetail2 != null && !納入通知書期情報リストDetail2.isEmpty()) {
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報Detail2
                    = getNew本算定納入通知書情報(HenshuHaniKubun.Detailのみ, 納入通知書期情報リストDetail2);
            NonyuTsuchishoCVSMultiRenchoReport reportDetail2
                    = new NonyuTsuchishoCVSMultiRenchoReport(本算定納入通知書情報Detail2, ninshoshaSource);
            nonyuTsuchishoList.add(reportDetail2);
        }
    }

    private HonSanteiNonyuTsuchiShoJoho getNew本算定納入通知書情報(
            HenshuHaniKubun 編集範囲区分, List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        HonSanteiNonyuTsuchiShoJoho new本算定納入通知書情報 = new HonSanteiNonyuTsuchiShoJoho();
        new本算定納入通知書情報.set本算定納入通知書制御情報(item.get本算定納入通知書制御情報());
        new本算定納入通知書情報.set処理区分(item.get処理区分());
        new本算定納入通知書情報.set出力期リスト(item.get出力期リスト());
        new本算定納入通知書情報.set地方公共団体(item.get地方公共団体());
        new本算定納入通知書情報.set帳票ID(item.get帳票ID());
        new本算定納入通知書情報.set帳票分類ID(item.get帳票分類ID());
        new本算定納入通知書情報.set発行日(item.get発行日());
        new本算定納入通知書情報.set現年度_過年度区分(item.get現年度_過年度区分());
        new本算定納入通知書情報.set納付書共通(item.get納付書共通());
        new本算定納入通知書情報.set編集後本算定通知書共通情報(item.get編集後本算定通知書共通情報());
        new本算定納入通知書情報.set納入通知書期情報リスト(納入通知書期情報リスト);
        new本算定納入通知書情報.set編集範囲区分(編集範囲区分);
        return new本算定納入通知書情報;
    }
}
