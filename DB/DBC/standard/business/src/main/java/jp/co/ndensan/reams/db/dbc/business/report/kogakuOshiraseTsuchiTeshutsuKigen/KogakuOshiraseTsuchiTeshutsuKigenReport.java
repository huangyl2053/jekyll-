/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.business.report.kogakuOshiraseTsuchiTeshutsuKigen;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuoshirasetsuchiteshutsukigennashi.KogakuOshiraseTsuchiTeshutsuKigenNashiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額サービス給付のお知らせ通知書（提出期限なし）帳票Report
 *
 * @author fzou
 */
public class KogakuOshiraseTsuchiTeshutsuKigenReport extends
        Report<KogakuOshiraseTsuchiTeshutsuKigenNashiSource> {

    @Override
    protected void writeBy(ReportSourceWriter<KogakuOshiraseTsuchiTeshutsuKigenNashiSource> writer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
