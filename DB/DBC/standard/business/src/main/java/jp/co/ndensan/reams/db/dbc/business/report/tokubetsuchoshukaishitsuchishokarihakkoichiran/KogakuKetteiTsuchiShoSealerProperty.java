/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer.KogakuKetteiTsuchiShoSealerSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranPropertyクラスです。
 *
 * @reamsid_L DBC-2000-060 lijian
 */
public class KogakuKetteiTsuchiShoSealerProperty extends
        ReportPropertyBase<KogakuKetteiTsuchiShoSealerSource> {

    /**
     * コンストラクタです。
     *
     */
    public KogakuKetteiTsuchiShoSealerProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100009.getReportId());
    }

}
