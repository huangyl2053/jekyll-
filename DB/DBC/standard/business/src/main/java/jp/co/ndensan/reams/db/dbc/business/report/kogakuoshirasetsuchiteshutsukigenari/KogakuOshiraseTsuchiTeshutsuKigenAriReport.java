/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuoshirasetsuchiteshutsukigenari;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuoshirasetsuchiteshutsukigenari.KogakuOshiraseTsuchiTeshutsuKigenAriEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuoshirasetsuchiteshutsukigenari.KogakuOshiraseTsuchiTeshutsuKigenAriSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額サービス給付のお知らせ通知書（提出期限あり）の出力クラスです。
 *
 * @reamsid_L DBC-4770-040 zhujun
 */
public class KogakuOshiraseTsuchiTeshutsuKigenAriReport extends Report<KogakuOshiraseTsuchiTeshutsuKigenAriSource> {

    private final KogakuOshiraseTsuchiTeshutsuKigenAriEntity target;

    /**
     * コンストラクタです。
     *
     * @param target target
     */
    public KogakuOshiraseTsuchiTeshutsuKigenAriReport(KogakuOshiraseTsuchiTeshutsuKigenAriEntity target) {
        this.target = target;
    }

    @Override
    protected void writeBy(ReportSourceWriter<KogakuOshiraseTsuchiTeshutsuKigenAriSource> writer) {
        IKogakuOshiraseTsuchiTeshutsuKigenAriEditor editor = new KogakuOshiraseTsuchiTeshutsuKigenAriEditor(target);
        IKogakuOshiraseTsuchiTeshutsuKigenAriBuilder builder = new KogakuOshiraseTsuchiTeshutsuKigenAriBuilder(editor);
        writer.writeLine(builder);
    }
}
