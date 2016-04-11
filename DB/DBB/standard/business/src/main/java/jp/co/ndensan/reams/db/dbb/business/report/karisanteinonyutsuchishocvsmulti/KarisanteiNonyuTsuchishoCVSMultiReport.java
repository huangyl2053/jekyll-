/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteinonyutsuchishocvsmulti;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.INonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.report.karisanteinonyutsuchishocvsmulti.KarisanteiNonyuTsuchishoCVSMultiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】CoverのReportです。
 *
 */
public class KarisanteiNonyuTsuchishoCVSMultiReport extends INonyuTsuchisho<KarisanteiNonyuTsuchishoCVSMultiSource> {

    private final KariSanteiNonyuTsuchiShoJoho item;
    //private final RString renchoKubun = new RString("1");
//    private static final int INT_2 = 2;
//    private static final int INT_5 = 5;
//    private static final int INT_8 = 8;

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】のITEM
     * @return 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】CoverのReport
     */
    public static KarisanteiNonyuTsuchishoCVSMultiReport createFrom(
            KariSanteiNonyuTsuchiShoJoho item) {
        return new KarisanteiNonyuTsuchishoCVSMultiReport(item);
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ】のITEM
     */
    protected KarisanteiNonyuTsuchishoCVSMultiReport(
            KariSanteiNonyuTsuchiShoJoho item) {

        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiNonyuTsuchishoCVSMultiSource> reportSourceWriter) {

        if (item.get納入通知書期情報リスト() != null) {
            boolean 作成フラグ = true;
            for (NonyuTsuchiShoKiJoho 納入通知書期情報 : item.get納入通知書期情報リスト()) {
                if (納入通知書期情報.get納付書納付額欄() != null
                        && Integer.valueOf(納入通知書期情報.get納付書納付額欄().toString()) > 0) {
                    作成フラグ = false;
                    break;
                }
            }
            if (作成フラグ) {
                return;
            }
        }
        // devidedByPage()
        IKarisanteiNonyuTsuchishoCVSMultiCoverEditor coverEditor = new KarisanteiNonyuTsuchishoCVSMultiCoverEditor(item);
        IKarisanteiNonyuTsuchishoCVSMultiBuilder builder = new KarisanteiNonyuTsuchishoCVSMultiBuilder(coverEditor);
        reportSourceWriter.writeLine(builder);

    }

    /**
     * devidedByPageメソッド
     *
     * @return List<NonyuTsuchisho>
     */
    @Override
    public List<INonyuTsuchisho> devidedByPage() {

        List<INonyuTsuchisho> reportLst = new ArrayList<>();

//        if (item.get納入通知書期情報リスト() != null) {
//            boolean 作成フラグ = true;
//            for (NonyuTsuchiShoKiJoho 納入通知書期情報 : item.get納入通知書期情報リスト()) {
//                if (納入通知書期情報.get納付書納付額欄() != null
//                        && Integer.valueOf(納入通知書期情報.get納付書納付額欄().toString()) > 0) {
//                    作成フラグ = false;
//                    break;
//                }
//            }
//            if (作成フラグ) {
//                return reportLst;
//            }
//        }
//
//        if (item.get編集後仮算定通知書共通情報() != null
//                && item.get編集後仮算定通知書共通情報().get更正後() != null
//                && item.get仮算定納入通知書制御情報() != null
//                && item.get仮算定納入通知書制御情報().get納入通知書制御情報() != null
//                && KozaKubun.口座振替.equals(item.get編集後仮算定通知書共通情報().get更正後().get更正後口座区分())
//                && HyojiUmu.表示しない.equals(item.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {
//            item.set編集範囲区分(HenshuHaniKubun.Coverのみ);
//        }
//
//        if (HenshuHaniKubun.Coverのみ.equals(item.get編集範囲区分())) {
//            reportLst.add(KarisanteiNonyuTsuchishoCVSMultiReport.createFrom(item));
//        } else if (HenshuHaniKubun.Detailのみ.equals(item.get編集範囲区分())) {
//
//            reportLst.add(KarisanteiNonyuTsuchishoCVSMultiNofushoReport.createFrom(item, INT_2));
//            reportLst.add(KarisanteiNonyuTsuchishoCVSMultiNofushoReport.createFrom(item, INT_5));
//            reportLst.add(KarisanteiNonyuTsuchishoCVSMultiNofushoReport.createFrom(item, INT_8));
//
//        } else if (HenshuHaniKubun.全てのレイアウト.equals(item.get編集範囲区分())) {
//            reportLst.add(KarisanteiNonyuTsuchishoCVSMultiReport.createFrom(item));
//            if (item.get編集後仮算定通知書共通情報() != null
//                    && item.get編集後仮算定通知書共通情報().get更正後() != null
//                    && item.get仮算定納入通知書制御情報() != null
//                    && item.get仮算定納入通知書制御情報().get納入通知書制御情報() != null
//                    && !KozaKubun.口座振替.equals(item.get編集後仮算定通知書共通情報().get更正後().get更正後口座区分())
//                    || !HyojiUmu.表示しない.equals(item.get仮算定納入通知書制御情報().get納入通知書制御情報().getコンビニ_ブック口座用納付書表示())) {
//                reportLst.add(KarisanteiNonyuTsuchishoCVSMultiNofushoReport.createFrom(item, INT_2));
//                reportLst.add(KarisanteiNonyuTsuchishoCVSMultiNofushoReport.createFrom(item, INT_5));
//                reportLst.add(KarisanteiNonyuTsuchishoCVSMultiNofushoReport.createFrom(item, INT_8));
//            }
//        }
        return reportLst;
    }
}
