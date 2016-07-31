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
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishoginfuri.HokenryoNonyuTsuchishoGinfuriFourKiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定）【銀振タイプ】帳票項目定義_4期
 *
 * @reamsid_L DBB-9110-090 liangbc
 */
public class HokenryoNonyuTsuchishoGinfuriFourKiReport extends NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFourKiSource> {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト前期 = new ArrayList<>();
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト中期 = new ArrayList<>();
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト後期 = new ArrayList<>();
    private final int 中期開始期;
    private final int 後期開始期;
    private static final int INT_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     * @param 中期開始期 中期開始期
     * @param 後期開始期 後期開始期
     */
    public HokenryoNonyuTsuchishoGinfuriFourKiReport(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            NinshoshaSource ninshoshaSource, int 中期開始期, int 後期開始期) {
        this.本算定納入通知書情報 = 本算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
        this.中期開始期 = 中期開始期;
        this.後期開始期 = 後期開始期;
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
    public void writeBy(ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFourKiSource> writer) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        if (is全部の納付額が0(納入通知書期情報リスト)) {
            return;
        }

        this.edit前中後期リスト(納入通知書期情報リスト);
        if (!納入通知書期情報リスト前期.isEmpty()) {
            this.edit前中後期(納入通知書期情報リスト前期, writer);
        }
        if (!納入通知書期情報リスト中期.isEmpty()) {
            this.edit前中後期(納入通知書期情報リスト中期, writer);
        }
        if (!納入通知書期情報リスト後期.isEmpty()) {
            this.edit前中後期(納入通知書期情報リスト後期, writer);
        }
    }

    private void edit(ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFourKiSource> writer,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit) {
        IHokenryoNonyuTsuchishoGinfuriFourKiEditor editor
                = new HokenryoNonyuTsuchishoGinfuriFourKiEditor(本算定納入通知書情報, ninshoshaSource, 納入通知書期情報リストEdit);
        IHokenryoNonyuTsuchishoGinfuriFourKiBuilder builder = new HokenryoNonyuTsuchishoGinfuriFourKiBuilder(editor);
        writer.writeLine(builder);
    }

    @Override
    public List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFourKiSource>> devidedByPage() {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFourKiSource>> reportLst = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport = new ArrayList<>();
        if (null == 納入通知書期情報リスト) {
            reportLst.add(getNewReport(納入通知書期情報リストReport));
            return reportLst;
        }

        this.edit前中後期リスト(納入通知書期情報リスト);
        if (!納入通知書期情報リスト前期.isEmpty()) {
            this.devidedEdit前中後期(納入通知書期情報リスト前期, 納入通知書期情報リストReport, reportLst);
        }
        if (!納入通知書期情報リスト中期.isEmpty()) {
            納入通知書期情報リストReport = new ArrayList<>();
            this.devidedEdit前中後期(納入通知書期情報リスト中期, 納入通知書期情報リストReport, reportLst);
        }
        if (!納入通知書期情報リスト後期.isEmpty()) {
            納入通知書期情報リストReport = new ArrayList<>();
            this.devidedEdit前中後期(納入通知書期情報リスト後期, 納入通知書期情報リストReport, reportLst);
        }

        return reportLst;
    }

    private HokenryoNonyuTsuchishoGinfuriFourKiReport getNewReport(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport) {
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報Report = new HonSanteiNonyuTsuchiShoJoho();
        clone仮算定納入通知書情報(本算定納入通知書情報Report);
        本算定納入通知書情報Report.set編集範囲区分(HenshuHaniKubun.全てのレイアウト);
        本算定納入通知書情報Report.set納入通知書期情報リスト(納入通知書期情報リストReport);
        HokenryoNonyuTsuchishoGinfuriFourKiReport report
                = new HokenryoNonyuTsuchishoGinfuriFourKiReport(本算定納入通知書情報Report, ninshoshaSource, 中期開始期, 後期開始期);
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
        本算定納入通知書情報Report.set連番(本算定納入通知書情報.get連番());
    }

    private void edit前中後期(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            ReportSourceWriter<HokenryoNonyuTsuchishoGinfuriFourKiSource> writer) {

        int 銀振印字位置Para = 0;
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit = new ArrayList<>();
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            int 銀振印字位置 = 納入通知書期情報.get銀振印字位置();
            if (銀振印字位置 > INT_4) {
                throw new ApplicationException(DbbErrorMessages.ブック開始位置不正.getMessage());
            }
            if (銀振印字位置 <= 銀振印字位置Para) {
                edit(writer, 納入通知書期情報リストEdit);
                納入通知書期情報リストEdit.clear();
                納入通知書期情報リストEdit.add(納入通知書期情報);
            } else {
                納入通知書期情報リストEdit.add(納入通知書期情報);
            }
            銀振印字位置Para = 銀振印字位置;
        }
        edit(writer, 納入通知書期情報リストEdit);
    }

    private void devidedEdit前中後期(
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport,
            List<NonyuTsuchisho<HokenryoNonyuTsuchishoGinfuriFourKiSource>> reportLst) {

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

    private void edit前中後期リスト(
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {

        if (中期開始期 != 0 && 後期開始期 != 0) {
            for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
                if (納入通知書期情報.get期() < 中期開始期) {
                    納入通知書期情報リスト前期.add(納入通知書期情報);
                } else if (納入通知書期情報.get期() >= 中期開始期 && 納入通知書期情報.get期() < 後期開始期) {
                    納入通知書期情報リスト中期.add(納入通知書期情報);
                } else {
                    納入通知書期情報リスト後期.add(納入通知書期情報);
                }
            }
        } else if (中期開始期 == 0 && 後期開始期 != 0) {
            for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
                if (納入通知書期情報.get期() < 後期開始期) {
                    納入通知書期情報リスト前期.add(納入通知書期情報);
                } else {
                    納入通知書期情報リスト後期.add(納入通知書期情報);
                }
            }
        } else if (中期開始期 == 0 && 後期開始期 == 0) {
            納入通知書期情報リスト前期.addAll(納入通知書期情報リスト);
        }
    }
}
