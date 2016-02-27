/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nofugakushomeishokofushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.nofugakushomeishokofushinseisho.NofugakuShomeishoKofuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険料納付額証明書交付申請書Builderクラスです。
 */
public final class NofugakuShomeishoKofuShinseishoBuilderImpl implements INofugakuShomeishoKofuShinseishoBuilder {

    private final INofugakuShomeishoKofuShinseishoEditor joho;

    /**
     * コンストラクタです。
     *
     * @param joho 介護保険料納付額証明書交付申請書ヘッダエディターのインターフェース
     */
    public NofugakuShomeishoKofuShinseishoBuilderImpl(INofugakuShomeishoKofuShinseishoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link NofugakuShomeishoKofuShinseishoReportSource}
     */
    @Override
    public NofugakuShomeishoKofuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new NofugakuShomeishoKofuShinseishoReportSource()).join(joho).buildSource();
    }

}
