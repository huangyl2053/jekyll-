/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha.KyuufuTaishoshaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額介護サービス費給付対象者一覧表帳票Report
 *
 * @reamsid_L DBC-0980-490 surun
 */
public class KogakuKyufuTaishoshaIchiranReport extends Report<KogakuKyufuTaishoshaIchiranSource> {

    private final List<KyuufuTaishoshaHihokenshaEntity> 帳票出力対象データリスト;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private final RDateTime 作成日時;
    private final RString 帳票レコード種別_T1 = new RString("T1");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データリスト List<KyuufuTaishoshaHihokenshaEntity>
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     * @param 作成日時 RDateTime
     */
    public KogakuKyufuTaishoshaIchiranReport(
            List<KyuufuTaishoshaHihokenshaEntity> 帳票出力対象データリスト,
            Map<RString, RString> 出力順Map, List<RString> 改頁リスト, RDateTime 作成日時) {
        this.帳票出力対象データリスト = 帳票出力対象データリスト;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuKyufuTaishoshaIchiranSource> writer) {
        if (null == 帳票出力対象データリスト || 帳票出力対象データリスト.isEmpty()) {
            return;
        }
        for (int index = 0; index < 帳票出力対象データリスト.size(); index++) {
            boolean 集計Flag = false;
            boolean 被保険者氏名Flag = false;
            if (0 == index) {
                被保険者氏名Flag = true;
            } else if (帳票出力対象データリスト.get(index).get対象者().get連番()
                    != 帳票出力対象データリスト.get(index - 1).get対象者().get連番()) {
                被保険者氏名Flag = true;
            }
            if (帳票出力対象データリスト.size() <= (index + 1)) {
                集計Flag = true;
            } else {
                if (帳票レコード種別_T1.equals(帳票出力対象データリスト.get(index + 1).get対象者().get帳票レコード種別())) {
                    集計Flag = true;
                }
            }
            writeLine(writer, 帳票出力対象データリスト.get(index), false, 被保険者氏名Flag);
            if (集計Flag) {
                writeLine(writer, 帳票出力対象データリスト.get(index + 1), true, false);
                index = index + 1;
            }

        }

    }

    private void writeLine(ReportSourceWriter<KogakuKyufuTaishoshaIchiranSource> writer,
            KyuufuTaishoshaHihokenshaEntity 帳票出力対象データ, boolean 集計Flag, boolean 被保険者氏名Flag) {
        IKogakuKyufuTaishoshaIchiranEditor headerEditor
                = new KogakuKyufuTaishoshaIchiranHeaderEditor(
                        帳票出力対象データ, 出力順Map, 改頁リスト, 作成日時);
        IKogakuKyufuTaishoshaIchiranEditor bodyEditor
                = new KogakuKyufuTaishoshaIchiranBodyEditor(帳票出力対象データ, 集計Flag, 被保険者氏名Flag);
        IKogakuKyufuTaishoshaIchiranBuilder builder
                = new KogakuKyufuTaishoshaIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
