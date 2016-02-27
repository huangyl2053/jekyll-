/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho.KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書Builderクラスです。
 *
 */
public class KeidoshaFukushiYoguTaiyoKakuninShinseishoBuilderImpl implements IKeidoshaFukushiYoguTaiyoKakuninShinseishoBuilder {

    private final IKeidoshaFukushiYoguTaiyoKakuninShinseishoEditor joho;

    /**
     * コンストラクタです。
     *
     * @param joho 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書情報
     */
    public KeidoshaFukushiYoguTaiyoKakuninShinseishoBuilderImpl(IKeidoshaFukushiYoguTaiyoKakuninShinseishoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource}
     */
    @Override
    public KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource build() {
        return ReportEditorJoiner.from(new KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource()).join(joho).buildSource();
    }
}
