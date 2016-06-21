/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyodoshorijukyushateiseirenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyodoshorijukyushateiseirenrakuhyo.KyodoShoriJukyushaTeiseiRenrakuhyoSource;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN81004_共同処理用受給者訂正連絡票（紙媒体）Reportのインターフェースクラスです。
 *
 * @reamsid_L DBC-1951-060 chenaoqi
 */
public class KyodoShoriJukyushaTeiseiRenrakuhyoReport extends Report<KyodoShoriJukyushaTeiseiRenrakuhyoSource> {

    private final KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity targets;
    private final List<KoikiZenShichosonJoho> 広域市町村情報List;

    /**
     * インスタンスを生成します。
     *
     * @param targets 出力用共同処理受給者訂正情報Entity
     * @param 広域市町村情報List List<KoikiZenShichosonJoho>
     */
    public KyodoShoriJukyushaTeiseiRenrakuhyoReport(KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity targets,
            List<KoikiZenShichosonJoho> 広域市町村情報List) {

        this.targets = targets;
        this.広域市町村情報List = 広域市町村情報List;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyodoShoriJukyushaTeiseiRenrakuhyoSource> reportSourceWriter) {
        IKyodoShoriJukyushaTeiseiRenrakuhyoEditor editor = new KyodoShoriJukyushaTeiseiRenrakuhyoEditor(targets, 広域市町村情報List);
        IKyodoShoriJukyushaTeiseiRenrakuhyoBuilder builder = new KyodoShoriJukyushaTeiseiRenrakuhyoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
