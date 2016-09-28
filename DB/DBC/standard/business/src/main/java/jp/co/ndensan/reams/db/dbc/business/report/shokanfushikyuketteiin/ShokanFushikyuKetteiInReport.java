/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanfushikyuketteiin.ShokanbaraiFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200022_償還払不支給決定者一覧表 ShokanFushikyuKetteiInReport
 *
 * @reamsid_L DBC-2590-040 xuhao
 */
public class ShokanFushikyuKetteiInReport extends Report<ShokanbaraiFushikyuKetteishaIchiranSource> {

    private final ShokanFushikyuKetteiInEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁項目;
    private final RString 編集住所;
    private final RDateTime 作成日時;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票出力対象データ ShokanFushikyuKetteiInEntity
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     * @param 作成日時 RDateTime
     * @param 編集住所 RString
     */
    public ShokanFushikyuKetteiInReport(
            ShokanFushikyuKetteiInEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map,
            List<RString> 改頁リスト,
            RDateTime 作成日時,
            RString 編集住所
    ) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.改頁項目 = 改頁リスト;
        this.作成日時 = 作成日時;
        this.編集住所 = 編集住所;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanbaraiFushikyuKetteishaIchiranSource> reportSourceWriter) {
        IShokanFushikyuKetteiInEditor headerEditor = new ShokanFushikyuKetteiInHeaderEditor(
                帳票出力対象データ, 出力順Map, 改頁項目, 作成日時);
        IShokanFushikyuKetteiInEditor bodyEditor = new ShokanFushikyuKetteiInBodyEditor(
                帳票出力対象データ, 編集住所);
        IShokanFushikyuKetteiInBuilder builder = new ShokanFushikyuKetteiInBuilder(
                headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }
}
