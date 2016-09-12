/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）TokubetsuChoshuKaishiReport
 *
 * @reamsid_L DBB-0780-100 yangchenbing
 */
public class TokubetsuChoshuKaishiReport extends Report<TokubetsuChoshuKaishiSource> {

    private final EditedHonSanteiTsuchiShoKyotsu editedhonsanteitsuchishokyotsu;
    private final FlexibleYear 賦課年度;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final RDateTime 帳票作成日時;
    private final List<RString> 改頁項目リスト;
    private final List<RString> 出力項目リスト;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param editedhonsanteitsuchishokyotsu EditedHonSanteiTsuchiShoKyotsu
     * @param 賦課年度 FlexibleYear
     * @param 帳票作成日時 RDateTime
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param 連番 int
     */
    public TokubetsuChoshuKaishiReport(EditedHonSanteiTsuchiShoKyotsu editedhonsanteitsuchishokyotsu, FlexibleYear 賦課年度,
            RDateTime 帳票作成日時, RString 市町村コード, RString 市町村名, List<RString> 出力項目リスト, List<RString> 改頁項目リスト, int 連番) {
        this.editedhonsanteitsuchishokyotsu = editedhonsanteitsuchishokyotsu;
        this.賦課年度 = 賦課年度;
        this.帳票作成日時 = 帳票作成日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.改頁項目リスト = 改頁項目リスト;
        this.出力項目リスト = 出力項目リスト;
        this.連番 = 連番;
    }

    /**
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiSource> reportSourceWriter) {
        ITokubetsuChoshuKaishiEditor tokubetsuchoshukaishieditor = new TokubetsuChoshuKaishiEditor(
                editedhonsanteitsuchishokyotsu, 賦課年度, 出力項目リスト, 改頁項目リスト, 帳票作成日時, 市町村コード, 市町村名, 連番);
        TokubetsuChoshuKaishiBuilder builder = new TokubetsuChoshuKaishiBuilder(tokubetsuchoshukaishieditor);
        reportSourceWriter.writeLine(builder);
    }
}
