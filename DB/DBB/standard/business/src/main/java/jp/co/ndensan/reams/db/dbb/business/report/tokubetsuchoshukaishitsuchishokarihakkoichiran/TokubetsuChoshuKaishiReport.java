/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
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

    private final RString 生活保護区分;
    private final RString 特徴10月開始者区分;
    private final HonSanteiTsuchiShoKyotsu 本算定通知書情報;
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
     * @param 生活保護区分 RString
     * @param 特徴10月開始者区分 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @param editedhonsanteitsuchishokyotsu EditedHonSanteiTsuchiShoKyotsu
     * @param 賦課年度 FlexibleYear
     * @param 帳票作成日時 RDateTime
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param 連番 int
     */
    public TokubetsuChoshuKaishiReport(RString 生活保護区分, RString 特徴10月開始者区分, HonSanteiTsuchiShoKyotsu 本算定通知書情報,
            EditedHonSanteiTsuchiShoKyotsu editedhonsanteitsuchishokyotsu, FlexibleYear 賦課年度,
            RDateTime 帳票作成日時, RString 市町村コード, RString 市町村名, List<RString> 出力項目リスト, List<RString> 改頁項目リスト, int 連番) {
        this.生活保護区分 = 生活保護区分;
        this.特徴10月開始者区分 = 特徴10月開始者区分;
        this.本算定通知書情報 = 本算定通知書情報;
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
        ITokubetsuChoshuKaishiEditor tokubetsuchoshukaishieditor
                = new TokubetsuChoshuKaishiEditor(生活保護区分, 特徴10月開始者区分, 本算定通知書情報,
                        editedhonsanteitsuchishokyotsu, 賦課年度, 出力項目リスト, 改頁項目リスト, 帳票作成日時, 市町村コード, 市町村名, 連番);
        TokubetsuChoshuKaishiBuilder builder = new TokubetsuChoshuKaishiBuilder(tokubetsuchoshukaishieditor);
        reportSourceWriter.writeLine(builder);
    }
}
