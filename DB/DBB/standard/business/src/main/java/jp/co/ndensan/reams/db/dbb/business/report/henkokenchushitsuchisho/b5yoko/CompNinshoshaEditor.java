/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.henkokenchushitsuchisho.b5yoko;

import jp.co.ndensan.reams.db.dbb.entity.report.henkokenchushitsuchisho.KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;

/**
 *
 * 介護保険料額変更兼特別徴収中止通知書のB5横タイプのEditorです。
 *
 * @reamsid_L DBB-9080-020 sunhaidi
 */
public class CompNinshoshaEditor implements IKaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoEditor {

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
    public KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource edit(KaigoHokenryogakuHenkoKenChushiTsuchishoB5YokoReportSource source) {
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
