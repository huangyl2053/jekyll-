/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho.KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource;

/**
 * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書エディターです。
 *
 */
public class KeidoshaFukushiYoguTaiyoKakuninShinseishoEditorImpl implements IKeidoshaFukushiYoguTaiyoKakuninShinseishoEditor {

    private final KeidoshaFukushiYoguTaiyoKakuninShinseishoItem item;

    /**
     * コンストラクタです。
     *
     * @param item KeidoshaFukushiYoguTaiyoKakuninShinseishoItem
     */
    public KeidoshaFukushiYoguTaiyoKakuninShinseishoEditorImpl(KeidoshaFukushiYoguTaiyoKakuninShinseishoItem item) {
        this.item = item;
    }

    /**
     * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書エディターです。
     *
     * @param source 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書
     * @return KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource
     */
    @Override
    public KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource edit(KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource source) {
        return editBody(source);
    }

    private KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource editBody(KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource source) {
        source.tsuchiBun1 = item.getTsuchiBun1();
        source.jusho = item.getJusho();
        source.shimei = item.getShimei();
        source.hihokenshaNo = item.getHihokenshaNo();
        source.tsuchiBun2 = item.getTsuchiBun2();
        source.remban = item.getRemban();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        return source;
    }
}
