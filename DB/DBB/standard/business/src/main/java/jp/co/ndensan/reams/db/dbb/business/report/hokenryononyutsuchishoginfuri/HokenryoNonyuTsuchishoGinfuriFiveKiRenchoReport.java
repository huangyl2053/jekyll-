/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishoginfuri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【銀振タイプ】帳票項目定義_5期_連帳
 *
 * @reamsid_L DBB-9110-090 liangbc
 */
public class HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport extends NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;
    private static final int INT_5 = 5;
    private static final int INT_7 = 7;
    private static final int INT_10 = 10;

    /**
     * コンストラクタです。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     */
    public HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, NinshoshaSource ninshoshaSource) {
        this.本算定納入通知書情報 = 本算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> writer) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        if (is全部の納付額が0(納入通知書期情報リスト)) {
            return;
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト前期 = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト中期 = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト後期 = new ArrayList<>();

        this.前中後期リストのedit(納入通知書期情報リスト, 納入通知書期情報リスト前期, 納入通知書期情報リスト中期, 納入通知書期情報リスト後期);
        if (!納入通知書期情報リスト前期.isEmpty()) {
            this.前中後期のedit(納入通知書期情報リスト前期, writer);
        }
        if (!納入通知書期情報リスト中期.isEmpty()) {
            this.前中後期のedit(納入通知書期情報リスト中期, writer);
        }
        if (!納入通知書期情報リスト後期.isEmpty()) {
            this.前中後期のedit(納入通知書期情報リスト後期, writer);
        }
    }

    private void edit(ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> writer,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit, int 連番) {
        IHokenryoNonyuTsuchishoGinfuriFiveKiRenchoEditor editor
                = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoEditor(本算定納入通知書情報, ninshoshaSource, 納入通知書期情報リストEdit, 連番);
        HokenryoNonyuTsuchishoGinfuriFiveKiRenchoBuilder builder = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoBuilder(editor);
        writer.writeLine(builder);
    }

    private boolean is全部の納付額が0(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        if (null == 納入通知書期情報リスト) {
            return true;
        }
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (納入通知書期情報.get納付額() != null && 納入通知書期情報.get納付額().compareTo(Decimal.ZERO) > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource>> devidedByPage() {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource>> reportLst = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport = new ArrayList<>();
        if (null == 納入通知書期情報リスト) {
            reportLst.add(getNewReport(納入通知書期情報リストReport));
            return reportLst;
        }

        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト前期 = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト中期 = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト後期 = new ArrayList<>();

        this.前中後期リストのedit(納入通知書期情報リスト, 納入通知書期情報リスト前期, 納入通知書期情報リスト中期, 納入通知書期情報リスト後期);
        if (!納入通知書期情報リスト前期.isEmpty()) {
            this.前中後期のdevidedEdit(納入通知書期情報リスト前期, 納入通知書期情報リストReport, reportLst);
        }
        if (!納入通知書期情報リスト中期.isEmpty()) {
            this.前中後期のdevidedEdit(納入通知書期情報リスト中期, 納入通知書期情報リストReport, reportLst);
        }
        if (!納入通知書期情報リスト後期.isEmpty()) {
            this.前中後期のdevidedEdit(納入通知書期情報リスト後期, 納入通知書期情報リストReport, reportLst);
        }

        return reportLst;
    }

    private HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport getNewReport(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport) {
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報Report = new HonSanteiNonyuTsuchiShoJoho();
        clone仮算定納入通知書情報(本算定納入通知書情報Report);
        本算定納入通知書情報Report.set編集範囲区分(HenshuHaniKubun.全てのレイアウト);
        本算定納入通知書情報Report.set納入通知書期情報リスト(納入通知書期情報リストReport);
        HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport report
                = new HokenryoNonyuTsuchishoGinfuriFiveKiRenchoReport(本算定納入通知書情報Report, ninshoshaSource);
        return report;
    }

    private void clone仮算定納入通知書情報(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報Report) {
        本算定納入通知書情報Report.set本算定納入通知書制御情報(本算定納入通知書情報.get本算定納入通知書制御情報());
        本算定納入通知書情報Report.set処理区分(本算定納入通知書情報.get処理区分());
        本算定納入通知書情報Report.set出力期リスト(本算定納入通知書情報.get出力期リスト());
        本算定納入通知書情報Report.set地方公共団体(本算定納入通知書情報.get地方公共団体());
        本算定納入通知書情報Report.set帳票ID(本算定納入通知書情報.get帳票ID());
        本算定納入通知書情報Report.set帳票分類ID(本算定納入通知書情報.get帳票分類ID());
        本算定納入通知書情報Report.set発行日(本算定納入通知書情報.get発行日());
        本算定納入通知書情報Report.set現年度_過年度区分(本算定納入通知書情報.get現年度_過年度区分());
        本算定納入通知書情報Report.set納付書共通(本算定納入通知書情報.get納付書共通());
        本算定納入通知書情報Report.set編集後本算定通知書共通情報(本算定納入通知書情報.get編集後本算定通知書共通情報());
    }

    private void 前中後期のedit(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource> writer) {

        int 銀振印字位置Para = 0;
        int 連番 = 1;
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit = new ArrayList<>();
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            int 銀振印字位置 = 納入通知書期情報.get銀振印字位置();
            if (銀振印字位置 > INT_5) {
                throw new ApplicationException(DbbErrorMessages.ブック開始位置不正.getMessage());
            }
            if (銀振印字位置 <= 銀振印字位置Para) {
                edit(writer, 納入通知書期情報リストEdit, 連番);
                納入通知書期情報リストEdit.clear();
                納入通知書期情報リストEdit.add(納入通知書期情報);
                連番++;
            } else {
                納入通知書期情報リストEdit.add(納入通知書期情報);
            }
            銀振印字位置Para = 銀振印字位置;
        }
        edit(writer, 納入通知書期情報リストEdit, 連番);
    }

    private void 前中後期のdevidedEdit(
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport,
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFiveKiRenchoSource>> reportLst) {

        int 銀振印字位置Para = 0;
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            int 銀振印字位置 = 納入通知書期情報.get銀振印字位置();
            if (銀振印字位置 <= 銀振印字位置Para) {
                reportLst.add(getNewReport(納入通知書期情報リストReport));
                納入通知書期情報リストReport = new ArrayList<>();
                納入通知書期情報リストReport.add(納入通知書期情報);
            } else {
                納入通知書期情報リストReport.add(納入通知書期情報);
            }
            銀振印字位置Para = 銀振印字位置;
        }
        reportLst.add(getNewReport(納入通知書期情報リストReport));
    }

    private void 前中後期リストのedit(
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト前期,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト中期,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト後期) {

        int 中期開始期 = INT_7;
        int 後期開始期 = INT_10;

        if (中期開始期 != 0 && 後期開始期 != 0) {
            int 前期 = 0;
            for (int i = 納入通知書期情報リスト.get(0).get期(); i <= 中期開始期 - 1; i++) {
                納入通知書期情報リスト前期.add(納入通知書期情報リスト.get(前期));
                前期++;
            }
            if (納入通知書期情報リスト.get(納入通知書期情報リスト.size() - 1).get期() < 中期開始期) {
                return;
            }
            int 中期 = 前期;
            for (int i = 中期開始期; i <= 後期開始期 - 1; i++) {
                納入通知書期情報リスト中期.add(納入通知書期情報リスト.get(中期));
                中期++;
            }
            if (納入通知書期情報リスト.get(納入通知書期情報リスト.size() - 1).get期() < 後期開始期) {
                return;
            }
            int 後期 = 中期;
            for (int i = 後期開始期; i <= 納入通知書期情報リスト.get(納入通知書期情報リスト.size() - 1).get期(); i++) {
                納入通知書期情報リスト後期.add(納入通知書期情報リスト.get(後期));
                後期++;
            }
        } else if (中期開始期 == 0 && 後期開始期 != 0) {
            int 前期 = 0;
            for (int i = 納入通知書期情報リスト.get(0).get期(); i <= 後期開始期 - 1; i++) {
                納入通知書期情報リスト前期.add(納入通知書期情報リスト.get(前期));
                前期++;
            }
            if (納入通知書期情報リスト.get(納入通知書期情報リスト.size() - 1).get期() < 後期開始期) {
                return;
            }
            int 後期 = 前期;
            for (int i = 後期開始期; i <= 納入通知書期情報リスト.get(納入通知書期情報リスト.size() - 1).get期(); i++) {
                納入通知書期情報リスト後期.add(納入通知書期情報リスト.get(後期));
                後期++;
            }
        } else if (中期開始期 == 0 && 後期開始期 == 0) {
            納入通知書期情報リスト前期.addAll(納入通知書期情報リスト);
        }
    }
}
