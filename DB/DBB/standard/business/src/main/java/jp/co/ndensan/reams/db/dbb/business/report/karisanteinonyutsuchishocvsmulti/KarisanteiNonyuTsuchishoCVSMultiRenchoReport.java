/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.INonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.HyojiUmu;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiRenchoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】連帳のReportです。
 *
 * @reamsid_L DBB-9110-050 huangh
 */
public class KarisanteiNonyuTsuchishoCVSMultiRenchoReport extends INonyuTsuchisho<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> {

    private final KariSanteiNonyuTsuchiShoJoho item;
    private final NinshoshaSource ninshoshaSource;
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
     */
    public KarisanteiNonyuTsuchishoCVSMultiRenchoReport(
            KariSanteiNonyuTsuchiShoJoho item,
            NinshoshaSource ninshoshaSource) {

        this.item = item;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> reportSourceWriter) {

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

    private void writeLine(ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiRenchoSource> reportSourceWriter) {

        if (item.get編集後仮算定通知書共通情報() != null
                && item.get編集後仮算定通知書共通情報().get更正後() != null
                && item.get仮算定納入通知書制御情報() != null
                && item.get仮算定納入通知書制御情報().get納入通知書制御情報() != null
                && KozaKubun.口座振替.equals(item.get編集後仮算定通知書共通情報().get更正後().get更正後口座区分())
                && HyojiUmu.表示しない.equals(item.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {
            item.set編集範囲区分(HenshuHaniKubun.Coverのみ);
        }

        HenshuHaniKubun 編集範囲区分 = item.get編集範囲区分();
        if (HenshuHaniKubun.Coverのみ.equals(編集範囲区分)) {
            IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor renchoCoverEditor
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverEditor(item, ninshoshaSource, 1);
            IKarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder builder
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoCoverBuilder(renchoCoverEditor);
            reportSourceWriter.writeLine(builder);
        }
        if (!HenshuHaniKubun.Detailのみ.equals(編集範囲区分) && !HenshuHaniKubun.全てのレイアウト.equals(編集範囲区分)) {
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

        this.納入通知書期情報Map作成(納入通知書期情報リスト, 納入通知書期情報Map1, 納入通知書期情報Map2);

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

    @Override
    public List<INonyuTsuchisho> devidedByPage() {
        List<INonyuTsuchisho> nonyuTsuchishoList = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = item.get納入通知書期情報リスト();

        if (HenshuHaniKubun.Coverのみ.equals(item.get編集範囲区分())) {
            editCover(nonyuTsuchishoList, 納入通知書期情報リスト);
        } else if (HenshuHaniKubun.Detailのみ.equals(item.get編集範囲区分())) {
            editDetail(nonyuTsuchishoList, 納入通知書期情報リスト);
        } else if (HenshuHaniKubun.全てのレイアウト.equals(item.get編集範囲区分())) {
            editCover(nonyuTsuchishoList, 納入通知書期情報リスト);
            editDetail(nonyuTsuchishoList, 納入通知書期情報リスト);
        }
        return nonyuTsuchishoList;
    }

    private void editCover(List<INonyuTsuchisho> nonyuTsuchishoList, List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストCover) {
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Cover = getNew仮算定納入通知書情報(HenshuHaniKubun.Coverのみ, 納入通知書期情報リストCover);
        KarisanteiNonyuTsuchishoCVSMultiRenchoReport reportCover
                = new KarisanteiNonyuTsuchishoCVSMultiRenchoReport(仮算定納入通知書情報Cover, ninshoshaSource);
        nonyuTsuchishoList.add(reportCover);
    }

    private void editDetail(List<INonyuTsuchisho> nonyuTsuchishoList, List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
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
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Detail1
                    = getNew仮算定納入通知書情報(HenshuHaniKubun.Detailのみ, 納入通知書期情報リストDetail1);
            KarisanteiNonyuTsuchishoCVSMultiRenchoReport reportDetail1
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoReport(仮算定納入通知書情報Detail1, ninshoshaSource);
            nonyuTsuchishoList.add(reportDetail1);
        } else if (納入通知書期情報リストDetail2 != null && !納入通知書期情報リストDetail2.isEmpty()) {
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Detail2
                    = getNew仮算定納入通知書情報(HenshuHaniKubun.Detailのみ, 納入通知書期情報リストDetail2);
            KarisanteiNonyuTsuchishoCVSMultiRenchoReport reportDetail2
                    = new KarisanteiNonyuTsuchishoCVSMultiRenchoReport(仮算定納入通知書情報Detail2, ninshoshaSource);
            nonyuTsuchishoList.add(reportDetail2);
        }
    }

    private void 納入通知書期情報Map作成(
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

    private KariSanteiNonyuTsuchiShoJoho getNew仮算定納入通知書情報(
            HenshuHaniKubun 編集範囲区分, List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        KariSanteiNonyuTsuchiShoJoho new仮算定納入通知書情報 = new KariSanteiNonyuTsuchiShoJoho();
        new仮算定納入通知書情報.set仮算定納入通知書制御情報(item.get仮算定納入通知書制御情報());
        new仮算定納入通知書情報.set処理区分(item.get処理区分());
        new仮算定納入通知書情報.set出力期リスト(item.get出力期リスト());
        new仮算定納入通知書情報.set地方公共団体(item.get地方公共団体());
        new仮算定納入通知書情報.set帳票ID(item.get帳票ID());
        new仮算定納入通知書情報.set帳票分類ID(item.get帳票分類ID());
        new仮算定納入通知書情報.set発行日(item.get発行日());
        new仮算定納入通知書情報.set算定の基礎(item.get算定の基礎());
        new仮算定納入通知書情報.set納付書共通(item.get納付書共通());
        new仮算定納入通知書情報.set編集後仮算定通知書共通情報(item.get編集後仮算定通知書共通情報());
        new仮算定納入通知書情報.set納入通知書期情報リスト(納入通知書期情報リスト);
        new仮算定納入通知書情報.set編集範囲区分(編集範囲区分);
        return new仮算定納入通知書情報;
    }
}
