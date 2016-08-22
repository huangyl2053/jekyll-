/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufuhishinsaketteiseikyumeisaihyo.KyufuhiShinsaKetteiSeikyuMeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護給付費等審査決定請求明細表のReportクラスです。
 *
 * @reamsid_L DBC-2500-030 jiangxiaolong
 */
public class KyufuhiShinsaKetteiSeikyuMeisaihyoReport extends Report<KyufuhiShinsaKetteiSeikyuMeisaihyoSource> {

    private final KyufuhiShinsaKetteiSeikyuMeisaihyoEntity 帳票出力対象;
    private final Map<RString, RString> 出力順Map;
    private final RDateTime 作成日時;
    private boolean 出力Flag = false;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象 KyufuhiShinsaKetteiSeikyuMeisaihyoEntity
     * @param 出力順Map Map<RString, RString>
     * @param 作成日時 RDateTime
     * @param 出力Flag boolean
     */
    public KyufuhiShinsaKetteiSeikyuMeisaihyoReport(
            KyufuhiShinsaKetteiSeikyuMeisaihyoEntity 帳票出力対象,
            Map<RString, RString> 出力順Map,
            RDateTime 作成日時,
            boolean 出力Flag) {
        this.帳票出力対象 = 帳票出力対象;
        this.出力順Map = 出力順Map;
        this.作成日時 = 作成日時;
        this.出力Flag = 出力Flag;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyufuhiShinsaKetteiSeikyuMeisaihyoSource> writer) {
        IKyufuhiShinsaKetteiSeikyuMeisaihyoEditor headerEditor
                = new KyufuhiShinsaKetteiSeikyuMeisaihyoHeaderEditor(帳票出力対象,
                        出力順Map, 作成日時);
        IKyufuhiShinsaKetteiSeikyuMeisaihyoEditor bodyEditor
                = new KyufuhiShinsaKetteiSeikyuMeisaihyoBodyEditor(
                        帳票出力対象, 出力Flag);
        IKyufuhiShinsaKetteiSeikyuMeisaihyoBuilder builder
                = new KyufuhiShinsaKetteiSeikyuMeisaihyoBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }
}
