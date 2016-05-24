/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nonyutsuchishohonsanteihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBRP43002_2_保険料納入通知書（本算定）NonyuTsuchIchiranReport
 *
 * @reamsid_L DBB-0780-080 yangchenbing
 */
public class NonyuTsuchIchiranReport extends Report<NonyuTsuchIchiranSource> {

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final int 出力期;
    private final RDateTime 帳票作成日時;
    private final Association 地方公共団体;
    private final List<RString> 並び順List;
    private final Decimal 連番;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 出力期 int
     * @param 帳票作成日時 RDateTime
     * @param 地方公共団体 Association
     * @param 並び順List List<RString>
     * @param 連番 Decimal
     */
    public NonyuTsuchIchiranReport(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            int 出力期,
            RDateTime 帳票作成日時,
            Association 地方公共団体,
            List<RString> 並び順List,
            Decimal 連番) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.出力期 = 出力期;
        this.帳票作成日時 = 帳票作成日時;
        this.地方公共団体 = 地方公共団体;
        this.並び順List = 並び順List;
        this.連番 = 連番;
    }

    /**
     * writeBy
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchIchiranSource> reportSourceWriter) {
        INonyuTsuchIchiranEditor headerEditor
                = new NonyuTsuchIchiranEditor(編集後本算定通知書共通情報, 出力期, 帳票作成日時, 地方公共団体, 並び順List, 連番);
        INonyuTsuchIchiranBuilder builder = new NonyuTsuchIchiranBuilder(headerEditor);
        reportSourceWriter.writeLine(builder);
    }
}
