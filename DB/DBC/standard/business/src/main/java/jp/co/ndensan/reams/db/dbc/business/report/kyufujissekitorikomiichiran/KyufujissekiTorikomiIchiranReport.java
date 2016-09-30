/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufujissekitorikomiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekitorikomiichiran.KyufujissekiTorikomiIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufujissekitorikomiichiran.KyufujissekiTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200007_給付実績情報取込結果一覧表 のReportクラスです。
 *
 * @reamsid_L DBC-2440-030 qinzhen
 */
public class KyufujissekiTorikomiIchiranReport extends Report<KyufujissekiTorikomiIchiranSource> {

    private final List<RString> 並び順リスト;
    private final List<RString> 改頁リスト;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final int 連番;
    private final KyufujissekiTorikomiIchiranEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakuGassanDataEntity
     * @param 並び順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 連番 int
     */
    public KyufujissekiTorikomiIchiranReport(KyufujissekiTorikomiIchiranEntity entity, List<RString> 並び順リスト,
            List<RString> 改頁リスト, FlexibleYearMonth 処理年月, RDateTime 作成日時, int 連番) {
        this.entity = entity;
        this.並び順リスト = 並び順リスト;
        this.改頁リスト = 改頁リスト;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyufujissekiTorikomiIchiranSource> writer) {

        IKyufujissekiTorikomiIchiranEditor editor = new KyufujissekiTorikomiIchiranEditor(entity, 並び順リスト, 改頁リスト, 処理年月, 作成日時, 連番);
        IKyufujissekiTorikomiIchiranBuilder builder = new KyufujissekiTorikomiIchiranBuilder(editor);

        writer.writeLine(builder);

    }
}
