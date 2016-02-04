/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho2;

import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho2.KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource;

/**
 * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2エディターです。
 *
 */
public class KeidoshaFukushiYoguTaiyoKakuninShinseisho2EditorImpl implements IKeidoshaFukushiYoguTaiyoKakuninShinseisho2Editor {

    private final KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item item;

    /**
     * コンストラクタです。
     *
     * @param item KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item
     */
    public KeidoshaFukushiYoguTaiyoKakuninShinseisho2EditorImpl(KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item item) {
        this.item = item;
    }

    /**
     * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2エディターです。
     *
     * @param source 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2
     * @return KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource
     */
    @Override
    public KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource edit(KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource source) {
        return editBody(source);
    }

    private KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource editBody(KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource source) {
        source.tsuchiBun1 = item.getTsuchiBun1();
        source.tsuchiBun2 = item.getTsuchiBun2();
        source.tsuchiBun3 = item.getTsuchiBun3();
        source.remban = item.getRemban();
        return source;
    }
}
