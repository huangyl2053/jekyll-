/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufugengakumenjyoshinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.kyufugengakumenjyoshinseisho.KyufugengakuMenjyoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 給付額減額免除申請書Builderクラスです。
 */
public final class KyufugengakuMenjyoShinseishoBuilderImpl implements IKyufugengakuMenjyoShinseishoBuilder {

    private final IKyufugengakuMenjyoShinseishoEditor joho;

    /**
     * コンストラクタです。
     *
     * @param joho 給付額減額免除申請書ヘッダエディターのインターフェース
     */
    public KyufugengakuMenjyoShinseishoBuilderImpl(IKyufugengakuMenjyoShinseishoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufugengakuMenjyoShinseishoReportSource}
     */
    @Override
    public KyufugengakuMenjyoShinseishoReportSource build() {
        return ReportEditorJoiner.from(new KyufugengakuMenjyoShinseishoReportSource()).join(joho).buildSource();
    }

}
