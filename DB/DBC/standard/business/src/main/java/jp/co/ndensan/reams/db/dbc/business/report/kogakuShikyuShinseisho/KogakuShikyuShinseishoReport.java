/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.business.report.kogakuShikyuShinseisho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseisho.KogakuShikyuShinseishoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額介護（予防）サービス費支給申請書帳票Report
 *
 * @author fzou
 */
public class KogakuShikyuShinseishoReport extends
        Report<KogakuShikyuShinseishoSource> {

    @Override
    protected void writeBy(ReportSourceWriter<KogakuShikyuShinseishoSource> writer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
