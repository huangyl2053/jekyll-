/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoKetteiKohifutanshaChohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteikohifutanshain.KagoKetteiKohifutanshaInSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 誤決定通知書情報取込一覧表（公費負担者分）帳票Report
 *
 * @reamsid_L DBC-0980-510 surun
 */
public class KagoKetteiKohifutanshaInReport extends
        Report<KagoKetteiKohifutanshaInSource> {

    private final List<KagoKetteiKohifutanshaChohyoEntity> 帳票出力対象データリスト;
    private final Map<RString, RString> 出力順Map;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データリスト List<KagoKetteiKohifutanshaChohyoEntity>
     * @param 出力順Map Map<RString, RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     */
    public KagoKetteiKohifutanshaInReport(List<KagoKetteiKohifutanshaChohyoEntity> 帳票出力対象データリスト,
            Map<RString, RString> 出力順Map, FlexibleYearMonth 処理年月, RDateTime 作成日時) {
        this.帳票出力対象データリスト = 帳票出力対象データリスト;
        this.出力順Map = 出力順Map;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<KagoKetteiKohifutanshaInSource> writer) {

        if (null == 帳票出力対象データリスト || 帳票出力対象データリスト.isEmpty()) {
            return;
        }
        for (int index = 0; index < 帳票出力対象データリスト.size(); index++) {
            boolean 集計Flag = false;
            if (帳票出力対象データリスト.size() <= (index + 1)) {
                集計Flag = true;
            } else {
                ShoKisaiHokenshaNo 公費負担者番号 = 帳票出力対象データリスト.get(index).get公費負担者番号();
                ShoKisaiHokenshaNo 公費負担者番号Next = 帳票出力対象データリスト.get(index + 1).get公費負担者番号();
                if (!公費負担者番号.equals(公費負担者番号Next)) {
                    集計Flag = true;
                }
            }
            IKagoKetteiKohifutanshaInEditor headerEditor = new KagoKetteiKohifutanshaInHeaderEditor(
                    帳票出力対象データリスト.get(index), 出力順Map, 処理年月, 作成日時);
            IKagoKetteiKohifutanshaInEditor bodyEditor
                    = new KagoKetteiKohifutanshaInBodyEditor(帳票出力対象データリスト.get(index), 集計Flag);
            IKagoKetteiKohifutanshaInBuilder builder
                    = new KagoKetteiKohifutanshaInBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

}
