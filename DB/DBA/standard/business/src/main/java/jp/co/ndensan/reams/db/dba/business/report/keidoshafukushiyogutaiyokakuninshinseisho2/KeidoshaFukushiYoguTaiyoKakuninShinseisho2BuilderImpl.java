/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho2;

import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho2.KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2Builderクラスです。
 *
 */
public class KeidoshaFukushiYoguTaiyoKakuninShinseisho2BuilderImpl implements IKeidoshaFukushiYoguTaiyoKakuninShinseisho2Builder {

    private final IKeidoshaFukushiYoguTaiyoKakuninShinseisho2Editor joho;

    /**
     * コンストラクタです。
     *
     * @param joho 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2情報
     */
    public KeidoshaFukushiYoguTaiyoKakuninShinseisho2BuilderImpl(IKeidoshaFukushiYoguTaiyoKakuninShinseisho2Editor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukiRendoTorokuListReportSource}
     */
    @Override
    public KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource build() {
        return ReportEditorJoiner.from(new KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource()).join(joho).buildSource();
    }
}
