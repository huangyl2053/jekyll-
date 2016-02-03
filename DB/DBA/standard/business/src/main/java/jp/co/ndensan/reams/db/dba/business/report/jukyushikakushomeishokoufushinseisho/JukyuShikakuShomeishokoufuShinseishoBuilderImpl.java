/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeishokoufushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.jukyushikakushomeishokoufushinseisho.JukyuShikakuShomeishokoufuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険受給資格証明書交付申請書のBuilderクラスです
 */
public final class JukyuShikakuShomeishokoufuShinseishoBuilderImpl implements IJukyuShikakuShomeishokoufuShinseishoBuilder {
    
    private final IJukyuShikakuShomeishokoufuShinseishoEditor joho;
    
    /**
     * コンストラクタです。
     * @param joho 介護保険受給資格証明書交付申請書のエディターインターフェース
     */
    public JukyuShikakuShomeishokoufuShinseishoBuilderImpl(IJukyuShikakuShomeishokoufuShinseishoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukiRendoTorokuListReportSource}
     */
    @Override
    public JukyuShikakuShomeishokoufuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new JukyuShikakuShomeishokoufuShinseishoReportSource()).join(joho).buildSource();
    }
    
}
