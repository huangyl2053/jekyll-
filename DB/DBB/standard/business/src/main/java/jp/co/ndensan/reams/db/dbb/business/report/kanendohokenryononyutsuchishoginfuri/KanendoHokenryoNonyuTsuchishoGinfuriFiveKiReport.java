/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendohokenryononyutsuchishoginfuri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendohokenryononyutsuchishoginfuri.KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険料納入通知書（本算定過年度）【銀振タイプ】帳票項目定義_5期
 *
 * @reamsid_L DBB-9110-150 wangjie2
 */
public class KanendoHokenryoNonyuTsuchishoGinfuriFiveKiReport extends NonyuTsuchisho<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource> {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;
    private static final int INT_5 = 5;

    /**
     * コンストラクタです。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     */
    public KanendoHokenryoNonyuTsuchishoGinfuriFiveKiReport(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, NinshoshaSource ninshoshaSource) {
        this.本算定納入通知書情報 = 本算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public void writeBy(ReportSourceWriter<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource> writer) {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        if (is全部の納付額が0(納入通知書期情報リスト)) {
            return;
        }
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

    private void edit(ReportSourceWriter<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource> writer,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit, int 連番) {
        IKanendoHokenryoNonyuTsuchishoGinfuriFiveKiEditor editor
                = new KanendoHokenryoNonyuTsuchishoGinfuriFiveKiEditor(本算定納入通知書情報, ninshoshaSource, 納入通知書期情報リストEdit, 連番);
        IKanendoHokenryoNonyuTsuchishoGinfuriFiveKiBuilder builder = new KanendoHokenryoNonyuTsuchishoGinfuriFiveKiBuilder(editor);
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
    public List<NonyuTsuchisho<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource>> devidedByPage() {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        List<NonyuTsuchisho<KanendoHokenryoNonyuTsuchishoGinfuriFiveKiSource>> reportLst = new ArrayList<>();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport = new ArrayList<>();
        if (null == 納入通知書期情報リスト) {
            reportLst.add(getNewReport(納入通知書期情報リストReport));
            return reportLst;
        }
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
        return reportLst;
    }

    private KanendoHokenryoNonyuTsuchishoGinfuriFiveKiReport getNewReport(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport) {
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報Report = new HonSanteiNonyuTsuchiShoJoho();
        clone仮算定納入通知書情報(本算定納入通知書情報Report);
        本算定納入通知書情報Report.set編集範囲区分(HenshuHaniKubun.全てのレイアウト);
        本算定納入通知書情報Report.set納入通知書期情報リスト(納入通知書期情報リストReport);
        KanendoHokenryoNonyuTsuchishoGinfuriFiveKiReport report
                = new KanendoHokenryoNonyuTsuchishoGinfuriFiveKiReport(本算定納入通知書情報Report, ninshoshaSource);
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

}
