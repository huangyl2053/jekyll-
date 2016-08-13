/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuoshirasetsuchiteshutsukigen;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuoshirasetsuchiteshutsukigennashi.KogakuOshiraseTsuchiTeshutsuKigenNashiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuoshirasetsuchiteshutsukigennashi.KogakuOshiraseTsuchiTeshutsuKigenNashiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額サービス給付のお知らせ通知書（提出期限なし）帳票Report
 *
 * @reamsid_L DBC-4770-050 fzou
 */
public class KogakuOshiraseTsuchiTeshutsuKigenNashiReport extends
        Report<KogakuOshiraseTsuchiTeshutsuKigenNashiSource> {

    private final KogakuOshiraseTsuchiTeshutsuKigenNashiEntity target;

    /**
     * コンストラクタです。
     *
     * @param target target
     */
    public KogakuOshiraseTsuchiTeshutsuKigenNashiReport(KogakuOshiraseTsuchiTeshutsuKigenNashiEntity target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuOshiraseTsuchiTeshutsuKigenNashiSource> writer) {
        IKogakuOshiraseTsuchiTeshutsuKigenNashiEditor editor = new KogakuOshiraseTsuchiTeshutsuKigenNashiEditor(target);
        IKogakuOshiraseTsuchiTeshutsuKigenNashiBuilder builder = new KogakuOshiraseTsuchiTeshutsuKigenNashiBuilder(editor);
        writer.writeLine(builder);
    }

}
