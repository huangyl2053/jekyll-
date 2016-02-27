/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho2;

import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho2.KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2の帳票作成します。
 *
 */
public final class KeidoshaFukushiYoguTaiyoKakuninShinseisho2Report extends Report<KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource> {

    private final KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item item;

    private KeidoshaFukushiYoguTaiyoKakuninShinseisho2Report(KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item item) {
        this.item = item;
    }

    /**
     * インスタンスを生成します。
     *
     * @param item 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2Entityリスト
     * @return KeidoshaFukushiYoguTaiyoKakuninShinseisho2Report
     */
    public static KeidoshaFukushiYoguTaiyoKakuninShinseisho2Report createReport(@NonNull KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item item) {
        return new KeidoshaFukushiYoguTaiyoKakuninShinseisho2Report(item);
    }

    /**
     * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2writeByします。
     *
     * @param writer 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2_帳票クラスパラメータ
     */
    @Override
    public void writeBy(ReportSourceWriter<KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource> writer) {
        IKeidoshaFukushiYoguTaiyoKakuninShinseisho2Editor joho = new KeidoshaFukushiYoguTaiyoKakuninShinseisho2EditorImpl(item);
        IKeidoshaFukushiYoguTaiyoKakuninShinseisho2Builder builder = new KeidoshaFukushiYoguTaiyoKakuninShinseisho2BuilderImpl(joho);
        writer.writeLine(builder);
    }
}
