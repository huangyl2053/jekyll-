/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyosofuichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyosofuichiran.KyufuKanrihyoSofuIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyosofuichiran.KyufuKanrihyoSofuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200009_給付管理票送付一覧表のReportです。
 *
 * @reamsid_L DBC-2840-041 kanghongsong
 */
public class KyufuKanrihyoSofuIchiranReport extends Report<KyufuKanrihyoSofuIchiranReportSource> {

    private final KyufuKanrihyoSofuIchiranEntity entity;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;

    /**
     * インスタンスを生成するメソッド。
     *
     * @param entity 給付管理票送付一覧表
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     *
     */
    public KyufuKanrihyoSofuIchiranReport(KyufuKanrihyoSofuIchiranEntity entity, Map<RString, RString> 出力順Map, List<RString> 改頁リスト) {
        this.entity = entity;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyufuKanrihyoSofuIchiranReportSource> reportSourceWriter) {
        KyufuKanrihyoSofuIchiranEditor editor = new KyufuKanrihyoSofuIchiranEditor(entity, 出力順Map, 改頁リスト);
        IKyufuKanrihyoSofuIchiranBuilder builder = new KyufuKanrihyoSofuIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
