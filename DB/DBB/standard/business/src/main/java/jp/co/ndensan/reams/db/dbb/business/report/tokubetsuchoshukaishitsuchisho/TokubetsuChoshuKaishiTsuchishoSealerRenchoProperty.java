/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 特別徴収開始通知書（本算定）帳票【シーラタイプ（連帳）】
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoSealerRenchoProperty
        extends ReportPropertyBase<TokubetsuChoshuKaishiTsuchishoSealerRenchoSource> {

    /**
     * コンストラクタです。
     */
    public TokubetsuChoshuKaishiTsuchishoSealerRenchoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100035.getReportId());
    }

}
