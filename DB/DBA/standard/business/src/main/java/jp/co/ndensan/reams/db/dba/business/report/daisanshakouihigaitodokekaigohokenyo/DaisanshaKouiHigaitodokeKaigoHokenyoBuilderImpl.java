/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.daisanshakouihigaitodokekaigohokenyo;

import jp.co.ndensan.reams.db.dba.entity.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 第三者行為による被害届（介護保険用）Builderクラスです
 */
public final class DaisanshaKouiHigaitodokeKaigoHokenyoBuilderImpl implements IDaisanshaKouiHigaitodokeKaigoHokenyoBuilder {

    private final IDaisanshaKouiHigaitodokeKaigoHokenyoEditor joho;

    /**
     * コンストラクタです。
     *
     * @param joho 第三者行為による被害届（介護保険用）ヘッダエディターのインターフェース
     */
    public DaisanshaKouiHigaitodokeKaigoHokenyoBuilderImpl(IDaisanshaKouiHigaitodokeKaigoHokenyoEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link DaisanshaKouiHigaitodokeKaigoHokenyoReportSource}
     */
    @Override
    public DaisanshaKouiHigaitodokeKaigoHokenyoReportSource build() {
        return ReportEditorJoiner.from(new DaisanshaKouiHigaitodokeKaigoHokenyoReportSource()).join(joho).buildSource();
    }

}
