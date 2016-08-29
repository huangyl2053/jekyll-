/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120920;


import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc120920.SogojigyohiShinsaKetteiSeikyumeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200084_総合事業費審査決定請求明細表帳票Report
 *
 * @reamsid_L DBC-2500-032 jiangxiaolong
 */
public class SogojigyohiShinsaKetteiSeikyumeisaiInReport
        extends Report<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> {

    private final SogojigyohiShinsaKetteiSeikyumeisaiInEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final RDateTime 作成日時;
    private final List<RString> 改頁リスト;
    private final boolean 集計Flag;

    /**
     *
     * @param 帳票出力対象データ SogojigyohiShinsaKetteiSeikyumeisaiInEntity
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 RDateTime
     * @param 集計Flag boolean
     * @param 改頁リスト List<RString>
     */
    public SogojigyohiShinsaKetteiSeikyumeisaiInReport(
            SogojigyohiShinsaKetteiSeikyumeisaiInEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map, RDateTime 作成日時, boolean 集計Flag, List<RString> 改頁リスト) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.作成日時 = 作成日時;
        this.改頁リスト = 改頁リスト;
        this.集計Flag = 集計Flag;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> writer) {
        writeLine(writer, 帳票出力対象データ, 集計Flag);
    }

    private void writeLine(ReportSourceWriter<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> writer,
            SogojigyohiShinsaKetteiSeikyumeisaiInEntity 帳票出力対象データ, boolean 集計Flag) {
        ISogojigyohiShinsaKetteiSeikyumeisaiInEditor headerEditor
                = new SogojigyohiShinsaKetteiSeikyumeisaiInHeaderEditor(帳票出力対象データ, 出力順Map, 作成日時, 改頁リスト);
        ISogojigyohiShinsaKetteiSeikyumeisaiInEditor bodyEditor
                = new SogojigyohiShinsaKetteiSeikyumeisaiInBodyEditor(帳票出力対象データ, 集計Flag);
        ISogojigyohiShinsaKetteiSeikyumeisaiInBuilder builder
                = new SogojigyohiShinsaKetteiSeikyumeisaiInBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
