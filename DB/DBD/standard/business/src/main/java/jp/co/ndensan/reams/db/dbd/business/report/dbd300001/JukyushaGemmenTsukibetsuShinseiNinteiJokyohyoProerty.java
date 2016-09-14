/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300001;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300001.JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-3770-040 b_liuyang2
 */
public class JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoProerty extends
        ReportPropertyBase<JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource> {

    /**
     * コンストラクタです。
     */
    public JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoProerty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD300001.getReportId());
    }
}
