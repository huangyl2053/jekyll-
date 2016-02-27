/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.juryoininharaikeiyakushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.juryoininharaikeiyakushinseisho.JuryoIninharaiKeiyakuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険受領委任払い契約申請書Builderクラスです
 */
public final class JuryoIninharaiKeiyakuShinseishoBuilderImpl implements IJuryoIninharaiKeiyakuShinseishoBuilder {
    
    private final IJuryoIninharaiKeiyakuShinseishoEditor joho;
    
    /**
     * コンストラクタです。
     * @param joho 介護保険受領委任払い契約申請書ヘッダエディターのインターフェース
     */
    public JuryoIninharaiKeiyakuShinseishoBuilderImpl(IJuryoIninharaiKeiyakuShinseishoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukiRendoTorokuListReportSource}
     */
    @Override
    public JuryoIninharaiKeiyakuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new JuryoIninharaiKeiyakuShinseishoReportSource()).join(joho).buildSource();
    }
    
}
