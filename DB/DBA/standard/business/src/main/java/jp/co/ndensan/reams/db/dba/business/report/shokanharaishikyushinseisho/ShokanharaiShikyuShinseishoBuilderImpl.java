/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shokanharaishikyushinseisho;

import jp.co.ndensan.reams.db.dba.entity.report.shokanharaishikyushinseisho.ShokanharaiShikyuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険償還払支給申請書Builderクラスです。
 */
public final class ShokanharaiShikyuShinseishoBuilderImpl implements IShokanharaiShikyuShinseishoBuilder {

    private final IShokanharaiShikyuShinseishoEditor joho;

    /**
     * コンストラクタです。
     *
     * @param joho 介護保険償還払支給申請書ヘッダエディターのインターフェース
     */
    public ShokanharaiShikyuShinseishoBuilderImpl(IShokanharaiShikyuShinseishoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShokanharaiShikyuShinseishoReportSource}
     */
    @Override
    public ShokanharaiShikyuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new ShokanharaiShikyuShinseishoReportSource()).join(joho).buildSource();
    }

}
