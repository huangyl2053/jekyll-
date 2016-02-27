/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyufuhikashitsukekinshokankigen;

import jp.co.ndensan.reams.db.dba.entity.report.kyufuhikashitsukekinshokankigen.KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 護保険給付費貸付金償還期限延長申請書Builderクラスです。
 *
 */
public class KyufuhiKashitsukekinShokankigenEnchoShinseishoBuilderImpl implements IKyufuhiKashitsukekinShokankigenEnchoShinseishoBuilder {

    private final IKyufuhiKashitsukekinShokankigenEnchoShinseishoEditor joho;

    /**
     * コンストラクタです。
     *
     * @param joho 護保険給付費貸付金償還期限延長申請書情報
     */
    public KyufuhiKashitsukekinShokankigenEnchoShinseishoBuilderImpl(IKyufuhiKashitsukekinShokankigenEnchoShinseishoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukiRendoTorokuListReportSource}
     */
    @Override
    public KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource build() {
        return ReportEditorJoiner.from(new KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource()).join(joho).buildSource();
    }
}
