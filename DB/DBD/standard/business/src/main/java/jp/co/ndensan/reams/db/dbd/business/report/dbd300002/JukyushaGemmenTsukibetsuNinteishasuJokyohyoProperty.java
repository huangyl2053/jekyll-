/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300002;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300002.JukyushaGemmenTsukibetsuNinteishasuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link JukyushaGemmenTsukibetsuNinteishasuJokyohyoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3770-050 jinge
 */
public class JukyushaGemmenTsukibetsuNinteishasuJokyohyoProperty extends
        ReportPropertyBase<JukyushaGemmenTsukibetsuNinteishasuJokyohyoReportSource> {

    /**
     * コンストラクタです。
     */
    public JukyushaGemmenTsukibetsuNinteishasuJokyohyoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD300002.getReportId());
    }
}
