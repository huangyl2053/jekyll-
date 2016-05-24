/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBRP43002_5_介護保険料額変更通知書発行一覧表 KaigoHokenryogakuReport
 *
 * @reamsid_L DBB-0780-120 yangchenbing
 */
public class KaigoHokenryogakuReport extends Report<KaigoHokenryogakuSource> {

    private final RString タイトル;
    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final RDateTime 帳票作成日時;
    private final Association 地方公共団体;
    private final List<RString> 並び順List;
    private final Decimal 連番;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 帳票作成日時 RDateTime
     * @param 地方公共団体 Association
     * @param 並び順List List<RString>
     * @param 連番 Decimal
     * @param タイトル RString
     */
    public KaigoHokenryogakuReport(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RDateTime 帳票作成日時,
            Association 地方公共団体,
            List<RString> 並び順List,
            Decimal 連番,
            RString タイトル) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.帳票作成日時 = 帳票作成日時;
        this.地方公共団体 = 地方公共団体;
        this.並び順List = 並び順List;
        this.連番 = 連番;
        this.タイトル = タイトル;
    }

    /**
     * writeBy
     *
     * @param reportSourceWriter reportSourceWriter
     */
    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenryogakuSource> reportSourceWriter) {
        IKaigoHokenryogakuEditor editor
                = new KaigoHokenryogakuEditor(編集後本算定通知書共通情報, 帳票作成日時, 地方公共団体, 並び順List, 連番, タイトル);
        IKaigoHokenryogakuBuilder builder = new KaigoHokenryogakuBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
