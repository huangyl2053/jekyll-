/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kaigojuryoininkeiyakujigyoshaichirahyo;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigojuryoininkeiyakujigyoshaichirahyo.KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.juryoininjigyoshaichiran.JuryoIninJigyoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN32001_受領委任契約事業者一覧表帳票Reportのインターフェースクラスです。
 *
 * @reamsid_L DBC-2110-040 liuxiaoyu
 */
public class JuryoIninJigyoshaIchiranReport extends Report<JuryoIninJigyoshaIchiranSource> {

    private final KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final LasdecCode 市町村コード;
    private final RString 市町村名称;
    private final RDateTime 処理日時;
    private final List<RString> 改頁項目;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力対象データ JuryoIninJigyoshaIchiranEntity
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @param 出力順Map Map<RString, RString>
     * @param 処理日時 RDateTime
     * @param 改頁項目 List<RString>
     */
    public JuryoIninJigyoshaIchiranReport(
            KaigoJuryoininKeiyakuJigyoshaIchirahyoEntity 帳票出力対象データ,
            LasdecCode 市町村コード,
            RString 市町村名称,
            RDateTime 処理日時,
            Map<RString, RString> 出力順Map,
            List<RString> 改頁項目
    ) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.処理日時 = 処理日時;
        this.出力順Map = 出力順Map;
        this.改頁項目 = 改頁項目;

    }

    @Override
    public void writeBy(ReportSourceWriter<JuryoIninJigyoshaIchiranSource> reportSourceWriter
    ) {

        IJuryoIninJigyoshaIchiranEditor headerEditor = new JuryoIninJigyoshaIchiranHeaderEditor(
                市町村コード, 市町村名称, 処理日時, 出力順Map, 改頁項目);
        IJuryoIninJigyoshaIchiranEditor bodyEditor = new JuryoIninJigyoshaIchiranBodyEditor(
                帳票出力対象データ);
        IJuryoIninJigyoshaIchiranBuilder builder = new JuryoIninJigyoshaIchiranBuilder(
                headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);

    }
}
