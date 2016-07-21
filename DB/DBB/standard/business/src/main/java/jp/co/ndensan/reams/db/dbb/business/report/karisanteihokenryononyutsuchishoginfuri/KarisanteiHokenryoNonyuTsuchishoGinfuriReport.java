/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.NonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 帳票設計_DBBRP00007_3_保険料納入通知書（仮算定）【銀振タイプ】
 *
 * @reamsid_L DBB-9110-030 wangjie2
 */
public class KarisanteiHokenryoNonyuTsuchishoGinfuriReport extends NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoGinfuriSource> {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;
    private static final int INT_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     */
    protected KarisanteiHokenryoNonyuTsuchishoGinfuriReport(
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, NinshoshaSource ninshoshaSource) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
    }

    /**
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     * @return KarisanteiHokenryoNonyuTsuchishoGinfuriReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public static KarisanteiHokenryoNonyuTsuchishoGinfuriReport createFrom(
            @NonNull KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, NinshoshaSource ninshoshaSource) {
        return new KarisanteiHokenryoNonyuTsuchishoGinfuriReport(仮算定納入通知書情報, ninshoshaSource);
    }

    @Override
    public void writeBy(ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriSource> reportSourceWriter) {
        ShoriKubun 処理区分 = 仮算定納入通知書情報.get処理区分();
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト();
        if (null == 納入通知書期情報リスト || is全部の納付額なし(納入通知書期情報リスト)) {
            return;
        }
        int 銀振印字位置Para = 0;
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストEdit = new ArrayList<>();
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            int 銀振印字位置 = 納入通知書期情報.get銀振印字位置();
            if (銀振印字位置 > INT_4) {
                throw new ApplicationException(DbbErrorMessages.ブック開始位置不正.getMessage());
            }
            if (銀振印字位置 <= 銀振印字位置Para) {
                edit(reportSourceWriter, 納入通知書期情報リストEdit, 処理区分);
                納入通知書期情報リストEdit.clear();
                納入通知書期情報リストEdit.add(納入通知書期情報);
            } else {
                納入通知書期情報リストEdit.add(納入通知書期情報);
            }
            銀振印字位置Para = 銀振印字位置;
        }
        edit(reportSourceWriter, 納入通知書期情報リストEdit, 処理区分);
    }

    /**
     * devidedByPageメソッド
     *
     * @return List<INonyuTsuchisho>
     */
    @Override
    public List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoGinfuriSource>> devidedByPage() {
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 仮算定納入通知書情報.get納入通知書期情報リスト();
        List<NonyuTsuchisho<KarisanteiHokenryoNonyuTsuchishoGinfuriSource>> reportLst = new ArrayList<>();
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

    private KarisanteiHokenryoNonyuTsuchishoGinfuriReport getNewReport(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リストReport) {
        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Report = new KariSanteiNonyuTsuchiShoJoho();
        clone仮算定納入通知書情報(仮算定納入通知書情報Report);
        仮算定納入通知書情報Report.set編集範囲区分(HenshuHaniKubun.全てのレイアウト);
        仮算定納入通知書情報Report.set納入通知書期情報リスト(納入通知書期情報リストReport);
        KarisanteiHokenryoNonyuTsuchishoGinfuriReport report
                = KarisanteiHokenryoNonyuTsuchishoGinfuriReport
                .createFrom(仮算定納入通知書情報Report, ninshoshaSource);
        return report;
    }

    private void clone仮算定納入通知書情報(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Report) {
        仮算定納入通知書情報Report.set仮算定納入通知書制御情報(仮算定納入通知書情報.get仮算定納入通知書制御情報());
        仮算定納入通知書情報Report.set処理区分(仮算定納入通知書情報.get処理区分());
        仮算定納入通知書情報Report.set出力期リスト(仮算定納入通知書情報.get出力期リスト());
        仮算定納入通知書情報Report.set地方公共団体(仮算定納入通知書情報.get地方公共団体());
        仮算定納入通知書情報Report.set帳票ID(仮算定納入通知書情報.get帳票ID());
        仮算定納入通知書情報Report.set帳票分類ID(仮算定納入通知書情報.get帳票分類ID());
        仮算定納入通知書情報Report.set発行日(仮算定納入通知書情報.get発行日());
        仮算定納入通知書情報Report.set算定の基礎(仮算定納入通知書情報.get算定の基礎());
        仮算定納入通知書情報Report.set納付書共通(仮算定納入通知書情報.get納付書共通());
        仮算定納入通知書情報Report.set編集後仮算定通知書共通情報(仮算定納入通知書情報.get編集後仮算定通知書共通情報());
        仮算定納入通知書情報Report.set連番(仮算定納入通知書情報.get連番());
    }

    private void edit(ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriSource> reportSourceWriter,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            ShoriKubun 処理区分) {
        NofuShoKyotsu 納付書共通 = 仮算定納入通知書情報.get納付書共通();
        IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor editor
                = new KarisanteiHokenryoNonyuTsuchishoGinfuriEditor(仮算定納入通知書情報, 納入通知書期情報リスト);
        IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor compNinshoshaEditor
                = new CompNinshoshaEditor(ninshoshaSource);
        IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor compSofubutsuAtesakiEditor
                = new CompSofubutsuAtesakiEditor(仮算定納入通知書情報);
        IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor compSofubutsuAtesaki2Editor
                = new CompSofubutsuAtesaki2Editor(仮算定納入通知書情報);
        IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor compNofushoItemEditor
                = new DBBCompNofushoItemEditor(納付書共通, 納入通知書期情報リスト, 仮算定納入通知書情報.get連番(), 処理区分);
        IKarisanteiHokenryoNonyuTsuchishoGinfuriBuilder builder
                = new KarisanteiHokenryoNonyuTsuchishoGinfuriBuilder(
                        editor,
                        compNinshoshaEditor,
                        compNofushoItemEditor,
                        compSofubutsuAtesakiEditor,
                        compSofubutsuAtesaki2Editor);
        reportSourceWriter.writeLine(builder);
    }

    private boolean is全部の納付額なし(List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト) {
        if (納入通知書期情報リスト.isEmpty()) {
            return true;
        }
        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (null == 納入通知書期情報.get納付額()) {
                continue;
            }
            if (納入通知書期情報.get納付額().compareTo(Decimal.ZERO) > 0) {
                return false;
            }
        }
        return true;
    }

}
