/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeishofrom2009;

import jp.co.ndensan.reams.db.dbc.entity.report.source.jikofutangakushomeishofrom2009.JikoFutangakushomeishoFrom2009ReportSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;

/**
 * 自己負担証明書_2009年以降のEditorです。
 *
 * @reamsid_L DBC-4810-040 kanghongsong
 */
public class CompNinshoshaEditor implements IJikoFutangakushomeishoFrom2009Editor {

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
    public JikoFutangakushomeishoFrom2009ReportSource edit(JikoFutangakushomeishoFrom2009ReportSource source) {
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
