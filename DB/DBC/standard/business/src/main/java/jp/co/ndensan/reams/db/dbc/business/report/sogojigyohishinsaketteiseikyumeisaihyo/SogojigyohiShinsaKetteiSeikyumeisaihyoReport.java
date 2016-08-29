/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishinsaketteiseikyumeisaihyo;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohishinsaketteiseikyumeisaihyo.SogojigyohiShinsaKetteiSeikyumeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 帳票設計_DBC200070_介護予防・日常生活支援総合事業費審査決定請求明細表帳票Reportクラスです
 *
 * @reamsid_L DBC-2500-031 jiangwenkai
 */
public class SogojigyohiShinsaKetteiSeikyumeisaihyoReport extends Report<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> {

    private final SogojigyohiShinsaKetteiSeikyumeisaihyoEntity 帳票出力対象データ;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private final RDateTime 作成日時;
    private final boolean 合計出力flag;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ DbWT1613SinsaKetteiSeikyuGokeiTempEntity
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 RDateTime
     * @param 合計出力flag boolean
     * @param 改頁リスト List<RString>
     */
    public SogojigyohiShinsaKetteiSeikyumeisaihyoReport(
            SogojigyohiShinsaKetteiSeikyumeisaihyoEntity 帳票出力対象データ,
            Map<RString, RString> 出力順Map,
            RDateTime 作成日時,
            boolean 合計出力flag,
            List<RString> 改頁リスト) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.出力順Map = 出力順Map;
        this.作成日時 = 作成日時;
        this.合計出力flag = 合計出力flag;
        this.改頁リスト = 改頁リスト;
    }

    @Override
    public void writeBy(ReportSourceWriter<SogojigyohiShinsaKetteiSeikyumeisaihyoSource> reportSourceWriter) {
        ISogojigyohiShinsaKetteiSeikyumeisaihyoEditor headerEditor
                = new SogojigyohiShinsaKetteiSeikyumeisaihyoHeaderEditor(出力順Map, 作成日時, 帳票出力対象データ, 改頁リスト);
        ISogojigyohiShinsaKetteiSeikyumeisaihyoEditor bodyEditor = new SogojigyohiShinsaKetteiSeikyumeisaihyoBodyEditor(帳票出力対象データ, 合計出力flag);
        ISogojigyohiShinsaKetteiSeikyumeisaihyoBuilder builder
                = new SogojigyohiShinsaKetteiSeikyumeisaihyoBuilder(headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }
}
