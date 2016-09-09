/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho;

import jp.co.ndensan.reams.db.dbc.entity.report.jikofutangakushomeisho.JikoFutangakushomeishoReportSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;

/**
 * 自己負担証明書のEditorです。
 *
 * @reamsid_L DBC-4810-030 sunhaidi
 */
public class CompNinshoshaEditor implements IJikoFutangakushomeishoEditor {

    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param ninshoshaSource NinshoshaSource
     */
    protected CompNinshoshaEditor(NinshoshaSource ninshoshaSource) {
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public JikoFutangakushomeishoReportSource edit(JikoFutangakushomeishoReportSource source) {
        source.denshiKoin = ninshoshaSource.denshiKoin;
        source.hakkoYMD = ninshoshaSource.hakkoYMD;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
        return source;
    }

}
