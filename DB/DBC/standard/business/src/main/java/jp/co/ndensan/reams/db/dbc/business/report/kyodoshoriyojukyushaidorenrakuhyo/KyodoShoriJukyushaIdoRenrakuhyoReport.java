/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyodoshoriyojukyushaidorenrakuhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshoriyojukyushaidorenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyodoshorijukyushaidorenrakuhyo.KyodoShoriJukyushaIdoRenrakuhyoSource;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN81003_共同処理用受給者異動連絡票（紙媒体）Reportのインターフェースクラスです。
 *
 * @reamsid_L DBC-1950-050 chenaoqi
 */
public class KyodoShoriJukyushaIdoRenrakuhyoReport extends Report<KyodoShoriJukyushaIdoRenrakuhyoSource> {

    private final KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity targets;
    private final List<KoikiZenShichosonJoho> 広域市町村情報List;

    /**
     * インスタンスを生成します。
     *
     * @param targets 共同処理用受給者異動連絡票Entity
     * @param 広域市町村情報List List<KoikiZenShichosonJoho>
     */
    public KyodoShoriJukyushaIdoRenrakuhyoReport(KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity targets,
            List<KoikiZenShichosonJoho> 広域市町村情報List) {

        this.targets = targets;
        this.広域市町村情報List = 広域市町村情報List;
    }

    @Override
    public void writeBy(ReportSourceWriter<KyodoShoriJukyushaIdoRenrakuhyoSource> reportSourceWriter) {
        IKyodoShoriJukyushaIdoRenrakuhyoEditor editor = new KyodoShoriJukyushaIdoRenrakuhyoEditor(targets, 広域市町村情報List);
        IKyodoShoriJukyushaIdoRenrakuhyoBuilder builder = new KyodoShoriJukyushaIdoRenrakuhyoBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
